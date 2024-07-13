package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.CarsDao;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private CarsDao carsDao;

    public CarsController(CarsDao carsDao) {
        this.carsDao = carsDao;
    }

    @GetMapping
    public String getBy(HttpServletRequest request, Model model) {
        if (request.getParameter("count") == null) {
            model.addAttribute("carsBy", carsDao.getAll());
        } else {
            int quantity = Integer.parseInt(request.getParameter("count"));
            model.addAttribute("carsBy", carsDao.getBy(quantity));
        }
        return "cars/getBy";
    }
}
