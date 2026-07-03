package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSelectComponentBottomSheetItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f17454a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialTextView f17455b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final View f17456c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final View f17457d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeView f17458e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialCheckBox f17459f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final MaterialTextView f17460g;

    public WidgetSelectComponentBottomSheetItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialTextView materialTextView, @NonNull View view, @NonNull View view2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialCheckBox materialCheckBox, @NonNull MaterialTextView materialTextView2) {
        this.f17454a = constraintLayout;
        this.f17455b = materialTextView;
        this.f17456c = view;
        this.f17457d = view2;
        this.f17458e = simpleDraweeView;
        this.f17459f = materialCheckBox;
        this.f17460g = materialTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17454a;
    }
}
