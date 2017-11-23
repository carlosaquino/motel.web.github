package py.edu.ucsa.cliente.web.config;

public interface Configuration {

	/**
	 * Devuelve el host del rest
	 * @return
	 */
	public String getRestServiceHost();

	/**
	 * Asigna el valor del host del rest
	 * @param restServiceHost
	 */
	public void setRestServiceHost(String restServiceHost);
	
	/**
	 * Devuelve el nombre del rest api
	 * @return
	 */
	public String getAppId();
	
	/**
	 * Asigna el valor del nombre del rest api
	 * @param appId
	 */
	public void setAppId(String appId);
	
	/**
	 * Devuelve el nombre de usuario
	 * @return
	 */
	public String getUsername();
	
	/**
	 * Asigna el nombre de usuario a ser utilizado para la conexi&oacute;n
	 * @param username
	 */
	public void setUsername(String username);
	
	/**
	 * Devuelve la clave 
	 * @return
	 */
	public String getPassword();
	
	/**
	 * Asigna la clave obtenida del archivo de configuraci&oacute;n
	 * @param encodedPassword
	 */
	public void setPassword(String password);
    
}

