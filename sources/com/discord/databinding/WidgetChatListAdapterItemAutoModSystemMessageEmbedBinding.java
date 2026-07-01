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

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2311b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final SimpleDraweeSpanTextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public WidgetChatListAdapterItemAutoModSystemMessageEmbedBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.a = constraintLayout;
        this.f2311b = textView;
        this.c = simpleDraweeView;
        this.d = textView3;
        this.e = simpleDraweeSpanTextView;
        this.f = textView4;
        this.g = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
