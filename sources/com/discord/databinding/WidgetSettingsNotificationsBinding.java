package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsNotificationsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f18022a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CheckedSetting f18023b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CheckedSetting f18024c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final CheckedSetting f18025d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final CheckedSetting f18026e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final CheckedSetting f18027f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final LinearLayout f18028g;

    public WidgetSettingsNotificationsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull CheckedSetting checkedSetting4, @NonNull CheckedSetting checkedSetting5, @NonNull LinearLayout linearLayout) {
        this.f18022a = coordinatorLayout;
        this.f18023b = checkedSetting;
        this.f18024c = checkedSetting2;
        this.f18025d = checkedSetting3;
        this.f18026e = checkedSetting4;
        this.f18027f = checkedSetting5;
        this.f18028g = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18022a;
    }
}
