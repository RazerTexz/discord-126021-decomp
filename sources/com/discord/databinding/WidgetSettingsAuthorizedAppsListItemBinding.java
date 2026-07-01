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

    @NonNull
    public final MaterialCardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f2604b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final SimpleDraweeView e;

    @NonNull
    public final MaterialCardView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final RecyclerView i;

    public WidgetSettingsAuthorizedAppsListItemBinding(@NonNull MaterialCardView materialCardView, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull RecyclerView recyclerView) {
        this.a = materialCardView;
        this.f2604b = appCompatImageView;
        this.c = textView;
        this.d = textView2;
        this.e = simpleDraweeView;
        this.f = materialCardView2;
        this.g = textView3;
        this.h = textView4;
        this.i = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
