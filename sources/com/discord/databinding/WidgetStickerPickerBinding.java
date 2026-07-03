package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.views.SearchInputView;
import com.discord.views.sticker.StickerView;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerPickerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f18188a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f18189b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinkifiedTextView f18190c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final StickerView f18191d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final StickerView f18192e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final StickerView f18193f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final StickerView f18194g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final LoadingButton f18195h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final TextView f18196i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final TextView f18197j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final RecyclerView f18198k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final AppViewFlipper f18199l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final AppBarLayout f18200m;

    /* JADX INFO: renamed from: n */
    @NonNull
    public final ConstraintLayout f18201n;

    /* JADX INFO: renamed from: o */
    @NonNull
    public final View f18202o;

    /* JADX INFO: renamed from: p */
    @NonNull
    public final RecyclerView f18203p;

    /* JADX INFO: renamed from: q */
    @NonNull
    public final CoordinatorLayout f18204q;

    /* JADX INFO: renamed from: r */
    @NonNull
    public final SearchInputView f18205r;

    /* JADX INFO: renamed from: s */
    @NonNull
    public final Toolbar f18206s;

    public WidgetStickerPickerBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull StickerView stickerView, @NonNull StickerView stickerView2, @NonNull StickerView stickerView3, @NonNull StickerView stickerView4, @NonNull LoadingButton loadingButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull RecyclerView recyclerView, @NonNull AppViewFlipper appViewFlipper, @NonNull AppBarLayout appBarLayout, @NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull RecyclerView recyclerView2, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull SearchInputView searchInputView, @NonNull Toolbar toolbar) {
        this.f18188a = coordinatorLayout;
        this.f18189b = imageView;
        this.f18190c = linkifiedTextView;
        this.f18191d = stickerView;
        this.f18192e = stickerView2;
        this.f18193f = stickerView3;
        this.f18194g = stickerView4;
        this.f18195h = loadingButton;
        this.f18196i = textView;
        this.f18197j = textView3;
        this.f18198k = recyclerView;
        this.f18199l = appViewFlipper;
        this.f18200m = appBarLayout;
        this.f18201n = constraintLayout;
        this.f18202o = view;
        this.f18203p = recyclerView2;
        this.f18204q = coordinatorLayout2;
        this.f18205r = searchInputView;
        this.f18206s = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18188a;
    }
}
