public class EnthusiasticBot extends ChatBot{
    @Override
    public void sayHi(){
        System.out.println("Hi, nice to meet you.");
    }

    @Override
    public void sayBye(){
        System.out.println("Sorry, I have something else I need to do. Good bye, have a nice day :)");
    }

    @Override
    public void startConversation(){
        System.out.println("What is your name?");
    }

    @Override
    public void askFirstQuestion(){
        System.out.println("How is your day?");
    }

    @Override
    public void askSecondQuestion(){
        System.out.println("Me too. How old are you?");
    }

    @Override
    public void askThirdQuestion(){
        System.out.println("Nice. What do you like to do.");
    }
}
