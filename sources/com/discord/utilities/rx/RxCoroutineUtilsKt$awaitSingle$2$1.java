package com.discord.utilities.rx;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: RxCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxCoroutineUtilsKt$awaitSingle$2$1 extends o implements Function1<Throwable, Unit> {
    public final /* synthetic */ Subscription $subscription;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxCoroutineUtilsKt$awaitSingle$2$1(Subscription subscription) {
        super(1);
        this.$subscription = subscription;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.$subscription.unsubscribe();
    }
}
