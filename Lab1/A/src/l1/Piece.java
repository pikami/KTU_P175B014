/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l1;

/**
 *
 * @author pk
 */
public class Piece {
    private int[] parts;    // Stores both parts of the piece

    public Piece(int num)
    {
        parts = new int[2];
        parts[0] = num / 10;
        parts[1] = num % 10;
    }

    public int HasPart(int part)
    {
        for (int i = 0; i < 2; i++)
            if (parts[i] == part)
                return i;
        return -1;
    }

    public int GetPiece(boolean rotate)
    {
        if (rotate)
            return parts[0] + parts[1] * 10;
        return parts[0] * 10 + parts[1];
    }

    public static Piece[] StringToPieces(String input, int count)
    {
        Piece[] Pieces = new Piece[count];
        String[] pieceNumbers = input.split(" ");
        if (pieceNumbers.length != count)
            return null;
        for (int i = 0; i < count; i++)
            Pieces[i] = new Piece(Integer.parseInt(pieceNumbers[i]));
        return Pieces;
    }
}
