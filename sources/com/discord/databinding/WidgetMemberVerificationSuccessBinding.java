package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetMemberVerificationSuccessBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2494b;

    @NonNull
    public final TextView c;

    public WidgetMemberVerificationSuccessBinding(@NonNull RelativeLayout relativeLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull CardView cardView) {
        this.a = relativeLayout;
        this.f2494b = materialButton;
        this.c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
