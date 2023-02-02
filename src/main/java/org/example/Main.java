package org.example;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();
    static File typingSound,ShopingMusic, IntroMusic, coinFalling, cashRegister;
    static AudioInputStream TypeStream,ShopStream, introStream, fallingStream, registerStream;
    static Clip type,shop,intro,coinFall, purchase;
    public static Draw artist = new Draw();
    public static Colors colors;
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        typingSound = new File("/Users/edmarpelayo/Desktop/Code Differently Labs/newDSA/newDSAProject/src/main/java/org/example/typeSoundEffect.wav");
        TypeStream = AudioSystem.getAudioInputStream(typingSound);
        type = AudioSystem.getClip();
        type.open(TypeStream);

        ShopingMusic = new File("/Users/edmarpelayo/Desktop/Code Differently Labs/newDSA/newDSAProject/src/main/java/org/example/shoppingMusic.wav");
        ShopStream = AudioSystem.getAudioInputStream(ShopingMusic);
        shop = AudioSystem.getClip();
        shop.open(ShopStream);

        //Coin Falling
        coinFalling= new File("/Users/edmarpelayo/Desktop/Code Differently Labs/newDSA/newDSAProject/src/main/java/org/example/coinFalling.wav");
        fallingStream = AudioSystem.getAudioInputStream(coinFalling);
        coinFall= AudioSystem.getClip();
        coinFall.open(fallingStream);

        cashRegister = new File("/Users/edmarpelayo/Desktop/Code Differently Labs/newDSA/newDSAProject/src/main/java/org/example/cashRegister.wav");
        registerStream = AudioSystem.getAudioInputStream(cashRegister);
        purchase = AudioSystem.getClip();
        purchase.open(registerStream);



        //Intro Music
        IntroMusic = new File("/Users/edmarpelayo/Desktop/Code Differently Labs/newDSA/newDSAProject/src/main/java/org/example/introMusic.wav");
        introStream = AudioSystem.getAudioInputStream(IntroMusic);
        intro = AudioSystem.getClip();
        intro.open(introStream);
        intro.loop(999);

        write("Hello there, Welcome to the Kingdom of Data Structures and Algorithms! ",colors.YELLOW_BOLD_BRIGHT);
        writeFaster(artist.castle, colors.WHITE_BOLD_BRIGHT);

        write("\n\nA) Recursion \nB)HashMap\nC)LinkedList\nD)Array\nE)Stack\nF)Quit\n",colors.WHITE_BOLD_BRIGHT);

        write("What would you like to learn about today?:",colors.YELLOW_BOLD_BRIGHT);

        String learning = scanner.nextLine();
        while(!learning.equals("F")){
            intro.loop(999);
            switch(learning){
                case "A":
                    intro.stop();
                    recursion(scanner);
                    break;
                case "B":
                    intro.stop();
                    HashMapDivine();
                    break;
                case "C":
                    intro.stop();
                    merchantListCreation();
                    break;
                case "D":
                    intro.stop();
                    arrayMiniGame(scanner);
                    break;
                case "E":
                    intro.stop();
                    stackRomir();
                    break;
                case "F":
                    intro.stop();
                    learning = "F";
                    break;
                default:
                    write("I don't know what you mean, so I'm ignoring you ",colors.RED);
                    break;
            }
            intro.loop(999);
            write("\n\nA) Recursion \nB)HashMap\nC)LinkedList\nD)Array\nE)Stack\nF)Quit\n\n",colors.WHITE_BOLD_BRIGHT);

            write("What would you like to learn about today?:",colors.YELLOW_BOLD_BRIGHT);
            learning = scanner.nextLine();
        }
        write("Have a Great Day! Hope you have a great day!",colors.YELLOW);
    }


    public static void write(String phrase, String desireColor) throws LineUnavailableException, IOException {
        boolean printing = true;
        type.loop(99);

       for(int i = 0; i < phrase.length() - 1; i++){
           System.out.print(desireColor + phrase.charAt(i) +
                   colors.RESET);
           try{
               Thread.sleep(40);
           }catch(InterruptedException e){
               e.printStackTrace();
           }
       }
        System.out.println();
       type.stop();
    }
    public static void writeFaster(String phrase, String desireColor) throws LineUnavailableException, IOException {
        boolean printing = true;
        type.loop(99);

        for(int i = 0; i < phrase.length() - 1; i++){
            System.out.print(desireColor + phrase.charAt(i) +
                    colors.RESET);
            try{
                Thread.sleep(5);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println();
        type.stop();
    }

    static void searchMerchants() throws LineUnavailableException, IOException {
        String[] merchantIntro = {
            "Welcome traveler. I heard you are about to Venture out for glory. However, before you go I suggest you visit the Merchants in the town.",
            "The Merchants can provide you with everything that you may need in order to have a successful journey.",
            "However, I must warn you, The Merchants are not very bright. They only know the items they carry and the direction of another Merchant.",
            "The Merchants should still all be connected though. By one merchants after another you should meet every merchants.",
            "\nHere I'll let you borrow 1000 Gold Coins ,but I except you to pay me back plus interest when you become famous",


        };
        for(String phrase : merchantIntro){
            write(phrase,colors.GREEN_BOLD_BRIGHT);
        }
        coinFall.loop(1);
        write("Would you like to start browsing? y/n:\n ",colors.GREEN_BOLD_BRIGHT);


    }
    static void merchantListCreation() throws LineUnavailableException, IOException {
        shop.loop(99999);
        List<String> inventory =  new ArrayList();
        String[] phrases = {"Today seems like a good day to spend some money.",
                "You look like you have some money, want to use it?",
                "You look poor. Care to prove me wrong?",
                "The Weather Today is quite beautiful.",
                "I heard rumors about a Dragon being found in the caves.",
                "WAKE UP WAKE UP WAKE UP, LIFE IS A SIMILUATION. YOU THINK YOU'RE PLAYING A GAME? YOU'RE WRONG, YOU ARE THE PLAYABLE CHARACTER.",
                "My Breakfast today was quite exquisite.",
                "Have you heard, the hero has arrived to slay the Demon King and his Army"
        };
        String choice = null;

        int pocketMoney = 1000;

        //Linked List Creation
        Merchant merchants = new Merchant();
        merchants.head = new Merchant.ListNode(new Merchant.Item("Bag",10));
        Merchant.ListNode shield = new Merchant.ListNode(new Merchant.Item("Shield",40));
        Merchant.ListNode boots = new Merchant.ListNode(new Merchant.Item("Pair of Boots",10));
        Merchant.ListNode potion = new Merchant.ListNode(new Merchant.Item("Potion",8));
        Merchant.ListNode Helmet = new Merchant.ListNode(new Merchant.Item("Helmet", 30));
        Merchant.ListNode bow = new Merchant.ListNode(new Merchant.Item("Bow",12));
        Merchant.ListNode arrow = new Merchant.ListNode(new Merchant.Item("arrow", 2));
        Merchant.ListNode sword = new Merchant.ListNode(new Merchant.Item("sword",50));

        //Linked List Connection
        merchants.head.next = shield;
        shield.next = boots;
        boots.next = potion;
        potion.next = Helmet;
        Helmet.next = bow;
        bow.next = arrow;
        arrow.next = sword;
        sword.next = null;

        searchMerchants();

        String answer  = scanner.nextLine();

        while(answer.equals("n")){
            write("What about now?",colors.GREEN_BOLD_BRIGHT);
            answer = scanner.nextLine();
        }

        write("Nice. Well then, I would like to introduce you to the first merchant.",colors.GREEN_BOLD_BRIGHT);

        Merchant.ListNode pointer = merchants.head;
        int tracker = 0;
        Draw picutres = new Draw();
        while(answer.equals("y") && pointer.next!=null){

            write("\nHello , " +phrases[rand.nextInt(0,phrases.length)]+".",colors.GREEN_BOLD_BRIGHT);
            write("Would you like to buy a " + pointer.purchase.itemName + " ? y/n: ",colors.GREEN_BOLD_BRIGHT );
            System.out.println(colors.WHITE_BOLD_BRIGHT + picutres.itemDrawings[tracker]);

            choice = scanner.nextLine();
            if(choice.equals("y")){
                write("Great here you go. That will be " + (int)pointer.purchase.itemCost + " gold coins", colors.GREEN_BOLD_BRIGHT);
                inventory.add(pointer.purchase.itemName);
                pocketMoney -= pointer.purchase.itemCost;
                coinFall.loop(1);
                purchase.loop(1);


            }else{
                write("Okay thats fine. Would like to keep shopping or are you done?: y/n:",colors.GREEN_BOLD_BRIGHT);
                choice = scanner.nextLine();
                if(choice.equals("n")){
                   write("Alright, here you go. I'll bring you to the next merchant",colors.GREEN_BOLD_BRIGHT);
                } else {
                    break;
                }
            }
            write("You have "+pocketMoney+ " gold coins left coins", colors.GREEN_BOLD_BRIGHT);
            pointer = pointer.next;
            tracker = tracker + 1;
        }
        write("Well, thanks for shopping today's",colors.GREEN_BOLD_BRIGHT);
        write("Today, it seems that you bought ",colors.GREEN_BOLD_BRIGHT);
        for(String word : inventory){
            write(" a "+word+", ",colors.GREEN_BOLD_BRIGHT);
        }
        write(" Have a good day",colors.GREEN_BOLD_BRIGHT);
        shop.stop();
    }
    //TODO: Divine
    public static void HashMapDivine() throws LineUnavailableException, IOException {
        String[] magicWords = {"5'10", "Lebron James", "Decade"};
        String[] outputs = {"\nYou must Go to the Dark Wallow Caves, and when you are there say the next magic word... Be Safe Adventurer. \n \nYou have Arrived at the Wallow Caves after fending off beasts on your journey there.\n", "Descend into the caves for 10000 steps and turn to the left... \n \n You have arrived at to what seems to be an altar where a precious treasure would be held, but you see a large snake guarding it! \n You swiftly attack and defeat the snake but do not see the stone... \n it seems you must summon the crystal unto the altar...\n", "The Crystal Appears on the Altar and it is luminescent with a mythical Blue glow.\n"};
        int currentIndex = 0;
        System.out.print("You are tasked to find a Crystal to aid the village, but you are to use magic words to tell the location of said Crystal... \nThe Fortune Teller at the village has given you hints as to what the magic words are. The first hint is 'Jordan's Real Height' \n The Second is who is the best basketball player ever... And the third is the word you call ten years \n Good Luck Adventurer...\n");

        while (true) {
            if (currentIndex == magicWords.length) {
                write("Congratulations!\nYou have successfully summoned the magic crystal, Now take it back to the village.",colors.GREEN_BOLD_BRIGHT);
                break;
            }
            System.out.print("Enter the magic phrase: ");
            String inputString = scanner.nextLine();
            if (inputString.equals(magicWords[currentIndex])) {
                write("\nAmazing Job Adventurer! " + outputs[currentIndex],colors.GREEN_BOLD_BRIGHT);
                write("Please enter the next magic phrase.",colors.GREEN_BOLD_BRIGHT);
                currentIndex++;
            } else {
                write("No Adventurer! You are sadly wrong, now you will be teleported to where you said your first magic phrase as a side effect :( .",colors.GREEN_BOLD_BRIGHT);
                currentIndex = 0;
            }
        }


    }
    // passwords for recursion story
    //TODO: Jenny's
    private static final String[] ENTRANCE_PASSWORDS = {
            "j2o4df",
            "4df896",
            "dj0386",
            "k38fw0",
            "jordan53"
    };

    private static final String[] EXIT_PASSWORDS = {
            "vfndjk",
            "jo8afi",
            "fd9lkd",
            "0df2df"
    };

    // The method that is going to be called in the main function.
    // This contains the main story line for recursion.
    private static void recursion(Scanner scan) throws LineUnavailableException, IOException {

        // start - telling story
        write("Your goal is to rescue your best friend, who is held captive in a cabin in the mountains.\n" +
                "However, after a long way to the top of the mountain where the cabin is located, you face\n" +
                "the most difficult part of this journey: entering the cabin. Each time you enter the cabin, you\n" +
                "will see two locked doors, one is the entrance to another cabin, where your destination cabin is located in,\n" +
                "and another one is the exit that you will use when returning from the destination cabin.\n" +
                "Your destination cabin, that is, the cabin in which your best friend is, is the most inner cabin. Now\n" +
                "you have the passwords for the entrance doors, but the passwords for the exits are unknown. You\n" +
                "have to continue using the passwords you have to enter the cabin using the entrance door until\n" +
                "you reach the most inner cabin. And once you get there, you can save your friend and also get the\n" +
                "password set for the exits. Good luck!\n",colors.GREEN_BOLD_BRIGHT);

        Draw picutres = new Draw();

        System.out.println(colors.WHITE_BOLD_BRIGHT + picutres.itemDrawings[8]);

        // password set
        write("**********************************************************************\n",colors.GREEN_BOLD_BRIGHT);
        write("[Password Set for Entrances]\n" +
                "1st Cabin: j2o4df\n" +
                "2nd Cabin: (1st Cabin’s Password).subString(3) + “896”\n" +
                "3rd Cabin: (2st Cabin’s Password)[1] + (1st Cabin’s Password)[0] + “038” + (2st Cabin’s Password)[(2st Cabin’s Password).length - 1]\n" +
                "4th Cabin: “k38fw” + ((int) 5 / 6)\n" +
                "5th Cabin: (3rd Cabin’s Password)[1] + (1st Cabin’s Password)[2] + “r” + (2nd Cabin’s Password)[1] + “an” + 53\n",colors.GREEN_BOLD_BRIGHT);
        write("**********************************************************************\n",colors.GREEN_BOLD_BRIGHT);
        recursiveMethod(scan, 1);
    }
    public static void stackRomir() throws LineUnavailableException, IOException {
        Stack<String> locationStack = new Stack<String>();
        locationStack.push("castle");

        Scanner input = new Scanner(System.in);

        while (true) {
            String currentLocation = locationStack.peek();
            write("You are currently in a " + currentLocation,colors.GREEN_BOLD_BRIGHT);
            write("What would you like to do?",colors.GREEN_BOLD_BRIGHT);
            write("1. Explore the castle",colors.GREEN_BOLD_BRIGHT);
            write("2. Leave the castle",colors.GREEN_BOLD_BRIGHT);

            int choice = input.nextInt();
            if (choice == 1) {
                locationStack.push("tower");
                write("You explore the castle and find a tower. You climb to the top and have a great view of the surrounding area.",colors.GREEN_BOLD_BRIGHT);
            } else if (choice == 2) {
                locationStack.pop();
                write("You leave the castle and find yourself outside.",colors.GREEN_BOLD_BRIGHT);
                if (locationStack.empty()) {
                    break;
                }
            }
        }
        write("Thanks for playing!",colors.GREEN_BOLD_BRIGHT);
    }

    // This is the actual recursive method - it calls itself
    // This method will be called in the recursion() method.
    private static void recursiveMethod(Scanner scan, int doorNumber) throws LineUnavailableException, IOException {
        if (doorNumber <= 5) {
            String password = "";
            write("You're standing in front of Cabin " + doorNumber + ".\n",colors.GREEN_BOLD_BRIGHT);
            write("Enter the password for the entrance:\n", colors.GREEN_BOLD_BRIGHT);
            password = scan.nextLine();
            while (true) {
                if (password.equals(ENTRANCE_PASSWORDS[doorNumber - 1])) {
                    write("Door opens successfully!\n",colors.GREEN_BOLD_BRIGHT);
                    break;
                } else {
                    write("Wrong password! Please Try again!\n",colors.GREEN_BOLD_BRIGHT);
                    write("Enter the password:\n", colors.GREEN_BOLD_BRIGHT);
                    password = scan.nextLine();
                }
            }
            write("",colors.GREEN_BOLD_BRIGHT);
            recursiveMethod(scan, doorNumber + 1);
        } else {
            write("You've successfully entered the destination cabin!\n",colors.GREEN_BOLD_BRIGHT);
            write("You see your best friend there and immediately go and untie the ropes on his/her hands and feet.\n",colors.GREEN_BOLD_BRIGHT);
            write("Nice job!\n",colors.GREEN_BOLD_BRIGHT);
            write("On the table next to where your friend was laying at, you find the passwords for the exits:\n",colors.GREEN_BOLD_BRIGHT);
            write("**********************************************************************\n",colors.GREEN_BOLD_BRIGHT);
            write("[Password Set for Exits]\n" +
                    "1st Cabin: " +EXIT_PASSWORDS[0] + "\n" +
                    "2nd Cabin: " +EXIT_PASSWORDS[1] + "\n" +
                    "3rd Cabin: " +EXIT_PASSWORDS[2] + "\n" +
                    "4th Cabin: " +EXIT_PASSWORDS[3] + "\n",colors.GREEN_BOLD_BRIGHT);
            write("**********************************************************************\n",colors.GREEN_BOLD_BRIGHT);
            write("Pay attention to the order of the cabins!\n" +
                    "You are now in the 5th cabin and is trying to exit through the 1st cabin!\n",colors.GREEN_BOLD_BRIGHT);
            write("",colors.GREEN_BOLD_BRIGHT);
            write("",colors.GREEN_BOLD_BRIGHT);
        }

        if (doorNumber - 2 >= 1)  {
            String password = "";
            write("You're standing in front the exit that leads to Cabin " + (doorNumber - 2) + "." + "\n",colors.GREEN_BOLD_BRIGHT);
            write("Enter the password for the exit:\n", colors.GREEN_BOLD_BRIGHT);
            password = scan.nextLine();
            while (true) {
                if (password.equals(EXIT_PASSWORDS[doorNumber - 3])) {
                    write("Door opens successfully!\n",colors.GREEN_BOLD_BRIGHT);
                    break;
                } else {
                    write("Wrong password! Please Try again!\n",colors.GREEN_BOLD_BRIGHT);
                    write("Enter the password: \n", colors.GREEN_BOLD_BRIGHT);
                    password = scan.nextLine();
                }
            }
            write("",colors.GREEN_BOLD_BRIGHT);
        } else {
            write("Congrats! You have just escaped from the cabin series!!!!!!!\n",colors.GREEN_BOLD_BRIGHT);
            write("Now you and your best can go back home together!\n",colors.GREEN_BOLD_BRIGHT);
            write("NICE JOB!!\n",colors.GREEN_BOLD_BRIGHT);
        }
    }

    //TODO: Call Alexis
    public static void arrayMiniGame(Scanner scan) throws LineUnavailableException, IOException {
        int input;
        String[] inventory = new String[5];
        write("Hello there! Are you here to prepare for your quest to hunt the ogre who has been terrorizing our village?",colors.GREEN_BOLD_BRIGHT);
        write("1. Yes\n2. No",colors.GREEN_BOLD_BRIGHT);
        input = scan.nextInt();
        if(input == 1){
            write("Well welcome to my quest store which has all that is needed for your quest\n" +
                    "But be aware, you can only carry around 5 items throughout your quest, so choose wisely",colors.GREEN_BOLD_BRIGHT);
            int i = 0;
            while(Objects.isNull(inventory[3])){
                write("1. Helmet\n2. Chest-plate\n3. Sword\n4. Axe\n5. Coins\n6. Food\n7. Rope\n8. Torch",colors.GREEN_BOLD_BRIGHT);
                input = scan.nextInt();
                if(input == 0)
                    break;
                switch(input){
                    case 1 : inventory[i] = "Helmet";
                        break;
                    case 2 : inventory[i] = "Chest-plate";
                        break;
                    case 3 : inventory[i] = "Sword";
                        break;
                    case 4 : inventory[i] = "Axe";
                        break;
                    case 5 : inventory[i] = "Coins";
                        break;
                    case 6 : inventory[i] = "Food";
                        break;
                    case 7 : inventory[i] = "Rope";
                        break;
                    case 8 : inventory[i] = "Torch" ;
                    default:
                        write("Please enter a number 1-8",colors.GREEN_BOLD_BRIGHT);
                }
                i++;
            }
            write("Your inventory:",colors.GREEN_BOLD_BRIGHT);
            for(String items : inventory){
                write(items,colors.GREEN_BOLD_BRIGHT);
            }
            write("Excellent choices! You are now ready to head into the forest to start your hunt. Good Luck!",colors.GREEN_BOLD_BRIGHT);
            write("""
                 As you enter the forest you come across two paths:
                 to the left is an obstructed path that should be safe from any enemies.
                 To the right is a dark path that will take you straight to
                 the monster you seek, but enemies may attack you if there is no light.
                 You should probably only go down the left path if you have a rope
                 to help navigate the path, and only go down the right if you have a torch so
                 you can see in the dark.
                 Which do you choose?\s""",colors.GREEN_BOLD_BRIGHT);
            write("1. Left\n2. Right",colors.GREEN_BOLD_BRIGHT);
            input = scan.nextInt();
            if(input == 2 && linearSearch(inventory,inventory.length,"Torch") != -1){
                write("With your torch lighting up the path, you make your way to the Ogre's lair with no problem",colors.GREEN_BOLD_BRIGHT);
            }
            else if(input == 2){
                write("Without a torch to light up the path, you are ambushed by goblins and killed :(",colors.GREEN_BOLD_BRIGHT);
                return;
            }
            else if(input == 1 && linearSearch(inventory,inventory.length,"Rope") != -1){
                write("With your rope you are able to navigate through the obstructed path\n" +
                        "with no problem and find the ogre's lair",colors.GREEN_BOLD_BRIGHT);
            }
            else if(input == 1){
                write("When trying to navigate through the obstructed path with no rope " +
                        "you get stuck and can't complete your quest :(",colors.GREEN_BOLD_BRIGHT);
                return;
            }
            write("Once at the ogres lair, you confront it",colors.GREEN_BOLD_BRIGHT);
            if(linearSearch(inventory,inventory.length,"Sword") != -1 || linearSearch(inventory,inventory.length,"Axe") != -1){

                if(linearSearch(inventory,inventory.length,"Helmet") != -1 && linearSearch(inventory,inventory.length,"Chest-plate") != -1){
                    write("With protection from both your helmet and chest-plate, and your weapon, you were able to kill the ogre easily :D",colors.GREEN_BOLD_BRIGHT);
                }
                else if(linearSearch(inventory,inventory.length,"Helmet") != -1){
                    input = rand.nextInt(3) + 1;
                    if(input > 1){
                        write("Using your weapon and protection of your helmet, you are able to kill the ogre :)",colors.GREEN_BOLD_BRIGHT);
                    }
                    else{
                        write("While fighting the ogre you are caught off guard and are killed :(",colors.GREEN_BOLD_BRIGHT);
                    }
                }
                else if(linearSearch(inventory,inventory.length,"Chest-plate") != -1){
                    input = rand.nextInt(5) + 1;
                    if(input > 1){
                        write("Using your weapon and protection of your chest-plate, you are able to kill the ogre :)",colors.GREEN_BOLD_BRIGHT);
                    }
                    else{
                        write("While fighting the ogre you are caught off guard and are killed :(",colors.GREEN_BOLD_BRIGHT);
                    }
                }
                else{
                    write("With no armor, the ogre is easily able to stop you and you are killed :(",colors.GREEN_BOLD_BRIGHT);
                }
            }
            else{
                write("With no weapon to fight with, you only last five seconds before you are killed :(",colors.GREEN_BOLD_BRIGHT);
            }
        }
    }
    public static int linearSearch(String[] list, int size, String key){
        int i;
        for(i=0;i<size;i++)
        {
            if(list[i].equals(key))
                return i;
        }
        return -1;
    }

}
