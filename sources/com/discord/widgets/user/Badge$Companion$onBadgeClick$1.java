package com.discord.widgets.user;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import b.a.a.b.c;
import b.a.a.b.c$b;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Badge.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Badge$Companion$onBadgeClick$1 extends o implements Function1<Badge, Unit> {
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
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Badge badge) {
        m.checkNotNullParameter(badge, "badge");
        if (badge.getShowPremiumUpSell()) {
            c$b.a(c.k, this.$fragmentManager, 5, this.$context.getString(2131894493), null, null, "Profile Modal", "Badge", badge.getObjectType(), false, false, 792);
            return;
        }
        Context context = this.$context;
        CharSequence tooltip = badge.getTooltip();
        if (tooltip == null) {
            tooltip = badge.getText();
        }
        b.a.d.m.h(context, tooltip, 0, null, 12);
    }
}
