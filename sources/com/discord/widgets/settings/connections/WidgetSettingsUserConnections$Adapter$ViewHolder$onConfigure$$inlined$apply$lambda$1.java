package com.discord.widgets.settings.connections;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.uri.UriHandler;

/* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsUserConnections$UserConnectionItem $data$inlined;
    public final /* synthetic */ Platform $platform;
    public final /* synthetic */ WidgetSettingsUserConnections$Adapter$ViewHolder this$0;

    public WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$1(Platform platform, WidgetSettingsUserConnections$Adapter$ViewHolder widgetSettingsUserConnections$Adapter$ViewHolder, WidgetSettingsUserConnections$UserConnectionItem widgetSettingsUserConnections$UserConnectionItem) {
        this.$platform = platform;
        this.this$0 = widgetSettingsUserConnections$Adapter$ViewHolder;
        this.$data$inlined = widgetSettingsUserConnections$UserConnectionItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, a.x(view, "view", "view.context"), this.$platform.getProfileUrl(this.$data$inlined.getConnectedAccount().getConnection()), false, false, null, 28, null);
    }
}
