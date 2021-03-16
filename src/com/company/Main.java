package com.company;


//Program to make random DnD characters given a level to start at


//by Roy McIntosh
//started final week of high school were the stats program was made
//after graduation random name program was made then a program to select a
//random race and class was made (RaceClass.java)
//and the other programs were added to it
//the rest as they say is History (the int based skill)


import java.util.Random;

import java.io.*;

class Main
{
    public static void main(String[]args) throws IOException
    {
        //code to get input from the user
        BufferedReader inString = new BufferedReader(new InputStreamReader(System.in));
        Random rand = new Random();

        //value to see if the charater is a NPC (just gives them slightly worse stats(later))
        boolean NPC = false;

        //variables for customizing
        boolean cust;
        int custRace = 11;
        int custClass = 14;

        //asks the user if they want to customize their charicter
        System.out.println("Would you like to customize?(y/n)");
        String input = inString.readLine();

        //sets the boolean variable to true of false depending on if the user wants to customize
        if(input.equals("y"))
            cust = true;
        else
            cust = false;


        if (cust)
        {
            //asks the user if they would like an NPC variable NPC becomes true if they want a NPC
            System.out.println("Would you like a NPC? y/n");
            input = inString.readLine();
            if (input.equals("y"))
                NPC = true;
            else if (input.equals("n"))
                NPC = false;
            else
                System.out.println("Not and NPC then.");

            System.out.println("Would you like to pick your Race?(y/n)");
            input = inString.readLine();
            if (input.equals("y"))
            {
                System.out.println("Enter the number beside the Race you want:");
                System.out.println("1-Dwarf, 2-Elf, 3-Halfling, 4-Human, 5-Dragonborn, 6-Gnome, 7-Half-Elf, 8-Half-Orc, 9-Tiefling");
                input = inString.readLine();
                custRace = Integer.parseInt(input) - 1;
            }
            System.out.println("Would you like to pick your Class?");
            input = inString.readLine();
            if (input.equals("y"))
            {
                System.out.println("Enter the number beside the Class you want:");
                System.out.println("1-Barbarian, 2-Bard, 3-Cleric, 4-Druid, 5-Fighter, 6-Monk, 7-Paladin, 8-Ranger, 9-Rouge, 10-Sorcerer, 11-Warlock, 12-Wizard");
                input = inString.readLine();
                custClass = Integer.parseInt(input) - 1;
            }
        }

        //declaring a variable for the level of the character
        int level = 0;

        //loop to get a level that is between 1 and 20 for the character
        boolean endLoop = true;
        do
        {
            if ((level > 20) || (level < 1))
            {
                System.out.println("You must pick a level between 1 and 20");
                System.out.println("What level?");
                input = inString.readLine();
                level = Integer.parseInt(input);
            }
            else
                endLoop = false;
        }
        while(endLoop);
        System.out.println("");



        //random name

        //makes two strings for the first and last names with a random number of indexes
        //two random values are used to give the strings have and average value of 5 indexes
        String[] name1 = new String[(rand.nextInt(4) + rand.nextInt(4) + 2)];
        String[] name2 = new String[(rand.nextInt(4) + rand.nextInt(4) + 2)];

        //string array with all the vowles apparring with diffrent frequences to simulate more common letters (also includes a dash)
        String[] vowels = {"a", "a", "a", "a", "a", "e", "e", "e", "e", "e", "e", "i", "i", "i", "i", "i", "o", "o", "o", "o", "u", "u", "u", "u", "y", "y", "y", "'", "-"};

        //string array with diffrent frequences of consonants to simulate picking random letters (also includes pairs of letters like qu, th, sh, kn)
        String[] consonants = {"b", "b", "b", "c", "c","c", "d", "d", "d", "d", "f", "f", "g", "g", "h", "h", "h", "h", "j", "j", "k", "k", "k", "k", "l", "l", "m", "m", "m", "m", "m", "n", "n", "n", "n", "n", "p", "p", "qu", "qu", "r", "r", "r", "r", "s", "s", "s", "s", "t", "t", "t", "t", "t", "t", "v", "v", "w", "w", "w", "x", "x", "z", "z", "th", "th", "th", "sh", "sh", "sh", "kn", "kn"};

        //loop to fill the name arrays with letters

        //starts at index zero of name 1 and picks a letter until it gets to the last index and stops
        for (int count1 = 0; count1 < name1.length; count1++)
        {
            //picks a random number from 0 to five
            int r = rand.nextInt(6);

            //basicly what the below code does is makes every third letter a vowel and the other two consonates
            //unless the random number is 5 (1 in 5 chance) then it makes every third letter a consonate an the other ones vowels
            if (((count1 + 1) % 3 == 1) || ((count1 + 1) % 3 == 0))
                if (r < 5)
                    name1[count1] = consonants[rand.nextInt(consonants.length)];
                else
                    name1[count1] = vowels[rand.nextInt(vowels.length)];
            else
            if (r > 5)
                name1[count1] = consonants[rand.nextInt(consonants.length)];
            else
                name1[count1] = vowels[rand.nextInt(vowels.length)];
        }

        //makes the first string of the first name upper case (sometimes the first string has two letters so this dosn't work
        name1[0] = name1[0].toUpperCase();

        //prints out each string of the name to the user
        for (int count1 = 0; count1 < name1.length; count1++)
            System.out.print(name1[count1]);

        //space in between the two names
        System.out.print(" ");

        //same as for name one exsept there is a one in six chanse of switch the rarity of vowels and consonants
        for (int count2 = 0; count2 < name2.length; count2++)
        {
            int r = rand.nextInt(7);

            if (((count2 + 1) % 3 == 1) || ((count2 + 1) % 3 == 0))
                if (r < 6)
                    name2[count2] = consonants[rand.nextInt(consonants.length)];
                else
                    name2[count2] = vowels[rand.nextInt(vowels.length)];
            else
            if (r > 6)
                name2[count2] = consonants[rand.nextInt(consonants.length)];
            else
                name2[count2] = vowels[rand.nextInt(vowels.length)];
        }

        //same upper casing and printing
        name2[0] = name2[0].toUpperCase();
        for (int count2 = 0; count2 < name2.length; count2++)
            System.out.print(name2[count2]);

        //new line
        System.out.println();
        System.out.println();




        //random race and class

        //there are 9 races and 12 classes

        //makes string values for all the races and classes in DnD
        String[] races = {"Dwarf", "Elf", "Halfling", "Human", "Dragonborn", "Gnome", "Half-Elf", "Half-Orc", "Tiefling"};
        String[] classNames = {"Barbarian" , "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rouge", "Sorcerer", "Warlock", "Wizard"};

        //nothing fancy just choses an random number that corrisponds to a race to give the user a race
        int raceNumber = rand.nextInt(races.length);

        if ((cust) && (custRace != 11))
            raceNumber = custRace;

        //makes a variable for the sub race if any
        int subRace = 0;

        //getting fancy, assigning starting frenquences for each class
        int barb = 1, bard = 1, cleric = 1, druid = 1, fighter = 1, monk = 1, paladin = 1, ranger = 1, rouge = 1, sorcerer = 1, warlock = 1, wizard = 1;

        //we don't want the user to get a bad race class combo (like Dwarf Monk) often
        //so based on the ability score incresses of each race we make each class that benifits from those
        //stats more likly to be the users class

        //bases on the users race number incresse the frequence of relevent races
        //also assigns a number for their subrace if any
        switch (raceNumber)
        {
            case 0:
                fighter++;    //notice each race has six classes that they could be
                fighter++;
                barb++;
                barb++;
                cleric++;
                paladin++;

                subRace = rand.nextInt(2) + 1;
                break;
            case 1:
                ranger++;
                fighter++;
                sorcerer++;
                bard++;
                druid++;
                monk++;

                subRace = rand.nextInt(3) + 1;
                break;
            case 2:
                bard++;
                ranger++;
                warlock++;
                rouge++;
                monk++;
                sorcerer++;

                subRace = rand.nextInt(2) + 1;
                break;
            case 3:
                bard++;
                fighter++;
                paladin++;
                wizard++;
                druid++;
                rouge++;
                break;
            case 4:
                barb++;
                fighter++;
                paladin++;
                bard++;
                sorcerer++;
                warlock++;

                subRace = rand.nextInt(10) + 1;
                break;
            case 5:
                wizard++;
                wizard++;
                rouge++;
                monk++;
                ranger++;
                fighter++;

                subRace = rand.nextInt(2) + 1;
                break;
            case 6:
                bard++;
                sorcerer++;
                sorcerer++;
                wizard++;
                warlock++;
                warlock++;
                break;
            case 7:
                barb++;
                barb++;
                paladin++;
                fighter++;
                bard++;
                druid++;
                break;
            case 8:
                bard++;
                sorcerer++;
                warlock++;
                wizard++;
                druid++;
                cleric++;
                break;
        }

        //makes an array of numbers corricponding to the frequency of each class
        int[] classFrequency = {barb , bard, cleric, druid, fighter, monk, paladin, ranger, rouge, sorcerer, warlock, wizard};

        //what we're doing is making a string array that we can pick a random element from to get the users class
        //we want all classes avalible but better suited classes more likly

        //there are 12 classes plus 6 more likly classes makes 18 total choices to go in the string array
        String[] classes = new String[18];

        //making a slot number for the loop
        int slot = 0;


        //what this looped loop does is for each class puts its name is the array a number of times equal to its frenquency
        for (int countClass = 0; countClass < 12; countClass++) //for each class, repeat once, until all 12 classes are done
        {
            //for each element in the classFrenquency array, repeat a number of times equal to its frenqucy
            for (int countFrequency = 0; countFrequency < classFrequency[countClass]; countFrequency++)
            {
                //put the class name into the slot of the classNames array and move on to the next slot
                classes[slot] = classNames[countClass];
                slot++;
            }
        }

        //picks a random number from 0 to 17 (the index numbers of the classes array)
        int classNumber = rand.nextInt(18);

        //assigns a string name to the class the user will be
        String className = classes[classNumber];

        //compares the name of the users class to each value in the class list and assigns a class number
        //for the program to use when given the usesr abilitys from their class
        for (int c = 0; c < classNames.length; c++)
            if (className.equals(classNames[c]))
                classNumber = c;

        if ((cust) && (custClass != 14))
            classNumber = custClass;

        //if the user has a sub race prints out their race and sub race
        if ((raceNumber == 3) || (raceNumber == 6) || (raceNumber == 7) || (raceNumber == 8))
            System.out.println(races[raceNumber]);
        else
        {
            switch (raceNumber)
            {
                case 0:
                    if (subRace == 1)
                        System.out.println("Hill Dwarf");
                    else
                        System.out.println("Mountain Dwarf");
                    break;
                case 1:
                    if (subRace == 1)
                        System.out.println("High Elf");
                    else if (subRace == 2)
                        System.out.println("Wood Elf");
                    else
                        System.out.println("Dark Elf");
                    break;
                case 2:
                    if (subRace == 1)
                        System.out.println("Lightfoot Halfling");
                    else
                        System.out.println("Stout Hafling");
                    break;
                case 4:
                    switch (subRace)
                    {
                        case 1:
                            System.out.println("Black Dragonborn");
                            break;
                        case 2:
                            System.out.println("Blue Dragonborn");
                            break;
                        case 3:
                            System.out.println("Brass Dragonborn");
                            break;
                        case 4:
                            System.out.println("Bronze Dragonborn");
                            break;
                        case 5:
                            System.out.println("Copper Dragonborn");
                            break;
                        case 6:
                            System.out.println("Gold Dragonborn");
                            break;
                        case 7:
                            System.out.println("Green Dragonborn");
                            break;
                        case 8:
                            System.out.println("Red Dragonborn");
                            break;
                        case 9:
                            System.out.println("Silver Dragonborn");
                            break;
                        case 10:
                            System.out.println("White Dragonborn");
                            break;
                    }
                    break;
                case 5:
                    if (subRace == 1)
                        System.out.println("Forest Gnome");
                    else
                        System.out.println("Rock Gnome");
                    break;
            }
        }

        //otherwise just tells the user their race name
        System.out.println(classNames[classNumber]);




        //random background
        //string with all the backrounds
        String [] background = {"Acolyte", "Charlatan", "Criminal", "Entertainer", "Folk Hero", "Guild Artisan", "Hermit", "Noble", "Outlander", "Sage", "Sailer", "Soldier", "Urchin"};

        //random number corrisponding to each backround
        int backgroundNumber = rand.nextInt(background.length);

        //displays the backround to the user
        System.out.println(background[backgroundNumber]);

        //beacuse the backround has more story implications then gameplay implications
        //it is equally random for all users

        System.out.println();



        //random stats

        //based on the sysyem of rollong 4D6 and removing the lowest 6 times to get an array of stats

        //making varibles for each of the 4 rolls and a count varible for the loop
        int R1, R2, R3, R4, count;

        //arrays for the stats before and after they are ordered
        int[]stats = new int[6];
        int[]statsOrdered = new int [6];

        //variables for each of the six stats in DnD
        int dex = 0, str = 0, con = 0, intl = 0, wis = 0, cha = 0;

        //loop to make one stat six times

        //if the user wants an NPC they just get 3D6 for a stat
        if (NPC)
            for (count = 0; count < 6; count++)
                stats[count] = rand.nextInt(6) + rand.nextInt(6) + rand.nextInt(6) + 3;
        else
        {
            for(count = 0; count < 6; count++)
            {
                //simulating the random rolls of 4 D6
                R1 = rand.nextInt(6) + 1;
                R2 = rand.nextInt(6) + 1;
                R3 = rand.nextInt(6) + 1;
                R4 = rand.nextInt(6) + 1;

                //if statement to add the highest three numbers rolled

                //if they are all equal add any three
                if (R1 == R2 && R1 == R3 && R1 == R4)
                    stats [count] = R1 + R2 + R3;

                    //if R1 is the lowest add the other three
                else if (R1 <= R2 && R1 <= R3 && R1 <= R4)
                    stats [count] = R2 + R3 + R4;

                    //if R2 is the lowest add the other three
                else if (R2 <= R1 && R2 <= R3 && R2 <= R4)
                    stats [count] = R1 + R3 + R4;

                    //if R3 is the lowest add the other three
                else if (R3 <= R1 && R3 <= R3 && R3 <= R4)
                    stats [count] = R1 + R2 + R4;

                    //if R4 is the lowest add the other three
                else if (R4 <= R1 && R4 <= R2 && R4 <= R3)
                    stats [count] = R2 + R3 + R4;
                    //otherwise output a zero to show there is an error
                else
                    System.out.print ("0");
            }
        }

        //for each of the five other stats, compare it to each other stats not already compared
        //and if it is higher then the stat being compared it becomes the new stat
        //that is being compared to other stats
        int fin = 0;

        for (int statsCount = 5; statsCount > -1; statsCount--)
            for (int compareCount = 0; compareCount < statsCount; compareCount++)
                if ((stats[statsCount] >= stats[compareCount]) && (stats[statsCount] >= fin))
                    fin = stats[statsCount];

        //for some reason it don't work on the last stat so it is done individualy
        if (stats[0] > fin)
            fin = stats[0];

        //the above process will give the highest stat rolled
        //and then assign it to the first index of the ordered stats array
        statsOrdered[0] = fin;

        boolean end = true;

        //makes one of the highest stats zero so it is not reapeated
        for(int c = 0; c < stats.length; c++)
            if ((stats[c] == statsOrdered[0]) && end)
            {
                stats[c] = 0;
                end = false;
            }

        //starts at the first stat and goes to the next until it finds the zero stat then
        //switches the zero stat and the next stat until the zero stat is in the final slot
        //this makes the other five stats the in the first five slots
        for (int c = 0; c < 5; c++)
            if ((stats[c] == 0) && (c != 5))
            {
                stats[c] = stats[(c + 1)];
                stats[(c + 1)] = 0;
            }


        //find the highest stat of the reamaining five stats
        for (int statsCount = 4; statsCount > -1; statsCount--)
            for (int compareCount = 0; compareCount < statsCount; compareCount++)
                if ((stats[statsCount] >= stats[compareCount]) && (stats[statsCount] >= fin))
                    fin = stats[statsCount];

        //last slot still dosn't work so its done individualy
        if (stats[0] > fin)
            fin = stats[0];

        //makes the second highest stat the second value in the ordered stats array
        statsOrdered[1] = fin;

        end = true;

        //goes through each element in stats until it finds one with a value equal to the highest stat and makes it zero
        //then the loop ends so only one stat becomes zero
        for(int c = 0; c < stats.length; c++)
            if ((stats[c] == statsOrdered[1]) && end)
            {
                stats[c] = 0;
                end = false;
            }


        //for each stat in stats checks if its zero, if it is moves the value of the next elememlt into the current index
        //and makes the next element zero so in the end there will be the four other stats that are not the highest and
        //the last two elements will be zero
        for (int c = 0; c < 4; c++)
            if ((stats[c] == 0) && (c != 4))
            {
                stats[c] = stats[(c + 1)];
                stats[(c + 1)] = 0;
            }

        //puts the other four stats in the ordered list they are in a random order and are not the highest so they can
        //be assigned to any non-priority stat and it will make sense
        for (int c = 2; c < 6; c++)
            statsOrdered[c] = stats[(c - 2)];

        //assigning variables to the stat prioritys, if they don't get an index assigned to them the 6's will make errors
        int sp1 = 6, sp2 = 6;

        //array for the final stats the player gets ordered same as on acharticter sheet (Dex, Str, Con, Int, Wis, Cha)
        int[] statsFinal = new int[6];

        //random true or false value for classes that can have more then one priority stat(see case 2 which are Clerics)
        boolean tf;
        if (rand.nextInt(2) == 0)
            tf = true;
        else
            tf = false;

        switch (classNumber)
        {
            case 0:
                sp1 = 0;
                sp2 = 2;
                break;
            case 1:
                sp1 = 5;
                sp2 = 1;
                break;
            case 2:
                //clerics main stat is wisdom, but their second best stat could be strength or constution
                sp1 = 4;
                if (tf) //this gives 50% chance of each happining
                    sp2 = 2;
                else
                    sp2 = 1;
                break;
            case 3:
                sp1 = 4;
                sp2 = 2;
                break;
            case 4:
                if (tf)
                    sp1 = 0;
                else
                    sp1 = 1;
                sp2 = 2;
                break;
            case 5:
                sp1 = 1;
                sp2 = 4;
                break;
            case 6:
                sp1 = 0;
                sp2 = 5;
                break;
            case 7:
                if (tf)
                    sp1 = 0;
                else
                    sp1 = 1;
                sp2 = 4;
                break;
            case 8:
                sp1 = 1;
                sp2 = 5;
                break;
            case 9:
                sp1 = 5;
                sp2 = 2;
                break;
            case 10:
                sp1 = 5;
                sp2 = 2;
                break;
            case 11:
                sp1 = 3;
                if (tf)
                    sp2 = 2;
                else
                    sp2 = 1;
                break;
        }

        //uses the indexes from the switch statment to assign the 2 highest stats to the most usful stats for each class
        statsFinal[sp1] = statsOrdered[0];
        statsFinal[sp2] = statsOrdered[1];

        //the other four stats start at index 2 in the ordered stats array
        int statC = 2;

        //for each non-priority stat that does not have a value this loop gives it a value
        for(int c = 0; c < 6; c++)
            if (statsFinal[c] == 0)
                statsFinal[c] = statsOrdered[statC++];

        //switch statment to apply stat incresses based on the players race
        //note: check which subrace the player is and applies relevent modifers
        switch (raceNumber)
        {
            case 0:
                statsFinal[2] += 2;
                if (subRace == 1)
                    statsFinal[4]++;
                else
                    statsFinal[0] += 2;
                break;
            case 1:
                statsFinal[1] += 2;
                if (subRace == 1)
                    statsFinal[3]++;
                else if (subRace == 2)
                    statsFinal[4]++;
                else
                    statsFinal[5]++;
                break;
            case 2:
                statsFinal[1] += 2;
                if (subRace == 1)
                    statsFinal[5]++;
                else
                    statsFinal[2]++;
                break;
            case 3:
                for (int c = 0; c <= 5; c++)
                    statsFinal[c]++;
                break;
            case 4:
                statsFinal[0] += 2;
                statsFinal[5]++;
                break;
            case 5:
                statsFinal[3] += 2;
                if (subRace == 1)
                    statsFinal[1]++;
                else
                    statsFinal[2]++;
                break;
            case 6:
                statsFinal[5] += 2;
                if (sp1 == 5)
                    statsFinal[rand.nextInt(5)]++;
                else
                    statsFinal[sp1]++;
                if (sp2 == 5)
                    statsFinal[rand.nextInt(5)]++;
                else
                    statsFinal[sp2]++;
                break;
            case 7:
                statsFinal[0] += 2;
                statsFinal[2]++;
                break;
            case 8:
                statsFinal[5] += 2;
                statsFinal[3]++;
                break;
        }


        //speed

        int speed = 0;

        switch(raceNumber)
        {
            case 0:
            case 2:
            case 5:
                speed = 25;
                break;
            case 1:
                speed = 30;
                if (subRace == 2)
                    speed += 5;
                break;
            default:
                speed = 30;
                break;
        }

        System.out.println("Speed: " + speed + " feet");

        System.out.println();





        //Equitment

        System.out.println("Epuipment:");
        System.out.println("");

        String[] smw = {"club", "dagger", "greatclub", "handaxe", "javelin", "light hammer", "mace", "quarterstaff", "sickle", "spear"};
        String[] srw = {"light crossbow", "darts", "shortbow", "sling"};
        String[] sw  = {"club", "dagger", "greatclub", "handaxe", "javelin", "light hammer", "mace", "quarterstaff", "sickle", "spear","light crossbow", "darts", "shortbow", "sling"};

        String[] mmw = {"battleaxe", "flail", "glaive", "greataxe", "greatsword", "halberd", "lance", "longsword", "maul", "morningstar", "pike", "rapier", "scimitar", "shortsword", "trident", "warpick", "warhammer", "whip"};
        String[] mrw = {"blowgun", "hand crossbow", "heavy crossbow", "longbow", "net"};
        String[] mw  = {"battleaxe", "flail", "glaive", "greataxe", "greatsword", "halberd", "lance", "longsword", "maul", "morningstar", "pike", "rapier", "scimitar", "shortsword", "trident", "warpick", "warhammer", "whip", "blowgun", "hand crossbow", "heavy crossbow", "longbow", "net"};


        int smwn = rand.nextInt(smw.length);
        int srwn = rand.nextInt(srw.length);
        int swn  = rand.nextInt(sw.length);

        int mmwn = rand.nextInt(mmw.length);
        int mrwn = rand.nextInt(mrw.length);
        int mwn  = rand.nextInt(mw.length);

        int ACfrom = 0;
        boolean sheild = false;

        switch(classNumber)
        {
            case 0:
                if (rand.nextInt(2) == 0)
                    System.out.println("greataxe");
                else
                    System.out.println(mmw[mmwn]);
                if (rand.nextInt(2) == 0)
                    System.out.println("2 handaxes");
                else
                    System.out.println(sw[swn]);
                System.out.println("Explorer's pack");
                System.out.println("4 javelins");
                break;
            case 1:
                int r = rand.nextInt(3);
                if (r == 0)
                    System.out.println("Rapier");
                else if (r == 1)
                    System.out.println("Longsword");
                else
                    System.out.println(sw[swn]);
                if (rand.nextInt(2) == 0)
                    System.out.println("Diplomat's pack");
                else
                    System.out.println("Entertainer's pack");
                System.out.println("Lute");
                System.out.println("Leather armor");
                ACfrom = 1;
                System.out.println("Dagger");
                break;
            case 2:
                System.out.println("Mace");
                if (rand.nextInt(2) == 0)
                {
                    System.out.println("Scale mail");
                    ACfrom = 2;
                }
                else
                {
                    System.out.println("Leather armor");
                    ACfrom = 1;
                }
                if (rand.nextInt(2) == 0)
                    System.out.println("Light crossbow (20 Bolts)");
                else
                    System.out.println(sw[swn]);
                if (rand.nextInt(2) == 0)
                    System.out.println("Priest's pack");
                else
                    System.out.println("Explorer's pack");
                System.out.println("Sheild");
                sheild = true;
                System.out.println("Holy symbol");
                break;
            case 3:
                if (rand.nextInt(2) == 0)
                {
                    System.out.println("Wooden sheild");
                    sheild = true;
                }
                else
                    System.out.println(sw[swn]);
                if (rand.nextInt(2) == 0)
                    System.out.println("Scimitar");
                else
                    System.out.println(smw[smwn]);
                System.out.println("Leather Armor");
                ACfrom = 1;
                System.out.println("Explorer's pack");
                System.out.println("Druidic Focus");
                break;
            case 4:
                if (rand.nextInt(2) == 0)
                {
                    System.out.println("Chain mail");
                    ACfrom = 3;
                }
                else
                {
                    System.out.println("Leather armor");
                    ACfrom = 1;
                    System.out.println("Longbow (20 Arrows)");
                }
                if (rand.nextInt(2) == 0)
                {
                    System.out.println(mw[mwn]);
                    System.out.println("Sheild");
                    sheild = true;
                }
                else
                {
                    System.out.println(mw[mwn]);
                    System.out.println(mw[rand.nextInt(mw.length)]);
                }
                if (rand.nextInt(2) == 0)
                    System.out.println("Light crossbow (20 Bolts)");
                else
                    System.out.println("2 Handaxes");
                if (rand.nextInt(2) == 0)
                    System.out.println("Dungeoneer's pack");
                else
                    System.out.println("Explorer's pack");
                break;
            case 5:
                if (rand.nextInt(2) == 0)
                    System.out.println("Shortsword");
                else
                    System.out.println(sw[swn]);
                if (rand.nextInt(2) == 0)
                    System.out.println("Dungeoneer's pack");
                else
                    System.out.println("Explorer's pack");
                System.out.println("10 Darts");

                break;
            case 6:
                if (rand.nextInt(2) == 0)
                {
                    System.out.println(mw[mwn]);
                    System.out.println("Sheild");
                    sheild = true;
                }
                else
                {
                    System.out.println(mw[mwn]);
                    System.out.println(mw[rand.nextInt(mw.length)]);
                }
                if (rand.nextInt(2) == 0)
                    System.out.println("5 Javelins");
                else
                    System.out.println(mmw[mmwn]);
                if (rand.nextInt(2) == 0)
                    System.out.println("Priest's pack");
                else
                    System.out.println("Explorer's pack");
                System.out.println("Chain mail");
                ACfrom = 3;
                System.out.println("Holy Symbol");
                break;
            case 7:
                if (rand.nextInt(2) == 0)
                {
                    System.out.println("Scale mail");
                    ACfrom = 2;
                }
                else
                {
                    System.out.println("Leather armor");
                    ACfrom = 1;
                }
                if (rand.nextInt(2) == 0)
                    System.out.println("2 Shortswords");
                else
                {
                    System.out.println(smw[smwn]);
                    System.out.println(smw[rand.nextInt(smw.length)]);
                }
                if (rand.nextInt(2) == 0)
                    System.out.println("Dungeoneer's pack");
                else
                    System.out.println("Explorer's pack");
                System.out.println("Longbow (20 Arrows)");
                break;
            case 8:
                if (rand.nextInt(2) == 0)
                    System.out.println("Rapier");
                else
                    System.out.println("Shortsword");
                if (rand.nextInt(2) == 0)
                    System.out.println("Shortbow (20 Arrows)");
                else
                    System.out.println("Shortsword");
                int rnd = rand.nextInt(3);
                if (rnd == 0)
                    System.out.println("Burglar's pack");
                else if (rnd == 1)
                    System.out.println("Dungeoneer's pack");
                else
                    System.out.println("Explorer's pack");
                System.out.println("Leather armor");
                ACfrom = 1;
                System.out.println("2 Daggers");
                System.out.println("Thieve's tools");
                break;
            case 9:
                if (rand.nextInt(2) == 0)
                    System.out.println("Light crossbow (20 Bolts)");
                else
                    System.out.println(sw[swn]);
                if (rand.nextInt(2) == 0)
                    System.out.println("Component pouch");
                else
                    System.out.println("Arcane focus");
                if (rand.nextInt(2) == 0)
                    System.out.println("Dungeoneer's pack");
                else
                    System.out.println("Explorer's pack");
                System.out.println("2 Daggers");
                break;
            case 10:
                if (rand.nextInt(2) == 0)
                    System.out.println("Light crossbow (20 Bolts)");
                else
                    System.out.println(sw[swn]);
                if (rand.nextInt(2) == 0)
                    System.out.println("Component pouch");
                else
                    System.out.println("Arcane focus");
                if (rand.nextInt(2) == 0)
                    System.out.println("Scolar's pack");
                else
                    System.out.println("Dungeoneer's pack");
                System.out.println("Leather armor");
                ACfrom = 1;
                System.out.println(sw[swn]);
                System.out.println("2 Daggers");
                break;
            case 11:
                if (rand.nextInt(2) == 0)
                    System.out.println("Quarterstaff");
                else
                    System.out.println("Dagger");
                if (rand.nextInt(2) == 0)
                    System.out.println("Component pouch");
                else
                    System.out.println("Arcane focus");
                if (rand.nextInt(2) == 0)
                    System.out.println("Scolar's pack");
                else
                    System.out.println("Explorer's pack");
                System.out.println("Spellbook");
                break;
        }

        switch(backgroundNumber)
        {
            case 0:
                System.out.println("Holy Symbol");
                System.out.println("Prayer book");
                System.out.println("5 Sticks of incense");
                System.out.println("Vestaments");
                System.out.println("Common clothes");
                System.out.println("Belt pouch with 15 gp");
                break;
            case 1:
                System.out.println("Fine clothes");
                System.out.println("Disgusie kit");
                System.out.println("Tools of the con of your chioce");
                System.out.println("Belt pouch with 15 gp");
                break;
            case 2:
                System.out.println("Crowbar");
                System.out.println("Dark common clothes with a hood");
                System.out.println("Belt pouch with 15 gp");
                break;
            case 3:
                System.out.println("Musical instrument of your choice");
                System.out.println("The favor of an admirer");
                System.out.println("Costume");
                System.out.println("Belt pouch with 15 gp");
                break;
            case 4:
                System.out.println("Set of artisan's tools of your choice");
                System.out.println("Shovel");
                System.out.println("Iron pot");
                System.out.println("Common clothes");
                System.out.println("Belt pouch with 15 gp");
                break;
            case 5:
                System.out.println("Set of artisan's tools of your choice");
                System.out.println("Letter of introduction from your guild");
                System.out.println("Traveler's clothes");
                System.out.println("Belt pouch with 15 gp");
                break;
            case 6:
                System.out.println("Scroll case stuffed full of notes from your studies");
                System.out.println("Winter blanket");
                System.out.println("Common clothes");
                System.out.println("Herbalism kit");
                System.out.println("5 gp");
                break;
            case 7:
                System.out.println("Fine clothes");
                System.out.println("Signet ring");
                System.out.println("Scroll of pedigree");
                System.out.println("Purse with 25 gp");
                break;
            case 8:
                System.out.println("Staff");
                System.out.println("Hunting trap");
                System.out.println("Trophy from an animal you killed");
                System.out.println("Traveler's clothes");
                System.out.println("Belt pouch with 10 gp");
                break;
            case 9:
                System.out.println("Bottle of black ink");
                System.out.println("Quill");
                System.out.println("Small kinfe");
                System.out.println("Letter from a dead colleage posing a question you have not been able to answer");
                System.out.println("Common clothes");
                System.out.println("Belt pouch with 10 gp");
                break;
            case 10:
                System.out.println("Belaying pin");
                System.out.println("50 Foot of silk rope");
                System.out.println("Lucky charm");
                System.out.println("Common clothes");
                System.out.println("Belt pouch with 10 gp");
                break;
            case 11:
                System.out.println("Insignia of rank");
                System.out.println("Trophy from a fallen enemy");
                System.out.println("Bone dice or deck of cards");
                System.out.println("Common clothes");
                System.out.println("Belt pouch with 10 gp");
                break;
            case 12:
                System.out.println("Small knife");
                System.out.println("Map of the city you grew up in");
                System.out.println("Pet mouse");
                System.out.println("Token to remember your parents by");
                System.out.println("Common clothes");
                System.out.println("Belt pouch with 10 gp");
                break;
        }

        System.out.println("");




        //Leveling up

        int statUps = 0;

        if (classNumber == 4)
            switch (level)
            {
                case 20:
                case 19:
                    statUps++;
                case 18:
                case 17:
                case 16:
                    statUps++;
                case 15:
                case 14:
                    statUps++;
                case 13:
                case 12:
                    statUps++;
                case 11:
                case 10:
                case 9:
                case 8:
                    statUps++;
                case 7:
                case 6:
                    statUps++;
                case 5:
                case 4:
                    statUps++;
                case 3:
                case 2:
                case 1:
            }
        else if (raceNumber == 8)
            switch (level)
            {
                case 20:
                case 19:
                    statUps++;
                case 18:
                case 17:
                case 16:
                    statUps++;
                case 15:
                case 14:
                case 13:
                case 12:
                    statUps++;
                case 11:
                case 10:
                    statUps++;
                case 9:
                case 8:
                    statUps++;
                case 7:
                case 6:
                case 5:
                case 4:
                    statUps++;
                case 3:
                case 2:
                case 1:
            }
        else
            switch (level)
            {
                case 20:
                case 19:
                    statUps++;
                case 18:
                case 17:
                case 16:
                    statUps++;
                case 15:
                case 14:
                case 13:
                case 12:
                    statUps++;
                case 11:
                case 10:
                case 9:
                case 8:
                    statUps++;
                case 7:
                case 6:
                case 5:
                case 4:
                    statUps++;
                case 3:
                case 2:
                case 1:
            }

        statUps = statUps * 2;

        int rnd = rand.nextInt(6);
        int stat= rand.nextInt(6);

        for (int c = 0;c < statUps;c++)
        {
            if ((statsFinal[sp1] % 2 == 1) && (statsFinal[sp1] < 20))
                statsFinal[sp1]++;
            else if ((statsFinal[sp2] % 2 == 1) && (statsFinal[sp2] < 20))
                statsFinal[sp2]++;

            else if (statsFinal[0] < 8)
                statsFinal[0]++;
            else if (statsFinal[1] < 8)
                statsFinal[1]++;
            else if (statsFinal[2] < 8)
                statsFinal[2]++;
            else if (statsFinal[3] < 8)
                statsFinal[3]++;
            else if (statsFinal[4] < 8)
                statsFinal[4]++;
            else if (statsFinal[5] < 8)
                statsFinal[5]++;

            else if ((statsFinal[sp1] >= statsFinal[sp2]) && (statsFinal[sp1] - statsFinal[sp2]) < 4 && (statsFinal[sp1] < 20))
                statsFinal[sp1]++;
            else if ((statsFinal[sp1] >= statsFinal[sp2]) && (statsFinal[sp1] - statsFinal[sp2]) >= 4 && (statsFinal[sp2] < 20))
                statsFinal[sp2]++;
            else if ((statsFinal[sp1] < statsFinal[sp2]) && (statsFinal[sp1] < 20))
                statsFinal[sp1]++;

            else
            {
                end = true;
                while (end)
                {
                    rnd = rand.nextInt(6);
                    if (statsFinal[rnd] < 20)
                    {
                        statsFinal[rnd]++;
                        end = false;
                    }
                }
            }
        }

        int[] mods = new int[6];

        for (int c = 0; c <= 5; c++)
        {
            if ((statsFinal[c] >= 10) || (statsFinal[c] % 2 == 0))
                mods[c] = (statsFinal[c] - 10) / 2;
            else
                mods[c] = (statsFinal[c] - 10) / 2 - 1;
        }

        String[] pre = new String[6];

        for (int c = 0; c <= 5; c++)
        {
            if (statsFinal[c] > 11)
                pre[c] = "+";
            else
                pre[c] = " ";
        }

        int proBonus = level / 4;
        if (level % 4 == 0)
            proBonus--;
        proBonus += 2;

        System.out.println("Proficiency bonus: +" + proBonus);
        System.out.println("");

        System.out.println("Strength:      " + statsFinal[0] + " " + pre[0] + mods[0]);
        System.out.println("Dexterity:     " + statsFinal[1] + " " + pre[1] + mods[1]);
        System.out.println("Constitution:  " + statsFinal[2] + " " + pre[2] + mods[2]);
        System.out.println("Intelligence:  " + statsFinal[3] + " " + pre[3] + mods[3]);
        System.out.println("Wisdom:        " + statsFinal[4] + " " + pre[4] + mods[4]);
        System.out.println("Charisma:      " + statsFinal[5] + " " + pre[5] + mods[5]);

        System.out.println();




        //random skills
        System.out.println("Skills: ");

        boolean[] skillProf = new boolean [18];
        String[] skills = {"Acrobatics", "Animal Handling", "Arcana", "Athletics", "Deception", "History", "Insight", "Intimidation", "Investigation", "Medicine", "Nature", "Perception", "Performance", "Persuasion", "Religion", "Sleight of Hand", "Stealth", "Survival"};

        boolean halfElf = false;
        switch(raceNumber)
        {
            case 1:
                skillProf[11] = true;
                break;
            case 6:
                halfElf = true;
                break;
            case 7:
                skillProf[7] = true;
                break;
            default:
        }


        switch (backgroundNumber)
        {
            case 0:
                skillProf [6] = true;
                skillProf [14] = true;
                break;
            case 1:
                skillProf [4] = true;
                skillProf [15] = true;
                break;
            case 2:
                skillProf [4] = true;
                skillProf [16] = true;
                break;
            case 3:
                skillProf [0] = true;
                skillProf [12] = true;
                break;
            case 4:
                skillProf [1] = true;
                skillProf [17] = true;
                break;
            case 5:
                skillProf [6] = true;
                skillProf [13] = true;
                break;
            case 6:
                skillProf [9] = true;
                skillProf [14] = true;
                break;
            case 7:
                skillProf [5] = true;
                skillProf [13] = true;
                break;
            case 8:
                skillProf [3] = true;
                skillProf [17] = true;
                break;
            case 9:
                skillProf [2] = true;
                skillProf [5] = true;
                break;
            case 10:
                skillProf [3] = true;
                skillProf [11] = true;
                break;
            case 11:
                skillProf [3] = true;
                skillProf [7] = true;
                break;
            case 12:
                skillProf [15] = true;
                skillProf [16] = true;
                break;
        }

        int sNum;
        int c = 0;

        switch (classNumber)
        {
            case 0:
                do
                {
                    int[] sklSet = {1, 3, 7, 10, 11, 17};
                    sNum = rand.nextInt(sklSet.length);
                    if (skillProf[sklSet[sNum]] == false)
                    {
                        skillProf[sklSet[sNum]] = true;
                        c++;
                    }
                }
                while (c < 2);
                break;
            case 1:
                do
                {
                    sNum = rand.nextInt(skillProf.length);
                    if (skillProf[sNum] == false)
                    {
                        skillProf[sNum] = true;
                        c++;
                    }
                }
                while (c < 3);
                break;
            case 2:
                do
                {
                    int[] sklSet = {5, 6, 9, 13, 14};
                    sNum = rand.nextInt(sklSet.length);
                    if (skillProf[sklSet[sNum]] == false)
                    {
                        skillProf[sklSet[sNum]] = true;
                        c++;
                    }
                }
                while (c < 2);
                break;
            case 3:
                do
                {
                    int[] sklSet = {2, 1, 6, 9, 10, 11, 14, 17};
                    sNum = rand.nextInt(sklSet.length);
                    if (skillProf[sklSet[sNum]] == false)
                    {
                        skillProf[sklSet[sNum]] = true;
                        c++;
                    }
                }
                while (c < 2);
                break;
            case 4:
                do
                {
                    int[] sklSet = {0, 1, 3, 5, 6, 7, 11, 17};
                    sNum = rand.nextInt(sklSet.length);
                    if (skillProf[sklSet[sNum]] == false)
                    {
                        skillProf[sklSet[sNum]] = true;
                        c++;
                    }
                }
                while (c < 2);
                break;
            case 5:
                do
                {
                    int[] sklSet = {0, 3, 5, 6, 14, 16};
                    sNum = rand.nextInt(sklSet.length);
                    if (skillProf[sklSet[sNum]] == false)
                    {
                        skillProf[sklSet[sNum]] = true;
                        c++;
                    }
                }
                while (c < 2);
                break;
            case 6:
                do
                {
                    int[] sklSet = {3, 6, 7, 9, 13, 14};
                    sNum = rand.nextInt(sklSet.length);
                    if (skillProf[sklSet[sNum]] == false)
                    {
                        skillProf[sklSet[sNum]] = true;
                        c++;
                    }
                }
                while (c < 2);
                break;
            case 7:
                do
                {
                    int[] sklSet = {1, 3, 6, 8, 10, 11, 16, 17};
                    sNum = rand.nextInt(sklSet.length);
                    if (skillProf[sklSet[sNum]] == false)
                    {
                        skillProf[sklSet[sNum]] = true;
                        c++;
                    }
                }
                while (c < 3);
                break;
            case 8:
                do
                {
                    int[] sklSet = {0, 3, 4, 6, 7, 8, 11, 12, 13, 15, 16};
                    sNum = rand.nextInt(sklSet.length);
                    if (skillProf[sklSet[sNum]] == false)
                    {
                        skillProf[sklSet[sNum]] = true;
                        c++;
                    }
                }
                while (c < 4);
                break;
            case 9:
                do
                {
                    int[] sklSet = {2, 4, 6, 7, 13, 14};
                    sNum = rand.nextInt(sklSet.length);
                    if (skillProf[sklSet[sNum]] == false)
                    {
                        skillProf[sklSet[sNum]] = true;
                        c++;
                    }
                }
                while (c < 2);
                break;
            case 10:
                do
                {
                    int[] sklSet = {2, 4, 7, 8, 10, 14};
                    sNum = rand.nextInt(sklSet.length);
                    if (skillProf[sklSet[sNum]] == false)
                    {
                        skillProf[sklSet[sNum]] = true;
                        c++;
                    }
                }
                while (c < 2);
                break;
            case 11:
                do
                {
                    int[] sklSet = {2, 5, 6, 8, 9, 14};
                    sNum = rand.nextInt(sklSet.length);
                    if (skillProf[sklSet[sNum]] == false)
                    {
                        skillProf[sklSet[sNum]] = true;
                        c++;
                    }
                }
                while (c < 2);
                break;
        }

        if (halfElf)
        {
            do
            {
                sNum = rand.nextInt(skillProf.length);
                if (skillProf[sNum] == false)
                {
                    skillProf[sNum] = true;
                    c++;
                }
            }
            while (c < 2);
        }

        for(c = 0; c < skillProf.length; c++)
            if (skillProf[c] == true)
                System.out.println(skills[c]);

        System.out.println("");





        //features
        boolean extraHP1 = false;
        boolean extraHP2 = false;

        boolean spellcasting = false;
        int spellMod = 1;
        int spellAbil;

        System.out.println("Features:");
        switch(raceNumber)
        {
            case 0:
                System.out.println("Darkvision - 60 ft");
                System.out.println("Dwarven Resilience");
                System.out.println("Stonecunning");
                if (subRace == 0)
                {
                    System.out.println("Dwarven Toghness");
                    extraHP1 = true;
                }
                break;
            case 1:
                if (subRace == 2)
                    System.out.println("Darkvision - 120 ft");
                else
                    System.out.println("Darkvision - 60 ft");
                System.out.println("Fey Ancestry");
                System.out.println("Trance");
                if (subRace == 0)
                    System.out.println("Bouns Cantrip");
                else if (subRace == 1)
                    System.out.println("Mask of the Wild");
                else
                {
                    System.out.println("Sunlight Sensitivity");
                    System.out.println("Drow Magic");
                }
                break;
            case 2:
                System.out.println("Lucky");
                System.out.println("Brave");
                System.out.println("Halfling Nimbleness");
                if (subRace == 0)
                    System.out.println("Naturally Stealthy");
                else
                    System.out.println("Stout Resilence");
                break;
            case 3:
                break;
            case 4:
                System.out.println("Draconic Ancestry");
                System.out.println("Breath Weapon");
                System.out.println("Damage Resistance");
                break;
            case 5:
                System.out.println("Darkvision - 60 ft");
                System.out.println("Gnome Cunning");
                if (subRace == 0)
                {
                    System.out.println("Natural Illusionist");
                    System.out.println("Speak with Small Beasts");
                }
                else
                {
                    System.out.println("Artificer's Lore");
                    System.out.println("Tinker");
                }
                break;
            case 6:
                System.out.println("Darkvision - 60 ft");
                System.out.println("Fey Ancestry");
                break;
            case 7:
                System.out.println("Darkvision - 60 ft");
                System.out.println("Relenteless Endurance");
                System.out.println("Savage Attacks");
                break;
            case 8:
                System.out.println("Darkvision - 60 ft");
                System.out.println("Hellish Resistance");
                System.out.println("Infernal Legacy");
                break;
        }

        int classSpec = -1;

        switch(classNumber)
        {
            case 0:
                classSpec = rand.nextInt(2);
                int butCrit = 1;
                switch (level)
                {
                    case 20:
                        System.out.println("Primal Champion");
                    case 19:
                    case 18:
                        System.out.println("Indomitable Might");
                    case 17:
                        butCrit++;
                    case 16:
                    case 15:
                        System.out.println("Persistent Rage");
                    case 14:
                        if (classSpec == 0)
                            System.out.println("Retaliation");
                        else
                            System.out.println("Totemic Attunement");
                    case 13:
                        butCrit++;
                    case 12:
                    case 11:
                        System.out.println("Relentless Rage");
                    case 10:
                        if (classSpec == 0)
                            System.out.println("Intimidating Presence");
                        else
                            System.out.println("Spirit Walker");
                    case 9:
                        System.out.println("Brutal Critical (" + butCrit + " Dice)");
                    case 8:
                    case 7:
                        System.out.println("Feral Instinct");
                    case 6:
                        if (classSpec == 0)
                            System.out.println("Mindless Rage");
                        else
                            System.out.println("Aspect of the Beast");
                    case 5:
                        System.out.println("Extra Attack");
                        System.out.println("Fast Movement");
                    case 4:
                    case 3:
                        String path;
                        String pathAbil;
                        if (classSpec == 0)
                        {
                            path = "Path of the Berserker";
                            pathAbil = "Frenzy";
                        }
                        else
                        {
                            path = "Path of the Totem Warrior";
                            pathAbil = "Spirit Seeker";
                        }
                        System.out.println("Primal Path: " + path);
                        System.out.println(pathAbil);
                    case 2:
                        System.out.println("Reckless Attack");
                        System.out.println("Danger Sense");
                    case 1:
                        System.out.println("Rage");
                        System.out.println("Unarmored Defence");
                        ACfrom = 4;
                }
                break;
            case 1:
                classSpec = rand.nextInt(2);
                int bardIns = 6;
                int songRest = 6;
                int magSec = 1;
                int esper = 1;
                switch (level)
                {
                    case 20:
                        System.out.println("Superior Inspiration");
                    case 19:
                    case 18:
                        magSec++;
                    case 17:
                        songRest += 2;
                    case 16:
                    case 15:
                        bardIns += 2;
                    case 14:
                        magSec++;
                        if (classSpec == 0)
                            System.out.println("Peerless Skill");
                        else
                            System.out.println("Battle Magic");
                    case 13:
                        songRest += 2;
                    case 12:
                    case 11:
                    case 10:
                        bardIns += 2;
                        esper++;
                        System.out.println("Magical Secrets times " + magSec);
                    case 9:
                        songRest += 2;
                    case 8:
                    case 7:
                    case 6:
                        System.out.println("Countercharm");
                        if (classSpec == 0)
                            System.out.println("Additional Magic Secrets");
                        else
                            System.out.println("Extra Attack");
                    case 5:
                        System.out.println("Font of Inspiration");
                        bardIns += 2;
                    case 4:
                    case 3:
                        String collage;
                        String colAbil;
                        if (classSpec == 0)
                        {
                            collage = "Collage of Lore";
                            colAbil = "Cutting words";
                        }
                        else
                        {
                            collage = "Collage of Valor";
                            colAbil = "Combat Inspiration";
                        }
                        System.out.println("Bard Collage: " + collage);
                        System.out.println(colAbil);
                        System.out.println("Expertise times " + esper);
                    case 2:
                        System.out.println("Jack of All Trades");
                        System.out.println("Song of Rest (D" + songRest + ")");
                    case 1:
                        System.out.println("Spellcasting");
                        spellcasting = true;
                        spellAbil = 5;
                        System.out.println("Bardic Inpiration (D" + bardIns + ")");
                }
                break;
            case 2:
                int canDiv = 1;
                int desUndd = 1;
                classSpec = rand.nextInt(7);
                switch (level)
                {
                    case 20:
                        System.out.println("Divine Intervention Improvment");
                    case 19:
                    case 18:
                        canDiv++;
                    case 17:
                        desUndd++;
                        switch(classSpec)
                        {
                            case 0:
                                System.out.println("Visions of the Past");
                                break;
                            case 1:
                                System.out.println("Supreme Healing");
                                break;
                            case 2:
                                System.out.println("Corona of Light");
                                break;
                            case 3:
                                System.out.println("Master of Nature");
                                break;
                            case 4:
                                System.out.println("StormBorn");
                                break;
                            case 5:
                                System.out.println("Improved Duplicity");
                                break;
                            case 6:
                                System.out.println("Avatar of Battle");
                                break;
                        }
                    case 16:
                    case 15:
                    case 14:
                        desUndd++;
                    case 13:
                    case 12:
                    case 11:
                        desUndd++;
                    case 10:
                        System.out.println("Divine Intervention");
                    case 9:
                    case 8:
                        switch(classSpec)
                        {
                            case 0:
                                System.out.println("Potent Spellcasting");
                                break;
                            case 1:
                                System.out.println("Divine Strike");
                                break;
                            case 2:
                                System.out.println("Potent Spellcasting");
                                break;
                            case 3:
                                System.out.println("Divine Strike");
                                break;
                            case 4:
                                System.out.println("Divine Strike");
                                break;
                            case 5:
                                System.out.println("Divine Strike");
                                break;
                            case 6:
                                System.out.println("Divine Strike");
                                break;
                        }
                    case 7:
                    case 6:
                        canDiv++;
                        switch(classSpec)
                        {
                            case 0:
                                System.out.println("Channel Divinity: Read Thoughts");
                                break;
                            case 1:
                                System.out.println("Blessed Healer");
                                break;
                            case 2:
                                System.out.println("Improved Flare");
                                break;
                            case 3:
                                System.out.println("Dampen Elements");
                                break;
                            case 4:
                                System.out.println("Thunderbolt Strike");
                                break;
                            case 5:
                                System.out.println("Channel Divinity: Cloak of Shadows");
                                break;
                            case 6:
                                System.out.println("Channel Divinity: War Gods Blessing");
                                break;
                        }
                    case 5:
                        if (level < 8)
                            System.out.println("Destroy Undead (CR 1/2)");
                        else
                            System.out.println("Destroy Undead (CR " + desUndd + ")");
                    case 4:
                    case 3:
                    case 2:
                        System.out.println("Channel Divinity (" + canDiv +"/rest)");
                        switch(classSpec)
                        {
                            case 0:
                                System.out.println("Channel Divinity: Knowlage of the Ages");
                                break;
                            case 1:
                                System.out.println("Channel Divinity: Preserve Life");
                                break;
                            case 2:
                                System.out.println("Channel Divinity: Radiance of the Dawn");
                                break;
                            case 3:
                                System.out.println("Channel Divinity: Charm Animals and Plants");
                                break;
                            case 4:
                                System.out.println("Channel Divinity: Destructive Wrath");
                                break;
                            case 5:
                                System.out.println("Channel Divinity: Invoke Duplicity");
                                break;
                            case 6:
                                System.out.println("Channel Divinity: Guided Strike");
                                break;
                        }
                    case 1:
                        String[] domains = {"Knowlage", "Life", "light", "Nature", "Tempest", "Trickery", "War"};
                        System.out.println("Spellcasting");
                        spellcasting = true;
                        spellAbil = 4;
                        System.out.println("Divine Domain: " + domains[classSpec] + " Domain");
                        switch(classSpec)
                        {
                            case 0:
                                System.out.println("Blessings of Knowlage");
                                break;
                            case 1:
                                System.out.println("Disiple of Life");
                                break;
                            case 2:
                                System.out.println("Warding Flare");
                                break;
                            case 3:
                                System.out.println("Acolyte of Nature");
                                break;
                            case 4:
                                System.out.println("Wrath of the Storm");
                                break;
                            case 5:
                                System.out.println("Blessing of the Trickster");
                                break;
                            case 6:
                                System.out.println("War Priest");
                                break;
                        }
                }
                break;
            case 3:
                classSpec = rand.nextInt(2);
                switch (level)
                {
                    case 20:
                        System.out.println("ArchDruid");
                    case 19:
                    case 18:
                        System.out.println("Timeless Body");
                        System.out.println("Beast Spells");
                    case 17:
                    case 16:
                    case 15:
                    case 14:
                        if (classSpec == 0)
                            System.out.println("Nature's Sanctuary");
                        else
                            System.out.println("Thousand Forms");
                    case 13:
                    case 12:
                    case 11:
                    case 10:
                        if (classSpec == 0)
                            System.out.println("Nature's Ward");
                        else
                            System.out.println("Elemental Wild Shape");
                    case 9:
                    case 8:
                    case 7:
                    case 6:
                        if (classSpec == 0)
                            System.out.println("Land's Stride");
                        else
                            System.out.println("Primal Strike");
                    case 5:
                    case 4:
                    case 3:
                    case 2:
                        System.out.println("Wild shape");
                        String circle;
                        String circAbil;
                        if (classSpec == 0)
                        {
                            circle = "Circle of the Land";
                            circAbil = "Natural Recovery";
                        }
                        else
                        {
                            circle = "Circle of the Moon";
                            circAbil = "Combat Wild Shape";
                        }
                        System.out.println("Druid Circle: " + circle);
                        System.out.println(circAbil);
                    case 1:
                        System.out.println("Druidic");
                        System.out.println("Spellcasting");
                        spellcasting = true;
                        spellAbil = 4;
                        spellcasting = true;
                }
                break;
            case 4:
                classSpec = rand.nextInt(3);
                int extAtc = 1;
                int actSrg = 1;
                int indom = 1;
                String s = "";
                switch (level)
                {
                    case 20:
                        extAtc++;
                    case 19:
                    case 18:
                        if (classSpec == 0)
                            System.out.println("Survivor");
                        else if (classSpec == 1)
                            System.out.println("Improved Combat Superiority");
                        else
                            System.out.println("Improved War Magic");
                    case 17:
                        actSrg++;
                        indom++;
                    case 16:
                    case 15:
                        if (classSpec == 0)
                            System.out.println("Superior Critical");
                        else if (classSpec == 1)
                            System.out.println("Relentless");
                        else
                            System.out.println("Arcane Charge");
                    case 14:
                    case 13:
                        indom++;
                    case 12:
                    case 11:
                        extAtc++;
                    case 10:
                        if (classSpec == 0)
                            System.out.println("Additional Fighting Style");
                        else if (classSpec == 1)
                            System.out.println("Improved Combat Superiority");
                        else
                            System.out.println("Eldrich Strike");
                    case 9:
                        s = "";
                        if (indom > 1)
                            s = "s";
                        System.out.println("Indomitable (" + indom + " use" + s + ")");
                    case 8:
                    case 7:
                        if (classSpec == 0)
                            System.out.println("Remarkable Athlete");
                        else if (classSpec == 1)
                            System.out.println("Know your Enemy");
                        else
                            System.out.println("War Magic");
                    case 6:
                    case 5:
                        System.out.println("Extra Attack (" + extAtc + ")");
                    case 4:
                    case 3:
                        String archtyp;
                        String archAbil;
                        if (classSpec == 0)
                        {
                            archtyp = "Champion";
                            archAbil = "Improved Critical";
                        }
                        else if (classSpec == 1)
                        {
                            archtyp = "Battle Master";
                            archAbil = "Combat Superiority";
                        }
                        else
                        {
                            archtyp = "Eldrich Knight";
                            archAbil = "Spellcasting and Weapon Bond";
                            spellcasting = true;
                            spellMod = 3;
                            spellAbil = 3;
                        }
                        System.out.println("Martial Archetype: " + archtyp);
                        System.out.println(archAbil);
                    case 2:
                        s = "";
                        if (actSrg > 1)
                            s = "s";
                        System.out.println("Action Surge (" + actSrg + " use" + s + ")");
                    case 1:
                        System.out.println("Fighting Style");
                        System.out.println("Second Wind");
                }
                break;
            case 5:
                classSpec = rand.nextInt(3);
                int disciples = 1;
                switch (level)
                {
                    case 20:
                        System.out.println("Perfect Self");
                    case 19:
                    case 18:
                        System.out.println("Empty Body");
                    case 17:
                        if (classSpec == 0)
                            System.out.println("Quivering Palm");
                        else if (classSpec == 1)
                            System.out.println("Opportunist");
                        else
                            disciples++;
                    case 16:
                    case 15:
                        System.out.println("Timeless Body");
                    case 14:
                        System.out.println("Diamond Soul");
                    case 13:
                        System.out.println("Tougue of the Sun and Moon");
                    case 12:
                    case 11:
                        if (classSpec == 0)
                            System.out.println("Tranquility");
                        else if (classSpec == 1)
                            System.out.println("Cloak of Shadows");
                        else
                            disciples++;
                    case 10:
                        System.out.println("Purity of Body");
                    case 9:
                        System.out.println("Unarmored Movement Improvement");
                    case 8:
                    case 7:
                        System.out.println("Evasion");
                        System.out.println("Stillness of Mind");
                    case 6:
                        System.out.println("Ki Empowered Strikes");
                        if (classSpec == 0)
                            System.out.println("Wholeness of Body");
                        else if (classSpec == 1)
                            System.out.println("Shadow Step");
                        else
                            disciples++;
                    case 5:
                        System.out.println("Extra Attack");
                        System.out.println("Stunning Strike");
                    case 4:
                        System.out.println("Slow Fall");
                    case 3:
                        System.out.println("Deflect Missiles");
                        String tradis;
                        String traAbil;
                        if (classSpec == 0)
                        {
                            tradis = "Way of the Open Hand";
                            traAbil = "Open Hand Technique";
                        }
                        else if (classSpec == 1)
                        {
                            tradis = "Way of Shadow";
                            traAbil = "Shadow Arts";
                        }
                        else
                        {
                            tradis = "Way of the Four Elements";
                            traAbil = "Disciple of the Elements ";
                        }
                        System.out.println("Monastic Tradition: " + tradis);
                        if (classSpec == 2)
                            System.out.println(traAbil + " (" + disciples + " Disciples)");
                        else
                            System.out.println(traAbil);
                    case 2:
                        System.out.println("Ki");
                        System.out.println("Unarmored Movement");
                    case 1:
                        System.out.println("Unarmored Defense");
                        ACfrom = 5;
                        System.out.println("Martial Arts");
                }
                break;
            case 6:
                classSpec = rand.nextInt(3);
                switch (level)
                {
                    case 20:
                        if (classSpec == 0)
                            System.out.println("Holy Nimbus");
                        else if (classSpec == 1)
                            System.out.println("Elder Champion");
                        else
                            System.out.println("Avenging Angel");
                    case 19:
                    case 18:
                        System.out.println("Aura Improvments");
                    case 17:
                    case 16:
                    case 15:
                        if (classSpec == 0)
                            System.out.println("Purity of Spirit");
                        else if (classSpec == 1)
                            System.out.println("Undying Sentinel");
                        else
                            System.out.println("Soul of Vengance");
                    case 14:
                        System.out.println("Cleansing Touch");
                    case 13:
                    case 12:
                    case 11:
                        System.out.println("Improved Divine Smite");
                    case 10:
                        System.out.println("Aura of Courage");
                    case 9:
                    case 8:
                    case 7:
                        if (classSpec == 0)
                            System.out.println("Aura of Devotion");
                        else if (classSpec == 1)
                            System.out.println("Aura of Warding");
                        else
                            System.out.println("Relentless Avenger");
                    case 6:
                        System.out.println("Aura of Protection");
                    case 5:
                        System.out.println("Extra Attack");
                    case 4:
                    case 3:
                        System.out.println("Divine Health");
                        String oath;
                        if (classSpec == 0)
                            oath = "Oath of Devotion";
                        else if (classSpec == 1)
                            oath = "Oath of the Ancients";
                        else
                            oath = "Oath of Vengeance";
                        System.out.println(oath);
                        System.out.println("Channel Divinity");
                    case 2:
                        System.out.println("Fighting Style");
                        System.out.println("Spellcasting");
                        spellcasting = true;
                        spellMod = 2;
                        spellAbil = 5;
                        System.out.println("Divine Smite");
                    case 1:
                        System.out.println("Divine Sence");
                        System.out.println("Lay on Hands");
                }
                break;
            case 7:
                classSpec = rand.nextInt(2);
                switch (level)
                {
                    case 20:
                        System.out.println("Foe Slayer");
                    case 19:
                    case 18:
                        System.out.println("Feral Senses");
                    case 17:
                    case 16:
                    case 15:
                        if (classSpec == 0)
                            System.out.println("Superior Hunter's Defence");
                        else
                            System.out.println("Share Spells");
                    case 14:
                        System.out.println("Favored Enemy Improvment");
                        System.out.println("Vanish");
                    case 13:
                    case 12:
                    case 11:
                        if (classSpec == 0)
                            System.out.println("Multiattack");
                        else
                            System.out.println("Bestial Fury");
                    case 10:
                        System.out.println("Natrual Explorer Improvment");
                        System.out.println("Hide in Plain Sight");
                    case 9:
                    case 8:
                        System.out.println("Land's Stride");
                    case 7:
                        if (classSpec == 0)
                            System.out.println("Defensive Tactics");
                        else
                            System.out.println("Exceptional Training");
                    case 6:
                        System.out.println("Favored Enemy and Natural Explorer Improvments");
                    case 5:
                        System.out.println("Extra Attack");
                    case 4:
                    case 3:
                        System.out.print("Ranger Archetype: ");
                        if (classSpec == 0)
                        {
                            System.out.println("Hunter");
                            System.out.println("Hunter's Prey");
                        }
                        else
                        {
                            System.out.println("Beast Master");
                            System.out.println("Ranger's Companion");
                        }
                        System.out.println("Primeval Awarness");
                    case 2:
                        System.out.println("Fighting Style");
                        System.out.println("Spellcasting");
                        spellcasting = true;
                        spellMod = 2;
                        spellAbil = 4;
                    case 1:
                        System.out.println("Favored Enemy");
                        System.out.println("Natural Explorer");
                }
                break;
            case 8:
                classSpec = rand.nextInt(3);
                int exper = 1;
                switch (level)
                {
                    case 20:
                        System.out.println("Stroke of Luck");
                    case 19:
                    case 18:
                        System.out.println("Elusive");
                    case 17:
                        if (classSpec == 0)
                            System.out.println("Theif's Reflexes");
                        else if (classSpec == 1)
                            System.out.println("Death Strike");
                        else
                            System.out.println("Spell Theif");
                    case 16:
                    case 15:
                        System.out.println("Slippery Mind");
                    case 14:
                        System.out.println("Blindsense");
                    case 13:
                        if (classSpec == 0)
                            System.out.println("Use Magic Divice");
                        else if (classSpec == 1)
                            System.out.println("Impostor");
                        else
                            System.out.println("Versatile Trickster");
                    case 12:
                    case 11:
                        System.out.println("Reliable Talent");
                    case 10:
                    case 9:
                        if (classSpec == 0)
                            System.out.println("Supreme Sneak");
                        else if (classSpec == 1)
                            System.out.println("Infiltration Expertise");
                        else
                            System.out.println("Magical Ambush");
                    case 8:
                    case 7:
                        System.out.println("Evasion");
                    case 6:
                        exper++;
                    case 5:
                        System.out.println("Uncanney Dodge");
                    case 4:
                    case 3:
                        System.out.print("Roguish Archetype: ");
                        if (classSpec == 0)
                        {
                            System.out.println("Thief");
                            System.out.println("Fast Hands");
                        }
                        else if (classSpec == 1)
                        {
                            System.out.println("Assassin");
                            System.out.println("Assassinate");
                        }
                        else
                        {
                            System.out.println("Arcane Trickster");
                            System.out.println("Spellcasting");
                            spellcasting = true;
                            spellMod = 3;
                            spellAbil = 3;
                        }
                    case 2:
                        System.out.println("Cunning Action");
                    case 1:
                        System.out.println("Expertise times " + exper);
                        System.out.println("Sneak Attack");
                        System.out.println("Thieve's Cant");
                }
                break;
            case 9:
                classSpec = rand.nextInt(2);
                int meta = 2;
                switch (level)
                {
                    case 20:
                        System.out.println("Sorcerrous Restoration");
                    case 19:
                    case 18:
                        if (classSpec == 0)
                            System.out.println("Draconic Presesnce");
                        else
                            System.out.println("Spell Bombardment");
                    case 17:
                        meta++;
                    case 16:
                    case 15:
                    case 14:
                        if (classSpec == 0)
                            System.out.println("Dragon Wings");
                        else
                            System.out.println("Controlled Chaos");
                    case 13:
                    case 12:
                    case 11:
                    case 10:
                        meta++;
                    case 9:
                    case 8:
                    case 7:
                    case 6:
                        if (classSpec == 0)
                            System.out.println("Elemental Affinity");
                        else
                            System.out.println("Bend Luck");
                    case 5:
                    case 4:
                    case 3:
                        System.out.println("Metamagic (" + meta + " options)");
                    case 2:
                        System.out.println("Font of Magic");
                    case 1:
                        System.out.println("Spellcasting");
                        spellcasting = true;
                        spellAbil = 5;
                        System.out.print("Sorcerous Origin: ");
                        if (classSpec == 0)
                        {
                            System.out.println("Draconic Booldline");
                            System.out.println("Dragon Ancestor");
                            System.out.println("Draconic Resilience");
                            ACfrom = 6;
                            extraHP2 = true;
                        }
                        else
                        {
                            System.out.println("Wild Magic");
                            System.out.println("Wild Magic Surge");
                            System.out.println("Tides of Chaos");
                        }
                }
                break;
            case 10:
                classSpec = rand.nextInt(3);
                int boon = rand.nextInt(3);
                switch (level)
                {
                    case 20:
                        System.out.println("Eldrich Master");
                    case 19:
                    case 18:
                    case 17:
                        System.out.println("Mystic Arcanum (9th level)");
                    case 16:
                    case 15:
                        System.out.println("Mystic Arcanum (8th level)");
                    case 14:
                        if (classSpec == 0)
                            System.out.println("Dark Delirium");
                        else if (classSpec == 1)
                            System.out.println("Hurl Through Hell");
                        else
                            System.out.println("Create Thrall");
                    case 13:
                        System.out.println("Mystic Arcanum (7th level)");
                    case 12:
                    case 11:
                        System.out.println("Mystic Arcanum (6th level)");
                    case 10:
                        if (classSpec == 0)
                            System.out.println("Beguiling Defenses");
                        else if (classSpec == 1)
                            System.out.println("Fiendish Resilience");
                        else
                            System.out.println("Thought Sheild");
                    case 9:
                    case 8:
                    case 7:
                    case 6:
                        if (classSpec == 0)
                            System.out.println("Misty Escape");
                        else if (classSpec == 1)
                            System.out.println("Dark One's Own Luck");
                        else
                            System.out.println("Entropic Ward");
                    case 5:
                    case 4:
                    case 3:
                        System.out.print("Pact Boon: ");
                        if (boon == 0)
                            System.out.println("Pact of the Chain");
                        else if (boon == 1)
                            System.out.println("Pact of the Blade");
                        else
                            System.out.println("Pact of the Tome");
                    case 2:
                    case 1:
                        System.out.println("Otherworldly Patron: ");
                        if (classSpec == 0)
                        {
                            System.out.println("The Archfey");
                            System.out.println("Fey Presence");
                        }
                        else if (classSpec == 1)
                        {
                            System.out.println("The Fiend");
                            System.out.println("Dark One's Blessing");
                        }
                        else
                        {
                            System.out.println("The Great Old One");
                            System.out.println("Awakened Mind");
                        }
                        System.out.println("Pact Magic");
                        spellcasting = true;
                        spellAbil = 5;
                }
                break;
            case 11:
                classSpec = rand.nextInt(8);
                switch (level)
                {
                    case 20:
                        System.out.println("Signature Spell");
                    case 19:
                    case 18:
                        System.out.println("Spell Mastery");
                    case 17:
                    case 16:
                    case 15:
                    case 14:
                        switch(classSpec)
                        {
                            case 0:
                                System.out.println("Spell Resistance");
                                break;
                            case 1:
                                System.out.println("Durable Summons");
                                break;
                            case 2:
                                System.out.println("Greater Protent");
                                break;
                            case 3:
                                System.out.println("Alter Memories");
                                break;
                            case 4:
                                System.out.println("Overchannel");
                                break;
                            case 5:
                                System.out.println("Illusory Reality");
                                break;
                            case 6:
                                System.out.println("Command Undead");
                                break;
                            case 7:
                                System.out.println("Master Transmuter");
                                break;
                        }
                    case 13:
                    case 12:
                    case 11:
                    case 10:
                        switch(classSpec)
                        {
                            case 0:
                                System.out.println("Improved Abjuration");
                                break;
                            case 1:
                                System.out.println("Focused Conjuration");
                                break;
                            case 2:
                                System.out.println("The Third Eye");
                                break;
                            case 3:
                                System.out.println("Split Enchantment");
                                break;
                            case 4:
                                System.out.println("Empowered Evocation");
                                break;
                            case 5:
                                System.out.println("Illusory Self");
                                break;
                            case 6:
                                System.out.println("Inured to Undeath");
                                break;
                            case 7:
                                System.out.println("Shapechanger");
                                break;
                        }
                    case 9:
                    case 8:
                    case 7:
                    case 6:
                        switch(classSpec)
                        {
                            case 0:
                                System.out.println("Projected Ward");
                                break;
                            case 1:
                                System.out.println("Benign Transposition");
                                break;
                            case 2:
                                System.out.println("Expert Divination");
                                break;
                            case 3:
                                System.out.println("Instinctive Charm");
                                break;
                            case 4:
                                System.out.println("Potent Cantrip");
                                break;
                            case 5:
                                System.out.println("Malleable Illusions");
                                break;
                            case 6:
                                System.out.println("Undead Thralls");
                                break;
                            case 7:
                                System.out.println("Transmuter's Stone");
                                break;
                        }
                    case 5:
                    case 4:
                    case 3:
                    case 2:
                        System.out.print("Arcane Tradition: School of ");
                        switch(classSpec)
                        {
                            case 0:
                                System.out.println("Abjuration");
                                System.out.println("Abjuration Savant");
                                System.out.println("Arcane Ward");
                                break;
                            case 1:
                                System.out.println("Conjuration");
                                System.out.println("Conjuration Savant");
                                System.out.println("Minor Conjuration");
                                break;
                            case 2:
                                System.out.println("Divination");
                                System.out.println("Divination Savant");
                                System.out.println("Portent");
                                break;
                            case 3:
                                System.out.println("Enchantment");
                                System.out.println("Enchantment Savant");
                                System.out.println("Hypnotic Gaze");
                                break;
                            case 4:
                                System.out.println("Evocation");
                                System.out.println("Evocation Savant");
                                System.out.println("Sculpt Spells");
                                break;
                            case 5:
                                System.out.println("Illusion");
                                System.out.println("Illusion Savant");
                                System.out.println("Improved Minor Illusion");
                                break;
                            case 6:
                                System.out.println("Necromancy");
                                System.out.println("Necromancy Savant");
                                System.out.println("Grim Harvest");
                                break;
                            case 7:
                                System.out.println("Transmutation");
                                System.out.println("Transmutation Savant");
                                System.out.println("Minor Alchemy");
                                break;
                        }
                    case 1:
                        System.out.println("Spellcasting");
                        spellcasting = true;
                        spellAbil = 3;
                        System.out.println("Arcane Recovery");
                }
                break;
        }




        //Health Points

        int HP = 0;
        int HD = 0;

        switch(classNumber)
        {
            case 0:
                HP = 12;
                HD = 12;
                break;
            case 4:
            case 6:
            case 7:
                HP = 10;
                HD = 10;
                break;
            case 9:
            case 11:
                HP = 6;
                HD = 6;
                break;
            default:
                HP = 8;
                HD = 8;
                break;
        }

        HP += mods[2];

        for (c = 0;c < level - 1; c++)
        {
            int num = rand.nextInt(HD) + 1;
            if (num < 3)
                num = (HD / 2) + 1;
            HP += num + mods[2];
        }

        if (extraHP1)
            HP += level;

        if (extraHP2)
            HP += level;

        System.out.println("");

        System.out.println("Hit Points: " + HP);
        System.out.println("Hit Dice: " + level + "D" + HD);

        System.out.println("");




        //Armor Class
        int AC = 0;
        boolean stealthDis = false;

        switch(ACfrom)
        {
            case 0: //no Armor
                AC = 10 + mods[1];
                break;
            case 1: //leather armor
                AC = 11 + mods[1];
                break;
            case 2: //scale mail
                if (mods[1] > 2)
                    AC = 16;
                else
                    AC = 14 + mods[1];
                stealthDis = true;
                break;
            case 3: //chain mail armor
                AC = 16;
                stealthDis = true;
                break;
            case 4: //barb unarmored defense
                AC = 10 + mods[1] + mods[2];
                break;
            case 5: //monk unarmored defence
                AC = 10 + mods[1] + mods[4];
                break;
            case 6: //sorcrer dragon bloodline
                AC = 13 + mods[1];
                break;
        }

        if (sheild)
            AC += 2;

        System.out.println("Armor Class: " + AC);
        if (stealthDis)
            System.out.println("Disadvantage on Stealth checks");




        //Languages

        String[] standLan = {"Common", "Dwarvish", "Elvish", "Giant", "Gnomish", "Goblin", "Halfling", "Orc"};
        int stand = 8;

        String[] exoticLan = {"Abyssal", "Celestial", "Draconic", "Deep Speech", "Infernal", "Primordial", "Sylvan", "Undercommon"};
        int exotic = 8;

        String[] languages = {"Common", "Dwarvish", "Elvish", "Giant", "Gnomish", "Goblin", "Halfling", "Orc", "Abyssal", "Celestial", "Draconic", "Deep Speech", "Infernal", "Primordial", "Sylvan", "Undercommon"};
        boolean[] langTrue = new boolean [16];

        boolean druidic = false, thievesCant = false, allLangs = false;

        langTrue[0] = true;

        int randomLangs = 0;

        switch(raceNumber)
        {
            case 0:
                langTrue[1] = true;
                break;
            case 1:
                langTrue[2] = true;
                if (subRace == 1)
                    randomLangs++;
                else if (subRace == 3)
                    langTrue[15] = true;
                break;
            case 2:
                langTrue[6] = true;
                break;
            case 3:
                randomLangs++;
                break;
            case 4:
                langTrue[10] = true;
                break;
            case 5:
                langTrue[4] = true;
                break;
            case 6:
                langTrue[2] = true;
                randomLangs++;
            case 7:
                langTrue[7] = true;
                break;
            case 8:
                langTrue[12] = true;
                break;
        }

        switch(classNumber)
        {
            case 2:
                if (classSpec == 0)
                    randomLangs += 2;
                break;
            case 3:
                druidic = true;
                break;
            case 5:
                if (level <= 13)
                    allLangs = true;
                break;
            case 8:
                thievesCant = true;
                break;
            case 11:
                if ((classSpec == 2) && (level <= 10))
                    allLangs = true;
                break;
            default:
        }

        switch(backgroundNumber)
        {
            case 5:
            case 6:
            case 7:
            case 8:
                randomLangs++;
                break;
            case 0:
            case 9:
                randomLangs += 2;
                break;
            default:
        }

        int randLangNum;
        c = 0;

        while (c < randomLangs)
        {
            if (rand.nextInt(3) == 0)
                randLangNum = rand.nextInt(exotic) + stand;
            else
                randLangNum = rand.nextInt(stand);

            if (langTrue[randLangNum] == false)
            {
                langTrue[randLangNum] = true;
                c++;
            }
        }


        System.out.println("");
        System.out.println("Languages:");

        if (allLangs)
            System.out.println("You can understand all languages");
        else
        {
            if (druidic)
                System.out.println("Druidic");

            if (thievesCant)
                System.out.println("Thieves' Cant");

            for (c = 0; c <= 15; c++)
                if (langTrue[c])
                    System.out.println(languages[c]);
        }



        //Spellcasting

        if (spellcasting)
        {
            int[] spellSlots = {4, 3, 3, 3, 3, 2, 2, 1, 1};

            int spellLevel = level / spellMod;

            int maxLevel = 9;

            if (((spellMod == 3) && (level % 3 != 0)))
                spellLevel++;
            else if ((spellMod == 2) && (level % 2 != 0))
                spellLevel++;


            switch (++spellLevel)
            {
                case 1:
                case 2:
                    spellSlots[0]--;
                case 3:
                    spellSlots[0]--;
                    spellSlots[1] -= 2;
                    maxLevel--;
                case 4:
                    spellSlots[1]--;
                case 5:
                    spellSlots[2] -= 2;
                    maxLevel--;
                case 6:
                    spellSlots[2]--;
                case 7:
                    spellSlots[3]--;
                    maxLevel--;
                case 8:
                    spellSlots[3]--;
                case 9:
                    spellSlots[3]--;
                    spellSlots[4]--;
                    maxLevel--;
                case 10:
                    spellSlots[4]--;
                case 11:
                    spellSlots[5]--;
                    maxLevel--;
                case 12:
                case 13:
                    spellSlots[6]--;
                    maxLevel--;
                case 14:
                case 15:
                    spellSlots[7]--;
                    maxLevel--;
                case 16:
                case 17:
                    spellSlots[8]--;
                    maxLevel--;
                case 18:
                    spellSlots[4]--;
                case 19:
                    spellSlots[5]--;
                case 20:
                    spellSlots[6]--;
                case 21:
            }

            System.out.println("");
            System.out.println("Spell Slots:");

            for (c = 0; c < 9; c++)
                if (spellSlots[c] != 0)
                    System.out.println("Level " + (c + 1) + ": " + spellSlots[c] + " slots");

            //  String[] lvl0Spells = {"Acid Splash", "Blade Ward", "Chill Touch", "Dancing Lights", "Druidcraft", "Eldrich Blast", "Fire Bolt", "Friends", "Guidance", "Light", "Mage Hand", "Mending", "Message", "Minor Illusion", "Poison Spray", "Prestidigitation", "Produce Flame", "Ray of Frost", "Resistance", "Sacred Falme", "Shillelagh", "Shocking Grasp", "Spare the Dying", "Thaumaturgy",
            //          "Thorn Whip", "True Strike", "Vicious Mockery"};

            //  String[] lvl1Spells = {"Alarm", "Animal Freindship", "Armor of Agathys", "Arms of Hadar", "Bane", "Bless", "Burning Hands", "Charm Person", "Chromatic Orb", "Color Spray", "Command", "Compelled Duel", "Comprehend Languages", "Create or Destroy Water", "Cure Wounds", "Detect Evil and Good", "Detect Magic", "Detect Poison and Disease", "Disguise Self", "Dissonant Whispers", "Divine Favor", "Ensnaring Strike", "Entangle", "Expeditious Retreat", "Faerie Fire", "False Life", "Feather Fall", "Find Familiar", "Fog Cloud", "Goodberry", "Grease", "Guiding Bolt", "Hail of Thorns", "Healing Word", "Hellish Rebuke", "Heroism", "Hex", "Hunter's Mark", "Identify", "Illusory Script", "Inflict Wounds", "Jump", "Longstrider", "Mage Armor", "Magic Missile", "Protection from Good and Evil", "Purify Food and Drink", "Ray of Sickness", "Sanctuary", "Searing Smite", "Sheild", "Sheild of Faith", "Silent Image", "Sleep", "Speak with Animals", "Tasha's Hideous Laughter", "Tenser's Floating Disk", "Thunderous Smite",                                      //           "Thunderwave", "Unseen Servant", "Witch Bolt", "Wrathful Smite"};

            //  String[] lvl2Spells = {"Aid", "Alter Self", "Animal Messenger", "Arcane Lock", "Augury", "Barkskin", "Beast Sense", "Blindness/Deafness", "Blur", "Branding Smite", "Calm Emotions", "Continual Flame", "Cordon of Arrows", "Cloud of Daggers", "Crown of Madness", "Darkness", "Darkvision", "Detect Thoughts", "Enhance Ability", "Enlarge/Reduce", "Enthrall", "Find Steed", "Find Traps", "Flame Blade", "Flaming Sphere", "Gentle Repose", "Gust of Wind", "Heat Metal", "Hold Person", "Invisibility", "Knock", "Lesser Restoration", "Levitate", "Locate Animals or Plants", "Locate Object", "Magic Weapon", "Melf's Acid Arrow", "Mirror Image", "Misty Step", "Moonbeam", "Nystul's Magic Aura", "Pass without Trace", "Prayer of Healing", "Magic Mouth", "Phantasmal Force", "Protection from Poison", "Ray of Enfeeblement", "Rope Trick", "Scorching Ray", "See Invisibility", "Shatter", "Silence", "Spider Climb", "Spike Growth", "Spiritual Weapon", "Suggestion", "Warding Bond", "Web", "Zone of Truth"};

            //  String[] lvl3Spells = {"Animate Dead", "Aura of Vitality", "Beacon of Hope", "Bestow Curse", "Blink", "Branding Smite", "Call Lightning", "Clarivoyance", "Conjure Animals", "Conjure Barrage", "Counterspell", "Create Food and Water", "Crusader's Mantle", "Daylight", "Dispel Magic", "Elemental Weapon", "Fear", "Feign Death", "Fireball", "Fly", "Gaseous Form", "Glyph of Warding", "Haste", "Hunger of Hadar", "Hypnotic Pattern", "Leomound's Tiny Hut", "Lighning Arrow", "Lightning Blot", "Magic Circle", "Major Image", "Mass Healing Word", "Meld into Stone", "Nondetection", "Phantom Steed", "Plant Growth", "Protection from Energy", "Remove Curse", "Revivify", "Sending", "Sleet Storm", "Slow", "Speak with Dead", "Speak with Plants", "Spirit Guardians", "Stinking Cloud", "Tounges", "Vampiric Touch", "Water Breathing", "Water Walk", "Wind Wall"};

            //  String[] lvl4Spells = {"Arcane Eye", "Aura of Life", "Aura of Purity", "Banishment", "Blight", "Compulsion", "Confusion", "Conjure Minor Elementals", "Conjure Woodland Beings", "Control Water", "Death Ward", "Dimension Door", "Divination", "Dominate Beast", "Evards Black Tentacals", "Fabricate", "Fire Sheild", "Freedom of Movment", "Giant Insect", "Grasping Vine", "Greater Invisibility", "Guardian of Faith", "Hallucinatory Terrain", "Ice Storm", "Leomund's Secret Chest", "Locate Creature", "Mordenkinen's Faithful Hound", "Mordenkain's Private Sanctum", "Otiluke's Resilient Sphere", "Phantasmal Killer", "Polymorph", "Staggering Smite", "Stone Shape", "Stoneskin", "Wall of Fire"};

            //  String[] lvl5Spells = {"Animate Objects", "Antilife Shell", "Awaken", "Banishing Smite", "Bigby's Hand", "Circle of Power", "Cloudkill", "Commune", "Commune with Nature", "Cone of Cold", "Conjure Elemental", "Conjure Volley", "Contact Other Plane", "Contagnation", "Creation", "Destructive Smite", "Dispel Evil and Good", "Dominate Person", "Dream", "Flame Strike", "Geas", "Greater Restoration", "Hallow", "Hold Monster", "Insect Plague", "Legend Lore", "Mass Cure Wounds", "Mislead", "Modify Memory", "Passwall", "Planar Binding", "Raise Dead", "Rary's Telepathic Bond", "Reincarnate", "Scrying", "Seeming", "Swift Quiver", "Telekinsis", "Teleportation Circle", "Tree Stride", "Wall of Force", "Wall of Stone"};

            //   String[] lvl6Spells = {"Arcane Gate", "Blade Barrier", "Chain Lightning", "Circle of Death", "Conjure Fey", "Contingency", "Create Undead", "Disintegrate", "Drawmij's Instant Summons", "Eyebite", "Find the Path", "Flesh to Stone", "Forbiddance", "Globe of invulnerability", "Guards and Wards", "Harm", "Heal", "Heroes' Feast", "Magic Jar", "Mass Suggestion", "Move Earth", "Otiluke's Freezing Sphere", "Otto's Irrsistible Dance", "Planar Ally", "Programmed Illusion", "Sunbeam", "Transport via Plants", "True Seeing", "Wall of Ice", "Wall of Thorns", "Wind Walk", "Word of Recall"};

            //  String[] lvl7Spells = {"Conjure Celestial", "Delayed Blast Fireball", "Divine Word", "Etherealness", "Finger of Death", "Fire Storm", "Forcecage", "Mirage Arcane", "Mordenkainen's Magnificent Mansion", "Mordenkainen's Sword", "Plane Shift", "Prismatic Spray", "Project Image", "Regenerate", "Resurrection", "Reverse Gravity", "Sequester", "Silulacrum", "Symbol", "Teleport"};

            //  String[] lvl8Spells = {"Animal Shapes", "Antimagic Feild", "Antipathy/Sympathy", "Clone", "Control Weather", "Demiplane", "Dominate Monster", "Earthquake", "Feeblemind", "Glibness", "Holy Aura", "Incendiary Cloud", "Maze", "Mind Blank", "Power Word Stun", "Sunburst", "Telepathy", "Trap the Soul", "Tsunami"};

            // String[] lvl9Spells = {"Astral Projection", "Forsight", "Gate", "Imprisonment", "Mass Heal", "Meteor Swarm", "Power Word Heal", "Power Word Kill", "Prismatic Wall", "Shapechange", "Storm of Vengeance", "Time Stop", "True Polymorph", "True Resurrection", "Weird", "Wish"};


            //2D String array with every spell in D&D
            String[][] Spells = {{"Acid Splash", "Blade Ward", "Chill Touch", "Dancing Lights", "Druidcraft", "Eldrich Blast", "Fire Bolt", "Friends", "Guidance", "Light", "Mage Hand", "Mending", "Message", "Minor Illusion", "Poison Spray", "Prestidigitation", "Produce Flame", "Ray of Frost", "Resistance", "Sacred Falme", "Shillelagh", "Shocking Grasp", "Spare the Dying", "Thaumaturgy", "Thorn Whip", "True Strike", "Vicious Mockery"},
                    {"Alarm", "Animal Freindship", "Armor of Agathys", "Arms of Hadar", "Bane", "Bless", "Burning Hands", "Charm Person", "Chromatic Orb", "Color Spray", "Command", "Compelled Duel", "Comprehend Languages", "Create or Destroy Water", "Cure Wounds", "Detect Evil and Good", "Detect Magic", "Detect Poison and Disease", "Disguise Self", "Dissonant Whispers", "Divine Favor", "Ensnaring Strike", "Entangle", "Expeditious Retreat", "Faerie Fire", "False Life", "Feather Fall", "Find Familiar", "Fog Cloud", "Goodberry", "Grease", "Guiding Bolt", "Hail of Thorns", "Healing Word", "Hellish Rebuke", "Heroism", "Hex", "Hunter's Mark", "Identify", "Illusory Script", "Inflict Wounds", "Jump", "Longstrider", "Mage Armor", "Magic Missile", "Protection from Good and Evil", "Purify Food and Drink", "Ray of Sickness", "Sanctuary", "Searing Smite", "Sheild", "Sheild of Faith", "Silent Image", "Sleep", "Speak with Animals", "Tasha's Hideous Laughter", "Tenser's Floating Disk", "Thunderous Smite",                                              "Thunderwave", "Unseen Servant", "Witch Bolt", "Wrathful Smite"},
                    {"Aid", "Alter Self", "Animal Messenger", "Arcane Lock", "Augury", "Barkskin", "Beast Sense", "Blindness/Deafness", "Blur", "Branding Smite", "Calm Emotions", "Continual Flame", "Cordon of Arrows", "Cloud of Daggers", "Crown of Madness", "Darkness", "Darkvision", "Detect Thoughts", "Enhance Ability", "Enlarge/Reduce", "Enthrall", "Find Steed", "Find Traps", "Flame Blade", "Flaming Sphere", "Gentle Repose", "Gust of Wind", "Heat Metal", "Hold Person", "Invisibility", "Knock", "Lesser Restoration", "Levitate", "Locate Animals or Plants", "Locate Object", "Magic Weapon", "Melf's Acid Arrow", "Mirror Image", "Misty Step", "Moonbeam", "Nystul's Magic Aura", "Pass without Trace", "Prayer of Healing", "Magic Mouth", "Phantasmal Force", "Protection from Poison", "Ray of Enfeeblement", "Rope Trick", "Scorching Ray", "See Invisibility", "Shatter", "Silence", "Spider Climb", "Spike Growth", "Spiritual Weapon", "Suggestion", "Warding Bond", "Web", "Zone of Truth"},
                    {"Animate Dead", "Aura of Vitality", "Beacon of Hope", "Bestow Curse", "Blink", "Branding Smite", "Call Lightning", "Clarivoyance", "Conjure Animals", "Conjure Barrage", "Counterspell", "Create Food and Water", "Crusader's Mantle", "Daylight", "Dispel Magic", "Elemental Weapon", "Fear", "Feign Death", "Fireball", "Fly", "Gaseous Form", "Glyph of Warding", "Haste", "Hunger of Hadar", "Hypnotic Pattern", "Leomound's Tiny Hut", "Lighning Arrow", "Lightning Blot", "Magic Circle", "Major Image", "Mass Healing Word", "Meld into Stone", "Nondetection", "Phantom Steed", "Plant Growth", "Protection from Energy", "Remove Curse", "Revivify", "Sending", "Sleet Storm", "Slow", "Speak with Dead", "Speak with Plants", "Spirit Guardians", "Stinking Cloud", "Tounges", "Vampiric Touch", "Water Breathing", "Water Walk", "Wind Wall"},
                    {"Arcane Eye", "Aura of Life", "Aura of Purity", "Banishment", "Blight", "Compulsion", "Confusion", "Conjure Minor Elementals", "Conjure Woodland Beings", "Control Water", "Death Ward", "Dimension Door", "Divination", "Dominate Beast", "Evards Black Tentacals", "Fabricate", "Fire Sheild", "Freedom of Movment", "Giant Insect", "Grasping Vine", "Greater Invisibility", "Guardian of Faith", "Hallucinatory Terrain", "Ice Storm", "Leomund's Secret Chest", "Locate Creature", "Mordenkinen's Faithful Hound", "Mordenkain's Private Sanctum", "Otiluke's Resilient Sphere", "Phantasmal Killer", "Polymorph", "Staggering Smite", "Stone Shape", "Stoneskin", "Wall of Fire"},
                    {"Animate Objects", "Antilife Shell", "Awaken", "Banishing Smite", "Bigby's Hand", "Circle of Power", "Cloudkill", "Commune", "Commune with Nature", "Cone of Cold", "Conjure Elemental", "Conjure Volley", "Contact Other Plane", "Contagnation", "Creation", "Destructive Smite", "Dispel Evil and Good", "Dominate Person", "Dream", "Flame Strike", "Geas", "Greater Restoration", "Hallow", "Hold Monster", "Insect Plague", "Legend Lore", "Mass Cure Wounds", "Mislead", "Modify Memory", "Passwall", "Planar Binding", "Raise Dead", "Rary's Telepathic Bond", "Reincarnate", "Scrying", "Seeming", "Swift Quiver", "Telekinsis", "Teleportation Circle", "Tree Stride", "Wall of Force", "Wall of Stone"},
                    {"Arcane Gate", "Blade Barrier", "Chain Lightning", "Circle of Death", "Conjure Fey", "Contingency", "Create Undead", "Disintegrate", "Drawmij's Instant Summons", "Eyebite", "Find the Path", "Flesh to Stone", "Forbiddance", "Globe of invulnerability", "Guards and Wards", "Harm", "Heal", "Heroes' Feast", "Magic Jar", "Mass Suggestion", "Move Earth", "Otiluke's Freezing Sphere", "Otto's Irrsistible Dance", "Planar Ally", "Programmed Illusion", "Sunbeam", "Transport via Plants", "True Seeing", "Wall of Ice", "Wall of Thorns", "Wind Walk", "Word of Recall"},
                    {"Conjure Celestial", "Delayed Blast Fireball", "Divine Word", "Etherealness", "Finger of Death", "Fire Storm", "Forcecage", "Mirage Arcane", "Mordenkainen's Magnificent Mansion", "Mordenkainen's Sword", "Plane Shift", "Prismatic Spray", "Project Image", "Regenerate", "Resurrection", "Reverse Gravity", "Sequester", "Silulacrum", "Symbol", "Teleport"},
                    {"Animal Shapes", "Antimagic Feild", "Antipathy/Sympathy", "Clone", "Control Weather", "Demiplane", "Dominate Monster", "Earthquake", "Feeblemind", "Glibness", "Holy Aura", "Incendiary Cloud", "Maze", "Mind Blank", "Power Word Stun", "Sunburst", "Telepathy", "Trap the Soul", "Tsunami"},
                    {"Astral Projection", "Forsight", "Gate", "Imprisonment", "Mass Heal", "Meteor Swarm", "Power Word Heal", "Power Word Kill", "Prismatic Wall", "Shapechange", "Storm of Vengeance", "Time Stop", "True Polymorph", "True Resurrection", "Weird", "Wish"}};



            int[] SpellSpread = {1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,3,3,3,3,3,3,4,4,4,4,4,5,5,5,5,5,5,6,6,6,6,7,7,7,8,8,9,9};
            int maxSpread = FindLast(SpellSpread, maxLevel);

            int SpellsKnown;
            int[] SpellDisp = new int[maxLevel + 1];
            int[][] SpellMat = new int [10][];

            switch(classNumber)
            {
                case 1:
                    //Bard
                    SpellMat[0] = new int[] {1, 3, 7, 9, 10, 11, 12, 13, 15, 25, 26};
                    SpellMat[1] = new int[] {1, 4, 7, 12, 14, 16, 18, 19, 24, 26, 33, 35, 38, 39, 42, 52, 53, 54, 55, 58, 59};
                    SpellMat[2] = new int[] {2, 7, 10, 13, 14, 17, 18, 20, 27, 28, 29, 30, 31, 33, 34, 43, 44, 49, 50, 51, 55, 58};
                    SpellMat[3] = new int[] {3, 7, 1+4, 16, 17, 21, 24, 25, 29, 32, 34, 38, 41, 42, 44, 45};
                    SpellMat[4] = new int[] {5, 6, 11, 17, 20, 22, 25, 30};
                    SpellMat[5] = new int[] {1, 3, 18, 19, 21, 22, 24, 26, 27, 28, 29, 31, 32, 35, 36, 39};
                    SpellMat[6] = new int[] {10, 11, 15, 20, 25, 28};
                    SpellMat[7] = new int[] {4, 7, 8, 13, 14, 15, 19, 20};
                    SpellMat[8] = new int[] {7, 9, 10, 14, 15};
                    SpellMat[9] = new int[] {2, 7, 8, 13};

                    SpellsKnown = level + mods[5];

                    if (level < 4)
                        SpellDisp[0] = 3;
                    else if (level < 10)
                        SpellDisp[0] = 4;
                    else
                        SpellDisp[0] = 5;

                    break;

                case 2:
                    //Cleric
                    SpellMat[0] = new int[] {8, 9, 11, 18, 19, 22, 23};
                    SpellMat[1] = new int[] {4, 5, 10, 13, 14, 15, 16, 17, 31, 33, 40, 45, 46, 48, 51};
                    SpellMat[2] = new int[] {0, 4, 7, 10, 11, 18, 22, 25, 28, 31, 34, 42, 45, 51, 54, 56, 58};
                    SpellMat[3] = new int[] {0, 2, 3, 7, 11, 13, 14, 17, 21, 28, 30, 31, 35, 36, 37, 38, 41, 43, 45, 48};
                    SpellMat[4] = new int[] {4, 10, 11, 13, 22, 26, 33};
                    SpellMat[5] = new int[] {8, 17, 20, 21, 22, 23, 25, 26, 27, 31, 32, 35};
                    SpellMat[6] = new int[] {2, 7, 11, 13, 16, 17, 24, 28, 32};
                    SpellMat[7] = new int[] {1, 3, 4, 6, 11, 14, 15, 19};
                    SpellMat[8] = new int[] {2, 5, 8, 11};
                    SpellMat[9] = new int[] {1, 3, 5, 14};

                    SpellsKnown = level + mods[4];

                    if (level < 4)
                        SpellDisp[0] = 3;
                    else if (level < 10)
                        SpellDisp[0] = 4;
                    else
                        SpellDisp[0] = 5;

                    break;

                case 3:
                    //Druid
                    SpellMat[0] = new int[] {4, 8, 11, 14, 16, 18, 20, 24};
                    SpellMat[1] = new int[] {1, 7, 13, 14, 16, 17, 22, 24, 28, 29, 33, 41, 42, 46, 54, 58};
                    SpellMat[2] = new int[] {2, 5, 6, 16, 18, 22, 23, 24, 26, 27, 28, 31, 33, 34, 39, 41, 45, 53};
                    SpellMat[3] = new int[] {6, 8, 13, 14, 17, 31, 34, 35, 39, 42, 47, 48, 49};
                    SpellMat[4] = new int[] {5, 7, 8, 9, 10, 14, 19, 20, 23, 24, 26, 31, 33, 34, 35};
                    SpellMat[5] = new int[] {2, 3, 8, 9, 11, 21, 22, 25, 27, 31, 34, 35, 40, 42};
                    SpellMat[6] = new int[] {5, 11, 17, 18, 21, 26, 27, 30, 31};
                    SpellMat[7] = new int[] {6, 8, 11, 14, 16};
                    SpellMat[8] = new int[] {1, 3, 5, 8, 9, 16, 19};
                    SpellMat[9] = new int[] {2, 10, 11, 14};

                    SpellsKnown = level + mods[4];

                    if (level < 4)
                        SpellDisp[0] = 2;
                    else if (level < 10)
                        SpellDisp[0] = 3;
                    else
                        SpellDisp[0] = 4;

                    break;

                case 6:
                    //Palidin
                    SpellMat[1] = new int[] {5, 10, 11, 14, 15, 16, 17, 20, 35, 45, 46, 49, 51, 57, 61};
                    SpellMat[2] = new int[] {0, 9, 21, 31, 34, 35, 45, 58};
                    SpellMat[3] = new int[] {1, 5, 11, 12, 13, 14, 15, 28, 36, 37};
                    SpellMat[4] = new int[] {2, 3, 4, 11, 26, 32};
                    SpellMat[5] = new int[] {4, 6, 16, 17, 21, 32};

                    if (level%2 == 0) {
                        SpellsKnown = level/2 + mods[5]; }
                    else {
                        SpellsKnown = (level - 1)/2 + mods[5]; }

                    break;

                case 7:
                    //Ranger
                    SpellMat[1] = new int[] {0, 1, 14, 16, 17, 21, 28, 29, 32, 37, 41, 42, 54};
                    SpellMat[2] = new int[] {2, 5, 6, 12, 16, 22, 31, 33, 34, 41, 45, 51, 53};
                    SpellMat[3] = new int[] {8, 9, 13, 26, 32, 34, 35, 42, 47, 48, 49};
                    SpellMat[4] = new int[] {9, 18, 20, 26, 34};
                    SpellMat[5] = new int[] {9, 12, 37, 40};

                    if (level%2 == 0)
                        SpellsKnown = level/2 + 1;
                    else
                        SpellsKnown = (level + 1)/2 + 1;


                    break;

                case 9:
                    //Sorcerer
                    SpellMat[0] = new int[] {0, 1, 2, 3, 6, 7, 9, 10, 11, 12, 13, 14, 15, 17, 21, 25};
                    SpellMat[1] = new int[] {6, 7, 8, 9, 12, 16, 18, 23, 25, 26, 28, 41, 43, 44, 47, 50, 52, 53, 58, 60};
                    SpellMat[2] = new int[] {1, 7, 8, 13, 14, 15, 16, 17, 18, 19, 26, 28, 29, 30, 32, 37, 38, 44, 48, 49, 50, 52, 55, 57};
                    SpellMat[3] = new int[] {4, 7, 10, 13, 14, 16, 18, 19, 20, 22, 24, 27, 29, 35, 39, 40, 44, 45, 47, 48};
                    SpellMat[4] = new int[] {4, 5, 7, 12, 14, 21, 24, 31, 34, 35};
                    SpellMat[5] = new int[] {1, 7, 10, 15, 18, 24, 25, 36, 39, 42};
                    SpellMat[6] = new int[] {1, 3, 4, 8, 10, 20, 21, 26, 28};
                    SpellMat[7] = new int[] {2, 4, 5, 6, 11, 12, 16, 20};
                    SpellMat[8] = new int[] {7, 8, 12, 15, 16};
                    SpellMat[9] = new int[] {3, 6, 8, 12, 16};

                    if (level < 4)
                        SpellDisp[0] = 2;
                    else if (level < 10)
                        SpellDisp[0] = 3;
                    else
                        SpellDisp[0] = 4;

                    if (level < 12)
                        SpellsKnown = level + 1;
                    else if (level < 13)
                        SpellsKnown = 12;
                    else if (level < 15)
                        SpellsKnown = 13;
                    else if (level < 17)
                        SpellsKnown = 14;
                    else
                        SpellsKnown = 15;

                    break;

                case 10:
                    //Warlock
                    SpellMat[0] = new int[] {1, 2, 5, 7, 10, 13, 14, 15, 25};
                    SpellMat[1] = new int[] {2, 3, 7, 12, 23, 34, 36, 39, 45, 59, 60};
                    SpellMat[2] = new int[] {13, 14, 15, 20, 28, 29, 37, 38, 46, 50, 52, 55};
                    SpellMat[3] = new int[] {10, 14, 16, 19, 20, 23, 24, 28, 29, 36, 45, 46};
                    SpellMat[4] = new int[] {4, 5, 12, 23};
                    SpellMat[5] = new int[] {13, 19, 24, 35};
                    SpellMat[6] = new int[] {1, 4, 5, 7, 10, 12, 20, 28};
                    SpellMat[7] = new int[] {4, 5, 7, 11};
                    SpellMat[8] = new int[] {6, 7, 9, 10, 15};
                    SpellMat[9] = new int[] {1, 2, 4, 8, 13};

                    SpellsKnown = 2;

                    switch (level)
                    {
                        case 20:
                        case 19:
                            SpellsKnown++;
                        case 18:
                        case 17:
                            SpellsKnown++;
                        case 16:
                        case 15:
                            SpellsKnown++;
                        case 14:
                        case 13:
                            SpellsKnown++;
                        case 12:
                        case 11:
                            SpellsKnown++;
                        case 10:
                        case 9:
                            SpellsKnown++;
                        case 8:
                            SpellsKnown++;
                        case 7:
                            SpellsKnown++;
                        case 6:
                            SpellsKnown++;
                        case 5:
                            SpellsKnown++;
                        case 4:
                            SpellsKnown++;
                        case 3:
                            SpellsKnown++;
                        case 2:
                            SpellsKnown++;
                        case 1:
                    }

                    break;

                case 11:
                    //Wizard
                    SpellMat[0] = new int[] {0, 1, 2, 3, 6, 7, 9, 10, 11, 12, 13, 14, 15, 17, 21, 25};
                    SpellMat[1] = new int[] {0, 6, 7, 8, 9, 12, 16, 18, 23, 25, 26, 27, 28, 30, 38, 39, 41, 42, 43, 44, 45, 47, 50, 52, 53, 55, 56, 58, 59, 60};
                    SpellMat[2] = new int[] {1, 3, 7, 8, 11, 13, 14, 15, 16, 17, 19, 24, 25, 26, 28, 29, 30, 32, 34, 35, 36, 37, 38, 40, 43, 44, 46, 47, 48, 49, 50, 52, 55, 57};
                    SpellMat[3] = new int[] {0, 3, 4, 7, 10, 14, 16, 17, 18, 19, 20, 21, 22, 24, 25, 27, 28, 29, 32, 33, 35, 36, 38, 39, 40, 44, 45, 46, 47};
                    SpellMat[4] = new int[] {1, 4, 5, 7, 8, 10, 12, 16, 21, 23, 24, 26, 30, 31, 33, 34, 35};
                    SpellMat[5] = new int[] {1, 7, 10, 11, 13, 15, 18, 19, 21, 24, 26, 28, 29, 30, 31, 35, 36, 39, 41, 42};
                    SpellMat[6] = new int[] {1, 3, 4, 6, 7, 8, 10, 12, 15, 19, 20, 21, 25, 26, 28, 29};
                    SpellMat[7] = new int[] {2, 4, 5, 7, 8, 9, 11, 12, 13, 16, 17, 19, 20};
                    SpellMat[8] = new int[] {2, 3, 4, 5, 6, 7, 9, 12, 13, 14, 15, 16, 17, 18};
                    SpellMat[9] = new int[] {1, 2, 3, 4, 6, 8, 9, 10, 12, 13, 15, 16};

                    SpellsKnown = level + mods[3];

                    if (level < 4)
                        SpellDisp[0] = 3;
                    else if (level < 10)
                        SpellDisp[0] = 4;
                    else
                        SpellDisp[0] = 5;

                    break;
                default:
                    SpellsKnown = 0;
                    break;
            }


            for(c = 0; c < SpellsKnown; c++)
            {
                if (c < maxLevel) {
                    SpellDisp[c+1]++; }
                else {
                    SpellDisp[SpellSpread[rand.nextInt(maxSpread)]]++; }
            }

            int start = 0;
            if (classNumber == 6 || classNumber == 7)
                start = 1;

            int[] LvlS;
            int i;
            for(i = start; i < SpellDisp.length; i++)
            {
                System.out.println("");
                if (i == 0) {
                    System.out.println("Cantrips:"); }
                else {
                    System.out.println("Level " + i + " Spells:"); }
                LvlS = pickRandom(SpellMat[i], SpellDisp[i]);
                for (c = 0; c < LvlS.length; c++)
                    System.out.println(Spells[i][SpellMat[i][LvlS[c]]]);
            }
        }
    }


    //checks if an array (int[]array) contains a value (int value)
    public static boolean contains(int[]array, int value)
    {
        for(int c = 0; c < array.length;c++)
        {
            if(array[c] == value)
            {
                return true;
            }
        }
        return false;
    }

    //picks a number (int number) of diffrent elements of an array (int[]array)
    public static int[] pickRandom(int[]array, int number)
    {
        Random rand = new Random();

        int[] output = new int[number];
        int ran = rand.nextInt(array.length);
        for(int c = 0; c < number; c++)
        {
            while (contains(output, ran))
            {
                ran = rand.nextInt(array.length);
            }
            output[c] = ran;
        }
        return output;
    }

    //finds the last occurace of a number (int find) in an array (int[]array) asumming the array is orderd from lowest to highest
    public static int FindLast(int[]array, int find)
    {
        int c = 0;
        while(c <= array.length)
        {
            if(array[c] > find)
            {
                return c - 1;
            }
            else
            {
                c++;
            }
        }
        return 0;
    }
}









//extranous code that was adusted mutiple times by copying and pasting


	/*
			System.out.println("");

			switch(classSpec)
			{
			    case 0:
				System.out.println("");
				break;
			    case 1:
				System.out.println("");
				break;
			    case 2:
				System.out.println("");
				break;
			    case 3:
				System.out.println("");
				break;
			    case 4:
				System.out.println("");
				break;
			    case 5:
				System.out.println("");
				break;
			    case 6:
				System.out.println("");
				break;
			    case 7:
				System.out.println("");
				break;
			}



		switch (level)
	 	{
		    case 20:
		    case 19:
		    case 18:
		    case 17:
		    case 16:
		    case 15:
		    case 14:
		    case 13:
		    case 12:
		    case 11:
		    case 10:
		    case 9:
		    case 8:
		    case 7:
		    case 6:
		    case 5:
		    case 4:
		    case 3:
		    case 2:
		    case 1:
	   	}
		break;


			if (classSpec == 0)
			    System.out.println("");
			else if (classSpec == 1)
			    System.out.println("");
			else
			    System.out.println("");

	*/


