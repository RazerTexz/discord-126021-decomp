package com.discord.models.domain;

import b.d.b.a.a;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelCustomStatusSetting.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelCustomStatusSetting$Parser implements Model$Parser<ModelCustomStatusSetting> {
    public static final ModelCustomStatusSetting$Parser INSTANCE = new ModelCustomStatusSetting$Parser();

    private ModelCustomStatusSetting$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelCustomStatusSetting parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public ModelCustomStatusSetting parse(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
        ref$ObjectRefC0.element = null;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = null;
        Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        ref$ObjectRef3.element = null;
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return ModelCustomStatusSetting.Companion.getCLEAR();
        }
        reader.nextObject(new ModelCustomStatusSetting$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3));
        return new ModelCustomStatusSetting((String) ref$ObjectRefC0.element, (Long) ref$ObjectRef.element, (String) ref$ObjectRef2.element, (String) ref$ObjectRef3.element);
    }
}
