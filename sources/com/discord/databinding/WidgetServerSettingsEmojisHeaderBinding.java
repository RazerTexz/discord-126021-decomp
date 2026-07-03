package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsEmojisHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17643a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f17644b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f17645c;

    public WidgetServerSettingsEmojisHeaderBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView) {
        this.f17643a = linearLayout;
        this.f17644b = materialButton;
        this.f17645c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17643a;
    }
}
