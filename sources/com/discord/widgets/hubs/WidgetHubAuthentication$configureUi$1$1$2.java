package com.discord.widgets.hubs;

import com.discord.stores.StoreNux;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthentication$configureUi$1$1$2 extends AbstractC12240o implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
    public static final WidgetHubAuthentication$configureUi$1$1$2 INSTANCE = new WidgetHubAuthentication$configureUi$1$1$2();

    public WidgetHubAuthentication$configureUi$1$1$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
        C12238m.checkNotNullParameter(nuxState, "it");
        return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 62, null);
    }
}
