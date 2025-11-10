import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AgencyService agencyServiceImpl = new AgencyServiceImpl();

        boolean isTrue = true;
        while (isTrue) {
            System.out.println("""
                    MENU:
                    1) SOZDAT AGENTSTVO
                    2) NAITI AGENTSTVO PO ID
                    3) POKAZAT VSE AGENTSTVA
                    4) IZMENIT AGENTSTVO
                    5) UDALIT AGENTSTVO
                    6) VIITI
                    """);
            System.out.print("Viberite punkt: ");
            int san = sc.nextInt();
            sc.nextLine();

            switch (san) {
                case 1 -> {
                    System.out.print("Vvedite ID: ");
                    long id = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Vvedite nazvanie: ");
                    String name = sc.nextLine();

                    System.out.print("Vvedite Stranu: ");
                    String country = sc.nextLine();

                    System.out.print("Vvedite nomer telefona: ");
                    String phone = sc.nextLine();

                    System.out.print("Vvedite email: ");
                    String email = sc.nextLine();

                    System.out.println("VIBERITE AGENTSTVO");
                    for (AgencyType a:AgencyType.values()){
                        System.out.println(","+a);
                    }
                    String typeinput= sc.nextLine().toUpperCase();
                    AgencyType type = null;
                    try {
                        type=AgencyType.valueOf(typeinput);
                    }catch (IllegalArgumentException e){
                        System.out.println("NETU TAKOGO TYPA AGENSTVO");
                    }

                    Agency agency = new Agency(id, name, country, phone, email, AgencyType.VISA);
                    agencyServiceImpl.addAgency(agency);
                }

                case 2 -> {
                    System.out.print("Vvedite ID dlya poiska: ");
                    long id = sc.nextLong();
                    System.out.println(agencyServiceImpl.getAgencyById(id));
                }

                case 3 -> {
                    System.out.println(Arrays.toString( agencyServiceImpl.getAllAgency()));
                }

                case 4 -> {
                    System.out.print("Vvedite ID agentstva kotoroe hotite izmenit: ");
                    long id = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Novoe nazvanie: ");
                    String name = sc.nextLine();

                    System.out.print("Novyi Stranu: ");
                    String country = sc.nextLine();

                    System.out.print("Novyi telefon: ");
                    String phone = sc.nextLine();

                    System.out.print("Novyi email: ");
                    String email = sc.nextLine();

                    System.out.println("VIBERITE AGENTSTVO");
                    for (AgencyType a:AgencyType.values()){
                        System.out.println(","+a);
                    }
                    String typeinput= sc.nextLine().toUpperCase();
                    AgencyType type = null;
                    try {
                        type=AgencyType.valueOf(typeinput);
                    }catch (IllegalArgumentException e){
                        System.out.println("NETU TAKOGO TYPA AGENSTVO");
                    }


                    Agency updated = new Agency(id, name, country, phone, email,type);
                    agencyServiceImpl.updateAgency(id, updated);
                }

                case 5 -> {
                    System.out.print("Vvedite ID dlya udaleniya: ");
                    long id = sc.nextLong();
                    agencyServiceImpl.deleteAgency(id);
                }

                case 6 -> {

                    isTrue = false;
                }

                default -> System.out.println(" Nevernyi vibor");
            }

}
    }
}