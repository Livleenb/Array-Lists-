package proj4sp17;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 * <p>Title: The Project 4 Application Class</p>
 *
 * <p>Description: This class will be responsible for showing the analysis and the dataset.
 * This class will display a menu for the user to choose which analysis they would like to see.
 *  The appropriate methods will be called to display the analysis of the dataset. I am showing the
 *  dataset itself in the console and the analysis through the jOptionPane.</p>
 *
 * @author Livleen Bhullar, got help from a youtube video on how to spilt data for the info I needed
 */

public class Proj4App {
	public static void main (String[]args)
	{
		String fileName = "DOE_High_School_Directory_2016.csv";
		File file = new File(fileName);
		String[] schoolNames = new String[438];
		String[] tempSchoolNames = new String[438];
		String[] city = new String[438];
		String[] grade = new String[438];
		//these will store the data from start to finish that is parsed
		String[] tempCity = new String[438];
		String[] tempGradeSpan = new String[438];
		String[] sharedSpace = new String[438];
		String[] tempShared = new String[438];

		//had a count variable to make sure it was parsing 438 times
		//since my data had that many rows
		//int count = 0;
		int i = 0;
		try
		{
			//scanning in dataset
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext())
			{
				//spliting data for the info i need 
				String data = scanner.nextLine();
				schoolNames = data.split(",");
				city = data.split(",");
				grade = data.split(",");
				sharedSpace = data.split(",");
				//count++;
				//count just to make sure 438 times its parsed
				//System.out.println("****COUNT*****" + count);
				//System.out.println(schoolNames[1] + "**");
				//System.out.println(city[2] + "");
				//System.out.println(phoneNum[5] + "");
				//System.out.println("\n");
				//System.out.println(data + "***");
				//wanted arrays to keep track of all the data for each category
				tempGradeSpan[i] = grade[8];
				tempCity[i] = city[2];
				tempSchoolNames[i] = schoolNames[1];
				tempShared[i] = sharedSpace[4];
				i++;
			}
			scanner.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("FileNotFoundException");
		}

		ArrayUnorderedList<Item> item = new ArrayUnorderedList<Item>();
		//testing some methods from item class 
		//Item item1 = new Item();
		//item1.setCity(tempCity[123]);
		//item1.setPhoneNum(phoneNum[5]);
		//item1.setSchoolName(schoolNames[1]);
		//System.out.println("Testing toString Method" + item1.toString());
		//item.addToFront(item1);
		//System.out.println(item1);
		//Item item1 = new Item();
		//item1 = new Item (tempCity[1], tempSchoolNames[1], tempGradeSpan[k], tempShared[k]);
		//item.addToFront(item1);
		//System.out.println(item);

		//adding item objects to arrayunorderedlist
		for(int k = 1; k < 438; k++)
		{
			Item item1 = new Item();
			item1 = new Item (tempCity[k], tempSchoolNames[k], tempGradeSpan[k], tempShared[k]);
			item.addToRear(item1);
		}
		//showing the dataset in the console & analysis in jOptionPane 
		System.out.println(item);
		Item item2 = new Item();
		int choice = 0; 
		while(choice !=3)
		{
			String[] choices = {"How many schools are located in each city?",
					"How many schools start with grade 6 vs. grade 9?","How many schools have shared space?",
			"Quit"};
			choice = JOptionPane.showOptionDialog(null, "Which analysis would you like to see of this data set?",
					"Main Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
					null, choices, choices[0]);

			if(choice == 0)
			{
				JOptionPane.showMessageDialog(null,"Results: " + item2.cities(tempCity), 
						"Display Value",  JOptionPane.INFORMATION_MESSAGE);
			}
			if(choice == 1)
			{
				JOptionPane.showMessageDialog(null,"Results: " + item2.gradeStart(tempGradeSpan), 
						"Display Value",  JOptionPane.INFORMATION_MESSAGE);
			}
			if(choice == 2)
			{
				JOptionPane.showMessageDialog(null,"Results: " + item2.sharedSpace(tempShared), 
						"Display Value",  JOptionPane.INFORMATION_MESSAGE);
			}
			else 
				choice = 3;
		}
		//testing first analysis
		// how many cities have how many schools
		//analysis ONE 
		//System.out.println("\n" + item2.cities(tempCity));


		//testing second analysis
		//analysis TWO
		//how many schools start with grade 9 vs. how many start with grade 6 ?
		//System.out.println("\n" + item2.gradeStart(tempGradeSpan));

		//testing third analysis
		//analysis three
		//how many schools have shared space?
		//System.out.println("\n" + item2.sharedSpace(tempShared));
	}
}