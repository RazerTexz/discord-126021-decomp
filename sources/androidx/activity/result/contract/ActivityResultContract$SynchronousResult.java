package androidx.activity.result.contract;

import android.annotation.SuppressLint;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultContract$SynchronousResult<T> {

    @SuppressLint({"UnknownNullness"})
    private final T mValue;

    public ActivityResultContract$SynchronousResult(@SuppressLint({"UnknownNullness"}) T t) {
        this.mValue = t;
    }

    @SuppressLint({"UnknownNullness"})
    public T getValue() {
        return this.mValue;
    }
}
