import shapes.Square;

import java.util.ArrayList;
import java.util.HashMap;

public class CollectionsLecture {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4};
        ArrayList<Integer> collectionOfNums = new ArrayList<>();
        collectionOfNums.add(16);
        collectionOfNums.add(44);
        collectionOfNums.add(32);
        collectionOfNums.add(1,24);

        for(int i = 0; i < collectionOfNums.size(); i++) {
            System.out.println(collectionOfNums.get(i));
        }

        for (Integer collectionOfNum : collectionOfNums) {
            System.out.println(collectionOfNum);
        }

        System.out.println(numbers);
        System.out.println(collectionOfNums);

        System.out.println(collectionOfNums.contains(44));
        System.out.println(collectionOfNums.indexOf(44));
        System.out.println(collectionOfNums.lastIndexOf(44));
        ArrayList<String> studentNames = new ArrayList<>();
        if (studentNames.isEmpty()) {
            System.out.println("Let's fill in the list of Student names.");
        }

        boolean resultOfRemove = studentNames.remove("Beatrice");
        System.out.println(resultOfRemove);

        System.out.println(collectionOfNums);
        collectionOfNums.remove((Integer) 44);
        System.out.println(collectionOfNums);

        ArrayList<Double> collectionOfDoubles = new ArrayList<>();
        collectionOfDoubles.add(3.14);
        collectionOfDoubles.add(56.0);
        collectionOfDoubles.add(7.777777);
        collectionOfDoubles.add((double) 2);

        System.out.println(collectionOfDoubles);
        collectionOfDoubles.remove(2.0);
        System.out.println(collectionOfDoubles);

        ArrayList stuff = new ArrayList();
        stuff.add("Beatrice");
        stuff.add(13);
        stuff.add(new Square(5));

        for (Object thing : stuff) {
            System.out.println(thing);
        }

        System.out.println(stuff.get(2));
//        System.out.println((Square)stuff.get(2).getArea());

        System.out.println(collectionOfNums);
        collectionOfNums.set(2, 88);
        System.out.println(collectionOfNums);

        System.out.println("//////////");

        HashMap<Character, Square> squares = new HashMap<>();
        squares.put('A', new Square(5));
        squares.put('B', new Square(10));
        Square sq = new Square(3);
        squares.put('D', sq);
        squares.putIfAbsent('D', new Square(9));
        squares.putIfAbsent('Q', sq);
        System.out.println(squares.get('A').getArea());
//        System.out.println(squares.get('C').getArea());
        System.out.println(
                squares
                        .getOrDefault('B', new Square(0))
                        .getArea()
        );
        System.out.println(squares.containsKey('B'));
        System.out.println(squares.containsValue(new Square(5)));
        System.out.println(squares.containsValue(sq));
        System.out.println(sq);
        System.out.println(squares.get('Q'));
        squares.remove('Q');
        System.out.println(squares.get('Q'));
        squares.remove('C', sq);
        System.out.println(squares.containsValue(sq));
        squares.replace('D', new Square(4));
        System.out.println(sq.getArea());
        System.out.println(squares.get('D').getArea());
        squares.replace('E', new Square(15));
//        System.out.println(squares.get('E').getArea());
        squares.clear();
        System.out.println(squares.size());
        System.out.println(squares.isEmpty());
    }

}
