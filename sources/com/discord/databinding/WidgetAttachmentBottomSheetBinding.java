package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetAttachmentBottomSheetBinding implements ViewBinding {

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialTextView f2227b;

    @NonNull
    public final AppCompatTextView c;

    @NonNull
    public final AppCompatCheckedTextView d;

    @NonNull
    public final MaterialCheckBox e;

    @NonNull
    public final SimpleDraweeView f;

    @NonNull
    public final AppCompatTextView g;

    @NonNull
    public final FrameLayout h;

    public WidgetAttachmentBottomSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull MaterialTextView materialTextView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatCheckedTextView appCompatCheckedTextView, @NonNull MaterialCheckBox materialCheckBox, @NonNull SimpleDraweeView simpleDraweeView, @NonNull AppCompatTextView appCompatTextView2, @NonNull FrameLayout frameLayout, @NonNull View view, @NonNull ConstraintLayout constraintLayout) {
        this.a = nestedScrollView;
        this.f2227b = materialTextView;
        this.c = appCompatTextView;
        this.d = appCompatCheckedTextView;
        this.e = materialCheckBox;
        this.f = simpleDraweeView;
        this.g = appCompatTextView2;
        this.h = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
