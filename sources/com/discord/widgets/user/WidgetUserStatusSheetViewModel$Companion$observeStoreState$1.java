package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.models.presence.Presence;
import com.discord.utilities.presence.PresenceUtils;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: WidgetUserStatusSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusSheetViewModel$Companion$observeStoreState$1<T, R> implements b<Presence, WidgetUserStatusSheetViewModel$StoreState> {
    public static final WidgetUserStatusSheetViewModel$Companion$observeStoreState$1 INSTANCE = new WidgetUserStatusSheetViewModel$Companion$observeStoreState$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetUserStatusSheetViewModel$StoreState call(Presence presence) {
        return call2(presence);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetUserStatusSheetViewModel$StoreState call2(Presence presence) {
        PresenceUtils presenceUtils = PresenceUtils.INSTANCE;
        m.checkNotNullExpressionValue(presence, "localPresence");
        return new WidgetUserStatusSheetViewModel$StoreState(presenceUtils.getCustomStatusActivity(presence));
    }
}
