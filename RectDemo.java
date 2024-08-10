/*
Define a MyRectangle class with four public data members representing the x- and y-coordinates of the bottom-left vertex
and top-right vertex of a rectangle, whose sides are parallel to the x- or y-axis.
For example, the statement new MyRectangle (20, 80, 30, 90) creates a rectangle with bottom-left vertex at position (20, 80),
and top-right vertex at (30, 90).
a. Write an area () method, which computes the area of a rectangle.
b. Write MySquare.java, MySquare extends MyRectangle. A square is defined by its bottom-left vertex and the length of its side.
Complete the super (. . .) statement in the constructor.
c. Below is output of MySquare.java program when the user enters: 10 30 5.
Class MySquare: [(10,30); (15,35)] 
Area = 25
Override toString () method in MyRectangle in order to get such output.

Sample IO:
----------
Enter bottom left and top right coordinates of the rectangle
20 80 30 90
Rectangle Area 100
Enter bottom left, top right and length of the square
10 30 5
Class MySquare: [(10, 30); (15, 35)]
Square Area: 25
*/
import java.util.*;

class MyRectangle {
    public int bottomLeftX;
    public int bottomLeftY;
    public int topRightX;
    public int topRightY;

    public MyRectangle(int x1, int y1, int x2, int y2) {
        bottomLeftX = x1;
        bottomLeftY = y1;
        topRightX = x2;
        topRightY = y2;
    }

    public int area() {
        int width = topRightX - bottomLeftX;
        int height = topRightY - bottomLeftY;
        return width * height;
    }

    public String toString() {
        return "[(" + bottomLeftX + ", " + bottomLeftY + "), (" + topRightX + ", " + topRightY + ")]";
    }

    public MyRectangle overlap(MyRectangle rect) {
        int overlapBottomLeftX = Math.max(this.bottomLeftX, rect.bottomLeftX);
        int overlapBottomLeftY = Math.max(this.bottomLeftY, rect.bottomLeftY);
        int overlapTopRightX = Math.min(this.topRightX, rect.topRightX);
        int overlapTopRightY = Math.min(this.topRightY, rect.topRightY);

        // Check if the rectangles overlap
        if (overlapBottomLeftX < overlapTopRightX && overlapBottomLeftY < overlapTopRightY) {
            return new MyRectangle(overlapBottomLeftX, overlapBottomLeftY, overlapTopRightX, overlapTopRightY);
        }
        else {
            // No overlap
            return new MyRectangle(0, 0, 0, 0);
        }
    }

    public static MyRectangle overlapAll(MyRectangle[] rectangles) {
        if (rectangles.length == 0) {
            return new MyRectangle(0, 0, 0, 0);
        }

        MyRectangle overlapRect = rectangles[0];
        for (int i = 1; i < rectangles.length; i++) {
            overlapRect = overlapRect.overlap(rectangles[i]);
            // If at any point the overlap region becomes empty, return (0,0)-(0,0)
            if (overlapRect.area() == 0) {
                return new MyRectangle(0, 0, 0, 0);
            }
        }
        return overlapRect;
    }
}

class MySquare extends MyRectangle {
    public MySquare(int x, int y, int sideLength) {
        super(x, y, x + sideLength, y + sideLength);
    }
}

class RectDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter bottom left and top right coordinates of the rectangle:");
        MyRectangle r1 = new MyRectangle(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
        System.out.println("Rectangle Area: " + r1.area());

        System.out.println("Enter bottom left and side length of the square:");
        MySquare sq = new MySquare(s.nextInt(), s.nextInt(), s.nextInt());
        System.out.println("Class MySquare: " + sq);
        System.out.println("Square Area: " + sq.area());

        System.out.println("Enter number of rectangles:");
        int n = s.nextInt();
        MyRectangle[] rectangles = new MyRectangle[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter bottom left and top right coordinates of rectangle " + (i + 1) + ":");
            rectangles[i] = new MyRectangle(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
        }

        MyRectangle overlapRect = MyRectangle.overlapAll(rectangles);
        System.out.println("Overlapped Rectangle: " + overlapRect);
        System.out.println("Overlapped Rectangle Area: " + overlapRect.area());
    }
}

