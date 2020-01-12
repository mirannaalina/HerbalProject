package ro.herb.herbalproject.controller.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.herb.herbalproject.persistence.data.DataEntity;
import ro.herb.herbalproject.service.data.DataService;

import java.util.List;

@Controller
@RequestMapping("herbal")
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("home")
    public ModelAndView All(){
        //all input from user that was login
        //modelandview type
        List<DataEntity> allData = dataService.findAll();
        ModelAndView modelAndView =  new ModelAndView();
        modelAndView.setViewName("list.html");
        modelAndView.addObject("datas",allData);
        return modelAndView;

    }

    @PostMapping("save")
    //after pressing the button ("entry new data")
    public void save(@RequestBody DataSaveBody dataSaveBody){
        dataService.save(dataSaveBody.getDate(),dataSaveBody.getKg(),dataSaveBody.getBodyfat());
    }


}
