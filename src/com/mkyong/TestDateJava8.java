package com.mkyong;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
public class TestDateJava8 {
	 public static void main(String[] args) {

	        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate date1 = LocalDate.of(2009, 12, 31);
	        LocalDate date2 = LocalDate.of(2010, 01, 31);

	        System.out.println("date1 : " + sdf.format(date1));
	        System.out.println("date2 : " + sdf.format(date2));

	        System.out.println("Is...");
	        if (date1.isAfter(date2)) {
	            System.out.println("Date1 is after Date2");
	        }

	        if (date1.isBefore(date2)) {
	            System.out.println("Date1 is before Date2");
	        }

	        if (date1.isEqual(date2)) {
	            System.out.println("Date1 is equal Date	2");
	        }

	        System.out.println("CompareTo...");
	        if (date1.compareTo(date2) > 0) {

	            System.out.println("Date1 is after Date2");

	        } else if (date1.compareTo(date2) < 0) {

	            System.out.println("Date1 is before Date2");

	        } else if (date1.compareTo(date2) == 0) {

	            System.out.println("Date1 is equal to Date2");

	        } else {

	            System.out.println("How to get here?");

	        }
	        
	        
	        ///////////////////////////////
	        
	        LocalDateTime dateTime = LocalDateTime.of(2016, Month.AUGUST, 18, 6, 17, 10);

	        System.out.println("LocalDateTime : " + dateTime);

	        // Convert LocalDateTime to Instant, UTC+0
	        Instant instant = dateTime.toInstant(ZoneOffset.UTC);

	        System.out.println("Instant : " + instant);
	        
	        ////////////////////////////////////////
	        
	        String now = "2016-11-09 10:30";

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	        LocalDateTime formatDateTime = LocalDateTime.parse(now, formatter);

	        System.out.println("Before : " + now);

	        System.out.println("After : " + formatDateTime);

	        System.out.println("After : " + formatDateTime.format(formatter));

	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	    }

}
