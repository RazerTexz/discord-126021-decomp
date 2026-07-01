package com.discord.widgets.settings.connections;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.stores.StoreNotices$Dialog;
import com.discord.stores.StoreNotices$Dialog$Type;
import com.discord.utilities.notices.NoticeBuilders;
import com.discord.utilities.platform.Platform;
import d0.o;
import d0.t.h0;

/* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$2 implements View$OnClickListener {
    public final /* synthetic */ ConnectedAccount $connectedAccount;
    public final /* synthetic */ String $connectionId;
    public final /* synthetic */ WidgetSettingsUserConnections$UserConnectionItem $data$inlined;
    public final /* synthetic */ Platform $platform;
    public final /* synthetic */ WidgetSettingsUserConnections$Adapter$ViewHolder this$0;

    public WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$2(ConnectedAccount connectedAccount, Platform platform, String str, WidgetSettingsUserConnections$Adapter$ViewHolder widgetSettingsUserConnections$Adapter$ViewHolder, WidgetSettingsUserConnections$UserConnectionItem widgetSettingsUserConnections$UserConnectionItem) {
        this.$connectedAccount = connectedAccount;
        this.$platform = platform;
        this.$connectionId = str;
        this.this$0 = widgetSettingsUserConnections$Adapter$ViewHolder;
        this.$data$inlined = widgetSettingsUserConnections$UserConnectionItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        NoticeBuilders.INSTANCE.showNotice(a.x(view, "v", "v.context"), this.this$0.this$0.getFragmentManager(), new StoreNotices$Dialog(StoreNotices$Dialog$Type.DELETE_CONNECTION_MODAL, h0.mapOf(o.to(WidgetSettingsUserConnections.PLATFORM_NAME, this.$connectedAccount.getType()), o.to(WidgetSettingsUserConnections.PLATFORM_TITLE, this.$platform.getProperName()), o.to(WidgetSettingsUserConnections.CONNECTION_ID, this.$connectionId))));
    }
}
