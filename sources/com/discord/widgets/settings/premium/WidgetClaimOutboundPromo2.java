package com.discord.widgets.settings.premium;

import android.os.Bundle;
import android.os.Parcelable;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$Companion$showAndRegisterForClaimResult$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetClaimOutboundPromo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetClaimOutboundPromo2 extends Lambda implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ Function1 $onPromoClaimed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetClaimOutboundPromo2(Function1 function1) {
        super(2);
        this.$onPromoClaimed = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
        invoke2(str, bundle);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Bundle bundle) {
        Intrinsics3.checkNotNullParameter(str, "requestKey");
        Intrinsics3.checkNotNullParameter(bundle, "bundle");
        if (Intrinsics3.areEqual("KEY_PROMO_CLAIMED", str)) {
            Function1 function1 = this.$onPromoClaimed;
            Parcelable parcelable = bundle.getParcelable("KEY_PROMO_CLAIMED");
            Intrinsics3.checkNotNull(parcelable);
            function1.invoke(parcelable);
        }
    }
}
