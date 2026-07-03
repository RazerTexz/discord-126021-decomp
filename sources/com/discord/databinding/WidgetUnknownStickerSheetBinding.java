package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.sticker.StickerView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUnknownStickerSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f18312a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final StickerView f18313b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f18314c;

    public WidgetUnknownStickerSheetBinding(@NonNull LinearLayout linearLayout, @NonNull StickerView stickerView, @NonNull TextView textView) {
        this.f18312a = linearLayout;
        this.f18313b = stickerView;
        this.f18314c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18312a;
    }
}
