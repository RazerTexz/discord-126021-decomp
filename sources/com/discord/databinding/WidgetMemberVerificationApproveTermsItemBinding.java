package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetMemberVerificationApproveTermsItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CheckedSetting f17235a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CheckedSetting f17236b;

    public WidgetMemberVerificationApproveTermsItemBinding(@NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2) {
        this.f17235a = checkedSetting;
        this.f17236b = checkedSetting2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17235a;
    }
}
