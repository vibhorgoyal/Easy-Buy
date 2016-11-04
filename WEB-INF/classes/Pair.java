package pack;
class Pair{
		
	private  float score;
	private  String review;
	Pair(float f, String s)
	{
		
		this.score = f;
		this.review = s;
	}
	public float getScore()
	{

		return this.score;
	}
	public String getReview()
	{
		return this.review;
	}
	public void setScore(float f)
	{
		this.score=f;
	}
	public  void setReview(String s)
	{
		this.review= s;
	}


}