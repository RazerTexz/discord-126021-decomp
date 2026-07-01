package com.discord.utilities.rx;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$wrappedSubscriber$1$tryFinish$1, reason: use source file name */
/* JADX INFO: compiled from: OnDelayedEmissionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OnDelayedEmissionHandler3 extends Lambda implements Function1<Object, Unit> {
    public final /* synthetic */ OnDelayedEmissionHandler2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnDelayedEmissionHandler3(OnDelayedEmissionHandler2 onDelayedEmissionHandler2) {
        super(1);
        this.this$0 = onDelayedEmissionHandler2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2(obj);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object obj) {
        if (this.this$0.this$0.hasFinished.getAndSet(true)) {
            return;
        }
        this.this$0.this$0.onDelayCallback.invoke(Boolean.FALSE);
    }
}
