package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildFolderSettingsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f16774a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextInputLayout f16775b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16776c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final RelativeLayout f16777d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final View f16778e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final FloatingActionButton f16779f;

    public WidgetGuildFolderSettingsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout, @NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
        this.f16774a = coordinatorLayout;
        this.f16775b = textInputLayout;
        this.f16776c = textView;
        this.f16777d = relativeLayout;
        this.f16778e = view;
        this.f16779f = floatingActionButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16774a;
    }
}
