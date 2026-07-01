package com.discord.utilities.view.layoutparams;

import android.widget.RelativeLayout;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.view.layoutparams.LayoutParamsExtensionsKt, reason: use source file name */
/* JADX INFO: compiled from: LayoutParamsExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LayoutParamsExtensions {
    public static final void removeRuleCompat(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics3.checkNotNullParameter(layoutParams, "$this$removeRuleCompat");
        layoutParams.removeRule(i);
    }
}
