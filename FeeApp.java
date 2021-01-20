import java.util.Scanner;

import java.util.Iterator;
import java.util.List;
import java.util.*;



    public class FeeApp
    {

        private static Scanner sc = new Scanner(System.in);
        private static StudentModelInt model = new StudentModelImpl();
        private static FeeUtility util = new FeeUtility();

        public static void main(String[] args) {
            int ch = 0;
            boolean b = true;
            while (b) {
                util.header();
                ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        add();
                        break;
                    case 2:
                        viewAll();
                        break;
                    case 3:
                        findById();
                        break;
                    case 4:
                        deleteRecord();
                        break;
                    default:
                        break;
                }
            }
            System.out.println("\n");
        }

        private static void findById() {
            System.out.println("Enter Student Id");
            long id = sc.nextLong();
            Student bean=model.findById(id);
            if (bean == null) {
                System.out.println("Invalid Id");
            } else {
                System.out.println(
                        "|  Id  |     Name     |        EmailId       |    MobileNo    |  Gender  |     Dob    |       Address     |     Course Name  |    Price   |  Pay Amount  |  Due    |");
                System.out.println("|  " + bean.getId() + " | " + bean.getName() + "    |   " + bean.getEmail()
                        + "   |   " + bean.getMobileNo() + "   |   " + bean.getGender() + "  |   " + bean.getDob()
                        + "  |    " + bean.getAddress() + "           |       " + bean.getCourseName() + "      |     "
                        + bean.getPrice() + "        |  " + bean.getTotalPrice() + "         |  " + bean.getDue()
                        + "  |");
            }
        }

        private static void viewAll() {
            List<Student> list = model.list();
            if (list == null && list.size() == 0) {
                System.out.println("Record Not Found");
            } else {
                Iterator<Student> it = list.iterator();
                System.out.println(
                        "|  Id  |     Name     |        EmailId       |    MobileNo    |  Gender  |     Dob    |       Address     |     Course Name  |    Price   |  Pay Amount  |  Due    |");
                while (it.hasNext()) {
                    Student bean = (Student) it.next();
                    System.out.println("|  " + bean.getId() + " | " + bean.getName() + "    |   " + bean.getEmail()
                            + "   |   " + bean.getMobileNo() + "   |   " + bean.getGender() + "  |   " + bean.getDob()
                            + "  |    " + bean.getAddress() + "           |       " + bean.getCourseName() + "      |     "
                            + bean.getPrice() + "        |  " + bean.getTotalPrice() + "         |  " + bean.getDue()
                            + "  |");
                }
            }
        }

        private static void deleteRecord() {
            System.out.println("Enter Student Id");
            long id = sc.nextLong();
            if (model.findById(id) == null) {
                System.out.println("Invalid Id");
            } else {
                model.delete(id);
                util.getSuccessDelete();
            }
        }

        private static void add() {
            Student bean = null;
            bean = selectFaculty();
            System.out.println("Enter Studnet Detail :");
            System.out.println("|--------------------------------------------------------------------|");
            System.out.println("Enter Id :");
            bean.setId(sc.nextLong());
            System.out.println("Enter Name :");
            bean.setName(sc.next());
            System.out.println("Enter Email Id :");
            bean.setEmail(sc.next());
            System.out.println("Enter Mobile No. :");
            bean.setMobileNo(sc.next());
            System.out.println("Enter Gender :");
            bean.setGender(sc.next());
            System.out.println("Enter Date of Birth");
            bean.setDob(sc.next());
            System.out.println("Enter Address");
            bean.setAddress(sc.next());
            System.out.println("Enter Pay Amount");
            bean.setTotalPrice(sc.next());
            bean.setDue(String.valueOf(Long.parseLong(bean.getPrice()) - Long.parseLong(bean.getTotalPrice())));
            model.add(bean);
            util.getSuccess();

            util.getStudnetDetail(bean);
        }

        private static Student selectFaculty() {
            Student bean = null;
            int ch = 0;
            util.getFaculty();
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    bean = selectFaculty1Course();
                    break;

                case 2:
                    bean = selectFaculty2Course();
                    break;
                default:
                    System.out.println("Select at least one");
                    selectFaculty();
                    break;
            }
            return bean;
        }

        private static Student selectFaculty1Course() {
            Student bean = new Student();
            int ch = 0;
            util.getFaculty1Course();
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    bean.setCourseName("C");
                    bean.setPrice("3000");
                    break;
                case 2:
                    bean.setCourseName("C++");
                    bean.setPrice("2000");
                    break;
                case 3:
                    bean.setCourseName("Core Java");
                    bean.setPrice("4500");
                    break;
                case 4:
                    bean.setCourseName("Advance Java");
                    bean.setPrice("4000");
                    break;
                default:
                    System.out.println("Select at least one");
                    selectFaculty1Course();
                    break;
            }
            return bean;
        }

        private static Student selectFaculty2Course() {
            Student bean = new Student();
            int ch = 0;
            util.getFaculty2Course();
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    bean.setCourseName("Pythone");
                    bean.setPrice("5000");
                    break;
                case 2:
                    bean.setCourseName("Machine learning");
                    bean.setPrice("4000");
                    break;
                default:
                    System.out.println("Select at least one");
                    selectFaculty2Course();
                    break;
            }
            return bean;
        }
    }








}
