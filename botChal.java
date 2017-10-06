
import java.io.*;
import java.util.*;
public class CandidateCode {
    public static String findAvailabePosition(int[][] x, int id, int pos1,int pos2) {
        String str = "";
        if(id == 1) {
            int count = 0;
            for(int i = 0; i < 7; i++) {
                for(int j = 0;j < 7; j++) {
                    if(i == pos1 - 1 && j == pos2 - 1 && x[i][j] == 0 && x[i][pos2] != -1) {
                        str += "lftDig"+String.valueOf(pos1 - 1)+String.valueOf(pos2 - 1)+" ";
                        count++;
                    }
                    else if(i != 0 && i == pos1 - 1 && j == pos2 && x[i][j] == 0) {
                        str += "upStright"+String.valueOf(pos1 - 1)+String.valueOf(pos2)+" ";
                        count++;
                    }
                    else if(i == pos1 - 1 && j == pos2 + 1 && x[i][j] == 0) {
                        str += "rgtDig"+String.valueOf(pos1 - 1)+String.valueOf(pos2 + 1)+" ";
                        count++;
                    }
                    else if(i == pos1 && j == pos2 - 1 && x[i][j] == 0) {
                        str += "left"+String.valueOf(pos1)+String.valueOf(pos2 - 1)+" ";
                        count++;
                    }
                    else if(i == pos1 && j == pos2 + 1 && x[i][j] == 0) {
                        str += "Right"+String.valueOf(pos1)+String.valueOf(pos2 + 1)+" ";
                        count++;
                    }
                    else if(i == pos1 + 1 && j == pos2 - 1 && x[i][j] == 0) {
                        str += "lftDnDig"+String.valueOf(pos1 + 1)+String.valueOf(pos2 - 1)+" ";
                        count++;
                    }
                    else if(i == pos1 + 1 && j == pos2 + 1 && x[i][j] == 0) {
                        str += "rgtDnDig"+String.valueOf(pos1 + 1)+String.valueOf(pos2 + 1)+" ";
                        count++;
                    }
                    else if(i == pos1 + 1 && j == pos2 && x[i][j] == 0) {
                        str += "DnStright"+String.valueOf(pos1 + 1)+String.valueOf(pos2)+" ";
                        count++;
                    }
                }
            }
            if(count == 0) {
                str = "No Way";
            }
        }
        else if(id == 2) {
            int count = 0;
            for(int i = 0; i < 7; i++) {
                for(int j = 0;j < 7; j++) {
                    if(i == pos1 + 1 && j == pos2 - 1 && x[i][j] == 0 && j != 0) {
                        str += "lftDig"+String.valueOf(pos1 + 1)+String.valueOf(pos2 - 1)+" ";
                        count++;
                    }
                    else if(i == pos1 + 1 && j == pos2 + 1 && x[i][j] == 0 && j != 6) {
                        str += "rgtDig"+String.valueOf(pos1 + 1)+String.valueOf(pos2 + 1)+" ";
                        count++;
                    }
                    else if(i == pos1 - 1 && j == pos2 - 1 && x[i][j] == 0) {
                        str += "lftDnDig"+String.valueOf(pos1 - 1)+String.valueOf(pos2 - 1)+" ";
                        count++;
                    }
                    else if(i == pos1 - 1 && j == pos2 && x[i][j] == 0) {
                        str += "upDnStright"+String.valueOf(pos1 - 1)+String.valueOf(pos2)+" ";
                        count++;
                    }
                    else if(i == pos1 - 1 && j == pos2 + 1 && x[i][j] == 0) {
                        str += "rgtDnDig"+String.valueOf(pos1 - 1)+String.valueOf(pos2 + 1)+" ";
                        count++;
                    }
                    else if(i == pos1 && j == pos2 - 1 && x[i][j] == 0 ) {
                        str += "left"+String.valueOf(pos1)+String.valueOf(pos2 - 1)+" ";
                        count++;
                    }
                    else if(i == pos1 && j == pos2 + 1 && x[i][j] == 0) {
                        str += "Right"+String.valueOf(pos1)+String.valueOf(pos2 + 1)+" ";
                        count++;
                    }
                    else if(i == pos1 + 1 && j == pos2 && x[i][j] == 0 && x[i][j - 1] != -1) {
                        str += "Stright"+String.valueOf(pos1 + 1)+String.valueOf(pos2)+" ";
                        count++;
                    }
                }
            }
            if(count == 0) {
                str = "No Way";
            }
        }
        return str;
    }
    public static String removeAvail(int[][] y,int po1,int po2,int pId) {
        String gtr = "";
        int count1 = 0;
        if(pId == 2) {
            if(po1 <= 4 && po1 != 0) {
                if(y[po1 - 1][po2] == -1 && y[po1 + 1][po2]== -1 && y[po1 - 1][po2 + 1] == -1 && y[po1 + 1][po2 + 1]== -1) {
                    if(y[po1][po2 + 1] == 0 && y[po1][po2 + 2] == 0) {
                        gtr += String.valueOf(po1)+String.valueOf(po2 + 1)+String.valueOf(po1)+String.valueOf(po2 + 2);
                        count1 = 2;
                    }
                    else if(y[po1][po2 + 1] == 0 && y[po1][po2 + 2] != 0) {
                        gtr += String.valueOf(po1)+String.valueOf(po2 + 1);
                        for(int i = po1;i <= 6; i++) {
                            for(int j = 6; j >= 0; j--) {
                                if(y[i][j] == 0) {
                                    gtr += String.valueOf(i)+String.valueOf(j);
                                    count1 = 2;
                                    break;
                                }
                            }
                            if(count1 == 2) {
                                break;
                            }
                        }
                    }
                    else if(y[po1][po2 + 1] != 0 && y[po1][po2 + 2] == 0) {
                        gtr += String.valueOf(po1)+String.valueOf(po2 + 2);
                        for(int i = po1;i <= 6; i++) {
                            for(int j = 6; j >= 0; j--) {
                                if(y[i][j] == 0) {
                                    gtr += String.valueOf(i)+String.valueOf(j);
                                    count1 = 2;
                                    break;
                                }
                            }
                            if(count1 == 2) {
                                break;
                            }
                        }
                    }
                }
                else {
                    for(int i = po1 - 1; i <= 6; i++) {
                        for(int j = po2; j >= 0; j--) {
                            if(count1 < 2 && y[i][j] == 0) {
                                gtr += String.valueOf(i)+String.valueOf(j);
                                count1++;
                                break;
                            }
                            else if(count1 < 2 && y[i][j + 1] == 0) {
                            	gtr += String.valueOf(i)+String.valueOf(j + 1);
                            	count1++;
                            	break;
                            }
                        }
                    }
                }
            }
            else {
                if(po2 != 0 && po1 != 0 && (y[po1 - 1][po2 - 1] != -1 || y[po1 - 1][po2] != -1 || y[po1][po2 - 1] != -1)) {
                    for(int i = po1; i >= 0; i--) {
                        for(int j = po2; j >= 0; j--) {
                            if(count1 < 2 && y[i][j] != 1 && y[i][j] != -1 && y[i][j] != 2) {
                                gtr += String.valueOf(i)+String.valueOf(j);
                                count1++;
                                break;
                            }
                        }
                    }
                }
                else {
                    for(int i = po1; i >= 0; i--) {
                        for(int j = po2 + 1; j >= 0; j--) {
                            if(count1 < 2 && y[i][j] != 1 && y[i][j] != -1 && y[i][j] != 2) {
                                gtr += String.valueOf(i)+String.valueOf(j);
                                count1++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        else if(pId == 1) {
            if(po1 != 0 && po1 != 6 && po2 != 6) {
                if(po2 == 0 && y[po1 - 1][po2 + 1] == -1 && y[po1 + 1][po2] == -1 && y[po1 - 1][po2] == 0 && y[po1][po2 + 1] == 0) {
                    gtr += String.valueOf(po1 - 1)+String.valueOf(po2)+String.valueOf(po1)+String.valueOf(po2 + 1);
                    count1 = 2;
                }
                else if(po2 == 1 && y[po1 - 1][po2 + 1] == 0 && y[po1 + 1][po2 + 1] == 0) {
                    gtr += String.valueOf(po1 - 1)+String.valueOf(po2 + 1)+String.valueOf(po1+1)+String.valueOf(po2 + 1);
                    count1 = 2;
                }
                else if(po1 >= 1 && po2 <= 5 && y[po1][po2 + 1] == -1 && y[po1][po2 - 1] == 0 && y[po1 + 1][po2] == 0) {
                	gtr += String.valueOf(po1)+String.valueOf(po2 - 1)+String.valueOf(po1 + 1)+String.valueOf(po2);
                	count1 = 2;
                }
                else if(po1 >= 1 && po1 <= 5 && po2 >= 1 && y[po1 - 1][po2 + 1] == -1 && y[po1][po2 + 1] == -1 && 
                y[po1 + 1][po2 + 1] == -1 && y[po1 + 1][po2] == -1 && y[po1 + 1][po2 - 1] == -1 && y[po1 - 1][po2 - 1] == -1 && 
                y[po1 - 1][po2] == -1 && y[po1][po2 - 1] == 0) {
                    gtr += String.valueOf(po1)+String.valueOf(po2 - 1);
                    for(int i = po1; i <= 6; i++) {
                        for(int j = (po2 - 1 )+ 1; j <= 6; j++) {
                            if(count1 < 2 && y[i][j] == 0) {
                                gtr += String.valueOf(i)+String.valueOf(j);
                                count1 = 2;
                                break;
                            }
                        }
                    }
                }
                else {
                    if(po1 >= 1 && po1 <= 5 && po2 >= 2 && po2 <= 4 && y[po1 - 1][po2 + 2] == -1 && y[po1 - 1][po2] == 0 && y[po1 + 1][po2 - 1] == 0) {
                        gtr += String.valueOf(po1 - 1)+String.valueOf(po2)+String.valueOf(po1 + 1)+String.valueOf(po2 - 1);
                        count1 = 2;
                    }
                    else {
                        for(int i = po1 - 1; i <= 6; i++) {
                            for(int j = po2 + 1; j >= 0; j--) {
                                if(count1 < 2 && y[i][j] != 1 && y[i][j] == 0) {
                                    gtr += String.valueOf(i)+String.valueOf(j);
                                    count1++;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            else {
                 if(po1 == 6 && po2 == 0 && y[po1 - 1][po2] == 0) {
                        gtr += String.valueOf(po1 - 1)+String.valueOf(po2);
                        for(int i = 6; i >= 0; i--) {
                            for(int j = 6; j >= 0; j--) {
                                if(count1 < 2 && y[i][j] == 0) {
                                    gtr += String.valueOf(i)+String.valueOf(j);
                                    count1 = 2;
                                    break;
                                }
                            }
                        }
                    }
                    else if(po1 == 6 && po2 <= 5 && y[po1 - 1][po2 + 1] == 0 && y[po1][po2 + 1] == -1 && y[po1][po2 - 1] == -1 && y[po1 - 1][po2 - 1] == 0 && y[po1 - 1][po2] == -1) {
                     gtr += String.valueOf(po1 - 1)+String.valueOf(po2 + 1)+String.valueOf(po1 - 1)+String.valueOf(po2 - 1);
                     count1 = 2;
                    }
                    else if(po1 == 6 && po2 <= 5 && y[po1 - 1][po2 + 1] == -1 && y[po1][po2 + 1] == -1 && y[po1][po2 - 1] == 0 && y[po1 - 1][po2 - 1] == 0) {
                        gtr += String.valueOf(po1)+String.valueOf(po2 - 1)+String.valueOf(po1 - 1)+String.valueOf(po2 - 1);
                        count1 = 2;
                    }
                     else if(po2 == 0 && po1 <= 5 && po1 >= 1 &&y[po1 - 1][po2] == -1 && y[po1 + 1][po2] == -1 && y[po1 + 1][po2 + 1] == -1 && y[po1][po2 + 1] == -1 && y[po1 + 1][po2 + 1] == -1) {
                    	for(int i = 6; i >= 0; i--) {
                    		for(int j = 6; j >= 0;j--) {
                    			if(count1 < 2 && y[i][j] == 0) {
                    				gtr += String.valueOf(i)+String.valueOf(j);
                    				count1++;
                    				break;
                    			}
                    		}
                    	}
                    }
                    else if(po2 == 6 && po1 <= 5 && po1 >= 1 &&y[po1 - 1][po2] == -1 && y[po1 + 1][po2] == -1 && y[po1 + 1][po2 - 1] == -1 && y[po1][po2 - 1] == -1 && y[po1 + 1][po2 - 1] == -1) {
                    	for(int i = 6; i >= 0; i--) {
                    		for(int j = 6; j >= 0;j--) {
                    			if(count1 < 2 && y[i][j] == 0) {
                    				gtr += String.valueOf(i)+String.valueOf(j);
                    				count1++;
                    				break;
                    			}
                    		}
                    	}
                    }
                    else {
                        if(po1 == 0) {
                    		for(int i = po1; i <= 6; i++) {
                                for(int j = po2; j <= 6; j++) {
                                    if(count1 < 2 && y[i][j] != 1 && y[i][j] != -1 && y[i][j] != 2) {
                                        gtr += String.valueOf(i)+String.valueOf(j);
                                        count1++;
                                        break;
                                    }
                                }
                            }
                    	}
                    	else {
                            for(int i = po1; i <= 6; i++) {
                                for(int j = 0; j <= 6; j++) {
                                    if(count1 < 2 && y[i][j] != 1 && y[i][j] != -1 && y[i][j] != 2) {
                                        gtr += String.valueOf(i)+String.valueOf(j);
                                        count1++;
                                    }
                                }
                            }
                    	}
                    }
                }
        }
        return gtr;
    }
    public static void main(String args[] ) throws Exception {
    	//Write code here
    	Scanner in = new Scanner(System.in);
    	int[][] arr = new int[7][7];
    	for(int i = 0; i < 7;i++) {
    	    for(int j = 0;j < 7; j++) {
    	        arr[i][j] = in.nextInt();
    	    }
    	}
    	int playerId = in.nextInt();
    	int secondPlayerPos1 = 6;
    	int secondPlayerPos2 = 3;
    	int firstPlayerPos1 = 0;
    	int firstPlayerPos2 = 3;
    	String availblity = "";
    	String remAva = "";
    	if(playerId == 2) {
    	    for(int i = 6;i >= 0; i-- ) {
    	        for(int j = 6; j >= 0; j--) {
    	            if(arr[i][j] == 2) {
    	                secondPlayerPos1 = i;
    	                secondPlayerPos2 = j;
    	                break;
    	            }
    	        }
    	    }
    	    availblity = findAvailabePosition(arr, 2, secondPlayerPos1, secondPlayerPos2);
    	    if(availblity.equals("NO Way")) {
    	        System.out.println("Game Over \n Player1 won");
    	    }
    	    else {
    	        String[] str1 = availblity.split(" ");
    	        int alternat1 = Integer.parseInt(str1[str1.length - 1].charAt(str1[str1.length - 1].length() - 2)+"");
    	        int alternat2 = Integer.parseInt(str1[str1.length - 1].charAt(str1[str1.length - 1].length() - 1)+"");
    	        arr[alternat1][alternat2] = 2;
    	        arr[secondPlayerPos1][secondPlayerPos2] = 0;
    	        System.out.println(alternat1+" "+alternat2);
    	        int first1 = 0;
    	        int first2 = 0;
    	        for(int k = 6; k >= 0; k--) {
    	            for(int g = 6; g >= 0; g--) {
    	                if(arr[k][g] == 1) {
    	                    first1 = k;
    	                    first2 = g;
    	                    break;
    	                }
    	            }
    	        }
    	        remAva = removeAvail(arr,first1,first2,playerId);
    	        int fis1 = Integer.parseInt(remAva.charAt(0)+"");
    	        int fis2 = Integer.parseInt(remAva.charAt(1)+"");
    	        int fis3 = Integer.parseInt(remAva.charAt(2)+"");
    	        int fis4 = Integer.parseInt(remAva.charAt(3)+"");
    	        for(int l = 0; l < 7; l++) {
    	            for(int e = 0; e < 7; e++) {
    	                if((l == fis1 && e == fis2) || (l == fis3 && e == fis4)) {
    	                    arr[l][e] = - 1;
    	                }
    	            }
    	        }
    	        char[] ch = remAva.toCharArray();
    	        for(int t = 0; t < ch.length; t++) {
    	            if(t == 2) {
    	                System.out.println();
    	            }
    	            System.out.print(ch[t]+" ");
    	        }
    	    }
    	}
    	else if(playerId == 1) {
    	    for(int i = 0;i <= 6; i++ ) {
    	        for(int j = 0; j <= 6; j++) {
    	            if(arr[i][j] == 1) {
    	                firstPlayerPos1 = i;
    	                firstPlayerPos2 = j;
    	                break;
    	            }
    	        }
    	    }
    	    availblity = findAvailabePosition(arr, 1, firstPlayerPos1, firstPlayerPos2);
    	    if(availblity.equals("NO Way")) {
    	        System.out.println("Game Over \n Player2 won");
    	    }
    	    else {
    	        String[] str1 = availblity.split(" ");
    	        int alternat1 = Integer.parseInt(str1[0].charAt(str1[0].length() - 2)+"");
    	        int alternat2 = Integer.parseInt(str1[0].charAt(str1[0].length() - 1)+"");
    	        arr[alternat1][alternat2] = 1;
    	        arr[firstPlayerPos1][firstPlayerPos2] = 0;
    	        System.out.println(alternat1+" "+alternat2);
    	        int first1 = 0;
    	        int first2 = 0;
    	        for(int k = 0; k <= 6; k++) {
    	            for(int g = 0; g <= 6; g++) {
    	                if(arr[k][g] == 2) {
    	                    first1 = k;
    	                    first2 = g;
    	                    break;
    	                }
    	            }
    	        }
    	        remAva = removeAvail(arr,first1,first2,playerId);
    	        int fis1 = Integer.parseInt(remAva.charAt(0)+"");
    	        int fis2 = Integer.parseInt(remAva.charAt(1)+"");
    	        int fis3 = Integer.parseInt(remAva.charAt(2)+"");
    	        int fis4 = Integer.parseInt(remAva.charAt(3)+"");
    	        for(int l = 0; l < 7; l++) {
    	            for(int e = 0; e < 7; e++) {
    	                if((l == fis1 && e == fis2) || (l == fis3 && e == fis4)) {
    	                    arr[l][e] = - 1;
    	                }
    	            }
    	        }
    	        char[] ch = remAva.toCharArray();
    	        for(int t = 0; t < ch.length; t++) {
    	            if(t == 2) {
    	                System.out.println();
    	            }
    	            System.out.print(ch[t]+" ");
    	        }
    	    }
    	}
   }
}