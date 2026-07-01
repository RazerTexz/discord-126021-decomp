package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import d0.w.i.a.d;
import d0.w.i.a.e;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.lifecycle.CoroutineLiveData", f = "CoroutineLiveData.kt", l = {227, 228}, m = "emitSource$lifecycle_livedata_ktx_release")
public final class CoroutineLiveData$emitSource$1 extends d {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ CoroutineLiveData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineLiveData$emitSource$1(CoroutineLiveData coroutineLiveData, Continuation continuation) {
        super(continuation);
        this.this$0 = coroutineLiveData;
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emitSource$lifecycle_livedata_ktx_release(null, this);
    }
}
