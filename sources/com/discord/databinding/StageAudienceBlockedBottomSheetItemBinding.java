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

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f2145b;

    @NonNull
    public final CutoutView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final TextView f;

    public StageAudienceBlockedBottomSheetItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull CutoutView cutoutView, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull View view, @NonNull TextView textView3) {
        this.a = constraintLayout;
        this.f2145b = simpleDraweeView;
        this.c = cutoutView;
        this.d = textView;
        this.e = imageView;
        this.f = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
