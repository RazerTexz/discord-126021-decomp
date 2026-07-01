package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsLanguageSelectItemBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2629b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public WidgetSettingsLanguageSelectItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull Barrier barrier, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = constraintLayout;
        this.f2629b = imageView;
        this.c = textView;
        this.d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
