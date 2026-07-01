package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: renamed from: com.discord.models.domain.StreamServerUpdate, reason: use source file name */
/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelApplicationStream7 {
    private final String endpoint;
    private final String streamKey;
    private final String token;

    /* JADX INFO: renamed from: com.discord.models.domain.StreamServerUpdate$Parser */
    /* JADX INFO: compiled from: ModelApplicationStream.kt */
    public static final class Parser implements Model.Parser<ModelApplicationStream7> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelApplicationStream7 parse(final Model.JsonReader reader) throws IOException {
            final Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.StreamServerUpdate$Parser$parse$1
                @Override // rx.functions.Action1
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
                            Ref$ObjectRef ref$ObjectRef3 = ref$ObjectRefC0;
                            T t = (T) reader.nextStringOrNull();
                            Intrinsics3.checkNotNull(t);
                            ref$ObjectRef3.element = t;
                            return;
                        }
                    }
                    reader.skipValue();
                }
            });
            T t = ref$ObjectRefC0.element;
            if (t == 0) {
                Intrinsics3.throwUninitializedPropertyAccessException("streamKey");
            }
            return new ModelApplicationStream7((String) t, (String) ref$ObjectRef.element, (String) ref$ObjectRef2.element);
        }
    }

    public ModelApplicationStream7(String str, String str2, String str3) {
        Intrinsics3.checkNotNullParameter(str, "streamKey");
        this.streamKey = str;
        this.endpoint = str2;
        this.token = str3;
    }

    public static /* synthetic */ ModelApplicationStream7 copy$default(ModelApplicationStream7 modelApplicationStream7, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelApplicationStream7.streamKey;
        }
        if ((i & 2) != 0) {
            str2 = modelApplicationStream7.endpoint;
        }
        if ((i & 4) != 0) {
            str3 = modelApplicationStream7.token;
        }
        return modelApplicationStream7.copy(str, str2, str3);
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

    public final ModelApplicationStream7 copy(String streamKey, String endpoint, String token) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        return new ModelApplicationStream7(streamKey, endpoint, token);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelApplicationStream7)) {
            return false;
        }
        ModelApplicationStream7 modelApplicationStream7 = (ModelApplicationStream7) other;
        return Intrinsics3.areEqual(this.streamKey, modelApplicationStream7.streamKey) && Intrinsics3.areEqual(this.endpoint, modelApplicationStream7.endpoint) && Intrinsics3.areEqual(this.token, modelApplicationStream7.token);
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
        StringBuilder sbU = outline.U("StreamServerUpdate(streamKey=");
        sbU.append(this.streamKey);
        sbU.append(", endpoint=");
        sbU.append(this.endpoint);
        sbU.append(", token=");
        return outline.J(sbU, this.token, ")");
    }
}
