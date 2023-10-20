// Geometry Program

import java.util.Scanner;
class Point{
    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    // Calaculate distance between two points
    public double distance_btw_pts(Point pt_2) {
        double diff_x = Math.abs(x - pt_2.x);
        double diff_y = Math.abs(y - pt_2.y);
        return Math.sqrt((diff_x * diff_x) + (diff_y * diff_y));
    }

}

class Triangle {
    private Point[] vertices;
    public Triangle(Point pt_1, Point pt_2, Point pt_3) {
        vertices = new Point[]{pt_1, pt_2, pt_3};
    }

    // Calculate perimeter of the triangle
    public double calculate_perimeter() {
        double side_dist_1 = vertices[0].distance_btw_pts(vertices[1]);
        double side_dist_2 = vertices[0].distance_btw_pts(vertices[2]);
        double side_dist_3 = vertices[1].distance_btw_pts(vertices[2]);
        return side_dist_1 + side_dist_2 + side_dist_3;
    }

    // Check whether given triangle is isosceles triangle
    public boolean  is_isosceles_triangle(){
        double side_dist_1 = vertices[0].distance_btw_pts(vertices[1]);
        double side_dist_2 = vertices[0].distance_btw_pts(vertices[2]);
        double side_dist_3 = vertices[1].distance_btw_pts(vertices[2]);
        boolean is_isosceles_flag = false;
        if ((side_dist_1 == side_dist_2) || (side_dist_1 == side_dist_3) || (side_dist_2 == side_dist_3)){
            is_isosceles_flag = true;
        }
        return is_isosceles_flag;
    }

    // Check whether given point is inside or outside the triangle
    public boolean is_inside_triangle(Point check_point){
        boolean is_inside_triangle_flag = false;

        return is_inside_triangle_flag;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of triangles you would like to check perimeter (n): ");
        int no_of_triangles = scanner.nextInt();
        for(int i=0; i<no_of_triangles;i++){

            Point pt_1 = user_point();
            Point pt_2 = user_point();
            Point pt_3 = user_point();

            Triangle t = new Triangle(pt_1,pt_2,pt_3);
            double perimeter = t.calculate_perimeter();
            System.out.println("Perimeter: "+ perimeter);

            boolean is_isosceles_flag = t.is_isosceles_triangle();
            if (is_isosceles_flag){
                System.out.print("The triangle is isosceles");
            }
            else{
                System.out.print("The triangle is not isosceles");
            }
        }

    }

    public static Point user_point(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Construction of a new point Please enter x: ");
        double x = scanner.nextDouble();
        System.out.print("Please enter y: ");
        double y = scanner.nextDouble();
        Point pt = new Point(x,y);
        return pt;
    }
}