package findData;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//Reducer

public class FindDataReducer extends
		Reducer<Text, FloatWritable, Text, Text> {

	@Override public void reduce(Text key, Iterable<FloatWritable> values, Context context) throws IOException, InterruptedException { 
		float maxTemp = Float.MIN_VALUE; // 최대값 초기화
		for (FloatWritable value : values) {
			maxTemp = Math.max(maxTemp, value.get()); // 최대값 산출 	
		} 
		context.write(new Text(""), new Text(maxTemp+"°C")); // 결과 출력
	}
}
