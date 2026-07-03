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
public final class WidgetStageChannelAudienceBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f18132a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f18133b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CutoutView f18134c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f18135d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f18136e;

    public WidgetStageChannelAudienceBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull CutoutView cutoutView, @NonNull TextView textView, @NonNull ImageView imageView) {
        this.f18132a = constraintLayout;
        this.f18133b = simpleDraweeView;
        this.f18134c = cutoutView;
        this.f18135d = textView;
        this.f18136e = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18132a;
    }
}
