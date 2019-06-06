package Model;

import java.util.ArrayList;

public class Snake {
    private int xPos;
    private int yPos;
    private HeadPart headPart;
    private ArrayList<BodyPart> bodyParts;

    public Snake() {
        headPart = new HeadPart(5, 5);
    }
}
