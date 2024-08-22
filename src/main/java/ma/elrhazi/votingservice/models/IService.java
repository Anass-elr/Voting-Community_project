package ma.elrhazi.votingservice.models;

import ma.elrhazi.votingservice.entities.Article;

import java.util.List;

public interface IService<T,A> {
    public List<T> getAll();

    public T getById(A id);

    public T create(T t);

    void update(A id,T t);
    void deleteById(A id);
 }
