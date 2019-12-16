package ee402test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataPackage {
	   /**
	    * DataPackage contains the different informations communicated by the raspberry pi
	    */
        private String t_temp,t_time;// value of reference (CPU's Temperature & time of the recuperation )
		
		public DataPackage() {}
		public DataPackage getDataPackage() {
			try {//try to open th file containing the CPU's temperature on raspberry pi
				File file = new File("/sys/class/thermal/thermal_zone0/temp");//create a file object with the raspberry path
				Scanner scan = new Scanner(file);//opening a scanner to read the file
				t_temp= scan.nextLine();
				scan.close();//close the scanner
			}
			catch (FileNotFoundException e){//if the file isn't found
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			DateTimeService datatime=new DateTimeService();
			t_time= datatime.getDateAndTime();
			return this;
		}
		public String get_data_str() {return (t_temp+"@"+t_time);}//return all informations in a string format
}
