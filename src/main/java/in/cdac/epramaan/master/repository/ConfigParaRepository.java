package in.cdac.epramaan.master.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.cdac.epramaan.master.model.ConfigPara;

@Repository
public interface ConfigParaRepository extends JpaRepository<ConfigPara, String> {
	Optional<ConfigPara> findByParaname(String paraname);
}
