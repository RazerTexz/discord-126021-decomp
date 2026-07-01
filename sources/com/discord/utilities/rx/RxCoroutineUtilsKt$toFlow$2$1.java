package com.discord.utilities.rx;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Subscription;

/* JADX INFO: compiled from: RxCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxCoroutineUtilsKt$toFlow$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Subscription $subscription;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxCoroutineUtilsKt$toFlow$2$1(Subscription subscription) {
        super(0);
        this.$subscription = subscription;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$subscription.unsubscribe();
    }
}
