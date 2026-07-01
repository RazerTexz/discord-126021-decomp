package com.discord.widgets.voice.call;

import b.d.b.a.a;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetVoiceCallIncoming$Model {
    public static final WidgetVoiceCallIncoming$Model$Companion Companion = new WidgetVoiceCallIncoming$Model$Companion(null);
    private final CallModel callModel;
    private final int numIncomingCalls;
    private final List<StoreVoiceParticipants$VoiceUser> privateCallUserListItems;

    public WidgetVoiceCallIncoming$Model(CallModel callModel, List<StoreVoiceParticipants$VoiceUser> list, int i) {
        m.checkNotNullParameter(callModel, "callModel");
        m.checkNotNullParameter(list, "privateCallUserListItems");
        this.callModel = callModel;
        this.privateCallUserListItems = list;
        this.numIncomingCalls = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetVoiceCallIncoming$Model copy$default(WidgetVoiceCallIncoming$Model widgetVoiceCallIncoming$Model, CallModel callModel, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            callModel = widgetVoiceCallIncoming$Model.callModel;
        }
        if ((i2 & 2) != 0) {
            list = widgetVoiceCallIncoming$Model.privateCallUserListItems;
        }
        if ((i2 & 4) != 0) {
            i = widgetVoiceCallIncoming$Model.numIncomingCalls;
        }
        return widgetVoiceCallIncoming$Model.copy(callModel, list, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CallModel getCallModel() {
        return this.callModel;
    }

    public final List<StoreVoiceParticipants$VoiceUser> component2() {
        return this.privateCallUserListItems;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getNumIncomingCalls() {
        return this.numIncomingCalls;
    }

    public final WidgetVoiceCallIncoming$Model copy(CallModel callModel, List<StoreVoiceParticipants$VoiceUser> privateCallUserListItems, int numIncomingCalls) {
        m.checkNotNullParameter(callModel, "callModel");
        m.checkNotNullParameter(privateCallUserListItems, "privateCallUserListItems");
        return new WidgetVoiceCallIncoming$Model(callModel, privateCallUserListItems, numIncomingCalls);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetVoiceCallIncoming$Model)) {
            return false;
        }
        WidgetVoiceCallIncoming$Model widgetVoiceCallIncoming$Model = (WidgetVoiceCallIncoming$Model) other;
        return m.areEqual(this.callModel, widgetVoiceCallIncoming$Model.callModel) && m.areEqual(this.privateCallUserListItems, widgetVoiceCallIncoming$Model.privateCallUserListItems) && this.numIncomingCalls == widgetVoiceCallIncoming$Model.numIncomingCalls;
    }

    public final CallModel getCallModel() {
        return this.callModel;
    }

    public final long getChannelId() {
        return this.callModel.getChannel().getId();
    }

    public final int getNumIncomingCalls() {
        return this.numIncomingCalls;
    }

    public final List<StoreVoiceParticipants$VoiceUser> getPrivateCallUserListItems() {
        return this.privateCallUserListItems;
    }

    public int hashCode() {
        CallModel callModel = this.callModel;
        int iHashCode = (callModel != null ? callModel.hashCode() : 0) * 31;
        List<StoreVoiceParticipants$VoiceUser> list = this.privateCallUserListItems;
        return ((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + this.numIncomingCalls;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(callModel=");
        sbU.append(this.callModel);
        sbU.append(", privateCallUserListItems=");
        sbU.append(this.privateCallUserListItems);
        sbU.append(", numIncomingCalls=");
        return a.B(sbU, this.numIncomingCalls, ")");
    }
}
