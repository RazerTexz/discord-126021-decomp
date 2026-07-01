package b.b.a.d;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CancellationSignal;
import b.b.a.d.ThumbnailViewHolder;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import s.a.Dispatchers;

/* JADX INFO: renamed from: b.b.a.d.j, reason: use source file name */
/* JADX INFO: compiled from: ThumbnailViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.lytefast.flexinput.adapters.ThumbnailViewHolder$ThumbnailBitmapGenerator$generate$1", f = "ThumbnailViewHolder.kt", l = {102}, m = "invokeSuspend")
public final class ThumbnailViewHolder2 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function1 $onGenerate;
    public final /* synthetic */ Uri $uri;
    public Object L$0;
    public int label;
    public final /* synthetic */ ThumbnailViewHolder.b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThumbnailViewHolder2(ThumbnailViewHolder.b bVar, Uri uri, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = bVar;
        this.$uri = uri;
        this.$onGenerate = function1;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new ThumbnailViewHolder2(this.this$0, this.$uri, this.$onGenerate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> continuation2 = continuation;
        Intrinsics3.checkNotNullParameter(continuation2, "completion");
        return new ThumbnailViewHolder2(this.this$0, this.$uri, this.$onGenerate, continuation2).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ThumbnailViewHolder.b bVar;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            Result3.throwOnFailure(obj);
            this.this$0.f321b = new CancellationSignal();
            ThumbnailViewHolder.b bVar2 = this.this$0;
            ContentResolver contentResolver = bVar2.d;
            Uri uri = this.$uri;
            this.L$0 = bVar2;
            this.label = 1;
            Objects.requireNonNull(bVar2);
            Object objC1 = b.i.a.f.e.o.f.C1(Dispatchers.f3842b, new ThumbnailViewHolder3(bVar2, contentResolver, uri, null), this);
            if (objC1 == coroutine_suspended) {
                return coroutine_suspended;
            }
            bVar = bVar2;
            obj = objC1;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bVar = (ThumbnailViewHolder.b) this.L$0;
            Result3.throwOnFailure(obj);
        }
        bVar.c = (Bitmap) obj;
        this.$onGenerate.invoke(this.this$0.c);
        return Unit.a;
    }
}
