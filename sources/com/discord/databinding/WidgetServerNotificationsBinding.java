package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.NotificationHighlightsSettingsView;
import com.discord.widgets.servers.NotificationMuteSettingsView;
import p007b.p008a.p025i.C1095z1;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerNotificationsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17489a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final C1095z1 f17490b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f17491c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final CheckedSetting f17492d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final CheckedSetting f17493e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final CheckedSetting f17494f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final CheckedSetting f17495g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final View f17496h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final LinearLayout f17497i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final NotificationHighlightsSettingsView f17498j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final View f17499k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final NotificationMuteSettingsView f17500l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final View f17501m;

    /* JADX INFO: renamed from: n */
    @NonNull
    public final TextView f17502n;

    /* JADX INFO: renamed from: o */
    @NonNull
    public final CheckedSetting f17503o;

    /* JADX INFO: renamed from: p */
    @NonNull
    public final View f17504p;

    /* JADX INFO: renamed from: q */
    @NonNull
    public final CheckedSetting f17505q;

    public WidgetServerNotificationsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull C1095z1 c1095z1, @NonNull RecyclerView recyclerView, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull CheckedSetting checkedSetting4, @NonNull View view, @NonNull LinearLayout linearLayout, @NonNull NotificationHighlightsSettingsView notificationHighlightsSettingsView, @NonNull View view2, @NonNull NotificationMuteSettingsView notificationMuteSettingsView, @NonNull View view3, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting5, @NonNull View view4, @NonNull CheckedSetting checkedSetting6) {
        this.f17489a = coordinatorLayout;
        this.f17490b = c1095z1;
        this.f17491c = recyclerView;
        this.f17492d = checkedSetting;
        this.f17493e = checkedSetting2;
        this.f17494f = checkedSetting3;
        this.f17495g = checkedSetting4;
        this.f17496h = view;
        this.f17497i = linearLayout;
        this.f17498j = notificationHighlightsSettingsView;
        this.f17499k = view2;
        this.f17500l = notificationMuteSettingsView;
        this.f17501m = view3;
        this.f17502n = textView;
        this.f17503o = checkedSetting5;
        this.f17504p = view4;
        this.f17505q = checkedSetting6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17489a;
    }
}
