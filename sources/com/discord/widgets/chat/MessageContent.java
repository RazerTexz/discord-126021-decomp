package com.discord.widgets.chat;

import b.d.b.a.a;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: MessageContent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MessageContent {
    private final List<User> mentionedUsers;
    private final String textContent;

    /* JADX WARN: Multi-variable type inference failed */
    public MessageContent(String str, List<? extends User> list) {
        m.checkNotNullParameter(str, "textContent");
        m.checkNotNullParameter(list, "mentionedUsers");
        this.textContent = str;
        this.mentionedUsers = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageContent copy$default(MessageContent messageContent, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageContent.textContent;
        }
        if ((i & 2) != 0) {
            list = messageContent.mentionedUsers;
        }
        return messageContent.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTextContent() {
        return this.textContent;
    }

    public final List<User> component2() {
        return this.mentionedUsers;
    }

    public final MessageContent copy(String textContent, List<? extends User> mentionedUsers) {
        m.checkNotNullParameter(textContent, "textContent");
        m.checkNotNullParameter(mentionedUsers, "mentionedUsers");
        return new MessageContent(textContent, mentionedUsers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageContent)) {
            return false;
        }
        MessageContent messageContent = (MessageContent) other;
        return m.areEqual(this.textContent, messageContent.textContent) && m.areEqual(this.mentionedUsers, messageContent.mentionedUsers);
    }

    public final List<User> getMentionedUsers() {
        return this.mentionedUsers;
    }

    public final String getTextContent() {
        return this.textContent;
    }

    public int hashCode() {
        String str = this.textContent;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<User> list = this.mentionedUsers;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("MessageContent(textContent=");
        sbU.append(this.textContent);
        sbU.append(", mentionedUsers=");
        return a.L(sbU, this.mentionedUsers, ")");
    }
}
