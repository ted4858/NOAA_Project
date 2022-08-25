package noaaProject;

import java.util.Scanner;

public class SearchForData {
	protected static Scanner scanner = new Scanner(System.in);
	private int year;
	protected int arrayNum;
	protected int[] yearData = { 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1980, 1981, 
			1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990, 1991, 1992, 1993, 1994, 
			1995, 1996, 1997, 1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 
			2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 
			2021, 2022 };
	protected double[][] climateData = { { 11.0, 13.0, 16.0, 13.0, 13.0, 15.0, 14.0, 
			15.0, 8.0, 9.6, 10.2, 10.1, 13.5, 12.6, 11.4, 11.0, 12.2, 18.4, 9.8, 11.6, 10.9, 
			16.0, 9.9, 11.5, 12.7, 10.3, 11.8, 10.5, 12.0, 14.1, 11.2, 13.4, 14.0, 12.3, 11.7, 
			11.0, 11.5, 9.7, 12.2, 12.7, 12.3, 11.7, 14.2, 12.2, 14.3, 16.6, 16.7, 10.7, 13.2, 
			8.6 },	// 연도별 최고 기온 데이터
		{ -25.0, -13.0, -22.0, -18.0, -26.0, -23.0, -26.0, -17.0, -17.0, -18.9, -16.4, 
		  -12.4, -17.8, -21.1, -24.8, -25.1, -20.3, -13.9, -14.6, -18.1, -16.3, -15.9, 
		  -13.2, -17.8, -23.2, -21.0, -12.6, -17.9, -19.1, -16.3, -19.6, -15.1, -12.9, 
		  -12.9, -13.4, -13.7, -13.2, -12.9, -14.1, -15.0, -13.5, -12.7, -14.1, -10.4, 
		  -12.3, -13.2, -12.2, -14.1, -12.2, -12.7 },	// 연도별 최저 기온 데이터
		{ -2.3, 0.3, -1.6, -0.0, -1.4, -1.6, -1.5, -0.8, -1.9, -1.7, -1.3, 0.7, -1.2, 
		  -0.7, -1.0, -2.4, -1.2, 0.2, 0.3, -0.3, -0.2, -0.1, -0.5, -0.6, -1.0, -0.4, 
		  0.7, -0.1, -0.4, 2.3, 0.2, 0.8, 0.6, 0.9, 0.4, 0.7, 0.8, 0.6, 1.0, 0.3, 0.1, 
		  2.1, 1.0, 2.2, 1.6, 2.0, 0.8, 0.4, 1.5, -2.5 },	// 연평균 기온 데이터
		{ 231.2, 210.9, 235.4, 215.2, 229.2, 197.8, 209.5, 233.1, 233.3, 232.6, 238.9, 
		  208.5, 235.1, 218.3, 214.7, 220.4, 217.9, 202.6, 201.1, 207.9, 204.0, 212.7, 
		  225.1, 217.6, 219.9, 218.5, 206.3, 200.8, 205.5, 188.8, 206.5, 214.7, 216.2, 
		  207.2, 229.1, 215.7, 223.2, 226.8, 219.0, 232.6, 211.3, 199.9, 207.1, 209.1, 
		  203.1, 195.0, 209.7, 209.8, 205.7, 200.3 },	// 연평균 풍향 데이터
		{ 73.0, 66.2, 72.1, 67.0, 66.9, 67.7, 74.0, 69.8, 69.3, 69.5, 70.7, 66.4, 63.4, 
		  63.7, 65.0, 70.6, 73.8, 71.5, 73.2, 71.0, 72.1, 68.0, 73.5, 63.7, 65.7, 70.0, 
		  39.7, 33.6, 68.6, 62.4, 63.8, 67.0, 68.6, 66.8, 73.0, 70.7, 67.1, 62.5, 71.2, 
		  66.1, 65.0, 61.7, 73.2, 67.4, 66.5, 64.7, 64.7, 74.1, 66.6, 81.6
		}	// 연평균 풍속 데이터
	};
	private double latitudeCoordinate = 70.933;
	private double longitudeCoordinate = -86.67;
	
	public SearchForData() {
		this.year = 0;
		this.arrayNum = 0;
	}
	
	public void searchData() {
		boolean run = true;
		System.out.println("\t\t    << ㅇ 1. 연도별 기후 데이터 검색 >>\n");
		
		//연도 선택 무한 반복문
        while(run) {
        	try {
                System.out.print("ㅇ 연도 입력(입력값 : 1973 ~ 2022) : ");
     
                this.year = scanner.nextInt();
                
                System.out.println();
     
                if(this.year >= 1973 && this.year <= 2022) {
                	printData();
                	run = false;
                } else {
                	System.out.println("!! 잘못 입력하셨습니다. 다시 입력하세요! (입력값 : 1973 ~ 2022)\n");
                }
			} catch (Exception e) {
				scanner = new Scanner(System.in);
				System.out.println("\n!! 잘못 입력하셨습니다. (정수만 입력 가능)\n");
//				e.printStackTrace();
			}
        }
	}
	
	public void printData() {
		System.out.println("ㅇ " + this.year + "년도를 검색하셨습니다.\n");
		
		// yearData에서 입력한 연도와 같은 연도의 배열 번호 가져오기
		for(int i = 0; i < this.yearData.length; ++i) {
			if(this.year == this.yearData[i]) {
				this.arrayNum = i;
				break;
			}
		}
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\t<< " + this.yearData[this.arrayNum] + "년도 캐나다 누나부트 배핀 섬의 NOAA 기후 데이터 >>");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\t# 위도 : " + this.latitudeCoordinate);
		System.out.println("\t# 경도 : " + this.longitudeCoordinate);
		System.out.println("\t# 최고 기온 : " + this.climateData[0][this.arrayNum] + " °C");
		System.out.println("\t# 최저 기온 : " + this.climateData[1][this.arrayNum] + " °C");
		System.out.println("\t# 연평균 기온 : " + this.climateData[2][this.arrayNum] + " °C");
		System.out.println("\t# 연평균 풍향각 : " + this.climateData[3][this.arrayNum] + " °");
		System.out.println("\t# 연평균 풍속(m/s) : " + this.climateData[4][this.arrayNum] + " (m/s)");
		climateCheck();
		System.out.println("--------------------------------------------------------------------");
		
	}
	
	public void climateCheck() {
		if (this.climateData[2][this.arrayNum] < 1.0 && this.climateData[4][this.arrayNum] > 65.0) {
			System.out.println("\t# " + this.yearData[this.arrayNum] + "년도는 대체로 춥고 바람이 많이 부는 날씨였습니다.");
		} else if (this.climateData[2][this.arrayNum] < 1.0 && this.climateData[4][this.arrayNum] < 65.0) {
			System.out.println("\t# " + this.yearData[this.arrayNum] + "년도는 대체로 추운 날씨였습니다.");
		} else if (this.climateData[2][this.arrayNum] > 1.0 && this.climateData[4][this.arrayNum] > 65.0) {
			System.out.println("\t# " + this.yearData[this.arrayNum] + "년도는 대체로 바람이 많이 부는 날씨였습니다.");
		} else {
			System.out.println("\t# " + this.yearData[this.arrayNum] + "년도는 다른 연도에 비해 따뜻한 날씨였습니다.");
		}
	}
}
