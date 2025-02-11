package com.gamewerks.blocky.engine;

public enum PieceKind {
    I,
    J,
    L,
    O,
    S,
    T,
    Z;
    
    public static final PieceKind[] ALL = { I, J, L, O, S, T, Z };
    
    /**
     * Shuffle the array using the Fisher-Yates method
     * 
     * @param array 
     */
    public static void shuffleArray(PieceKind[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = i % (i + 1); 
            
            PieceKind temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
