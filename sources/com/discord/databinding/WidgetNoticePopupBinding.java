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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17308a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f17309b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeSpanTextView f17310c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f17311d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeView f17312e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final StickerView f17313f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f17314g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f17315h;

    public WidgetNoticePopupBinding(@NonNull RelativeLayout relativeLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull ImageView imageView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull StickerView stickerView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout2) {
        this.f17308a = relativeLayout;
        this.f17309b = simpleDraweeView;
        this.f17310c = simpleDraweeSpanTextView;
        this.f17311d = imageView;
        this.f17312e = simpleDraweeView2;
        this.f17313f = stickerView;
        this.f17314g = textView;
        this.f17315h = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17308a;
    }
}
