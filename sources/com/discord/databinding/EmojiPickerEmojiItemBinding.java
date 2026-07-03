package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiPickerEmojiItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final SimpleDraweeView f15056a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f15057b;

    public EmojiPickerEmojiItemBinding(@NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2) {
        this.f15056a = simpleDraweeView;
        this.f15057b = simpleDraweeView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15056a;
    }
}
