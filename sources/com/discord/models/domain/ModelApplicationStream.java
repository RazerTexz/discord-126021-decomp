package com.discord.models.domain;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class ModelApplicationStream implements Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;

    /* JADX INFO: renamed from: encodedStreamKey$delegate, reason: from kotlin metadata */
    private final Lazy encodedStreamKey;
    private final long ownerId;

    /* JADX INFO: compiled from: ModelApplicationStream.kt */
    public static final /* data */ class CallStream extends ModelApplicationStream {
        private final long channelId;
        private final long ownerId;
        private final String type;

        public CallStream(long j, long j2) {
            super(j, j2, null);
            this.channelId = j;
            this.ownerId = j2;
            this.type = StreamType.CALL.getSerializedRepresentation();
        }

        public static /* synthetic */ CallStream copy$default(CallStream callStream, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = callStream.getChannelId();
            }
            if ((i & 2) != 0) {
                j2 = callStream.getOwnerId();
            }
            return callStream.copy(j, j2);
        }

        public final long component1() {
            return getChannelId();
        }

        public final long component2() {
            return getOwnerId();
        }

        public final CallStream copy(long channelId, long ownerId) {
            return new CallStream(channelId, ownerId);
        }

        @Override // com.discord.models.domain.ModelApplicationStream
        public String encodeStreamKey() {
            return StreamType.CALL.getSerializedRepresentation() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + getChannelId() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + getOwnerId();
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CallStream)) {
                return false;
            }
            CallStream callStream = (CallStream) other;
            return getChannelId() == callStream.getChannelId() && getOwnerId() == callStream.getOwnerId();
        }

        @Override // com.discord.models.domain.ModelApplicationStream
        public long getChannelId() {
            return this.channelId;
        }

        @Override // com.discord.models.domain.ModelApplicationStream
        public long getOwnerId() {
            return this.ownerId;
        }

        @Override // com.discord.models.domain.ModelApplicationStream
        public String getType() {
            return this.type;
        }

        public int hashCode() {
            long channelId = getChannelId();
            int i = ((int) (channelId ^ (channelId >>> 32))) * 31;
            long ownerId = getOwnerId();
            return i + ((int) (ownerId ^ (ownerId >>> 32)));
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("CallStream(channelId=");
            sbM833U.append(getChannelId());
            sbM833U.append(", ownerId=");
            sbM833U.append(getOwnerId());
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: ModelApplicationStream.kt */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                StreamType.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                iArr[StreamType.GUILD.ordinal()] = 1;
                iArr[StreamType.CALL.ordinal()] = 2;
            }
        }

        private Companion() {
        }

        public final ModelApplicationStream decodeStreamKey(String streamKey) {
            C12238m.checkNotNullParameter(streamKey, "streamKey");
            List listSplit$default = C12106w.split$default((CharSequence) streamKey, new String[]{":"}, false, 0, 6, (Object) null);
            int iOrdinal = StreamType.INSTANCE.fromString((String) listSplit$default.get(0)).ordinal();
            if (iOrdinal == 0) {
                return new GuildStream(Long.parseLong((String) listSplit$default.get(1)), Long.parseLong((String) listSplit$default.get(2)), Long.parseLong((String) listSplit$default.get(3)));
            }
            if (iOrdinal == 1) {
                return new CallStream(Long.parseLong((String) listSplit$default.get(1)), Long.parseLong((String) listSplit$default.get(2)));
            }
            throw new NoWhenBranchMatchedException();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ModelApplicationStream.kt */
    public static final /* data */ class GuildStream extends ModelApplicationStream {
        private final long channelId;
        private final long guildId;
        private final long ownerId;
        private final String type;

        public GuildStream(long j, long j2, long j3) {
            super(j2, j3, null);
            this.guildId = j;
            this.channelId = j2;
            this.ownerId = j3;
            this.type = StreamType.GUILD.getSerializedRepresentation();
        }

        public static /* synthetic */ GuildStream copy$default(GuildStream guildStream, long j, long j2, long j3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = guildStream.guildId;
            }
            long j4 = j;
            if ((i & 2) != 0) {
                j2 = guildStream.getChannelId();
            }
            long j5 = j2;
            if ((i & 4) != 0) {
                j3 = guildStream.getOwnerId();
            }
            return guildStream.copy(j4, j5, j3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final long component2() {
            return getChannelId();
        }

        public final long component3() {
            return getOwnerId();
        }

        public final GuildStream copy(long guildId, long channelId, long ownerId) {
            return new GuildStream(guildId, channelId, ownerId);
        }

        @Override // com.discord.models.domain.ModelApplicationStream
        public String encodeStreamKey() {
            return StreamType.GUILD.getSerializedRepresentation() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + this.guildId + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + getChannelId() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + getOwnerId();
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildStream)) {
                return false;
            }
            GuildStream guildStream = (GuildStream) other;
            return this.guildId == guildStream.guildId && getChannelId() == guildStream.getChannelId() && getOwnerId() == guildStream.getOwnerId();
        }

        @Override // com.discord.models.domain.ModelApplicationStream
        public long getChannelId() {
            return this.channelId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        @Override // com.discord.models.domain.ModelApplicationStream
        public long getOwnerId() {
            return this.ownerId;
        }

        @Override // com.discord.models.domain.ModelApplicationStream
        public String getType() {
            return this.type;
        }

        public int hashCode() {
            long j = this.guildId;
            long channelId = getChannelId();
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (channelId ^ (channelId >>> 32)))) * 31;
            long ownerId = getOwnerId();
            return i + ((int) (ownerId ^ (ownerId >>> 32)));
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("GuildStream(guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", channelId=");
            sbM833U.append(getChannelId());
            sbM833U.append(", ownerId=");
            sbM833U.append(getOwnerId());
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    private ModelApplicationStream(long j, long j2) {
        this.channelId = j;
        this.ownerId = j2;
        this.encodedStreamKey = C12083g.lazy(new ModelApplicationStream$encodedStreamKey$2(this));
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
