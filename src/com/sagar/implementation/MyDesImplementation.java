package com.sagar.implementation;
public class MyDesImplementation {
    public String plainText,binaryPlainText,IP,L0,R0;
    public int initialPermuation[];
    public  int eBitSelection [];
    public  int permutation[];
    public  int reversePermutation[];
    String Er0, IPminus,ChiperText;
    String halfFunction;
    public int [][] S1,S2,S3,S4,S5,S6,S7,S8;
    public String S1B1,S2B2,S3B3,S4B4,S5B5,S6B6,S7B7,S8B8,SB;
    String B1,B2,B3,B4,B5,B6,B7,B8;
    String s1,s2;
    int value1,value2,rowbycolumn,value3,value4;
    String function;
    String [] Rhalf,Lhalf;


    public MyDesImplementation() {
        plainText = "0123456789ABCDEF";
        binaryPlainText = new String();
        IP = L0 = R0 = Er0 = IPminus = halfFunction = new String();
        S1B1 = S2B2 = S3B3 = S4B4 = S5B5 = S6B6 = S7B7 = S8B8 = SB = new String();
        B1 = B2 = B3 = B4 = B5 = B6 = B7 = B8 = new String();
        s1 = s2 = new String();
        value1 = value2 = value3 = value4 = rowbycolumn = 1;
        function = new String();
        Rhalf = Lhalf = new String[16];

        initialPermuation = new int[]
                {
                        58   , 50 ,  42  ,  34  ,  26 ,  18  ,  10  ,  2,
                        60   , 52 ,  44  ,  36  ,  28 ,  20  , 12   ,  4,
                        62   , 54 ,  46  ,  38  ,  30 ,  22  ,  14  ,  6,
                        64   , 56 ,  48  ,  40  ,  32 ,  24  ,  16  ,  8,
                        57   , 49 ,  41  ,  33  ,  25 ,  17  ,  9   ,  1,
                        59   , 51 ,  43  ,  35  ,  27 ,  19  ,  11  ,  3,
                        61   , 53 ,  45  ,  37  ,  29 ,  21  ,  13  ,  5,
                        63   , 55 ,  47  ,  39  ,  31 ,  23  ,  15  ,  7
                };
        eBitSelection = new int[]
                {
                        32   ,  1  ,  2   ,  3   ,  4  ,  5,
                        4    , 5   ,  6   ,  7   ,  8  ,  9,
                        8    , 9   ,  10  ,  11  ,  12 ,  13,
                        12   , 13  ,  14  ,  15  ,  16 ,  17,
                        16   , 17  ,  18  ,  19  ,  20 ,  21,
                        20   , 21  ,  22  ,  23  ,  24 ,  25,
                        24   , 25  ,  26  ,  27  ,  28 ,  29,
                        28   , 29  ,  30  ,  31  ,  32 ,  1
                };
        S1 = new int[][]
                {
                        {14 , 4  ,13 , 1 ,  2 ,15 , 11 , 8  , 3 ,10  , 6 ,12  , 5 , 9 ,  0 , 7},
                        { 0 ,15 ,  7 , 4  ,14 , 2  ,13 , 1  ,10 , 6  ,12, 11 ,  9 , 5  , 3  ,8},
                        { 4 , 1 , 14 , 8  ,13 , 6  , 2 , 11 , 15, 12 ,  9 , 7  , 3 ,10  , 5  ,0},
                        { 15 ,12 ,  8 , 2  , 4  ,9  , 1 , 7  , 5 ,11   ,3 ,14 , 10 , 0 ,  6 ,13}
                };
        S2 = new int[][]
                {
                        {15 , 1 ,  8 ,14 ,  6 ,11  , 3 , 4  , 9 , 7  , 2 ,13 , 12,  0 ,  5 ,10},
                        {3 ,13 ,  4 , 7 , 15 , 2  , 8 ,14 , 12 , 0 ,  1 ,10 ,  6 , 9  ,11 , 5},
                        {0 , 14 ,  7 ,11  ,10 , 4 , 13 , 1 ,  5 , 8 , 12 , 6  , 9  ,3  , 2 ,15},
                        {13 , 8 , 10 , 1  , 3 ,15 ,  4 , 2 , 11 , 6  , 7 ,12  , 0  ,5  ,14  ,9}
                };

        S3 = new int[][]
                {
                        {10 , 0 ,  9 ,14 ,  6 , 3 , 15,  5  , 1 ,13 , 12 , 7  ,11 , 4 ,  2 , 8},
                        {13 , 7 ,  0 , 9 ,  3 , 4  , 6 ,10 ,  2,  8 ,  5 ,14 , 12 ,11 , 15 , 1},
                        {13 , 6  , 4 , 9  , 8 ,15 ,  3 , 0  ,11 , 1  , 2 ,12  , 5 ,10 , 14 , 7},
                        {1 ,10 , 13,  0 ,  6 , 9  , 8  ,7  , 4 , 15  ,14 , 3  ,11  ,5  , 2 ,12}
                };

        S4 = new int[][]
                {
                        {7 ,13,  14,  3  , 0 , 6  , 9 ,10  , 1  ,2  , 8  ,5  ,11, 12  , 4 ,15},
                        {13 , 8 , 11,  5 ,  6 ,15  , 0 , 3  , 4 , 7 ,  2 ,12 ,  1 ,10 , 14 , 9},
                        {10 , 6 ,  9 , 0 , 12 ,11 ,  7 ,13  ,15 , 1  , 3 ,14  , 5 , 2  , 8 , 4},
                        {3 ,15 ,  0,  6 , 10,  1 , 13,  8 ,  9 , 4 ,  5 ,11 , 12,  7 ,  2 ,14}
                };

        S5 = new int[][]
                {
                        {2,12 ,  4 , 1 ,  7 ,10  ,11 , 6 ,  8 , 5 ,  3 ,15  ,13 , 0  ,14 , 9},
                        {14, 11,   2, 12,   4,  7 , 13,  1 ,  5,  0,  15, 10 ,  3 , 9 ,  8 , 6},
                        {4 , 2 ,  1 ,11 , 10, 13 ,  7 , 8 , 15 , 9 , 12 , 5  , 6 , 3  , 0 ,14},
                        {11 , 8  ,12  ,7  , 1 ,14  , 2,13 ,  6 ,15 ,  0 , 9,  10 , 4 ,  5 , 3}
                };

        S6 = new int[][]
                {
                        {12 , 1 , 10 ,15  , 9 , 2 ,  6 , 8 ,  0 ,13  , 3 , 4  ,14 , 7  , 5 ,11},
                        {10  ,15 ,  4 , 2 ,  7 ,12 ,  9 , 5  , 6 , 1 , 13, 14 ,  0 ,11  , 3 , 8},
                        {9 ,14 , 15,  5 ,  2,  8 , 12 , 3  , 7 , 0  , 4 ,10  , 1 ,13  ,11 , 6},
                        {4  ,3  , 2 ,12 ,  9 , 5 , 15 ,10 , 11 ,14 ,  1 , 7  , 6 , 0  , 8 ,13}
                };
        S7 = new int[][]
                {
                        {4 ,11 ,  2, 14,  15,  0 ,  8 ,13 ,  3 ,12 ,  9 , 7  , 5 ,10 ,  6,  1},
                        {13 , 0 , 11,  7 ,  4 , 9 ,  1 ,10 , 14 , 3  , 5 ,12  , 2 ,15  , 8 , 6},
                        {1 , 4 , 11, 13 , 12,  3 ,  7 ,14 , 10 ,15  , 6 , 8  , 0 , 5 ,  9 , 2},
                        {6 ,11 , 13,  8 ,  1 , 4 , 10 , 7 ,  9 , 5 ,  0 ,15 , 14 , 2  , 3 ,12}
                };
        S8 = new int[][]
                {
                        {13 , 2 ,  8,  4 ,  6 ,15 , 11 , 1  ,10 , 9  , 3 ,14  , 5 , 0  ,12 , 7},
                        {1, 15  ,13  ,8  ,10 , 3 ,  7 , 4 , 12,  5  , 6, 11,   0, 14 ,  9 , 2},
                        {7 ,11 ,  4,  1  , 9 ,12 , 14 , 2  , 0 , 6 , 10 ,13  ,15 , 3  , 5 , 8},
                        {2 , 1  ,14 , 7 ,  4 ,10 ,  8, 13 , 15 ,12  , 9  ,0 ,  3 , 5 ,  6 ,11}
                };
        permutation = new int[]
                {
                        16  , 7 , 20 , 21,
                        29 , 12 , 28 , 17,
                        1 , 15 , 23 , 26,
                        5 , 18 , 31 , 10,
                        2 ,  8 , 24 , 14,
                        32 , 27 ,  3  , 9,
                        19 , 13 , 30 ,  6,
                        22 , 11  , 4  ,25
                };
        reversePermutation = new int[]
                {
                        40   ,  8 ,  48 ,   16  ,  56  , 24  ,  64 ,  32,
                        39   ,  7  , 47  ,  15  ,  55  , 23   , 63 ,  31,
                        38   ,  6  , 46  ,  14  ,  54 ,  22  ,  62 ,  30,
                        37   ,  5  , 45  ,  13  ,  53  , 21  ,  61  , 29,
                        36   ,  4 ,  44  ,  12  ,  52 ,  20  ,  60 ,  28,
                        35   ,  3 ,  43   , 11  ,  51   ,19  ,  59 ,  27,
                        34  ,   2 ,  42  ,  10  ,  50  , 18   , 58  , 26,
                        33   ,  1   ,41   ,  9   , 49  , 17  ,  57 ,  25
                };

    }

    public void binaryConversion()
    {
        MyKeyRotation mkr = new MyKeyRotation();
        binaryPlainText = mkr.binaryToHexaDecimal(plainText.charAt(0));
        for(int i = 1; i < plainText.length(); i++)
        {
            binaryPlainText = binaryPlainText + mkr.binaryToHexaDecimal(plainText.charAt(i));
        }
//         System.out.println("Plain Text Message: " +binaryPlainText);
    }
    public void leftAndRightHalf()
    {
        binaryConversion();
        MyKeyRotation mkr = new MyKeyRotation();
        mkr.decreaseArrayValueByOne(initialPermuation);

        for (int i = 0; i < initialPermuation.length; i++)
        {
            IP = IP + binaryPlainText.charAt(initialPermuation[i]);
        }
//        System.out.println("64 Bit IP: " + IP);
        for(int i = 0; i < 32; i++)
        {
            L0 = L0 + IP.charAt(i);
        }
//        System.out.println("Left Half 32 Bit: L0 " + L0);
        for(int i = 32; i < 64; i++)
        {
            R0 = R0 + IP.charAt(i);
        }
//        System.out.println("Left Half 32 Bit: R0 " + R0);
    }


    public void bitSeparation()
    {
//            generationOfRnAndLn();

        int keyIncrement = 0;
        leftAndRightHalf();
        MyKeyRotation mkr = new MyKeyRotation();
        mkr.decreaseArrayValueByOne(eBitSelection);
        mkr.decreaseArrayValueByOne(permutation);
        String key[] = mkr.leftCircularShiftWIthKeyGeneration();


        for(int j = 1; j <= 16; j++) {
            String R1 = "";
            Er0 = "";
            halfFunction = "";
            B1 = B2 = B3 = B4 = B5 = B6 = B7 = B8 = "";
            S1B1 = S2B2 = S3B3 = S4B4 = S5B5 = S6B6 = S7B7 = S8B8 = SB = "";
            function = "";
//            System.out.println(R0);
            for (int i = 0; i < eBitSelection.length; i++) {
                Er0 = Er0 + R0.charAt(eBitSelection[i]);
            }
//            System.out.println(Er0);
            String firstKey = key[keyIncrement];
//             System.out.println(firstKey);
            for (int i = 0; i < Er0.length(); i++) {
                if ((Er0.charAt(i) == '0' && firstKey.charAt(i) == '0') || (Er0.charAt(i) == '1' && firstKey.charAt(i) == '1')) {
                    halfFunction = halfFunction + '0';
                } else {
                    halfFunction = halfFunction + '1';
                }
            }
//          System.out.println(halfFunction);
            for (int i = 0; i < 6; i++) {
                B1 = B1 + halfFunction.charAt(i);
            }
//            System.out.println(B1);
            s1 = (Character.toString(B1.charAt(0))).concat(Character.toString(B1.charAt(5)));
            value1 = twobitDecimal(s1);
            s2 = (((Character.toString(B1.charAt(1))).concat(Character.toString(B1.charAt(2)))).concat(Character.toString(B1.charAt(3)))).concat(Character.toString(B1.charAt(4)));
            value2 = fourbitDecimal(s2);
            rowbycolumn = S1[value1][value2];
            S1B1 = decimaltoBinary(rowbycolumn);
//            System.out.println(S1B1);

            for (int i = 6; i < 12; i++) {
                B2 = B2 + halfFunction.charAt(i);
            }
//        System.out.println(B2);
            s1 = (Character.toString(B2.charAt(0))).concat(Character.toString(B2.charAt(5)));
            value1 = twobitDecimal(s1);
            s2 = (((Character.toString(B2.charAt(1))).concat(Character.toString(B2.charAt(2)))).concat(Character.toString(B2.charAt(3)))).concat(Character.toString(B2.charAt(4)));
            value2 = fourbitDecimal(s2);
            rowbycolumn = S2[value1][value2];
            S2B2 = decimaltoBinary(rowbycolumn);
//            System.out.println(S2B2);
            for (int i = 12; i < 18; i++) {
                B3 = B3 + halfFunction.charAt(i);
            }
//        System.out.println(B3);
            s1 = (Character.toString(B3.charAt(0))).concat(Character.toString(B3.charAt(5)));
            value1 = twobitDecimal(s1);
            s2 = (((Character.toString(B3.charAt(1))).concat(Character.toString(B3.charAt(2)))).concat(Character.toString(B3.charAt(3)))).concat(Character.toString(B3.charAt(4)));
            value2 = fourbitDecimal(s2);
            rowbycolumn = S3[value1][value2];
            S3B3 = decimaltoBinary(rowbycolumn);
//            System.out.println(S3B3);

            for (int i = 18; i < 24; i++) {
                B4 = B4 + halfFunction.charAt(i);
            }
//            System.out.println(B4);
            s1 = (Character.toString(B4.charAt(0))).concat(Character.toString(B4.charAt(5)));
            value1 = twobitDecimal(s1);
            s2 = (((Character.toString(B4.charAt(1))).concat(Character.toString(B4.charAt(2)))).concat(Character.toString(B4.charAt(3)))).concat(Character.toString(B4.charAt(4)));
            value2 = fourbitDecimal(s2);
            rowbycolumn = S4[value1][value2];
            S4B4 = decimaltoBinary(rowbycolumn);
//            System.out.println(S4B4);

            for (int i = 24; i < 30; i++) {
                B5 = B5 + halfFunction.charAt(i);
            }
//        System.out.println(B5);
            s1 = (Character.toString(B5.charAt(0))).concat(Character.toString(B5.charAt(5)));
            value1 = twobitDecimal(s1);
            s2 = (((Character.toString(B5.charAt(1))).concat(Character.toString(B5.charAt(2)))).concat(Character.toString(B5.charAt(3)))).concat(Character.toString(B5.charAt(4)));
            value2 = fourbitDecimal(s2);
            rowbycolumn = S5[value1][value2];
            S5B5 = decimaltoBinary(rowbycolumn);
//            System.out.println(S5B5);

            for (int i = 30; i < 36; i++) {
                B6 = B6 + halfFunction.charAt(i);
            }
//        System.out.println(B6);
            s1 = (Character.toString(B6.charAt(0))).concat(Character.toString(B6.charAt(5)));
            value1 = twobitDecimal(s1);
            s2 = (((Character.toString(B6.charAt(1))).concat(Character.toString(B6.charAt(2)))).concat(Character.toString(B6.charAt(3)))).concat(Character.toString(B6.charAt(4)));
            value2 = fourbitDecimal(s2);
            rowbycolumn = S6[value1][value2];
            S6B6 = decimaltoBinary(rowbycolumn);
//            System.out.println(S6B6);

            for (int i = 36; i < 42; i++) {
                B7 = B7 + halfFunction.charAt(i);
            }
//        System.out.println(B7);
            s1 = (Character.toString(B7.charAt(0))).concat(Character.toString(B7.charAt(5)));
            value1 = twobitDecimal(s1);
            s2 = (((Character.toString(B7.charAt(1))).concat(Character.toString(B7.charAt(2)))).concat(Character.toString(B7.charAt(3)))).concat(Character.toString(B7.charAt(4)));
            value2 = fourbitDecimal(s2);
            rowbycolumn = S7[value1][value2];
            S7B7 = decimaltoBinary(rowbycolumn);
//           System.out.println(S7B7);

            for (int i = 42; i < 48; i++) {
                B8 = B8 + halfFunction.charAt(i);
            }
//            System.out.println(S8B8);
            s1 = (Character.toString(B8.charAt(0))).concat(Character.toString(B8.charAt(5)));
            value1 = twobitDecimal(s1);
            s2 = (((Character.toString(B8.charAt(1))).concat(Character.toString(B8.charAt(2)))).concat(Character.toString(B8.charAt(3)))).concat(Character.toString(B8.charAt(4)));
            value2 = fourbitDecimal(s2);
            rowbycolumn = S8[value1][value2];
            S8B8 = decimaltoBinary(rowbycolumn);
//        System.out.println(B8);
//            System.out.println(S8B8);
            SB = S1B1 + S2B2 + S3B3 + S4B4 + S5B5 + S6B6 + S7B7 + S8B8;
//            System.out.println("\n");

//            System.out.println(SB);

            for (int i = 0; i < permutation.length; i++) {
                function = function + SB.charAt(permutation[i]);
            }
//            System.out.println(R0);

//            System.out.println(function);
//            System.out.println(L0);
            for (int i = 0; i < function.length(); i++) {
                if ((L0.charAt(i) == '0' && function.charAt(i) == '0') || (L0.charAt(i) == '1' && function.charAt(i) == '1')) {
                    R1 = R1 + '0';
                } else {
                    R1 = R1 + '1';
                }
            }
//            System.out.println(R1);
            Lhalf[keyIncrement] = R0;
            L0 = Lhalf[keyIncrement];

            System.out.println("L "+ j +":" + Lhalf[keyIncrement]);
            Rhalf[keyIncrement] = R1;

            System.out.println("R " + j + ":" + Rhalf[keyIncrement]);
            R0 = Rhalf[keyIncrement];

            keyIncrement++;
            System.out.println("\n");
        }
    }

    public void chiperGeneration()
    {
        String reverseOrder = Rhalf[15] + Rhalf[14]; // since L16 = R14
//        System.out.println(reverseOrder);
        MyKeyRotation mkr = new MyKeyRotation();
        mkr.decreaseArrayValueByOne(reversePermutation);
        for (int i = 0; i < reversePermutation.length; i++)
        {
            IPminus = IPminus + reverseOrder.charAt(reversePermutation[i]);
        }
//        System.out.println(IPminus);
        String c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16;
        c1 = c2 = c3 = c4 = c5 = c6 = c7 = c8 = c9 = c10 = c11 = c12 = c13 = c14 = c15 = c16 = new String();
       for(int i = 0; i < 4; i++)
       {
           c1 =   c1 + IPminus.charAt(i);
           c2 =   c2 + IPminus.charAt(i+4);
           c3 =   c3 + IPminus.charAt(i+8);
           c4 =   c4 + IPminus.charAt(i+12);
           c5 =   c5 + IPminus.charAt(i+16);
           c6 =   c6 + IPminus.charAt(i+20);
           c7 =   c7 + IPminus.charAt(i+24);
           c8 =   c8 + IPminus.charAt(i+28);
           c9 =   c9 + IPminus.charAt(i+32);
           c10 = c10 + IPminus.charAt(i+36);
           c11 = c11 + IPminus.charAt(i+40);
           c12 = c12 + IPminus.charAt(i+44);
           c13 = c13 + IPminus.charAt(i+48);
           c14 = c14 + IPminus.charAt(i+52);
           c15 = c15 + IPminus.charAt(i+56);
           c16 = c16 + IPminus.charAt(i+60);
       }
       ChiperText = binaryToHex(c1) + binaryToHex(c2) + binaryToHex(c3) + binaryToHex(c4) +binaryToHex(c5) + binaryToHex(c6) + binaryToHex(c7) + binaryToHex(c8) + binaryToHex(c9) + binaryToHex(c10) + binaryToHex(c11) + binaryToHex(c12) +binaryToHex(c13) + binaryToHex(c14) + binaryToHex(c15) + binaryToHex(c16) ;
       System.out.println("The Plain Text was  :" + plainText );
       System.out.println("The ChiperText is   :" + ChiperText);


    }

    /*public String returnRowColumnPoint(String B)
    {
       if(B.equals(B1)) {

           s1 = (Character.toString(B.charAt(0))).concat(Character.toString(B.charAt(5)));
           value1 = twobitDecimal(s1);
           s2 = (((Character.toString(B.charAt(1))).concat(Character.toString(B.charAt(2)))).concat(Character.toString(B.charAt(3)))).concat(Character.toString(B.charAt(4)));
           value2 = fourbitDecimal(s2);
           rowbycolumn = S1[value1][value2];
       }
       else if(B.equals(B2))
       {
           s1 = (Character.toString(B.charAt(0))).concat(Character.toString(B.charAt(5)));
           value1 = twobitDecimal(s1);
           s2 = (((Character.toString(B.charAt(1))).concat(Character.toString(B.charAt(2)))).concat(Character.toString(B.charAt(3)))).concat(Character.toString(B.charAt(4)));
           value2 = fourbitDecimal(s2);
           rowbycolumn = S2[value1][value2];
       }
       else if(B.equals(B3))
       {
           s1 = (Character.toString(B.charAt(0))).concat(Character.toString(B.charAt(5)));
           value1 = twobitDecimal(s1);
           s2 = (((Character.toString(B.charAt(1))).concat(Character.toString(B.charAt(2)))).concat(Character.toString(B.charAt(3)))).concat(Character.toString(B.charAt(4)));
           value2 = fourbitDecimal(s2);
           rowbycolumn = S3[value1][value2];
       }
       else if(B.equals(B4))
       {
           s1 = (Character.toString(B.charAt(0))).concat(Character.toString(B.charAt(5)));
           value1 = twobitDecimal(s1);
           System.out.println(value1);
           s2 = (((Character.toString(B.charAt(1))).concat(Character.toString(B.charAt(2)))).concat(Character.toString(B.charAt(3)))).concat(Character.toString(B.charAt(4)));
           value2 = fourbitDecimal(s2);
           System.out.println(value2);
           rowbycolumn = S4[value1][value2];
       }
       else if(B.equals(B5))
       {
           s1 = (Character.toString(B.charAt(0))).concat(Character.toString(B.charAt(5)));
           value1 = twobitDecimal(s1);
           s2 = (((Character.toString(B.charAt(1))).concat(Character.toString(B.charAt(2)))).concat(Character.toString(B.charAt(3)))).concat(Character.toString(B.charAt(4)));
           value2 = fourbitDecimal(s2);
           rowbycolumn = S5[value1][value2];
       }
       else if(B.equals(B6))
       {
           s1 = (Character.toString(B.charAt(0))).concat(Character.toString(B.charAt(5)));
           value1 = twobitDecimal(s1);
           s2 = (((Character.toString(B.charAt(1))).concat(Character.toString(B.charAt(2)))).concat(Character.toString(B.charAt(3)))).concat(Character.toString(B.charAt(4)));
           value2 = fourbitDecimal(s2);
           rowbycolumn = S6[value1][value2];
       }
       else if(B.equals(B7))
       {
           s1 = (Character.toString(B.charAt(0))).concat(Character.toString(B.charAt(5)));
           value1 = twobitDecimal(s1);
           s2 = (((Character.toString(B.charAt(1))).concat(Character.toString(B.charAt(2)))).concat(Character.toString(B.charAt(3)))).concat(Character.toString(B.charAt(4)));
           value2 = fourbitDecimal(s2);
           rowbycolumn = S7[value1][value2];
       }
       else if(B.equals(B8))
       {
           s1 = (Character.toString(B.charAt(0))).concat(Character.toString(B.charAt(5)));
           value1 = twobitDecimal(s1);
           s2 = (((Character.toString(B.charAt(1))).concat(Character.toString(B.charAt(2)))).concat(Character.toString(B.charAt(3)))).concat(Character.toString(B.charAt(4)));
           value2 = fourbitDecimal(s2);
           rowbycolumn = S8[value1][value2];
       }

       else
       {
           System.out.println("Error");
       }

        return decimaltoBinary(rowbycolumn);


    }*/


    public  String decimaltoBinary(int c)
    {
        switch(c)
        {
            case 10:
                return "1010";
            case 11:
                return "1011";
            case 12:
                return "1100";
            case 13:
                return "1101";
            case 14:
                return "1110";
            case 15:
                return "1111";
            case 1:
                return "0001";
            case 2:
                return "0010";
            case 3:
                return "0011";
            case 4:
                return "0100";
            case 5:
                return "0101";
            case 6:
                return "0110";
            case 7:
                return "0111";
            case 8:
                return "1000";
            case 9:
                return "1001";
            case 0:
                return "0000";
            default:
                return null;
        }
    }
    public String binaryToHex(String c)
    {

        switch (c)
        {
            case "0000":
                return "0";
            case "0001":
                return "1";
            case "0010":
                return "2";
            case "0011":
                return "3";
            case "0100":
                return "4";
            case "0101":
                return "5";
            case "0110":
                return "6";
            case "0111":
                return "7";
            case "1000":
                return "8";
            case "1001":
                return "9";
            case "1010":
                return "A";
            case "1011":
                return "B";
            case "1100":
                return "C";
            case "1101":
                return "D";
            case "1110":
                return "E";
            case "1111":
                return "F";
            default:
                return null;
        }
    }


    public int twobitDecimal(String s)
    {
        switch (s)
        {
            case "00":
                return 0;
            case "01":
                return 1;
            case "10":
                return 2;
            case "11":
                return 3;
                default:
                    return -1;
        }
    }


    public int fourbitDecimal(String s)
    {
        switch (s)
        {
            case "0000":
                return 0;
            case "0001":
                 return 1;
            case "0010":
                return 2;
            case "0011":
                return 3;
            case "0100":
                return 4;
            case "0101":
                return 5;
            case "0110":
                return 6;
            case "0111":
                return 7;
            case "1000":
                return 8;
            case "1001":
                return 9;
            case "1010":
                return 10;
            case "1011":
                return 11;
            case "1100":
                return 12;
            case "1101":
                return 13;
            case "1110":
                return 14;
            case "1111":
                return 15;
            default:
                return -1;
        }
    }


    public static void main(String args[])
    {
       MyDesImplementation mDes = new MyDesImplementation();
       mDes.bitSeparation();
       mDes.chiperGeneration();

    }
}
