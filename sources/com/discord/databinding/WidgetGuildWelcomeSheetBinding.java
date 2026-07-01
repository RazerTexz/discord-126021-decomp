package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildWelcomeSheetBinding implements ViewBinding {

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f2457b;

    @NonNull
    public final TextView c;

    @NonNull
    public final AppViewFlipper d;

    @NonNull
    public final SimpleDraweeView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public WidgetGuildWelcomeSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull RecyclerView recyclerView, @NonNull TextView textView, @NonNull AppViewFlipper appViewFlipper, @NonNull SimpleDraweeView simpleDraweeView, @NonNull CardView cardView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = nestedScrollView;
        this.f2457b = recyclerView;
        this.c = textView;
        this.d = appViewFlipper;
        this.e = simpleDraweeView;
        this.f = textView2;
        this.g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
