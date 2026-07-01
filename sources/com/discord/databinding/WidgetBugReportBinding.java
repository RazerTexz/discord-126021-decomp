package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.views.SearchInputView;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetBugReportBinding implements ViewBinding {

    @NonNull
    public final LinearLayoutCompat a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f2241b;

    @NonNull
    public final TextInputLayout c;

    @NonNull
    public final TextInputLayout d;

    @NonNull
    public final ProgressBar e;

    @NonNull
    public final RecyclerView f;

    @NonNull
    public final SearchInputView g;

    @NonNull
    public final TextInputLayout h;

    @NonNull
    public final MaterialTextView i;

    @NonNull
    public final TextInputLayout j;

    @NonNull
    public final SimpleDraweeView k;

    @NonNull
    public final AppCompatImageView l;

    @NonNull
    public final StickerView m;

    @NonNull
    public final MaterialTextView n;

    @NonNull
    public final MaterialButton o;

    @NonNull
    public final AppViewFlipper p;

    @NonNull
    public final MaterialButton q;

    @NonNull
    public final MaterialTextView r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final View f2242s;

    @NonNull
    public final View t;

    public WidgetBugReportBinding(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull AppCompatImageView appCompatImageView, @NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull MaterialCardView materialCardView, @NonNull ImageView imageView, @NonNull ProgressBar progressBar, @NonNull RecyclerView recyclerView, @NonNull SearchInputView searchInputView, @NonNull TextInputLayout textInputLayout3, @NonNull MaterialTextView materialTextView, @NonNull TextInputLayout textInputLayout4, @NonNull MaterialCardView materialCardView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull AppCompatImageView appCompatImageView2, @NonNull ImageView imageView2, @NonNull StickerView stickerView, @NonNull MaterialTextView materialTextView2, @NonNull MaterialButton materialButton, @NonNull AppViewFlipper appViewFlipper, @NonNull MaterialButton materialButton2, @NonNull MaterialTextView materialTextView3, @NonNull View view, @NonNull View view2) {
        this.a = linearLayoutCompat;
        this.f2241b = appCompatImageView;
        this.c = textInputLayout;
        this.d = textInputLayout2;
        this.e = progressBar;
        this.f = recyclerView;
        this.g = searchInputView;
        this.h = textInputLayout3;
        this.i = materialTextView;
        this.j = textInputLayout4;
        this.k = simpleDraweeView;
        this.l = appCompatImageView2;
        this.m = stickerView;
        this.n = materialTextView2;
        this.o = materialButton;
        this.p = appViewFlipper;
        this.q = materialButton2;
        this.r = materialTextView3;
        this.f2242s = view;
        this.t = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
