import java.util.*;

/**
 * Jorge Ambriz
 */
public class CollectionSortBooksLinkedList
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		// Step 1: Create a LinkedList (dynamic)
		LinkedList<Book> bookInventory = new LinkedList<>();
		bookInventory.add(new Book("Unmasking AI", "Dr. Joy Buolamwini", 2023));
		bookInventory.add(new Book("Hello World", "Hannah Fry", 2018));
		bookInventory.add(new Book("The Mathematics of Love", "Hannah Fry", 2015));
		bookInventory.add(new Book("Weapons of Math Destruction", "Cathy O’Neil", 2016));
		bookInventory.add(new Book("Race After Technology", "Ruha Benjamin", 2019));

		System.out.println("Original LinkedList of books:");
		for (Book currentBook : bookInventory)
		{
			System.out.println(currentBook);
		}

		System.out.println();

		// Step 2: Convert to ArrayList for sorting, tip to contain the info better convert the linked list to an array list
		List<Book> books = new ArrayList<>(bookInventory);

		// Step 3: Sort by Title
		System.out.println("Books sorted by title:");
		books.sort(Comparator.comparing(Book::getTitle));
		for (Book currentBook : books)
		{
			System.out.println(currentBook);
		}

		System.out.println();

		// Step 4: Sort by year (newest to oldest)
		System.out.println("Books sorted by Year:");
		books.sort(Comparator.comparing(Book::getYear));
		for(Book currentBook : books)
		{
			System.out.println(currentBook);
		}
		
		//TreeMap Practice	
		TreeMap<Integer, List<Book>> booksByYear = new TreeMap<>();
		for(Book currentBook : bookInventory) 
		{
			booksByYear.putIfAbsent(currentBook.getYear(), new ArrayList<>());
			booksByYear.get(currentBook.getYear()).add(currentBook);

			for(Map.Entry<Integer, List<Book>> entry : booksByYear.entrySet()) 
			{
				System.out.println("\nYear: " + entry.getKey());
				for (Book book : entry.getValue()) {
					System.out.println(book);
				}
			}
		}

		System.out.println();

		// Step 5: Sort by author then title
		System.out.println("Sort by Author then title");
		books.sort(Comparator.comparing(Book::getAuthor).thenComparing(Book::getTitle));
		for(Book currentBook1 : books)
		{
			System.out.println(currentBook1);
		}
		
		System.out.println();
		
		// Step 6: Add Queue for signing out books
        Queue<Book> signOutQueue = new LinkedList<>();

        // Simulate students requesting to sign out books
        signOutQueue.add(bookInventory.get(0)); // Unmasking AI
        signOutQueue.add(bookInventory.get(2)); // Weapons of Math Destruction
        
        System.out.println(); 
        
        System.out.println("Sign-out queue:");
        for (Book currentBook1 : signOutQueue) 
        {
            System.out.println(currentBook1);
        }

        System.out.println();

        // Step 7: Process the sign-out queue
        System.out.println("Processing sign-outs:");
        while(!signOutQueue.isEmpty()) 
        {
        	System.out.println("Signed-out:" + signOutQueue.remove());
        }
        
        //Step 8: Search by author
        System.out.println("\nSearching for books by Hannah Fry:");
        List<Book> searchBooksResult = findBooksByAuthor(bookInventory, "Hannah Fry");
        printBooks(searchBooksResult, "Hannah Fry", -1);
        
        //Step 9: search books by author and year
        //create a method that
        List<Book> foundBooks = findBooks(bookInventory, "Hannah Fry", 2018);
        printBooks(foundBooks, "Hannah Fry", 2018);
        
        //Step 10: Use a HashMap to organize books by title L020, it adds one more node to the linked list 
        // you can't modify a linked list inside a hash map
        System.out.println("\nStep 10 HashMap of books by title");
        
        Map<String, Book>bookMapByTitle = new HashMap<>();
        for(Book book : bookInventory) 
        {
        	bookMapByTitle.put(book.getTitle(), book); // key= title, value = book
        }
        
        String searchTitle= "Hello World";
        if(bookMapByTitle.containsKey(searchTitle)) {
        	System.out.println("Found book:\n" + bookMapByTitle.get(searchTitle));
        } else {
        	System.out.println("Book not Found:" + searchTitle);
        }
	}

	public static List<Book> findBooksByAuthor(List<Book> inventory, String author) {
	    List<Book> results = new ArrayList<>();
	    for (Book currentBook : inventory) {
	        if (currentBook.getAuthor().equalsIgnoreCase(author)) {
	            results.add(currentBook);
	        }
	    }
	    return results;
	}
	
	public static List<Book> findBooks(List<Book> inventory, String author, int year) {
	    List<Book> results = new ArrayList<>();

	    return results;
	}
	
	public static void printBooks(List<Book> books, String author, int year) {
	    String label;
	    if (year != -1) {
	        label = " in " + year;
	    } else {
	        label = "";
	    }

	    if (books.isEmpty()) {
	        System.out.println("\nNo books found by " + author + label + ".");
	    } else {
	        System.out.println("\nBooks by " + author + label + ":");
	        for (Book currentBook : books) {
	            System.out.println(currentBook);
	        }
	    }
	}


	
	
}

class Book
{
	private String title;
	private String author;
	private int year;

	public Book(String title, String author, int year)
	{
		this.title = title;
		this.author = author;
		this.year = year;
	}

	public String getTitle()
	{
		return title;
	}

	public String getAuthor()
	{
		return author;
	}

	public int getYear()
	{
		return year;
	}

	public String toString()
	{
		return title + " by " + author + " (" + year + ")";
	}
}
