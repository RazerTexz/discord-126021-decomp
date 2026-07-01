package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LiveDataKt$observe$wrappedObserver$1<T> implements Observer<T> {
    public final /* synthetic */ Function1 $onChanged;

    public LiveDataKt$observe$wrappedObserver$1(Function1 function1) {
        this.$onChanged = function1;
    }

    @Override // androidx.view.Observer
    public final void onChanged(T t) {
        this.$onChanged.invoke(t);
    }
}
