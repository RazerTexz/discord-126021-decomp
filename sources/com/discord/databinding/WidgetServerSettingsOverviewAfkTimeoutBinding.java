package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsOverviewAfkTimeoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f17724a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17725b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f17726c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17727d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f17728e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f17729f;

    public WidgetServerSettingsOverviewAfkTimeoutBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6) {
        this.f17724a = nestedScrollView;
        this.f17725b = textView2;
        this.f17726c = textView3;
        this.f17727d = textView4;
        this.f17728e = textView5;
        this.f17729f = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17724a;
    }
}
