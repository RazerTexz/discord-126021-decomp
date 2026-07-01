package com.discord.utilities.viewcontroller;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.analytics.Traits$Payment$Type;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.Subscription;

/* JADX INFO: compiled from: RxViewController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxViewController$connectViewRx$2 extends o implements Function1<Subscription, Unit> {
    public final /* synthetic */ Ref$ObjectRef $subscriptionResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxViewController$connectViewRx$2(Ref$ObjectRef ref$ObjectRef) {
        super(1);
        this.$subscriptionResult = ref$ObjectRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        m.checkNotNullParameter(subscription, Traits$Payment$Type.SUBSCRIPTION);
        this.$subscriptionResult.element = subscription;
    }
}
