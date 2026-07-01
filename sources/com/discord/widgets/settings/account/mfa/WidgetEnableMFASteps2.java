package com.discord.widgets.settings.account.mfa;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.R;
import com.discord.databinding.WidgetEnableMfaStepsBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.steps.StepsView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableMFASteps2 extends FunctionReferenceImpl implements Function1<View, WidgetEnableMfaStepsBinding> {
    public static final WidgetEnableMFASteps2 INSTANCE = new WidgetEnableMFASteps2();

    public WidgetEnableMFASteps2() {
        super(1, WidgetEnableMfaStepsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableMfaStepsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetEnableMfaStepsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
        if (dimmerView != null) {
            i = R.id.enable_mfa_stepsview;
            StepsView stepsView = (StepsView) view.findViewById(R.id.enable_mfa_stepsview);
            if (stepsView != null) {
                return new WidgetEnableMfaStepsBinding((FrameLayout) view, dimmerView, stepsView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
