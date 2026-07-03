package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsAccountBackupCodesBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17780a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final DimmerView f17781b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f17782c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17783d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final RecyclerView f17784e;

    public WidgetSettingsAccountBackupCodesBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DimmerView dimmerView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull RecyclerView recyclerView) {
        this.f17780a = coordinatorLayout;
        this.f17781b = dimmerView;
        this.f17782c = materialButton;
        this.f17783d = textView;
        this.f17784e = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17780a;
    }
}
