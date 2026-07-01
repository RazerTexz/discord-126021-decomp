package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsAccessibilityBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckedSetting f2589b;

    @NonNull
    public final CheckedSetting c;

    @NonNull
    public final TextView d;

    @NonNull
    public final LinkifiedTextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final CheckedSetting g;

    @NonNull
    public final TextView h;

    @NonNull
    public final CheckedSetting i;

    @NonNull
    public final CheckedSetting j;

    @NonNull
    public final CheckedSetting k;

    public WidgetSettingsAccessibilityBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView2, @NonNull CheckedSetting checkedSetting3, @NonNull LinearLayout linearLayout, @NonNull TextView textView3, @NonNull View view, @NonNull CheckedSetting checkedSetting4, @NonNull CheckedSetting checkedSetting5, @NonNull CheckedSetting checkedSetting6) {
        this.a = coordinatorLayout;
        this.f2589b = checkedSetting;
        this.c = checkedSetting2;
        this.d = textView;
        this.e = linkifiedTextView;
        this.f = textView2;
        this.g = checkedSetting3;
        this.h = textView3;
        this.i = checkedSetting4;
        this.j = checkedSetting5;
        this.k = checkedSetting6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
