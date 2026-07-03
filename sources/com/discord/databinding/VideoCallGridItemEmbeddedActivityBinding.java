package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.PileView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class VideoCallGridItemEmbeddedActivityBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15360a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final PileView f15361b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15362c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f15363d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final View f15364e;

    public VideoCallGridItemEmbeddedActivityBinding(@NonNull FrameLayout frameLayout, @NonNull PileView pileView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull View view) {
        this.f15360a = frameLayout;
        this.f15361b = pileView;
        this.f15362c = textView2;
        this.f15363d = simpleDraweeView;
        this.f15364e = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15360a;
    }
}
