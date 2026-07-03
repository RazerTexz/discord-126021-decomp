package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f16924a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f16925b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f16926c;

    public WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.f16924a = nestedScrollView;
        this.f16925b = materialButton;
        this.f16926c = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16924a;
    }
}
