package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.appcompat.app.AlertDialog;
import b.a.d.o;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;

/* JADX INFO: compiled from: WidgetServerSettingsIntegrationsListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsIntegrationsListItem$showDisableSyncDialog$2 implements View$OnClickListener {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ AlertDialog $dialog;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $integrationId;

    public WidgetServerSettingsIntegrationsListItem$showDisableSyncDialog$2(long j, long j2, AlertDialog alertDialog, Context context) {
        this.$guildId = j;
        this.$integrationId = j2;
        this.$dialog = alertDialog;
        this.$context = context;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().deleteGuildIntegration(this.$guildId, this.$integrationId), false, 1, null)).k(o.j(new WidgetServerSettingsIntegrationsListItem$showDisableSyncDialog$2$1(this), this.$context, null, 4));
    }
}
