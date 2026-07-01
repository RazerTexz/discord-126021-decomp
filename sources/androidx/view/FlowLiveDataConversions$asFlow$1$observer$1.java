package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import s.a.c2.f;

/* JADX INFO: compiled from: FlowLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FlowLiveDataConversions$asFlow$1$observer$1<T> implements Observer<T> {
    public final /* synthetic */ f $channel;

    public FlowLiveDataConversions$asFlow$1$observer$1(f fVar) {
        this.$channel = fVar;
    }

    @Override // androidx.view.Observer
    public final void onChanged(T t) {
        this.$channel.offer(t);
    }
}
