import java.util.Scanner;
public class DZ6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.print(sc.nextLine().replaceAll("o","0"));        №1
//        int n =0;
//        String str = sc.nextLine(), st = sc.nextLine();             №2
//        sc.close();
//        while (str.contains(st)) {
//            str = str.replaceFirst(st,"");
//            n++;
//        }
//        System.out.print(String.format("слово %s попадается %d раз(а)",st,n));
        String pal = sc.nextLine();
        sc.close();
        StringBuffer palRev = new StringBuffer(pal);
        palRev = palRev.reverse();
        if (!(pal.equalsIgnoreCase(palRev.toString()))){
            System.out.println("Не палиндром");
            System.out.println(palRev);
    }
        else { System.out.println("Палиндром");
    }
}
}