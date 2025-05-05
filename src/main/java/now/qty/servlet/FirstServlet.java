package now.qty.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import now.qty.dto.ClientDto;
import now.qty.service.impl.ClientServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/clients")
public class FirstServlet extends HttpServlet {

    private ClientServiceImpl clientService;

    @Override
    public void init() throws ServletException {
        clientService = ClientServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        List<ClientDto> clients = clientService.findAll();

        request.setAttribute("clients", clients);
        request.getRequestDispatcher("/WEB-INF/views/clients.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
