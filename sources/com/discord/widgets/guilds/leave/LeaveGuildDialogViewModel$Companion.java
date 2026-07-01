package com.discord.widgets.guilds.leave;

import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreLurking;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LeaveGuildDialogViewModel$Companion {
    private LeaveGuildDialogViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(LeaveGuildDialogViewModel$Companion leaveGuildDialogViewModel$Companion, long j, StoreGuilds storeGuilds, StoreLurking storeLurking) {
        return leaveGuildDialogViewModel$Companion.observeStoreState(j, storeGuilds, storeLurking);
    }

    private final Observable<LeaveGuildDialogViewModel$StoreState> observeStoreState(long guildId, StoreGuilds guildStore, StoreLurking lurkingStore) {
        Observable<LeaveGuildDialogViewModel$StoreState> observableJ = Observable.j(guildStore.observeGuild(guildId), lurkingStore.isLurkingObs(guildId), LeaveGuildDialogViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…urking)\n        }\n      }");
        return observableJ;
    }

    public /* synthetic */ LeaveGuildDialogViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
