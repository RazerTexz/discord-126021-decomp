package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.widgets.chat.list.ViewEmbedGameInvite;
import com.discord.widgets.user.search.ViewGlobalSearchItem;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetIncomingShareBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final DimmerView f2479b;

    @NonNull
    public final ViewEmbedGameInvite c;

    @NonNull
    public final TextInputLayout d;

    @NonNull
    public final RecyclerView e;

    @NonNull
    public final CardView f;

    @NonNull
    public final TextInputLayout g;

    @NonNull
    public final RecyclerView h;

    @NonNull
    public final AppViewFlipper i;

    @NonNull
    public final NestedScrollView j;

    @NonNull
    public final AppViewFlipper k;

    @NonNull
    public final ViewGlobalSearchItem l;

    @NonNull
    public final ImageView m;

    public WidgetIncomingShareBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DimmerView dimmerView, @NonNull ViewEmbedGameInvite viewEmbedGameInvite, @NonNull TextInputLayout textInputLayout, @NonNull RecyclerView recyclerView, @NonNull CardView cardView, @NonNull TextInputLayout textInputLayout2, @NonNull RecyclerView recyclerView2, @NonNull ImageView imageView, @NonNull AppViewFlipper appViewFlipper, @NonNull NestedScrollView nestedScrollView, @NonNull AppViewFlipper appViewFlipper2, @NonNull ViewGlobalSearchItem viewGlobalSearchItem, @NonNull ImageView imageView2) {
        this.a = coordinatorLayout;
        this.f2479b = dimmerView;
        this.c = viewEmbedGameInvite;
        this.d = textInputLayout;
        this.e = recyclerView;
        this.f = cardView;
        this.g = textInputLayout2;
        this.h = recyclerView2;
        this.i = appViewFlipper;
        this.j = nestedScrollView;
        this.k = appViewFlipper2;
        this.l = viewGlobalSearchItem;
        this.m = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
