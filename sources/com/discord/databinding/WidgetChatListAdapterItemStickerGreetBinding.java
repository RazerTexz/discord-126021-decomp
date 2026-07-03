package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.sticker.StickerView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemStickerGreetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16299a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final StickerView f16300b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f16301c;

    public WidgetChatListAdapterItemStickerGreetBinding(@NonNull LinearLayout linearLayout, @NonNull StickerView stickerView, @NonNull MaterialButton materialButton) {
        this.f16299a = linearLayout;
        this.f16300b = stickerView;
        this.f16301c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16299a;
    }
}
