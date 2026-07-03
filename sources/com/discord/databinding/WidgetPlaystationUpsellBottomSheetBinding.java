package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetPlaystationUpsellBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f17370a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f17371b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f17372c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17373d;

    public WidgetPlaystationUpsellBottomSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.f17370a = nestedScrollView;
        this.f17371b = materialButton;
        this.f17372c = materialButton2;
        this.f17373d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17370a;
    }
}
