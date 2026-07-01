package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelStoreListing.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelStoreListing$Parser implements Model$Parser<ModelStoreListing> {
    public static final ModelStoreListing$Parser INSTANCE = new ModelStoreListing$Parser();

    private ModelStoreListing$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelStoreListing parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public ModelStoreListing parse(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
        ref$ObjectRefC0.element = null;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        reader.nextObject(new ModelStoreListing$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef));
        ModelSku modelSku = (ModelSku) ref$ObjectRefC0.element;
        m.checkNotNull(modelSku);
        Long l = (Long) ref$ObjectRef.element;
        return new ModelStoreListing(modelSku, l != null ? l.longValue() : 0L);
    }
}
