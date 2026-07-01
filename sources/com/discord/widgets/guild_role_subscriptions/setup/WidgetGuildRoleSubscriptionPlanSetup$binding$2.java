package com.discord.widgets.guild_role_subscriptions.setup;

import android.view.View;
import com.discord.databinding.WidgetGuildSubscriptionPlanSetupBinding;
import com.discord.views.steps.StepsView;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionPlanSetup$binding$2 extends k implements Function1<View, WidgetGuildSubscriptionPlanSetupBinding> {
    public static final WidgetGuildRoleSubscriptionPlanSetup$binding$2 INSTANCE = new WidgetGuildRoleSubscriptionPlanSetup$binding$2();

    public WidgetGuildRoleSubscriptionPlanSetup$binding$2() {
        super(1, WidgetGuildSubscriptionPlanSetupBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildSubscriptionPlanSetupBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildSubscriptionPlanSetupBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildSubscriptionPlanSetupBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        StepsView stepsView = (StepsView) view;
        return new WidgetGuildSubscriptionPlanSetupBinding(stepsView, stepsView);
    }
}
