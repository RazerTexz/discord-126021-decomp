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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f15870a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinearLayout f15871b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinearLayout f15872c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final CheckedSetting f15873d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f15874e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final CheckedSetting f15875f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final CheckedSetting f15876g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final CheckedSetting f15877h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final TextView f15878i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final View f15879j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final NotificationMuteSettingsView f15880k;

    public WidgetChannelNotificationSettingsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull CheckedSetting checkedSetting, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull CheckedSetting checkedSetting4, @NonNull TextView textView2, @NonNull View view, @NonNull NotificationMuteSettingsView notificationMuteSettingsView, @NonNull NestedScrollView nestedScrollView) {
        this.f15870a = coordinatorLayout;
        this.f15871b = linearLayout;
        this.f15872c = linearLayout3;
        this.f15873d = checkedSetting;
        this.f15874e = textView;
        this.f15875f = checkedSetting2;
        this.f15876g = checkedSetting3;
        this.f15877h = checkedSetting4;
        this.f15878i = textView2;
        this.f15879j = view;
        this.f15880k = notificationMuteSettingsView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15870a;
    }
}
