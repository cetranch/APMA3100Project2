import java.util.*;
public class Simulation{
    //the actual simulation
    public static void main(String[] args) {
        double[] ws = new double[500];
        double sum = 0;
        RandomNumGen num = new RandomNumGen();
        for(int i = 0; i<500; i++){
            ws[i] = findw(num)/60;
            //System.out.println(ws[i]);
            sum+=ws[i];
        }
        Arrays.sort(ws);
        System.out.println(Arrays.toString(ws));
        System.out.println("mean: " + sum/500);
        System.out.println("median: " + (ws[ws.length/2] + ws[(ws.length/2)-1]) / 2.0);

    }

    //returns number of seconds for 1 customer
    public static double findw(RandomNumGen num){
        double w = 0.0;
        int calls = 0;
        //RandomNumGen num = new RandomNumGen();
        RandomVarGen var = new RandomVarGen(num);
        double cur = 0.0;
        while(calls<3){
            w += 3; //dials
            cur = num.nextRandom();
            if(cur<=.3536){ //connects in less than 2 min
                w +=5; //get connected
                w += var.ContinuousX();
                cur = num.nextRandom(); //generate new random number
                if(cur<=.1){ //agent a
                    w += 60.0*1.1;
                }
                else if(cur<=.3){ //agent b
                    w+=60.0*1.5;
                }
                else if (cur<=.55){ //agent c
                    w+=60.0*1.65;
                }
                else{
                    w+=1.9*60;
                }


                calls = 100; //makes sure loop ends
            }
            else{ //doesn't connect and hangs up;
                w +=120; //time waiting
                w+=2; //disconect time
                calls++;
            }
        }

        return w;
    }
}

