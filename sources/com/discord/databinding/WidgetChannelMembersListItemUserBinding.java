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

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f2261b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final SimpleDraweeSpanTextView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final UsernameView f;

    @NonNull
    public final StatusView g;

    @NonNull
    public final ImageView h;

    public WidgetChannelMembersListItemUserBinding(@NonNull ConstraintLayout constraintLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ImageView imageView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull ImageView imageView2, @NonNull UsernameView usernameView, @NonNull StatusView statusView, @NonNull ImageView imageView3) {
        this.a = constraintLayout;
        this.f2261b = simpleDraweeView;
        this.c = imageView;
        this.d = simpleDraweeSpanTextView;
        this.e = imageView2;
        this.f = usernameView;
        this.g = statusView;
        this.h = imageView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
