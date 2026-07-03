package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSearchSuggestionItemHeaderHistoryBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17428a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f17429b;

    public WidgetSearchSuggestionItemHeaderHistoryBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull View view, @NonNull TextView textView) {
        this.f17428a = relativeLayout;
        this.f17429b = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17428a;
    }
}
