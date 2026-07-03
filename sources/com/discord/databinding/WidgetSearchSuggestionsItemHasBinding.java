package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSearchSuggestionsItemHasBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17435a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RelativeLayout f17436b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f17437c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17438d;

    public WidgetSearchSuggestionsItemHasBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f17435a = relativeLayout;
        this.f17436b = relativeLayout2;
        this.f17437c = imageView;
        this.f17438d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17435a;
    }
}
