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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17769a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CheckedSetting f17770b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CheckedSetting f17771c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17772d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LinkifiedTextView f17773e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f17774f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final CheckedSetting f17775g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f17776h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final CheckedSetting f17777i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final CheckedSetting f17778j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final CheckedSetting f17779k;

    public WidgetSettingsAccessibilityBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView2, @NonNull CheckedSetting checkedSetting3, @NonNull LinearLayout linearLayout, @NonNull TextView textView3, @NonNull View view, @NonNull CheckedSetting checkedSetting4, @NonNull CheckedSetting checkedSetting5, @NonNull CheckedSetting checkedSetting6) {
        this.f17769a = coordinatorLayout;
        this.f17770b = checkedSetting;
        this.f17771c = checkedSetting2;
        this.f17772d = textView;
        this.f17773e = linkifiedTextView;
        this.f17774f = textView2;
        this.f17775g = checkedSetting3;
        this.f17776h = textView3;
        this.f17777i = checkedSetting4;
        this.f17778j = checkedSetting5;
        this.f17779k = checkedSetting6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17769a;
    }
}
