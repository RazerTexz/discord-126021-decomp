package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import b.a.i.ViewAddOverrideItemBinding;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.NotificationHighlightsSettingsView;
import com.discord.widgets.servers.NotificationMuteSettingsView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerNotificationsBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ViewAddOverrideItemBinding f2538b;

    @NonNull
    public final RecyclerView c;

    @NonNull
    public final CheckedSetting d;

    @NonNull
    public final CheckedSetting e;

    @NonNull
    public final CheckedSetting f;

    @NonNull
    public final CheckedSetting g;

    @NonNull
    public final View h;

    @NonNull
    public final LinearLayout i;

    @NonNull
    public final NotificationHighlightsSettingsView j;

    @NonNull
    public final View k;

    @NonNull
    public final NotificationMuteSettingsView l;

    @NonNull
    public final View m;

    @NonNull
    public final TextView n;

    @NonNull
    public final CheckedSetting o;

    @NonNull
    public final View p;

    @NonNull
    public final CheckedSetting q;

    public WidgetServerNotificationsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ViewAddOverrideItemBinding viewAddOverrideItemBinding, @NonNull RecyclerView recyclerView, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull CheckedSetting checkedSetting4, @NonNull View view, @NonNull LinearLayout linearLayout, @NonNull NotificationHighlightsSettingsView notificationHighlightsSettingsView, @NonNull View view2, @NonNull NotificationMuteSettingsView notificationMuteSettingsView, @NonNull View view3, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting5, @NonNull View view4, @NonNull CheckedSetting checkedSetting6) {
        this.a = coordinatorLayout;
        this.f2538b = viewAddOverrideItemBinding;
        this.c = recyclerView;
        this.d = checkedSetting;
        this.e = checkedSetting2;
        this.f = checkedSetting3;
        this.g = checkedSetting4;
        this.h = view;
        this.i = linearLayout;
        this.j = notificationHighlightsSettingsView;
        this.k = view2;
        this.l = notificationMuteSettingsView;
        this.m = view3;
        this.n = textView;
        this.o = checkedSetting5;
        this.p = view4;
        this.q = checkedSetting6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
