package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.premium.GiftSelectView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsGiftingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17953a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final DimmerView f17954b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final GiftSelectView f17955c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final GiftSelectView f17956d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final GiftSelectView f17957e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final GiftSelectView f17958f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final LinkifiedTextView f17959g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final LinkifiedTextView f17960h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final AppViewFlipper f17961i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final ProgressBar f17962j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final TextInputLayout f17963k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final TextView f17964l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final RecyclerView f17965m;

    /* JADX INFO: renamed from: n */
    @NonNull
    public final TextView f17966n;

    /* JADX INFO: renamed from: o */
    @NonNull
    public final MaterialButton f17967o;

    /* JADX INFO: renamed from: p */
    @NonNull
    public final TextView f17968p;

    /* JADX INFO: renamed from: q */
    @NonNull
    public final TextView f17969q;

    /* JADX INFO: renamed from: r */
    @NonNull
    public final TextView f17970r;

    /* JADX INFO: renamed from: s */
    @NonNull
    public final RecyclerView f17971s;

    public WidgetSettingsGiftingBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DimmerView dimmerView, @NonNull GiftSelectView giftSelectView, @NonNull GiftSelectView giftSelectView2, @NonNull GiftSelectView giftSelectView3, @NonNull GiftSelectView giftSelectView4, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LinkifiedTextView linkifiedTextView2, @NonNull AppViewFlipper appViewFlipper, @NonNull ProgressBar progressBar, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull MaterialButton materialButton, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull RecyclerView recyclerView2) {
        this.f17953a = coordinatorLayout;
        this.f17954b = dimmerView;
        this.f17955c = giftSelectView;
        this.f17956d = giftSelectView2;
        this.f17957e = giftSelectView3;
        this.f17958f = giftSelectView4;
        this.f17959g = linkifiedTextView;
        this.f17960h = linkifiedTextView2;
        this.f17961i = appViewFlipper;
        this.f17962j = progressBar;
        this.f17963k = textInputLayout;
        this.f17964l = textView;
        this.f17965m = recyclerView;
        this.f17966n = textView2;
        this.f17967o = materialButton;
        this.f17968p = textView3;
        this.f17969q = textView4;
        this.f17970r = textView5;
        this.f17971s = recyclerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17953a;
    }
}
