package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelMemberVerificationForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelMemberVerificationForm$Parser implements Model$Parser<ModelMemberVerificationForm> {
    public static final ModelMemberVerificationForm$Parser INSTANCE = new ModelMemberVerificationForm$Parser();

    private ModelMemberVerificationForm$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelMemberVerificationForm parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public ModelMemberVerificationForm parse(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
        ref$ObjectRefC0.element = null;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        reader.nextObject(new ModelMemberVerificationForm$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef));
        T t = ref$ObjectRefC0.element;
        if (t == 0) {
            m.throwUninitializedPropertyAccessException("version");
        }
        String str = (String) t;
        T t2 = ref$ObjectRef.element;
        if (t2 == 0) {
            m.throwUninitializedPropertyAccessException("formFields");
        }
        return new ModelMemberVerificationForm(str, (List) t2);
    }
}
