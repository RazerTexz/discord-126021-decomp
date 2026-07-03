package androidx.view;

import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: LiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LiveDataKt {
    @MainThread
    public static final <T> Observer<T> observe(LiveData<T> liveData, LifecycleOwner lifecycleOwner, final Function1<? super T, Unit> function1) {
        C12238m.checkNotNullParameter(liveData, "$this$observe");
        C12238m.checkNotNullParameter(lifecycleOwner, "owner");
        C12238m.checkNotNullParameter(function1, "onChanged");
        Observer<T> observer = new Observer<T>() { // from class: androidx.lifecycle.LiveDataKt$observe$wrappedObserver$1
            @Override // androidx.view.Observer
            public final void onChanged(T t) {
                function1.invoke(t);
            }
        };
        liveData.observe(lifecycleOwner, observer);
        return observer;
    }
}
