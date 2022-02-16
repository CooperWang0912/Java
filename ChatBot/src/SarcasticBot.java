public class SarcasticBot extends ChatBot{
    @Override
    public void sayHi(){
        System.out.println("wHO Do wE hAvE HeRE?");
    }

    @Override
    public void sayBye(){
        System.out.println("HaHA YoU ARe sO fUnNy");
    }

    @Override
    public void startConversation(){
        System.out.println("Who asked?");
    }

    @Override
    public void askFirstQuestion(){
        System.out.println("HOw iS It pOssIBle tO Be As dUMb As YoU");
    }

    @Override
    public void askSecondQuestion(){
        System.out.println("HOw diD YoU gEt sO SmArT");
    }

    @Override
    public void askThirdQuestion(){
        System.out.println("wOW, whAt MAdE yOu SAy tHAt");
    }
}
