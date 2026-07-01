package com.discord.widgets.settings.connections;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.analytics.Traits$Location$Page;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAdd$Adapter$ViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsUserConnectionsAdd$PlatformItem $data;
    public final /* synthetic */ WidgetSettingsUserConnectionsAdd$Adapter$ViewHolder this$0;

    public WidgetSettingsUserConnectionsAdd$Adapter$ViewHolder$onConfigure$1(WidgetSettingsUserConnectionsAdd$Adapter$ViewHolder widgetSettingsUserConnectionsAdd$Adapter$ViewHolder, WidgetSettingsUserConnectionsAdd$PlatformItem widgetSettingsUserConnectionsAdd$PlatformItem) {
        this.this$0 = widgetSettingsUserConnectionsAdd$Adapter$ViewHolder;
        this.$data = widgetSettingsUserConnectionsAdd$PlatformItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.getDialogDismissCallback().invoke();
        if (this.$data.getPlatform().ordinal() == 12) {
            WidgetSettingsUserConnectionsAddXbox$Companion widgetSettingsUserConnectionsAddXbox$Companion = WidgetSettingsUserConnectionsAddXbox.Companion;
            m.checkNotNullExpressionValue(view, "v");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "v.context");
            widgetSettingsUserConnectionsAddXbox$Companion.launch(context);
            return;
        }
        StoreUserConnections userConnections = StoreStream.Companion.getUserConnections();
        String platformId = this.$data.getPlatform().getPlatformId();
        m.checkNotNullExpressionValue(view, "v");
        Context context2 = view.getContext();
        m.checkNotNullExpressionValue(context2, "v.context");
        userConnections.authorizeConnection(platformId, context2, Traits$Location$Page.USER_SETTINGS);
    }
}
