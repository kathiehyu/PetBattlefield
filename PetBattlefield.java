/**
 * a battlefield for pets, where teams of pet objects battle each other.
 * @author Kathie Huynh
 * @version JDK 11.0.13
 */
public class PetBattlefield {
    private Pet[] firstTeam;
    private Pet[] secondTeam;

    /**
     * creates a pet battlefield object.
     * @param firstTeam a Pet array of the first team in the battle
     * @param secondTeam a Pet array of the second team in the battle
     */
    public PetBattlefield(Pet[] firstTeam, Pet[] secondTeam) {
        if (firstTeam.length > 5 || secondTeam.length > 5) {
            firstTeam = new Pet[5];
            secondTeam = new Pet[5];
        }
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    /**
     * creates a string representation of a team.
     * @param team the Pet array to create a string for
     * @return the String representation of the Pet team
     */
    private static String stringTeam(Pet[] team) {
        String steam = "";
        for (Pet p: team) {
            // System.out.println(p);
            if (p == null) {
                steam += "Empty";
            } else {
                steam += p.toString();
            }
            steam += ", ";
        }
        return steam.substring(0, steam.length() - 2);
    }

    @Override
    public String toString() {
        return String.format("First team: %s vs Second Team: %s",
            stringTeam(firstTeam), stringTeam(secondTeam));
    }

    /**
     * predicts the outcome of the battle between two teams.
     */
    public void compareTeams() {
        int one = 0;
        int two = 0;
        if (firstTeam.length >= secondTeam.length) { //for each pet in larger team
            for (int i = 0; i < firstTeam.length; i++) {
                if (i < secondTeam.length) { //if index in range of shorter team
                    if (firstTeam[i] != null) { //if one is not null
                        if (firstTeam[i].compareTo(secondTeam[i]) == 1) { //if one > two
                            one++; //add to one
                        } else if (firstTeam[i].compareTo(secondTeam[i]) == -1) { //if two > one
                            two++; //add to two
                        }
                    } else { //if one is null
                        if (secondTeam[i] != null) { //if two is not null
                            two++; //add to two
                        }
                    }
                } else { //no more on second team
                    if (firstTeam[i] != null) {
                        one++;
                    }
                }
            }
        } else {
            for (int i = 0; i < secondTeam.length; i++) {
                if (i < firstTeam.length) {
                    if (secondTeam[i] != null) {
                        if (secondTeam[i].compareTo(firstTeam[i]) == 1) {
                            two++;
                        } else if (secondTeam[i].compareTo(firstTeam[i]) == -1) {
                            one++;
                        }
                    } else {
                        if (firstTeam[i] != null) {
                            one++;
                        }
                    }
                } else {
                    if (secondTeam[i] != null) {
                        two++;
                    }
                }
            }
        }
        if (one > two) {
            System.out.println("The first team will probably win.");
        } else if (two > one) {
            System.out.println("The second team will probably win.");
        } else {
            System.out.println("It is an even match.");
        }
    }

    /**
     * the two Pet teams battle.
     */
    public void battle() {
        int one = 0;
        int two = 0;
        while (two < secondTeam.length && one < firstTeam.length) { //while secondTeam in index
            if (firstTeam[one] == null) {
                one++;
                continue;
            }
            if (secondTeam[two] == null) {
                two++;
                continue;
            }
            firstTeam[one].attackPet(secondTeam[two]);
            secondTeam[two].attackPet(firstTeam[one]);
            if (firstTeam[one].hasFainted()) {
                firstTeam[one] = null;
                one++;
            }
            if (secondTeam[two].hasFainted()) {
                secondTeam[two] = null;
                two++;
            }
        }
        boolean oneWon = false;
        boolean twoWon = false;
        for (int i = 0; i < firstTeam.length; i++) {
            if (firstTeam[i] != null) {
                oneWon = true;
            }
        }
        for (int i = 0; i < secondTeam.length; i++) {
            if (secondTeam[i] != null) {
                twoWon = true;
            }
        }
        if (oneWon && !twoWon) {
            System.out.println("The first team won!");
        } else if (!oneWon && twoWon) {
            System.out.println("The second team won!");
        } else {
            System.out.println("Both teams fainted.");
        }

    }
    /**
     * create and interact with Pet objects and PetBattlefield objects.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Turtle turt1 = new Turtle();
        // System.out.println(turt1.toString() + " 1: " + turt1.hasFainted());
        // Turtle turt2 = new Turtle(-3, 8, true);
        // System.out.println(turt2.toString() + " 2: " + turt2.hasFainted());
        // Turtle turt3 = new Turtle(-5, 9, false);
        // System.out.println(turt3.toString() + " 3: " + turt3.hasFainted());
        // Pet turt4 = new Turtle(8, 4, true); //implements the methods of Turtle
        // System.out.println(turt4.toString() + " 4: " + turt4.hasFainted());
        // Pet turt5 = new Turtle(-1, -2, true);
        // System.out.println(turt5.toString() + " 5: " + turt5.hasFainted());
        // Pet turt6 = new Turtle(-1, 0, true);

        // System.out.println("ATTACK ONE");
        // turt1.attackPet(turt4);
        // System.out.println(turt4.toString() + " 4: " + turt4.hasFainted());
        // turt4.attackPet(turt1);
        // System.out.println(turt1.toString() + " 1: " + turt1.hasFainted());

        // System.out.println("ATTACK TWO");
        // turt1.attackPet(turt4);
        // System.out.println(turt4.toString() + " 4: " + turt4.hasFainted());
        // turt4.attackPet(turt1);
        // System.out.println(turt1.toString() + " 1: " + turt1.hasFainted());

        // Hippo hippo1 = new Hippo();
        // System.out.println(hippo1.toString() + " 1:" + hippo1.hasFainted());
        // Pet hippo2 = new Hippo(11, 7, 3);
        // System.out.println(hippo2.toString() + " 2:" + hippo2.hasFainted());
        // Pet hippo3 = new Hippo(14, -6, -2);
        // System.out.println(hippo3.toString() + " 3:" + hippo3.hasFainted());
        // Hippo hippo4 = new Hippo(17, 5, 4);
        // System.out.println(hippo4.toString() + " 4:" + hippo4.hasFainted());
        // Hippo hippo5 = new Hippo(-1, 6, 2);
        // System.out.println(hippo5.toString() + " 5:" + hippo5.hasFainted());

        // System.out.println("ATTACK UNTIL FAINT");
        // ((Hippo) hippo2).getBuffed();
        // System.out.println(hippo2.toString() + " 2:" + hippo2.hasFainted());
        // ((Hippo) hippo2).attackPet(hippo3);
        // System.out.println(hippo2.toString() + " 2:" + hippo2.hasFainted());
        // System.out.println(hippo3.toString() + " 3:" + hippo3.hasFainted());
        // ((Hippo) hippo2).attackPet((hippo3));
        // System.out.println(hippo2.toString() + " 2:" + hippo2.hasFainted());
        // System.out.println(hippo3.toString() + " 3:" + hippo3.hasFainted());

        // Skunk sknk1 = new Skunk();
        // System.out.println(sknk1.toString());
        // Skunk skunk2 = new Skunk(12, 4, 3);
        // System.out.println(skunk2.toString());
        // Skunk skunk3 = new Skunk(-2, -5, -2);
        // System.out.println(skunk3.toString());
        // Skunk skunk4 = new Skunk(75, 15, 10);
        // System.out.println(skunk4.toString());

        // System.out.println("SPRAY TIL YOU CANT");
        // skunk2.attackPet(skunk4);
        // System.out.println(skunk4.toString());
        // skunk2.attackPet(skunk4);
        // System.out.println(skunk4.toString());
        // skunk2.attackPet(skunk4);
        // System.out.println(skunk4.toString());
        // skunk2.attackPet(skunk4);
        // System.out.println(skunk4.toString());

        // Skunk skunk5 = new Skunk(8, 4, 10);
        // Pet hippo6 = new Hippo(8, 4, 10);

        // System.out.println(skunk4.compareTo((Pet) null));
        // System.out.println(skunk4.compareTo(skunk2));
        // System.out.println(hippo4.compareTo(hippo3));
        // System.out.println(hippo4.compareTo(turt1));
        // System.out.println(turt4.compareTo(turt1));
        // System.out.println(turt4.compareTo(skunk2));
        // System.out.println(turt5.compareTo(turt6));
        // System.out.println(skunk4.compareTo(skunk5));
        // System.out.println(skunk5.compareTo(hippo6));

        Pet turtle1 = new Turtle(8, 15, true);
        Turtle turtle2 = new Turtle();
        Turtle turtle3 = new Turtle(15, 8, false);
        Turtle turtle3Copy = new Turtle(15, 8, false);
        Pet turtle4 = new Turtle(12, 5, true);

        Hippo hippo1 = new Hippo();
        Pet hippo2 = new Hippo(10, 3, 3);
        Hippo hippo3 = new Hippo(15, 2, 4);
        Hippo hippo4 = new Hippo(5, 10, 2);

        Skunk skunk1 = new Skunk();
        Skunk skunk2 = new Skunk(13, 4, 2);
        Skunk skunk3 = new Skunk(10, 2, 4);
        Pet skunk4 = new Skunk(20, 1, 3);
        Pet skunk4Copy = new Skunk(20, 1, 3);

        Pet[] teamOne = {null, turtle3, skunk4, hippo2};
        Pet[] teamTwo = {turtle1, hippo3, skunk4Copy};
        Pet[] teamThree = {turtle4, skunk3, hippo1, hippo3};
        Pet[] teamFour = {null, skunk3, skunk4Copy, null, hippo3};
        Pet[] teamFive = {turtle2, hippo1, skunk1, hippo4, turtle3Copy};
        Pet[] teamSix = {null, skunk3, turtle2, null, hippo3};

        PetBattlefield round1 = new PetBattlefield(teamOne, teamTwo);
        PetBattlefield round2 = new PetBattlefield(teamOne, teamThree);
        PetBattlefield round3 = new PetBattlefield(teamOne, teamFour);
        PetBattlefield round4 = new PetBattlefield(teamOne, teamFive);
        PetBattlefield round5 = new PetBattlefield(teamTwo, teamThree);
        PetBattlefield round6 = new PetBattlefield(teamTwo, teamFour);
        PetBattlefield round7 = new PetBattlefield(teamTwo, teamFive);
        PetBattlefield round8 = new PetBattlefield(teamThree, teamFour);
        PetBattlefield round9 = new PetBattlefield(teamThree, teamFive);
        PetBattlefield round0 = new PetBattlefield(teamFour, teamFive);

        System.out.println(round1.toString());
        System.out.println(round3.toString());


        round1.compareTeams(); //first
        round2.compareTeams(); //tie
        round3.compareTeams(); //first
        round4.compareTeams(); //second
        round5.compareTeams(); //first
        round6.compareTeams(); //first
        round7.compareTeams(); //first
        round8.compareTeams(); //tie
        round9.compareTeams(); //first
        round0.compareTeams(); //second

        // round1.battle(); //can hippos revive?
        // round2.battle(); //good
        // round3.battle(); //infinite loop?
        // round4.battle(); //would tie, but hippo revived
        // round5.battle(); //infinite loop?
        // round6.battle();
        round7.battle();
        // // round8.battle(); //infinite loop?
        round9.battle();
        round0.battle();
    }
}