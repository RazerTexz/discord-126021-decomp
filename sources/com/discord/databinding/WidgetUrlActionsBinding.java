package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUrlActionsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f18315a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f18316b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f18317c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f18318d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f18319e;

    public WidgetUrlActionsBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f18315a = linearLayout;
        this.f18316b = textView;
        this.f18317c = textView2;
        this.f18318d = textView3;
        this.f18319e = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18315a;
    }
}
