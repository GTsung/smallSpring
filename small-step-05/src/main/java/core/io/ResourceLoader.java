package core.io;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
