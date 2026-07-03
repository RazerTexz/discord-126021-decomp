package com.discord.databinding;

import android.view.View;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetMemberVerificationMultipleChoiceItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RadioGroup f17246a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RadioGroup f17247b;

    public WidgetMemberVerificationMultipleChoiceItemBinding(@NonNull RadioGroup radioGroup, @NonNull RadioGroup radioGroup2) {
        this.f17246a = radioGroup;
        this.f17247b = radioGroup2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17246a;
    }
}
