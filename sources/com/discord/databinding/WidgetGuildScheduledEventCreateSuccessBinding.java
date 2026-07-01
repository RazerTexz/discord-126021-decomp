package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildScheduledEventCreateSuccessBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2442b;

    @NonNull
    public final TextView c;

    @NonNull
    public final CheckedSetting d;

    @NonNull
    public final MaterialButton e;

    public WidgetGuildScheduledEventCreateSuccessBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting, @NonNull MaterialButton materialButton, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = constraintLayout;
        this.f2442b = imageView;
        this.c = textView;
        this.d = checkedSetting;
        this.e = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
