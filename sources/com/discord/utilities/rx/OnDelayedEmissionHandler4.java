package com.discord.utilities.rx;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.error.Error;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$wrappedSubscriber$1$tryFinish$2, reason: use source file name */
/* JADX INFO: compiled from: OnDelayedEmissionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OnDelayedEmissionHandler4 extends Lambda implements Function1<Error, Unit> {
    public final /* synthetic */ OnDelayedEmissionHandler2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnDelayedEmissionHandler4(OnDelayedEmissionHandler2 onDelayedEmissionHandler2) {
        super(1);
        this.this$0 = onDelayedEmissionHandler2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        Intrinsics3.checkNotNullParameter(error, "error");
        OnDelayedEmissionHandler2 onDelayedEmissionHandler2 = this.this$0;
        Throwable throwable = error.getThrowable();
        Intrinsics3.checkNotNullExpressionValue(throwable, "error.throwable");
        onDelayedEmissionHandler2.onError(throwable);
    }
}
