package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStageAudienceBlockedBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f18124a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f18125b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaxHeightRecyclerView f18126c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f18127d;

    public WidgetStageAudienceBlockedBottomSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull MaxHeightRecyclerView maxHeightRecyclerView, @NonNull MaterialButton materialButton2) {
        this.f18124a = constraintLayout;
        this.f18125b = materialButton;
        this.f18126c = maxHeightRecyclerView;
        this.f18127d = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18124a;
    }
}
