package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetForumGuidelinesBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f16640a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16641b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f16642c;

    public WidgetForumGuidelinesBottomSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull CardView cardView, @NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f16640a = nestedScrollView;
        this.f16641b = textView;
        this.f16642c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16640a;
    }
}
