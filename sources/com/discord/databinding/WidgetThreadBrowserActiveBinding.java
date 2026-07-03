package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import p007b.p008a.p025i.C1046s1;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetThreadBrowserActiveBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f18264a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final C1046s1 f18265b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f18266c;

    public WidgetThreadBrowserActiveBinding(@NonNull ConstraintLayout constraintLayout, @NonNull C1046s1 c1046s1, @NonNull RecyclerView recyclerView) {
        this.f18264a = constraintLayout;
        this.f18265b = c1046s1;
        this.f18266c = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18264a;
    }
}
