package com.discord.widgets.settings.premium;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetClaimOutboundPromo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetClaimOutboundPromo$Companion {
    private WidgetClaimOutboundPromo$Companion() {
    }

    public final void showAndRegisterForClaimResult(ClaimStatus claimStatus, Fragment fragment, Function1<? super ClaimStatus$Claimed, Unit> onPromoClaimed) {
        m.checkNotNullParameter(claimStatus, "claimStatus");
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(onPromoClaimed, "onPromoClaimed");
        if (fragment.getParentFragmentManager().findFragmentByTag("javaClass") != null) {
            return;
        }
        if (claimStatus instanceof ClaimStatus$Unclaimed) {
            FragmentKt.setFragmentResultListener(fragment, "KEY_PROMO_CLAIMED", new WidgetClaimOutboundPromo$Companion$showAndRegisterForClaimResult$2(onPromoClaimed));
        }
        WidgetClaimOutboundPromo widgetClaimOutboundPromo = new WidgetClaimOutboundPromo();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_CLAIM_STATUS", claimStatus);
        widgetClaimOutboundPromo.setArguments(bundle);
        FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
        widgetClaimOutboundPromo.show(parentFragmentManager, "javaClass");
    }

    public /* synthetic */ WidgetClaimOutboundPromo$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
