package src.controls.second.task_c;

public class FilterForString<T> implements Filter<T> {

    @Override
    public boolean apply(T o) {
        if (o instanceof String) {
            return this.equals(o);
        } else {
            return false;
        }
    }

}
