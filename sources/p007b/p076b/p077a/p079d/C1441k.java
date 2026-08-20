package p007b.p076b.p077a.p079d;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Size;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.b.a.d.k */
/* JADX INFO: compiled from: ThumbnailViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC12188e(m10084c = "com.lytefast.flexinput.adapters.ThumbnailViewHolder$ThumbnailBitmapGenerator$getThumbnailQ$2", m10085f = "ThumbnailViewHolder.kt", m10086l = {}, m10087m = "invokeSuspend")
public final class C1441k extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    public final /* synthetic */ ContentResolver $contentResolver;
    public final /* synthetic */ Uri $uri;
    public int label;
    public final /* synthetic */ AbstractC1439i.b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1441k(AbstractC1439i.b bVar, ContentResolver contentResolver, Uri uri, Continuation continuation) {
        super(2, continuation);
        this.this$0 = bVar;
        this.$contentResolver = contentResolver;
        this.$uri = uri;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C12238m.checkNotNullParameter(continuation, "completion");
        return new C1441k(this.this$0, this.$contentResolver, this.$uri, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        Continuation<? super Bitmap> continuation2 = continuation;
        C12238m.checkNotNullParameter(continuation2, "completion");
        return new C1441k(this.this$0, this.$contentResolver, this.$uri, continuation2).invokeSuspend(Unit.f27425a);
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Object invokeSuspend(Object obj) {
        C12183c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C12113l.throwOnFailure(obj);
        try {
            return this.$contentResolver.loadThumbnail(this.$uri, new Size(AbstractC1439i.f2159j, AbstractC1439i.f2160k), this.this$0.f2166b);
        } catch (Exception unused) {
            return null;
        }
    }
}
