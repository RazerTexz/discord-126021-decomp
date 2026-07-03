package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSearchSuggestionItemHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final TextView f17426a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17427b;

    public WidgetSearchSuggestionItemHeaderBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f17426a = textView;
        this.f17427b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17426a;
    }
}
