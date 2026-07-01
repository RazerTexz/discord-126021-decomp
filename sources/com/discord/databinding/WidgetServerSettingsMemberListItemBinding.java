package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.user.SettingsMemberView;
import com.discord.widgets.roles.RolesListView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsMemberListItemBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f2578b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final RolesListView e;

    @NonNull
    public final SettingsMemberView f;

    public WidgetServerSettingsMemberListItemBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull RolesListView rolesListView, @NonNull SettingsMemberView settingsMemberView) {
        this.a = frameLayout;
        this.f2578b = frameLayout2;
        this.c = imageView;
        this.d = imageView2;
        this.e = rolesListView;
        this.f = settingsMemberView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
