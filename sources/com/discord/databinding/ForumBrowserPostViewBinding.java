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

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2109b;

    @NonNull
    public final SimpleDraweeSpanTextView c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final ForumPostTagView f;

    @NonNull
    public final SimpleDraweeView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final LinearLayout i;

    @NonNull
    public final ImageView j;

    @NonNull
    public final ImageView k;

    @NonNull
    public final ReactionView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final TypingDots n;

    @NonNull
    public final UserSummaryView o;

    @NonNull
    public final TextView p;

    public ForumBrowserPostViewBinding(@NonNull View view, @NonNull Barrier barrier, @NonNull TextView textView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2, @NonNull ForumPostTagView forumPostTagView, @NonNull Barrier barrier2, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ReactionView reactionView, @NonNull TextView textView4, @NonNull TypingDots typingDots, @NonNull UserSummaryView userSummaryView, @NonNull TextView textView5) {
        this.a = view;
        this.f2109b = textView;
        this.c = simpleDraweeSpanTextView;
        this.d = simpleDraweeView;
        this.e = textView2;
        this.f = forumPostTagView;
        this.g = simpleDraweeView2;
        this.h = textView3;
        this.i = linearLayout;
        this.j = imageView;
        this.k = imageView2;
        this.l = reactionView;
        this.m = textView4;
        this.n = typingDots;
        this.o = userSummaryView;
        this.p = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
