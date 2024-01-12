/*
 * 
 */
package in.cdac.epramaan.master.bd;

import java.util.List;

import in.cdac.epramaan.master.model.ConfigPara;


/**
 * The Interface MasterConfigBD.
 */
public interface ConfigParaBD {
    
    /**
     * Gets the config para.
     *
     * @param paraname the paraname
     * @return the config para
     */
    public ConfigPara getConfigPara(String paraname);
 
    /**
     * Gets the config paras.
     *
     * @return the config paras
     */
    public List<ConfigPara> getAllConfigParas();
	
	
}
