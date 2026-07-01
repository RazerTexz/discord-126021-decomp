package com.discord.models.domain;

import b.d.b.a.a;
import d0.t.n;
import d0.z.d.m;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StreamCreateOrUpdate$Parser implements Model$Parser<StreamCreateOrUpdate> {
    public static final StreamCreateOrUpdate$Parser INSTANCE = new StreamCreateOrUpdate$Parser();

    private StreamCreateOrUpdate$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ StreamCreateOrUpdate parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public StreamCreateOrUpdate parse(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
        ref$ObjectRefC0.element = null;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = false;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = null;
        reader.nextObject(new StreamCreateOrUpdate$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef, ref$BooleanRef, ref$ObjectRef2));
        T t = ref$ObjectRefC0.element;
        if (t == 0) {
            m.throwUninitializedPropertyAccessException("streamKey");
        }
        String str = (String) t;
        String str2 = (String) ref$ObjectRef.element;
        boolean z2 = ref$BooleanRef.element;
        List listEmptyList = (List) ref$ObjectRef2.element;
        if (listEmptyList == null) {
            listEmptyList = n.emptyList();
        }
        return new StreamCreateOrUpdate(str, str2, z2, listEmptyList);
    }
}
