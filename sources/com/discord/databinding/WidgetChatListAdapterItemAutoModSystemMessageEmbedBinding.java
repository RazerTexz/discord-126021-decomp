package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16160a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16161b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f16162c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16163d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeSpanTextView f16164e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f16165f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f16166g;

    public WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.f16160a = constraintLayout;
        this.f16161b = textView;
        this.f16162c = simpleDraweeView;
        this.f16163d = textView3;
        this.f16164e = simpleDraweeSpanTextView;
        this.f16165f = textView4;
        this.f16166g = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16160a;
    }
}
