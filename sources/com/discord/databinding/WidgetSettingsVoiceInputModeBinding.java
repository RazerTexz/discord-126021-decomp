package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsVoiceInputModeBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f18121a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinearLayout f18122b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinearLayout f18123c;

    public WidgetSettingsVoiceInputModeBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2) {
        this.f18121a = nestedScrollView;
        this.f18122b = linearLayout;
        this.f18123c = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18121a;
    }
}
