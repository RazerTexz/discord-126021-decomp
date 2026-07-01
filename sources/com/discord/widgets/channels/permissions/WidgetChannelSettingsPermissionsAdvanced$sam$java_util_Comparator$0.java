package com.discord.widgets.channels.permissions;

import d0.z.d.m;
import java.util.Comparator;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsAdvanced$sam$java_util_Comparator$0 implements Comparator {
    private final /* synthetic */ Function2 function;

    public WidgetChannelSettingsPermissionsAdvanced$sam$java_util_Comparator$0(Function2 function2) {
        this.function = function2;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        Object objInvoke = this.function.invoke(obj, obj2);
        m.checkNotNullExpressionValue(objInvoke, "invoke(...)");
        return ((Number) objInvoke).intValue();
    }
}
