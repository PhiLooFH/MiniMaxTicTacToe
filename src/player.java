public class player {
    private String Character;
    private boolean Ai;
    private int Marker;

    //self playing player
    public player(String Character) {
        this.Character = Character;
        this.Ai = false;
    }
    //Ai player
    public player(String Character, boolean Ai) {
        this.Character = Character;
        this.Ai = Ai;
    }

    private int getBestPossibleMove(int[] field) {
        return 0;
    }

    public String getCharacter() {
        return Character;
    }

    public boolean isAi() {
        return Ai;
    }

    public int getMarker() {
        return this.Marker;
    }

    public void setMarker(int marker) {
        Marker = marker;
    }
}
