package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetAddFriendUserListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15634a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final AppCompatImageView f15635b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final AppCompatImageView f15636c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final AppCompatImageView f15637d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeView f15638e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15639f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f15640g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final StatusView f15641h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final AppCompatImageView f15642i;

    public WidgetAddFriendUserListItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull SimpleDraweeView simpleDraweeView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull StatusView statusView, @NonNull LinearLayout linearLayout2, @NonNull AppCompatImageView appCompatImageView4) {
        this.f15634a = constraintLayout;
        this.f15635b = appCompatImageView;
        this.f15636c = appCompatImageView2;
        this.f15637d = appCompatImageView3;
        this.f15638e = simpleDraweeView;
        this.f15639f = textView;
        this.f15640g = textView2;
        this.f15641h = statusView;
        this.f15642i = appCompatImageView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15634a;
    }
}
