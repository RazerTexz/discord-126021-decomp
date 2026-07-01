package com.discord.widgets.stage.sheet;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded extends WidgetStageRaisedHandsBottomSheetViewModel$ViewState {
    private final Channel channel;
    private final boolean isEmpty;
    private final boolean isRequestToSpeakEnabled;
    private final boolean isSpeaker;
    private final boolean isTogglingSpeakingState;
    private final boolean isUpdatingRequestToSpeakPermissions;
    private final List<WidgetStageRaisedHandsBottomSheetAdapter$ListItem> raisedHandsParticipants;

    public /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded(Channel channel, List list, boolean z2, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, list, z2, z3, (i & 16) != 0 ? false : z4, (i & 32) != 0 ? false : z5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded copy$default(WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded, Channel channel, List list, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.channel;
        }
        if ((i & 2) != 0) {
            list = widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.raisedHandsParticipants;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            z2 = widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.isRequestToSpeakEnabled;
        }
        boolean z6 = z2;
        if ((i & 8) != 0) {
            z3 = widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.isSpeaker;
        }
        boolean z7 = z3;
        if ((i & 16) != 0) {
            z4 = widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.isUpdatingRequestToSpeakPermissions;
        }
        boolean z8 = z4;
        if ((i & 32) != 0) {
            z5 = widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.isTogglingSpeakingState;
        }
        return widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.copy(channel, list2, z6, z7, z8, z5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final List<WidgetStageRaisedHandsBottomSheetAdapter$ListItem> component2() {
        return this.raisedHandsParticipants;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsRequestToSpeakEnabled() {
        return this.isRequestToSpeakEnabled;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSpeaker() {
        return this.isSpeaker;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsUpdatingRequestToSpeakPermissions() {
        return this.isUpdatingRequestToSpeakPermissions;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsTogglingSpeakingState() {
        return this.isTogglingSpeakingState;
    }

    public final WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded copy(Channel channel, List<? extends WidgetStageRaisedHandsBottomSheetAdapter$ListItem> raisedHandsParticipants, boolean isRequestToSpeakEnabled, boolean isSpeaker, boolean isUpdatingRequestToSpeakPermissions, boolean isTogglingSpeakingState) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(raisedHandsParticipants, "raisedHandsParticipants");
        return new WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded(channel, raisedHandsParticipants, isRequestToSpeakEnabled, isSpeaker, isUpdatingRequestToSpeakPermissions, isTogglingSpeakingState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded = (WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded) other;
        return m.areEqual(this.channel, widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.channel) && m.areEqual(this.raisedHandsParticipants, widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.raisedHandsParticipants) && this.isRequestToSpeakEnabled == widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.isRequestToSpeakEnabled && this.isSpeaker == widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.isSpeaker && this.isUpdatingRequestToSpeakPermissions == widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.isUpdatingRequestToSpeakPermissions && this.isTogglingSpeakingState == widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.isTogglingSpeakingState;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final List<WidgetStageRaisedHandsBottomSheetAdapter$ListItem> getRaisedHandsParticipants() {
        return this.raisedHandsParticipants;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        List<WidgetStageRaisedHandsBottomSheetAdapter$ListItem> list = this.raisedHandsParticipants;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.isRequestToSpeakEnabled;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z3 = this.isSpeaker;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.isUpdatingRequestToSpeakPermissions;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.isTogglingSpeakingState;
        return i3 + (z5 ? 1 : z5);
    }

    /* JADX INFO: renamed from: isEmpty, reason: from getter */
    public final boolean getIsEmpty() {
        return this.isEmpty;
    }

    public final boolean isRequestToSpeakEnabled() {
        return this.isRequestToSpeakEnabled;
    }

    public final boolean isSpeaker() {
        return this.isSpeaker;
    }

    public final boolean isTogglingSpeakingState() {
        return this.isTogglingSpeakingState;
    }

    public final boolean isUpdatingRequestToSpeakPermissions() {
        return this.isUpdatingRequestToSpeakPermissions;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(channel=");
        sbU.append(this.channel);
        sbU.append(", raisedHandsParticipants=");
        sbU.append(this.raisedHandsParticipants);
        sbU.append(", isRequestToSpeakEnabled=");
        sbU.append(this.isRequestToSpeakEnabled);
        sbU.append(", isSpeaker=");
        sbU.append(this.isSpeaker);
        sbU.append(", isUpdatingRequestToSpeakPermissions=");
        sbU.append(this.isUpdatingRequestToSpeakPermissions);
        sbU.append(", isTogglingSpeakingState=");
        return a.O(sbU, this.isTogglingSpeakingState, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded(Channel channel, List<? extends WidgetStageRaisedHandsBottomSheetAdapter$ListItem> list, boolean z2, boolean z3, boolean z4, boolean z5) {
        super(null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(list, "raisedHandsParticipants");
        this.channel = channel;
        this.raisedHandsParticipants = list;
        this.isRequestToSpeakEnabled = z2;
        this.isSpeaker = z3;
        this.isUpdatingRequestToSpeakPermissions = z4;
        this.isTogglingSpeakingState = z5;
        this.isEmpty = list.isEmpty();
    }
}
