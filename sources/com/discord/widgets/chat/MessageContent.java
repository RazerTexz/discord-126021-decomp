package com.discord.widgets.chat;

import b.d.b.a.outline;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: MessageContent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MessageContent {
    private final List<User> mentionedUsers;
    private final String textContent;

    /* JADX WARN: Multi-variable type inference failed */
    public MessageContent(String str, List<? extends User> list) {
        Intrinsics3.checkNotNullParameter(str, "textContent");
        Intrinsics3.checkNotNullParameter(list, "mentionedUsers");
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
        Intrinsics3.checkNotNullParameter(textContent, "textContent");
        Intrinsics3.checkNotNullParameter(mentionedUsers, "mentionedUsers");
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
        return Intrinsics3.areEqual(this.textContent, messageContent.textContent) && Intrinsics3.areEqual(this.mentionedUsers, messageContent.mentionedUsers);
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
        StringBuilder sbU = outline.U("MessageContent(textContent=");
        sbU.append(this.textContent);
        sbU.append(", mentionedUsers=");
        return outline.L(sbU, this.mentionedUsers, ")");
    }
}
