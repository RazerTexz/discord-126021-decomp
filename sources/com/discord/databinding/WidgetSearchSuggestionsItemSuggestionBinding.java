package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSearchSuggestionsItemSuggestionBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17442a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17443b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RelativeLayout f17444c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17445d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f17446e;

    public WidgetSearchSuggestionsItemSuggestionBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.f17442a = relativeLayout;
        this.f17443b = textView;
        this.f17444c = relativeLayout2;
        this.f17445d = textView2;
        this.f17446e = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17442a;
    }
}
