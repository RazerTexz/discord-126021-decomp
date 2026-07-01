package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelMemberVerificationForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelMemberVerificationForm$FormField$Parser implements Model$Parser<ModelMemberVerificationForm$FormField> {
    public static final ModelMemberVerificationForm$FormField$Parser INSTANCE = new ModelMemberVerificationForm$FormField$Parser();

    private ModelMemberVerificationForm$FormField$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelMemberVerificationForm$FormField parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public ModelMemberVerificationForm$FormField parse(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
        ref$ObjectRefC0.element = null;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = false;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = null;
        Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        ref$ObjectRef3.element = null;
        Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
        ref$ObjectRef4.element = null;
        reader.nextObject(new ModelMemberVerificationForm$FormField$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef, ref$BooleanRef, ref$ObjectRef2, ref$ObjectRef3, ref$ObjectRef4));
        T t = ref$ObjectRefC0.element;
        if (t == 0) {
            m.throwUninitializedPropertyAccessException("fieldType");
        }
        String str = (String) t;
        T t2 = ref$ObjectRef.element;
        if (t2 == 0) {
            m.throwUninitializedPropertyAccessException("label");
        }
        String str2 = (String) t2;
        boolean z2 = ref$BooleanRef.element;
        T t3 = ref$ObjectRef2.element;
        if (t3 == 0) {
            m.throwUninitializedPropertyAccessException("values");
        }
        List list = (List) t3;
        T t4 = ref$ObjectRef3.element;
        if (t4 == 0) {
            m.throwUninitializedPropertyAccessException("choices");
        }
        List list2 = (List) t4;
        T t5 = ref$ObjectRef4.element;
        if (t5 == 0) {
            m.throwUninitializedPropertyAccessException("response");
        }
        return new ModelMemberVerificationForm$FormField(str, str2, z2, list, list2, t5);
    }
}
