package ra.presentation;

import ra.businessImp.Employee;

import java.util.*;

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagement employeeManagement = new EmployeeManagement();

        int choice;
        do {
            employeeManagement.displayMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự Enter sau nextInt

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng nhân viên (n): ");
                    int n = scanner.nextInt();
                    scanner.nextLine(); // Đọc ký tự Enter sau nextInt
                    employeeManagement.inputEmployeeData(scanner, n);
                    break;
                case 2:
                    employeeManagement.displayAllEmployees();
                    break;
                case 3:
                    employeeManagement.calculateSalaries();
                    System.out.println("Đã tính lương cho các nhân viên.");
                    break;
                case 4:
                    System.out.print("Nhập tên nhân viên cần tìm: ");
                    String name = scanner.nextLine();
                    employeeManagement.searchEmployeeByName(name);
                    break;
                case 5:
                    System.out.print("Nhập mã nhân viên cần cập nhật: ");
                    String updateId = scanner.nextLine();
                    employeeManagement.updateEmployee(scanner, updateId);
                    break;
                case 6:
                    System.out.print("Nhập mã nhân viên cần xóa: ");
                    String deleteId = scanner.nextLine();
                    employeeManagement.deleteEmployee(deleteId);
                    break;
                case 7:
                    employeeManagement.sortEmployeesSarary();
                    System.out.println("Đã sắp xếp theo lương nhân Viên tăng dần");
                case 8:
                    employeeManagement.sortEmployeesByNameDescending();
                    System.out.println("Đã sắp xếp theo tên giảm dần.");
                    break;
                case 9:
                    employeeManagement.sortEmployeesByBirthYearAscending();
                    System.out.println("Đã sắp xếp theo năm sinh tăng dần.");
                    break;
                case 10:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 10);

    }

    private static final int MAX_EMPLOYEES = 100;
    private List<Employee> employeeList;

    public EmployeeManagement() {
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void inputEmployeeData(Scanner scanner, int n) {
        for (int i = 0; i < n; i++) {
            Employee employee = new Employee();
            employee.inputData(scanner);
            addEmployee(employee);
        }
    }

    public void displayAllEmployees() {
        for (Employee employee : employeeList) {
            employee.displayData();
            System.out.println("----------------------");
        }
    }

    public void calculateSalaries() {
        for (Employee employee : employeeList) {
            employee.calSalary();
        }
    }

    public void searchEmployeeByName(String name) {
        for (Employee employee : employeeList) {
            if (employee.getName().equalsIgnoreCase(name)) {
                employee.displayData();
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên có tên: " + name);
    }

    public void updateEmployee(Scanner scanner, String id) {
        for (Employee employee : employeeList) {
            if (employee.getId().equalsIgnoreCase(id)) {
                System.out.println("Nhập thông tin cập nhật cho nhân viên có mã " + id + ":");
                employee.inputData(scanner);
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên có mã: " + id);
    }

    public void deleteEmployee(String id) {
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId().equalsIgnoreCase(id)) {
                iterator.remove();
                System.out.println("Xóa thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên có mã: " + id);
    }


    public void sortEmployeesSarary() {
        Collections.sort(employeeList, Comparator.comparing(Employee::getSalary));
    }

    public void sortEmployeesByNameDescending() {
        Collections.sort(employeeList, Comparator.comparing(Employee::getName).reversed());
    }

    public void sortEmployeesByBirthYearAscending() {
        Collections.sort(employeeList, Comparator.comparingInt(Employee::getYear));
    }

    public void displayMenu() {
        System.out.println("********************MENU*********************");
        System.out.println("1. Nhập thông tin cho n nhân viên");
        System.out.println("2. Hiển thị thông tin nhân viên");
        System.out.println("3. Tính lương cho các nhân viên");
        System.out.println("4. Tìm kiếm nhân viên theo tên nhân viên");
        System.out.println("5. Cập nhật thông tin nhân viên");
        System.out.println("6. Xóa nhân viên theo mã nhân viên");
        System.out.println("7. Sắp xếp nhân viên theo lương tăng dần (Comparable)");
        System.out.println("8. Sắp xếp nhân viên theo tên nhân viên giảm dần (Comparator)");
        System.out.println("9. Sắp xếp nhân viên theo năm sinh tăng dần (Comparator)");
        System.out.println("10. Thoát");
        System.out.println("*********************************************");
    }

}

