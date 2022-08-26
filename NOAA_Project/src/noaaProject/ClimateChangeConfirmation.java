package noaaProject;

import java.util.Scanner;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class ClimateChangeConfirmation extends SearchForData{
	private int selectNo;
	
	public ClimateChangeConfirmation() {
		this.selectNo = 0;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void printGraph() {
		boolean run = true;
		System.out.println("\t\t    << ㅇ 2. 연도별 기온 변화 >>\n");
		
		//연도 선택 무한 반복문
        while(run) {
        	try {
        		System.out.println("--------------------------- < 메뉴 선택 > ----------------------------");
                System.out.println("--------------------------------------------------------------------");
                System.out.println("     1.최고 기온   |   2.최저 기온   |   3.연평균 기온   |   4.메인 메뉴");
                System.out.println("--------------------------------------------------------------------");
                System.out.print("ㅇ 번호 입력 : ");
     
                selectNo = scanner.nextInt();
                
                System.out.println();
     
                if(selectNo == 1) {
                	System.out.println("ㅇ 1. 연도별 최고 기온 변화 그래프 출력");
                	arrayNum = selectNo - 1;
                	break;
                } else if(selectNo == 2) {
                	System.out.println("ㅇ 2. 연도별 최고 기온 변화 그래프 출력");
                	arrayNum = selectNo - 1;
                	break;
                } else if(selectNo == 3) {
                	System.out.println("ㅇ 3. 연도별 최고 기온 변화 그래프 출력");
                	arrayNum = selectNo - 1;
                	break;
                } else if(selectNo == 4) {
                	System.out.println("ㅇ 4. 메인 메뉴");
                    run = false;
                } else {
                	System.out.println("!! 잘못 입력하셨습니다. 다시 입력하세요! (입력값 : 1 ~ 4)\n");
                }
			} catch (Exception e) {
				scanner = new Scanner(System.in);
				System.out.println("\n!! 잘못 입력하셨습니다. (정수만 입력 가능)\n");
//				e.printStackTrace();
			}
        }
        
		if(run) {
			double[] xData = new double[] { 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1980, 1981, 
					1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 
					1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 
					2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 
					2021, 2022 };
		    double[] yData = new double[50];
		    yData = climateData[arrayNum];
		    
		    // Create Chart
		    XYChart chart = QuickChart.getChart("연도별 기온 변화 그래프", "연도(년도)", "기온(°C)", xData, yData);
		 
		    // Show it
		    new SwingWrapper(chart).displayChart();
		}
	}
}
