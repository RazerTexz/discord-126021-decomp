package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.checkbox.MaterialCheckBox;

/* JADX INFO: loaded from: classes.dex */
public final class ViewSelectableFriendSuggestionBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15546a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f15547b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ConstraintLayout f15548c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15549d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15550e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15551f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final MaterialCheckBox f15552g;

    public ViewSelectableFriendSuggestionBinding(@NonNull ConstraintLayout constraintLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull MaterialCheckBox materialCheckBox) {
        this.f15546a = constraintLayout;
        this.f15547b = simpleDraweeView;
        this.f15548c = constraintLayout2;
        this.f15549d = textView;
        this.f15550e = textView2;
        this.f15551f = textView3;
        this.f15552g = materialCheckBox;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15546a;
    }
}
