package com.discord.models.domain;

import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StreamDelete {
    private final Reason reason;
    private final String streamKey;
    private final boolean unavailable;

    /* JADX INFO: compiled from: ModelApplicationStream.kt */
    public static final class Parser implements Model.Parser<StreamDelete> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:21:0x005f  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public StreamDelete parse(final Model.JsonReader reader) throws IOException {
            Reason reason;
            final Ref$ObjectRef ref$ObjectRefM844c0 = C1643a.m844c0(reader, "reader");
            ref$ObjectRefM844c0.element = null;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.StreamDelete$Parser$parse$1
                @Override // p658rx.functions.Action1
                public final void call(String str) throws IOException {
                    if (str != null) {
                        int iHashCode = str.hashCode();
                        if (iHashCode != -1194435296) {
                            if (iHashCode != -934964668) {
                                if (iHashCode == -665462704 && str.equals("unavailable")) {
                                    ref$ObjectRef2.element = (T) reader.nextBooleanOrNull();
                                    return;
                                }
                            } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_REASON)) {
                                ref$ObjectRef.element = (T) reader.nextStringOrNull();
                                return;
                            }
                        } else if (str.equals("stream_key")) {
                            Ref$ObjectRef ref$ObjectRef3 = ref$ObjectRefM844c0;
                            T t = (T) reader.nextStringOrNull();
                            C12238m.checkNotNull(t);
                            ref$ObjectRef3.element = t;
                            return;
                        }
                    }
                    reader.skipValue();
                }
            });
            String str = (String) ref$ObjectRef.element;
            if (str != null) {
                int iHashCode = str.hashCode();
                if (iHashCode != -2033943558) {
                    if (iHashCode != 620910836) {
                        if (iHashCode == 1627077614 && str.equals("stream_full")) {
                            reason = Reason.STREAM_FULL;
                        } else {
                            reason = Reason.UNKNOWN;
                        }
                    } else if (str.equals("unauthorized")) {
                        reason = Reason.UNAUTHORIZED;
                    } else {
                        reason = Reason.UNKNOWN;
                    }
                } else if (str.equals("user_requested")) {
                    reason = Reason.USER_REQUESTED;
                } else {
                    reason = Reason.UNKNOWN;
                }
            } else {
                reason = Reason.UNKNOWN;
            }
            T t = ref$ObjectRefM844c0.element;
            if (t == 0) {
                C12238m.throwUninitializedPropertyAccessException("streamKey");
            }
            String str2 = (String) t;
            Boolean bool = (Boolean) ref$ObjectRef2.element;
            return new StreamDelete(str2, reason, bool != null ? bool.booleanValue() : false);
        }
    }

    /* JADX INFO: compiled from: ModelApplicationStream.kt */
    public enum Reason {
        USER_REQUESTED,
        STREAM_FULL,
        UNAUTHORIZED,
        UNKNOWN
    }

    public StreamDelete(String str, Reason reason, boolean z2) {
        C12238m.checkNotNullParameter(str, "streamKey");
        C12238m.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        this.streamKey = str;
        this.reason = reason;
        this.unavailable = z2;
    }

    public static /* synthetic */ StreamDelete copy$default(StreamDelete streamDelete, String str, Reason reason, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = streamDelete.streamKey;
        }
        if ((i & 2) != 0) {
            reason = streamDelete.reason;
        }
        if ((i & 4) != 0) {
            z2 = streamDelete.unavailable;
        }
        return streamDelete.copy(str, reason, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStreamKey() {
        return this.streamKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Reason getReason() {
        return this.reason;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getUnavailable() {
        return this.unavailable;
    }

    public final StreamDelete copy(String streamKey, Reason reason, boolean unavailable) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        C12238m.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        return new StreamDelete(streamKey, reason, unavailable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamDelete)) {
            return false;
        }
        StreamDelete streamDelete = (StreamDelete) other;
        return C12238m.areEqual(this.streamKey, streamDelete.streamKey) && C12238m.areEqual(this.reason, streamDelete.reason) && this.unavailable == streamDelete.unavailable;
    }

    public final Reason getReason() {
        return this.reason;
    }

    public final String getStreamKey() {
        return this.streamKey;
    }

    public final boolean getUnavailable() {
        return this.unavailable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.streamKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Reason reason = this.reason;
        int iHashCode2 = (iHashCode + (reason != null ? reason.hashCode() : 0)) * 31;
        boolean z2 = this.unavailable;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("StreamDelete(streamKey=");
        sbM833U.append(this.streamKey);
        sbM833U.append(", reason=");
        sbM833U.append(this.reason);
        sbM833U.append(", unavailable=");
        return C1643a.m827O(sbM833U, this.unavailable, ")");
    }
}
