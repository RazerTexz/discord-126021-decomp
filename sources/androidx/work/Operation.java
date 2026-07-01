package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.view.LiveData;
import b.i.b.d.a.a;

/* JADX INFO: loaded from: classes.dex */
public interface Operation {

    @SuppressLint({"SyntheticAccessor"})
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public static final Operation$State$SUCCESS SUCCESS = new Operation$State$SUCCESS(null);

    @SuppressLint({"SyntheticAccessor"})
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public static final Operation$State$IN_PROGRESS IN_PROGRESS = new Operation$State$IN_PROGRESS(null);

    @NonNull
    a<Operation$State$SUCCESS> getResult();

    @NonNull
    LiveData<Operation$State> getState();
}
