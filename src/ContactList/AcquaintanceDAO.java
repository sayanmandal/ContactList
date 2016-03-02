package ContactList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class AcquaintanceDAO {
	
		static Scanner sc = new Scanner(System.in);
	
		static RandomAccessFile file;
		static RandomAccessFile file_1;
		static RandomAccessFile file_2;
		static RandomAccessFile file_3;
		
		static List<Relative> RelativeList = new ArrayList<Relative>();
		static List<PersonalFriend> PersonalFriendList = new ArrayList<PersonalFriend>();
		static List<ProfessionalFriend> ProfessionalFriendList = new ArrayList<ProfessionalFriend>();
		static List<CasualFriend> CasualFriendList = new ArrayList<CasualFriend>();
		
		AcquaintanceDAO() throws FileNotFoundException{
			file = new RandomAccessFile("RelativeData.txt","rw");
			file_1 = new RandomAccessFile("PersonalFriendData.txt","rw");
			file_2 = new RandomAccessFile("ProfessionalFriendData.txt","rw");
			file_3 = new RandomAccessFile("CasualFriendData.txt","rw");
		}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		
		

	}
	
	
	
	 @SuppressWarnings("unchecked")
	void read_from_relative() throws IOException, ClassNotFoundException{
		FileInputStream fin = new FileInputStream("RelativeData.txt");
		if(file.length()!=0){
			ObjectInputStream ois = new ObjectInputStream(fin);
			RelativeList = (ArrayList<Relative>)ois.readObject();
			ois.close();
		}
		fin.close();
	}
	
	@SuppressWarnings("unchecked")
	 void read_from_personal_friend() throws IOException, ClassNotFoundException{
		FileInputStream fin = new FileInputStream("PersonalFriendData.txt");
		if(file_1.length()!=0){
			ObjectInputStream ois = new ObjectInputStream(fin);
			PersonalFriendList = (ArrayList<PersonalFriend>)ois.readObject();
			ois.close();
		}
		fin.close();
	}
	
	@SuppressWarnings("unchecked")
	void read_from_professional_friend() throws IOException, ClassNotFoundException{
		FileInputStream fin = new FileInputStream("ProfessionalFriendData.txt");
		if(file_2.length()!=0){
			ObjectInputStream ois = new ObjectInputStream(fin);
			ProfessionalFriendList = (ArrayList<ProfessionalFriend>)ois.readObject();
			ois.close();
		}
		fin.close();
	}
	
	@SuppressWarnings("unchecked")
	void read_from_casual_friend() throws IOException, ClassNotFoundException{
		FileInputStream fin = new FileInputStream("CasualFriendData.txt");
		if(file_3.length()!=0){
			ObjectInputStream ois = new ObjectInputStream(fin);
			CasualFriendList = (ArrayList<CasualFriend>)ois.readObject();
			ois.close();
		}
		fin.close();
	}
	
	void write_to_relative() throws IOException{
		FileOutputStream fos = new FileOutputStream("RelativeData.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(RelativeList);
	}
	
	void write_to_personal_friend() throws IOException{
		FileOutputStream fos = new FileOutputStream("PersonalFriendData.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(PersonalFriendList);
	}
	
	void write_to_professional_friend() throws IOException{
		FileOutputStream fos = new FileOutputStream("ProfessionalFriendData.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(ProfessionalFriendList);
	}

	void write_to_casual_friend() throws IOException{
		FileOutputStream fos = new FileOutputStream("CasualFriendData.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(CasualFriendList);
	}
	
	void create_new_relative(Relative relative) throws IOException, ClassNotFoundException{
		read_from_relative();
		RelativeList.add(relative);
		write_to_relative();
	}
	
	void show_relatives(){
		System.out.println("Do you want to see the relatives?");
		if(sc.nextLine().toLowerCase().equals("yes")){
		if(RelativeList.size()==0){
			System.out.println("There is no relative in the database");
			return;
		}
		System.out.println("Following are your relatives::");
		Iterator<Relative> itr = RelativeList.iterator();
		while(itr.hasNext()){
			Relative relative = (Relative)itr.next();
			System.out.println(relative.getName()+"\t"+relative.getMobNumber()+"\t"+relative.getEmailaddress()+"\t"+relative.getBirthday()+"\t"+relative.getDateoflastmeeting());
			}
		}
	}
	
	void create_new_personal_friend(PersonalFriend personalfriend) throws IOException, ClassNotFoundException{
		read_from_personal_friend();
		PersonalFriendList.add((PersonalFriend) personalfriend);
		write_to_personal_friend();
	}
	
	void show_personal_friends(){
		System.out.println("Do you want to see the personal friends?");
		if(sc.nextLine().toLowerCase().equals("yes")){
			if(PersonalFriendList.size() == 0){
				System.out.println("No personal friend exist in the database");
				return;
			}
			System.out.println("Following are your personal friends::");
			Iterator<PersonalFriend> itr = PersonalFriendList.iterator();
			while(itr.hasNext()){
				PersonalFriend personalfriend = (PersonalFriend) itr.next();
				System.out.println(personalfriend.getName()+"\t"+personalfriend.getMobNumber()+"\t"+personalfriend.getEmailaddress()+"\t"+personalfriend.getContext()+"\t"+personalfriend.getDateofmeeting());
			}
		}
	}
	
	void create_new_professional_friend(ProfessionalFriend professionalfriend) throws IOException, ClassNotFoundException{
		read_from_professional_friend();
		ProfessionalFriendList.add((ProfessionalFriend) professionalfriend);
		write_to_professional_friend();
	}
	
	 void show_professional_friends(){
		System.out.println("Do you want to see the professional friends?");
		if(sc.nextLine().toLowerCase().equals("yes")){
			if(ProfessionalFriendList.size()==0){
				System.out.println("No professional friend exist in the database");
				return;
			}
			System.out.println("Following are your professional friends::");
			Iterator<ProfessionalFriend> itr = ProfessionalFriendList.iterator();
			while(itr.hasNext()){
				ProfessionalFriend friend = (ProfessionalFriend)itr.next();
				System.out.println(friend.getName()+"\t"+friend.getMobNumber()+"\t"+friend.getEmailaddress()+"\t"+friend.getCommonInterest());
			}
		}
	}
	
	
	void create_new_casual_friend(CasualFriend casualfriend) throws IOException, ClassNotFoundException{
		read_from_casual_friend();
		CasualFriendList.add((CasualFriend) casualfriend);
		write_to_casual_friend();
	}
	
	static void show_casual_friends(){
		System.out.println("Do you want to see the Casual friends?");
		if(sc.nextLine().toLowerCase().equals("yes")){
			if(CasualFriendList.size()==0){
				System.out.println("No casual friend exist in the database");
				return;
			}
			System.out.println("Following are your casual friends::");
			Iterator<CasualFriend> itr = CasualFriendList.iterator();
			while(itr.hasNext()){
				CasualFriend cazz = (CasualFriend) itr.next();
				System.out.println(cazz.getName()+"\t"+cazz.getMobNumber()+"\t"+cazz.getEmailaddress()+"\t"+cazz.getTimeofmeeting()+"\t"+cazz.getPlaceofmeeting()+"\t"+cazz.getCircumstanceofmeeting());
			}
		}
	}
	
	void show_all_acquaintances(){
		System.out.println("the following are your acquaintances::");
		Iterator itr = RelativeList.iterator();
		while(itr.hasNext()){
			Relative relative = (Relative)itr.next();
			System.out.println("RELATIVE\t"+relative.getName()+"\t"+relative.getMobNumber()+"\t"+relative.getEmailaddress());
		}
		
		itr = PersonalFriendList.iterator();
		while(itr.hasNext()){
			PersonalFriend personalfriend = (PersonalFriend)itr.next();
			System.out.println("PERSONAL FRIEND\t"+personalfriend.getName()+"\t"+personalfriend.getMobNumber()+"\t"+personalfriend.getEmailaddress());
		}
		
		itr = ProfessionalFriendList.iterator();
		while(itr.hasNext()){
			ProfessionalFriend professionalfriend = (ProfessionalFriend)itr.next();
			System.out.println("PROFESSIONAL FRIEND\t"+professionalfriend.getName()+"\t"+professionalfriend.getMobNumber()+"\t"+professionalfriend.getEmailaddress());
		}
		
		itr = CasualFriendList.iterator();
		while(itr.hasNext()){
			CasualFriend casualfriend = (CasualFriend)itr.next();
			System.out.println("CASUAL FRIEND\t"+casualfriend.getName()+"\t"+casualfriend.getMobNumber()+"\t"+casualfriend.getEmailaddress());
		}
	}
	
	
	void delete_relative(int i) throws IOException, ClassNotFoundException{
		read_from_relative();
		RelativeList.remove(i);
		write_to_relative();
	}
	
	void delete_personal_friend(int i) throws IOException, ClassNotFoundException{
		read_from_personal_friend();
		PersonalFriendList.remove(i);
		write_to_personal_friend();
	}
	
	void delete_professional_friend(int i) throws IOException, ClassNotFoundException{
		read_from_professional_friend();
		ProfessionalFriendList.remove(i);
		write_to_professional_friend();
	}
	
	void delete_casual_friend(int i) throws IOException, ClassNotFoundException{
		read_from_casual_friend();
		CasualFriendList.remove(i);
		write_to_casual_friend();
	}
	
	List<Relative> show_all_relatives() throws ClassNotFoundException, IOException{
		read_from_relative();
		List<Relative> templist = new ArrayList<Relative>();
		for(int i = 0 ; i < RelativeList.size() ; i++){
			templist.add(RelativeList.get(i));
		}
		return templist;
	}
	
	List<PersonalFriend> show_all_personal_friends() throws ClassNotFoundException, IOException{
		read_from_personal_friend();
		List<PersonalFriend> templist = new ArrayList<PersonalFriend>();
		for(int i = 0 ; i < PersonalFriendList.size() ; i++){
			templist.add(PersonalFriendList.get(i));
		}
		return templist;
	}
	
	List<ProfessionalFriend> show_all_professional_friends() throws ClassNotFoundException, IOException{
		read_from_professional_friend();
		List<ProfessionalFriend> templist = new ArrayList<ProfessionalFriend>();
		for(int i = 0 ; i < ProfessionalFriendList.size() ; i++){
			templist.add(ProfessionalFriendList.get(i));
		}
		return templist;
	}
	
	List<CasualFriend> show_all_casual_friends() throws ClassNotFoundException, IOException{
		read_from_casual_friend();
		List<CasualFriend> templist = new ArrayList<CasualFriend>();
		for(int i = 0 ; i < CasualFriendList.size() ; i++){
			templist.add(CasualFriendList.get(i));
		}
		return templist;
	}
	List<Relative> search_relative(String name) throws ClassNotFoundException, IOException{
		read_from_relative();
		List<Relative> templist = new ArrayList<Relative>();
		for(int i = 0 ; i < RelativeList.size() ; i++){
			if(RelativeList.get(i).getName().contains(name)){
				templist.add(RelativeList.get(i));
			}
		}
		return templist;
	}
	
	List<PersonalFriend> search_personal_friend(String name) throws ClassNotFoundException, IOException{
		read_from_personal_friend();
		List<PersonalFriend> templist = new ArrayList<PersonalFriend>();
		for(int i = 0 ; i < PersonalFriendList.size() ; i++){
			if(PersonalFriendList.get(i).getName().contains(name)){
				templist.add(PersonalFriendList.get(i));
			}
		}
		return templist;
	}
	
	List<ProfessionalFriend> search_professional_friend(String name) throws ClassNotFoundException, IOException{
		read_from_professional_friend();
		List<ProfessionalFriend> templist = new ArrayList<ProfessionalFriend>();
		for(int i = 0 ; i < ProfessionalFriendList.size() ; i++){
			if(ProfessionalFriendList.get(i).getName().contains(name)){
				templist.add(ProfessionalFriendList.get(i));
			}
		}
		return templist;
	}
	
	List<CasualFriend> search_casual_friend(String name) throws ClassNotFoundException, IOException{
		read_from_casual_friend();
		List<CasualFriend> templist = new ArrayList<CasualFriend>();
		for(int i = 0 ; i < CasualFriendList.size() ; i++){
			if(CasualFriendList.get(i).getName().contains(name)){
				templist.add(CasualFriendList.get(i));
			}
		}
		return templist;
	}
	
	void search_acquaintance(){
		System.out.println("Please give the name:");
		String name = sc.nextLine();
		if(DoesNotExistInDirectory(name)){
			System.out.println("The Name Doesn't exist in the directory");
			return;
		}
		for(int i = 0 ; i < RelativeList.size() ; i++){
			if(RelativeList.get(i).getName().equalsIgnoreCase(name)){
				Relative relative = RelativeList.get(i);
				System.out.println("Relative\t"+relative.getName()+"\t"+relative.getMobNumber()+"\t"+relative.getEmailaddress()+"\t"+relative.getBirthday()+"\t"+relative.getDateoflastmeeting());
			}
		}
		for(int i = 0 ; i < PersonalFriendList.size() ; i++){
			if(PersonalFriendList.get(i).getName().equalsIgnoreCase(name)){
				PersonalFriend personalfriend = PersonalFriendList.get(i);
				System.out.println("Personal Friend\t"+personalfriend.getName()+"\t"+personalfriend.getMobNumber()+"\t"+personalfriend.getEmailaddress()+"\t"+personalfriend.getContext()+"\t"+personalfriend.getDateofmeeting()+personalfriend.getContext());
			}
		}
		for(int i = 0 ; i < ProfessionalFriendList.size() ; i++){
			if(ProfessionalFriendList.get(i).getName().equalsIgnoreCase("yes")){
				ProfessionalFriend professionalfriend = ProfessionalFriendList.get(i);
				System.out.println("Professional Friend\t"+professionalfriend.getName()+"\t"+professionalfriend.getMobNumber()+"\t"+professionalfriend.getEmailaddress()+"\t"+professionalfriend.getCommonInterest());
			}
		}
		for(int i = 0 ; i < CasualFriendList.size() ; i++){
			if(CasualFriendList.get(i).getName().equalsIgnoreCase(name)){
				CasualFriend casualfriend = CasualFriendList.get(i);
				System.out.println(casualfriend.getName()+"\t"+casualfriend.getMobNumber()+"\t"+casualfriend.getEmailaddress()+"\t"+casualfriend.getTimeofmeeting()+"\t"+casualfriend.getPlaceofmeeting()+"\t"+casualfriend.getCircumstanceofmeeting());
			}
		}
	}
	
	boolean DoesNotExistInDirectory(String name){
		int count = 0;
		for(int i = 0 ; i < RelativeList.size() ; i++){
			if(RelativeList.get(i).getName().equalsIgnoreCase(name)){
				count++;
			}
		}
		for(int i = 0 ; i < PersonalFriendList.size() ; i++){
			if(PersonalFriendList.get(i).getName().equals(name)){
				count++;
			}
		}
		for(int i = 0 ; i < ProfessionalFriendList.size() ; i++){
			if(ProfessionalFriendList.get(i).getName().equalsIgnoreCase(name)){
				count++;
			}
		}
		for(int i = 0 ; i < CasualFriendList.size() ; i++){
			if(CasualFriendList.get(i).getName().equals("yes")){
				if(CasualFriendList.get(i).getName().equals(name)){
					count++;
				}
			}
		}
		if(count == 0){
			return true;
		}
		return false;
	}
}
