package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: loaded from: classes.dex */
public final class StageAudienceBlockedBottomSheetHeaderItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15242a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialTextView f15243b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialTextView f15244c;

    public StageAudienceBlockedBottomSheetHeaderItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialTextView materialTextView, @NonNull MaterialTextView materialTextView2) {
        this.f15242a = constraintLayout;
        this.f15243b = materialTextView;
        this.f15244c = materialTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15242a;
    }
}
