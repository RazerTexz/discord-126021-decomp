package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsSecurityBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17752a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17753b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f17754c;

    public WidgetServerSettingsSecurityBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull MaterialButton materialButton) {
        this.f17752a = coordinatorLayout;
        this.f17753b = textView;
        this.f17754c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17752a;
    }
}
