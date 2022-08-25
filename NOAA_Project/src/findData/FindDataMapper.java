package findData;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//Mapper

public class FindDataMapper extends
		Mapper<LongWritable, Text, Text, FloatWritable> {
	
	private static final int MISSING = 9999; // 실측 데이터

	@Override public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException { 
		String data = value.toString(); 
		String year = data.substring(15, 19); // 연도 추출 
		int airTemp = 0;
		float airTemp_MAx = 0;
		
		// 기온 추출: parseInt() 메소드는 + 문자 처리가 안되므로 제외 시킴 
		if (data.charAt(87)=='+') airTemp_MAx=(Float.parseFloat(data.substring(88,92))) / 10; 
		if (data.charAt(87)=='-') airTemp_MAx=(Float.parseFloat(data.substring(88,92))) / 10; 
		else airTemp = Integer.parseInt(data.substring(87, 92));
		
		String quality = data.substring(92, 93);
		
		if (airTemp != MISSING && quality.matches("[01459]")) {	// 정상이면 
			context.write(new Text(year), new FloatWritable(airTemp_MAx)); // 출력 
		}
	}
}
