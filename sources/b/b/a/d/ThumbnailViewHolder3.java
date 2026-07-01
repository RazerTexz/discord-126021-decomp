package b.b.a.d;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Size;
import b.b.a.d.ThumbnailViewHolder;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: b.b.a.d.k, reason: use source file name */
/* JADX INFO: compiled from: ThumbnailViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.lytefast.flexinput.adapters.ThumbnailViewHolder$ThumbnailBitmapGenerator$getThumbnailQ$2", f = "ThumbnailViewHolder.kt", l = {}, m = "invokeSuspend")
public final class ThumbnailViewHolder3 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    public final /* synthetic */ ContentResolver $contentResolver;
    public final /* synthetic */ Uri $uri;
    public int label;
    public final /* synthetic */ ThumbnailViewHolder.b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThumbnailViewHolder3(ThumbnailViewHolder.b bVar, ContentResolver contentResolver, Uri uri, Continuation continuation) {
        super(2, continuation);
        this.this$0 = bVar;
        this.$contentResolver = contentResolver;
        this.$uri = uri;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new ThumbnailViewHolder3(this.this$0, this.$contentResolver, this.$uri, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        Continuation<? super Bitmap> continuation2 = continuation;
        Intrinsics3.checkNotNullParameter(continuation2, "completion");
        return new ThumbnailViewHolder3(this.this$0, this.$contentResolver, this.$uri, continuation2).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Intrinsics2.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result3.throwOnFailure(obj);
        try {
            return this.$contentResolver.loadThumbnail(this.$uri, new Size(ThumbnailViewHolder.j, ThumbnailViewHolder.k), this.this$0.f321b);
        } catch (Exception unused) {
            return null;
        }
    }
}
