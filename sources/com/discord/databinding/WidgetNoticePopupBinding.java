package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetNoticePopupBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f2503b;

    @NonNull
    public final SimpleDraweeSpanTextView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final SimpleDraweeView e;

    @NonNull
    public final StickerView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    public WidgetNoticePopupBinding(@NonNull RelativeLayout relativeLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull ImageView imageView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull StickerView stickerView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout2) {
        this.a = relativeLayout;
        this.f2503b = simpleDraweeView;
        this.c = simpleDraweeSpanTextView;
        this.d = imageView;
        this.e = simpleDraweeView2;
        this.f = stickerView;
        this.g = textView;
        this.h = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
