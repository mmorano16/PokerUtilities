import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardSearcherTest {
    private static Deck deck;
    private static Card temp;
    private static Card board[];
    private static Card C2, C3, C4, C5, C6, C7, C8, C9, C10, CJ, CQ, CK, CA;
    private static Card S2, S3, S4, S5, S6, S7, S8, S9, S10, SJ, SQ, SK, SA;
    private static Card D2, D3, D4, D5, D6, D7, D8, D9, deck0, DJ, DQ, DK, DA;
    private static Card H2, H3, H4, H5, H6, H7, H8, H9, H10, HJ, HQ, HK, HA;
    private static BoardSearcher searcher;
    private static ArrayList<Card[]> permutations;
    private static Scanner sc;
    @BeforeAll
    static void init(){
        temp = new Card();
        deck = new Deck();
        //deal cards
        C2 = deck.deal(); C3 = deck.deal(); C4 = deck.deal(); C5 = deck.deal(); C6 = deck.deal(); C7 = deck.deal();
        C8 = deck.deal(); C9 = deck.deal(); C10 = deck.deal(); CJ = deck.deal(); CQ = deck.deal(); CK = deck.deal(); CA = deck.deal();
        S2 = deck.deal(); S3 = deck.deal(); S4 = deck.deal(); S5 = deck.deal(); S6 = deck.deal(); S7 = deck.deal();
        S8 = deck.deal(); S9 = deck.deal(); S10 = deck.deal(); SJ = deck.deal(); SQ = deck.deal(); SK = deck.deal(); SA = deck.deal();
        H2 = deck.deal(); H3 = deck.deal(); H4 = deck.deal(); H5 = deck.deal(); H6 = deck.deal(); H7 = deck.deal();
        H8 = deck.deal(); H9 = deck.deal(); H10 = deck.deal(); HJ = deck.deal(); HQ = deck.deal(); HK = deck.deal(); HA = deck.deal();
        D2 = deck.deal(); D3 = deck.deal(); D4 = deck.deal(); D5 = deck.deal(); D6 = deck.deal(); D7 = deck.deal();
        D8 = deck.deal(); D9 = deck.deal(); deck0 = deck.deal(); DJ = deck.deal(); DQ = deck.deal(); DK = deck.deal(); DA = deck.deal();
        permutations = new ArrayList<>();
        board = new Card[5];
        try {
            sc = new Scanner(new File("Permutations.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static void getPermutations(Card[] board)
    {
        while(sc.hasNextLine())
        {
            String[] line = sc.nextLine().split(",");
            int[] nums = new int[5];
            for(int i = 0; i < line.length; i++){
                nums[i] = Integer.parseInt(line[i]);
            }
            permutations.add(new Card[]{board[nums[0]-1],board[nums[1]-1],board[nums[2]-1],board[nums[3]-1],board[nums[4]-1]});
        }
    }
    @Test
    void pairPresent_True() {
        board = new Card[]{H3, C3, C4, C5, C6};
        getPermutations(board);
        boolean result = true;
        for(Card[] permutation : permutations){
            searcher = new BoardSearcher(permutation);
            result = result && searcher.pairPresent();
            if(!result)
                System.out.println(result);
            assertTrue(result);
        }
    }
    @Test
    void pairPresent_False() {
        board = new Card[]{H2, C3, C4, C5, C6};
        getPermutations(board);
        boolean result = true;
        for(Card[] permutation : permutations){
            searcher = new BoardSearcher(permutation);
            result = result && searcher.pairPresent();
            if(!result)
                System.out.println(result);
            assertFalse(result);
        }
    }

    @Test
    void twoPairPresent_True(){
        board = new Card[]{H2, C2, C4, H4, C6};
        getPermutations(board);
        boolean result = true;
        for(Card[] permutation : permutations){
            searcher = new BoardSearcher(permutation);
            result = result && searcher.twoPairPresent();
            if(!result) {
                System.out.println(result);
                searcher.twoPairPresent();
            }
            assertTrue(result);
        }
    }
    @Test
    void twoPairPresent_False(){
        board = new Card[]{H2, C2, D2, H4, C6};
        getPermutations(board);
        boolean result = true;
        for(Card[] permutation : permutations){
            searcher = new BoardSearcher(permutation);
            result = result && searcher.twoPairPresent();
            if(!result) {
                System.out.println(result);
                searcher.twoPairPresent();
            }
            assertFalse(result);
        }
    }
    @Test
    void threePairPresent_True(){
        board = new Card[]{H2, C2, D2, H4, C6};
        getPermutations(board);
        boolean result = true;
        for(Card[] permutation : permutations){
            searcher = new BoardSearcher(permutation);
            result = result && searcher.threePairPresent();
            if(!result) {
                System.out.println(result);
                searcher.threePairPresent();
            }
            assertTrue(result);
        }
    }
    @Test
    void threePairPresent_False(){
        board = new Card[]{H6, C2, D2, H4, C6};
        getPermutations(board);
        boolean result = true;
        for(Card[] permutation : permutations){
            searcher = new BoardSearcher(permutation);
            result = result && searcher.threePairPresent();
            if(!result) {
                System.out.println(result);
                searcher.threePairPresent();
            }
            assertFalse(result);
        }
    }
}