package com.discord.widgets.home;

import com.discord.stores.StoreNux$NuxState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$configureFirstOpen$2$3$1 extends o implements Function1<StoreNux$NuxState, StoreNux$NuxState> {
    public static final WidgetHome$configureFirstOpen$2$3$1 INSTANCE = new WidgetHome$configureFirstOpen$2$3$1();

    public WidgetHome$configureFirstOpen$2$3$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StoreNux$NuxState invoke(StoreNux$NuxState storeNux$NuxState) {
        return invoke2(storeNux$NuxState);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StoreNux$NuxState invoke2(StoreNux$NuxState storeNux$NuxState) {
        m.checkNotNullParameter(storeNux$NuxState, "it");
        return StoreNux$NuxState.copy$default(storeNux$NuxState, false, false, false, false, true, null, 39, null);
    }
}
