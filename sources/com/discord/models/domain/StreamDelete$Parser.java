package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StreamDelete$Parser implements Model$Parser<StreamDelete> {
    public static final StreamDelete$Parser INSTANCE = new StreamDelete$Parser();

    private StreamDelete$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ StreamDelete parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code duplicated, block: B:21:0x005f  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public StreamDelete parse(Model$JsonReader reader) throws IOException {
        StreamDelete$Reason streamDelete$Reason;
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
        ref$ObjectRefC0.element = null;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = null;
        reader.nextObject(new StreamDelete$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef2));
        String str = (String) ref$ObjectRef.element;
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -2033943558) {
                if (iHashCode != 620910836) {
                    if (iHashCode == 1627077614 && str.equals("stream_full")) {
                        streamDelete$Reason = StreamDelete$Reason.STREAM_FULL;
                    } else {
                        streamDelete$Reason = StreamDelete$Reason.UNKNOWN;
                    }
                } else if (str.equals("unauthorized")) {
                    streamDelete$Reason = StreamDelete$Reason.UNAUTHORIZED;
                } else {
                    streamDelete$Reason = StreamDelete$Reason.UNKNOWN;
                }
            } else if (str.equals("user_requested")) {
                streamDelete$Reason = StreamDelete$Reason.USER_REQUESTED;
            } else {
                streamDelete$Reason = StreamDelete$Reason.UNKNOWN;
            }
        } else {
            streamDelete$Reason = StreamDelete$Reason.UNKNOWN;
        }
        T t = ref$ObjectRefC0.element;
        if (t == 0) {
            m.throwUninitializedPropertyAccessException("streamKey");
        }
        String str2 = (String) t;
        Boolean bool = (Boolean) ref$ObjectRef2.element;
        return new StreamDelete(str2, streamDelete$Reason, bool != null ? bool.booleanValue() : false);
    }
}
