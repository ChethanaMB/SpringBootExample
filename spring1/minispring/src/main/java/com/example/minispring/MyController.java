package com.example.minispring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    List<Employees> list = new ArrayList<>();
    
    @GetMapping("/hello")
    public String index(){
        return "Hey Chethana";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to my page";
    }

    @PostMapping("/addDetails")
    public response addP(@RequestBody Employees p) {
        list.add(p);
        return new response("200", "Successful",(Object) p);
    }

    @GetMapping("/getDetails")
    public response getDetails() {
        return new response("200", "Participants Fetched successfully", (Object)list);
    }

    @GetMapping("sort")
    public List<Employees> sortedList(){
        list.sort((a,b) -> {
            if(a.id > b.id){
                return -1;
            }
            return 0; 
        });
        return list;
    }

    @GetMapping("/delete/{id}")
    public List<Employees> delete(@PathVariable int id){
        for(Employees c:list){
            if(c.id== id){
                list.remove(c);   
            }
        }
        return list;
    }

    @GetMapping("/getById/{id}")
    public List<Employees> getemp(@PathVariable int id){
        for(Employees c:list){
            if(c.id == (id)){
                list.add(c);
                return list;
            }
        }
        return null;
    }

    @GetMapping("/product/{a}/{b}/{c}")
    public String Product(@PathVariable int a, @PathVariable int b, @PathVariable int c){
        return "Product is="+(a*b*c);
    }
}
