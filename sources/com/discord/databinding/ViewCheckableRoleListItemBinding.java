package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: loaded from: classes.dex */
public final class ViewCheckableRoleListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CheckedSetting f15397a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CheckedSetting f15398b;

    public ViewCheckableRoleListItemBinding(@NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2) {
        this.f15397a = checkedSetting;
        this.f15398b = checkedSetting2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15397a;
    }
}
