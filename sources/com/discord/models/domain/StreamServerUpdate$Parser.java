package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StreamServerUpdate$Parser implements Model$Parser<StreamServerUpdate> {
    public static final StreamServerUpdate$Parser INSTANCE = new StreamServerUpdate$Parser();

    private StreamServerUpdate$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ StreamServerUpdate parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public StreamServerUpdate parse(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
        ref$ObjectRefC0.element = null;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = null;
        reader.nextObject(new StreamServerUpdate$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef2));
        T t = ref$ObjectRefC0.element;
        if (t == 0) {
            m.throwUninitializedPropertyAccessException("streamKey");
        }
        return new StreamServerUpdate((String) t, (String) ref$ObjectRef.element, (String) ref$ObjectRef2.element);
    }
}
