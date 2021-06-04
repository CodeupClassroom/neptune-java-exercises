public class BirdShelter {
    public void shelterSounds(Bird[] birdsOfTheShelter){
        for(int i = 0; i < birdsOfTheShelter.length; i++){
            birdsOfTheShelter[i].makeNoise();
        }
    }

    boolean camerasOn;
    boolean alarmsArmed;
    boolean guardsAlert;
    // this method cannot be overridden because it is marked final
    public final void securityProcedures(){
        camerasOn = true;
        guardsAlert = true;
        alarmsArmed = true;
    }
}
