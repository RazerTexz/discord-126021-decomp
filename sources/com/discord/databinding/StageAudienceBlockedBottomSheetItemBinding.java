package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CutoutView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class StageAudienceBlockedBottomSheetItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15245a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f15246b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CutoutView f15247c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15248d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f15249e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15250f;

    public StageAudienceBlockedBottomSheetItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull CutoutView cutoutView, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull View view, @NonNull TextView textView3) {
        this.f15245a = constraintLayout;
        this.f15246b = simpleDraweeView;
        this.f15247c = cutoutView;
        this.f15248d = textView;
        this.f15249e = imageView;
        this.f15250f = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15245a;
    }
}
