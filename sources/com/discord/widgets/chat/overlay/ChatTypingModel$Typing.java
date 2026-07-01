package com.discord.widgets.chat.overlay;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ChatTypingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChatTypingModel$Typing extends ChatTypingModel {
    private final int channelRateLimit;
    private final int cooldownSecs;
    private final List<CharSequence> typingUsers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChatTypingModel$Typing(List<? extends CharSequence> list, int i, int i2) {
        super(null);
        m.checkNotNullParameter(list, "typingUsers");
        this.typingUsers = list;
        this.channelRateLimit = i;
        this.cooldownSecs = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatTypingModel$Typing copy$default(ChatTypingModel$Typing chatTypingModel$Typing, List list, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = chatTypingModel$Typing.typingUsers;
        }
        if ((i3 & 2) != 0) {
            i = chatTypingModel$Typing.channelRateLimit;
        }
        if ((i3 & 4) != 0) {
            i2 = chatTypingModel$Typing.cooldownSecs;
        }
        return chatTypingModel$Typing.copy(list, i, i2);
    }

    public final List<CharSequence> component1() {
        return this.typingUsers;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getChannelRateLimit() {
        return this.channelRateLimit;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCooldownSecs() {
        return this.cooldownSecs;
    }

    public final ChatTypingModel$Typing copy(List<? extends CharSequence> typingUsers, int channelRateLimit, int cooldownSecs) {
        m.checkNotNullParameter(typingUsers, "typingUsers");
        return new ChatTypingModel$Typing(typingUsers, channelRateLimit, cooldownSecs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatTypingModel$Typing)) {
            return false;
        }
        ChatTypingModel$Typing chatTypingModel$Typing = (ChatTypingModel$Typing) other;
        return m.areEqual(this.typingUsers, chatTypingModel$Typing.typingUsers) && this.channelRateLimit == chatTypingModel$Typing.channelRateLimit && this.cooldownSecs == chatTypingModel$Typing.cooldownSecs;
    }

    public final int getChannelRateLimit() {
        return this.channelRateLimit;
    }

    public final int getCooldownSecs() {
        return this.cooldownSecs;
    }

    public final List<CharSequence> getTypingUsers() {
        return this.typingUsers;
    }

    public int hashCode() {
        List<CharSequence> list = this.typingUsers;
        return ((((list != null ? list.hashCode() : 0) * 31) + this.channelRateLimit) * 31) + this.cooldownSecs;
    }

    public String toString() {
        StringBuilder sbU = a.U("Typing(typingUsers=");
        sbU.append(this.typingUsers);
        sbU.append(", channelRateLimit=");
        sbU.append(this.channelRateLimit);
        sbU.append(", cooldownSecs=");
        return a.B(sbU, this.cooldownSecs, ")");
    }
}
