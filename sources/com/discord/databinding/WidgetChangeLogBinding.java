package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChangeLogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15811a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinkifiedTextView f15812b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final AppCompatImageButton f15813c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final AppCompatImageButton f15814d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final NestedScrollView f15815e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final SimpleDraweeView f15816f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final AppCompatImageButton f15817g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final VideoView f15818h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final SimpleDraweeView f15819i;

    public WidgetChangeLogBinding(@NonNull LinearLayout linearLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LinearLayout linearLayout2, @NonNull AppCompatImageButton appCompatImageButton, @NonNull AppCompatImageButton appCompatImageButton2, @NonNull NestedScrollView nestedScrollView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull AppCompatImageButton appCompatImageButton3, @NonNull VideoView videoView, @NonNull SimpleDraweeView simpleDraweeView2) {
        this.f15811a = linearLayout;
        this.f15812b = linkifiedTextView;
        this.f15813c = appCompatImageButton;
        this.f15814d = appCompatImageButton2;
        this.f15815e = nestedScrollView;
        this.f15816f = simpleDraweeView;
        this.f15817g = appCompatImageButton3;
        this.f15818h = videoView;
        this.f15819i = simpleDraweeView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15811a;
    }
}
