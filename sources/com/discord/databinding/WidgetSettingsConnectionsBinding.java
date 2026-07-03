package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsConnectionsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17932a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17933b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f17934c;

    public WidgetSettingsConnectionsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull RecyclerView recyclerView) {
        this.f17932a = coordinatorLayout;
        this.f17933b = textView;
        this.f17934c = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17932a;
    }
}
