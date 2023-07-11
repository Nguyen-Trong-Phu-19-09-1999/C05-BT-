import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product product0 = new Product(1, "Nước", 7000, 16, "Sản phẩm số 1 ");
        Product product1 = new Product(2, "Bánh", 7000, 60, "Sản phẩm số 1 ");
        Product product2 = new Product(3, "Thốc lá", 17000, 12, "Sản phẩm số 1 ");
        Product product3 = new Product(4, "Xăng", 22000, 66, "Sản phẩm số 1 ");
        Product product4 = new Product(5, "Dầu", 30000, 86, "Sản phẩm số 1 ");
        Product[] array = {product0, product1, product2, product3, product4};
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("1. Tạo mới 1 sản phẩm mới");
            System.out.println("2. Sửa thông tin 1 sản phẩm");
            System.out.println("3. Xóa 1 sản phẩm");
            System.out.println("4. Hiển thị tất cả các sản phẩm");
            System.out.println("5. Hiển thị các sản phẩm có giá lớn nhất");
            System.out.println("6. Hiển thị các sản phẩm có giá nhỏ nhất");
            System.out.println("7. Hiển thị các sản phẩm có số lượng lớn nhất");
            System.out.println("8. Hiển thị các sản phẩm có số lượng nhỏ nhất");
            System.out.println("9. Tổng tiền hàng hiện có của tất cả sản phẩm");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Nhập số lượng muốn thêm");
                    int add = scanner.nextInt();
                    Product[] NewArray = new Product[5 + add];
                    int id = 5;
                    for (int i = 0; i < add; i++) {
                        id++;
                        scanner.nextLine();
                        System.out.println("Nhập Tên");
                        String newName = scanner.nextLine();

                        System.out.println("Nhập giá");
                        double newPrice = scanner.nextDouble();

                        System.out.println("Nhập số lương");
                        int newQuantity = scanner.nextInt();

                        System.out.println("Thông tin");
                        scanner.nextLine();
                        String newDescription = scanner.nextLine();

                        Product product6 = new Product(id, newName, newPrice, newQuantity, newDescription);
                        System.out.println(product6);
                    }
                    for (int i = 0; i < array.length; i++) {
                        NewArray[i] = array[i];
                    }
                    for (Product value : array) {
                        System.out.println(value);
                    }
                    break;
                case 2:
                    System.out.println("Nhập ID sản phẩm muốn sửa: ");
                    int edit = input.nextInt();
                    boolean flag1 = true;
                    for (int i = 0; i < array.length; i++) {
                        if (edit == array[i].getId()) {
                            flag1 = false;
                            System.out.println("ID: ");
                            array[i].setId(input.nextInt());
                            input.nextLine();
                            System.out.println("Name: ");
                            array[i].setName(input.nextLine());
                            System.out.println("Price: ");
                            array[i].setPrice(input.nextInt());
                            input.nextLine();
                            System.out.println("Quantity: ");
                            array[i].setQuantity(input.nextInt());
                            input.nextLine();
                            System.out.println("Description: ");
                            array[i].setDescription(input.nextLine());
                            System.out.println("Return: ");
                            System.out.println(array[i]);
                            break;
                        }
                    }
                    if (flag1) {
                        System.out.println("Không tìm thấy sản phẩm với ID : " + edit);
                    }
                    break;
                case 3:
                    System.out.println("Nhập ID sản phẩm muốn xóa: ");
                    int delete = input.nextInt();
                    boolean flag2 = true;
                    for (int i = 0; i < array.length; i++) {
                        if (delete == array[i].getId()) {
                            flag2 = false;
                            break;
                        }
                    }
                    if (flag2) {
                        System.out.println("Không tìm thấy sản phẩm với ID = " + delete);
                    }
                    else {
                        Product[] arr2 = new Product[array.length - 1];
                        int index = 0;
                        for (int i = 0; i < array.length; i++) {
                            if (delete != array[i].getId()) {
                                arr2[index] = array[i];
                                index++;
                            }
                        }
                        System.out.println("Hiển thị danh sách đã được xoá:");
                        for (int i = 0; i < arr2.length; i++) {
                            System.out.println(arr2[i]);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Hiển thị tất cả các sản phẩm : ");
                    for (int i = 0; i < array.length; i++) {
                        System.out.println(array[i]);
                    }
                    break;
                case 5:
                    double maxPrice = array[0].getPrice();
                    int index = 1;
                    for (int i = 0; i < array.length; i++) {
                        if(array[i].getPrice()>maxPrice) {
                            maxPrice = array[i].getPrice();
                            index =i+1;
                        }
                    }
                    System.out.println("Hiển thị sản phẩm có giá lớn nhất :");
                    System.out.println("ID : " +index + "; Số lượng "+ maxPrice);
                    break;
                case 6:
                    double minPrice = array[0].getPrice();
                    int index1 = 1;
                    for (int i = 0; i < array.length; i++) {
                        if(array[i].getPrice()>minPrice) {
                            minPrice = array[i].getPrice();
                            index1 =i+1;
                        }
                    }
                    System.out.println("Hiển thị sản phẩm có giá nhỏ nhất :");
                    System.out.println("ID : " +index1 + "; Số lượng "+ minPrice);
                    break;
                case 7:
                    double maxQuantity = array[0].getQuantity();
                    int index2 = 1;
                    for (int i = 0; i < array.length; i++) {
                        if(array[i].getPrice()>maxQuantity) {
                            maxQuantity = array[i].getQuantity();
                            index2 =i+1;
                        }
                    }
                    System.out.println("Hiển thị sản phẩm có số lượng lớn nhất :");
                    System.out.println("ID : " +index2 + "; Số lượng "+ maxQuantity);
                    break;
                case 8:
                    double minQuantity = array[0].getQuantity();
                    int index3 =1;
                    for (int i = 0; i < array.length; i++) {
                        if(array[i].getPrice()<minQuantity) {
                            minQuantity = array[i].getQuantity();
                            index3 =i+1;
                        }
                    }
                    System.out.println("Hiển thị sản phẩm có số lượng nhỏ nhất :");
                    System.out.println("ID : " + index3+ "; Số lượng " + minQuantity);
                    break;
                case 9:
                    int sum=0;
                    for (int i = 0; i < array.length; i++) {
                        sum+= array[i].getPrice()*array[i].getQuantity();
                    }
                    System.out.println("Tổng tiền hàng hiện có của tất cả sản phẩm : "+sum);
                    break;

            }

        }
    }
}
