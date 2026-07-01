package com.discord.widgets.servers.community;

import android.view.View;
import com.discord.databinding.WidgetEnableCommunityStepsBinding;
import com.discord.views.steps.StepsView;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEnableCommunitySteps$binding$2 extends k implements Function1<View, WidgetEnableCommunityStepsBinding> {
    public static final WidgetServerSettingsEnableCommunitySteps$binding$2 INSTANCE = new WidgetServerSettingsEnableCommunitySteps$binding$2();

    public WidgetServerSettingsEnableCommunitySteps$binding$2() {
        super(1, WidgetEnableCommunityStepsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableCommunityStepsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetEnableCommunityStepsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetEnableCommunityStepsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        StepsView stepsView = (StepsView) view;
        return new WidgetEnableCommunityStepsBinding(stepsView, stepsView);
    }
}
