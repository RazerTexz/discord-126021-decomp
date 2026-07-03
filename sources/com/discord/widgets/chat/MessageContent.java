package com.discord.widgets.chat;

import com.discord.models.user.User;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MessageContent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MessageContent {
    private final List<User> mentionedUsers;
    private final String textContent;

    /* JADX WARN: Multi-variable type inference failed */
    public MessageContent(String str, List<? extends User> list) {
        C12238m.checkNotNullParameter(str, "textContent");
        C12238m.checkNotNullParameter(list, "mentionedUsers");
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
        C12238m.checkNotNullParameter(textContent, "textContent");
        C12238m.checkNotNullParameter(mentionedUsers, "mentionedUsers");
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
        return C12238m.areEqual(this.textContent, messageContent.textContent) && C12238m.areEqual(this.mentionedUsers, messageContent.mentionedUsers);
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
        StringBuilder sbM833U = C1643a.m833U("MessageContent(textContent=");
        sbM833U.append(this.textContent);
        sbM833U.append(", mentionedUsers=");
        return C1643a.m824L(sbM833U, this.mentionedUsers, ")");
    }
}
