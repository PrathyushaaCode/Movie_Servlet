package dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Movie;



public class MovieDao {
//	private static final Object Movie = null;
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("m9");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void saveMovie(Movie movie)
	{
		transaction.begin();
		manager.persist(movie);
		transaction.commit();
	}
		
	
	public List<Movie> fetchMovies(){
		return manager.createQuery("select x from Movie x").getResultList();
	}
	
	public List<Movie> fetchMoviesById(int no)
	{
		return manager.createQuery("select x from Movie x where id=?3").setParameter(3, no).getResultList();
	}
	
	public List<Movie> fetchMoviesByRating(double rating)
	{
		return manager.createQuery("select x from Movie x where rating >= ?2").setParameter(2, rating).getResultList();
	}
	
	public List<Movie> fetchMovieByName(String name)
	{
		return manager.createQuery("select x from Movie x where name=?1").setParameter(1, name).getResultList();
	}
	
	public List<Movie> fetchMovieByLang(String name)
	{
		return manager.createQuery("select x from Movie x where language=?4").setParameter(4, name).getResultList();
	}
	
	public List<Movie> fetchMoviesByGenre(String name)
	{
		return manager.createQuery("select x from Movie x where Genre=?5").setParameter(5, name).getResultList();
	}


	public void deleteMovie(int id) {
		transaction.begin();
		manager.remove(manager.find(Movie.class, id));
		transaction.commit();
	}


	
	

}
