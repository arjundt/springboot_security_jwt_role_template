/*
 * 
 */
package in.cdac.epramaan.master.bd;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.cdac.epramaan.master.model.ConfigPara;
import in.cdac.epramaan.master.repository.ConfigParaRepository;
import lombok.RequiredArgsConstructor;


/**
 * The Class MasterConfigBDImpl.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ConfigParaBDImpl implements ConfigParaBD {
	
	 
    /** The Constant logger. */
    private static final Logger logger = LoggerFactory
            .getLogger(ConfigParaBDImpl.class);
    
    
    private final ConfigParaRepository configParaRepository;
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * in.cdac.epramaan.common.bd.MasterConfigBD#getConfigPara(in.cdac.epramaan
     * .util.ConfigParaKey)
     */
    @Override
    public ConfigPara getConfigPara(String paraname) {

		try{
//    		return masterConfigDAO.getConfigPara(paraname);
    		return configParaRepository.findByParaname(paraname).orElse(null);
    	}catch(EmptyResultDataAccessException e){
    		logger.error("ConfigPara: " + paraname + " does not exist!");
            return null;
    	}
    }


	/* (non-Javadoc)
	 * @see in.cdac.epramaan.master.bd.MasterConfigBD#getConfigParas()
	 */
	@Override
	public List<ConfigPara> getAllConfigParas() {
//		return masterConfigDAO.getConfigParas();
		return configParaRepository.findAll();
	}
    
}
