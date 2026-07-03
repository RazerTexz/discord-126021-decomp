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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16180a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final View f16181b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final View f16182c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f16183d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16184e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialCardView f16185f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final ConstraintLayout f16186g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final LinkifiedTextView f16187h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final View f16188i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final LinearLayout f16189j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final SimpleDraweeView f16190k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final TextView f16191l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final SimpleDraweeView f16192m;

    /* JADX INFO: renamed from: n */
    @NonNull
    public final ImageView f16193n;

    /* JADX INFO: renamed from: o */
    @NonNull
    public final SimpleDraweeView f16194o;

    /* JADX INFO: renamed from: p */
    @NonNull
    public final TextView f16195p;

    /* JADX INFO: renamed from: q */
    @NonNull
    public final FrameLayout f16196q;

    /* JADX INFO: renamed from: r */
    @NonNull
    public final LinkifiedTextView f16197r;

    /* JADX INFO: renamed from: s */
    @NonNull
    public final CardView f16198s;

    /* JADX INFO: renamed from: t */
    @NonNull
    public final InlineMediaView f16199t;

    public WidgetChatListAdapterItemEmbedBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull View view2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull Barrier barrier, @NonNull Barrier barrier2, @NonNull MaterialCardView materialCardView, @NonNull ConstraintLayout constraintLayout2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull View view3, @NonNull LinearLayout linearLayout, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView3, @NonNull ImageView imageView, @NonNull SimpleDraweeView simpleDraweeView4, @NonNull TextView textView3, @NonNull FrameLayout frameLayout, @NonNull LinkifiedTextView linkifiedTextView2, @NonNull CardView cardView, @NonNull InlineMediaView inlineMediaView) {
        this.f16180a = constraintLayout;
        this.f16181b = view;
        this.f16182c = view2;
        this.f16183d = simpleDraweeView;
        this.f16184e = textView;
        this.f16185f = materialCardView;
        this.f16186g = constraintLayout2;
        this.f16187h = linkifiedTextView;
        this.f16188i = view3;
        this.f16189j = linearLayout;
        this.f16190k = simpleDraweeView2;
        this.f16191l = textView2;
        this.f16192m = simpleDraweeView3;
        this.f16193n = imageView;
        this.f16194o = simpleDraweeView4;
        this.f16195p = textView3;
        this.f16196q = frameLayout;
        this.f16197r = linkifiedTextView2;
        this.f16198s = cardView;
        this.f16199t = inlineMediaView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16180a;
    }
}
