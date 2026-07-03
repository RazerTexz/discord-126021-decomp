package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetCollapsedVoiceUserListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f16399a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16400b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f16401c;

    public WidgetCollapsedVoiceUserListItemBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView) {
        this.f16399a = frameLayout;
        this.f16400b = textView;
        this.f16401c = simpleDraweeView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16399a;
    }
}
