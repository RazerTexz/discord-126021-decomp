package com.discord.widgets.user;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.p012b.C0811c;
import p007b.p008a.p018d.C0876m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Badge.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Badge$Companion$onBadgeClick$1 extends AbstractC12240o implements Function1<Badge, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ FragmentManager $fragmentManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Badge$Companion$onBadgeClick$1(FragmentManager fragmentManager, Context context) {
        super(1);
        this.$fragmentManager = fragmentManager;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Badge badge) {
        invoke2(badge);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Badge badge) {
        C12238m.checkNotNullParameter(badge, "badge");
        if (badge.getShowPremiumUpSell()) {
            C0811c.Companion.m114a(C0811c.INSTANCE, this.$fragmentManager, 5, this.$context.getString(C5419R.string.premium_upsell_badge_active_mobile), null, null, "Profile Modal", "Badge", badge.getObjectType(), false, false, 792);
            return;
        }
        Context context = this.$context;
        CharSequence tooltip = badge.getTooltip();
        if (tooltip == null) {
            tooltip = badge.getText();
        }
        C0876m.m170h(context, tooltip, 0, null, 12);
    }
}
