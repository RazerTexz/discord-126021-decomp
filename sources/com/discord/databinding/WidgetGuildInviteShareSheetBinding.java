package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.views.SearchInputView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildInviteShareSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f16837a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ConstraintLayout f16838b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16839c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16840d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageButton f16841e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final NestedScrollView f16842f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f16843g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final MaterialButton f16844h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final FrameLayout f16845i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final FrameLayout f16846j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final SearchInputView f16847k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final CardView f16848l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final RecyclerView f16849m;

    /* JADX INFO: renamed from: n */
    @NonNull
    public final AppViewFlipper f16850n;

    public WidgetGuildInviteShareSheetBinding(@NonNull FrameLayout frameLayout, @NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout2, @NonNull Barrier barrier, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView, @NonNull TextView textView4, @NonNull ImageButton imageButton, @NonNull NestedScrollView nestedScrollView, @NonNull TextView textView5, @NonNull MaterialButton materialButton, @NonNull TextView textView6, @NonNull FrameLayout frameLayout3, @NonNull TextView textView7, @NonNull Barrier barrier2, @NonNull FrameLayout frameLayout4, @NonNull Barrier barrier3, @NonNull SearchInputView searchInputView, @NonNull CardView cardView, @NonNull RecyclerView recyclerView, @NonNull AppViewFlipper appViewFlipper) {
        this.f16837a = frameLayout;
        this.f16838b = constraintLayout;
        this.f16839c = textView;
        this.f16840d = textView4;
        this.f16841e = imageButton;
        this.f16842f = nestedScrollView;
        this.f16843g = textView5;
        this.f16844h = materialButton;
        this.f16845i = frameLayout3;
        this.f16846j = frameLayout4;
        this.f16847k = searchInputView;
        this.f16848l = cardView;
        this.f16849m = recyclerView;
        this.f16850n = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16837a;
    }
}
