public class Simulation{
    //the actual simulation
    public static void main(String[] args) {
        double[] ws = new double[500];
        for(int i = 0; i<500; i++){
            ws[i] = findw()/60;
            System.out.println(ws[i]);
        }
    }

    //returns number of seconds for 1 customer
    public static double findw(){
        double w = 0.0;
        int calls = 0;
        RandomNumGen num = new RandomNumGen();
        RandomVarGen var = new RandomVarGen(num);
        double cur = 0.0;
        while(calls<3){
            w += 3; //dials
            cur = num.nextRandom();
            if(cur<=.3536){ //connects in less than 2 min
                w +=5; //get connected
                //w += random variabel that adds the time spent waiting
                cur = num.nextRandom(); //generate new random number
                if(cur<=.1){ //agent a
                    w += 60*1.1;
                }
                else if(w<=.3){ //agent b
                    w+=60*1.5;
                }
                else if (w<=.55){ //agent c
                    w+=60*1.65;
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
