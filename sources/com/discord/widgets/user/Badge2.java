package com.discord.widgets.user;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import b.a.a.b.MultiValuePropPremiumUpsellDialog;
import b.a.d.AppToast;
import com.discord.R;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.user.Badge$Companion$onBadgeClick$1, reason: use source file name */
/* JADX INFO: compiled from: Badge.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Badge2 extends Lambda implements Function1<Badge, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ FragmentManager $fragmentManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Badge2(FragmentManager fragmentManager, Context context) {
        super(1);
        this.$fragmentManager = fragmentManager;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Badge badge) {
        invoke2(badge);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Badge badge) {
        Intrinsics3.checkNotNullParameter(badge, "badge");
        if (badge.getShowPremiumUpSell()) {
            MultiValuePropPremiumUpsellDialog.Companion.a(MultiValuePropPremiumUpsellDialog.INSTANCE, this.$fragmentManager, 5, this.$context.getString(R.string.premium_upsell_badge_active_mobile), null, null, "Profile Modal", "Badge", badge.getObjectType(), false, false, 792);
            return;
        }
        Context context = this.$context;
        CharSequence tooltip = badge.getTooltip();
        if (tooltip == null) {
            tooltip = badge.getText();
        }
        AppToast.h(context, tooltip, 0, null, 12);
    }
}
