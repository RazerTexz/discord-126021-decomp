package com.discord.widgets.servers.community;

import android.view.View;
import com.discord.databinding.WidgetEnableCommunityStepsBinding;
import com.discord.views.steps.StepsView;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEnableCommunitySteps$binding$2 extends C12236k implements Function1<View, WidgetEnableCommunityStepsBinding> {
    public static final WidgetServerSettingsEnableCommunitySteps$binding$2 INSTANCE = new WidgetServerSettingsEnableCommunitySteps$binding$2();

    public WidgetServerSettingsEnableCommunitySteps$binding$2() {
        super(1, WidgetEnableCommunityStepsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableCommunityStepsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetEnableCommunityStepsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        StepsView stepsView = (StepsView) view;
        return new WidgetEnableCommunityStepsBinding(stepsView, stepsView);
    }
}
