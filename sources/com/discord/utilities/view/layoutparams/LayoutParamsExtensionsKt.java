package com.discord.utilities.view.layoutparams;

import android.widget.RelativeLayout$LayoutParams;
import d0.z.d.m;

/* JADX INFO: compiled from: LayoutParamsExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LayoutParamsExtensionsKt {
    public static final void removeRuleCompat(RelativeLayout$LayoutParams relativeLayout$LayoutParams, int i) {
        m.checkNotNullParameter(relativeLayout$LayoutParams, "$this$removeRuleCompat");
        relativeLayout$LayoutParams.removeRule(i);
    }
}
