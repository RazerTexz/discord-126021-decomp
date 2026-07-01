package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetFriendsListAdapterItemFriendBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeSpanTextView f2392b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final AppCompatImageView d;

    @NonNull
    public final AppCompatImageView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final StatusView g;

    public WidgetFriendsListAdapterItemFriendBinding(@NonNull RelativeLayout relativeLayout, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull LinearLayout linearLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull TextView textView, @NonNull StatusView statusView, @NonNull LinearLayout linearLayout2) {
        this.a = relativeLayout;
        this.f2392b = simpleDraweeSpanTextView;
        this.c = simpleDraweeView;
        this.d = appCompatImageView;
        this.e = appCompatImageView2;
        this.f = textView;
        this.g = statusView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
