package com.discord.utilities.rx;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: OnDelayedEmissionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OnDelayedEmissionHandler$call$3 extends o implements Function1<Subscription, Unit> {
    public final /* synthetic */ OnDelayedEmissionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnDelayedEmissionHandler$call$3(OnDelayedEmissionHandler onDelayedEmissionHandler) {
        super(1);
        this.this$0 = onDelayedEmissionHandler;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        m.checkNotNullParameter(subscription, "it");
        OnDelayedEmissionHandler.access$setDelaySubscription$p(this.this$0, subscription);
    }
}
