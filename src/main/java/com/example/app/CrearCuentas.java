package com.example.app;


import com.example.dao.Dao;
import com.example.dao.ImplDao;
import com.example.hibernate.HibernateUtil;
import com.example.modelo.Clients;
import com.example.modelo.Comptes;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/Create.do")
public class CrearCuentas extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion.equals("crear")){
            int condicion = 0;
            String dni = req.getParameter("idFiscal");
            String nombre = req.getParameter("clienteNombre");
            String email = req.getParameter("clienteEmail");
            String pais = req.getParameter("clientePais");
            String cuenta = req.getParameter("clienteCuenta");
            String ingresoString = req.getParameter("clienteIngreso");
            int ingreso = Integer.parseInt(ingresoString);

            Clients clienteExistente = null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();
                clienteExistente = session.get(Clients.class, dni);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }

            if (clienteExistente == null){
                clienteExistente = new Clients(dni, nombre, email, pais);
                condicion++;
            }

            Comptes comptes = new Comptes(cuenta, ingreso, clienteExistente);
            clienteExistente.getCompteByIdCompte().add(comptes);
            System.out.println(clienteExistente.toString());
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = null;
            try {
                transaction = session.beginTransaction();
                session.merge(clienteExistente);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }

            resp.setContentType("text/plain");
            PrintWriter out = resp.getWriter();
            if (condicion == 0){
                out.println("nueva cuenta " + nombre);
            } else{
                out.println("Usuario " + nombre + " creado");
            }

            out.close();
        }
        else if (accion.equals("mostrar")){
            List<Clients> clients;
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();

            Dao dao = new ImplDao(HibernateUtil.getSessionFactory());

            clients = dao.getAll();

            out.println("<html>");
            out.println("<body>");
            out.println("<h1>Cuentas de los clientes</h1>");
            out.println("<table>");
            out.println("<tr><th>Nombre</th><th>DNI</th></tr>");

            for(Clients client : clients) {
                out.println("<tr>");
                out.println("<td>" + client.getNombre() + "</td>");
                out.println("<td>" + client.getDni() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</html>");
            out.println("</body>");
        }
    }
}