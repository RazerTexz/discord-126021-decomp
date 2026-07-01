package com.discord.widgets.settings.account;

import androidx.core.app.NotificationCompat;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreMFA$State;
import com.discord.stores.StoreUserConnections$State;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import rx.functions.Func5;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount$Model$Companion$get$1<T1, T2, T3, T4, T5, R> implements Func5<MeUser, StoreMFA$State, Map<Long, ? extends Guild>, StoreUserConnections$State, Experiment, WidgetSettingsAccount$Model> {
    public static final WidgetSettingsAccount$Model$Companion$get$1 INSTANCE = new WidgetSettingsAccount$Model$Companion$get$1();

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetSettingsAccount$Model call(MeUser meUser, StoreMFA$State storeMFA$State, Map<Long, ? extends Guild> map, StoreUserConnections$State storeUserConnections$State, Experiment experiment) {
        return call2(meUser, storeMFA$State, (Map<Long, Guild>) map, storeUserConnections$State, experiment);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccount$Model call2(MeUser meUser, StoreMFA$State storeMFA$State, Map<Long, Guild> map, StoreUserConnections$State storeUserConnections$State, Experiment experiment) {
        ConnectedAccount connectedAccount;
        ConnectedAccount connectedAccountPrevious;
        m.checkNotNullExpressionValue(storeUserConnections$State, "connectedAccounts");
        ListIterator<ConnectedAccount> listIterator = storeUserConnections$State.listIterator(storeUserConnections$State.size());
        do {
            connectedAccount = null;
            if (!listIterator.hasPrevious()) {
                connectedAccountPrevious = null;
                break;
            }
            connectedAccountPrevious = listIterator.previous();
        } while (!m.areEqual(connectedAccountPrevious.getType(), "contacts"));
        ConnectedAccount connectedAccount2 = connectedAccountPrevious;
        boolean z2 = true;
        if (experiment != null && experiment.getBucket() == 1) {
            connectedAccount = connectedAccount2;
        }
        m.checkNotNullExpressionValue(meUser, "meUser");
        m.checkNotNullExpressionValue(storeMFA$State, "pendingMFAState");
        Collection<Guild> collectionValues = map.values();
        if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
            z2 = false;
        } else {
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((Guild) it.next()).getOwnerId() == meUser.getId()) {
                }
            }
            z2 = false;
        }
        return new WidgetSettingsAccount$Model(meUser, storeMFA$State, z2, connectedAccount);
    }
}
