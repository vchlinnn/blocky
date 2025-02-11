package com.gamewerks.blocky.engine;

import java.io.IOException;
import java.util.HashMap;

import com.gamewerks.blocky.util.Loader;
import com.gamewerks.blocky.util.Position;

public class Piece {
    
    private static HashMap ROTATION_DATA = null;
    
    static {
        try {
            ROTATION_DATA = Loader.loadAllRotationData();
        } catch (IOException ex) {
            System.out.println("Exception occurred loading rotation data");
            System.exit(-1);
        }
    }
    
    private PieceKind kind;
    private int orientation;
    private Position pos;
    private static PieceKind[] pieceArray = new PieceKind[PieceKind.ALL.length]; 
    private static int currentIndex = 0; 
    
    /**
     * Copy elements from ALL into pieceArray
     */
    static {
        for (int i = 0; i < PieceKind.ALL.length; i++) {
            pieceArray[i] = PieceKind.ALL[i];
        }
        PieceKind.shuffleArray(pieceArray); 
    }
    
    public Piece(PieceKind kind, Position pos) {
        this.kind = getNextPieceKind();
        orientation = 0;
        this.pos = pos;
    }
    
    /**
     * 
     * @return kind
     */
    public PieceKind getKind() {
        return kind;
    }

    /**
     * If all pieces are used, reshuffle and reset index
     * 
     * @return the current piece and move to the next one
     */
    private static PieceKind getNextPieceKind() {
        if (currentIndex >= pieceArray.length) {
            PieceKind.shuffleArray(pieceArray);
            currentIndex = 0;
        }

        return pieceArray[currentIndex++];
    }
    
    public Position getPosition() {
        return pos;
    }
    
    public void moveTo(Position p) {
        pos = p;
    }
    
    public boolean[][] getLayout() {
        return ((boolean[][][]) ROTATION_DATA.get(kind))[orientation];
    }
    
    public void rotate(boolean dir) {
        if (dir) {
            orientation = (orientation + 1) % 4;
        } else {
            int k = orientation - 1;
            orientation = k < 0 ? 3 : k;
        }
    }
}
