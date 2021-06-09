public class ExceptionsStudyTest {
    public static void main(String[] args) {

//       try {
//           ExceptionsStudy study = new ExceptionsStudy();
//           System.out.println(Integer.parseInt(study.maybeAnInteger));
//           System.out.println(Integer.parseInt(study.definitelyNotAnInteger));
//       } catch (NumberFormatException nfe){
//           nfe.printStackTrace();
//       }
        ExceptionsStudy study = new ExceptionsStudy();
//        study.askForAnInteger();
//        study.aMoreComplexAskForInteger();
//        try {
//            study.echoWord();
//        } catch (IllegalArgumentException iae){
//            System.out.println("How rude!");
//        }

        try {
            study.echoWordCustomEx();
        } catch (CusswordException ce){
            System.out.println("How rude!");
            System.out.println(ce.getMessage());
        }

    }
}
