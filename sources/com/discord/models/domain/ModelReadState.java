package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelReadState.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelReadState {
    private final long channelId;
    private final long lastMessageId;
    private final int mentionCount;
    private final int version;

    /* JADX INFO: compiled from: ModelReadState.kt */
    public static final class Parser implements Model.Parser<ModelReadState> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.Parser
        public ModelReadState parse(final Model.JsonReader reader) throws IOException {
            Intrinsics3.checkNotNullParameter(reader, "reader");
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = 0;
            final Ref$LongRef ref$LongRef = new Ref$LongRef();
            ref$LongRef.element = 0L;
            final Ref$LongRef ref$LongRef2 = new Ref$LongRef();
            ref$LongRef2.element = 0L;
            final Ref$LongRef ref$LongRef3 = new Ref$LongRef();
            ref$LongRef3.element = 0L;
            final Ref$LongRef ref$LongRef4 = new Ref$LongRef();
            ref$LongRef4.element = 0L;
            final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
            ref$IntRef2.element = 0;
            reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.ModelReadState$Parser$parse$1
                /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                @Override // rx.functions.Action1
                public final void call(String str) throws IOException {
                    if (str != null) {
                        switch (str.hashCode()) {
                            case -1930808873:
                                if (str.equals(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID)) {
                                    Ref$LongRef ref$LongRef5 = ref$LongRef4;
                                    ref$LongRef5.element = reader.nextLong(ref$LongRef5.element);
                                    return;
                                }
                                break;
                            case -1690722221:
                                if (str.equals("message_id")) {
                                    Ref$LongRef ref$LongRef6 = ref$LongRef2;
                                    ref$LongRef6.element = reader.nextLong(ref$LongRef6.element);
                                    return;
                                }
                                break;
                            case -83031652:
                                if (str.equals("last_message_id")) {
                                    Ref$LongRef ref$LongRef7 = ref$LongRef;
                                    ref$LongRef7.element = reader.nextLong(ref$LongRef7.element);
                                    return;
                                }
                                break;
                            case 3355:
                                if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                                    ref$LongRef3.element = reader.nextLong(0L);
                                    return;
                                }
                                break;
                            case 351608024:
                                if (str.equals("version")) {
                                    Ref$IntRef ref$IntRef3 = ref$IntRef2;
                                    ref$IntRef3.element = reader.nextInt(ref$IntRef3.element);
                                    return;
                                }
                                break;
                            case 2144418426:
                                if (str.equals("mention_count")) {
                                    Ref$IntRef ref$IntRef4 = ref$IntRef;
                                    ref$IntRef4.element = reader.nextInt(ref$IntRef4.element);
                                    return;
                                }
                                break;
                        }
                    }
                    reader.skipValue();
                }
            });
            return new ModelReadState(ref$LongRef3.element, ref$LongRef4.element, ref$LongRef.element, ref$LongRef2.element, ref$IntRef.element, ref$IntRef2.element, null);
        }
    }

    public ModelReadState(long j, long j2, int i, int i2) {
        this.channelId = j;
        this.lastMessageId = j2;
        this.mentionCount = i;
        this.version = i2;
    }

    public static /* synthetic */ ModelReadState copy$default(ModelReadState modelReadState, long j, long j2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = modelReadState.channelId;
        }
        long j3 = j;
        if ((i3 & 2) != 0) {
            j2 = modelReadState.lastMessageId;
        }
        long j4 = j2;
        if ((i3 & 4) != 0) {
            i = modelReadState.mentionCount;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = modelReadState.version;
        }
        return modelReadState.copy(j3, j4, i4, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getLastMessageId() {
        return this.lastMessageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMentionCount() {
        return this.mentionCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final ModelReadState copy(long channelId, long lastMessageId, int mentionCount, int version) {
        return new ModelReadState(channelId, lastMessageId, mentionCount, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelReadState)) {
            return false;
        }
        ModelReadState modelReadState = (ModelReadState) other;
        return this.channelId == modelReadState.channelId && this.lastMessageId == modelReadState.lastMessageId && this.mentionCount == modelReadState.mentionCount && this.version == modelReadState.version;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getLastMessageId() {
        return this.lastMessageId;
    }

    public final int getMentionCount() {
        return this.mentionCount;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        long j = this.channelId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.lastMessageId;
        return ((((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.mentionCount) * 31) + this.version;
    }

    public final boolean isMentioned() {
        return this.mentionCount > 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelReadState(channelId=");
        sbU.append(this.channelId);
        sbU.append(", lastMessageId=");
        sbU.append(this.lastMessageId);
        sbU.append(", mentionCount=");
        sbU.append(this.mentionCount);
        sbU.append(", version=");
        return outline.B(sbU, this.version, ")");
    }

    public /* synthetic */ ModelReadState(long j, long j2, long j3, long j4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, i, i2);
    }

    public /* synthetic */ ModelReadState(long j, long j2, long j3, long j4, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i3 & 4) != 0 ? 0L : j3, (i3 & 8) != 0 ? 0L : j4, i, i2);
    }

    private ModelReadState(long j, long j2, long j3, long j4, int i, int i2) {
        this(j2 != 0 ? j2 : j, j3 != 0 ? j3 : j4, i, i2);
    }
}
