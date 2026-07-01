package com.discord.widgets.chat.input;

import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MessageDraftsRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageDraftsRepo {
    private final HashMap<Long, CharSequence> textChannelInput;

    private MessageDraftsRepo() {
        this.textChannelInput = new HashMap<>();
    }

    @MainThread
    public final CharSequence getTextChannelInput(long channelId) {
        return this.textChannelInput.get(Long.valueOf(channelId));
    }

    @MainThread
    public final void setTextChannelInput(long channelId, CharSequence text) {
        if (text != null) {
            if (!(text.length() == 0)) {
                this.textChannelInput.put(Long.valueOf(channelId), text);
                return;
            }
        }
        this.textChannelInput.remove(Long.valueOf(channelId));
    }

    public /* synthetic */ MessageDraftsRepo(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
