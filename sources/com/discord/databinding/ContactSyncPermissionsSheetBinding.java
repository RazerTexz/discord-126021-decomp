package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;

/* JADX INFO: loaded from: classes.dex */
public final class ContactSyncPermissionsSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15025a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CheckedSetting f15026b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CheckedSetting f15027c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LinkifiedTextView f15028d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final CheckedSetting f15029e;

    public ContactSyncPermissionsSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull CheckedSetting checkedSetting, @NonNull TextView textView, @NonNull TextView textView2, @NonNull CheckedSetting checkedSetting2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull CheckedSetting checkedSetting3, @NonNull TextView textView3) {
        this.f15025a = constraintLayout;
        this.f15026b = checkedSetting;
        this.f15027c = checkedSetting2;
        this.f15028d = linkifiedTextView;
        this.f15029e = checkedSetting3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15025a;
    }
}
