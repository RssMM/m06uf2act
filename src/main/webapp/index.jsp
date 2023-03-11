<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<style>
    form {
        margin: 0 auto;
        width: 90%;
    }

    h1 {
        text-align: center;
    }

    table, th, td {
        border: 1px solid black;
    }

    input {
        width: 50%;
    }
    th {
        width: 200px;
    }

    td {
        width: 800px;
        text-align: start;
        padding: 4px;
    }
</style>

<head>
    <title>Banco DAM2</title>
</head>

<body>
<h1>Banco DAM2</h1>
<br/>
<form id="form" action="Create.do" method="POST">
    <table style="align-content: center">
        <tr>
            <th>
                <label for="clienteNombre">Nombre Cliente</label>
            </th>
            <td>
                <input type="text" id="clienteNombre" name="clienteNombre">
            </td>
        </tr>
        <tr>
            <th>
                <label for="idFiscal">Id Fiscal (DNI, NIE)</label>
            </th>
            <td>
                <input type="text" id="idFiscal" name="idFiscal" maxlength="9">
            </td>
        </tr>
        <tr>
            <th>
                <label for="clienteEmail">Email Cliente</label>
            </th>
            <td>
                <input type="email" id="clienteEmail" name="clienteEmail">
            </td>
        </tr>
        <tr>
            <th>
                <label for="clientePais">Pais</label>
            </th>
            <td>
                <input type="text" id="clientePais" name="clientePais">
            </td>
        </tr>
        <tr>
            <th>
                <label for="clienteCuenta">Cuenta</label>
            </th>
            <td>
                <input type="text" id="clienteCuenta" name="clienteCuenta">
            </td>
        </tr>
        <tr>
            <th>
                <label for="clienteIngreso">Ingreso inicial (€)</label>
            </th>
            <td>
                <input type="number" id="clienteIngreso" name="clienteIngreso">
            </td>
        </tr>
        <tr>
            <td style="text-align: center" colspan="2">
                <button type="submit" form="form" value="crear" name="accion">Crear cliente</button>
            </td>
        </tr>
        <tr>
            <td style="text-align: center" colspan="2">
                <button type="submit" form="form" value="mostrar" name="accion">Mostrar clientes</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>