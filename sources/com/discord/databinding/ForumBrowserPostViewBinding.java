package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.ReactionView;
import com.discord.views.typing.TypingDots;
import com.discord.views.user.UserSummaryView;
import com.discord.widgets.forums.ForumPostTagView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class ForumBrowserPostViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15080a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15081b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeSpanTextView f15082c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f15083d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15084e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ForumPostTagView f15085f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final SimpleDraweeView f15086g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f15087h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final LinearLayout f15088i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final ImageView f15089j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final ImageView f15090k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final ReactionView f15091l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final TextView f15092m;

    /* JADX INFO: renamed from: n */
    @NonNull
    public final TypingDots f15093n;

    /* JADX INFO: renamed from: o */
    @NonNull
    public final UserSummaryView f15094o;

    /* JADX INFO: renamed from: p */
    @NonNull
    public final TextView f15095p;

    public ForumBrowserPostViewBinding(@NonNull View view, @NonNull Barrier barrier, @NonNull TextView textView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2, @NonNull ForumPostTagView forumPostTagView, @NonNull Barrier barrier2, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ReactionView reactionView, @NonNull TextView textView4, @NonNull TypingDots typingDots, @NonNull UserSummaryView userSummaryView, @NonNull TextView textView5) {
        this.f15080a = view;
        this.f15081b = textView;
        this.f15082c = simpleDraweeSpanTextView;
        this.f15083d = simpleDraweeView;
        this.f15084e = textView2;
        this.f15085f = forumPostTagView;
        this.f15086g = simpleDraweeView2;
        this.f15087h = textView3;
        this.f15088i = linearLayout;
        this.f15089j = imageView;
        this.f15090k = imageView2;
        this.f15091l = reactionView;
        this.f15092m = textView4;
        this.f15093n = typingDots;
        this.f15094o = userSummaryView;
        this.f15095p = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15080a;
    }
}
