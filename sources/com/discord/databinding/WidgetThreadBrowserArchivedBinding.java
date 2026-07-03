package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import p007b.p008a.p025i.C1046s1;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetThreadBrowserArchivedBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f18267a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final C1046s1 f18268b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f18269c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ConstraintLayout f18270d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialButton f18271e;

    public WidgetThreadBrowserArchivedBinding(@NonNull ConstraintLayout constraintLayout, @NonNull C1046s1 c1046s1, @NonNull RecyclerView recyclerView, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2, @NonNull MaterialButton materialButton) {
        this.f18267a = constraintLayout;
        this.f18268b = c1046s1;
        this.f18269c = recyclerView;
        this.f18270d = constraintLayout2;
        this.f18271e = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18267a;
    }
}
