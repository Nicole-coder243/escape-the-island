/*Author: Makayla Sanders
 * Start Date: sept, 11,2024
 * Last Updated: 4/21/2025
 * Description: A text adventure game where the player is a bookstore employee who gets transported to a mysterious island after opening a strange book. 
 * The player must navigate through various challenges to escape the island. 
 * The game features multiple endings based on the player's choices.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean hasOpenedBook = true;
        boolean gameRunning = true;
        int hp = 100; // Initial player's health
        int damage = hp - 15; // Damage
        int thinkingSkills = 10;
        int bravery = 10;
        int confidence = 10;
        int cleverness = 10;
        int playerHP = 100;
        int snakeHP = 150;

        while (gameRunning) {
            // Game begins!
            System.out.println("Welcome to Escape the Island! There are multiple endings so this should be fun!");
            System.out.println("Before we begin, Enter your name: ");
            String playerName = input.nextLine(); // Reads playerName when you type it and press enter
            System.out.println("Hello, " + playerName + "! Before we begin, here is the backstory... enjoy!");

            ArrayList<String> adventureScenes = new ArrayList<>();
            adventureScenes.add("You work at a bookstore on the night shift where it's empty and quiet during the night.");
            adventureScenes.add("One night before the owner leaves, you are tasked with putting away old antique books for the new 'Island Mystery' section of the store.");
            adventureScenes.add("Curiosity piqued your interest on an unusual book from the pile called 'Island Game'. Unlike the others, it doesn't quite match the display theme of misty fog and hint of distant mountains.");

            for (String beginningscene : adventureScenes) {
                System.out.println(beginningscene);
            }

            System.out.println("As you open the book, the pages begin to glow faintly, drawing you deeper into each word until...");
            // First game option
            System.out.println("Wait... Do you want to continue reading through the book? (yes or no)");
            String choice = input.nextLine();  // Read player's choice

            if (choice.equalsIgnoreCase("yes") && hasOpenedBook) {
                thinkingSkills += 5;
                bravery += 5;
                System.out.println("Your thinking skills have increased: " + thinkingSkills + "!");
                System.out.println("Your bravery has increased: " + bravery + "!");
                System.out.println("One page inscribed said 'you are chosen' and suddenly bright light has blinded you."); // If yes, the player continues through the game

                // New story part: waking up on the island
                System.out.println("As the light slowly fades, you regain consciousness, opening your eyes.");
                System.out.println("Dazed and confused, you find yourself surrounded by heavy misty fog and the smell of salty air.");
                System.out.println("You hear roaring crashes of... waves!");
                System.out.println("You feel sand beneath your hand on the surface... sand!");
                System.out.println("Thoughts hit " + playerName + ": Am I on an island?!");

                adventureScenes.add("Waking up on Mysterious Island: heavy misty fog, sounds of roaring waves, feeling of sand beneath");

            } else {
                confidence -= 10;
                System.out.println("Your confidence slightly went down: " + confidence + "!");
                String firstEnding = "Since you decided not to read or continue reading, you closed up the shop and went home for the rest of the night.";
                String firstEndingMessage = "Escape the Island Game has ended early."; // First ending to Escape the Island game
                gameRunning = false; // Game ends, loop stops when false
                adventureScenes.add(firstEnding);
                System.out.println(firstEnding);
                System.out.println(firstEndingMessage);
                break; // Ensure the game loop exits completely
            }

            // Part 2: Replay the backstory
            System.out.println("Would you like to replay the backstory? (yes or no): ");
            String replayChoice = input.nextLine();
            if (replayChoice.equalsIgnoreCase("yes")) { // Replay the backstory if chosen
                System.out.println("Replaying...");

                for (String scene : adventureScenes.subList(0, 3)) {
                    System.out.println(scene);
                }
            } else if (replayChoice.equalsIgnoreCase("no")) { // Continue without replaying
                System.out.println("Great, let's continue the Escape the Island adventure!");
            }

            ArrayList<String> walking = new ArrayList<>();
            walking.add("You start walking in the midst of the fog, confused but on guard.");
            walking.add("Two items you see on the ground as the fog clears when the items appear.");
            walking.add("The first item is a Sword, and the other item is a bow and arrows.");
            walking.add("You tend to think as the fog dissipates while you decide to pick up one of the items.");
            for (String walkingScene : walking) {
                System.out.println(walkingScene);
            }

            System.out.println("Choose your weapon for now: Bow and Arrows or Sword: ");
            String weapon = input.nextLine();
            if (weapon.equals("bow and arrows")) {
                System.out.println("A classic brave choice, good for distance and strategy thinking. Upgrade for Bow and Arrows will unlock later...");
            } else {
                System.out.println("An Excalibur choice, good for close combat with the sharpness of security. Upgrade for Sword will unlock later...");
            }

            // Story: Cave Discovery
            System.out.println("You continue walking and you see a cave in the distance.");
            System.out.println("You start walking towards the cave and the eerie sound grows louder.");
            System.out.println("You continue walking into the cave and see a backpack with the following materials on the ground: map, rope, and a flashlight.");
            ArrayList<String> backPack = new ArrayList<>();
            backPack.add("map");
            backPack.add("rope");
            backPack.add("flashlight");
            System.out.println("The item(s) currently in the backpack are: " + backPack);
            System.out.println(playerName + "! As soon as you enter further into the cave you see a giant three-headed bear monster.");
            System.out.println(playerName + ", make a choice: (run or fight)"); // choice 2 goes into encounter with the bear monster

            String choice2 = input.nextLine(); // prompts player to make a choice2

            if (choice2.equals("run")) { // choice of run action reduces bravery and confidence
                thinkingSkills -= 20;
                bravery -= 5;
                System.out.println("Your thinking skills have decreased from this: " + thinkingSkills + "!");
                System.out.println("Your bravery skills have decreased from this: " + bravery + "!");
                System.out.println("Panicked, you turn and start running quickly within the cave's dense fog.");
                System.out.println("Your heart pounds as the sounds of the three-headed bear grow closer behind you.");
                System.out.println("Blinded by fear and the thick fog, you trip over a root and tumble down to the ground.");
                System.out.println("You try to scramble to your feet to continue, but pain strikes up your ankle, and the pain is sharp.");
                System.out.println("Shadows in the fog. The three-headed bear monster closes in and pounces on you before you can escape.");
                System.out.println("You have died. The game has ended but the run choice was an ideal choice. Escape The Island has multiple endings; some choices and endings are not as ideal.");
                gameRunning = false;
                break; // Ensure the game loop exits completely
            } else if (choice2.equals("fight")) {
                bravery += 10;
                System.out.println("Your bravery has increased from this: " + bravery + "!");
                System.out.println("With your choice of: " + weapon + ", you make the head start to fight the bear monster");

                if (weapon.equals("sword")) {
                    System.out.println("In your mind, just like a video game, you think of the best way to fight the bear monster.");
                    thinkingSkills += 10;
                    System.out.println("Your thinking skills have just increased: " + thinkingSkills + "!");
                    System.out.println("However, a little hesitant, the three-headed bear monster made a surprise launch at you, " + playerName + "!");
                    System.out.println("Luckily, within a millisecond from the attack, you manage to roll away to get yourself some time but scrape your knee.");
                    System.out.println(playerName + ", you have gotten your cut from rolling, your HP is now: " + (hp - 15) + "!");
                    System.out.println("The three-headed bear monster grunts angrily and heads toward you, bearing teeth, ready to leap toward you again. With your " + weapon + " you try to swing it frantically, but the bear smacks it out of your hand.");

                    dialoguePhase(input, "The monster roars and seems ready to strike again. What will you do?", thinkingSkills);
                } else if (weapon.equals("bow and arrows")) {
                    System.out.println("In your mind, just like a video game, you think of the best way to fight the bear monster.");
                    thinkingSkills += 10;
                    System.out.println("Your thinking skills have just increased: " + thinkingSkills + "!");
                    System.out.println("However, a little hesitant, the three bear-headed monster made a surprise launch at you, " + playerName + "!");
                    System.out.println("Luckily, within a millisecond from the attack, you manage to roll away to buy yourself some time but manage to scrape your knee.");
                    System.out.println(playerName + ", you have gotten your cut from rolling, your HP is now: " + (hp - 15) + "!");
                    System.out.println("The three bear-headed monster grunts angrily and decides to head toward you and this time bearing teeth ready to leap toward you again. With your " + weapon + " you try to aim it frantically, but the bear smacks it out of your hand.");

                    dialoguePhase(input, "The monster growls fiercely. What will you do?", thinkingSkills);
                }

                // Next part of dialogue where the player decides how to handle the monster
                System.out.println("Quickly thinking, you come up with two options to get your " + weapon + " from where it landed behind the monster. Options are: run under the monster's legs or throw cave dust into the monster's eyes: ");
                String choice3 = input.nextLine();

                if (choice3.equals("run under monster legs")) {
                    System.out.println("Seeing a quick opening to get your " + weapon + ", you thought to scramble to get it through the monster's legs?!");
                    damage -= 60;
                    System.out.println("The word 'No Escape' echoes from the cave. The monster slays you with a harsh scratch, clawing you before you made it to your weapon. Your HP is now: " + damage + "!");
                    System.out.println("Your HP is critically low. Escape the Island game ended.");
                    gameRunning = false;
                    break; // Ensure the game loop exits completely
                } else if (choice3.equals("throw cave dust into monster eyes")) {
                    System.out.println("Temporarily, you have blinded the monster by grabbing a handful of cave dust and hurling it into the monster's eyes!");
                    cleverness += 5;
                    System.out.println("Your cleverness has increased: " + cleverness);
                    System.out.println("You feel a surge of confidence as you prepare for the next move.");
                    System.out.println("Quick thinking! The monster stumbles back, roaring in frustration, giving you just enough time to grab your " + weapon + "!");

                    if (weapon.equals("sword")) {
                        System.out.println("You see a large rock nearby. Accelerating towards it with your " + weapon + ", you leap from the rock!");
                        System.out.println("The three-headed bear monster sees you midair and attempts to swat you down.");
                        System.out.println("In that moment, sunlight streams into the cave, reflecting off your sword and creating a dazzling light beam.");
                        System.out.println(playerName + ", you shout a loud battle cry as you drive your " + weapon + " forward with all your strength.");
                        System.out.println("With a mighty strike, you pierce through the monster's heads, slaying it instantly!");
                    } else if (weapon.equals("bow and arrows")) {
                        System.out.println("You quickly set the arrow on fire using sparks from nearby rocks, creating a flaming arrow.");
                        System.out.println("Your thinking skill has increased from making a fire arrow: " + thinkingSkills + "!");
                        System.out.println("You shout a loud battle cry and release the blazing arrow, piercing the monster's heads and slaying it instantly!");
                    }

                    System.out.println("The three-headed bear monster has collapsed to the ground.");
                    System.out.println("==================================================");
                    System.out.println("CONGRATULATIONS! You have slain the three-headed bear monster!");
                    System.out.println("==================================================");
                }

                System.out.println("Are you ready for the next challenge? yes or no");
                String nextChallenge = input.nextLine();
                if (nextChallenge.equals("yes")) {
                    System.out.println("You gather your strength and start walking out of the cave, prepared for the next.");
                } else if (nextChallenge.equals("no")) {
                    System.out.println("As you step away from the adventure, a strange feeling washes over you.");
                    System.out.println("The cave around you begins to blur, colors swirling together as if being erased.");
                    System.out.println("You suddenly find yourself sitting in the bookstore, the book you were reading still open in your lap but blank pages.");
                    System.out.println("Confused, you glance around, realizing you're back at the new 'Island Mystery' section of the store, as if nothing had happened.");
                    System.out.println(playerName + " Was it all just a dream?");
                    System.out.println("Escape the Island game ended. Thank you for playing!");
                    gameRunning = false;
                    break; // Ensure the game loop exits completely
                }
            }

            // Third Final Stage: Tower of Challenges, Mystery of the Island, Ending, Choice, Storyline that ties it all together - Discovering the Tower

            System.out.println("After what feels like endless walking with no sign of change, doubt begins to settle in. You wonder if you’ll ever escape this island or how you even ended up here. But then, in the distance, a flicker of light catches your eye.");

            System.out.println("As you draw closer, the flickering light seems to grow stronger, drawing you in, guiding you forward. Your legs ache from the journey, but something about this light gives you renewed purpose. Your steps quicken, and the chill in the air only fuels your curiosity.");

            System.out.println("As you approach, you see a chest sitting atop a solitary platform, nestled within a clearing. A strange pull seems to emanate from the chest, beckoning you closer, urging you to take a closer look.");

            System.out.println("But just as you are about to step forward, the ground beneath you trembles. The platform lurches violently as if it has a life of its own. You instinctively leap back, heart pounding in your chest.");

            System.out.println("Before your eyes, the platform begins to rise, slowly at first, and then with great speed. The chest disappears, and what was once an innocent-looking structure transforms into a towering monolith, a dark silhouette against the cloudy sky.");

            System.out.println("The tower looms over you, its jagged spires reaching high into the mist, its many openings like gaping mouths, echoing with unsettling roars and whispers too faint to make sense of. The air feels heavy with tension, as though this place has been waiting for you, for this very moment.");

            System.out.println("Can this be the end, " + playerName + "? Or is it merely the beginning of a deeper, darker mystery?");

            System.out.println("You take a tentative step forward. The ground beneath your feet seems to hum with energy, the air thickening and growing colder with each passing second. Symbols, ancient and unfamiliar, begin to glow along the tower's surface. They pulse faintly as if alive, whispering meanings you cannot yet grasp.");

            System.out.println("A distant whisper floats through the air, unintelligible but laden with urgency. It seems to come from every direction at once, carried on the cold wind. Shadows flicker in the tower’s many openings above, shifting unnaturally—as if something, or someone, is watching you from within.");

            System.out.println("The weight of the island’s mystery presses down on you, filling you with both dread and determination. You cannot turn back now. This is the moment you’ve been preparing for, whether you’re ready or not.");

            System.out.println("With a deep breath, you step closer to the tower's entrance. The shadows seem to part in response to your movement, only to return to their former positions, waiting for you to come closer. The doorway looms in front of you, a gaping void that seems to swallow all light, save for the faint flicker of torches along the walls.");

            System.out.println("As you enter, the temperature drops further, and the walls pulse with the same glowing symbols. The whispers grow louder, forming distorted, echoing sounds that send shivers down your spine. Then, suddenly—a growl.");

            System.out.println("A low, menacing growl rumbles from the pitch-black darkness ahead. Eyes—glowing, unblinking—peer out from the shadows, watching your every move. Something is there, waiting.");

            System.out.println("Your heart pounds in your chest. You grip your " + weapon + " tightly, preparing for whatever lies ahead. Your body tenses, ready for the unknown creature that might appear.");

            System.out.println("Before you can react, the door behind you slams shut with a deafening thud, the sound echoing off the stone walls. The chamber is sealed. You are trapped inside, and there is no turning back now. The challenge of the tower has begun.");

            System.out.println("You ascend the staircase and reach a massive door to the next level of the tower.");
            System.out.println("As you push it open, you step into a dimly lit room filled with stone statues.");
            System.out.println("The room is dusty, like a scene from an old-time movie, with white drapes covering various items scattered throughout.");
            System.out.println("The statues appear eerily lifelike, frozen in expressions of fear and shock.");
            System.out.println("Suddenly, you hear a hissing sound, and from the shadows emerges a serpent-like creature with shimmering scales and hypnotic eyes—a mischievous Snake with features reminiscent of Medusa.");
            System.out.println("The snake’s movements resemble a slow, deliberate waltz, its scales whispering against the dusty floor.");
            System.out.println("Its gaze locks onto you, and you feel an unsettling chill. Its gaze seems to pierce through the draped covers, making you shiver as if its eyes are everywhere. Prepare yourself!");
            System.out.println("Just like Medusa, " + playerName + ", be careful of the eyes so you won't turn into stone.");
            // New choices for the room of statues
            System.out.println("What will you do?");
            System.out.println("1. Concentrate by closing your eyes to move around the room.");
            System.out.println("2. Freeze in fear, risking a glance at the eyes.");
            System.out.println("3. Back out, unsure whether to retreat or regroup.");
            int nextLvlChoice = input.nextInt();
            input.nextLine(); // Consume newline
            if (nextLvlChoice == 1) {
                System.out.println("You shut your eyes tightly, focusing only on the sounds and vibrations around you.");
                System.out.println("Slowly, you begin to move, carefully navigating the room by listening to the subtle echoes in the space.");
                System.out.println("Staying silent and focused, you manage to avoid the creature’s gaze as it slithers closer.");
                System.out.println("You steady your breathing and prepare your next move.");
                System.out.println("Waiting for something to happen which nothing occurred, the snake slithers by you with care for you for now.");
                System.out.println("Taking this as a sign to make a move just like before the room symbols call to you this time different: fire symbols, ice symbols, reflective symbols.");
                System.out.println("Do you take one of the symbols? (yes/no)");
                String symbolChoice = input.nextLine();

                if (symbolChoice.equalsIgnoreCase("yes")) {
                    System.out.println("You approach the symbols and select one, feeling its power resonate through your weapon.");
                    System.out.println("Which symbol do you choose? Fire, Ice, or Reflective?");
                    String chosenSymbol = input.nextLine();
                    if (chosenSymbol.equalsIgnoreCase("fire")) {
                        System.out.println("Your weapon absorbs the power of fire. If weapon is sword, it is now a Flaming Sword with enhanced damage x2.");
                        if (weapon.equalsIgnoreCase("sword")) {
                            System.out.println("The Flaming Sword heats up, radiating intense heat. The snake recoils, clearly uncomfortable with the rising temperature.");
                            System.out.println("You swing your sword blindly, relying on sound and heat to guide you.");
                            System.out.println("Flames erupt from the sword, creating bursts of heat and small explosions in the room.");
                            // Damage calculation

                            snakeHP -= 45;
                            playerHP -= 15;
                            System.out.println("The explosions damage the snake and force it back, leaving it hissing in pain. Snake HP: " + snakeHP);
                            System.out.println("The heat slightly burns you as well. Player HP: " + playerHP);
                            System.out.println("The snake quickly slithers to the side and lashes its tail, catching you off guard!");
                            playerHP -= 10;
                            System.out.println("You stumble back, feeling the impact. Player HP: " + playerHP);

                            // Snake's relentless movements
                            System.out.println("The snake circles around you mercilessly, its movements swift and unpredictable.");
                            System.out.println("You must stay sharp and avoid being cornered!");

                            System.out.println("With the Flaming Sword, " + playerName + ", you now have the upper hand. Do you:");
                            System.out.println("1. Press your upper hand and attack?");
                            System.out.println("2. Keep moving cautiously, look for another opening?");
                            int fireDecision = input.nextInt();
                            input.nextLine(); // Consume newline
                            if (fireDecision == 1) {
                                System.out.println("You charge forward, swinging your Flaming Sword. The snake reappears, striking swiftly.");
                                System.out.println("The flames keep it at bay, but it’s faster than you expected. You need to time your attacks carefully.");
                                System.out.println("However, the heat forces the snake into retreat, and a path opens up leading deeper into the room.");
                                System.out.println("Taking this chance, you circle around, creating flames that trap the snake, forcing it to halt.");
                                snakeHP -= 75;
                                System.out.println("The snake is now at: " + snakeHP);
                                System.out.println("The mischievous snake started to heat up over time, causing the dust in the room to overwhelm it.");
                                System.out.println("The room is now covered in dust, extinguishing the flames and returning the cold.");
                                System.out.println("You see a key revealed in the pile of dust, the key to the door.");
                            }
                        } else if (chosenSymbol.equalsIgnoreCase("ice")) {
                            System.out.println("Your weapon absorbs the power of ice, glowing with sharp frost.");
                            System.out.println("The Ice Sword allows you, " + playerName + ", to freeze your opponent temporarily. Use this wisely!");
                            System.out.println("Warning: If not used carefully, the sword's frost may backfire, leaving you frostbitten!");
                            // Step 1: Ice Slash Echo - Listen and Strike
                            System.out.println("You listen carefully, waiting for the snake’s movements.");
                            System.out.println("You swing your Ice Sword, releasing a chilling echo that bounces around the room.");
                            System.out.println("The icy slash reverberates, creating sharp vibrations that briefly reveal the snake’s location. Wise choice");
                            snakeHP -= 30; // Initial ice damage
                            System.out.println("The freezing wind slows the snake, causing it to hiss angrily. Snake HP: " + snakeHP);
                            // Step 2: Freeze Weak Points
                            System.out.println("Do you: ");
                            System.out.println("1. Focus and deliver a precise strike at the snake’s tail?");
                            System.out.println("2. Use the ice sword’s freezing ability to create a defensive wall of frost?");
                            int iceDecision = input.nextInt();
                            input.nextLine(); // Consume newline
                            if (iceDecision == 1) {
                                // Offensive Strategy
                                System.out.println("You target the snake’s tail, aiming for a weak point.");
                                System.out.println("The blade releases another icy slash, freezing the tail in place.");
                                snakeHP -= 40; // Heavy damage
                                System.out.println("The snake struggles to move, its tail frozen solid. Snake HP: " + snakeHP);

                                // Counterattack risk
                                System.out.println("The snake, in desperation, strikes wildly with its head!");
                                playerHP -= 20; // Damage to player
                                System.out.println("You’re hit by its sudden attack! Player HP: " + playerHP);

                                // Final Chance to Strike
                                System.out.println("The frozen tail weakens the snake further. Do you:");
                                System.out.println("1. Shatter the ice, damaging the snake further?");
                                System.out.println("2. Retreat carefully and prepare for another move?");
                                int finalIceStrike = input.nextInt();
                                input.nextLine(); // Consume newline

                                if (finalIceStrike == 1) {
                                    System.out.println("You swing down hard, shattering the frozen tail of this mischievous snake and dealing massive damage.");
                                    snakeHP -= 50; // Final damage
                                    System.out.println("The snake collapses in a frozen heap. Snake HP: " + snakeHP);
                                    System.out.println("The frost slowly fades, leaving the room cold but calm. A door appears with a keyhole.");
                                    System.out.println("You spot the key in the frost-covered floor and prepare to move forward.");
                                } else if (finalIceStrike == 2) {
                                    System.out.println("You step back, keeping your distance. The snake thrashes but eventually collapses from the cold.");
                                    snakeHP -= 30; // Gradual damage
                                    System.out.println("The room calms as the frost fades. A door appears with a keyhole.");
                                    System.out.println("You pick up the key, ready to continue.");
                                }

                            } else if (iceDecision == 2) {
                                // Defensive Strategy - Frost Wall
                                System.out.println("You stab the ground, releasing a burst of icy energy.");
                                System.out.println("A wall of frost rises, blocking the snake’s path and forcing it back.");
                                snakeHP -= 20; // Reduced damage
                                System.out.println("The snake hisses, slowed but still circling you. Snake HP: " + snakeHP);

                                // Frostbite Risk
                                System.out.println("The cold intensifies, and you feel the chill creeping into your hands.");
                                playerHP -= 10; // Player takes frostbite damage
                                System.out.println("You suffer mild frostbite but remain focused and steady. Player HP: " + playerHP);

                                // Opening and Escape
                                System.out.println("The ice wall weakens the snake, forcing it to retreat. A door appears with a keyhole.");
                                System.out.println("You find the key frozen into the ice and carefully retrieve it before moving forward.Let move on!");
                            }
                        } else if (weapon.equals("bow and arrows")) {
                            System.out.println("Your bow has now  absorb the ability of ice with sharp icy arrows with it ");
                            System.out.println("be careful one touch might get you frostbite,stay frosty!");
                            System.out.println("You listen carefully, waiting for the snake’s movements listening to room atomsphere.");
                            System.out.println("The snake moves swiftly, using its familiarity with the room to stay out of reach.");
                            System.out.println("You can’t see it, so you focus on sound and vibrations to determine its position.");
                            System.out.println("You ready your frosty arrow, knowing the snake has the key hanging around its neck.");
                            // Step 2: First Shot -
                            System.out.println("Do you:");
                            System.out.println("1. Fire an arrow to create an icy barrier to slow the snake?");
                            System.out.println("2. Fire an arrow toward the sound to try to hit its body directly?");
                            int iceBowDecision = input.nextInt();
                            input.nextLine(); // Consume newline

                            if (iceBowDecision == 1) {
                                // Create Icy Barrier
                                System.out.println("You fire an arrow at the floor, creating a wall of ice that blocks part of the room.");
                            }
                            System.out.println("The snake hisses, forced to reroute around the frozen area.");
                            System.out.println("The ice hardens permanently, providing cover and slowing the snake."); // Snake's Movement in ice
                            System.out.println("The snake quickly circles around the barrier on walls, staying out of sight off the ice .");
                            System.out.println("You listen closely as sound is your eyes for now, waiting for the right moment to strike again.");
                            // Second Move
                            System.out.println("What do you do:");
                            System.out.println("1. Use the barrier as cover and fire another arrow at the sound?");
                            System.out.println("2. Move closer to get a better angle but risk exposure?");

                            int barrierDecision = input.nextInt();
                            input.nextLine(); // Consume newline

                            if (barrierDecision == 1) {
                                // Strategic Shot
                                System.out.println("You fire another arrow toward the sound.");
                                System.out.println("The arrow strikes true, partially freezing the snake’s tail.");
                                snakeHP -= 35;
                                System.out.println("The freezing wind slows the snake, causing it to hiss angrily. Snake HP: " + snakeHP);
                                System.out.println("You notice the key around its neck shimmering as it struggles.");
                                System.out.println("You carefully prepare your next shot to get the key.");
                            } else if (barrierDecision == 2) {
                                System.out.println("You move closer, stepping carefully over the frozen ground its slippery.");
                                System.out.println("The snake suddenly lashes out, striking you a bit!");
                                playerHP -= 20;
                                System.out.println("You barely dodge, but feel the sting of its attack. Player HP: " + playerHP);
                                System.out.println("However, you now have a clearer shot at the key!");
                            } else if (iceBowDecision == 2) {
                                // Direct Attack
                                System.out.println("You fire an arrow toward the sound of movement.");
                                System.out.println("The arrow misses slightly but freezes part of the floor, forcing the snake to reveal itself.");
                                System.out.println("You take aim again, focusing on the key around its neck.");
                                System.out.println("What do you do:");
                                System.out.println("1. Fire an arrow at the key, risking missing the shot?");
                                System.out.println("2. Freeze more of the room to trap the snake and retrieve the key afterward?");

                                int finalIceDecision = input.nextInt();
                                input.nextLine(); // Consume newline

                                if (finalIceDecision == 1) {
                                    System.out.println("You take a deep breath and release the arrow.");

                                    System.out.println("The arrow strikes the chain holding the key, freezing it in place!");
                                    snakeHP -= 25; // Snake weakened  now
                                    System.out.println("The snake hisses and struggles to break free. Snake HP: " + snakeHP);
                                    System.out.println("You quickly fire another arrow, breaking the chain and causing the key to drop to the floor!");
                                    System.out.println("You dash forward and grab the key before the snake recovers.");
                                } else if (finalIceDecision == 2) {
                                    // Trap the Snake System.out.println("You fire arrows around the snake, creating a frozen cage that limits its movements.");
                                    System.out.println("The snake tries to escape but can’t move as freely. Snake HP: " + snakeHP);
                                    System.out.println("You carefully approach and retrieve the key, keeping your weapon ready for the next door.");
                                }
                            }
                        }
                    } else if (chosenSymbol.equalsIgnoreCase("reflective")) {
                        System.out.println("Your weapon gains reflective properties, able to deflect the creature’s gaze—but only if timed right.");
                        System.out.println("Great choice! Your sword is now extra reflective and can emit a glare capable of blinding the mischievous snake.");
                        System.out.println("However, be cautious—if the snake gets too close, using the sword’s reflective surface could also expose you to danger by the looking of its stare.");

                        // Hint for Strategy
                        System.out.println("Hint: Your sword acts like a mirror. Think carefully about how to use it against a Medusa-like snake.");
                        System.out.println("Speed and agility will be key to winning this fight.Lets go!");

                        // Initial Attack
                        System.out.println("What do you do:");
                        System.out.println("1. Use the sword’s reflection to blind the snake and create an opening?");
                        System.out.println("2. Try to get close and slash directly while avoiding its gaze?");
                        int reflectDecision = input.nextInt();
                        input.nextLine(); // Consume newline
                        if (reflectDecision == 1) {
                            System.out.println("You angle your sword carefully, catching the faint light in the room.");
                            System.out.println("A sudden glare flashes into the snake’s eyes, causing it to hiss and recoil!,there eyes are sensitive!");
                            snakeHP -= 30;
                            System.out.println("Snake HP is now: " + snakeHP);
                            System.out.println("You have a moment to act before the snake recovers. Do you grab the key? (yes/no)");
                            String grabKey = input.nextLine();

                            if (grabKey.equalsIgnoreCase("yes")) {
                                System.out.println("You dash forward, using the glare as cover to snatch the key around its neck.");
                                System.out.println("But the snake lunges, barely missing you as you retreat!");
                                System.out.println("You escape with the key and head toward the door.");
                            } else {
                                System.out.println("You hesitate, and the snake recovers quickly, lunging at you!");
                                playerHP -= 15;
                                System.out.println("Player HP: " + playerHP);
                                System.out.println("You barely manage to dodge and prepare for another attempt.");
                            }  // Direct Slash
                            System.out.println("You charge in, keeping the sword angled to avoid looking directly at the snake.");
                            System.out.println("With a quick slash, you strike its side, but the snake retaliates with its tail!");
                            snakeHP -= 25;
                            playerHP -= 10;
                            System.out.println("Snake HP: " + snakeHP);
                            System.out.println("Player HP: " + playerHP);
                            System.out.println("The snake stumbles, disoriented, giving you a chance to strike again  as well as grab the key.");
                        }

                        // Final Outcome
                        if (snakeHP <= 0) {
                            System.out.println("The snake is weakened, its movements slowing. It freezes, staring at its reflection in the sword.");
                            System.out.println("As the reflective light catches the surface, the snake eyes and itself slowly turns to stone!");
                            System.out.println("You quickly  get the key and move toward the door before the effect wears onto you.");
                        }
                    }

                } else if (nextLvlChoice == 2) {
                    System.out.println(" since Freeze in fear, risking a glance at the mischievous snake medusa eyes.");
                    System.out.println("Your hesitation costs you as the snake’s gaze locks onto yours. A cold, creeping sensation spreads through your body, and before you can react, you feel your limbs harden. Your journey ends as another statue in this cursed room.");
                    System.out.println("Escape the island game has ended as another statue in the room");
                    gameRunning = false; //end the game
                    break; // Ensure the game loop exits completely
                } else if (nextLvlChoice == 3) {
                    System.out.println("You retreat to the previous staircase, but the door seals shut behind you. You’re forced to regroup, losing time and risking more danger as the snake’s hissing echoes grow louder.");

                    System.out.println("Growwing louder and louder the snake exits it room stage hunting");
                    System.out.println("The snake see you at the other end of previous staircase and sharply with speed pounces you into the unknown");
                    System.out.println("Escape the island has ended at the stage of unknown part one.");
                    gameRunning = false; //end the game
                    break; // Ensure the game loop exits completely
                } else {
                    System.out.println("Invalid choice. Your weapon remains unchanged.");
                }
            }

            // New stage: Bridge and Riddle from Hawk with Fire Breathing
            System.out.println("After defeating the snake, you find a key that opens a door leading to a narrow bridge.");
            System.out.println("The bridge is suspended over a deep chasm, with swirling mists below.");
            System.out.println("As you step onto the bridge, a hawk with glowing eyes and fire breathing appears, blocking your path.");
            System.out.println("The hawk speaks: 'To cross this bridge, you must answer my riddles. Fail, and you shall fall.'");

            System.out.println("The hawk's first riddle is: 'I speak without a mouth and hear without ears. I have no body, but I come alive with wind. What am I?'");
            System.out.println("1. An Echo");
            System.out.println("2. A Shadow");
            System.out.println("3. A Whisper");

            int riddleAnswer1 = input.nextInt();
            input.nextLine(); // Consume newline

            if (riddleAnswer1 == 1) {
                System.out.println("Correct! An Echo is the answer.");
                System.out.println("The hawk nods and allows you to move forward on the bridge.");

                System.out.println("The hawk's second riddle is: 'I am words that you see, I am words that you hear, I am words that can bring emotion—tears, happiness, love, and more. What am I?'");
                System.out.println("1. A Song");
                System.out.println("2. A Poem");
                System.out.println("3. A Story");

                int riddleAnswer2 = input.nextInt();
                input.nextLine(); // Consume newline

                if (riddleAnswer2 == 2) {
                    System.out.println("Correct! A Poem is the answer.");
                    System.out.println("The hawk nods and allows you to pass. You carefully cross the bridge and continue your journey.");
                } else {
                    System.out.println("Incorrect! The answer is a Poem.");
                    System.out.println("The hawk's fire breathing activates, and the bridge begins to shake.");
                    System.out.println("You lose your footing and fall into the chasm below.");
                    System.out.println("Escape the Island game has ended.");
                    gameRunning = false;
                    break; // Ensure the game loop exits completely
                }
            } else {
                System.out.println("Incorrect! The answer is an Echo.");
                System.out.println("The hawk's fire breathing activates, and the bridge begins to shake.");
                System.out.println("You lose your footing and fall into the chasm below.");
                System.out.println("Escape the Island game has ended.");
                gameRunning = false;
                break; // Ensure the game loop exits completely
            }

            // New stage: Sea Serpent and Shadow Beings
            System.out.println("After crossing the bridge, you find yourself at the edge of a vast, dark sea.");
            System.out.println("Shadowy figures appear before you, whispering: 'Free us, and you shall be free as well.'");
            System.out.println("Suddenly, a massive sea serpent emerges from the water, its eyes glowing with malice.");

            System.out.println("The shadow beings say: 'Defeat the serpent, and we will be free. But beware, the water is rising.'");
            System.out.println("You must act quickly to defeat the serpent and save the shadow beings before the water consumes you all.");

            System.out.println("Choose your action:");
            System.out.println("1. Attack the serpent with your weapon.");
            System.out.println("2. Use the environment to your advantage.");
            System.out.println("3. Attempt to communicate with the serpent.");
            System.out.println("4. Stay on the island and become its guardian.");

            int finalChoice = input.nextInt();
            input.nextLine(); // Consume newline

            if (finalChoice == 1) {
                System.out.println("You charge at the serpent with your weapon, striking it with all your might.");
                System.out.println("The serpent roars in pain, but the water continues to rise.");
                System.out.println("You manage to wound the serpent, but it retaliates, knocking you back.");
                playerHP -= 20;
                System.out.println("Player HP: " + playerHP);

                if (playerHP > 0) {
                    System.out.println("With one final effort, you strike the serpent's head, defeating it.");
                    System.out.println("The shadow beings are freed, revealing themselves to be the spirits of people trapped on the island.");
                    System.out.println("They thank you and guide you to safety. You have escaped the island!");
                    System.out.println("A burst of energy arises, shaking the island. Many portals open, allowing the people you saved to return home.");
                    System.out.println("They will not remember being on the island but will be found on the news as having magically reappeared at home.");
                    System.out.println("You decide to join them in the portal and find yourself back at work.");
                    System.out.println("As you return to work, you see the news reporting that people who had been missing have returned to their families.");
                    System.out.println("You smile at the news but don't know why, having lost your memory as well.");
                    System.out.println("Congratulations! You have achieved the 'Saviour: A Way Home' ending.");
                } else {
                    System.out.println("You succumb to your injuries, and the water consumes you. The game has ended.");
                    gameRunning = false;
                    break; // Ensure the game loop exits completely
                }
            } else if (finalChoice == 2) {
                System.out.println("You look around and notice large rocks and debris that you can use to your advantage.");
                System.out.println("You climb onto a rock and wait for the serpent to approach.");
                System.out.println("As it lunges at you, you push a large boulder onto its head, stunning it.");
                System.out.println("You quickly strike the serpent, defeating it.");
                System.out.println("The shadow beings are freed, revealing themselves to be the spirits of people trapped on the island.");
                System.out.println("They thank you and guide you to safety. You have escaped the island!");
                System.out.println("A burst of energy arises, shaking the island. Many portals open, allowing the people you saved to return home.");
                System.out.println("They will not remember being on the island but will be found on the news as having magically reappeared at home.");
                System.out.println("However, you notice a different portal, glowing with a golden light.");
                System.out.println("The shadow beings say: 'This portal leads to a new adventure. Are you ready for more?'");
                System.out.println("You step towards the golden portal, knowing that your journey is not over, but this island is.");
                System.out.println("Congratulations! You have achieved the 'A Hero's Path Continues' ending.");
                gameRunning = false;
                break; // Ensure the game loop exits completely
            } else if (finalChoice == 3) {
                System.out.println("You attempt to communicate with the serpent, speaking calmly and soothingly.");
                System.out.println("The serpent hesitates, its eyes softening.");
                System.out.println("The shadow beings whisper: 'You have shown compassion. We are free.'");
                System.out.println("The serpent retreats into the water, and the shadow beings reveal themselves to be the spirits of people trapped on the island.");
                System.out.println("They thank you and guide you to safety. You have escaped the island!");
                System.out.println("A burst of energy arises, shaking the island. Many portals open, allowing the people you saved to return home.");
                System.out.println("They will not remember being on the island but will be found on the news as having magically reappeared at home.");
                System.out.println("You decide to join them in the portal and find yourself back at work.");
                System.out.println("As you return to work, you see the news reporting that people who had been missing have returned to their families.");
                System.out.println("You smile at the news but don't know why, having lost your memory as well.");
                System.out.println("Congratulations! You have achieved the 'Saviour: A Way Home' ending.");
                gameRunning = false;
                break; // Ensure the game loop exits completely
            } else if (finalChoice == 4) {
                System.out.println("You decide to stay on the island and become its guardian, protecting it from future threats.");
                System.out.println("The shadow beings thank you for your bravery and dedication.");
                System.out.println("You watch as they step through the portals, returning to their homes.");
                System.out.println("As the last portal closes, a powerful figure appears before you.");
                System.out.println("The figure says: 'I knew you would stay. You were always the chosen one, destined to protect this island.'");
                System.out.println("You feel a sense of peace and purpose, knowing that your journey is far from over.");
                System.out.println("Congratulations! You have achieved the 'Guardian of the Island' ending.");
                gameRunning = false;
                break; // Ensure the game loop exits completely
            } else {
                System.out.println("Invalid choice. The water consumes you. The game has ended.");
                gameRunning = false;
                break; // Ensure the game loop exits completely
            }

            input.close();  // Close scanner to avoid resource leak
        }
    }

    // Function to handle dialogue phases
    public static void dialoguePhase(Scanner input, String prompt, int thinkingSkills) {
        System.out.println(prompt);
        String response = input.nextLine();
        System.out.println("You chose: " + response);
        System.out.println("Your thinking has gone up: " + thinkingSkills);
    }
}

