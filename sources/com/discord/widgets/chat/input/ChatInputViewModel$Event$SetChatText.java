package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChatInputViewModel$Event$SetChatText extends ChatInputViewModel$Event {
    private final String text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$Event$SetChatText(String str) {
        super(null);
        m.checkNotNullParameter(str, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        this.text = str;
    }

    public static /* synthetic */ ChatInputViewModel$Event$SetChatText copy$default(ChatInputViewModel$Event$SetChatText chatInputViewModel$Event$SetChatText, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chatInputViewModel$Event$SetChatText.text;
        }
        return chatInputViewModel$Event$SetChatText.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final ChatInputViewModel$Event$SetChatText copy(String text) {
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        return new ChatInputViewModel$Event$SetChatText(text);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ChatInputViewModel$Event$SetChatText) && m.areEqual(this.text, ((ChatInputViewModel$Event$SetChatText) other).text);
        }
        return true;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("SetChatText(text="), this.text, ")");
    }
}
