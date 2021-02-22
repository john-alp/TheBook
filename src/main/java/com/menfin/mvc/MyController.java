package com.menfin.mvc;

import com.menfin.Config;
import com.menfin.dao.ObjDao;
import com.menfin.entity.Book;
import com.menfin.service.ServiceDB;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("/go")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

//    @RequestMapping("/askDetails")
//    public String askEmployeeDetails(Model model) {
//        model.addAttribute("friend", new Friend());
//        return "ask-emp-details-view";
//       // return "ask-book-details-view";
//    }

//    @RequestMapping("/askDetails")
//    public String askEmployeeDetails2(Model model) {
//        System.out.println("I am askDetails");
//        model.addAttribute("addBookAttribute", new Book());
//        return "ask-book-details-view";
//    }
    @RequestMapping("/askDetails")
    public String askSelectAction(Model model) {
        System.out.println("I am askAction");
        model.addAttribute("selectBook", new Book());
        return "ask-book-select-view";
    }

    public String showSelectBook(HttpServletRequest request, Model model) {
        return "show-emp-details-view";
    }

    @RequestMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("friend") com.menfin.mvc.Friend employee
            , BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        } else {
            return "show-emp-details-view";
        }
    }

    @RequestMapping("/addBook")
    public String showAddBook(HttpServletRequest request, Model model) {
        ObjDao<Book> objDao = new ServiceDB(new Config());
        Book book = new Book();

        book.setAuthor(request.getParameter("author"));
        book.setBookName(request.getParameter("bookName"));
        book.setRating(Integer.parseInt(request.getParameter("rating")));
        System.out.println("book to DB " + book);
         objDao.saveBook(book);

        model.addAttribute("list", objDao.getAllBooks());

    //    model.addAllAttributes(objDao.getAllBooks());

        System.out.println("May!!!!");


        return "show-emp-details-view";

//        if(bindingResult.hasErrors()) {
//            return "ask-emp-details-view";
//        } else {
//            return "show-emp-details-view";
//        }
    }
}
