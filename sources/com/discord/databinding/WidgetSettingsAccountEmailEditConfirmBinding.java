package com.discord.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsAccountEmailEditConfirmBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17840a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final DimmerView f17841b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputLayout f17842c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17843d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LinkifiedTextView f17844e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final Button f17845f;

    public WidgetSettingsAccountEmailEditConfirmBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DimmerView dimmerView, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull Button button) {
        this.f17840a = coordinatorLayout;
        this.f17841b = dimmerView;
        this.f17842c = textInputLayout;
        this.f17843d = textView;
        this.f17844e = linkifiedTextView;
        this.f17845f = button;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17840a;
    }
}
