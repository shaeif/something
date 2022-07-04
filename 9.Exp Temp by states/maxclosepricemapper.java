import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.Mapper;

public class maxclosepricemapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, FloatWritable>
{																		                     	
	@Override
	public void map(LongWritable key, Text value, 
			OutputCollector<Text, FloatWritable> output, Reporter r)
					throws IOException {

		String line = value.toString();
		String[] items = line.split(",");
		
		String stock = items[3];
		if(!items[1].isEmpty() && !items[1].equals(null)) 
		{
			Float closePrice = Float.parseFloat(items[1]);
		    output.collect(new Text(stock), new FloatWritable(closePrice));
		}
}
}
