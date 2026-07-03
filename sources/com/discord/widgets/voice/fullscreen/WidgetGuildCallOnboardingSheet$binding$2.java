package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildCallOnboardingBinding;
import com.discord.views.JoinVoiceChannelButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildCallOnboardingSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetGuildCallOnboardingSheet$binding$2 extends C12236k implements Function1<View, WidgetGuildCallOnboardingBinding> {
    public static final WidgetGuildCallOnboardingSheet$binding$2 INSTANCE = new WidgetGuildCallOnboardingSheet$binding$2();

    public WidgetGuildCallOnboardingSheet$binding$2() {
        super(1, WidgetGuildCallOnboardingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildCallOnboardingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildCallOnboardingBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        JoinVoiceChannelButton joinVoiceChannelButton = (JoinVoiceChannelButton) view.findViewById(C5419R.id.guild_call_onboarding_connect);
        if (joinVoiceChannelButton != null) {
            return new WidgetGuildCallOnboardingBinding((LinearLayout) view, joinVoiceChannelButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.guild_call_onboarding_connect)));
    }
}
