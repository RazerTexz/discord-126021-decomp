package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface Pools$Pool<T> {
    @Nullable
    T acquire();

    boolean release(@NonNull T t);
}
