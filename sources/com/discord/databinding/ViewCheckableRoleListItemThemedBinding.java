package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: loaded from: classes.dex */
public final class ViewCheckableRoleListItemThemedBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CheckedSetting f15399a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CheckedSetting f15400b;

    public ViewCheckableRoleListItemThemedBinding(@NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2) {
        this.f15399a = checkedSetting;
        this.f15400b = checkedSetting2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15399a;
    }
}
