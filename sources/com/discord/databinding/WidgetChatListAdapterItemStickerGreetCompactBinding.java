package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.sticker.StickerView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemStickerGreetCompactBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final StickerView f2336b;

    @NonNull
    public final TextView c;

    @NonNull
    public final LinearLayout d;

    public WidgetChatListAdapterItemStickerGreetCompactBinding(@NonNull ConstraintLayout constraintLayout, @NonNull StickerView stickerView, @NonNull TextView textView, @NonNull LinearLayout linearLayout) {
        this.a = constraintLayout;
        this.f2336b = stickerView;
        this.c = textView;
        this.d = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
