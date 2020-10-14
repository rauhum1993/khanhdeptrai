package controller;

import bo.CustomerBO;
import bo.CustomerBOImpl;
import bo.GenderBO;
import bo.GenderBOImpl;
import commom.Validate;
import model.Customer;
import model.GenderCustomer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerBO customerBO = new CustomerBOImpl();
    GenderBO genderBO = new GenderBOImpl();

    // Set invalid message
    private static final String ID_INVALID = "The ID must be as format 'KH-XXXX'";
    private static final String NAME_INVALID = "The name not valid";
    private static final String BIRTHDAY_INVALID = "The birthday must made the age not less than 18";
    private static final String CARD_ID_INVALID = "The ID card number is not valid";
    private static final String EMAIL_INVALID = "The email is not valid";
    private static final String PHONE_INVALID = "The phone number must have 10 or 11 digits";
    private static final String INTEGER_INVALID = "The number is not valid";
    private static final String DOUBLE_INVALID = "The number is not valid";
    private static final String NOTIFICATION = "successfully added";
    private static final String NOTIFICATION2 = "Update successful";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "editModal":
                updateModalCustomer(request, response);
                break;
            case "delete":
                deleteCutomer(request, response);
                break;
        }
    }

    private void updateModalCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String typeId = request.getParameter("typeId");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthDay");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address);

        customerBO.update(customer);

        List<Customer> customerList = this.customerBO.showListCustomer();
        List<GenderCustomer> genderCustomerList = this.genderBO.findAllGenderCustomer();
        request.setAttribute("genderCustomerList", genderCustomerList);
        request.setAttribute("list", customerList);
        request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String typeId = request.getParameter("typeId");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address);

        boolean check = true;
        if (!Validate.checkCode(String.valueOf(id))) {
            request.setAttribute("messageID", ID_INVALID);
            check = false;
        }
        if (!Validate.checkInteger(String.valueOf(typeId))) {
            request.setAttribute("messageTypeID", INTEGER_INVALID);
            check = false;
        }
        if (!Validate.checkPhoneNumber(phone)) {
            request.setAttribute("messagePhone", PHONE_INVALID);
            check = false;
        }
        if (!Validate.checkBirthday(birthday)) {
            request.setAttribute("messageBirthday", BIRTHDAY_INVALID);
            check = false;
        }
        if (!Validate.checkEmail(email)) {
            request.setAttribute("messageEmail", EMAIL_INVALID);
            check = false;
        }
        if (!Validate.checkIdCard(idCard)) {
            request.setAttribute("messageIDCard", CARD_ID_INVALID);
            check = false;
        }
        if (check) {
            try {
                customerBO.insert(customer);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            List<Customer> customerList = this.customerBO.showListCustomer();
            request.setAttribute("list", customerList);
            request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
            request.setAttribute("notification", NOTIFICATION);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/list.jsp");
            dispatcher.forward(request, response);
        } else {
            List<GenderCustomer> genderCustomerList = this.genderBO.findAllGenderCustomer();
            request.setAttribute("genderCustomerList", genderCustomerList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/create.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String typeId = request.getParameter("typeId");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address);
        boolean check = true;
        if (!Validate.checkCode(String.valueOf(id))) {
            request.setAttribute("messageID", ID_INVALID);
            check = false;
        }
        if (!Validate.checkInteger(String.valueOf(typeId))) {
            request.setAttribute("messageTypeID", INTEGER_INVALID);
            check = false;
        }
        if (!Validate.checkPhoneNumber(phone)) {
            request.setAttribute("messagePhone", PHONE_INVALID);
            check = false;
        }
//        if (!Validate.checkBirthday(birthday)){
//            request.setAttribute("messageBirthday",BIRTHDAY_INVALID);
//            check=false;
//        }
        if (!Validate.checkEmail(email)) {
            request.setAttribute("messageEmail", EMAIL_INVALID);
            check = false;
        }
        if (!Validate.checkIdCard(idCard)) {
            request.setAttribute("messageIDCard", CARD_ID_INVALID);
            check = false;
        }
        if (check) {
            customerBO.update(customer);
            List<Customer> customerList = this.customerBO.showListCustomer();
            request.setAttribute("notification", NOTIFICATION2);
            request.setAttribute("list", customerList);
            request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
        } else {
            List<GenderCustomer> genderCustomerList = this.genderBO.findAllGenderCustomer();
            request.setAttribute("genderCustomerList", genderCustomerList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/edit.jsp");
            dispatcher.forward(request, response);
        }


    }

    private void deleteCutomer(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateCustomer(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "search":
                searchByName(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GenderCustomer> genderCustomerList = this.genderBO.findAllGenderCustomer();
        request.setAttribute("genderCustomerList", genderCustomerList);
        request.getRequestDispatcher("/view/customer/create.jsp").forward(request, response);
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Customer customer = this.customerBO.findByID(id);
        request.setAttribute("customer", customer);
        List<GenderCustomer> genderCustomerList = this.genderBO.findAllGenderCustomer();
        request.setAttribute("genderCustomerList", genderCustomerList);
        request.getRequestDispatcher("/view/customer/edit.jsp").forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idStudentHidden");
        customerBO.delete(id);

        List<Customer> customerList = this.customerBO.showListCustomer();
        request.setAttribute("list", customerList);
        request.setAttribute("message", "Delete a user with id=  " + id);
        request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<Customer> customerList = this.customerBO.searchByName(name);
        request.setAttribute("list", customerList);
        request.setAttribute("message", "Search user with country = " + name);
        request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = this.customerBO.showListCustomer();
        List<GenderCustomer> genderCustomerList = this.genderBO.findAllGenderCustomer();
        request.setAttribute("genderCustomerList", genderCustomerList);
        request.setAttribute("list", customerList);
        request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
    }
}
