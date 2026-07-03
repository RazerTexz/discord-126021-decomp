package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSearchSuggestionsItemChannelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17432a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RelativeLayout f17433b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f17434c;

    public WidgetSearchSuggestionsItemChannelBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f17432a = relativeLayout;
        this.f17433b = relativeLayout2;
        this.f17434c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17432a;
    }
}
