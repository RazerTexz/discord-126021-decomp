package com.discord.widgets.settings.connections;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.analytics.Traits$Location$Page;
import com.discord.utilities.platform.Platform;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAddXbox$onViewBound$1 implements View$OnClickListener {
    public static final WidgetSettingsUserConnectionsAddXbox$onViewBound$1 INSTANCE = new WidgetSettingsUserConnectionsAddXbox$onViewBound$1();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreUserConnections userConnections = StoreStream.Companion.getUserConnections();
        String platformId = Platform.XBOX.getPlatformId();
        m.checkNotNullExpressionValue(view, "v");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "v.context");
        userConnections.authorizeConnection(platformId, context, Traits$Location$Page.USER_SETTINGS);
    }
}
