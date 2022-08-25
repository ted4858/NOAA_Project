package findData;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;

public class FindData {
	
	public static void main(String[] args) throws Exception {

		if (args.length != 2) { // 데이터 경로 요청
			System.err.println("Input: FindMaxTemp <input path> <output path>"); 
			System.exit(-1); 
		}
		@SuppressWarnings("deprecation")
		Job job = new Job(); 
		job.setJarByClass(FindData.class);
		job.setJobName("Find Data"); 
		FileInputFormat.addInputPath(job, new Path(args[0])); // 입력 데이터 경로 
		FileOutputFormat.setOutputPath(job, new Path(args[1])); // 출력 데이터 경로 
		job.setMapperClass(FindDataMapper.class); // 매퍼 
		job.setReducerClass(FindDataReducer.class); // 리듀서
		job.setOutputKeyClass(Text.class); // 문자열 형태 
		job.setOutputValueClass(Text.class); // 부동소수점 형태
		System.exit(job.waitForCompletion(true) ? 0 : 1 );
	}
}
