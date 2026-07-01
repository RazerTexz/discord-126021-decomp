package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.widgets.chat.list.ViewReplySpline;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemThreadEmbedBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f2341b;

    @NonNull
    public final View c;

    @NonNull
    public final ConstraintLayout d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final SimpleDraweeView h;

    @NonNull
    public final SimpleDraweeSpanTextView i;

    @NonNull
    public final ConstraintLayout j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    public WidgetChatListAdapterItemThreadEmbedBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull View view2, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView, @NonNull View view3, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull ConstraintLayout constraintLayout3, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ConstraintLayout constraintLayout4, @NonNull ViewReplySpline viewReplySpline, @NonNull Guideline guideline) {
        this.a = constraintLayout;
        this.f2341b = view;
        this.c = view2;
        this.d = constraintLayout2;
        this.e = imageView;
        this.f = textView;
        this.g = imageView2;
        this.h = simpleDraweeView;
        this.i = simpleDraweeSpanTextView;
        this.j = constraintLayout3;
        this.k = textView2;
        this.l = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
