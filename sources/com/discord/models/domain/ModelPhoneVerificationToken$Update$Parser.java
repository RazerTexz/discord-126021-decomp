package com.discord.models.domain;

import b.d.b.a.a;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelPhoneVerificationToken.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelPhoneVerificationToken$Update$Parser implements Model$Parser<ModelPhoneVerificationToken$Update> {
    public static final ModelPhoneVerificationToken$Update$Parser INSTANCE = new ModelPhoneVerificationToken$Update$Parser();

    private ModelPhoneVerificationToken$Update$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelPhoneVerificationToken$Update parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public ModelPhoneVerificationToken$Update parse(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
        ref$ObjectRefC0.element = "";
        reader.nextObject(new ModelPhoneVerificationToken$Update$Parser$parse$1(ref$ObjectRefC0, reader));
        return new ModelPhoneVerificationToken$Update((String) ref$ObjectRefC0.element);
    }
}
