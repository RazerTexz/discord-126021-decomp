package com.discord.models.domain;

import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;

/* JADX INFO: compiled from: ModelReadState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelReadState$Parser implements Model$Parser<ModelReadState> {
    public static final ModelReadState$Parser INSTANCE = new ModelReadState$Parser();

    private ModelReadState$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelReadState parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$Parser
    public ModelReadState parse(Model$JsonReader reader) throws IOException {
        m.checkNotNullParameter(reader, "reader");
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = 0L;
        Ref$LongRef ref$LongRef2 = new Ref$LongRef();
        ref$LongRef2.element = 0L;
        Ref$LongRef ref$LongRef3 = new Ref$LongRef();
        ref$LongRef3.element = 0L;
        Ref$LongRef ref$LongRef4 = new Ref$LongRef();
        ref$LongRef4.element = 0L;
        Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.element = 0;
        reader.nextObject(new ModelReadState$Parser$parse$1(ref$LongRef3, reader, ref$IntRef, ref$LongRef, ref$LongRef2, ref$LongRef4, ref$IntRef2));
        return new ModelReadState(ref$LongRef3.element, ref$LongRef4.element, ref$LongRef.element, ref$LongRef2.element, ref$IntRef.element, ref$IntRef2.element, null);
    }
}
