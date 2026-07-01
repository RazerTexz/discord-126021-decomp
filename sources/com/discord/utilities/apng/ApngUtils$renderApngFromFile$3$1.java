package com.discord.utilities.apng;

import android.widget.ImageView;
import b.l.a.a;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ApngUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.utilities.apng.ApngUtils$renderApngFromFile$3$1", f = "ApngUtils.kt", l = {}, m = "invokeSuspend")
public final class ApngUtils$renderApngFromFile$3$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Ref$ObjectRef $drawable;
    public int label;
    public final /* synthetic */ ApngUtils$renderApngFromFile$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApngUtils$renderApngFromFile$3$1(ApngUtils$renderApngFromFile$3 apngUtils$renderApngFromFile$3, Ref$ObjectRef ref$ObjectRef, Continuation continuation) {
        super(2, continuation);
        this.this$0 = apngUtils$renderApngFromFile$3;
        this.$drawable = ref$ObjectRef;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new ApngUtils$renderApngFromFile$3$1(this.this$0, this.$drawable, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ApngUtils$renderApngFromFile$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.throwOnFailure(obj);
        ImageView imageView = (ImageView) ((WeakReference) this.this$0.$imageViewRef.element).get();
        if (imageView == null) {
            return Unit.a;
        }
        m.checkNotNullExpressionValue(imageView, "imageViewRef.get() ?: return@withContext");
        imageView.setImageDrawable((a) this.$drawable.element);
        if (this.this$0.$autoPlay) {
            ApngUtils.INSTANCE.playApngAnimation((a) this.$drawable.element);
        }
        return Unit.a;
    }
}
