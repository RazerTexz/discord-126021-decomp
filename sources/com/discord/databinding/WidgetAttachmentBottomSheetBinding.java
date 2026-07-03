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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f15657a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialTextView f15658b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final AppCompatTextView f15659c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final AppCompatCheckedTextView f15660d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialCheckBox f15661e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final SimpleDraweeView f15662f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final AppCompatTextView f15663g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final FrameLayout f15664h;

    public WidgetAttachmentBottomSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull MaterialTextView materialTextView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatCheckedTextView appCompatCheckedTextView, @NonNull MaterialCheckBox materialCheckBox, @NonNull SimpleDraweeView simpleDraweeView, @NonNull AppCompatTextView appCompatTextView2, @NonNull FrameLayout frameLayout, @NonNull View view, @NonNull ConstraintLayout constraintLayout) {
        this.f15657a = nestedScrollView;
        this.f15658b = materialTextView;
        this.f15659c = appCompatTextView;
        this.f15660d = appCompatCheckedTextView;
        this.f15661e = materialCheckBox;
        this.f15662f = simpleDraweeView;
        this.f15663g = appCompatTextView2;
        this.f15664h = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15657a;
    }
}
