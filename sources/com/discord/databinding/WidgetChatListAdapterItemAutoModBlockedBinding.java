package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemAutoModBlockedBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16154a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f16155b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinkifiedTextView f16156c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeSpanTextView f16157d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16158e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f16159f;

    public WidgetChatListAdapterItemAutoModBlockedBinding(@NonNull ConstraintLayout constraintLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull ImageView imageView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull ImageView imageView2, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ConstraintLayout constraintLayout3, @NonNull ConstraintLayout constraintLayout4, @NonNull TextView textView3) {
        this.f16154a = constraintLayout;
        this.f16155b = simpleDraweeView;
        this.f16156c = linkifiedTextView;
        this.f16157d = simpleDraweeSpanTextView;
        this.f16158e = textView;
        this.f16159f = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16154a;
    }
}
