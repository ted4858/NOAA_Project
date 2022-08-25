package noaaProject;

import java.net.MalformedURLException;
import java.util.Scanner;

public class NoaaMain {
	private static Scanner scanner = new Scanner(System.in);
	private static SearchForData searchForData = new SearchForData();
	private static ClimateChangeConfirmation climateChangeConfirmation = new ClimateChangeConfirmation();
	private static DisplayFileURL displayFileURL = new DisplayFileURL();
	
    //기후 데이터 프로그램 메인 코드
    public static void main(String[] args) {
    	long startTime = System.currentTimeMillis();
        boolean run = true;
        int selectNo = 0;
        
        for (int i = 0; i < 12; ++i) System.out.println("--------------------------------------------------------------------");
        System.out.println("\n\t  <<< NOAA 기후 데이터 검색 시스템에 오신 것을 환영합니다. >>>\n");
        System.out.println("\t  <<< 원하시는 메뉴에 해당하는 번호를 입력해주십시오. (정수) >>>\n");
        for (int i = 0; i < 9; ++i) System.out.println("--------------------------------------------------------------------");
        
        //프로그램 메뉴 선택 무한 반복문
        while(run) {
        	try {
        		System.out.println("\n--------------------------- < 메뉴 선택 > ----------------------------");
                System.out.println("--------------------------------------------------------------------");
                System.out.println("    1.연도별 기후 데이터 검색 | 2.연도별 기온 변화 | 3.원본 파일 보기 | 4.종료");
                System.out.println("--------------------------------------------------------------------");
                System.out.print("ㅇ 번호 입력 : ");
     
                selectNo = scanner.nextInt();
                
                System.out.println();
     
                if(selectNo == 1) {
                	searchForData.searchData();
                } else if(selectNo == 2) {
                	climateChangeConfirmation.printGraph();
                } else if(selectNo == 3) {
                	displayFileURL.displayFile();
                } else if(selectNo == 4) {
                	System.out.println("\t\t    << ㅇ 4. 프로그램 종료 >>");
                    run = false;
                } else {
                	System.out.println("!! 잘못 입력하셨습니다. 다시 입력하세요! (입력값 : 1 ~ 3)\n");
                }
			} catch (MalformedURLException e) {
//				e.printStackTrace();
			} catch (Exception e) {
				scanner = new Scanner(System.in);
				System.out.println("\n!! 잘못 입력하셨습니다. (정수만 입력 가능)\n");
//				e.printStackTrace();
			}
        }
        
        long endTime = System.currentTimeMillis();
        
        //프로그램 동작 시간(MilliSecond)을 시, 분, 초로 저장
        int second = (int) ((endTime - startTime) / 1000) % 60;
        int minute = (int) ((endTime - startTime) / 1000 / 60) % 60;
        int hour = (int) (endTime - startTime) / 1000 / 60 / 60;
        
        System.out.println("\nㅇ 프로그램 이용 시간 : " + hour + "시간 " + minute + "분 " + second + "초");
        System.out.println("ㅇ 감사합니다. 다음에도 이용 부탁드립니다.");
    }
}
