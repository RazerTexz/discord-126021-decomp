package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.user.SettingsMemberView;

/* JADX INFO: loaded from: classes.dex */
public final class SimpleMemberListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15238a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SettingsMemberView f15239b;

    public SimpleMemberListItemBinding(@NonNull FrameLayout frameLayout, @NonNull SettingsMemberView settingsMemberView) {
        this.f15238a = frameLayout;
        this.f15239b = settingsMemberView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15238a;
    }
}
