public class Main {
    //static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        AFile prueba = new Unzipped("Fileproves\\probing");

        FileManagement File_Controller = new FileManagement(prueba.file);

        File_Controller.Write_Content("Pupusa");

        prueba.setContent(File_Controller.Read_Content());

        System.out.println(prueba.getContent());

    }
}