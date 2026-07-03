package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerNotificationOverrideSelectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17486a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f17487b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputLayout f17488c;

    public WidgetServerNotificationOverrideSelectorBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView, @NonNull TextInputLayout textInputLayout) {
        this.f17486a = coordinatorLayout;
        this.f17487b = recyclerView;
        this.f17488c = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17486a;
    }
}
