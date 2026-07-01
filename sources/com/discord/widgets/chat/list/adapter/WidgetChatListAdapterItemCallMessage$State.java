package com.discord.widgets.chat.list.adapter;

import b.d.b.a.a;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.widgets.chat.list.entries.MessageEntry;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListAdapterItemCallMessage$State {
    private final MessageEntry messageEntry;
    private final Map<Long, StoreVoiceParticipants$VoiceUser> voiceParticipants;

    public WidgetChatListAdapterItemCallMessage$State(Map<Long, StoreVoiceParticipants$VoiceUser> map, MessageEntry messageEntry) {
        m.checkNotNullParameter(map, "voiceParticipants");
        m.checkNotNullParameter(messageEntry, "messageEntry");
        this.voiceParticipants = map;
        this.messageEntry = messageEntry;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChatListAdapterItemCallMessage$State copy$default(WidgetChatListAdapterItemCallMessage$State widgetChatListAdapterItemCallMessage$State, Map map, MessageEntry messageEntry, int i, Object obj) {
        if ((i & 1) != 0) {
            map = widgetChatListAdapterItemCallMessage$State.voiceParticipants;
        }
        if ((i & 2) != 0) {
            messageEntry = widgetChatListAdapterItemCallMessage$State.messageEntry;
        }
        return widgetChatListAdapterItemCallMessage$State.copy(map, messageEntry);
    }

    public final Map<Long, StoreVoiceParticipants$VoiceUser> component1() {
        return this.voiceParticipants;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MessageEntry getMessageEntry() {
        return this.messageEntry;
    }

    public final WidgetChatListAdapterItemCallMessage$State copy(Map<Long, StoreVoiceParticipants$VoiceUser> voiceParticipants, MessageEntry messageEntry) {
        m.checkNotNullParameter(voiceParticipants, "voiceParticipants");
        m.checkNotNullParameter(messageEntry, "messageEntry");
        return new WidgetChatListAdapterItemCallMessage$State(voiceParticipants, messageEntry);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListAdapterItemCallMessage$State)) {
            return false;
        }
        WidgetChatListAdapterItemCallMessage$State widgetChatListAdapterItemCallMessage$State = (WidgetChatListAdapterItemCallMessage$State) other;
        return m.areEqual(this.voiceParticipants, widgetChatListAdapterItemCallMessage$State.voiceParticipants) && m.areEqual(this.messageEntry, widgetChatListAdapterItemCallMessage$State.messageEntry);
    }

    public final MessageEntry getMessageEntry() {
        return this.messageEntry;
    }

    public final Map<Long, StoreVoiceParticipants$VoiceUser> getVoiceParticipants() {
        return this.voiceParticipants;
    }

    public int hashCode() {
        Map<Long, StoreVoiceParticipants$VoiceUser> map = this.voiceParticipants;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        MessageEntry messageEntry = this.messageEntry;
        return iHashCode + (messageEntry != null ? messageEntry.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("State(voiceParticipants=");
        sbU.append(this.voiceParticipants);
        sbU.append(", messageEntry=");
        sbU.append(this.messageEntry);
        sbU.append(")");
        return sbU.toString();
    }
}
