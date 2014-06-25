package com.example.tests;

import static com.example.tests.GroupDataGenerator.generateRandomString;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	enum months {January, February, March, April, May, June, July, September, October, November, December};
	
	public static void main(String[] args) throws IOException {
		if (args.length < 3){
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File " + file + " exists. Please delete it yourself. \n");
			return;
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)){
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format " + format);
		}

	}

	private static void saveContactsToXmlFile(List<ContactData> contacts,
			File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("Contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
		
	}

	private static void saveContactsToCsvFile (List<ContactData> contacts,
			File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getContactName() + "," + contact.getLastName() + "," + 
					contact.getFirstAddress() + "," + contact.getFirstHomePhone() + "," + 
					contact.getMobilePhone() + "," + contact.getWorkPhone() + "," + 
					contact.getEmail() + "," + contact.getSecondEmail() + "," + 
					contact.getYear() + "," + contact.getSecondAddress() + "," + 
					contact.getSecondHomePhone() + ",!\n");
		}
		writer.close();
		
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++) {
			ContactData contact = new ContactData()
			.withContactName(generateRandomString())
			.withLastName(generateRandomString())
			.withFirstAddress(generateRandomString())
			.withFirstHomePhone(generateRandomString())
			.withMobilePhone(generateRandomString())
			.withWorkPhone(generateRandomString())
			.withEmail(generateRandomString())
			.withSecondEmail(generateRandomString())
			.withBirthDay(generateRandomDay())
			.withBirthMonth(generateRandomMonth())
			.withBirthYear(generateRandomYear())
			.withSecondAddress(generateRandomString())
			.withSecondHomePhone(generateRandomString());
			
			list.add(contact);
		}
		return list;
	}
	
	public static String generateRandomMonth(){
		
		Random rnd = new Random();
		int month = rnd.nextInt(11);
		return months.values()[month].toString();
	}
	
	public static String generateRandomDay(){
		Random rnd = new Random();
		String day;
		int temp = rnd.nextInt(31);
		if (temp != 0)
			day = String.valueOf(temp);
		else
			day = "-";
		return day;
	}
	
	public static String generateRandomYear(){
		Random rnd = new Random();
		int number = rnd.nextInt(100)+1900;
		return String.valueOf(number);
	}

}
