package com.discord.widgets.chat;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.utilities.messagesend.MessageResult;
import d0.z.d.m;

/* JADX INFO: compiled from: MessageManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MessageManager$MessageSendResult {
    private final Guild guild;
    private final MessageResult messageResult;

    public MessageManager$MessageSendResult(MessageResult messageResult, Guild guild) {
        m.checkNotNullParameter(messageResult, "messageResult");
        this.messageResult = messageResult;
        this.guild = guild;
    }

    public static /* synthetic */ MessageManager$MessageSendResult copy$default(MessageManager$MessageSendResult messageManager$MessageSendResult, MessageResult messageResult, Guild guild, int i, Object obj) {
        if ((i & 1) != 0) {
            messageResult = messageManager$MessageSendResult.messageResult;
        }
        if ((i & 2) != 0) {
            guild = messageManager$MessageSendResult.guild;
        }
        return messageManager$MessageSendResult.copy(messageResult, guild);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MessageResult getMessageResult() {
        return this.messageResult;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final MessageManager$MessageSendResult copy(MessageResult messageResult, Guild guild) {
        m.checkNotNullParameter(messageResult, "messageResult");
        return new MessageManager$MessageSendResult(messageResult, guild);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageManager$MessageSendResult)) {
            return false;
        }
        MessageManager$MessageSendResult messageManager$MessageSendResult = (MessageManager$MessageSendResult) other;
        return m.areEqual(this.messageResult, messageManager$MessageSendResult.messageResult) && m.areEqual(this.guild, messageManager$MessageSendResult.guild);
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final MessageResult getMessageResult() {
        return this.messageResult;
    }

    public int hashCode() {
        MessageResult messageResult = this.messageResult;
        int iHashCode = (messageResult != null ? messageResult.hashCode() : 0) * 31;
        Guild guild = this.guild;
        return iHashCode + (guild != null ? guild.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("MessageSendResult(messageResult=");
        sbU.append(this.messageResult);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(")");
        return sbU.toString();
    }
}
