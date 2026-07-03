package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemApplicationCommandBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16138a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16139b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CardView f16140c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final FrameLayout f16141d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16142e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f16143f;

    public WidgetChatListAdapterItemApplicationCommandBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull CardView cardView, @NonNull FrameLayout frameLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull Guideline guideline) {
        this.f16138a = constraintLayout;
        this.f16139b = textView;
        this.f16140c = cardView;
        this.f16141d = frameLayout;
        this.f16142e = textView2;
        this.f16143f = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16138a;
    }
}
