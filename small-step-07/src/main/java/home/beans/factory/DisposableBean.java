package home.beans.factory;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface DisposableBean {


    void destroy() throws Exception;
}
