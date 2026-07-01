package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: renamed from: com.discord.models.domain.StreamCreateOrUpdate, reason: use source file name */
/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelApplicationStream3 {
    private final boolean paused;
    private final String rtcServerId;
    private final String streamKey;
    private final List<Long> viewerIds;

    /* JADX INFO: renamed from: com.discord.models.domain.StreamCreateOrUpdate$Parser */
    /* JADX INFO: compiled from: ModelApplicationStream.kt */
    public static final class Parser implements Model.Parser<ModelApplicationStream3> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelApplicationStream3 parse(final Model.JsonReader reader) throws IOException {
            final Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            ref$BooleanRef.element = false;
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.StreamCreateOrUpdate$Parser$parse$1
                /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                @Override // rx.functions.Action1
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
                                    Ref$ObjectRef ref$ObjectRef3 = ref$ObjectRefC0;
                                    T t = (T) reader.nextStringOrNull();
                                    Intrinsics3.checkNotNull(t);
                                    ref$ObjectRef3.element = t;
                                    return;
                                }
                                break;
                            case -995321554:
                                if (str.equals("paused")) {
                                    Ref$BooleanRef ref$BooleanRef2 = ref$BooleanRef;
                                    Boolean boolNextBooleanOrNull = reader.nextBooleanOrNull();
                                    Intrinsics3.checkNotNullExpressionValue(boolNextBooleanOrNull, "reader.nextBooleanOrNull()");
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
            T t = ref$ObjectRefC0.element;
            if (t == 0) {
                Intrinsics3.throwUninitializedPropertyAccessException("streamKey");
            }
            String str = (String) t;
            String str2 = (String) ref$ObjectRef.element;
            boolean z2 = ref$BooleanRef.element;
            List listEmptyList = (List) ref$ObjectRef2.element;
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            return new ModelApplicationStream3(str, str2, z2, listEmptyList);
        }
    }

    public ModelApplicationStream3(String str, String str2, boolean z2, List<Long> list) {
        Intrinsics3.checkNotNullParameter(str, "streamKey");
        Intrinsics3.checkNotNullParameter(list, "viewerIds");
        this.streamKey = str;
        this.rtcServerId = str2;
        this.paused = z2;
        this.viewerIds = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelApplicationStream3 copy$default(ModelApplicationStream3 modelApplicationStream3, String str, String str2, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelApplicationStream3.streamKey;
        }
        if ((i & 2) != 0) {
            str2 = modelApplicationStream3.rtcServerId;
        }
        if ((i & 4) != 0) {
            z2 = modelApplicationStream3.paused;
        }
        if ((i & 8) != 0) {
            list = modelApplicationStream3.viewerIds;
        }
        return modelApplicationStream3.copy(str, str2, z2, list);
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

    public final ModelApplicationStream3 copy(String streamKey, String rtcServerId, boolean paused, List<Long> viewerIds) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        Intrinsics3.checkNotNullParameter(viewerIds, "viewerIds");
        return new ModelApplicationStream3(streamKey, rtcServerId, paused, viewerIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelApplicationStream3)) {
            return false;
        }
        ModelApplicationStream3 modelApplicationStream3 = (ModelApplicationStream3) other;
        return Intrinsics3.areEqual(this.streamKey, modelApplicationStream3.streamKey) && Intrinsics3.areEqual(this.rtcServerId, modelApplicationStream3.rtcServerId) && this.paused == modelApplicationStream3.paused && Intrinsics3.areEqual(this.viewerIds, modelApplicationStream3.viewerIds);
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
        StringBuilder sbU = outline.U("StreamCreateOrUpdate(streamKey=");
        sbU.append(this.streamKey);
        sbU.append(", rtcServerId=");
        sbU.append(this.rtcServerId);
        sbU.append(", paused=");
        sbU.append(this.paused);
        sbU.append(", viewerIds=");
        return outline.L(sbU, this.viewerIds, ")");
    }
}
