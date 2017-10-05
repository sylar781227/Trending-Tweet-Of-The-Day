Export the twitter path:
{cs6360:~} export HADOOP_CLASSPATH=$HADOOP_CLASSPATH:/home/005/j/jx/jxs143230/twitter4j-core-4.0.4.jar

Give the from and to date in the argument
{cs6360:~} hadoop jar FinalTweet-1.0.jar com.sylar.Ass2.tweetAnalysis.Tweet 2016-02-03 2016-02-06

Execute the Map reduce code
{cs6360:~} hadoop jar FinalTweet-1.0.jar com.sylar.Ass2.tweetAnalysis.TweetCount /user/jxs143230/jxs_tweet2016-02-03-2016-02-06.txt /user/jxs143230/jxs_tweet6
