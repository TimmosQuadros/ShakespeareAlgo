/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shakespeare;

/**
 *
 * @author TimmosQuadros
 */
public class Stopwatch {

	private long start;

	public Stopwatch() {
		
	}
	
	public void start(){
		start = System.currentTimeMillis();
		//System.out.println(start);
	}

	public double elapsedTime(){
		long now = System.currentTimeMillis();
		return (now-start)/1000.0;
	}
}

