package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.PileView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class VoiceUserListItemEmbeddedActivityBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15614a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f15615b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15616c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ConstraintLayout f15617d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final PileView f15618e;

    public VoiceUserListItemEmbeddedActivityBinding(@NonNull FrameLayout frameLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout, @NonNull PileView pileView) {
        this.f15614a = frameLayout;
        this.f15615b = simpleDraweeView;
        this.f15616c = textView;
        this.f15617d = constraintLayout;
        this.f15618e = pileView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15614a;
    }
}
