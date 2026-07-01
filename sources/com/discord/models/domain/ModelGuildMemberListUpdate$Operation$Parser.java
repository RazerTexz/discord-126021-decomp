package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelGuildMemberListUpdate$Operation$Parser implements Model$Parser<ModelGuildMemberListUpdate$Operation> {
    public static final ModelGuildMemberListUpdate$Operation$Parser INSTANCE = new ModelGuildMemberListUpdate$Operation$Parser();

    private ModelGuildMemberListUpdate$Operation$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelGuildMemberListUpdate$Operation parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public ModelGuildMemberListUpdate$Operation parse(Model$JsonReader reader) throws IOException {
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
        reader.nextObject(new ModelGuildMemberListUpdate$Operation$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef3, ref$ObjectRef2, ref$ObjectRef4));
        String str = (String) ref$ObjectRefC0.element;
        if (str != null) {
            switch (str.hashCode()) {
                case -2130463047:
                    if (str.equals("INSERT")) {
                        Integer num = (Integer) ref$ObjectRef.element;
                        m.checkNotNull(num);
                        int iIntValue = num.intValue();
                        ModelGuildMemberListUpdate$Operation$Item modelGuildMemberListUpdate$Operation$Item = (ModelGuildMemberListUpdate$Operation$Item) ref$ObjectRef2.element;
                        m.checkNotNull(modelGuildMemberListUpdate$Operation$Item);
                        return new ModelGuildMemberListUpdate$Operation$Insert(iIntValue, modelGuildMemberListUpdate$Operation$Item);
                    }
                    break;
                case -1785516855:
                    if (str.equals("UPDATE")) {
                        Integer num2 = (Integer) ref$ObjectRef.element;
                        m.checkNotNull(num2);
                        int iIntValue2 = num2.intValue();
                        ModelGuildMemberListUpdate$Operation$Item modelGuildMemberListUpdate$Operation$Item2 = (ModelGuildMemberListUpdate$Operation$Item) ref$ObjectRef2.element;
                        m.checkNotNull(modelGuildMemberListUpdate$Operation$Item2);
                        return new ModelGuildMemberListUpdate$Operation$Update(iIntValue2, modelGuildMemberListUpdate$Operation$Item2);
                    }
                    break;
                case -1346757317:
                    if (str.equals("INVALIDATE")) {
                        IntRange intRange = (IntRange) ref$ObjectRef3.element;
                        m.checkNotNull(intRange);
                        return new ModelGuildMemberListUpdate$Operation$Invalidate(intRange);
                    }
                    break;
                case 2560667:
                    if (str.equals("SYNC")) {
                        IntRange intRange2 = (IntRange) ref$ObjectRef3.element;
                        m.checkNotNull(intRange2);
                        List list = (List) ref$ObjectRef4.element;
                        m.checkNotNull(list);
                        return new ModelGuildMemberListUpdate$Operation$Sync(intRange2, list);
                    }
                    break;
                case 2012838315:
                    if (str.equals("DELETE")) {
                        Integer num3 = (Integer) ref$ObjectRef.element;
                        m.checkNotNull(num3);
                        return new ModelGuildMemberListUpdate$Operation$Delete(num3.intValue());
                    }
                    break;
            }
        }
        StringBuilder sbU = a.U("Invalid operation type: ");
        sbU.append((String) ref$ObjectRefC0.element);
        throw new IllegalArgumentException(sbU.toString());
    }
}
