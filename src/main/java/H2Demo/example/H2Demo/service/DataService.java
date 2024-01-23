package H2Demo.example.H2Demo.service;

import H2Demo.example.H2Demo.Entities.AppData;
import H2Demo.example.H2Demo.repo.H2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@EnableScheduling
public class DataService {

    private final String apiUrl = "http://localhost:8080/api/getInformation";


    @Autowired
    private H2Repository mySQLRepository;


    //    @Scheduled(fixedDelay = 900000)
    public void fetchDataAndSaveToMysql() {
        WebClient webClient = WebClient.create();
        List<AppData> apiDataList = webClient.post()
                .uri(apiUrl)
                .retrieve()
                .bodyToFlux(AppData.class)
                .collectList()
                .block();

        if (apiDataList != null) {
            mySQLRepository.saveAll(apiDataList);
        }
    }

    public List<AppData> fetchDataFromMysql(){
        return  mySQLRepository.findAll();
    }

}

