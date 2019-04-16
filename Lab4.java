/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;
import static lab4.TestTable.nextPrime;
/**
 *
 * @author Amos
 */
public class Lab4 {

    /**
     * @param args the command line arguments
     */
    public static void simulationLin(){
        for(double load = 1; load<10; load++){
            double avgProbes = 0;
            double avgunsuccess=0;
            double loadfactor = 0.1 * load;
            for(int i = 0; i<100; i++){
                double probes = 0;
                HashTableLin h1 = new HashTableLin(100000, loadfactor);
                for(int k = 0; k<100000; k++){
                    int randomNum = (int)(Math.random() * 100000000);
                    probes += h1.insertcount(randomNum);
                }
                double counter= h1.getNumKeys();
                avgProbes= probes/ counter;
                avgunsuccess=((probes-100000)/(100000));
            }
//            System.out.println("The average number of probes for a successful insertion with load factor " + loadfactor + " is "  + avgProbes);
//            System.out.println("The theorical number is "+ 0.5*(1+(1/(1-loadfactor))));
            System.out.println("The average number of probes for an unsuccessful insertion with load factor " + loadfactor + " is "  + avgunsuccess);
            System.out.println("The theorical number is "+ 0.5*(1+(1/((1-loadfactor)*(1-loadfactor)))));
        }
    }
    
    public static void simulationQuad(){
        for(double load = 1; load<10; load++){
            double avgProbes = 0;
            double loadfactor = 0.1 * load;
            for(int i = 0; i<100; i++){
                double probes = 0;
                HashTableQuad h2 = new HashTableQuad(10000, loadfactor);
                for(int k = 0; k<10000; k++){
                    int randomNum = (int)(Math.random() * 10000); 
                    probes += h2.insertcount(randomNum);
                }
                double counter= h2.getNumKeys();
                avgProbes= probes/ counter;
            }
            System.out.println("The average number of probes for a successful insertion with load factor " + loadfactor + " is "  + avgProbes);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int int1=3;
        int int2=2;
        int int3=50;
        double loadfactor1=0.9;
        double loadfactor2=0.8;
        Integer [] a = {2,5,12,7};

        
 
         System.out.println("No1-> test linear constructor ");
         HashTableLin h1=new HashTableLin(3,loadfactor1);
         System.out.println("table size= "+h1.getTSize()+"\nnumber of keys in the table = " + h1.getNumKeys());
         System.out.println("*****************************************************");
         
        
        System.out.println("No2-> test insert method");
         for(int i=0;i<a.length;i++){
                 h1.insert(a[i]);
            }
        
        h1.printKeys();
        h1.printKeysAndIndexes();
        System.out.println("table size= "+h1.getTSize()+"\nnumber of keys in the table = " + h1.getNumKeys());
        System.out.println("*****************************************************");

        
         
        System.out.println("No3-> test isIn method");
        System.out.println(h1.isIn(2));
        System.out.println("*****************************************************");
        
        
        
             
        System.out.println("No4-> test quadratic constructor ");
        HashTableQuad h2=new HashTableQuad(3,loadfactor1);
        System.out.println("table size= "+h2.getTSize()+"\nnumber of keys in the table = " + h2.getNumKeys());
        System.out.println("*****************************************************");
        
        
        
         System.out.println("No14-> test insert method");
         for(int i=0;i<a.length;i++){
                h2.insert(a[i]);
            }
        h2.printKeys();
        h2.printKeysAndIndexes();
        
         System.out.println("table size= "+h2.getTSize()+"\nnumber of keys in the table = " + h2.getNumKeys());
         System.out.println("*****************************************************");
         
        simulationLin();
    }
    
}
