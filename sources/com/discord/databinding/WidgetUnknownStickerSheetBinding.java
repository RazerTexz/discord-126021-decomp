package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.sticker.StickerView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUnknownStickerSheetBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final StickerView f2677b;

    @NonNull
    public final TextView c;

    public WidgetUnknownStickerSheetBinding(@NonNull LinearLayout linearLayout, @NonNull StickerView stickerView, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f2677b = stickerView;
        this.c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
