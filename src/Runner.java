import java.io.*;

public class Runner {
    public static void main(String[] args) {
//        Person tom = new Person("Tom", "Johns", 40, false);
//        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("tom.txt"))) {
//            dos.writeUTF(tom.getFirstName());
//            dos.writeUTF(tom.getLastName());
//            dos.writeInt(tom.getAge());
//            dos.writeBoolean(tom.isStudent());
//            System.out.println("File has been written");
//        } catch (IOException ex) {
//            System.out.println(ex.getStackTrace());
//        }
//
//        try (DataInputStream dis = new DataInputStream(new FileInputStream("tom.txt"))) {
//
//            String name = dis.readUTF();
//            String lastName = dis.readUTF();
//            int age = dis.readInt();
//            boolean isStudent = dis.readBoolean();
//
//            Person person = new Person(name, lastName, age, isStudent);
//
//            System.out.println(person);
//
//        } catch (IOException ex) {
//            System.out.println(ex.getStackTrace());
//        }
//    }
        //Person ivan = new Person("Ivan", "Petrov", 2, true);
        String fileName = "ivan.txt";
        //writePersonToFile(ivan, fileName);

        Person personFromFile = readPersonToFile(fileName);
        System.out.println(personFromFile);
    }

    public static void writePersonToFile(Person person, String FileName) {
        try (FileOutputStream fos = new FileOutputStream(FileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(person);
        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }

    public static Person readPersonToFile(String fileName) {
        Person p = null;
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream oin = new ObjectInputStream(fis)) {
            p = (Person) oin.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return p;
    }
}