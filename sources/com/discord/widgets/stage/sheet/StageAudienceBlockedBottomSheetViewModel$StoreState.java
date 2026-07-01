package com.discord.widgets.stage.sheet;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StageAudienceBlockedBottomSheetViewModel$StoreState {
    private final Set<Long> blockedUsers;
    private final CallModel callModel;
    private final long channelId;
    private final Map<Long, StageRoles> stageRoles;

    public StageAudienceBlockedBottomSheetViewModel$StoreState(long j, CallModel callModel, Set<Long> set, Map<Long, StageRoles> map) {
        m.checkNotNullParameter(set, "blockedUsers");
        m.checkNotNullParameter(map, "stageRoles");
        this.channelId = j;
        this.callModel = callModel;
        this.blockedUsers = set;
        this.stageRoles = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StageAudienceBlockedBottomSheetViewModel$StoreState copy$default(StageAudienceBlockedBottomSheetViewModel$StoreState stageAudienceBlockedBottomSheetViewModel$StoreState, long j, CallModel callModel, Set set, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            j = stageAudienceBlockedBottomSheetViewModel$StoreState.channelId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            callModel = stageAudienceBlockedBottomSheetViewModel$StoreState.callModel;
        }
        CallModel callModel2 = callModel;
        if ((i & 4) != 0) {
            set = stageAudienceBlockedBottomSheetViewModel$StoreState.blockedUsers;
        }
        Set set2 = set;
        if ((i & 8) != 0) {
            map = stageAudienceBlockedBottomSheetViewModel$StoreState.stageRoles;
        }
        return stageAudienceBlockedBottomSheetViewModel$StoreState.copy(j2, callModel2, set2, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CallModel getCallModel() {
        return this.callModel;
    }

    public final Set<Long> component3() {
        return this.blockedUsers;
    }

    public final Map<Long, StageRoles> component4() {
        return this.stageRoles;
    }

    public final StageAudienceBlockedBottomSheetViewModel$StoreState copy(long channelId, CallModel callModel, Set<Long> blockedUsers, Map<Long, StageRoles> stageRoles) {
        m.checkNotNullParameter(blockedUsers, "blockedUsers");
        m.checkNotNullParameter(stageRoles, "stageRoles");
        return new StageAudienceBlockedBottomSheetViewModel$StoreState(channelId, callModel, blockedUsers, stageRoles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageAudienceBlockedBottomSheetViewModel$StoreState)) {
            return false;
        }
        StageAudienceBlockedBottomSheetViewModel$StoreState stageAudienceBlockedBottomSheetViewModel$StoreState = (StageAudienceBlockedBottomSheetViewModel$StoreState) other;
        return this.channelId == stageAudienceBlockedBottomSheetViewModel$StoreState.channelId && m.areEqual(this.callModel, stageAudienceBlockedBottomSheetViewModel$StoreState.callModel) && m.areEqual(this.blockedUsers, stageAudienceBlockedBottomSheetViewModel$StoreState.blockedUsers) && m.areEqual(this.stageRoles, stageAudienceBlockedBottomSheetViewModel$StoreState.stageRoles);
    }

    public final Set<Long> getBlockedUsers() {
        return this.blockedUsers;
    }

    public final CallModel getCallModel() {
        return this.callModel;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Map<Long, StageRoles> getStageRoles() {
        return this.stageRoles;
    }

    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        CallModel callModel = this.callModel;
        int iHashCode = (iA + (callModel != null ? callModel.hashCode() : 0)) * 31;
        Set<Long> set = this.blockedUsers;
        int iHashCode2 = (iHashCode + (set != null ? set.hashCode() : 0)) * 31;
        Map<Long, StageRoles> map = this.stageRoles;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(channelId=");
        sbU.append(this.channelId);
        sbU.append(", callModel=");
        sbU.append(this.callModel);
        sbU.append(", blockedUsers=");
        sbU.append(this.blockedUsers);
        sbU.append(", stageRoles=");
        return a.M(sbU, this.stageRoles, ")");
    }
}
