//Book Class is a Blueprint to creating 
// Book Objects (vars)

// import the LocalDateTime class
import java.time.LocalDate;
import java.time.format.DateTimeFormatter; 

public class Book 
{
    //The following variables (properties) exist within 
	//  a Book 
	//(Public means all can access: Wallet in the hallway)
	//CREATE USER INPUT FOR THESE
    private String title;					//Already checking for bad words
    private String authorFirst;		//Check for bad words in the set
    private String authorLast;		// Same thing here
    private String Email;				//Min of 8 chars, Max of 75
    private LocalDate DatePublished;  //Do not ask user for this
    private int pages;					//Already checking
    private double Price;				//CHeck if it is a Double (driver) & Positive value (here)
    public String Feedback;
    
 //Default constructor   
    public Book()
    {
    	Feedback="";
    	title = "";
    	authorFirst ="";
    	authorLast = "";
    	Email = "";
    	DatePublished = LocalDate.now();
    	pages = 0;
    	Price = 0.0;
    }
    
    //Overloaded Constructor that gets Title, and Author's name
    public Book(String tTitle, String tAuthFirst, String tAuthLast)
    {
    	Feedback="";
    	SetTitle( tTitle);							//Protect out info from Bad Incoming data
    	SetAuthFirst(tAuthFirst);
    	SetAuthLast( tAuthLast);
    	Email = "";
    	DatePublished = LocalDate.now();
    	pages = 0;
    	Price = 0.0;
    }
 

    
    //Overloaded Constructor that receives and sets all info
    public Book(String tTitle, String tAuthFirst, String tAuthLast, String tEmail, LocalDate tDatePublished, int tPages, double tPrice)
    {
    	Feedback="";
    	SetTitle( tTitle);							//Protect out info from Bad Incoming data
    	SetAuthFirst(tAuthFirst);
    	SetAuthLast( tAuthLast);
    	SetDatePublished(tDatePublished);
    	SetDatePublished(tDatePublished);
    	SetPages(tPages);
    	SetPrice(tPrice);
    }
 

    
    
    
    //*********** Sets and Gets for Title **********************
    public String GetTitle()
    {
    	return title;
    }
    
    public void SetTitle(String tTitle)
    {
    	//if tTitle does not contain bad words, store it
    	if (Validation.GotBadWord(tTitle) == false)
    	{
    		title = tTitle;  //if good, store it.
    	}
    	else
    	{
    		//If it is bad, make it an empty string
    		Feedback = "\nERROR: This Title Contains Bad Words, such as Poop.";    		
    	}
    }
    
    
    //*********** Sets and Gets for Authors First Name **************
	public String GetAuthFirst()
	{
		return authorFirst;
	}
	
	public void SetAuthFirst(String tAuthorFirst)
	{
		//Check for bad words
		authorFirst = tAuthorFirst;
	}
    	
	  //*********** Sets and Gets for Authors Last Name **************
   public void SetAuthLast(String tAuthLast)
   {
	   //Check for bad words
	   this.authorLast = tAuthLast;
   }
	
	public String GetAuthLast()
	{
		return authorLast;
	}

	
	
  //*********** Sets and Gets for Author's Email **************
public void SetEmail(String tEmail)
{
   //Check for Good email???
   this.Email = tEmail;
}


public String GetEmail()
{
	return Email;
}



//*********** Sets and Gets for DatePublished **************
public void SetDatePublished(LocalDate tDatePublished)
{
 //Check for Good email???
 this.DatePublished = tDatePublished;
}


public LocalDate GetDatePublished()
{
	return DatePublished;
}



	
   	
	  //*********** Sets and Gets for # of pages (Int) **************
   public void SetPages(int tPages)
   {
	   if (Validation.IsWithinRange(tPages, 10, 3000))
	   {
		   this.pages = tPages;
	   }
	   else
	   {
		   Feedback += "\nERROR: Sorry this number needs to be between 10 and 3000 pages.";
	   }
	   
   }
	
	public int GetPages()
	{
		return pages;
	}

	
	
   	
	  //*********** Sets and Gets for Price (Double) **************
 public void SetPrice(double tPrice)
 {
	   if (Validation.IsWithinRange(tPrice, 1.00, 3000.00))
	   {
		   this.Price = tPrice;
	   }
	   else
	   {
		   Feedback += "\nERROR: Sorry the price needs to be between $1 and $3000.";
	   }
	   
 }
	
	public double GetPrice()
	{
		return Price;
	}

	
	//***** NEW FEATURES ADDED (START) *****
	
	public String OutputOneRecord_CSV()
	{
		String tOutput = "";
		//Concatenate individual pieces into tOutput
		// NEW - I updated this to merge the data in comma-delimtted format
		if (this.Feedback.contains("ERROR") == false)
		{
			tOutput = this.GetTitle();
			tOutput += ("," + this.GetAuthFirst() + ", " + this.GetAuthLast());
			tOutput += ("," + this.Email);
			tOutput += ("," + this.DatePublished.toString());
			tOutput += ("," + this.GetPages());
			tOutput += ("," + this.Price);
		}
		
		return tOutput;
	}
	public static Book ParsingOneBook(String tCsvBook)
	{
		Book tBook = new Book();
		
		if (tCsvBook.length() > 0)
		{
			int pos1 = 0;
			int pos2 = tCsvBook.indexOf(",", 0);
			tBook.SetTitle(tCsvBook.substring(pos1,pos2));
			
			pos1 = pos2 + 1;
			pos2 = tCsvBook.indexOf(",", pos1);
			tBook.SetAuthFirst(tCsvBook.substring(pos1,pos2));
			
			pos1 = pos2 + 1;
			pos2 = tCsvBook.indexOf(",", pos1);
			tBook.SetAuthLast(tCsvBook.substring(pos1,pos2));
			
			pos1 = pos2 + 1;
			pos2 = tCsvBook.indexOf(",", pos1);
			tBook.SetEmail(tCsvBook.substring(pos1,pos2));
			
			pos1 = pos2 + 1;
			pos2 = tCsvBook.indexOf(",", pos1);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate tDate = LocalDate.parse((tCsvBook.substring(pos1,pos2)), formatter);
			tBook.SetDatePublished(tDate);
			
			pos1 = pos2 + 1;
			pos2 = tCsvBook.indexOf(",", pos1);
			int tPages = Integer.parseInt(( tCsvBook.substring(pos1, pos2)));
			tBook.SetPages(tPages);
			
			pos1 = pos2 + 1;
			pos2 = tCsvBook.length();
			double tPrice = Double.parseDouble(tCsvBook.substring(pos1,pos2));
			tBook.SetPrice(tPrice);
			
		}
		return tBook;
	}
	
	public static Book[] ParsingBooksData(String[] tArrayOfData)
	{
		Book[] tBooks = new Book[tArrayOfData.length];
		
		for (int ctr = 0; ctr < tArrayOfData.length; ctr++)
		{
			if (tArrayOfData[ctr].length() > 0)
			{
				Book tBook = ParsingOneBook(tArrayOfData[ctr]);
				
				if (tBook != null) 
				{
					tBooks[ctr] = tBook;
				}
			}
		}
		return tBooks;
	}
	//***** NEW FEATURES ADDED (END) *****


}
