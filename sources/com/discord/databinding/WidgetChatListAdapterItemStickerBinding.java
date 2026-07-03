package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.sticker.StickerView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemStickerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f16297a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final StickerView f16298b;

    public WidgetChatListAdapterItemStickerBinding(@NonNull FrameLayout frameLayout, @NonNull StickerView stickerView) {
        this.f16297a = frameLayout;
        this.f16298b = stickerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16297a;
    }
}
