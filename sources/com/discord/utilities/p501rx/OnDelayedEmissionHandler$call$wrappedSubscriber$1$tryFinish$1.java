package com.discord.utilities.p501rx;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: OnDelayedEmissionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OnDelayedEmissionHandler$call$wrappedSubscriber$1$tryFinish$1 extends AbstractC12240o implements Function1<Object, Unit> {
    public final /* synthetic */ OnDelayedEmissionHandler$call$wrappedSubscriber$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnDelayedEmissionHandler$call$wrappedSubscriber$1$tryFinish$1(OnDelayedEmissionHandler$call$wrappedSubscriber$1 onDelayedEmissionHandler$call$wrappedSubscriber$1) {
        super(1);
        this.this$0 = onDelayedEmissionHandler$call$wrappedSubscriber$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2(obj);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object obj) {
        if (this.this$0.this$0.hasFinished.getAndSet(true)) {
            return;
        }
        this.this$0.this$0.onDelayCallback.invoke(Boolean.FALSE);
    }
}
