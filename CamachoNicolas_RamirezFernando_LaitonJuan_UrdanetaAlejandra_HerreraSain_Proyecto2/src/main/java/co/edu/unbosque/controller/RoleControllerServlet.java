package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.PrintWriter;

import co.edu.unbosque.model.AlcoholicDTO;
import co.edu.unbosque.model.persistence.AlcoholicDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RoleControllerServlet extends HttpServlet {

	private static final long serialVersionUID = -3725620046939664619L;

	

	public RoleControllerServlet() {
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rolSeleccionado = request.getParameter("role");
        RequestDispatcher dispatcher;

        if("administrador".equals(rolSeleccionado)) {
            // Código para manejar el rol de administrador
            dispatcher = request.getRequestDispatcher("administrador.jsp");
        } else if("psicologo".equals(rolSeleccionado)) {
            // Código para manejar el rol de psicólogo
            dispatcher = request.getRequestDispatcher("psicologo.jsp");
        } else if("alcoholico".equals(rolSeleccionado)) {
            // Código para manejar el rol de alcohólico
            dispatcher = request.getRequestDispatcher("alcoholico.jsp");
        } else if("persona_de_servicio".equals(rolSeleccionado)) {
            // Código para manejar el rol de persona de servicio
            dispatcher = request.getRequestDispatcher("persona_de_servicio.jsp");
        } else {
            // En caso de que no se seleccione ningún rol válido
            dispatcher = request.getRequestDispatcher("error.jsp");
        }
        
        dispatcher.forward(request, response);
    }

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

	@Override
	protected void doHead(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doHead(arg0, arg1);
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(req, resp);
	}

	@Override
	protected void doTrace(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doTrace(arg0, arg1);
	}
}