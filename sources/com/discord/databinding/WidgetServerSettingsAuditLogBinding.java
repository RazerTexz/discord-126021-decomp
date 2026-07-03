package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsAuditLogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17506a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17507b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f17508c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17509d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final AppViewFlipper f17510e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final AppViewFlipper f17511f;

    public WidgetServerSettingsAuditLogBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull TextView textView4, @NonNull LinearLayout linearLayout2, @NonNull AppViewFlipper appViewFlipper, @NonNull AppViewFlipper appViewFlipper2) {
        this.f17506a = coordinatorLayout;
        this.f17507b = textView3;
        this.f17508c = recyclerView;
        this.f17509d = textView4;
        this.f17510e = appViewFlipper;
        this.f17511f = appViewFlipper2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17506a;
    }
}
