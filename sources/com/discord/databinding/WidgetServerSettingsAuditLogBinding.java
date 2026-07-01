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

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2539b;

    @NonNull
    public final RecyclerView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final AppViewFlipper e;

    @NonNull
    public final AppViewFlipper f;

    public WidgetServerSettingsAuditLogBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull TextView textView4, @NonNull LinearLayout linearLayout2, @NonNull AppViewFlipper appViewFlipper, @NonNull AppViewFlipper appViewFlipper2) {
        this.a = coordinatorLayout;
        this.f2539b = textView3;
        this.c = recyclerView;
        this.d = textView4;
        this.e = appViewFlipper;
        this.f = appViewFlipper2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
