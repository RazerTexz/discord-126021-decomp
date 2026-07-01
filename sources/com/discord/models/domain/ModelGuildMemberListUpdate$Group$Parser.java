package com.discord.models.domain;

import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelGuildMemberListUpdate$Group$Parser implements Model$Parser<ModelGuildMemberListUpdate$Group> {
    public static final ModelGuildMemberListUpdate$Group$Parser INSTANCE = new ModelGuildMemberListUpdate$Group$Parser();

    private ModelGuildMemberListUpdate$Group$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelGuildMemberListUpdate$Group parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public ModelGuildMemberListUpdate$Group parse(Model$JsonReader reader) throws IOException {
        m.checkNotNullParameter(reader, "reader");
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = "";
        reader.nextObject(new ModelGuildMemberListUpdate$Group$Parser$parse$1(ref$ObjectRef, reader, ref$IntRef));
        return new ModelGuildMemberListUpdate$Group((String) ref$ObjectRef.element, ref$IntRef.element);
    }
}
