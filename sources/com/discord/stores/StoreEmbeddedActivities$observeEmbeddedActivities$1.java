package com.discord.stores;

import com.discord.models.embeddedactivities.EmbeddedActivity;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreEmbeddedActivities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmbeddedActivities$observeEmbeddedActivities$1 extends o implements Function0<Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>>> {
    public final /* synthetic */ StoreEmbeddedActivities this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreEmbeddedActivities$observeEmbeddedActivities$1(StoreEmbeddedActivities storeEmbeddedActivities) {
        super(0);
        this.this$0 = storeEmbeddedActivities;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>> invoke2() {
        return this.this$0.getEmbeddedActivities();
    }
}
