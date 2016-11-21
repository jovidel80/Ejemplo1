package com.joseoliveros.aplicacion;

import com.joseoliveros.Libro;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ControladorLibros extends HttpServlet {

    private static final long serialVersionUID = -2978402334741404345L;

    private static final Logger log = Logger.getLogger(ControladorLibros.class.getPackage().getName());

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher despachador = null;
        
        if (request.getServletPath().equals("/MostrarLibros.do")) {
            PrintWriter writer = response.getWriter();
            writer.println("si esta enviando");
            writer.println(request.getServletPath());
            List<Libro> listaDeLibros = Libro.buscarTodos();
            List<String> listaDeCategorias = Libro.buscarTodasLasCategoria();
            writer.println(listaDeLibros);
            writer.println(listaDeCategorias);
            request.setAttribute("listaDeLibros", listaDeLibros);
            request.setAttribute("listaDeCategorias", listaDeCategorias);
            
            despachador = request.getRequestDispatcher("MostrarLibros.jsp");
            
        } else if (request.getServletPath().equals("/FormularioInsertarLibro.do")) {
            List<String> listaDeCategorias = Libro.buscarTodasLasCategoria();
            request.setAttribute("listaDeCategorias", listaDeCategorias);
            
            despachador = request.getRequestDispatcher("FormularioInsertarLibro.jsp");

        } else if (request.getServletPath().equals("/InsertarLibro.do")) {
            String isbn = request.getParameter("isbn");
            String titulo = request.getParameter("titulo");
            String categoria = request.getParameter("categoria");
            Libro libro = new Libro(isbn, titulo, categoria);
            libro.insertar();
            
            despachador = request.getRequestDispatcher("MostrarLibros.do");

        } else if (request.getServletPath().equals("/BorrarLibro.do")) {
            String isbn = request.getParameter("isbn");
            Libro libro = new Libro(isbn);
            libro.borrar();

            despachador = request.getRequestDispatcher("MostrarLibros.do");
            
        } else if (request.getServletPath().equals("/FormularioEditarLibro.do")) {
            String isbn = request.getParameter("isbn");
            List<String> listaDeCategorias = Libro.buscarTodasLasCategoria();
            Libro libro = Libro.buscarPorClave(isbn);
            request.setAttribute("listaDeCategorias", listaDeCategorias);
            request.setAttribute("libro", libro);
            despachador = request.getRequestDispatcher("FormularioEditarLibro.jsp");
            
        } else if (request.getServletPath().equals("/SalvarLibro.do")) {
            String isbn = request.getParameter("isbn");
            String titulo = request.getParameter("titulo");
            String categoria = request.getParameter("categoria");
            Libro libro = new Libro(isbn, titulo, categoria);
            libro.salvar();
            
            despachador = request.getRequestDispatcher("/MostrarLibros.do");
            
        } else if (request.getServletPath().equals("/filtrar.do")) {
            List<Libro> listaDeLibros = null;
            List<String> listaDeCategorias = Libro.buscarTodasLasCategoria();
            if (request.getParameter("categoria") == null ||
                    request.getParameter("categoria").equals("seleccionar")) {
                listaDeLibros = Libro.buscarTodos();
            } else {
                listaDeLibros = Libro.buscarPorCategoria(request
                        .getParameter("categoria"));
            }
            
            request.setAttribute("listaDeLibros", listaDeLibros);
            request.setAttribute("listaDeCategorias", listaDeCategorias);
            despachador = request.getRequestDispatcher("MostrarLibros.jsp");
        }
        despachador.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
