package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsAuthorizedAppsListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final MaterialCardView f17863a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final AppCompatImageView f17864b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f17865c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17866d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeView f17867e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialCardView f17868f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f17869g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f17870h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final RecyclerView f17871i;

    public WidgetSettingsAuthorizedAppsListItemBinding(@NonNull MaterialCardView materialCardView, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull RecyclerView recyclerView) {
        this.f17863a = materialCardView;
        this.f17864b = appCompatImageView;
        this.f17865c = textView;
        this.f17866d = textView2;
        this.f17867e = simpleDraweeView;
        this.f17868f = materialCardView2;
        this.f17869g = textView3;
        this.f17870h = textView4;
        this.f17871i = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17863a;
    }
}
