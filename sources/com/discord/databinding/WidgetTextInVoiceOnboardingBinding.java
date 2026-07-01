package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetTextInVoiceOnboardingBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2666b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final VideoView d;

    @NonNull
    public final FrameLayout e;

    @NonNull
    public final SimpleDraweeView f;

    @NonNull
    public final ImageView g;

    public WidgetTextInVoiceOnboardingBinding(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull VideoView videoView, @NonNull FrameLayout frameLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ImageView imageView) {
        this.a = constraintLayout;
        this.f2666b = materialButton;
        this.c = materialButton2;
        this.d = videoView;
        this.e = frameLayout;
        this.f = simpleDraweeView;
        this.g = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
