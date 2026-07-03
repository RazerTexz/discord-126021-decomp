package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import p007b.p008a.p025i.C1017o0;

/* JADX INFO: loaded from: classes.dex */
public final class ContactSyncUpsellSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15030a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f15031b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f15032c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final C1017o0 f15033d;

    public ContactSyncUpsellSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull C1017o0 c1017o0) {
        this.f15030a = constraintLayout;
        this.f15031b = materialButton;
        this.f15032c = materialButton2;
        this.f15033d = c1017o0;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15030a;
    }
}
