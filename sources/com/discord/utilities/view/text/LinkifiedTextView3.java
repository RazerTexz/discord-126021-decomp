package com.discord.utilities.view.text;

import android.view.View;
import b.i.a.f.e.o.f;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import s.a.Dispatchers;
import s.a.a.MainDispatchers;

/* JADX INFO: renamed from: com.discord.utilities.view.text.LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1, reason: use source file name */
/* JADX INFO: compiled from: LinkifiedTextView.kt */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.discord.utilities.view.text.LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1", f = "LinkifiedTextView.kt", l = {Opcodes.D2I}, m = "invokeSuspend")
public final class LinkifiedTextView3 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Ref$ObjectRef $clickableSpan;
    public final /* synthetic */ WeakReference $weakView;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ LinkifiedTextView.ClickableSpanOnTouchListener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkifiedTextView3(LinkifiedTextView.ClickableSpanOnTouchListener clickableSpanOnTouchListener, WeakReference weakReference, Ref$ObjectRef ref$ObjectRef, Continuation continuation) {
        super(2, continuation);
        this.this$0 = clickableSpanOnTouchListener;
        this.$weakView = weakReference;
        this.$clickableSpan = ref$ObjectRef;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        LinkifiedTextView3 linkifiedTextView3 = new LinkifiedTextView3(this.this$0, this.$weakView, this.$clickableSpan, continuation);
        linkifiedTextView3.L$0 = obj;
        return linkifiedTextView3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LinkifiedTextView3) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        View view;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            Result3.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            long j = this.this$0.longPressDelayInMs;
            this.L$0 = coroutineScope2;
            this.label = 1;
            if (f.P(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            Result3.throwOnFailure(obj);
            coroutineScope = coroutineScope3;
        }
        if (!this.this$0.isClickHandled.getAndSet(true) && f.y0(coroutineScope) && (view = (View) this.$weakView.get()) != null) {
            CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
            f.H0(coroutineScope, MainDispatchers.f3830b, null, new LinkifiedTextView4(view, null, this, coroutineScope), 2, null);
        }
        return Unit.a;
    }
}
