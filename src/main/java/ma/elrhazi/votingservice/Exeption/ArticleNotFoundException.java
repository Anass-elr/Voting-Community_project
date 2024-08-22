package ma.elrhazi.votingservice.Exeption;

public class ArticleNotFoundException extends RuntimeException{

    public ArticleNotFoundException(String msg){
        super(msg);
    }
}
