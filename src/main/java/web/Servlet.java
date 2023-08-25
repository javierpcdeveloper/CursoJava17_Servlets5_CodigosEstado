package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/ServletCodigosEstado")
public class Servlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
        res.setContentType("text/html;charset=UTF-8");
        String usuarioOk="juan";
        String claveOk="1234";
        String usuario=req.getParameter("usuario");
        String clave=req.getParameter("clave");
        PrintWriter out=res.getWriter();
        if(usuarioOk.equals(usuario) && claveOk.equals(clave)){
            out.print("<h1>Autenticación correcta</h1><br>");
            out.print("Usuario:"+usuario+"<br>");
            out.print("Contraseña:"+clave);
        }else{
            res.sendError(res.SC_UNAUTHORIZED,"Las credenciales no son válidas");
        }
    }
}

