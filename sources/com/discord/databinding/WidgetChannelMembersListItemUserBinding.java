package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.discord.views.UsernameView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelMembersListItemUserBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15862a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f15863b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f15864c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeSpanTextView f15865d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f15866e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final UsernameView f15867f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final StatusView f15868g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final ImageView f15869h;

    public WidgetChannelMembersListItemUserBinding(@NonNull ConstraintLayout constraintLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ImageView imageView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull ImageView imageView2, @NonNull UsernameView usernameView, @NonNull StatusView statusView, @NonNull ImageView imageView3) {
        this.f15862a = constraintLayout;
        this.f15863b = simpleDraweeView;
        this.f15864c = imageView;
        this.f15865d = simpleDraweeSpanTextView;
        this.f15866e = imageView2;
        this.f15867f = usernameView;
        this.f15868g = statusView;
        this.f15869h = imageView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15862a;
    }
}
