package com.joseoliveros.aplicacion;

import com.joseoliveros.Libro;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ControladorLibros extends HttpServlet {

    private static final long serialVersionUID = -2978402334741404345L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachador = null;
        if (request.getServletPath().equals("/MostrarLibros.do")) {
            List<Libro> listaDeLibros = Libro.buscarTodos();
            List<String> listaDeCategorias = Libro.buscarTodasLasCategoria();
            request.setAttribute("listaDeLibros", listaDeLibros);
            request.setAttribute("listaDeCategorias", listaDeCategorias);
            request.getRequestDispatcher("MostrarLibros.jsp").forward(request, response);
        } else if (request.getServletPath().equals("/FormularioInsertarLibro.do")) {
            List<String> listaDeCategorias = Libro.buscarTodasLasCategoria();
            request.setAttribute("listaDeCategorias", listaDeCategorias);
            request.getRequestDispatcher("FormularioInsertarLibro.jsp").forward(request, response);
        } else if (request.getServletPath().equals("/FormularioEditarLibro.do")) {
            String isbn = request.getParameter("isbn");
            List<String> listaDeCategorias = Libro.buscarTodasLasCategoria();
            Libro libro = Libro.buscarPorClave(isbn);
            request.setAttribute("listaDeCategorias", listaDeCategorias);
            request.setAttribute("libro", libro);
            request.getRequestDispatcher("FormularioEditarLibro.jsp").forward(request, response);
        } else if (request.getServletPath().equals("/BorrarLibro.do")) {
            String isbn = request.getParameter("isbn");
            Libro libro = new Libro(isbn);
            libro.borrar();
            request.getRequestDispatcher("/MostrarLibros.do").forward(request, response);
        } else if (request.getServletPath().equals("/SalvarLibro.do")) {
            String isbn = request.getParameter("isbn");
            String titulo = request.getParameter("titulo");
            String categoria = request.getParameter("categoria");
            Libro libro = new Libro(isbn, titulo, categoria);
            libro.salvar();
            request.getRequestDispatcher("MostrarLibros.do").forward(request, response);
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
            request.getRequestDispatcher("MostrarLibros.do").forward(request, response);
        }

//        List<Libro> listaDeLibrosdd = Libro.buscarTodos();
//        List<String> listaDeCategorias = Libro.buscarTodasLasCategoria();
//        System.out.println(listaDeCategorias);
//        request.setAttribute("listaDeLibros", listaDeLibros);
//        request.setAttribute("listaDeCategorias", listaDeCategorias);
//        despachador = request.getRequestDispatcher("MostrarLibros.jsp");
//        despachador.forward(request, response);
    }
}
