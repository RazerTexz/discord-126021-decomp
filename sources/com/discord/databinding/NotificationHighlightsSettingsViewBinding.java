package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationHighlightsSettingsViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15189a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15190b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CheckedSetting f15191c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialCardView f15192d;

    public NotificationHighlightsSettingsViewBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting, @NonNull MaterialCardView materialCardView) {
        this.f15189a = linearLayout;
        this.f15190b = textView;
        this.f15191c = checkedSetting;
        this.f15192d = materialCardView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15189a;
    }
}
