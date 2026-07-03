package com.discord.widgets.channels;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelOnboardingBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelOnboarding$binding$2 extends C12236k implements Function1<View, WidgetChannelOnboardingBinding> {
    public static final WidgetChannelOnboarding$binding$2 INSTANCE = new WidgetChannelOnboarding$binding$2();

    public WidgetChannelOnboarding$binding$2() {
        super(1, WidgetChannelOnboardingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelOnboardingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelOnboardingBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.channel_actions_view);
        if (materialButton != null) {
            return new WidgetChannelOnboardingBinding((LinearLayout) view, materialButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.channel_actions_view)));
    }
}
