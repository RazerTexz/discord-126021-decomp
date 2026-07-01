package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.JoinVoiceChannelButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCallOnboardingBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final JoinVoiceChannelButton f2409b;

    public WidgetGuildCallOnboardingBinding(@NonNull LinearLayout linearLayout, @NonNull JoinVoiceChannelButton joinVoiceChannelButton) {
        this.a = linearLayout;
        this.f2409b = joinVoiceChannelButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
