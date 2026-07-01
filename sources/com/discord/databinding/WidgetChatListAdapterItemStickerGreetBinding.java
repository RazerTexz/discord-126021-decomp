package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.sticker.StickerView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemStickerGreetBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final StickerView f2335b;

    @NonNull
    public final MaterialButton c;

    public WidgetChatListAdapterItemStickerGreetBinding(@NonNull LinearLayout linearLayout, @NonNull StickerView stickerView, @NonNull MaterialButton materialButton) {
        this.a = linearLayout;
        this.f2335b = stickerView;
        this.c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
