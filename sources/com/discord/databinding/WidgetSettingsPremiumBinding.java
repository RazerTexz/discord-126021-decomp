package com.discord.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import b.a.i.LayoutAccountCreditsListBinding;
import b.a.i.LayoutPremiumSettingsPaymentBinding;
import b.a.i.ViewPremiumSettingsPerksBinding;
import b.a.i.ViewPremiumSettingsTier1Binding;
import b.a.i.ViewPremiumSettingsTier2Binding;
import b.a.i.WidgetSettingsPremiumPriceChangeNoticeBinding;
import com.discord.app.AppViewFlipper;
import com.discord.views.ActiveSubscriptionView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsPremiumBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LayoutAccountCreditsListBinding f2633b;

    @NonNull
    public final LayoutPremiumSettingsPaymentBinding c;

    @NonNull
    public final ViewPremiumSettingsPerksBinding d;

    @NonNull
    public final ActiveSubscriptionView e;

    @NonNull
    public final ActiveSubscriptionView f;

    @NonNull
    public final LinearLayout g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final WidgetSettingsPremiumPriceChangeNoticeBinding k;

    @NonNull
    public final MaterialButton l;

    @NonNull
    public final ScrollView m;

    @NonNull
    public final Button n;

    @NonNull
    public final CardView o;

    @NonNull
    public final TextView p;

    @NonNull
    public final LinearLayout q;

    @NonNull
    public final TextView r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final AppViewFlipper f2634s;

    @NonNull
    public final ViewPremiumSettingsTier1Binding t;

    @NonNull
    public final ViewPremiumSettingsTier2Binding u;

    public WidgetSettingsPremiumBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LayoutAccountCreditsListBinding layoutAccountCreditsListBinding, @NonNull LayoutPremiumSettingsPaymentBinding layoutPremiumSettingsPaymentBinding, @NonNull ViewPremiumSettingsPerksBinding viewPremiumSettingsPerksBinding, @NonNull ActiveSubscriptionView activeSubscriptionView, @NonNull ActiveSubscriptionView activeSubscriptionView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull WidgetSettingsPremiumPriceChangeNoticeBinding widgetSettingsPremiumPriceChangeNoticeBinding, @NonNull MaterialButton materialButton, @NonNull ScrollView scrollView, @NonNull Button button, @NonNull CardView cardView, @NonNull TextView textView4, @NonNull LinearLayout linearLayout2, @NonNull TextView textView5, @NonNull AppViewFlipper appViewFlipper, @NonNull ViewPremiumSettingsTier1Binding viewPremiumSettingsTier1Binding, @NonNull ViewPremiumSettingsTier2Binding viewPremiumSettingsTier2Binding) {
        this.a = coordinatorLayout;
        this.f2633b = layoutAccountCreditsListBinding;
        this.c = layoutPremiumSettingsPaymentBinding;
        this.d = viewPremiumSettingsPerksBinding;
        this.e = activeSubscriptionView;
        this.f = activeSubscriptionView2;
        this.g = linearLayout;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
        this.k = widgetSettingsPremiumPriceChangeNoticeBinding;
        this.l = materialButton;
        this.m = scrollView;
        this.n = button;
        this.o = cardView;
        this.p = textView4;
        this.q = linearLayout2;
        this.r = textView5;
        this.f2634s = appViewFlipper;
        this.t = viewPremiumSettingsTier1Binding;
        this.u = viewPremiumSettingsTier2Binding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
