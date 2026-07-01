package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsNotificationOsBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckedSetting f2631b;

    @NonNull
    public final RelativeLayout c;

    @NonNull
    public final CheckedSetting d;

    public WidgetSettingsNotificationOsBinding(@NonNull LinearLayout linearLayout, @NonNull CheckedSetting checkedSetting, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting2) {
        this.a = linearLayout;
        this.f2631b = checkedSetting;
        this.c = relativeLayout;
        this.d = checkedSetting2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
