/*
 * 
 */
package in.cdac.epramaan.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Response.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
	
	boolean status;	
	EpError error;
	
}
