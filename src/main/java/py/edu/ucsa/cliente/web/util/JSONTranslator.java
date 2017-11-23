package py.edu.ucsa.cliente.web.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONTranslator<T> { //INICIO DE LA CLASE
	
	public T fromJSON(String jsondata, Class<?> clazz) throws ServiceException {
		if(jsondata == null || jsondata.isEmpty()) {
			return null;
		}  
		try {
			@SuppressWarnings("unchecked")
			T response = (T) new ObjectMapper().readValue(jsondata, clazz);
			return response;
		} catch (Exception e) {
			throw new ServiceException(ErrorCode.JSON_ENCODING_ERROR, e);
		}
	}
	
	public String toJSON(T instance) throws ServiceException{
		try{
			return new ObjectMapper().writeValueAsString(instance);
		} catch (Exception e){
	 		throw new ServiceException(ErrorCode.JSON_ENCODING_ERROR, e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> toList(String jsondata, Class<?> clazz) throws ServiceException {
		if(jsondata == null || jsondata.isEmpty()) {
			return null;
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			JavaType type = mapper.getTypeFactory()
				.constructCollectionType(ArrayList.class, clazz);
			return (List<T>) mapper.readValue(jsondata, type);
		} catch (Exception e){
			throw new ServiceException(ErrorCode.JSON_ENCODING_ERROR, e);
		}
	}
	
	public String fromList(List<T> list) throws ServiceException {
		try{
			return new ObjectMapper().writeValueAsString(list);
		} catch (Exception e) {
			throw new ServiceException(ErrorCode.JSON_ENCODING_ERROR, e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> toMap(String jsonString) throws ServiceException {
		try{
			return new ObjectMapper().readValue(jsonString, HashMap.class);
		} catch (Exception e) {
			throw new ServiceException(ErrorCode.JSON_ENCODING_ERROR, e);
		}
	}

} //FIN DE LA CLASE