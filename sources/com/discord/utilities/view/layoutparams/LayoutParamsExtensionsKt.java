package com.discord.utilities.view.layoutparams;

import android.widget.RelativeLayout;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: LayoutParamsExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LayoutParamsExtensionsKt {
    public static final void removeRuleCompat(RelativeLayout.LayoutParams layoutParams, int i) {
        C12238m.checkNotNullParameter(layoutParams, "$this$removeRuleCompat");
        layoutParams.removeRule(i);
    }
}
