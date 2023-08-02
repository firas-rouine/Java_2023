import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        String greeting = String.format("Hello, %s, Lovely to see you.", name);
        return greeting;
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        String date = String.format("It is currently %s", new Date());
        return  date;

    }
    // It is currently Wed Aug 11 16:34:59 PDT 2022.
    public String respondBeforeAlexis(String phrase) {

        if(phrase.indexOf("Alexis") > -1) {
            return "She's really of no help. What can I get for you?";
        }

        if (phrase.indexOf("Alfred") > -1) {
            return "At your service, naturally. How may I be of assistance?";
        }

        return "Right. And with that I shall retire.";
    }
     public String lengthString(String Phrase) {
        int length = Phrase.length();
        return String.format("phrase Length is : %d" , length);
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
        // SENSEI BONUS
        // Write your own AlfredQuote method using any of the String methods you have learned!
}

