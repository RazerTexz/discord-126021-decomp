package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.message.Message;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: BotUiComponentEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class BotUiComponentEntry extends ChatListEntry {
    private final long applicationId;
    private final Long guildId;
    private final String key;
    private final Message message;
    private final List<MessageComponent> messageComponents;
    private final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public BotUiComponentEntry(Message message, long j, Long l, List<? extends MessageComponent> list) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(list, "messageComponents");
        this.message = message;
        this.applicationId = j;
        this.guildId = l;
        this.messageComponents = list;
        this.type = 36;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(" -- ");
        Object nonce = message.getNonce();
        sb.append(nonce == null ? Long.valueOf(message.getId()) : nonce);
        this.key = sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BotUiComponentEntry copy$default(BotUiComponentEntry botUiComponentEntry, Message message, long j, Long l, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            message = botUiComponentEntry.message;
        }
        if ((i & 2) != 0) {
            j = botUiComponentEntry.applicationId;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            l = botUiComponentEntry.guildId;
        }
        Long l2 = l;
        if ((i & 8) != 0) {
            list = botUiComponentEntry.messageComponents;
        }
        return botUiComponentEntry.copy(message, j2, l2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public final List<MessageComponent> component4() {
        return this.messageComponents;
    }

    public final BotUiComponentEntry copy(Message message, long applicationId, Long guildId, List<? extends MessageComponent> messageComponents) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(messageComponents, "messageComponents");
        return new BotUiComponentEntry(message, applicationId, guildId, messageComponents);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BotUiComponentEntry)) {
            return false;
        }
        BotUiComponentEntry botUiComponentEntry = (BotUiComponentEntry) other;
        return Intrinsics3.areEqual(this.message, botUiComponentEntry.message) && this.applicationId == botUiComponentEntry.applicationId && Intrinsics3.areEqual(this.guildId, botUiComponentEntry.guildId) && Intrinsics3.areEqual(this.messageComponents, botUiComponentEntry.messageComponents);
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final List<MessageComponent> getMessageComponents() {
        return this.messageComponents;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Message message = this.message;
        int iA = (b.a(this.applicationId) + ((message != null ? message.hashCode() : 0) * 31)) * 31;
        Long l = this.guildId;
        int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
        List<MessageComponent> list = this.messageComponents;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("BotUiComponentEntry(message=");
        sbU.append(this.message);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", messageComponents=");
        return outline.L(sbU, this.messageComponents, ")");
    }
}
