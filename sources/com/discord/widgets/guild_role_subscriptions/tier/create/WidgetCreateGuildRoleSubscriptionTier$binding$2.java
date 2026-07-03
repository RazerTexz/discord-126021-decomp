package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.view.View;
import com.discord.databinding.WidgetCreateGuildRoleSubscriptionTierBinding;
import com.discord.views.steps.StepsView;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetCreateGuildRoleSubscriptionTier$binding$2 extends C12236k implements Function1<View, WidgetCreateGuildRoleSubscriptionTierBinding> {
    public static final WidgetCreateGuildRoleSubscriptionTier$binding$2 INSTANCE = new WidgetCreateGuildRoleSubscriptionTier$binding$2();

    public WidgetCreateGuildRoleSubscriptionTier$binding$2() {
        super(1, WidgetCreateGuildRoleSubscriptionTierBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCreateGuildRoleSubscriptionTierBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetCreateGuildRoleSubscriptionTierBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        StepsView stepsView = (StepsView) view;
        return new WidgetCreateGuildRoleSubscriptionTierBinding(stepsView, stepsView);
    }
}
