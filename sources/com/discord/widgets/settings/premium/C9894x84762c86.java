package com.discord.widgets.settings.premium;

import android.os.Bundle;
import android.os.Parcelable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetClaimOutboundPromo$Companion$showAndRegisterForClaimResult$2 */
/* JADX INFO: compiled from: WidgetClaimOutboundPromo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9894x84762c86 extends AbstractC12240o implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ Function1 $onPromoClaimed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9894x84762c86(Function1 function1) {
        super(2);
        this.$onPromoClaimed = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
        invoke2(str, bundle);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Bundle bundle) {
        C12238m.checkNotNullParameter(str, "requestKey");
        C12238m.checkNotNullParameter(bundle, "bundle");
        if (C12238m.areEqual("KEY_PROMO_CLAIMED", str)) {
            Function1 function1 = this.$onPromoClaimed;
            Parcelable parcelable = bundle.getParcelable("KEY_PROMO_CLAIMED");
            C12238m.checkNotNull(parcelable);
            function1.invoke(parcelable);
        }
    }
}
