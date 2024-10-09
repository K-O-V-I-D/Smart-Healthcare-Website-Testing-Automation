import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Module {

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean correctDoc(String dep, String dname) throws IOException {
        String[][] s = {
            {"Chief", "Prof Palanivelu C|chief"},
            {"Obesity", "Dr Baby Narayanan|Obesity"},
            {"Surgical Gastro", "Dr Waseem Ahmed|SG"},
            {"Medical Gastro", "Dr. P Praveen Raj|MG"},
            {"Gynecology", "Dr Jayanth Leo XL|Gynecology"},
            {"Liver Transplant", "Dr S Asokan|LT"},
            {"Anaesthesiology", "Dr T K Rajesh|Anesthesiology"},
            {"Liver and multi-organ Transplant", "Dr S Srivatsasn Gurumurthy"},
            {"General Surgeon", "Dr Pinak DasGupta|GS"},
            {"General Surgeon", "Dr Ajay G Pai|GS"},
            {"Nephrology", "Dr Srinivasan Muthukrishnan|Nephrology"}
        };
        int l = s.length;
        for (int i = 0; i < l; i++) {
            if (dep.equals(s[i][0]) && dname.equals(s[i][1])) {
                return true;
            }
        }
        return false;
    }

    public static void check(String n, String age, String gender, String email, String pno, String city, String dep, String dname, String tarea) {
        try {
            if (n.equals("Name")) {
                throw new Exception("Enter name");
            }
            if (!(isNumeric(age))) {
                throw new Exception("Enter proper age");
            }
            if (gender.equals("Gender")) {
                throw new Exception("Select gender");
            }
            if (!(email.contains("@") && email.indexOf('@') != 0 && email.contains(".com"))) {
                throw new Exception("Invalid email");
            }
            if (!(isNumeric(pno) && pno.length() == 10)) {
                throw new Exception("Invalid phone number");
            }
            if (city.equals("City")) {
                throw new Exception("Select city");
            }
            if (dep.equals("Department")) {
                throw new Exception("Select department");
            }
            if (dname.equals("Select doctor")) {
                throw new Exception("Select doctor");
            }
            if (!(correctDoc(dep, dname))) {
                throw new Exception("Doctor and department do not match");
            }
            
            // Printing values
            System.out.println(n);
            System.out.println(age);
            System.out.println(gender);
            System.out.println(email);
            System.out.println(pno);
            System.out.println(city);
            System.out.println(dep);
            System.out.println(dname);
            System.out.println(tarea);

            // Writing to file
            FileWriter fw = new FileWriter("db.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(n + " " + age + " " + gender + " " + email + " " + pno + " " + city + " " + dep + " " + dname + " " + tarea);
            pw.close();
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter choice (1 for GUI, any other key for console):");
        char ch = sc.nextLine().charAt(0);

        if (ch == '1') {
            Module obj = new Module();
            JFrame J = new JFrame("Module");
            J.setLayout(new BorderLayout());
            J.setContentPane(new JLabel(new ImageIcon("D:/programming/java/a.png")));
            J.setLayout(new FlowLayout());

            JButton b = new JButton("Submit");
            JTextField f1 = new JTextField("Name");
            JTextField f2 = new JTextField("Age");
            String[] s3 = {"Gender", "Male", "Female"};
            JComboBox<String> f3 = new JComboBox<>(s3);
            JTextField f4 = new JTextField("Email");
            JTextField f5 = new JTextField("Phone number");
            String[] s6 = {"City", "Chennai", "Coimbatore"};
            JComboBox<String> f6 = new JComboBox<>(s6);
            String[] s7 = {
                "Department", "Chief", "Obesity", "Surgical Gastro", "Medical Gastro", "Gynecology",
                "Liver Transplant", "Anaesthesiology", "Liver and multi-organ Transplant", "General Surgeon", "Nephrology"
            };
            JComboBox<String> f7 = new JComboBox<>(s7);
            String[] s8 = {
                "Select doctor", "Prof Palanivelu C|chief", "Dr Baby Narayanan|Obesity",
                "Dr Waseem Ahmed|SG", "Dr. P Praveen Raj|MG", "Dr Jayanth Leo XL|Gynecology",
                "Dr S Asokan|LT", "Dr T K Rajesh|Anesthesiology", "Dr S Srivatsasn Gurumurthy",
                "Dr Pinak DasGupta|GS", "Dr Ajay G Pai|GS", "Dr Srinivasan Muthukrishnan|Nephrology"
            };
            JComboBox<String> f8 = new JComboBox<>(s8);
            JTextArea f9 = new JTextArea("Eg: Cold, Fever, Pain");

            // Setting bounds for components
            f1.setBounds(300, 200, 150, 30);
            f2.setBounds(500, 200, 150, 30);
            f3.setBounds(300, 250, 150, 30);
            f4.setBounds(500, 250, 150, 30);
            f5.setBounds(300, 300, 150, 30);
            f6.setBounds(500, 300, 150, 30);
            f7.setBounds(300, 350, 150, 30);
            f8.setBounds(500, 350, 250, 30);
            f9.setBounds(300, 400, 400, 90);
            b.setBounds(450, 500, 120, 20);

            // Adding components to the frame
            J.add(b);
            J.add(f1);
            J.add(f2);
            J.add(f3);
            J.add(f4);
            J.add(f5);
            J.add(f6);
            J.add(f7);
            J.add(f8);
            J.add(f9);

            J.setSize(800, 600);
            J.getContentPane().setLayout(null);
            J.setVisible(true);

            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String n = f1.getText();
                        String age = f2.getText();
                        String gender = (String) f3.getSelectedItem();
                        String email = f4.getText();
                        String pno = f5.getText();
                        String city = (String) f6.getSelectedItem();
                        String dep = (String) f7.getSelectedItem();
                        String dname = (String) f8.getSelectedItem();
                        String tarea = f9.getText();
                        check(n, age, gender, email, pno, city, dep, dname, tarea);
                    } catch (Exception f) {
                        System.out.println(f);
                    }
                }
            });
        } else {
            // Console input mode
            String n = sc.nextLine();
            String age = sc.nextLine();
            String gender = sc.nextLine();
            String email = sc.nextLine();
            String pno = sc.nextLine();
            String city = sc.nextLine();
            String dep = sc.nextLine();
            String dname = sc.nextLine();
            String tarea = sc.nextLine();
            check(n, age, gender, email, pno, city, dep, dname, tarea);
        }
    }
}
