public class Main {
    //static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        Unzipped prueba = new Unzipped("Fileproves\\probing");

        FileManagement File_Controller = new FileManagement(prueba.file);

        System.out.println(prueba.getContent());

        prueba.getReps();

    }
}