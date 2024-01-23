package H2Demo.example.H2Demo.controller;


import H2Demo.example.H2Demo.Entities.AppData;
import H2Demo.example.H2Demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class H2Controller {
    @Autowired
    DataService dataService;

    @GetMapping("/saveInformation")
    public void saveInformation(){
        dataService.fetchDataAndSaveToMysql();
    }

    @PostMapping("/getInformation")
    public ResponseEntity<List<AppData>> getInformation(){
        List<AppData> send = dataService.fetchDataFromMysql();
        return new ResponseEntity<>(send, HttpStatus.OK);
    }
}