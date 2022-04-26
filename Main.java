import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;

class WrongStudentName extends Exception { }
class WrongStudentAge extends Exception { }
class WrongStudentDate extends Exception { }
class WrongChoice extends Exception { }


class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            try {
                int ex = Readmenu();
                switch(ex) {
                    case 1: exercise1(); break;
                    case 2: exercise2(); break;
                    case 3: exercise3(); break;
                    default: return;
                }
            } catch(IOException e) {

            } catch(WrongStudentName e) {
                System.out.println("Błędne imie studenta!");
            }
					catch(WrongStudentAge e) {
                System.out.println("Błędny wiek studenta!");
            }
					catch(WrongStudentDate e) {
                System.out.println("Błędna data urodzenia studenta!");
            }
					catch(WrongChoice e) {
                System.out.println("Błędna data urodzenia studenta!");
            }
        }
    }

    //public static int menu() {
      //  System.out.println("Wciśnij:");
        //System.out.println("1 - aby dodać studenta");
        //System.out.println("2 - aby wypisać wszystkich studentów");
        //System.out.println("3 - aby wyszukać studenta po imieniu");
        //System.out.println("0 - aby wyjść z programu");
        //return scan.nextInt();
    //}

    public static String ReadName() throws WrongStudentName {
        scan.nextLine();
        System.out.println("Podaj imie: ");
        String name = scan.nextLine();
        if(name.contains(" "))
            throw new WrongStudentName();

        return name;
    }
		public static int ReadAge() throws WrongStudentAge {
       
        System.out.println("Podaj wiek: ");
        var age = scan.nextInt();  ///tu
				//scan.nextLine();
        if(age<0||age>100)
            throw new WrongStudentAge();

        return age;
    }
	public static String ReadDate() throws WrongStudentDate {
        scan.nextLine();
        System.out.println("Podaj datę urodzenia DD-MM-YYYY: ");
        var date = scan.nextLine();  ///tu
        if(date.length()>11||date.charAt(2)!='-'||date.charAt(5)!='-')
            throw new WrongStudentDate();

        return date;
    }
public static int ReadChoice() throws WrongChoice {
       // scan.nextLine();
       // System.out.println("Podaj wybór: ");
        int wybor = scan.nextInt();
        if(wybor<0)
            throw new WrongChoice();

        return wybor;
    }
	 public static int Readmenu() throws IOException,
	WrongChoice{
		 System.out.println("Wciśnij:");
		
		 
        System.out.println("1 - aby dodać studenta");
        System.out.println("2 - aby wypisać wszystkich studentów");
        System.out.println("3 - aby wyszukać studenta po imieniu");
        System.out.println("0 - aby wyjść z programu");
		 var wybor = ReadChoice();
       //return scan.nextInt();
		 return wybor;
		 
	}
	
    public static void exercise1() throws IOException, WrongStudentName,WrongStudentAge,WrongStudentDate {
        var name = ReadName();
        var age = ReadAge();
        var date = ReadDate();
        (new Service1()).addStudent(new Student(name, age, date));
    }

    public static void exercise2() throws IOException {
        var students = (new Service1()).getStudents();
        for(Student current : students) {
            System.out.println(current.ToString());
        }
    }

    public static void exercise3() throws IOException {
        scan.nextLine();
        System.out.println("Podaj imie: ");
        var name = scan.nextLine();
        var wanted = (new Service1()).findStudentByName(name);
        if(wanted == null)
            System.out.println("Nie znaleziono...");
        else {
            System.out.println("Znaleziono: ");
            System.out.println(wanted.ToString());
        }
    }
}