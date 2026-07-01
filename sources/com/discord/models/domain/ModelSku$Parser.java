package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.api.application.Application;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelSku.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelSku$Parser implements Model$Parser<ModelSku> {
    public static final ModelSku$Parser INSTANCE = new ModelSku$Parser();

    private ModelSku$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelSku parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public ModelSku parse(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
        ref$ObjectRefC0.element = null;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = null;
        Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        ref$ObjectRef3.element = null;
        Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
        ref$ObjectRef4.element = null;
        Ref$ObjectRef ref$ObjectRef5 = new Ref$ObjectRef();
        ref$ObjectRef5.element = null;
        Ref$ObjectRef ref$ObjectRef6 = new Ref$ObjectRef();
        ref$ObjectRef6.element = null;
        Ref$ObjectRef ref$ObjectRef7 = new Ref$ObjectRef();
        ref$ObjectRef7.element = null;
        reader.nextObject(new ModelSku$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3, ref$ObjectRef4, ref$ObjectRef5, ref$ObjectRef6, ref$ObjectRef7));
        Long l = (Long) ref$ObjectRefC0.element;
        long jLongValue = l != null ? l.longValue() : 0L;
        String str = (String) ref$ObjectRef.element;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        Long l2 = (Long) ref$ObjectRef2.element;
        long jLongValue2 = l2 != null ? l2.longValue() : 0L;
        Application application = (Application) ref$ObjectRef3.element;
        Boolean bool = (Boolean) ref$ObjectRef4.element;
        m.checkNotNull(bool);
        boolean zBooleanValue = bool.booleanValue();
        Integer num = (Integer) ref$ObjectRef5.element;
        m.checkNotNull(num);
        int iIntValue = num.intValue();
        ModelSku$Price modelSku$Price = (ModelSku$Price) ref$ObjectRef6.element;
        Integer num2 = (Integer) ref$ObjectRef7.element;
        m.checkNotNull(num2);
        return new ModelSku(jLongValue, str2, jLongValue2, application, zBooleanValue, iIntValue, modelSku$Price, num2.intValue(), null);
    }
}
