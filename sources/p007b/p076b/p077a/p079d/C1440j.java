package p007b.p076b.p077a.p079d;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CancellationSignal;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13124k0;

/* JADX INFO: renamed from: b.b.a.d.j */
/* JADX INFO: compiled from: ThumbnailViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC12188e(m10084c = "com.lytefast.flexinput.adapters.ThumbnailViewHolder$ThumbnailBitmapGenerator$generate$1", m10085f = "ThumbnailViewHolder.kt", m10086l = {102}, m10087m = "invokeSuspend")
public final class C1440j extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function1 $onGenerate;
    public final /* synthetic */ Uri $uri;
    public Object L$0;
    public int label;
    public final /* synthetic */ AbstractC1439i.b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1440j(AbstractC1439i.b bVar, Uri uri, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = bVar;
        this.$uri = uri;
        this.$onGenerate = function1;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C12238m.checkNotNullParameter(continuation, "completion");
        return new C1440j(this.this$0, this.$uri, this.$onGenerate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> continuation2 = continuation;
        C12238m.checkNotNullParameter(continuation2, "completion");
        return new C1440j(this.this$0, this.$uri, this.$onGenerate, continuation2).invokeSuspend(Unit.f27425a);
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Object invokeSuspend(Object obj) throws Throwable {
        AbstractC1439i.b bVar;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            C12113l.throwOnFailure(obj);
            this.this$0.f2166b = new CancellationSignal();
            AbstractC1439i.b bVar2 = this.this$0;
            ContentResolver contentResolver = bVar2.f2168d;
            Uri uri = this.$uri;
            this.L$0 = bVar2;
            this.label = 1;
            Objects.requireNonNull(bVar2);
            Object objM4197C1 = C3404f.m4197C1(C13124k0.f27867b, new C1441k(bVar2, contentResolver, uri, null), this);
            if (objM4197C1 == coroutine_suspended) {
                return coroutine_suspended;
            }
            bVar = bVar2;
            obj = objM4197C1;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bVar = (AbstractC1439i.b) this.L$0;
            C12113l.throwOnFailure(obj);
        }
        bVar.f2167c = (Bitmap) obj;
        this.$onGenerate.invoke(this.this$0.f2167c);
        return Unit.f27425a;
    }
}
