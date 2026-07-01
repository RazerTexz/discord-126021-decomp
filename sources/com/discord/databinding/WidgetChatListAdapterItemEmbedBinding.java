package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.chat.list.InlineMediaView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemEmbedBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f2315b;

    @NonNull
    public final View c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final MaterialCardView f;

    @NonNull
    public final ConstraintLayout g;

    @NonNull
    public final LinkifiedTextView h;

    @NonNull
    public final View i;

    @NonNull
    public final LinearLayout j;

    @NonNull
    public final SimpleDraweeView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final SimpleDraweeView m;

    @NonNull
    public final ImageView n;

    @NonNull
    public final SimpleDraweeView o;

    @NonNull
    public final TextView p;

    @NonNull
    public final FrameLayout q;

    @NonNull
    public final LinkifiedTextView r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final CardView f2316s;

    @NonNull
    public final InlineMediaView t;

    public WidgetChatListAdapterItemEmbedBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull View view2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull Barrier barrier, @NonNull Barrier barrier2, @NonNull MaterialCardView materialCardView, @NonNull ConstraintLayout constraintLayout2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull View view3, @NonNull LinearLayout linearLayout, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView3, @NonNull ImageView imageView, @NonNull SimpleDraweeView simpleDraweeView4, @NonNull TextView textView3, @NonNull FrameLayout frameLayout, @NonNull LinkifiedTextView linkifiedTextView2, @NonNull CardView cardView, @NonNull InlineMediaView inlineMediaView) {
        this.a = constraintLayout;
        this.f2315b = view;
        this.c = view2;
        this.d = simpleDraweeView;
        this.e = textView;
        this.f = materialCardView;
        this.g = constraintLayout2;
        this.h = linkifiedTextView;
        this.i = view3;
        this.j = linearLayout;
        this.k = simpleDraweeView2;
        this.l = textView2;
        this.m = simpleDraweeView3;
        this.n = imageView;
        this.o = simpleDraweeView4;
        this.p = textView3;
        this.q = frameLayout;
        this.r = linkifiedTextView2;
        this.f2316s = cardView;
        this.t = inlineMediaView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
