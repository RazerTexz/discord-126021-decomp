package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelSettingsAddMemberCategoryBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15898a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15899b;

    public WidgetChannelSettingsAddMemberCategoryBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.f15898a = linearLayout;
        this.f15899b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15898a;
    }
}
