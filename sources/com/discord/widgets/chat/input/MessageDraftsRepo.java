package com.discord.widgets.chat.input;

import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import d0.LazyJVM;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MessageDraftsRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageDraftsRepo {
    private final HashMap<Long, CharSequence> textChannelInput;

    /* JADX INFO: compiled from: MessageDraftsRepo.kt */
    public static final class Provider {
        public static final Provider INSTANCE = new Provider();

        /* JADX INFO: renamed from: MESSAGE_DRAFTS_REPO_INSTANCE$delegate, reason: from kotlin metadata */
        private static final Lazy MESSAGE_DRAFTS_REPO_INSTANCE = LazyJVM.lazy(MessageDraftsRepo2.INSTANCE);

        private Provider() {
        }

        private final MessageDraftsRepo getMESSAGE_DRAFTS_REPO_INSTANCE() {
            return (MessageDraftsRepo) MESSAGE_DRAFTS_REPO_INSTANCE.getValue();
        }

        public final MessageDraftsRepo get() {
            return getMESSAGE_DRAFTS_REPO_INSTANCE();
        }
    }

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
