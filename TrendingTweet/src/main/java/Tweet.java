import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Tweet
{
	public static void main(String[] args) throws Exception {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("LN9OdScNGGJRabURP8S3ESGEG");
        cb.setOAuthConsumerSecret("SUaVLB3DFz8lJ1AbOdWHhxrHT2GnKpMtbP9cWKzp4cxIUU82V2");
        cb.setOAuthAccessToken("4842509317-uleLwkBRGePPCMLHMnFqBud55BJfRRalVpC22Mf");
        cb.setOAuthAccessTokenSecret("Lpko0LMVNZU9daVIQJwcQ0ehsXE7LNpkOFvahvr29ul81");
        TwitterFactory tf = new TwitterFactory(cb.build());
    	twitter4j.Twitter twitter = tf.getInstance();
    	Query query = new Query("job");
		PrintWriter writer = new PrintWriter("\\tmp"+"\\"+"jxs_tweet"+args[0]+"-"+args[1]+".txt"); 
		
		
		List<Status> tweets;
		    String str1 ="";
		    List<String> terms = new ArrayList<String>();
		    long count=0;
		    long sinceID=Long.MIN_VALUE;
		    query.setCount(100);
		    query.since(args[0]);
		    query.until(args[1]);
		    do {
		    	tweets = new ArrayList<Status>();
		        if(count>1)
		        	query.maxId(sinceID);
		        
		        QueryResult result;
				try {
					result = twitter.search(query);
			        for (Status status : result.getTweets()) {
			        	tweets.add(status);
			            if(sinceID<status.getId()){
			            	sinceID=status.getId();
			            }
			        }
			        for(Status status:tweets) {
			        	writer.println(status.getText());
			        }
			        count++;
				} catch (TwitterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    } while(count<50);
		    writer.flush();
		    writer.close();
		    System.out.println("Tweets fetched");
		String localSrc="\\tmp"+"\\"+"jxs_tweet"+args[0]+"-"+args[1]+".txt";
		String dst="hdfs://cshadoop1/user/jxs143230/"+"jxs_tweet"+args[0]+"-"+args[1]+".txt";
		HdfsAddFile.addFile(localSrc, dst);

    
    	
    }
}
            
    	
   
