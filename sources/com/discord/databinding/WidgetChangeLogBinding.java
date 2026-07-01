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

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinkifiedTextView f2253b;

    @NonNull
    public final AppCompatImageButton c;

    @NonNull
    public final AppCompatImageButton d;

    @NonNull
    public final NestedScrollView e;

    @NonNull
    public final SimpleDraweeView f;

    @NonNull
    public final AppCompatImageButton g;

    @NonNull
    public final VideoView h;

    @NonNull
    public final SimpleDraweeView i;

    public WidgetChangeLogBinding(@NonNull LinearLayout linearLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LinearLayout linearLayout2, @NonNull AppCompatImageButton appCompatImageButton, @NonNull AppCompatImageButton appCompatImageButton2, @NonNull NestedScrollView nestedScrollView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull AppCompatImageButton appCompatImageButton3, @NonNull VideoView videoView, @NonNull SimpleDraweeView simpleDraweeView2) {
        this.a = linearLayout;
        this.f2253b = linkifiedTextView;
        this.c = appCompatImageButton;
        this.d = appCompatImageButton2;
        this.e = nestedScrollView;
        this.f = simpleDraweeView;
        this.g = appCompatImageButton3;
        this.h = videoView;
        this.i = simpleDraweeView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
