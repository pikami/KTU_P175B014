/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l1;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author pk
 */
public class L1 {
    /* Settings */
    public static int     PIECE_COUNT = 7;                  // Count of domino pieces
    public static String  INPUT_FILE  = "domino.txt";       // Input file (Dataset)
    public static boolean FOUND_CHAIN = false;

    public static void main(String[] args) {
        try {
            System.err.println("Working directory: " + System.getProperty("user.dir"));
            String pieceStr = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
            Piece[] Pieces = Piece.StringToPieces(pieceStr, PIECE_COUNT);    // Array of pieces
            /* Check input */
            if (Pieces == null || Pieces.length == 0)
            {
                System.out.println("Bad input.");
                return;
            }
            /* Start the search */
            PrintDataset(Pieces);
            StartSearch(Pieces);
            /* Output message if we didn't find any chains */
            if(!FOUND_CHAIN)
                System.out.println("No chains were found!");
        } catch (Exception e) {
            
        } 
    }
    
    public static void PrintDataset(Piece[] Pieces) {
        System.out.print("Dataset: ");
        for (int i = 0; i < PIECE_COUNT; i++)
            System.out.print((Pieces[i].GetPiece(false) < 10 ? "0" + Pieces[i].GetPiece(false) : Pieces[i].GetPiece(false)) + " ");
        System.out.println();
    }
    
    public static void StartSearch(Piece[] Pieces)
    {
        int[] UsedPieces = new int[PIECE_COUNT];      // Array that keeps track of used pieces
        int[] Chain = new int[PIECE_COUNT];           // Array that stores the current chain
        /* Make every piece unused */
        for (int i = 0; i < PIECE_COUNT; i++)
            UsedPieces[i] = 0;
        /* Start recursion search with all posible beginings */
        for (int i = 0; i < PIECE_COUNT; i++)
        {
            UsedPieces[i] = 1;
            // Rotated start
            Chain[0] = Pieces[i].GetPiece(true);
            MakeChain(Pieces, UsedPieces, Chain, 0);
            // Non-Rotated start
            Chain[0] = Pieces[i].GetPiece(false);
            MakeChain(Pieces, UsedPieces, Chain, 0);
            UsedPieces[i] = 0;
        }
    }
    
    public static void MakeChain(Piece[] Pieces, int[] Used, int[] Chain, int place)
    {
        int next = Chain[place] % 10;               // Next piece in chain
        for (int i = 0; i < PIECE_COUNT; i++)
        {
            if (Used[i] == 0)
            {
                int pieceIndex = Pieces[i].HasPart(next);
                if (pieceIndex != -1)
                {
                    if (place == PIECE_COUNT - 2)
                    {
                        Chain[place + 1] = Pieces[i].GetPiece(pieceIndex == 1);
                        PrintChain(Chain);
                    }
                    Used[i] = 1;
                    Chain[place + 1] = Pieces[i].GetPiece(pieceIndex == 1);
                    MakeChain(Pieces, Used, Chain, place + 1);
                    Used[i] = 0;
                }
            }
        }
    }
    
    public static void PrintChain(int[] Chain)
    {
        if(!FOUND_CHAIN) {
            FOUND_CHAIN = true;
            System.out.println("Found chains: ");
        }
        String chainStr = "";
        for (int i = 0; i < PIECE_COUNT; i++)
            chainStr += (Chain[i] < 10 ? "0" + Chain[i] : Chain[i]) + " ";
        System.out.println(chainStr);
    }
}