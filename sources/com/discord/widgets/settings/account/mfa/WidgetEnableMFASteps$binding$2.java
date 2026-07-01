package com.discord.widgets.settings.account.mfa;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetEnableMfaStepsBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.steps.StepsView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableMFASteps$binding$2 extends k implements Function1<View, WidgetEnableMfaStepsBinding> {
    public static final WidgetEnableMFASteps$binding$2 INSTANCE = new WidgetEnableMFASteps$binding$2();

    public WidgetEnableMFASteps$binding$2() {
        super(1, WidgetEnableMfaStepsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableMfaStepsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetEnableMfaStepsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetEnableMfaStepsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131363051;
        DimmerView dimmerView = (DimmerView) view.findViewById(2131363051);
        if (dimmerView != null) {
            i = R$id.enable_mfa_stepsview;
            StepsView stepsView = (StepsView) view.findViewById(R$id.enable_mfa_stepsview);
            if (stepsView != null) {
                return new WidgetEnableMfaStepsBinding((FrameLayout) view, dimmerView, stepsView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
