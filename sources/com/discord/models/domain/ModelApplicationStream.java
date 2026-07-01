package com.discord.models.domain;

import d0.g;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class ModelApplicationStream implements Serializable {
    public static final ModelApplicationStream$Companion Companion = new ModelApplicationStream$Companion(null);
    private final long channelId;

    /* JADX INFO: renamed from: encodedStreamKey$delegate, reason: from kotlin metadata */
    private final Lazy encodedStreamKey;
    private final long ownerId;

    private ModelApplicationStream(long j, long j2) {
        this.channelId = j;
        this.ownerId = j2;
        this.encodedStreamKey = g.lazy(new ModelApplicationStream$encodedStreamKey$2(this));
    }

    public abstract String encodeStreamKey();

    public long getChannelId() {
        return this.channelId;
    }

    public final String getEncodedStreamKey() {
        return (String) this.encodedStreamKey.getValue();
    }

    public long getOwnerId() {
        return this.ownerId;
    }

    public abstract String getType();

    public /* synthetic */ ModelApplicationStream(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }
}
