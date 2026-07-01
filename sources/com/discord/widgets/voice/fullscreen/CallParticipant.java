package com.discord.widgets.voice.fullscreen;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CallParticipant.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class CallParticipant {
    private CallParticipant() {
    }

    public abstract String getId();

    public abstract boolean hasActiveVideo();

    public /* synthetic */ CallParticipant(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
