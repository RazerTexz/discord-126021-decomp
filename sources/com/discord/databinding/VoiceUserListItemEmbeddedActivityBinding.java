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

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f2219b;

    @NonNull
    public final TextView c;

    @NonNull
    public final ConstraintLayout d;

    @NonNull
    public final PileView e;

    public VoiceUserListItemEmbeddedActivityBinding(@NonNull FrameLayout frameLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout, @NonNull PileView pileView) {
        this.a = frameLayout;
        this.f2219b = simpleDraweeView;
        this.c = textView;
        this.d = constraintLayout;
        this.e = pileView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
