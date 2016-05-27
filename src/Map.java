import java.util.Collection;
import java.util.Set;

/**
 * User: dmorales
 * Date: 28/02/14
 * Time: 11:04 AM
 */
public interface Map<K, V> {

    Collection<V> getValues();

    Set<Map.Entry> entrySet();

    interface Entry<K, V> {
        K getKey();

        V getValue();

        V setValue(V value);

        int hashCode();

    }

}
