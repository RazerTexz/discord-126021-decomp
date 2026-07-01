package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.user.SettingsMemberView;

/* JADX INFO: loaded from: classes.dex */
public final class SimpleMemberListItemBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SettingsMemberView f2142b;

    public SimpleMemberListItemBinding(@NonNull FrameLayout frameLayout, @NonNull SettingsMemberView settingsMemberView) {
        this.a = frameLayout;
        this.f2142b = settingsMemberView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
