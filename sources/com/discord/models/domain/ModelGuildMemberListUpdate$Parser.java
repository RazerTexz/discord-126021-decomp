package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelGuildMemberListUpdate$Parser implements Model$Parser<ModelGuildMemberListUpdate> {
    public static final ModelGuildMemberListUpdate$Parser INSTANCE = new ModelGuildMemberListUpdate$Parser();

    private ModelGuildMemberListUpdate$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelGuildMemberListUpdate parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public ModelGuildMemberListUpdate parse(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
        ref$ObjectRefC0.element = null;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = null;
        Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        ref$ObjectRef3.element = null;
        reader.nextObject(new ModelGuildMemberListUpdate$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3));
        Long l = (Long) ref$ObjectRefC0.element;
        m.checkNotNull(l);
        long jLongValue = l.longValue();
        String str = (String) ref$ObjectRef.element;
        if (str == null) {
            str = ModelGuildMemberListUpdate.EVERYONE_ID;
        }
        String str2 = str;
        List list = (List) ref$ObjectRef2.element;
        m.checkNotNull(list);
        List list2 = (List) ref$ObjectRef3.element;
        m.checkNotNull(list2);
        return new ModelGuildMemberListUpdate(jLongValue, str2, list, list2);
    }
}
