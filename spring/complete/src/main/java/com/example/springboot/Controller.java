package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.net.URI;



@RestController
public class Controller {

	@RequestMapping("https://api.sec.or.th/FundFactsheet/fund/amc")
	public String index() {
		HttpClient httpclient = HttpClients.createDefault();

        try
        {
            URIBuilder builder = new URIBuilder("https://api.sec.or.th/FundFactsheet/fund/{IPO}/URLs");


            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", "{6d958a6654e74c08aee48a6b623fc07f}");


            // Request body
            StringEntity reqEntity = new StringEntity("
            {startSellDate: “1900-06-03T17:00:00.000Z”, endSellDate: “1900-06-03T17:00:00.000Z”, 
            } 
				
			");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) 
            {
                System.out.println(EntityUtils.toString(entity));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    

	
	}

}
