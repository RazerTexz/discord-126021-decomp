package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetPhoneCountryCodeBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17363a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f17364b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputLayout f17365c;

    public WidgetPhoneCountryCodeBottomSheetBinding(@NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull TextInputLayout textInputLayout) {
        this.f17363a = linearLayout;
        this.f17364b = recyclerView;
        this.f17365c = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17363a;
    }
}
