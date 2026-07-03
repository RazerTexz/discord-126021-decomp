package com.discord.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsVanityUrlBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17759a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextInputLayout f17760b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f17761c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17762d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f17763e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final RelativeLayout f17764f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final ProgressBar f17765g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f17766h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final TextView f17767i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final FloatingActionButton f17768j;

    public WidgetServerSettingsVanityUrlBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull RelativeLayout relativeLayout, @NonNull ProgressBar progressBar, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull FloatingActionButton floatingActionButton) {
        this.f17759a = coordinatorLayout;
        this.f17760b = textInputLayout;
        this.f17761c = textView;
        this.f17762d = textView2;
        this.f17763e = textView3;
        this.f17764f = relativeLayout;
        this.f17765g = progressBar;
        this.f17766h = textView4;
        this.f17767i = textView5;
        this.f17768j = floatingActionButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17759a;
    }
}
