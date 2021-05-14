package controls.second.task_c;

public class FilterForNumbers<T> implements Filter<T> {

    public boolean apply(T o) {
        if(o instanceof Number) {
            return this == o;
        }
        return false;
    }
}
