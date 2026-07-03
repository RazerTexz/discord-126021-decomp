package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildScheduledEventUpsellBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f17047a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f17048b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f17049c;

    public WidgetGuildScheduledEventUpsellBottomSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView) {
        this.f17047a = nestedScrollView;
        this.f17048b = materialButton;
        this.f17049c = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17047a;
    }
}
