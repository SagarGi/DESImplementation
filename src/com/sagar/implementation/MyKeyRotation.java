package com.sagar.implementation;
public class MyKeyRotation
{
    //sample key in hexadecimal
    public String sampleKey;
    //binary key 64 bit
    public  String binaryKey;
    public String pc1Key;
    public String C0;
    public String D0;
    public String C;
    public String D;
    public String[] MyKey;
    //pc-1
    static  int[] pc1;
    //pc=2
    static  int[] pc2;

    // required methods
    public  String binaryToHexaDecimal(char c)
    {
        switch(c)
        {
            case 'A':
                return "1010";
            case 'B':
                return "1011";
            case 'C':
                return "1100";
            case 'D':
                return "1101";
            case 'E':
                return "1110";
            case 'F':
                return "1111";
            case '1':
                return "0001";
            case '2':
                return "0010";
            case '3':
                return "0011";
            case '4':
                return "0100";
            case '5':
                return "0101";
            case '6':
                return "0110";
            case '7':
                return "0111";
            case '8':
                return "1000";
            case '9':
                return "1001";
            case '0':
                return "0000";
            default:
                return null;
        }
    }

    public MyKeyRotation() {
        sampleKey = "133457799BBCDFF1";
        binaryKey = null;
        pc1Key = new String();
        C0 = new String();
        D0 = new String();
        C = new String();
        D = new String();
        MyKey = new String[16];
        pc1 = new int[]{
                57,	49,	41,	33,	25,	17,	9,
                1,	58,	50,	42,	34,	26,	18,
                10,	2,	59,	51,	43,	35,	27,
                19,	11,	3,	60,	52,	44,	36,
                63,	55,	47,	39,	31,	23,	15,
                7,	62,	54,	46,	38,	30,	22,
                14,	6,	61,	53,	45,	37,	29,
                21,	13,	5,	28,	20,	12,	4
        };
         pc2 = new int[]{
                14, 17, 11, 24, 1,  5,
                3,  28, 15, 6,  21, 10,
                23, 19, 12, 4,  26, 8,
                16, 7,  27, 20, 13, 2,
                41, 52, 31, 37, 47, 55,
                30, 40, 51, 45, 33, 48,
                44, 49, 39, 56, 34, 53,
                46, 42, 50, 36, 29, 32
        };
    }
    // decreasing array value by 1 since it start from 0

    public void decreaseArrayValueByOne(int array[])
    {
        for(int i = 0; i < array.length; i++)
        {
            array[i] = array[i] - 1;
        }
    }

    public String[] leftCircularShiftWIthKeyGeneration()
    {
        //System.out.println("C 0:" + C0);
        //System.out.println("D 0:" + D0);
//        MyKeyRotation obj = new MyKeyRotation();
        binaryKey = binaryToHexaDecimal(sampleKey.charAt(0));
        for(int i = 1; i < 16; i++)
        {
            binaryKey = binaryKey + binaryToHexaDecimal(sampleKey.charAt(i));
        }
        decreaseArrayValueByOne(pc1);
        decreaseArrayValueByOne(pc2);

        //generation of 56 bit key using PC - 1
        for(int i = 0; i < pc1.length;  i++)
        {
            pc1Key = pc1Key + binaryKey.charAt(pc1[i]);
        }
        //System.out.println("PC-1  Key: " + pc1Key);

        //split up the pc2key into 28bit
        for(int i = 0; i < 28; i++)
        {
            C0 = C0 + pc1Key.charAt(i);
        }

        for(int i = 28; i < 56; i++)
        {
            D0 = D0 + pc1Key.charAt(i);
        }

        int onlyOneTime = 0;
        String tempC;
        String tempD;
        String key;
        String concateCandD;
        for(int j = 1; j <= 16; j++ )
        {
            tempC = "";
            tempD = "";
            key = "";
            for(int i = 1; i < C0.length(); i++)
            {

                 if(j == 1 || j == 2 || j == 9 || j == 16)
                {
                    tempC = tempC + C0.charAt(i);
                    tempD = tempD + D0.charAt(i);
                }
                else
                {
                    for(int k = 2; k < 28; k++ ) {
                        tempC = tempC + C0.charAt(k);
                        tempD = tempD + D0.charAt(k);
                    }
                    break;
                }
            }

          if(j == 1 || j == 2 || j == 9 || j == 16)
            {
                C = tempC + C0.charAt(0);
                D = tempD + D0.charAt(0);
            }
            else
            {
                C = tempC + C0.charAt(0) + C0.charAt(1);
                D = tempD + D0.charAt(0) + D0.charAt(1);
            }
            //System.out.println("C "+j+" :" + C);
            //System.out.println("D "+j+" :" + D);
            C0 = C;
            D0 = D;

            concateCandD = C + D;
            for(int i = 0; i <pc2.length; i++)
            {
                key = key + concateCandD.charAt(pc2[i]);
            }
            MyKey[onlyOneTime] = key;
            onlyOneTime++;
            //System.out.println("Key "+j+" :" + key);
        }
        return MyKey;
    }
}


