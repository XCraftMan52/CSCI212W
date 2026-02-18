//Include Swing and AWT libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import the LocalDateTime class
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList; 


//Class with the design (View)
public class Array_List_Driver_Swing 
{
	//Initial Tools we need to lay out our stuff in any Swing Project
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private JPanel formPanel;

	int bookCtr;
	MyList<Book> tBookList = new MyArrayList<>();

	//Use this constructor to set up our GUI
   public Array_List_Driver_Swing()
   {
	   bookCtr = 0;
	   prepareBasicGUI();
   }
   
   //Set up our default Window (FRAME) with some basic stuff like
   // Panels to add items to, then add some output labels
   private void prepareBasicGUI()
   {
	   //Create a Frame (Window) and add a Grid Layout
	   mainFrame = new JFrame("Java SWING Examples");
	   mainFrame.setSize(1200,800);
	   mainFrame.setLayout(new GridLayout(4,1));

	   //Initialize our standard window components
	   headerLabel = new JLabel("",JLabel.CENTER );
	   statusLabel = new JLabel("",JLabel.CENTER);        
	   statusLabel.setSize(350,100);

	   
	   //Add a listener for closing the window
	   // Telling the nosey neightbor (Gert) to report when Close 
	   //is clicked.  If it is, respond by exiting the program
      mainFrame.addWindowListener(new WindowAdapter() 
      {
    	  //When user clicks the close button, Exit this program
		 public void windowClosing(WindowEvent windowEvent)
		 {
		    System.exit(0);
		 }        
      });    
      
      
      //Add a new panel (controPanel) and give it a Flow layout 
      //  for Good & Bad buttons
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      
      //Create another panel for our form and the submit button 
      formPanel = new JPanel();
      formPanel.setLayout(new GridLayout(8,2));

      
      //Add our header & status labels, as well as the control panel
      //Think of Grid...4 Rows, 1 Column
      mainFrame.add(headerLabel);		//Row 1
      mainFrame.add(controlPanel);		//Row 2
      mainFrame.add(formPanel);		//Row 3
      mainFrame.add(statusLabel);		//Row 4
      
      //Set the main frame (Window) visible
      mainFrame.setVisible(true);  
   }
   
   //Method to create the personalized version of the user form
   private void CreateImplementGUI()
   {
	   //Header for our GUI
	   headerLabel.setText("Book ArrayList Tracker: Swing"); 
	   
	   //****  Start form fields  ****************************************
	   
	   //Title
	   JLabel lblTitle = new JLabel("Book Title: ");
	   final JTextField txtTitle = new JTextField(20);
	   
	   //Author First
	   JLabel lblAuthFirst = new JLabel("Author First: ");
	   final JTextField txtAuthFirst = new JTextField(20);
	   
	   //Author Last
	   JLabel lblAuthLast = new JLabel("Author Last: ");
	   final JTextField txtAuthLast = new JTextField(20);
   
	   //Author Email
	   JLabel lblEmail = new JLabel("Email: ");
	   final JTextField txtEmail = new JTextField(20);

	   
	   //Published Date
	   JLabel lblDatePublished = new JLabel("Publish Date: ");
	   final JTextField txtDatePublished = new JTextField(20);
	   
	   //Set initial date to today, formatted the local date formatting
	   DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	   String tDate = LocalDate.now().format(formatters);
	   txtDatePublished.setText(tDate);

	   //Pages
	   JLabel lblPages = new JLabel("Pages: ");
	   //Create a numeric Spinner...First Set up the parameters
      SpinnerModel spinnerModel = 
    		  new SpinnerNumberModel(10, //initial value
    	         1, //min
    	         5000, //max
    	         1);//step
      //Next use the model to configure the spinner
      JSpinner spinPages = new JSpinner(spinnerModel);
    	      	     
      
	   //Price
	   JLabel lblPrice = new JLabel("Price: $");
	   final JTextField txtPrice = new JTextField(20);

	   

	   //***************************************************************
	   //Create Add Button and its event handler
	   //***************************************************************
	   JButton addButton = new JButton("Add Book");
	   addButton.setHorizontalAlignment(SwingConstants.CENTER);
	   
	   addButton.addActionListener(new ActionListener() 
	   {
	         public void actionPerformed(ActionEvent e) 
	         {   
	        	 //Create a Book instance and set values individually.
	        	 // Is there another way to create an instance and fill in values?
	        	 Book temp = new Book();
				 Timer tTimer = new Timer();
	        	 
	        	 //Individually fill in the values from the form
	        	 temp.SetTitle( txtTitle.getText());
	        	 temp.SetAuthFirst(txtTitle.getText());
	        	 temp.SetAuthLast(txtAuthFirst.getText());
	        	 temp.SetEmail(txtEmail.getText());
	        	 
	        	 try
	        	 {
		        	 //Convert to LocatDate, store it, then place it in Book
	        		 
        	         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Specify the format
	        	     LocalDate tDatePublished = LocalDate.parse(txtDatePublished.getText(), formatter);
	        		 
		        	 temp.SetDatePublished(tDatePublished);
	
		        	 //Convert to integer, store it, then place it in Book
		        	 int tPages = Integer.parseInt(spinPages.getValue().toString());
		        	 temp.SetPages(tPages);
	
		        	 //Convert to double, store it, then place it in Book
		        	 double tPrice = Double.parseDouble(txtPrice.getText());
		        	 temp.SetPrice(tPrice);
	        	 }
	        	 catch (NumberFormatException err)
	        	 {
	        		 temp.Feedback += "ERROR: Date or Numeric data not correct.";
	        	 }
	        	 catch (DateTimeParseException err)
	        	 {
	        		 temp.Feedback += "ERROR: The Publish date data not correct.";
	        	 }
	        	 
	        	 
	        	 //After book is filled in...Do we print it or do we print errors?
	        	 if (temp.Feedback.contains("ERROR:") == false)
	        	 {
	        		//***** NEW/UPDATED (START) *****
	        		//Retrieve the new Book as a Comma-Delimitted string
	        		//Also known as Comma-Separated Values (CSV) 
		            String data = temp.OutputOneRecord_CSV();
		            
		            //******NEW: Storing Data ***************************
		            String tResults = "";
		            
		            // (1) *** NEW *** Overwriting the data in the file
                    // tResults = FileIO.OverwriteFile(data, "Books.csv");

		            // (2) *** NEW *** Creates new data file if one does not exist already
		           // tResults = FileIO.CreateNewDataFile(data, "Books.csv");
		            
		            // (3) *** NEW *** Appending the data to the file
		            tResults = FileIO.AppendToFile(data, "Books.csv");

					tTimer.setStart();
					tBookList.add(temp);
					tTimer.setEnd();
		            
		           // (4) *** NEW *** Opens and Reads the first line of data (a record) 
		           // tResults = FileIO.GetOneLineOfData("Books.csv");
		           
			       // (5) *** NEW *** Opens and Reads the All Lines of data (a table or a database) 
			       //tResults = FileIO.GetAllLinesOfData("Books.csv");
		            
			       // (5) *** NEW *** Opens and Reads the All Lines of data (a table or a database) 
		            
			    //    String[] ArrayOfData = new String[100000000];
			    //    ArrayOfData = FileIO.GetArrayOfData("Books.csv");
			    //    tResults="";
			    //    for (int ctr=0; ctr < ArrayOfData.length; ctr++)
			    //    {
			    // 	   tResults += ArrayOfData[ctr];
			    //    }
			       

		            statusLabel.setText("Book Added to End of List: " + tTimer.getElapsedNano() + "NanoSecs");
	        	 }
	        	 else
	        	 {
	        		 statusLabel.setText(temp.Feedback);
	        	 }
	         }
	    }); 
	   //***************************************************************

	   //***************************************************************
	   //Create Add At Front Button and its event handler
	   //***************************************************************
	   JButton addAtFrontButton = new JButton("Add Book at Front of List");
	   addAtFrontButton.setHorizontalAlignment(SwingConstants.CENTER);
	   
	   addAtFrontButton.addActionListener(new ActionListener() 
	   {
	         public void actionPerformed(ActionEvent e) 
	         {   
	        	 //Create a Book instance and set values individually.
	        	 // Is there another way to create an instance and fill in values?
	        	 Book temp = new Book();
				 Timer tTimer = new Timer();
	        	 
	        	 //Individually fill in the values from the form
	        	 temp.SetTitle( txtTitle.getText());
	        	 temp.SetAuthFirst(txtTitle.getText());
	        	 temp.SetAuthLast(txtAuthFirst.getText());
	        	 temp.SetEmail(txtEmail.getText());
	        	 
	        	 try
	        	 {
		        	 //Convert to LocatDate, store it, then place it in Book
	        		 
        	         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Specify the format
	        	     LocalDate tDatePublished = LocalDate.parse(txtDatePublished.getText(), formatter);
	        		 
		        	 temp.SetDatePublished(tDatePublished);
	
		        	 //Convert to integer, store it, then place it in Book
		        	 int tPages = Integer.parseInt(spinPages.getValue().toString());
		        	 temp.SetPages(tPages);
	
		        	 //Convert to double, store it, then place it in Book
		        	 double tPrice = Double.parseDouble(txtPrice.getText());
		        	 temp.SetPrice(tPrice);
	        	 }
	        	 catch (NumberFormatException err)
	        	 {
	        		 temp.Feedback += "ERROR: Date or Numeric data not correct.";
	        	 }
	        	 catch (DateTimeParseException err)
	        	 {
	        		 temp.Feedback += "ERROR: The Publish date data not correct.";
	        	 }
	        	 
	        	 
	        	 //After book is filled in...Do we print it or do we print errors?
	        	 if (temp.Feedback.contains("ERROR:") == false)
	        	 {
	        		//***** NEW/UPDATED (START) *****
	        		//Retrieve the new Book as a Comma-Delimitted string
	        		//Also known as Comma-Separated Values (CSV) 
		            String data = temp.OutputOneRecord_CSV();
		            
		            //******NEW: Storing Data ***************************
		            String tResults = "";
		            
		            // (1) *** NEW *** Overwriting the data in the file
                    // tResults = FileIO.OverwriteFile(data, "Books.csv");

		            // (2) *** NEW *** Creates new data file if one does not exist already
		           // tResults = FileIO.CreateNewDataFile(data, "Books.csv");
		            
		            // (3) *** NEW *** Appending the data to the file
		            tResults = FileIO.AppendToFile(data, "Books.csv");

					tTimer.setStart();
					tBookList.add(0, temp);
					tTimer.setEnd();
		            
		           // (4) *** NEW *** Opens and Reads the first line of data (a record) 
		           // tResults = FileIO.GetOneLineOfData("Books.csv");
		           
			       // (5) *** NEW *** Opens and Reads the All Lines of data (a table or a database) 
			       //tResults = FileIO.GetAllLinesOfData("Books.csv");
		            
			       // (5) *** NEW *** Opens and Reads the All Lines of data (a table or a database) 
		            
			    //    String[] ArrayOfData = new String[100000000];
			    //    ArrayOfData = FileIO.GetArrayOfData("Books.csv");
			    //    tResults="";
			    //    for (int ctr=0; ctr < ArrayOfData.length; ctr++)
			    //    {
			    // 	   tResults += ArrayOfData[ctr];
			    //    }
			       

		            statusLabel.setText("Book Added to Front of List: " + tTimer.getElapsedNano() + "NanoSecs");
	        	 }
	        	 else
	        	 {
	        		 statusLabel.setText(temp.Feedback);
	        	 }
	         }
	    }); 
	   //***************************************************************
	   
	   //***************************************************************
	   //Create Delete Last Button and its event handler
	   //***************************************************************
	   JButton deleteLastButton = new JButton("Delete Last Book");
	   deleteLastButton.setHorizontalAlignment(SwingConstants.CENTER);
	   
	   deleteLastButton.addActionListener(new ActionListener()
	   {
	       public void actionPerformed(ActionEvent e)
	       {
	           if(tBookList.size() > 0)
	           {
	               Timer tTimer = new Timer();
	               tTimer.setStart();

	               tBookList.remove(tBookList.size() - 1);

	               tTimer.setEnd();
	               statusLabel.setText("Deleted Last Book: " + tTimer.getElapsedNano() + " NanoSecs");
	           }
	       }
	   });
	   
	   //***************************************************************
	   //Create Delete First Button and its event handler
	   //***************************************************************
	   JButton deleteFirstButton = new JButton("Delete First Book");
	   deleteFirstButton.setHorizontalAlignment(SwingConstants.CENTER);
	   
	   deleteFirstButton.addActionListener(new ActionListener()
	   {
	       public void actionPerformed(ActionEvent e)
	       {
	           if(tBookList.size() > 0)
	           {
	               Timer tTimer = new Timer();
	               tTimer.setStart();

	               tBookList.remove(0);

	               tTimer.setEnd();
	               statusLabel.setText("Deleted First Book: " + tTimer.getElapsedNano() + " NanoSecs");
	           }
	       }
	   });
	   //***************************************************************
	   //Create Find Start Index Button and its event handler
	   //***************************************************************
	   JButton findStartIndexButton = new JButton("Find Start Index Book");
	   findStartIndexButton.setHorizontalAlignment(SwingConstants.CENTER);
	   findStartIndexButton.addActionListener(new ActionListener()
	   {
	       public void actionPerformed(ActionEvent e)
	       {
	           if(tBookList.size() > 0)
	           {
	               Timer tTimer = new Timer();
	               tTimer.setStart();

	               Book b = tBookList.get(0);

	               tTimer.setEnd();
	               statusLabel.setText("Found Start Index: " + tTimer.getElapsedNano() + " NanoSecs");
	           }
	       }
	   });

	 
	   //***************************************************************
	   //Create Find Middle Index Button and its event handler
	   //***************************************************************
	   JButton findMiddleIndexButton = new JButton("Find Middle Index Book");
	   findMiddleIndexButton.setHorizontalAlignment(SwingConstants.CENTER);
	   findMiddleIndexButton.addActionListener(new ActionListener()
	   {
	       public void actionPerformed(ActionEvent e)
	       {
	           if(tBookList.size() > 0)
	           {
	               int mid = tBookList.size()/2;

	               Timer tTimer = new Timer();
	               tTimer.setStart();

	               Book b = tBookList.get(mid);

	               tTimer.setEnd();
	               statusLabel.setText("Found Middle Index: " + tTimer.getElapsedNano() + " NanoSecs");
	           }
	       }
	   });

	   
	   
	   //***************************************************************
	   //Create Find End Button and its event handler
	   //***************************************************************
	   JButton findEndIndexButton = new JButton("Find End Index Book");
	   findEndIndexButton.setHorizontalAlignment(SwingConstants.CENTER);
	   findEndIndexButton.addActionListener(new ActionListener()
	   {
	       public void actionPerformed(ActionEvent e)
	       {
	           if(tBookList.size() > 0)
	           {
	               Timer tTimer = new Timer();
	               tTimer.setStart();

	               Book b = tBookList.get(tBookList.size()-1);

	               tTimer.setEnd();
	               statusLabel.setText("Found End Index: " + tTimer.getElapsedNano() + " NanoSecs");
	           }
	       }
	   });

	  


	   //***************************************************************
	   //Create Button to fill form with good data and its event handler
	   //***************************************************************
	   JButton goodButton = new JButton("Good Sample");
	   
	   goodButton.addActionListener(new ActionListener() 
	   {
	         public void actionPerformed(ActionEvent e) 
	         {     
	           txtTitle.setText("Optimus Flies a Kite");
	           txtAuthFirst.setText("Scotticus");
	           txtAuthLast.setText("Prime");
	           txtEmail.setText("Scotticus@Primes.com");
	           txtDatePublished.setText("05/04/1977");
	           txtPrice.setText("3.99");
	         }
	    }); 
	   //***************************************************************
	   
	   
	   
	   //***************************************************************
	   //Create Button to fill form with bad data and its event handler
	   //***************************************************************
	   JButton badButton = new JButton("Bad Sample");
	   
	   badButton.addActionListener(new ActionListener() 
	   {
	         public void actionPerformed(ActionEvent e) 
	         {     
	           txtTitle.setText("Optimus Steps in Poopy");
	           txtAuthFirst.setText("ScotticusPoop");
	           txtAuthLast.setText("PoopyPrime");
	           txtEmail.setText("NotAnEmail");
	           txtDatePublished.setText("A while Ago");
	           txtPrice.setText("A lot");
	         }
	    }); 
	   //***************************************************************
	   
	   JButton readButton = new JButton("Read DataFile");
	   readButton.addActionListener(new ActionListener()
	   {
		   public void actionPerformed(ActionEvent e)
		   {
			   String[] ArrayOfData = new String[100000000];
			   ArrayOfData = FileIO.GetArrayOfData("Books.csv");
			   Timer tTimer = new Timer();

			   tTimer.setStart();

			   for (int ctr = 0; ctr < ArrayOfData.length; ctr++)
			   {
				if(ArrayOfData[ctr].length() > 0)
				{
					Book tBook = Book.ParsingOneBook(ArrayOfData[ctr]);

					if (tBook != null)
					{
						tBookList.add(tBook);
					}
				}
			   }

			   tTimer.setEnd();

			   
			   bookCtr = 0; // Get the last piece of data.
			   
			   txtTitle.setText(tBookList.get(bookCtr).GetTitle());
			   txtAuthFirst.setText(tBookList.get(bookCtr).GetAuthFirst());
			   txtAuthLast.setText(tBookList.get(bookCtr).GetAuthLast());
			   txtEmail.setText(tBookList.get(bookCtr).GetEmail());
			   txtDatePublished.setText(tBookList.get(bookCtr).GetDatePublished().toString());
			   Double tPrice = tBookList.get(bookCtr).GetPrice();
			   txtPrice.setText(tPrice.toString());

			   statusLabel.setText("Read small file:" + tTimer.getElapsedNano() + " NanoSecs");
			   
		   }
	   });

	   JButton importButton = new JButton("Import Data");
	   importButton.addActionListener(new ActionListener() 
	   {
		public void actionPerformed(ActionEvent e)
		{
			String[] ArrayOfData = new String[1000000000];
			ArrayOfData = FileIO.GetArrayOfData("Random_books.csv");

			Timer tTimer = new Timer();
			tTimer.setStart();

			for(int ctr = 0; ctr < ArrayOfData.length; ctr++)
			{
				if(ArrayOfData[ctr].length() > 0)
				{
					Book tBook = Book.ParsingOneBook(ArrayOfData[ctr]);

					if (tBook != null)
					{
						tBookList.add(tBook);
					}
				}
			}
			tTimer.setEnd();

			int ctr = 0;
			     // Add safety check before accessing
			
			
            txtTitle.setText(tBookList.get(bookCtr).GetTitle());
            txtAuthFirst.setText(tBookList.get(bookCtr).GetAuthFirst());
            txtAuthLast.setText(tBookList.get(bookCtr).GetAuthLast());
            txtEmail.setText(tBookList.get(bookCtr).GetEmail());
            txtDatePublished.setText(tBookList.get(bookCtr).GetDatePublished().toString());
            Double tPrice = tBookList.get(bookCtr).GetPrice();
            txtPrice.setText(tPrice.toString());

            statusLabel.setText("import large file:" + tTimer.getElapsedNano() + " NanoSecs - Loaded " + tBookList.size() + " books");
       
		}
	   });


	   // Button to change the index to # to the prior position in the array & fill out the form with the data
	   JButton priorButton = new JButton(" <<");

	   priorButton.addActionListener(new ActionListener()
	   {
			public void actionPerformed(ActionEvent e)
			{
				Timer tTimer = new Timer();
				tTimer.setStart();
				bookCtr--;

				if (bookCtr < 0)
				{
					bookCtr = 0;
				}

		       txtTitle.setText(tBookList.get(bookCtr).GetTitle());
			   txtAuthFirst.setText(tBookList.get(bookCtr).GetAuthFirst());
			   txtAuthLast.setText(tBookList.get(bookCtr).GetAuthLast());
			   txtEmail.setText(tBookList.get(bookCtr).GetEmail());
			   txtDatePublished.setText(tBookList.get(bookCtr).GetDatePublished().toString());
			   Double tPrice = tBookList.get(bookCtr).GetPrice();
			   txtPrice.setText(tPrice.toString());

		       statusLabel.setText("shifting one record:" + tTimer.getElapsedNano() + " NanoSecs");

			}
	   });

	   // Button to change the index to # to the next position in the array & fill out the form with the data
	   JButton nextButton = new JButton(" >>");

	   nextButton.addActionListener(new ActionListener()
	   {
			public void actionPerformed(ActionEvent e)
			{
				Timer tTimer = new Timer();
				tTimer.setStart();
				
				bookCtr++;

				if (bookCtr >= tBookList.size())
				{
					bookCtr = tBookList.size()-1;
				}

		       txtTitle.setText(tBookList.get(bookCtr).GetTitle());
			   txtAuthFirst.setText(tBookList.get(bookCtr).GetAuthFirst());
			   txtAuthLast.setText(tBookList.get(bookCtr).GetAuthLast());
			   txtEmail.setText(tBookList.get(bookCtr).GetEmail());
			   txtDatePublished.setText(tBookList.get(bookCtr).GetDatePublished().toString());
			   Double tPrice = tBookList.get(bookCtr).GetPrice();
			   txtPrice.setText(tPrice.toString());
			   tTimer.setEnd();
			   	statusLabel.setText("shifting one record:" + tTimer.getElapsedNano() + " NanoSecs");

			}
	   });
	   

	   //****  End form fields  ****************************************


	  
      //Add buttons to the Control Panel
      controlPanel.add(goodButton);
      controlPanel.add(badButton);  

      controlPanel.add(readButton);
	  controlPanel.add(importButton);
	  controlPanel.add(priorButton);
	  controlPanel.add(nextButton);

      //Add our specific form labels,textfields, etc
      formPanel.add(lblTitle);
      formPanel.add(txtTitle);
      formPanel.add(lblAuthFirst);
      formPanel.add(txtAuthFirst);
      formPanel.add(lblAuthLast);
      formPanel.add(txtAuthLast);
      formPanel.add(lblEmail);
      formPanel.add(txtEmail);

      formPanel.add(lblDatePublished);
      formPanel.add(txtDatePublished);

      formPanel.add(lblPages);
      formPanel.add(spinPages);
      
      formPanel.add(lblPrice);
      formPanel.add(txtPrice);
      

      //Add out submit button
      formPanel.add(addButton);
	  formPanel.add(addAtFrontButton);
	  formPanel.add(deleteFirstButton);
	  formPanel.add(deleteLastButton);
	  formPanel.add(findStartIndexButton);
	  formPanel.add(findMiddleIndexButton);
	  formPanel.add(findEndIndexButton);
	  
      
      //Make frame visible
	  mainFrame.setVisible(true);  
   }

    
   
   
   
   public static void main(String[] args)
   {
	   //Create an Instance of this GUI Driver class
	   Array_List_Driver_Swing Driver_Swing = new Array_List_Driver_Swing();
	   //Run code to generate this specific GUI and implement it
	   Driver_Swing.CreateImplementGUI();
   }
   

}