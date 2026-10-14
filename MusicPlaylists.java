import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

 class MusicPlaylists 
{
    
    static String[] songs = new String[5];
    static int[] duration = new int[5];
    static int[] plays = new int[5];
    static int count = 0;

    
    static ArrayList<String> playlist = new ArrayList<>();
    static HashMap<String, Integer> playCount = new HashMap<>();


    
    static class Song
    {
        String name;
        int time;

        Song(String name, int time)
        {
            this.name = name;
            this.time = time;
        }

        public String toString()
        {
            return name + " - " + time + " minutes";
        }
    }


    
    static void addSong()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter song name: ");
        songs[count] = sc.nextLine();

        System.out.print("Enter duration in minutes: ");
        duration[count] = sc.nextInt();

        plays[count] = 0;
        count++;

        
        playlist.add(songs[count - 1]);


        playCount.put(songs[count - 1], 0);

        System.out.println("Song added successfully!");
    }


    
    static void displaySongs() 
    {
        System.out.println("\n--- My Songs ---");

        for (int i = 0; i < count; i++) 
        {
            System.out.println((i + 1) + ". " + songs[i]);
            System.out.println("Duration: " + duration[i] + " minutes");
            System.out.println("Played: " + plays[i] + " times");
        }
    }


    
    static void playSong()
    {
        Scanner sc = new Scanner(System.in);
        displaySongs();

        System.out.print("Enter song number: ");
        int number = sc.nextInt();

        if (number >= 1 && number <= count) 
        {
            plays[number - 1]++;

            
            playCount.put(
                songs[number - 1],
                playCount.get(songs[number - 1]) + 1
            );

            System.out.println("Playing: " + songs[number - 1]);
        } 
        else 
        {
            System.out.println("Wrong song number!");
        }
    }


    
    static void showStatistics() 
    {
        int totalPlays = 0;
        int totalTime = 0;

        for (int i = 0; i < count; i++) 
        {
            totalPlays = totalPlays + plays[i];
            totalTime = totalTime + duration[i] * plays[i];
        }

        System.out.println("\n--- Listening Statistics ---");
        System.out.println("Total songs: " + count);
        System.out.println("Total plays: " + totalPlays);
        System.out.println("Total listening time: " + totalTime + " minutes");
    }



    static void searchSong()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter song name: ");
        String search = sc.nextLine();

        for (int i = 0; i < count; i++)
        {
            if (songs[i].equalsIgnoreCase(search))
            {
                System.out.println("Song found: " + songs[i]);
                return;
            }
        }

        System.out.println("Song not found!");
    }


    
    static void sortSongs()
    {
        String[] sortedSongs = Arrays.copyOf(songs, count);

        Arrays.sort(sortedSongs);

        System.out.println("\n--- Sorted Songs ---");

        for (String song : sortedSongs)
        {
            System.out.println(song);
        }
    }


    public static void main(String[] args) 
    {
    
        Scanner sc = new Scanner(System.in);

        int choice;

    
        do 
        {
            System.out.println("\n===== MUSIC PLAYLIST =====");
            System.out.println("1. Add Song");
            System.out.println("2. Display Songs");
            System.out.println("3. Play Song");
            System.out.println("4. Show Statistics");
            System.out.println("5. Search Song");
            System.out.println("6. Sort Songs");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

        
            switch (choice) 
            {
                case 1:
                    addSong();
                    break;

                case 2:
                    displaySongs();
                    break;

                case 3:
                    playSong();
                    break;

                case 4:
                    showStatistics();
                    break;

                case 5:
                    searchSong();
                    break;

                case 6:
                    sortSongs();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Please enter 1 to 7.");
            }

        } 
        while (choice != 7);

        sc.close();
    }
}