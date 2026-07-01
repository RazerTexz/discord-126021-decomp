package com.discord.models.domain;

import b.d.b.a.a;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelSku.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelSku$Price$Parser implements Model$Parser<ModelSku$Price> {
    public static final ModelSku$Price$Parser INSTANCE = new ModelSku$Price$Parser();

    private ModelSku$Price$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelSku$Price parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public ModelSku$Price parse(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
        ref$ObjectRefC0.element = null;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        reader.nextObject(new ModelSku$Price$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef));
        Integer num = (Integer) ref$ObjectRefC0.element;
        int iIntValue = num != null ? num.intValue() : -1;
        String str = (String) ref$ObjectRef.element;
        if (str == null) {
            str = "";
        }
        return new ModelSku$Price(iIntValue, str, null, 4, null);
    }
}
