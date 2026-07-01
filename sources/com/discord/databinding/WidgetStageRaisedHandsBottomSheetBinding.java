package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Group;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStageRaisedHandsBottomSheetBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialTextView f2657b;

    @NonNull
    public final Group c;

    @NonNull
    public final SwitchMaterial d;

    @NonNull
    public final MaxHeightRecyclerView e;

    @NonNull
    public final MaterialTextView f;

    @NonNull
    public final MaterialTextView g;

    @NonNull
    public final ImageView h;

    public WidgetStageRaisedHandsBottomSheetBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MaterialTextView materialTextView, @NonNull Group group, @NonNull ImageView imageView, @NonNull MaterialTextView materialTextView2, @NonNull MaterialTextView materialTextView3, @NonNull SwitchMaterial switchMaterial, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull MaxHeightRecyclerView maxHeightRecyclerView, @NonNull MaterialTextView materialTextView4, @NonNull MaterialTextView materialTextView5, @NonNull MaterialTextView materialTextView6, @NonNull Group group2, @NonNull ImageView imageView2) {
        this.a = coordinatorLayout;
        this.f2657b = materialTextView;
        this.c = group;
        this.d = switchMaterial;
        this.e = maxHeightRecyclerView;
        this.f = materialTextView4;
        this.g = materialTextView6;
        this.h = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
