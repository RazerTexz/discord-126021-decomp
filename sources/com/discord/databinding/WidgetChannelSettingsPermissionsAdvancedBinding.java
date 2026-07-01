package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelSettingsPermissionsAdvancedBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2278b;

    @NonNull
    public final TextView c;

    @NonNull
    public final LinearLayout d;

    @NonNull
    public final RecyclerView e;

    @NonNull
    public final LinearLayout f;

    @NonNull
    public final RecyclerView g;

    public WidgetChannelSettingsPermissionsAdvancedBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout2, @NonNull RecyclerView recyclerView2) {
        this.a = coordinatorLayout;
        this.f2278b = textView;
        this.c = textView2;
        this.d = linearLayout;
        this.e = recyclerView;
        this.f = linearLayout2;
        this.g = recyclerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
