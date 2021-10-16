package core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author GTsung
 * @date 2021/10/16
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
