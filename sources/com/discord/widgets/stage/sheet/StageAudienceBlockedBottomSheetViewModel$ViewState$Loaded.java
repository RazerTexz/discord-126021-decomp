package com.discord.widgets.stage.sheet;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StageAudienceBlockedBottomSheetViewModel$ViewState$Loaded extends StageAudienceBlockedBottomSheetViewModel$ViewState {
    private final Channel channel;
    private final List<MGRecyclerDataPayload> listItems;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StageAudienceBlockedBottomSheetViewModel$ViewState$Loaded(Channel channel, List<? extends MGRecyclerDataPayload> list) {
        super(null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(list, "listItems");
        this.channel = channel;
        this.listItems = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StageAudienceBlockedBottomSheetViewModel$ViewState$Loaded copy$default(StageAudienceBlockedBottomSheetViewModel$ViewState$Loaded stageAudienceBlockedBottomSheetViewModel$ViewState$Loaded, Channel channel, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = stageAudienceBlockedBottomSheetViewModel$ViewState$Loaded.channel;
        }
        if ((i & 2) != 0) {
            list = stageAudienceBlockedBottomSheetViewModel$ViewState$Loaded.listItems;
        }
        return stageAudienceBlockedBottomSheetViewModel$ViewState$Loaded.copy(channel, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final List<MGRecyclerDataPayload> component2() {
        return this.listItems;
    }

    public final StageAudienceBlockedBottomSheetViewModel$ViewState$Loaded copy(Channel channel, List<? extends MGRecyclerDataPayload> listItems) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(listItems, "listItems");
        return new StageAudienceBlockedBottomSheetViewModel$ViewState$Loaded(channel, listItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageAudienceBlockedBottomSheetViewModel$ViewState$Loaded)) {
            return false;
        }
        StageAudienceBlockedBottomSheetViewModel$ViewState$Loaded stageAudienceBlockedBottomSheetViewModel$ViewState$Loaded = (StageAudienceBlockedBottomSheetViewModel$ViewState$Loaded) other;
        return m.areEqual(this.channel, stageAudienceBlockedBottomSheetViewModel$ViewState$Loaded.channel) && m.areEqual(this.listItems, stageAudienceBlockedBottomSheetViewModel$ViewState$Loaded.listItems);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final List<MGRecyclerDataPayload> getListItems() {
        return this.listItems;
    }

    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        List<MGRecyclerDataPayload> list = this.listItems;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(channel=");
        sbU.append(this.channel);
        sbU.append(", listItems=");
        return a.L(sbU, this.listItems, ")");
    }
}
