package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentionsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f18333a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final Toolbar f18334b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f18335c;

    public WidgetUserMentionsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar toolbar, @NonNull RecyclerView recyclerView) {
        this.f18333a = coordinatorLayout;
        this.f18334b = toolbar;
        this.f18335c = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18333a;
    }
}
