package py.edu.ucsa.cliente.web.config;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.digester.Digester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationFactory
{
    private static Logger log = LoggerFactory.getLogger(ConfigurationFactory.class);
    
    private static Configuration config = null;

    //"C:/tools/jboss-eap-6.4/standalone/configuration/apps/modulo4-153/frontend-config.xml";
    //"/opt/jboss-eap-6.4/standalone/configuration/apps/modulo4-153/frontend-config.xml";
    private static String CONFIGFILE = null;
    

    public static Configuration getConfig()
    {
        if (config == null)
        {
            config = load();
        }
        return config;
    }

    public static void reload()
    {
        synchronized (config)
        {
            config = null;
            load();
        }
    }

    private static Configuration load()
    {
        try
        {
            Digester digester = new Digester();

            Configuration conf = new ConfigurationXMLImpl();
            digester.push(conf);

            digester.addBeanPropertySetter("frontend/restService/app/id","appId");
			digester.addBeanPropertySetter("frontend/restService/host","restServiceHost");
			digester.addBeanPropertySetter("frontend/restService/authentication/user","username");
            digester.addBeanPropertySetter("frontend/restService/authentication/pass","password");

            String filePath = getConfigfile();
            File file = new File(filePath);
            
            if(file.exists())
            {
                digester.parse(new FileInputStream(filePath));
            }
            else
            {
                log.error("No se cuentra el archivo de configuracion en:");
                log.error(filePath);
            }
            
            return conf;
        }
        catch (Exception e)
        {
            log.error("error reading configuration", e);
            throw new RuntimeException(e); // should not continue
        }
    }
    
    public static String getConfigfile()
    {
        if(CONFIGFILE == null)
        {
//            String serverConfigFolder = null;
//            
//            serverConfigFolder = "JBOSS_SERVER_CONFIG_URL";
            
            String folderurl = fixUrlName(System.getenv("JBOSS_SERVER_CONFIG_URL"));
            
            CONFIGFILE = folderurl + "/apps/modulo4-153/frontend-config.xml";
        }

        return CONFIGFILE;
    }

    
    public static String fixUrlName(String folderurl)
    {
        if(folderurl.contains("file:")) {
            String[] split = folderurl.split("file:");
            folderurl = split[1];
        }
        
        return folderurl;
    }

}
