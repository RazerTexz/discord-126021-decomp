package com.discord.models.domain;

import b.d.b.a.a;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelMuteConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelMuteConfig$Parser implements Model$Parser<ModelMuteConfig> {
    private ModelMuteConfig$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelMuteConfig parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    public /* synthetic */ ModelMuteConfig$Parser(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public ModelMuteConfig parse(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
        ref$ObjectRefC0.element = null;
        reader.nextObject(new ModelMuteConfig$Parser$parse$1(ref$ObjectRefC0, reader));
        return new ModelMuteConfig((String) ref$ObjectRefC0.element);
    }
}
