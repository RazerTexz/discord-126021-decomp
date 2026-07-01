package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelGuildFolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelGuildFolder$Parser implements Model$Parser<ModelGuildFolder> {
    public static final ModelGuildFolder$Parser INSTANCE = new ModelGuildFolder$Parser();

    private ModelGuildFolder$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelGuildFolder parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public ModelGuildFolder parse(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
        ref$ObjectRefC0.element = null;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = null;
        Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        ref$ObjectRef3.element = null;
        reader.nextObject(new ModelGuildFolder$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3));
        Long l = (Long) ref$ObjectRefC0.element;
        List list = (List) ref$ObjectRef.element;
        m.checkNotNull(list);
        return new ModelGuildFolder(l, list, (Integer) ref$ObjectRef2.element, (String) ref$ObjectRef3.element);
    }
}
