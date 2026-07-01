package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.NotificationMuteSettingsView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelNotificationSettingsBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f2262b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final CheckedSetting d;

    @NonNull
    public final TextView e;

    @NonNull
    public final CheckedSetting f;

    @NonNull
    public final CheckedSetting g;

    @NonNull
    public final CheckedSetting h;

    @NonNull
    public final TextView i;

    @NonNull
    public final View j;

    @NonNull
    public final NotificationMuteSettingsView k;

    public WidgetChannelNotificationSettingsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull CheckedSetting checkedSetting, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull CheckedSetting checkedSetting4, @NonNull TextView textView2, @NonNull View view, @NonNull NotificationMuteSettingsView notificationMuteSettingsView, @NonNull NestedScrollView nestedScrollView) {
        this.a = coordinatorLayout;
        this.f2262b = linearLayout;
        this.c = linearLayout3;
        this.d = checkedSetting;
        this.e = textView;
        this.f = checkedSetting2;
        this.g = checkedSetting3;
        this.h = checkedSetting4;
        this.i = textView2;
        this.j = view;
        this.k = notificationMuteSettingsView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
