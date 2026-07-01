package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSearchSuggestionsItemSuggestionBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2530b;

    @NonNull
    public final RelativeLayout c;

    @NonNull
    public final TextView d;

    @NonNull
    public final ImageView e;

    public WidgetSearchSuggestionsItemSuggestionBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.a = relativeLayout;
        this.f2530b = textView;
        this.c = relativeLayout2;
        this.d = textView2;
        this.e = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
