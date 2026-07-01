package com.discord.utilities.coroutines;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.error.Error;
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

/* JADX INFO: compiled from: RxCoroutineExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.utilities.coroutines.RxCoroutineExtensionsKt$appAwaitSingle$2$1", f = "RxCoroutineExtensions.kt", l = {}, m = "invokeSuspend")
public final class RxCoroutineExtensionsKt$appAwaitSingle$2$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Throwable $e;
    public final /* synthetic */ Ref$ObjectRef $errorTag;
    public final /* synthetic */ Ref$ObjectRef $weakContext;
    public int label;
    public final /* synthetic */ RxCoroutineExtensionsKt$appAwaitSingle$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxCoroutineExtensionsKt$appAwaitSingle$2$1(RxCoroutineExtensionsKt$appAwaitSingle$2 rxCoroutineExtensionsKt$appAwaitSingle$2, Throwable th, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = rxCoroutineExtensionsKt$appAwaitSingle$2;
        this.$e = th;
        this.$errorTag = ref$ObjectRef;
        this.$weakContext = ref$ObjectRef2;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new RxCoroutineExtensionsKt$appAwaitSingle$2$1(this.this$0, this.$e, this.$errorTag, this.$weakContext, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RxCoroutineExtensionsKt$appAwaitSingle$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.throwOnFailure(obj);
        Error.handle(this.$e, (String) this.$errorTag.element, null, (Context) ((WeakReference) this.$weakContext.element).get(), this.this$0.$suppressToast);
        return Unit.a;
    }
}
