public class BirdShelterWithACrookedSecurityGuard extends BirdShelter {
    // this will not work because the method in the superclass is final
//    public void securityProcedures(){
//        camerasOn = false;
//        guardsAlert = false;
//        alarmsArmed = false;
//    }

    public void securityProcedures(String guardName, int duration){
        camerasOn = false;
        guardsAlert = false;
        alarmsArmed = false;
    }
}
