package com.discord.widgets.settings.premium;

import android.os.Bundle;
import android.os.Parcelable;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetClaimOutboundPromo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetClaimOutboundPromo$Companion$showAndRegisterForClaimResult$2 extends o implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ Function1 $onPromoClaimed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetClaimOutboundPromo$Companion$showAndRegisterForClaimResult$2(Function1 function1) {
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
        m.checkNotNullParameter(str, "requestKey");
        m.checkNotNullParameter(bundle, "bundle");
        if (m.areEqual("KEY_PROMO_CLAIMED", str)) {
            Function1 function1 = this.$onPromoClaimed;
            Parcelable parcelable = bundle.getParcelable("KEY_PROMO_CLAIMED");
            m.checkNotNull(parcelable);
            function1.invoke(parcelable);
        }
    }
}
