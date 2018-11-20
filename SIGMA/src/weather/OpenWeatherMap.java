/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author ramires
 */
public class OpenWeatherMap {
    private String LOCATION;
    private Map<String,Object> respMap, windMap, mainMap;

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }
    
    public String getTemperatura(){
        return mainMap.get("temp").toString();
    }
    
    public String getWindSpeed(){
        return windMap.get("speed").toString();
    }
    
    public String getUmidade(){
        return mainMap.get("humidity").toString();
    }
    
    
    public static Map<String, Object> jsonToMap(String str){
        Map<String, Object> map = new Gson().fromJson(
            str, new TypeToken<HashMap<String,Object>>() {}.getType());
        return map;
    }
    
    public void getWeather(){
        String API_KEY = "a5d2f582295feef4af7b2b24bbac4efa";
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION +",BR" + "&appid=" + API_KEY + "&units=metric";
        
        try{
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection con = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            
            String line;
            
            while ((line = rd.readLine()) != null){
                result.append(line);
            }
            
            rd.close();
            
            respMap = jsonToMap(result.toString());
            
            
            mainMap = jsonToMap(respMap.get("main").toString());
            windMap = jsonToMap(respMap.get("wind").toString());
            
        }
        
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Erro na Previsão do Tempo! ");
        }
        
    }
}
