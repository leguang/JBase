package cn.itsite.jbase.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: leguang
 * @e-mail: langmanleguang@qq.com
 * @version: v0.0.0
 * @blog: https://github.com/leguang
 * @time: 2018/11/25 0025 20:03
 * @description:
 */
public class ExceptionHelper {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

    public static void handle(Throwable t) {
        if (t != null) {
            t.printStackTrace();
            logger.debug("ExceptionHelper-->" + t.getMessage(), t);
        }
    }
}
