package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import b.a.i.s1;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetThreadBrowserActiveBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final s1 f2668b;

    @NonNull
    public final RecyclerView c;

    public WidgetThreadBrowserActiveBinding(@NonNull ConstraintLayout constraintLayout, @NonNull s1 s1Var, @NonNull RecyclerView recyclerView) {
        this.a = constraintLayout;
        this.f2668b = s1Var;
        this.c = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
