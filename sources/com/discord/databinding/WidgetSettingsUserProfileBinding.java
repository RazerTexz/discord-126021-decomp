package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.settings.profile.TouchInterceptingCoordinatorLayout;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsUserProfileBinding implements ViewBinding {

    @NonNull
    public final TouchInterceptingCoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CardView f2640b;

    @NonNull
    public final TextInputEditText c;

    @NonNull
    public final TextInputLayout d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final CardView g;

    @NonNull
    public final LinkifiedTextView h;

    @NonNull
    public final DimmerView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final LinearLayout k;

    @NonNull
    public final LinearLayout l;

    @NonNull
    public final FloatingActionButton m;

    @NonNull
    public final TextInputLayout n;

    @NonNull
    public final UserProfileHeaderView o;

    public WidgetSettingsUserProfileBinding(@NonNull TouchInterceptingCoordinatorLayout touchInterceptingCoordinatorLayout, @NonNull CardView cardView, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull CardView cardView2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull DimmerView dimmerView, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull CardView cardView3, @NonNull TextView textView4, @NonNull LinearLayout linearLayout3, @NonNull FloatingActionButton floatingActionButton, @NonNull TextInputLayout textInputLayout2, @NonNull NestedScrollView nestedScrollView, @NonNull UserProfileHeaderView userProfileHeaderView) {
        this.a = touchInterceptingCoordinatorLayout;
        this.f2640b = cardView;
        this.c = textInputEditText;
        this.d = textInputLayout;
        this.e = textView;
        this.f = textView2;
        this.g = cardView2;
        this.h = linkifiedTextView;
        this.i = dimmerView;
        this.j = textView3;
        this.k = linearLayout;
        this.l = linearLayout2;
        this.m = floatingActionButton;
        this.n = textInputLayout2;
        this.o = userProfileHeaderView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
