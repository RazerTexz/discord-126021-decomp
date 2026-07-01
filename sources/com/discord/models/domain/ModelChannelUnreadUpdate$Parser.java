package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelChannelUnreadUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelChannelUnreadUpdate$Parser implements Model$Parser<ModelChannelUnreadUpdate> {
    public static final ModelChannelUnreadUpdate$Parser INSTANCE = new ModelChannelUnreadUpdate$Parser();

    private ModelChannelUnreadUpdate$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelChannelUnreadUpdate parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$Parser
    public ModelChannelUnreadUpdate parse(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
        ref$ObjectRefC0.element = null;
        reader.nextObject(new ModelChannelUnreadUpdate$Parser$parse$1(ref$ObjectRefC0, reader));
        T t = ref$ObjectRefC0.element;
        if (t == 0) {
            m.throwUninitializedPropertyAccessException("channelReadStates");
        }
        return new ModelChannelUnreadUpdate((List) t);
    }
}
