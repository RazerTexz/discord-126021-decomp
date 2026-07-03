package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import kotlin.coroutines.Continuation;
import p507d0.p584w.p586i.p587a.AbstractC12187d;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
@InterfaceC12188e(m10084c = "androidx.lifecycle.CoroutineLiveData", m10085f = "CoroutineLiveData.kt", m10086l = {234}, m10087m = "clearSource$lifecycle_livedata_ktx_release")
public final class CoroutineLiveData$clearSource$1 extends AbstractC12187d {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ CoroutineLiveData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineLiveData$clearSource$1(CoroutineLiveData coroutineLiveData, Continuation continuation) {
        super(continuation);
        this.this$0 = coroutineLiveData;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.clearSource$lifecycle_livedata_ktx_release(this);
    }
}
