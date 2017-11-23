package py.edu.ucsa.cliente.web.config;


public class ConfigurationXMLImpl implements Configuration
{
   
    private String appId = null;
    private String restServiceHost = null;
    private String username = null;
    private String pass = null;
    
    public String getRestServiceHost()
    {
        return restServiceHost;
    }

    public void setRestServiceHost(String restServiceHost)
    {
        this.restServiceHost = restServiceHost;
    }

    public String getAppId()
    {
        return appId;
    }

    public void setAppId(String appId)
    {
        this.appId = appId;
    }

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.pass;
	}

	public void setPassword(String password) {
		this.pass = password;
	}

}