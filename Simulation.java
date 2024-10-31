import java.util.*;
public class Simulation{
    //the actual simulation
    public static void main(String[] args) {
        double[] ws = new double[500];
        double sum = 0;
        RandomNumGen num = new RandomNumGen();
        for(int i = 0; i<500; i++){
            ws[i] = findw(num);
            //System.out.println(ws[i]);
            sum+=ws[i];
        }
        Arrays.sort(ws);
        for (double value : ws) {
            System.out.println(value);
        }
        System.out.println("mean: " + sum/500);
        System.out.println("median: " + (ws[ws.length/2] + ws[(ws.length/2)-1]) / 2.0);

    }

    //returns number of seconds for 1 customer
    public static double findw(RandomNumGen num){
        double w = 0.0;
        int calls = 0;
        RandomVarGen var = new RandomVarGen(num);
        while(calls<3){
            w += 3.0 / 60.0; //dials
            double waittime = var.ContinuousX();
            if(waittime <= 2){ //connects in less than 2 min
                w +=5.0 / 60.0; //get connected
                w += waittime;
                double cur = num.nextRandom(); //generate new random number
                if(cur<=.1){ //agent a
                    w += 1.1;
                }
                else if(cur<=.3){ //agent b
                    w+= 1.5;
                }
                else if (cur<=.55){ //agent c
                    w+= 1.65;
                }
                else{
                    w+=1.9;
                }
                break;


            }
            else{ //doesn't connect and hangs up;
                w +=2; //time waiting
                w+=2.0 / 60.0; //disconnect time
                calls++;
            }
        }

        return w;
    }
}
