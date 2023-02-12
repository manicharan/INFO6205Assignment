package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class HWQUPC_Solution {
	private static Random random = new Random();
	public static int count(int n) {
        int edges = 0;
        
        UF_HWQUPC u = new UF_HWQUPC(n);
        while (u.components() > 1) {
            int i = random.nextInt(n);
            int j = random.nextInt(n);
            if (!u.connected(i, j))
            	 u.union(i, j);
            edges++;
        }
        return edges;
    }
    public static void main(String[] args) {
    	if (args.length == 0)
            throw new RuntimeException("Syntax: HWQUPC [experiments]");
    	
        for(int i=0;i<args.length;i++) {        
        int n = Integer.parseInt(args[i]);
        int experiments = 1000;        
        double sum=0;        
        for (int j = 0; j < experiments; j++) {
            sum+= count(n);
        }           
        System.out.println("The average number of connections for n = " + n +" is " + sum/experiments);
        }       
    }
}
