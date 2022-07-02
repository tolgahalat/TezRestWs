/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tolga.tezrestws.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.simple.JSONObject;

/**
 *
 * @author Tolga
 */
public class TezUtil {

    public static JSONObject getById(String id) {
        JSONObject mukellefJSON = new JSONObject();
        JSONObject adresJSON = new JSONObject();

        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select * from public.\"TezMukellef\" where \"Id\" = " + id);
            while (rs.next()) {
                mukellefJSON.put("Id", (rs.getInt("Id")));
                mukellefJSON.put("Ad", (rs.getString("Ad")));
                mukellefJSON.put("Soyad", (rs.getString("Soyad")));
                mukellefJSON.put("Tckn", (rs.getString("Tckn")));
                mukellefJSON.put("Vkn", (rs.getString("Vkn")));
                mukellefJSON.put("VdKodu", (rs.getString("VdKodu")));
                mukellefJSON.put("DogumYeri", (rs.getString("DogumYeri")));
                mukellefJSON.put("IsYeriTuru", (rs.getString("IsYeriTuru")));
                mukellefJSON.put("BabaAdi", (rs.getString("BabaAdi")));
                mukellefJSON.put("AnneAdi", (rs.getString("AnneAdi")));
                mukellefJSON.put("IseBaslamaTarihi", (rs.getString("IseBaslamaTarihi")));
                mukellefJSON.put("IsiBirakmaTarihi", (rs.getString("IsıBirakmaTarihi")));
                mukellefJSON.put("DogumTarihi", (rs.getString("DogumTarihi")));
                mukellefJSON.put("Unvan", (rs.getString("Unvan")));
                mukellefJSON.put("VdAdi", (rs.getString("VdAdi")));

                adresJSON.put("Il", (rs.getString("AdresIl")));
                adresJSON.put("Ilce", (rs.getString("AdresIlce")));
                adresJSON.put("Mahalle", (rs.getString("AdresMah")));
                adresJSON.put("CaddeSokak", (rs.getString("AdresCaddeSokak")));

                mukellefJSON.put("Adres", adresJSON);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return mukellefJSON;
    }
}
