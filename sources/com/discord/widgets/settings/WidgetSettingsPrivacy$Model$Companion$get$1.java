package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.stores.StoreUserConnections$State;
import d0.z.d.m;
import j0.k.b;
import java.util.ListIterator;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$Model$Companion$get$1<T, R> implements b<StoreUserConnections$State, ConnectedAccount> {
    public static final WidgetSettingsPrivacy$Model$Companion$get$1 INSTANCE = new WidgetSettingsPrivacy$Model$Companion$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ ConnectedAccount call(StoreUserConnections$State storeUserConnections$State) {
        return call2(storeUserConnections$State);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ConnectedAccount call2(StoreUserConnections$State storeUserConnections$State) {
        ConnectedAccount connectedAccountPrevious;
        m.checkNotNullExpressionValue(storeUserConnections$State, "accounts");
        ListIterator<ConnectedAccount> listIterator = storeUserConnections$State.listIterator(storeUserConnections$State.size());
        while (listIterator.hasPrevious()) {
            connectedAccountPrevious = listIterator.previous();
            if (m.areEqual(connectedAccountPrevious.getType(), "contacts")) {
                return connectedAccountPrevious;
            }
        }
        connectedAccountPrevious = null;
        return connectedAccountPrevious;
    }
}
