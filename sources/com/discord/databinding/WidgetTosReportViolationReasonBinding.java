package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.radiobutton.MaterialRadioButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolationReasonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f18308a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f18309b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f18310c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialRadioButton f18311d;

    public WidgetTosReportViolationReasonBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull MaterialRadioButton materialRadioButton) {
        this.f18308a = relativeLayout;
        this.f18309b = textView;
        this.f18310c = textView2;
        this.f18311d = materialRadioButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18308a;
    }
}
