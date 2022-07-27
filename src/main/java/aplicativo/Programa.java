package aplicativo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {


		Pessoa p1 = new Pessoa(null, "carlos da silva", "carlosdasilva@gmail.com");
		Pessoa p2 = new Pessoa(null, "joaquim torres", "joaquimtorres@gmail.com");
		Pessoa p3 = new Pessoa(null,"ana maria", "anamaria@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//recuperar  no banco via JPA
		Pessoa p = em.find(Pessoa.class, 2);
		
		//remover dado da consulta
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println(p);
		
		System.out.println("pronto!");
		em.close();
		emf.close();
		
	}

}
