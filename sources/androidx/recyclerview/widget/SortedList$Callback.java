package androidx.recyclerview.widget;

import androidx.annotation.Nullable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public abstract class SortedList$Callback<T2> implements Comparator<T2>, ListUpdateCallback {
    public abstract boolean areContentsTheSame(T2 t2, T2 t3);

    public abstract boolean areItemsTheSame(T2 t2, T2 t3);

    @Override // java.util.Comparator
    public abstract int compare(T2 t2, T2 t3);

    @Nullable
    public Object getChangePayload(T2 t2, T2 t3) {
        return null;
    }

    public abstract void onChanged(int i, int i2);

    public void onChanged(int i, int i2, Object obj) {
        onChanged(i, i2);
    }
}
