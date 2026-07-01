package b.b.a.d;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Size;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ThumbnailViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
@d0.w.i.a.e(c = "com.lytefast.flexinput.adapters.ThumbnailViewHolder$ThumbnailBitmapGenerator$getThumbnailQ$2", f = "ThumbnailViewHolder.kt", l = {}, m = "invokeSuspend")
public final class k extends d0.w.i.a.k implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    public final /* synthetic */ ContentResolver $contentResolver;
    public final /* synthetic */ Uri $uri;
    public int label;
    public final /* synthetic */ i$b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(i$b i_b, ContentResolver contentResolver, Uri uri, Continuation continuation) {
        super(2, continuation);
        this.this$0 = i_b;
        this.$contentResolver = contentResolver;
        this.$uri = uri;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        d0.z.d.m.checkNotNullParameter(continuation, "completion");
        return new k(this.this$0, this.$contentResolver, this.$uri, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        Continuation<? super Bitmap> continuation2 = continuation;
        d0.z.d.m.checkNotNullParameter(continuation2, "completion");
        return new k(this.this$0, this.$contentResolver, this.$uri, continuation2).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        d0.w.h.c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        d0.l.throwOnFailure(obj);
        try {
            return this.$contentResolver.loadThumbnail(this.$uri, new Size(i.j, i.k), this.this$0.f321b);
        } catch (Exception unused) {
            return null;
        }
    }
}
