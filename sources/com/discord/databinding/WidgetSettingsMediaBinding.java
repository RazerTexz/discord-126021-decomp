package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsMediaBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckedSetting f2630b;

    @NonNull
    public final CheckedSetting c;

    @NonNull
    public final LinkifiedTextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final CheckedSetting g;

    @NonNull
    public final CheckedSetting h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final CheckedSetting l;

    @NonNull
    public final CheckedSetting m;

    public WidgetSettingsMediaBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull CheckedSetting checkedSetting3, @NonNull CheckedSetting checkedSetting4, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull CheckedSetting checkedSetting5, @NonNull CheckedSetting checkedSetting6) {
        this.a = coordinatorLayout;
        this.f2630b = checkedSetting;
        this.c = checkedSetting2;
        this.d = linkifiedTextView;
        this.e = textView;
        this.f = textView2;
        this.g = checkedSetting3;
        this.h = checkedSetting4;
        this.i = textView3;
        this.j = textView4;
        this.k = textView5;
        this.l = checkedSetting5;
        this.m = checkedSetting6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
