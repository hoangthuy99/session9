package ra.businessImp;

import ra.business.IEmployee;

import java.util.Scanner;

public class Employee implements IEmployee {
    private String Id;
    private String Name;
    private int Year;
    private float Rate;
    private float Commission;
    private float Salary;
    private boolean Status;

    public Employee() {
    }

    public Employee(String id, String name, int year, float rate, float commission, float salary, boolean status) {
        Id = id;
        Name = name;
        Year = year;
        Rate = rate;
        Commission = commission;
        Salary = salary;
        Status = status;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public float getRate() {
        return Rate;
    }

    public void setRate(float rate) {
        Rate = rate;
    }

    public float getCommission() {
        return Commission;
    }

    public void setCommission(float commission) {
        Commission = commission;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float salary) {
        Salary = salary;
    }

    public boolean getStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        this.Status = status;
    }

    public boolean inputData(Scanner scanner) {
        System.out.print("Nhập mã nhân viên: ");
        this.Id = scanner.nextLine();

        System.out.print("Nhập tên nhân viên: ");
        this.Name = scanner.nextLine();

        System.out.print("Nhập năm sinh nhân viên: ");
        this.Year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập hệ số lương nhân viên: ");
        this.Rate = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Nhập hoa hồng hàng tháng của nhân viên: ");
        this.Commission = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Nhập trạng thái sản phẩm (true – Đang làm việc, false – Nghỉ việc): ");
        do {
            String Status = scanner.nextLine();
            if (Status.equals("true") || Status.equals("false")) {
                return Boolean.parseBoolean(Status);
            } else {
                System.err.println("Nhập sai vui lòng nhập lại");
            }
        } while (true);
    }

    public void calSalary() {
        this.Salary = this.Rate * BASIC_SALARY + this.Commission;
    }

    @Override
    public void displayData() {
        System.out.println("Mã nhân viên: " + this.Id);
        System.out.println("Tên nhân viên: " + this.Name);
        System.out.println("Năm sinh nhân viên: " + this.Year);
        System.out.println("Hệ số lương nhân viên: " + this.Rate);
        System.out.println("Hoa hồng hàng tháng của nhân viên: " + this.Commission);
        System.out.println("Lương nhân viên hàng tháng: " + this.Salary);
        System.out.println("Trạng thái nhân viên: " + (this.getStatus()));
    }


}
