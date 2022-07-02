/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tolga.tezrestws.webservice;

import java.net.URLDecoder;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestParam;
import tolga.tezrestws.util.TezUtil;

/**
 *
 * @author Tolga
 */
@Path("/")
public class TolgaWs {
  
    @GET
    @Path("/test")
    public String Test(@QueryParam("param") String param) {
        return "Servise gelen parametre: " + param;
    }
    
    @POST
    @Path("/getById")
    @Consumes(MediaType.APPLICATION_JSON)
    public String getById(@RequestParam("bodyParam") String bodyParam) throws ParseException {
        JSONObject inJSON = new JSONObject();
        JSONParser parser = new JSONParser();
        
        inJSON = (JSONObject) parser.parse(URLDecoder.decode(bodyParam));
        
        JSONObject sonuc = TezUtil.getById(inJSON.get("id").toString());
        
        return sonuc.toJSONString();
    }
}
