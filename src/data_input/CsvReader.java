package data_input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.String;
import java.util.Date;

public class CsvReader {

    public void readDataByLine(String file_name){
        try{
            BufferedReader br = new BufferedReader(new FileReader(file_name));
            String[] tmp = null;
            for(int i = 0; i< 1000; i++){
                tmp = br.readLine().split(",");
                System.out.println("Id: " + tmp[0] +
                        "       Timestamp: " + this.unixTimeDecoder(tmp[1]) +
                        "       Value: " + tmp[2] +
                        "       Property: " + tmp[3] +
                        "       Plug_id: " + tmp[4] +
                        "       househole_id: " + tmp[5] +
                        "       house_id: " + tmp[6]);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    Date unixTimeDecoder(String time){
        Date timeStamp = new Date(Long.parseLong(time));
        return timeStamp;
    }
}
