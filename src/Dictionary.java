/**
 * Lucy Adelson (ema53)
 * Dictionary class creates a small dictionary
 * uses separate chaining
 * edited code from textbook for separate chaining
 */
import java.util.*;

public class Dictionary {
    private static LinkedList<String>[] w; //linked list that will be populated with linked lists for words


    /**
     * constructor
     * assigns a LinkedList to each space in w, the LinkedList array
     */
    public Dictionary() {
        w = new LinkedList[1013]; //prime number

        //populates LinkedList w with LinkedLists
        for (int i = 0; i < w.length; i++) {
            w[i] = new LinkedList<>();
        }

        //calls method to add words to dictionary
        addWords();

    }

    /**
     * inserts words that are in an array of String into the hashtable through hashing
     * @param s array of String words to insert into dictionary
     */
    public static void insert(String[] s) {

        //for each String in inputted array, s, hash the string to put into hashtable
        for (String st : s) {
            int h = hash(st);
            if (!w[h].contains(st)) { //if LinkedList (chain) at index that st is hashed to does NOT have st, add it
                w[h].add(st);
            }
        }

    }


    /**
     * see if the hash table contains an item being searched for
     * @param s is the String word being searched for
     * @return true if s is found, false if it is not found
     */
    public static boolean contains(String s) {
        int h = hash(s);
        boolean c = false;

        if (w[h].contains(s)) { //LinkedList (chain) at index that s is hashed to contains s, return true
            c = true;
        }
        //for each word (string value) in the chain at index that s is hashed to, see if the chain has a word,
        //or part of a word, that matches input String s
        for (int i = 0; i < w[h].size(); i++) {
            String st = w[h].get(i);
            for (int j = 0; j < st.length(); j++) {
                if (st.substring(0, j).equals(s)) {
                    c = true; //at least part of the word in the chain matches the input s
                }
            }

        }
        return c;
    }

    /**
     * hashes input String value into hash table
     * hashes the first letter of a word into table
     * this way the separate chain will contain words that also begin with this letter
     * @param s String value that needs to be hashed to the first letter/character
     * @return integer value of the index where s was hashed to
     */
    private static int hash(String s) {
        s = s.toLowerCase();
        int hashValue = s.charAt(0); //int value of the first character of s
        int tableSize = 1013;

        hashValue %= tableSize;
        if (hashValue < 0) {
            hashValue += tableSize;
        }

        return hashValue;
    }


    /**
     * prints the contents of hash table
     */
    public static void print() {
        for (int i = 0; i < w.length; i++) {
            System.out.println(i + "  " + w[i]);
        }

    }


    /**
     * returns list of suggested words that have letters that  match the input word
     * @param s String input word or partial word
     * @return String of words that have full or partial matches of input word
     */
    public static String getSuggestion(String s) {
        s = s.toLowerCase();
        int h = hash(s);
        String words = "";
        int sLength = s.length();

        //goes through separate chain (LinkedList) to determine what words should be suggested
        for (int i = 0; i < w[h].size(); i++) {
            if (w[h].get(i).length() >= sLength) {
                if (w[h].get(i).substring(0, sLength).equals(s)) {
                    words += w[h].get(i);
                    words += "\n";
                }
            }

        }

        return words;
    }

    /**
     * adds words to Dictionary by creating array of String and using method insert(String[])
     */
    private static void addWords(){
        String[] a = {"aardvark", "abstract", "absolute", "accumulate", "actual", "advice", "adult", "aerodynamics", "aesthetic", "afar", "affair", "aggravate", "age", "ahead", "ahold", "airplane", "aim", "ajar", "alive", "alphabet", "amount", "ambitious", "anger", "answer", "aorta", "ape", "application", "aquarium", "aqueduct", "artist", "argument", "asleep", "ask", "attract", "athlete", "augment", "audience", "available", "avoid", "awake", "aware", "axis", "axe", "aztec"};
        insert(a);
        String[] b = {"back", "baggage", "beach", "beard", "best", "bind", "bicycle", "blind", "black", "blizzard", "board", "bone", "box", "branch", "breakfast", "bridge", "build", "business"};
        insert(b);
        String[] c = {"cabbage", "car", "cave", "ceiling", "center", "cell", "chair", "chapter", "chemical", "circle", "city", "civil", "clap", "classic", "cliff", "couch", "coin", "cold", "cow", "crazy", "criminal", "curiosity", "custody", "cynical", "cylinder"};
        insert(c);
        String[] d = {"danger", "dark", "data", "deal", "decide", "decorate", "different", "difficult", "dirt", "distress", "double", "down", "dodge", "drive", "draft", "dribble", "dusk", "dune", "dump", "dugout"};
        insert(d);
        String[] e = {"each", "eager", "east", "ebb", "ebony", "economy", "ecology", "edge", "edit", "effort", "efficient", "egg", "egregious", "either", "eight", "eject", "elect", "elbow", "embarrass", "emergency", "end", "encourage", "eon", "epiphany", "epilogue", "equal", "equipment", "erase", "error", "escape", "estimate", "eternal", "ethical", "euphemism", "euthanize", "every", "evacuate", "ewe", "exit", "examine", "eye", "eyebrow"};
        insert(e);
        String[] f = {"fabulous", "famous", "fart", "ferocious", "ferret", "few", "file", "fit", "fire", "flick", "fly", "flame", "foul", "fond", "found", "fried", "frame", "frisbee", "furniture", "fun", "full"};
        insert(f);
        String[] g = {"gallop", "gain", "gelatin", "gentleman", "ghetto", "ghost", "girl", "gift", "giant", "gloat", "glucose", "glacier", "gnome", "government", "gossip", "goat", "grass", "gross", "green", "gun", "guitar", "gyro", "gymnastics"};
        insert(g);
        String[] h = {"hand", "hair", "handsome", "hero", "heckle", "hefty", "hit", "hill", "hinder", "honey", "hoard", "holiday", "hunt", "humdrum", "hum", "hymn",};
        insert(h);
        String[] i = {"ibis", "ibuprofen", "ice", "icicle", "idiom", "ideal","if","iffy","igloo","ignite","illuminate","illegal","immunization","impress","initiate","intricate","ion","ipsilateral","irate","irrational","isolate","issue","itch","iterate","ivy","ivory"};
        insert(i);
        String[] j = {"jar","jam","jamboree","jealous","jewelry","jet","jingle","jigsaw","journey","jolly","join","june","jury","judge"};
        insert(j);
        String[] k = {"kale","kangaroo","keyboard","keep","kettle","khaki","kind","kill","kleptomaniac","knife","knight","knock","kosher","koi","kudos"};
        insert(k);
        String[] l = {"lazy","lawful","late","learn","left","lean","list","lick","light","lit","llama","lost","lock","lox","lonely","lust","luck","lynx"};
        insert(l);
        String[] m = {"maybe","mate","marriage","meaning","mellow","meat","might","mile","misery","most","more","mourn","mop","must","mustard","mull","murky","my","myriad","mystery"};
        insert(m);
        String[] n = {"nasty","natural","nature","name","neither","next","near","nix","night","nice","nope","not","noodle","nothing","nose","nugget","nuptial","nutrient","nucleus","nymph","nylon"};
        insert(n);
        String[] o = {"oat","oats","oar","obstruct","obsolete","oblivion","ocean","occupy","occupant","odious","odor","offer","official","ogre","ogle","ohm","onerous","one","ooze","oozy","operation","operate","opaque","original","orchestra","osmosis","oscillate","other","ottoman","ouch","ought","outside","ovulate","over","own","owner","ox","oyster","ozone"};
        insert(o);
        String[] p = {"pale","palpable","parent","peer","person","pencil","pine","pile","pinniped","pole","pour","pollen","precious","press","pretend","put","pull","puck","python","pyre"};
        insert (p);
        String[] q = {"quiet","queen","quiver","quake"};
        insert(q);
        String[] r = {"race","rain","railing","red","read","research","right","rile","rice","rift","roam","rose","rock","rocking","rut","rule","rulers","rumor","rye"};
        insert(r);
        String[] s = {"sale","sane","sailing","scoliosis","scorch","scale","search","seal","send","shallow","shadow","shine","sing","sign","signal","sinister","slow","slim","slight","smite","smother","snow","snake","soul","soup","sonic","special","spice","sriracha","stuck","sting","stale","supple","sun","sucker","sympathetic","system"};
        insert(s);
        String[] t = {"tail","tankz","taken","tear","team","tell","them","their","there","theater","tinker","time","tired","tone","towel","tomorrow","track","trace","tune","tuning","tug","typical","type"};
        insert(t);
        String[] u = {"uber","ubiquitous","udder","ugly","ugh","ukulele","ultimate","ultrasound","umbrella","under","understand","upperclassman","upstanding","urgent","urchin","useless","usurp","useful","utter","utilize"};
        insert(u);
        String[] v = {"vary","valor","valence","very","vest","vestibular","vine","villain","vote","voting","voice"};
        insert(v);
        String[] w = {"warrant","war","want","weep","west","wellness","whether","white","whisper","wind","will","willpower","word","words","wood","would","wrath","write"};
        insert(w);
        String[] x = {"xylophone","xenon"};
        insert(x);
        String[] y = {"yank","yard","yesterday","year","yellow","yield","yikes"};
        insert(y);
        String[] z = {"zap","zest","zesty","zinc","zombie","zombies","zone"};
        insert(z);

    }



}



