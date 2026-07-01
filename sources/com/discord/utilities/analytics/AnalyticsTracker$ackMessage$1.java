package com.discord.utilities.analytics;

import com.discord.utilities.collections.CollectionExtensionsKt;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsTracker$ackMessage$1 extends o implements Function0<Map<String, ? extends Object>> {
    public final /* synthetic */ Function0 $propertyProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsTracker$ackMessage$1(Function0 function0) {
        super(0);
        this.$propertyProvider = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<String, ? extends Object> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, ? extends Object> invoke2() {
        return CollectionExtensionsKt.filterNonNullValues((Map) this.$propertyProvider.invoke());
    }
}
