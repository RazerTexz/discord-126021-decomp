package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class DiffUtil$ItemCallback<T> {
    public abstract boolean areContentsTheSame(@NonNull T t, @NonNull T t2);

    public abstract boolean areItemsTheSame(@NonNull T t, @NonNull T t2);

    @Nullable
    public Object getChangePayload(@NonNull T t, @NonNull T t2) {
        return null;
    }
}
