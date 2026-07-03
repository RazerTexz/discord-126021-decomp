package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.simple_pager.SimplePager;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.guildboost.GuildBoostMarketingView;
import com.discord.views.guildboost.GuildBoostSubscriptionUpsellView;
import com.google.android.material.button.MaterialButton;
import p007b.p008a.p025i.C1075w2;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerBoostStatusBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17467a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final AppViewFlipper f17468b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinkifiedTextView f17469c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17470d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final GuildBoostMarketingView f17471e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final GuildBoostSubscriptionUpsellView f17472f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final LinkifiedTextView f17473g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final MaterialButton f17474h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final MaterialButton f17475i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final MaterialButton f17476j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final SimplePager f17477k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final C1075w2 f17478l;

    public WidgetServerBoostStatusBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppViewFlipper appViewFlipper, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView, @NonNull GuildBoostMarketingView guildBoostMarketingView, @NonNull GuildBoostSubscriptionUpsellView guildBoostSubscriptionUpsellView, @NonNull LinkifiedTextView linkifiedTextView2, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull MaterialButton materialButton3, @NonNull SimplePager simplePager, @NonNull C1075w2 c1075w2) {
        this.f17467a = coordinatorLayout;
        this.f17468b = appViewFlipper;
        this.f17469c = linkifiedTextView;
        this.f17470d = textView;
        this.f17471e = guildBoostMarketingView;
        this.f17472f = guildBoostSubscriptionUpsellView;
        this.f17473g = linkifiedTextView2;
        this.f17474h = materialButton;
        this.f17475i = materialButton2;
        this.f17476j = materialButton3;
        this.f17477k = simplePager;
        this.f17478l = c1075w2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17467a;
    }
}
