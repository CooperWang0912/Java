public class DepressedBot extends ChatBot{
    @Override
    public void sayHi(){
        System.out.println("Hello there");
    }

    @Override
    public void sayBye(){
        System.out.println("Good bye, I hope I can live to the day when we meet again");
    }

    @Override
    public void startConversation(){
        System.out.println("Want to talk?");
    }

    @Override
    public void askFirstQuestion(){
        System.out.println("What is our purpose?");
    }

    @Override
    public void askSecondQuestion(){
        System.out.println("Why am I still alive?");
    }

    @Override
    public void askThirdQuestion(){
        System.out.println("When can I stop suffering?");
    }
}
