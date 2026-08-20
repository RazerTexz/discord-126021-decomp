package com.discord.models.domain;

import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StreamServerUpdate {
    private final String endpoint;
    private final String streamKey;
    private final String token;

    /* JADX INFO: compiled from: ModelApplicationStream.kt */
    public static final class Parser implements Model.Parser<StreamServerUpdate> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public StreamServerUpdate parse(final Model.JsonReader reader) throws IOException {
            final Ref$ObjectRef ref$ObjectRefM844c0 = C1643a.m844c0(reader, "reader");
            ref$ObjectRefM844c0.element = null;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.StreamServerUpdate$Parser$parse$1
                @Override // p658rx.functions.Action1
                public final void call(String str) throws IOException {
                    if (str != null) {
                        int iHashCode = str.hashCode();
                        if (iHashCode != -1194435296) {
                            if (iHashCode != 110541305) {
                                if (iHashCode == 1741102485 && str.equals("endpoint")) {
                                    ref$ObjectRef.element = (T) reader.nextStringOrNull();
                                    return;
                                }
                            } else if (str.equals("token")) {
                                ref$ObjectRef2.element = (T) reader.nextStringOrNull();
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
            T t = ref$ObjectRefM844c0.element;
            if (t == 0) {
                C12238m.throwUninitializedPropertyAccessException("streamKey");
            }
            return new StreamServerUpdate((String) t, (String) ref$ObjectRef.element, (String) ref$ObjectRef2.element);
        }
    }

    public StreamServerUpdate(String str, String str2, String str3) {
        C12238m.checkNotNullParameter(str, "streamKey");
        this.streamKey = str;
        this.endpoint = str2;
        this.token = str3;
    }

    public static /* synthetic */ StreamServerUpdate copy$default(StreamServerUpdate streamServerUpdate, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = streamServerUpdate.streamKey;
        }
        if ((i & 2) != 0) {
            str2 = streamServerUpdate.endpoint;
        }
        if ((i & 4) != 0) {
            str3 = streamServerUpdate.token;
        }
        return streamServerUpdate.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStreamKey() {
        return this.streamKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEndpoint() {
        return this.endpoint;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final StreamServerUpdate copy(String streamKey, String endpoint, String token) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        return new StreamServerUpdate(streamKey, endpoint, token);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamServerUpdate)) {
            return false;
        }
        StreamServerUpdate streamServerUpdate = (StreamServerUpdate) other;
        return C12238m.areEqual(this.streamKey, streamServerUpdate.streamKey) && C12238m.areEqual(this.endpoint, streamServerUpdate.endpoint) && C12238m.areEqual(this.token, streamServerUpdate.token);
    }

    public final String getEndpoint() {
        return this.endpoint;
    }

    public final String getStreamKey() {
        return this.streamKey;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        String str = this.streamKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.endpoint;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.token;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("StreamServerUpdate(streamKey=");
        sbM833U.append(this.streamKey);
        sbM833U.append(", endpoint=");
        sbM833U.append(this.endpoint);
        sbM833U.append(", token=");
        return C1643a.m822J(sbM833U, this.token, ")");
    }
}
