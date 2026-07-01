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

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2130b;

    @NonNull
    public final CheckedSetting c;

    @NonNull
    public final MaterialCardView d;

    public NotificationHighlightsSettingsViewBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting, @NonNull MaterialCardView materialCardView) {
        this.a = linearLayout;
        this.f2130b = textView;
        this.c = checkedSetting;
        this.d = materialCardView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
