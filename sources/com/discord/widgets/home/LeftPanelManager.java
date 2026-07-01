package com.discord.widgets.home;

import com.discord.panels.OverlappingPanelsLayout$LockState;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: LeftPanelManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LeftPanelManager {
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreGuildSelected storeGuildSelected;

    public LeftPanelManager() {
        this(null, null, 3, null);
    }

    public LeftPanelManager(StoreChannelsSelected storeChannelsSelected, StoreGuildSelected storeGuildSelected) {
        m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        m.checkNotNullParameter(storeGuildSelected, "storeGuildSelected");
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeGuildSelected = storeGuildSelected;
    }

    public final Observable<OverlappingPanelsLayout$LockState> observeLockState() {
        Observable<OverlappingPanelsLayout$LockState> observableR = Observable.j(this.storeChannelsSelected.observeResolvedSelectedChannel(), this.storeGuildSelected.observeSelectedGuildId(), LeftPanelManager$observeLockState$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest… }.distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ LeftPanelManager(StoreChannelsSelected storeChannelsSelected, StoreGuildSelected storeGuildSelected, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getChannelsSelected() : storeChannelsSelected, (i & 2) != 0 ? StoreStream.Companion.getGuildSelected() : storeGuildSelected);
    }
}
