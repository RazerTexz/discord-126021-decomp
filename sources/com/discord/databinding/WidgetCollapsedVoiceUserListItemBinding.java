package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetCollapsedVoiceUserListItemBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2352b;

    @NonNull
    public final SimpleDraweeView c;

    public WidgetCollapsedVoiceUserListItemBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView) {
        this.a = frameLayout;
        this.f2352b = textView;
        this.c = simpleDraweeView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
