package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import b.a.i.LayoutContactSyncToggleInfoBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class ContactSyncUpsellSheetBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2093b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final LayoutContactSyncToggleInfoBinding d;

    public ContactSyncUpsellSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LayoutContactSyncToggleInfoBinding layoutContactSyncToggleInfoBinding) {
        this.a = constraintLayout;
        this.f2093b = materialButton;
        this.c = materialButton2;
        this.d = layoutContactSyncToggleInfoBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
