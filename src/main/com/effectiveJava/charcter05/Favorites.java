package main.com.effectiveJava.charcter05;

import java.util.HashMap;
import java.util.Map;

/**
 * 类型安全的异构容器
 * Created by chenbin on 2018\10\29 0029.
 */
public class Favorites {
    private Map<Class<?>,Object> favorites = new HashMap<Class<?>,Object>();

    public <T> void putFavorite(Class<T> type,T instance){
        if (type == null)
            throw new NullPointerException();
        favorites.put(type,instance);
    }

    public <T> T getFavorite(Class<T> type){
        return type.cast(favorites.get(type));
    }
}
