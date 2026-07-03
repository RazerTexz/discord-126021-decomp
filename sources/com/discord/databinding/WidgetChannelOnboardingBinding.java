package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelOnboardingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15881a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f15882b;

    public WidgetChannelOnboardingBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton) {
        this.f15881a = linearLayout;
        this.f15882b = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15881a;
    }
}
