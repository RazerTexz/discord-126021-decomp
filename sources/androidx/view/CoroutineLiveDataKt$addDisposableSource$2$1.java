package androidx.view;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CoroutineLiveDataKt$addDisposableSource$2$1<T> implements Observer<T> {
    public final /* synthetic */ CoroutineLiveDataKt$addDisposableSource$2 this$0;

    public CoroutineLiveDataKt$addDisposableSource$2$1(CoroutineLiveDataKt$addDisposableSource$2 coroutineLiveDataKt$addDisposableSource$2) {
        this.this$0 = coroutineLiveDataKt$addDisposableSource$2;
    }

    @Override // androidx.view.Observer
    public final void onChanged(T t) {
        this.this$0.$this_addDisposableSource.setValue(t);
    }
}
