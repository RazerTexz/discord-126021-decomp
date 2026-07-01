package androidx.transition;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Transition$ArrayListManager {
    private Transition$ArrayListManager() {
    }

    public static <T> ArrayList<T> add(ArrayList<T> arrayList, T t) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (!arrayList.contains(t)) {
            arrayList.add(t);
        }
        return arrayList;
    }

    public static <T> ArrayList<T> remove(ArrayList<T> arrayList, T t) {
        if (arrayList == null) {
            return arrayList;
        }
        arrayList.remove(t);
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }
}
