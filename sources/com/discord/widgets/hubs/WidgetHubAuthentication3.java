package com.discord.widgets.hubs;

import com.discord.stores.StoreNux;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$configureUi$1$1$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthentication3 extends Lambda implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
    public static final WidgetHubAuthentication3 INSTANCE = new WidgetHubAuthentication3();

    public WidgetHubAuthentication3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
        Intrinsics3.checkNotNullParameter(nuxState, "it");
        return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 62, null);
    }
}
