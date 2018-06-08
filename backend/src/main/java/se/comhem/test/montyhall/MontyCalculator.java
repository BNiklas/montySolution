package se.comhem.test.montyhall;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class MontyCalculator {
    public int calc(Request request){
        int result = 0;
        //Numbers to represent doors
        Random rand = new Random();

        if(request.getChangeDoor()){
            for(int i=0; i<request.getSimNum(); i++){
                Map<String,Integer> map = new HashMap<>();
                map.put("Door1",1);
                map.put("Door2",2);
                map.put("Door3",3);
                String[] keys = {"Door1","Door2","Door3"};
                int winDoor = rand.nextInt(3)+1;
                int playDoor = rand.nextInt(3)+1;
                for(String key : keys){
                    if(map.get(key)!= winDoor && map.get(key) != playDoor) {
                        map.remove(key);
                        break;
                    }
                    if(winDoor == playDoor) {
                        for (String key2 : keys) {
                            if (playDoor != map.get(key2))
                                playDoor = map.get(key2);
                        }
                    }
                    else
                        playDoor = winDoor;
                }

                if(winDoor == playDoor)
                    result++;
            }
        }
        else {
            for (int i = 0; i < request.getSimNum(); i++) {
                //Onödigt? -------------------------------------------------
                Map<String, Integer> map = new HashMap<>();
                map.put("Door1", 1);
                map.put("Door2", 2);
                map.put("Door3", 3);
                String[] keys = {"Door1", "Door2", "Door3"};
                int winDoor = rand.nextInt(3) + 1;
                int playDoor = rand.nextInt(3) + 1;
                for (String key : keys) {
                    if (map.get(key) != winDoor && map.get(key) != playDoor) {
                        map.remove(key);
                        break;
                    }
                }
                //-----------------------------------------------------------
                if (winDoor == playDoor)
                    result++;
            }
        }
        return result;
    }
}
