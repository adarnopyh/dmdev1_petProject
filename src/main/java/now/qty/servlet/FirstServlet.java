package now.qty.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import now.qty.dao.ClientDao;
import now.qty.dao.impl.ClientDaoImpl;
import now.qty.entity.ClientEntity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    private ClientDaoImpl clientDao;

    @Override
    public void init() throws ServletException {
        clientDao = ClientDaoImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        List<ClientEntity> clients = clientDao.findAll();

        try (var writer = resp.getWriter()) {
            writer.write("List of Clients: ");
            for (ClientEntity client : clients) {
                writer.write(client.toString());
            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
