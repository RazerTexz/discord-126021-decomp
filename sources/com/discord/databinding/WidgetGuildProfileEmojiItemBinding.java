package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildProfileEmojiItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final SimpleDraweeView f16887a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f16888b;

    public WidgetGuildProfileEmojiItemBinding(@NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2) {
        this.f16887a = simpleDraweeView;
        this.f16888b = simpleDraweeView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16887a;
    }
}
