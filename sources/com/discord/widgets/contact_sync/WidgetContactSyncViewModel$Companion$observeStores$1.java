package com.discord.widgets.contact_sync;

import androidx.core.app.NotificationCompat;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.models.user.MeUser;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.StoreUserConnections$State;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import j0.k.b;
import java.util.ListIterator;
import kotlin.Unit;

/* JADX INFO: compiled from: WidgetContactSyncViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSyncViewModel$Companion$observeStores$1<T, R> implements b<Unit, WidgetContactSyncViewModel$StoreState> {
    public final /* synthetic */ StoreUserConnections $storeConnections;
    public final /* synthetic */ StorePhone $storePhone;
    public final /* synthetic */ StoreUser $storeUsers;

    public WidgetContactSyncViewModel$Companion$observeStores$1(StoreUser storeUser, StorePhone storePhone, StoreUserConnections storeUserConnections) {
        this.$storeUsers = storeUser;
        this.$storePhone = storePhone;
        this.$storeConnections = storeUserConnections;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetContactSyncViewModel$StoreState call(Unit unit) {
        return call2(unit);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetContactSyncViewModel$StoreState call2(Unit unit) {
        ConnectedAccount connectedAccountPrevious;
        MeUser meSnapshot = this.$storeUsers.getMeSnapshot();
        PhoneCountryCode countryCode = this.$storePhone.getCountryCode();
        StoreUserConnections$State stateSnapshot = this.$storeConnections.getStateSnapshot();
        ListIterator<ConnectedAccount> listIterator = stateSnapshot.listIterator(stateSnapshot.size());
        while (listIterator.hasPrevious()) {
            connectedAccountPrevious = listIterator.previous();
            if (m.areEqual(connectedAccountPrevious.getType(), "contacts")) {
                return new WidgetContactSyncViewModel$StoreState(meSnapshot.getPhoneNumber(), UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, meSnapshot, null, null, 3, null).toString(), countryCode, connectedAccountPrevious);
            }
        }
        connectedAccountPrevious = null;
        return new WidgetContactSyncViewModel$StoreState(meSnapshot.getPhoneNumber(), UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, meSnapshot, null, null, 3, null).toString(), countryCode, connectedAccountPrevious);
    }
}
