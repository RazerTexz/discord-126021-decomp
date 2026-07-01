package com.discord.databinding;

import android.view.View;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetMemberVerificationMultipleChoiceItemBinding implements ViewBinding {

    @NonNull
    public final RadioGroup a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RadioGroup f2490b;

    public WidgetMemberVerificationMultipleChoiceItemBinding(@NonNull RadioGroup radioGroup, @NonNull RadioGroup radioGroup2) {
        this.a = radioGroup;
        this.f2490b = radioGroup2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
