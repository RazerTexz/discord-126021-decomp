package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSelectComponentBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f17449a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17450b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaxHeightRecyclerView f17451c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17452d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f17453e;

    public WidgetSelectComponentBottomSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull MaxHeightRecyclerView maxHeightRecyclerView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f17449a = constraintLayout;
        this.f17450b = textView;
        this.f17451c = maxHeightRecyclerView;
        this.f17452d = textView2;
        this.f17453e = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17449a;
    }
}
