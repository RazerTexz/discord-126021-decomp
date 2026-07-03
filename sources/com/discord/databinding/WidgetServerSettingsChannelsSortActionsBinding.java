package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsChannelsSortActionsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f17569a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17570b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f17571c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17572d;

    public WidgetServerSettingsChannelsSortActionsBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f17569a = nestedScrollView;
        this.f17570b = textView2;
        this.f17571c = textView3;
        this.f17572d = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17569a;
    }
}
