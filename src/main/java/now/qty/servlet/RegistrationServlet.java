package now.qty.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import now.qty.dto.CreateUserDto;
import now.qty.service.UserService;
import now.qty.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("roles", List.of("ADMIN", "GUEST"));

        request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var name = request.getParameter("username");
        var userDto = CreateUserDto.builder()
                .username(request.getParameter("username"))
                .password(request.getParameter("password"))
                .email(request.getParameter("email"))
                .role(request.getParameter("role"))
                .build();


        var savedUser = userService.create(userDto);

        if (savedUser != null) {
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Registration failed");
            request.setAttribute("roles", List.of("ADMIN", "GUEST"));
            request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
        }
    }
}
