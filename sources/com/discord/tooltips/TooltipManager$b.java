package com.discord.tooltips;

import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TooltipManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public class TooltipManager$b {
    private final String cacheKey;
    private final String tooltipName;

    public TooltipManager$b(String str, String str2) {
        m.checkNotNullParameter(str2, "tooltipName");
        this.cacheKey = str;
        this.tooltipName = str2;
    }

    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final String getTooltipName() {
        return this.tooltipName;
    }

    public /* synthetic */ TooltipManager$b(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, str2);
    }
}
