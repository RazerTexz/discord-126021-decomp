package com.discord.models.domain;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StreamCreateOrUpdate {
    private final boolean paused;
    private final String rtcServerId;
    private final String streamKey;
    private final List<Long> viewerIds;

    /* JADX INFO: compiled from: ModelApplicationStream.kt */
    public static final class Parser implements Model.Parser<StreamCreateOrUpdate> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public StreamCreateOrUpdate parse(final Model.JsonReader reader) throws IOException {
            final Ref$ObjectRef ref$ObjectRefM844c0 = C1643a.m844c0(reader, "reader");
            ref$ObjectRefM844c0.element = null;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            ref$BooleanRef.element = false;
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.StreamCreateOrUpdate$Parser$parse$1
                /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                @Override // p658rx.functions.Action1
                public final void call(String str) throws IOException {
                    if (str != null) {
                        switch (str.hashCode()) {
                            case -1349214453:
                                if (str.equals("viewer_ids")) {
                                    ref$ObjectRef2.element = (T) reader.nextList(new Model.JsonReader.ItemFactory<Long>() { // from class: com.discord.models.domain.StreamCreateOrUpdate$Parser$parse$1.1
                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                                        public final Long get() {
                                            return Long.valueOf(reader.nextLong(0L));
                                        }
                                    });
                                    return;
                                }
                                break;
                            case -1194435296:
                                if (str.equals("stream_key")) {
                                    Ref$ObjectRef ref$ObjectRef3 = ref$ObjectRefM844c0;
                                    T t = (T) reader.nextStringOrNull();
                                    C12238m.checkNotNull(t);
                                    ref$ObjectRef3.element = t;
                                    return;
                                }
                                break;
                            case -995321554:
                                if (str.equals("paused")) {
                                    Ref$BooleanRef ref$BooleanRef2 = ref$BooleanRef;
                                    Boolean boolNextBooleanOrNull = reader.nextBooleanOrNull();
                                    C12238m.checkNotNullExpressionValue(boolNextBooleanOrNull, "reader.nextBooleanOrNull()");
                                    ref$BooleanRef2.element = boolNextBooleanOrNull.booleanValue();
                                    return;
                                }
                                break;
                            case -490387655:
                                if (str.equals("rtc_server_id")) {
                                    ref$ObjectRef.element = (T) reader.nextStringOrNull();
                                    return;
                                }
                                break;
                        }
                    }
                    reader.skipValue();
                }
            });
            T t = ref$ObjectRefM844c0.element;
            if (t == 0) {
                C12238m.throwUninitializedPropertyAccessException("streamKey");
            }
            String str = (String) t;
            String str2 = (String) ref$ObjectRef.element;
            boolean z2 = ref$BooleanRef.element;
            List listEmptyList = (List) ref$ObjectRef2.element;
            if (listEmptyList == null) {
                listEmptyList = C12147n.emptyList();
            }
            return new StreamCreateOrUpdate(str, str2, z2, listEmptyList);
        }
    }

    public StreamCreateOrUpdate(String str, String str2, boolean z2, List<Long> list) {
        C12238m.checkNotNullParameter(str, "streamKey");
        C12238m.checkNotNullParameter(list, "viewerIds");
        this.streamKey = str;
        this.rtcServerId = str2;
        this.paused = z2;
        this.viewerIds = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StreamCreateOrUpdate copy$default(StreamCreateOrUpdate streamCreateOrUpdate, String str, String str2, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = streamCreateOrUpdate.streamKey;
        }
        if ((i & 2) != 0) {
            str2 = streamCreateOrUpdate.rtcServerId;
        }
        if ((i & 4) != 0) {
            z2 = streamCreateOrUpdate.paused;
        }
        if ((i & 8) != 0) {
            list = streamCreateOrUpdate.viewerIds;
        }
        return streamCreateOrUpdate.copy(str, str2, z2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStreamKey() {
        return this.streamKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRtcServerId() {
        return this.rtcServerId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getPaused() {
        return this.paused;
    }

    public final List<Long> component4() {
        return this.viewerIds;
    }

    public final StreamCreateOrUpdate copy(String streamKey, String rtcServerId, boolean paused, List<Long> viewerIds) {
        C12238m.checkNotNullParameter(streamKey, "streamKey");
        C12238m.checkNotNullParameter(viewerIds, "viewerIds");
        return new StreamCreateOrUpdate(streamKey, rtcServerId, paused, viewerIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamCreateOrUpdate)) {
            return false;
        }
        StreamCreateOrUpdate streamCreateOrUpdate = (StreamCreateOrUpdate) other;
        return C12238m.areEqual(this.streamKey, streamCreateOrUpdate.streamKey) && C12238m.areEqual(this.rtcServerId, streamCreateOrUpdate.rtcServerId) && this.paused == streamCreateOrUpdate.paused && C12238m.areEqual(this.viewerIds, streamCreateOrUpdate.viewerIds);
    }

    public final boolean getPaused() {
        return this.paused;
    }

    public final String getRtcServerId() {
        return this.rtcServerId;
    }

    public final String getStreamKey() {
        return this.streamKey;
    }

    public final List<Long> getViewerIds() {
        return this.viewerIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        String str = this.streamKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.rtcServerId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.paused;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        List<Long> list = this.viewerIds;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("StreamCreateOrUpdate(streamKey=");
        sbM833U.append(this.streamKey);
        sbM833U.append(", rtcServerId=");
        sbM833U.append(this.rtcServerId);
        sbM833U.append(", paused=");
        sbM833U.append(this.paused);
        sbM833U.append(", viewerIds=");
        return C1643a.m824L(sbM833U, this.viewerIds, ")");
    }
}
