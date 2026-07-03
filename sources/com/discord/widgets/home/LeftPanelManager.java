package com.discord.widgets.home;

import com.discord.api.channel.ChannelUtils;
import com.discord.panels.OverlappingPanelsLayout;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: LeftPanelManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LeftPanelManager {
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreGuildSelected storeGuildSelected;

    /* JADX WARN: Multi-variable type inference failed */
    public LeftPanelManager() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public LeftPanelManager(StoreChannelsSelected storeChannelsSelected, StoreGuildSelected storeGuildSelected) {
        C12238m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        C12238m.checkNotNullParameter(storeGuildSelected, "storeGuildSelected");
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeGuildSelected = storeGuildSelected;
    }

    public final Observable<OverlappingPanelsLayout.LockState> observeLockState() {
        Observable<OverlappingPanelsLayout.LockState> observableM11112r = Observable.m11076j(this.storeChannelsSelected.observeResolvedSelectedChannel(), this.storeGuildSelected.observeSelectedGuildId(), new Func2<StoreChannelsSelected.ResolvedSelectedChannel, Long, OverlappingPanelsLayout.LockState>() { // from class: com.discord.widgets.home.LeftPanelManager.observeLockState.1
            /* JADX WARN: Code duplicated, block: B:16:0x0028  */
            @Override // p658rx.functions.Func2
            public final OverlappingPanelsLayout.LockState call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Long l) {
                long id2 = resolvedSelectedChannel.getId();
                boolean z2 = false;
                boolean z3 = (id2 == 0 || id2 == -1) ? false : true;
                boolean z4 = l == null || l.longValue() != 0;
                boolean z5 = !z3;
                if (resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) {
                    z2 = true;
                } else if (resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.Channel) {
                    StoreChannelsSelected.ResolvedSelectedChannel.Channel channel = (StoreChannelsSelected.ResolvedSelectedChannel.Channel) resolvedSelectedChannel;
                    if (channel.getPeekParent() != null || ChannelUtils.m7675J(channel.getChannel())) {
                        z2 = true;
                    }
                }
                if (z4 && z2) {
                    return OverlappingPanelsLayout.LockState.CLOSE;
                }
                return (z4 || !z5) ? OverlappingPanelsLayout.LockState.UNLOCKED : OverlappingPanelsLayout.LockState.OPEN;
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public /* synthetic */ LeftPanelManager(StoreChannelsSelected storeChannelsSelected, StoreGuildSelected storeGuildSelected, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected, (i & 2) != 0 ? StoreStream.INSTANCE.getGuildSelected() : storeGuildSelected);
    }
}
