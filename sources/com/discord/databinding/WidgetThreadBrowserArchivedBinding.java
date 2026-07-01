package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import b.a.i.ThreadBrowserEmptyBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetThreadBrowserArchivedBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ThreadBrowserEmptyBinding f2669b;

    @NonNull
    public final RecyclerView c;

    @NonNull
    public final ConstraintLayout d;

    @NonNull
    public final MaterialButton e;

    public WidgetThreadBrowserArchivedBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ThreadBrowserEmptyBinding threadBrowserEmptyBinding, @NonNull RecyclerView recyclerView, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2, @NonNull MaterialButton materialButton) {
        this.a = constraintLayout;
        this.f2669b = threadBrowserEmptyBinding;
        this.c = recyclerView;
        this.d = constraintLayout2;
        this.e = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
