package com.discord.models.domain;

import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelUserNote.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelUserNote$Update$Parser implements Model$Parser<ModelUserNote$Update> {
    public static final ModelUserNote$Update$Parser INSTANCE = new ModelUserNote$Update$Parser();

    private ModelUserNote$Update$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelUserNote$Update parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public ModelUserNote$Update parse(Model$JsonReader reader) throws IOException {
        m.checkNotNullParameter(reader, "reader");
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = 0L;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = "";
        reader.nextObject(new ModelUserNote$Update$Parser$parse$1(ref$LongRef, reader, ref$ObjectRef));
        return new ModelUserNote$Update(ref$LongRef.element, (String) ref$ObjectRef.element);
    }
}
