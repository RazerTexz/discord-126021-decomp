package com.discord.widgets.servers.community;

import android.view.View;
import com.discord.databinding.WidgetEnableCommunityStepsBinding;
import com.discord.views.steps.StepsView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEnableCommunitySteps2 extends FunctionReferenceImpl implements Function1<View, WidgetEnableCommunityStepsBinding> {
    public static final WidgetServerSettingsEnableCommunitySteps2 INSTANCE = new WidgetServerSettingsEnableCommunitySteps2();

    public WidgetServerSettingsEnableCommunitySteps2() {
        super(1, WidgetEnableCommunityStepsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableCommunityStepsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetEnableCommunityStepsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        StepsView stepsView = (StepsView) view;
        return new WidgetEnableCommunityStepsBinding(stepsView, stepsView);
    }
}
