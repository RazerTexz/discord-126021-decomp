package androidx.view;

import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import java.time.Duration;
import kotlin.coroutines.CoroutineContext;
import s.a.d2.d;
import s.a.d2.f;

/* JADX INFO: compiled from: FlowLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FlowLiveDataConversions {
    public static final <T> d<T> asFlow(LiveData<T> liveData) {
        m.checkNotNullParameter(liveData, "$this$asFlow");
        return new f(new FlowLiveDataConversions$asFlow$1(liveData, null));
    }

    public static final <T> LiveData<T> asLiveData(d<? extends T> dVar) {
        return asLiveData$default(dVar, (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(d<? extends T> dVar, CoroutineContext coroutineContext) {
        return asLiveData$default(dVar, coroutineContext, 0L, 2, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(d<? extends T> dVar, CoroutineContext coroutineContext, long j) {
        m.checkNotNullParameter(dVar, "$this$asLiveData");
        m.checkNotNullParameter(coroutineContext, "context");
        return CoroutineLiveDataKt.liveData(coroutineContext, j, new FlowLiveDataConversions$asLiveData$1(dVar, null));
    }

    public static /* synthetic */ LiveData asLiveData$default(d dVar, CoroutineContext coroutineContext, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = d0.w.f.j;
        }
        if ((i & 2) != 0) {
            j = 5000;
        }
        return asLiveData(dVar, coroutineContext, j);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> asLiveData(d<? extends T> dVar, CoroutineContext coroutineContext, Duration duration) {
        m.checkNotNullParameter(dVar, "$this$asLiveData");
        m.checkNotNullParameter(coroutineContext, "context");
        m.checkNotNullParameter(duration, "timeout");
        return asLiveData(dVar, coroutineContext, duration.toMillis());
    }

    public static /* synthetic */ LiveData asLiveData$default(d dVar, CoroutineContext coroutineContext, Duration duration, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = d0.w.f.j;
        }
        return asLiveData(dVar, coroutineContext, duration);
    }
}
