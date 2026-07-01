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

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckedSetting f2092b;

    @NonNull
    public final CheckedSetting c;

    @NonNull
    public final LinkifiedTextView d;

    @NonNull
    public final CheckedSetting e;

    public ContactSyncPermissionsSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull CheckedSetting checkedSetting, @NonNull TextView textView, @NonNull TextView textView2, @NonNull CheckedSetting checkedSetting2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull CheckedSetting checkedSetting3, @NonNull TextView textView3) {
        this.a = constraintLayout;
        this.f2092b = checkedSetting;
        this.c = checkedSetting2;
        this.d = linkifiedTextView;
        this.e = checkedSetting3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
