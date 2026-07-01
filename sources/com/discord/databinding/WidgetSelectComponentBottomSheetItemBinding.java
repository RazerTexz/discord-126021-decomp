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

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialTextView f2533b;

    @NonNull
    public final View c;

    @NonNull
    public final View d;

    @NonNull
    public final SimpleDraweeView e;

    @NonNull
    public final MaterialCheckBox f;

    @NonNull
    public final MaterialTextView g;

    public WidgetSelectComponentBottomSheetItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialTextView materialTextView, @NonNull View view, @NonNull View view2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialCheckBox materialCheckBox, @NonNull MaterialTextView materialTextView2) {
        this.a = constraintLayout;
        this.f2533b = materialTextView;
        this.c = view;
        this.d = view2;
        this.e = simpleDraweeView;
        this.f = materialCheckBox;
        this.g = materialTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
