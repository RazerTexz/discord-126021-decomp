package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemSystemBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f2337b;

    @NonNull
    public final ConstraintLayout c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final LinkifiedTextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final LinearLayout j;

    @NonNull
    public final StickerView k;

    public WidgetChatListAdapterItemSystemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull View view, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull StickerView stickerView, @NonNull Guideline guideline) {
        this.a = constraintLayout;
        this.f2337b = appCompatImageView;
        this.c = constraintLayout2;
        this.d = simpleDraweeView;
        this.e = textView2;
        this.f = imageView;
        this.g = imageView2;
        this.h = linkifiedTextView;
        this.i = textView3;
        this.j = linearLayout;
        this.k = stickerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
