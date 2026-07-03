package com.discord.widgets.guild_role_subscriptions.setup;

import android.view.View;
import com.discord.databinding.WidgetGuildSubscriptionPlanSetupBinding;
import com.discord.views.steps.StepsView;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionPlanSetup$binding$2 extends C12236k implements Function1<View, WidgetGuildSubscriptionPlanSetupBinding> {
    public static final WidgetGuildRoleSubscriptionPlanSetup$binding$2 INSTANCE = new WidgetGuildRoleSubscriptionPlanSetup$binding$2();

    public WidgetGuildRoleSubscriptionPlanSetup$binding$2() {
        super(1, WidgetGuildSubscriptionPlanSetupBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildSubscriptionPlanSetupBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildSubscriptionPlanSetupBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        StepsView stepsView = (StepsView) view;
        return new WidgetGuildSubscriptionPlanSetupBinding(stepsView, stepsView);
    }
}
