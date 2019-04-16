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
public class HashTableQuad {
    private Integer[] table;
    private int Tsize;
    private int NumKeys;
    private double loadfac;
    
    public HashTableQuad(int maxNum, double load){
        NumKeys=0;
        loadfac=load;
        int size=(int)(maxNum/load);
        Tsize=nextPrime(size);
        table = new Integer[Tsize];
    }
    
        public int getTSize(){
        return Tsize;
    }
    public int getNumKeys(){
        return NumKeys;
    }
    
    public void insert(int n){
        if(!isIn(n)){
            if(((NumKeys +1.0)/Tsize) >= loadfac){
                rehash();
            }
            for(int i = 0; i<Tsize;i++){
                int quad = ((n%Tsize)+(i*i))%Tsize;
                if(table[quad]== null){
                    table[quad] = n;
                    break;
                }
            }
            NumKeys++;
        }
    }
    
    public int insertcount(int n){
        int count=1;
        if(!isIn(n)){
            if(((NumKeys +1.0)/Tsize) >= loadfac){
                rehash();
            }
            for(int i = 0; i<Tsize;i++){
                int quad = ((n%Tsize)+(i*i))%Tsize;
                if(table[quad]== null){
                    table[quad] = n;
                    break;
                }
                if(table[quad]!= null){
                    count++;
                }
            }
            NumKeys++;
        }
        return count;
    }
    
    private void rehash(){
       int NewSize= 2*(table.length);
       int reSize=nextPrime(NewSize);
       Integer[] newtable=new Integer[reSize];
         for(int i = 0; i<this.table.length;i++){
             if(this.table[i]!=null){
                int index=this.table[i]%reSize;
                newtable[index]=this.table[i];
             }
            }
       Tsize=reSize;
       table=newtable;
    }
    
    public boolean isIn(int n){
        for(int i = n%Tsize; i<Tsize; i++){
            if(table[(n+i*i)%Tsize]== null){
                return false;
            }
            else if(table[(n+i*i)%Tsize] == n){
                return true;
            }
        }
        return false;
    }
    
    public void printKeys(){
       for(Integer i: table)
            if(i!=null)
                System.out.print(i + " ");
                System.out.println( );
    }
    
    public void printKeysAndIndexes(){
       for(int i = 0; i<Tsize; i++){
            if(table[i] != null)
                System.out.println(table[i] + " stored at index " + i);
       }
    }
}
