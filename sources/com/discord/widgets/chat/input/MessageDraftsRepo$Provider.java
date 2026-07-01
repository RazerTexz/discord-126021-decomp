package com.discord.widgets.chat.input;

import d0.g;
import kotlin.Lazy;

/* JADX INFO: compiled from: MessageDraftsRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageDraftsRepo$Provider {
    public static final MessageDraftsRepo$Provider INSTANCE = new MessageDraftsRepo$Provider();

    /* JADX INFO: renamed from: MESSAGE_DRAFTS_REPO_INSTANCE$delegate, reason: from kotlin metadata */
    private static final Lazy MESSAGE_DRAFTS_REPO_INSTANCE = g.lazy(MessageDraftsRepo$Provider$MESSAGE_DRAFTS_REPO_INSTANCE$2.INSTANCE);

    private MessageDraftsRepo$Provider() {
    }

    private final MessageDraftsRepo getMESSAGE_DRAFTS_REPO_INSTANCE() {
        return (MessageDraftsRepo) MESSAGE_DRAFTS_REPO_INSTANCE.getValue();
    }

    public final MessageDraftsRepo get() {
        return getMESSAGE_DRAFTS_REPO_INSTANCE();
    }
}
