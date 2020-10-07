/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (findWord(statement,"no") >= 0)
        {
            response = "Why so negative?";
            
        }
        else if (findWord(statement,"I") == 0 && findWord(statement, "you")==statement.length()-3)
        {
            response = transformIYouStatement(statement);
        }
        else if (findWord(statement,"you") >= 0 && findWord(statement, "me")==statement.length()-2)
        {
            response = transformYouMeStatement(statement);
        }
        else if (findWord(statement,"I want to") >= 0)
        {
            response = transformIWantToStatement(statement);
        }
        else if (findWord(statement,"I want") >= 0)
        {
            response = transformIWantStatement(statement);
        }
        else if (findWord(statement,"videogame") >= 0
                || findWord(statement,"Minecraft") >= 0)
        {
            response = getRandomResponseGames();
        }
        else if (findWord(statement,"mother") >= 0
                || findWord(statement,"father") >= 0
                || findWord(statement,"sister") >= 0
                || findWord(statement,"brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (findWord(statement,"cat") >= 0
                || findWord(statement,"dog") >= 0
                || findWord(statement,"cats") >= 0
                || findWord(statement,"dogs") >= 0)
        {
            response = "Tell me more about your pets.";
        }
        else if (findWord(statement,"Nathan") >= 0)
        {
            response = getRandomResponseNathan();
        }
        else if (statement.trim().equals(""))
        {
            response = "Alright, keep your secrets...";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 7;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Bruh.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "Jimmy's Mom.";
        }
        else if (whichResponse == 5)
        {
            response = "K.";
        }
        else if (whichResponse == 6)
        {
            response = "I find your lack of faith disturbing.";
        }
    
        return response;
    }

    public String getRandomResponseNathan()
    {
        final int NUMBER_OF_RESPONSES = 3;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "I hear he, he being the AWESOME TEACHER Nathan Lin, is kinda epic ngl.";
        }
        else if (whichResponse == 1)
        {
            response = "Nathan Lin?! Wow he is great!";
        }
        else if (whichResponse == 2)
        {
            response = "Nathan is such a cool and epic individual.";
        }
        return response;
    }
     public String getRandomResponseGames()
    {
        final int NUMBER_OF_RESPONSES = 3;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "1v1 me on Hypixel nerd.";
        }
        else if (whichResponse == 1)
        {
            response = "Bro can you even Breezily?";
        }
        else if (whichResponse == 2)
        {
            response = "I love Minecraft.";
        }
        return response;
    }
    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
        String strL = " " + str.toLowerCase()+" ";
        String wordL = " " + word.toLowerCase()+ " ";
        
        return strL.indexOf(wordL);

        /*
        for(int i = 0; i<str.length();i++){
            if(wordL.equals(strL)){
                return strL.indexOf(wordL);
            }else if(strL.charAt(i)==" "&&strL.substring(i+1,i+))
        }
        
        else if  (
            wordL.equals(strL)
            || strL.indexOf(wordL)==0 && strL.substring(wordL.length(),wordL.length()+1).equals(" ")
            ||strL.indexOf(wordL)!=0 && strL.length()-1-wordL.length() == strL.indexOf(wordL) && strL.substring(strL.indexOf(wordL)-1,strL.indexOf(wordL)).equals(" ") 
            ||strL.indexOf(wordL)!=0 && strL.substring((strL.indexOf(wordL)-1),strL.indexOf(wordL)).equals(" ") && strL.substring(wordL.length(),wordL.length()+1).equals(" ")
            )
            {
            return strL.indexOf(wordL);
        }else{
            return -1;
        }
        */
    }

    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    { 
        if(findWord(statement, "I want")+7>statement.length()){
            return getRandomResponse();
        }else{
            return ("Would you really be happy if you had " + statement.substring(findWord(statement, "I want")+7) + "?");
        }
            
    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        
        return "Why do you " + statement.substring(2,findWord(statement, "you"))+ "me?";
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        return "What would it mean to "+statement.substring(10)+"?";
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        return "What makes you think that I" + statement.substring(findWord(statement, "you")+3,findWord(statement, "me"))+ "you?";
    }
}
