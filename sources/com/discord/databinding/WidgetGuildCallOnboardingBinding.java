package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.JoinVoiceChannelButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCallOnboardingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16749a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final JoinVoiceChannelButton f16750b;

    public WidgetGuildCallOnboardingBinding(@NonNull LinearLayout linearLayout, @NonNull JoinVoiceChannelButton joinVoiceChannelButton) {
        this.f16749a = linearLayout;
        this.f16750b = joinVoiceChannelButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16749a;
    }
}
