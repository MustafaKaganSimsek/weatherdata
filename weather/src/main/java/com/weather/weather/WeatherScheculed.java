package com.weather.weather;

import com.weather.weather.dao.GridPointRepository;
import com.weather.weather.dao.WeatherRepository;
import com.weather.weather.model.GeoCode;
import com.weather.weather.model.GridPoints;
import com.weather.weather.model.Weather;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class WeatherScheculed {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final WeatherRepository weatherRepository;
    private final GridPointRepository gridPointRepository;

    private boolean flag = true;
    private HashMap<String,String> latitudedata = new HashMap<String, String>();
    private HashMap<String,String> longitudedata = new HashMap<String, String>();
    private HashMap<String,String> statedata = new HashMap<String, String>();

    private HashMap<String,String> cityNames= new HashMap<String, String>();





    List<String> cityCode = Arrays.asList("HNX/64,99","SJT/90,34","OKX/35,35","TBW/97,101",
            "ILX/69,65","CTP/88,77","ILN/82,99","APX/67,21","GSP/117,89","PHI/60,71");

    @Scheduled(fixedRate = 180000)
    //@Scheduled(cron = "0 0 0 * * *")
    //0 0 0 * * * burası saat 12 için
    public void scheculedGridPoints() {
//        if (flag)
//            getCityNames();
        for(String code:cityCode) {

            String[] split = code.split("/");
            String codeCity = split[0];
            try {
                RestTemplate restTemplate = new RestTemplate();
                Map<String, Object> forObject = restTemplate.getForObject(
                        "https://api.weather.gov/gridpoints/" + code + "/forecast", Map.class);
                Map<String, Object> properties = (Map<String, Object>) forObject.get("properties");
                List<Map<String, Object>> periods = (List<Map<String, Object>>) properties.get("periods");
                for (Map<String, Object> o : periods) {
                    GridPoints gridPoints = new GridPoints();
                    gridPoints.setEndTime(o.get("endTime").toString());
                    gridPoints.setShortForecast(o.get("shortForecast").toString());
                    gridPoints.setDetailedForecast(o.get("detailedForecast").toString());
                    gridPoints.setStartDay(o.get("startTime").toString().substring(0,10));
                    gridPoints.setStartHours(o.get("startTime").toString().substring(11));
                    gridPoints.setTemperature(o.get("temperature").toString());
                    gridPoints.setTemperatureUnit(o.get("temperatureUnit").toString());
                    gridPoints.setCityCode(codeCity);
                    gridPointRepository.save(gridPoints);
                }
            }
            catch (HttpServerErrorException.InternalServerError e){
                e.printStackTrace();
            }


        }

    }

    @Scheduled(fixedRate = 180000)
    public void scheduleFixedRateTask() {
        if (flag)
            loadCoordinates();
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> forObject = restTemplate.getForObject("https://api.weather.gov/alerts/active", Map.class);

        List<Weather> weathers = new ArrayList<>();
        List<Map<String, Object>> features = (List<Map<String, Object>>) forObject.get("features");

        for (Map<String, Object> o : features) {
            Map<String, Object> properties = (Map<String, Object>) o.get("properties");
            Weather weather = new Weather();

            weather.setId(properties.get("id") != null ? (properties.get("id").toString()).substring(0,properties.get("id").toString().length()-6) : "");
            weather.setSent(properties.get("sent").toString());
            //weather.setDescription(properties.get("description").toString());
            //weather.setAreaDesc(properties.get("areaDesc").toString());
            weather.setEffective(properties.get("effective").toString());
            weather.setEvent(properties.get("event").toString());
            weather.setExpires(properties.get("expires").toString());
            weather.setHeadline(properties.get("headline") != null ? properties.get("headline").toString() : "");
            ///weather.setInstruction(properties.get("instruction") != null ? properties.get("instruction").toString() : "");
            weather.setZoneId(weather.getHeadline().length() >2 ? weather.getHeadline().substring((weather.getHeadline().length())-2).toUpperCase():"");
            weather.setLatitude(getLatitude(weather.getZoneId()) != null ? getLatitude(weather.getZoneId()):"s");
            weather.setLongitude(getLongitude(weather.getZoneId()) != null ? getLongitude(weather.getZoneId()):"s");
            weather.setState(getState(weather.getZoneId()) != null ? getState(weather.getZoneId()):"s");
            Map<String, Object> geocode = (Map<String, Object>) properties.get("geocode");
            List<String> same = (List<String>) geocode.get("SAME  ");
            List<String> ugc = (List<String>) geocode.get("UGC");
            GeoCode geoCode = new GeoCode();
            geoCode.setSAME(same);
            geoCode.setUGC(ugc);
            weather.setGeocode(geoCode);
            //kafkaTemplate.send("weathertopic", weather);
            //weathers.add(weather);
            weatherRepository.save(weather);

        }
    }

    public String getLatitude(String zoneId){


            return latitudedata.get(zoneId) !=null ? latitudedata.get(zoneId) :"#" ;


    }

    public void setLatitude(JSONObject coordinates){
        String zoneId = coordinates.get("zoneId").toString();
        String latitude = coordinates.get("latitude").toString();
        latitudedata.put(zoneId,latitude);


    }
    public String getLongitude(String zoneId){

            return longitudedata.get(zoneId) !=null ? longitudedata.get(zoneId):"#";


    }
    public void setLongitude(JSONObject coordinates){
        String zoneId = coordinates.get("zoneId").toString();
        String longitude = coordinates.get("longitude").toString();
        longitudedata.put(zoneId,longitude);

    }

    public String getState(String zoneId){
        return statedata.get(zoneId) !=null ? statedata.get(zoneId):"#";
    }

    public void setState(JSONObject coordinates){

        statedata.put(coordinates.get("zoneId").toString(),coordinates.get("state").toString());

    }
//    public String getCity(String cityCode){
//        return cityNames.get(cityCode) ;
//    }
//
//    public void setCity(JSONObject cityCodes){
//
//        cityNames.put(cityCodes.get("cityCode").toString(),cityCodes.get("cityNames").toString());
//
//    }

    public void loadCoordinates(){
        flag = false;
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("StateCoordinates.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray Coordinates = (JSONArray) obj;
            System.out.println(Coordinates);

            Coordinates.forEach(coor ->setLatitude((JSONObject) coor));
            Coordinates.forEach(coor ->setLongitude((JSONObject) coor));
            Coordinates.forEach(coor ->setState((JSONObject) coor));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        flag = false;
    }

//    public void getCityNames(){
//        flag = false;
//        JSONParser jsonParser = new JSONParser();
//
//        try (FileReader reader = new FileReader("CityCodeNames.json"))
//        {
//            //Read JSON file
//            Object obj = jsonParser.parse(reader);
//
//            JSONArray cityCodeNames = (JSONArray) obj;
//            System.out.println(cityCodeNames);
//
//            cityCodeNames.forEach(c-> setCity((JSONObject) c));
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        flag = false;
//    }


    /*@KafkaListener(topics = "weathertopic",
            groupId = "1")
    public void consume(Weather weather) {
        weatherRepository.save(weather);
    }*/
}
