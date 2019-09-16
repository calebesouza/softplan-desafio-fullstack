package br.com.calebe.backend.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.calebe.backend.entities.Processo;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long>  {

	@Modifying
    @Query(value = "TRUNCATE TABLE processo", nativeQuery = true)
    void limparTabela();
	
}
