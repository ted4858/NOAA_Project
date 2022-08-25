package noaaProject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

public class DisplayFileURL extends SearchForData{
	private int selectNo;
	
	static { 
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory()); 
	}
	
	private String[] url = { "http://192.168.244.128:50070/webhdfs/v1/climateData/latitudeLongitude.txt?op=OPEN", 
							  "http://192.168.244.128:50070/webhdfs/v1/climateData/tempAvg.txt?op=OPEN", 
							  "http://192.168.244.128:50070/webhdfs/v1/climateData/tempMax.txt?op=OPEN", 
							  "http://192.168.244.128:50070/webhdfs/v1/climateData/tempMin.txt?op=OPEN", 
							  "http://192.168.244.128:50070/webhdfs/v1/climateData/windData.txt?op=OPEN" };
	
	public DisplayFileURL() {
		this.selectNo = 0;
	}

	public void displayFile() throws MalformedURLException, IOException {
		boolean run = true;
		System.out.println("\t\t    << ㅇ 3. 원본 파일 보기 >>\n");
		
		//연도 선택 무한 반복문
        while(run) {
        	try {
        		System.out.println("--------------------------- < 파일 선택 > ----------------------------");
                System.out.println("--------------------------------------------------------------------");
                System.out.println(" 1.위/경도 | 2.연평균 기온 | 3.최고 기온 | 4.최저 기온 | 5.풍향/속 | 6.메인 메뉴");
                System.out.println("--------------------------------------------------------------------");
                System.out.print("ㅇ 번호 입력 : ");
     
                selectNo = scanner.nextInt();
                
                System.out.println();
     
                if(selectNo == 1) {
                	System.out.println("ㅇ 1. 위/경도 .txt 파일 출력\n");
                	arrayNum = selectNo - 1;
                	break;
                } else if(selectNo == 2) {
                	System.out.println("ㅇ 2. 연평균 기온 .txt 파일 출력\n");
                	arrayNum = selectNo - 1;
                	break;
                } else if(selectNo == 3) {
                	System.out.println("ㅇ 3. 최고 기온 .txt 파일 출력\n");
                	arrayNum = selectNo - 1;
                	break;
                } else if(selectNo == 4) {
                	System.out.println("ㅇ 4. 최저 기온 .txt 파일 출력\n");
                	arrayNum = selectNo - 1;
                	break;
                } else if(selectNo == 5) {
                	System.out.println("ㅇ 5. 풍향/속 .txt 파일 출력\n");
                	arrayNum = selectNo - 1;
                	break;
                } else if(selectNo == 6) {
                	System.out.println("ㅇ 6. 메인 메뉴\n");
                    run = false;
                } else {
                	System.out.println("!! 잘못 입력하셨습니다. 다시 입력하세요! (입력값 : 1 ~ 6)\n");
                }
			} catch (Exception e) {
				scanner = new Scanner(System.in);
				System.out.println("\n!! 잘못 입력하셨습니다. (정수만 입력 가능)\n");
//				e.printStackTrace();
			}
        }
        
        if(run) {
        	System.out.println("ㅇ 파일을 읽고 있습니다. 잠시만 기다려주십시오...(약 10초 이내)\n");
        	InputStream in = null; 
        	
        	try 
    		{ 
    			in = new URL(url[arrayNum]).openStream(); 
    			IOUtils.copyBytes(in, System.out, 4096, false); 
    		} 
    		finally { 
    			IOUtils.closeStream(in); 
    		}
        }
        
	}
}