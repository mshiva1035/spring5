package group.springframework.chucknorrisforacutator.service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JokesServiceImpl implements JokesService {

    private final ChuckNorrisQuotes chuckNorrisQuotes ;

    public JokesServiceImpl(){
        this.chuckNorrisQuotes= new ChuckNorrisQuotes();
    }
    @Override
    public String getRandomQuote(){
        return chuckNorrisQuotes.getRandomQuote();
    }
}
