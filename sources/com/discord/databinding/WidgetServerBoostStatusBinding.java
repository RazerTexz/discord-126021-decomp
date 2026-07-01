package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import b.a.i.w2;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.simple_pager.SimplePager;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.guildboost.GuildBoostMarketingView;
import com.discord.views.guildboost.GuildBoostSubscriptionUpsellView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerBoostStatusBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppViewFlipper f2535b;

    @NonNull
    public final LinkifiedTextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final GuildBoostMarketingView e;

    @NonNull
    public final GuildBoostSubscriptionUpsellView f;

    @NonNull
    public final LinkifiedTextView g;

    @NonNull
    public final MaterialButton h;

    @NonNull
    public final MaterialButton i;

    @NonNull
    public final MaterialButton j;

    @NonNull
    public final SimplePager k;

    @NonNull
    public final w2 l;

    public WidgetServerBoostStatusBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppViewFlipper appViewFlipper, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView, @NonNull GuildBoostMarketingView guildBoostMarketingView, @NonNull GuildBoostSubscriptionUpsellView guildBoostSubscriptionUpsellView, @NonNull LinkifiedTextView linkifiedTextView2, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull MaterialButton materialButton3, @NonNull SimplePager simplePager, @NonNull w2 w2Var) {
        this.a = coordinatorLayout;
        this.f2535b = appViewFlipper;
        this.c = linkifiedTextView;
        this.d = textView;
        this.e = guildBoostMarketingView;
        this.f = guildBoostSubscriptionUpsellView;
        this.g = linkifiedTextView2;
        this.h = materialButton;
        this.i = materialButton2;
        this.j = materialButton3;
        this.k = simplePager;
        this.l = w2Var;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
