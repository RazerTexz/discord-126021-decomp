package com.discord.models.experiments.dto;

import b.d.b.a.a;
import com.discord.models.domain.Model$JsonReader;
import d0.t.n;
import d0.z.d.m;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentDto$Parser {
    public static final GuildExperimentDto$Parser INSTANCE = new GuildExperimentDto$Parser();

    private GuildExperimentDto$Parser() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [T, java.util.List] */
    public static final GuildExperimentDto parse(Model$JsonReader jsonReader) throws IOException {
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(jsonReader, "jsonReader");
        ref$ObjectRefC0.element = null;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = null;
        Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        ref$ObjectRef3.element = null;
        Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
        ref$ObjectRef4.element = n.emptyList();
        jsonReader.nextListIndexed(new GuildExperimentDto$Parser$parse$1(ref$ObjectRefC0, jsonReader), new GuildExperimentDto$Parser$parse$2(ref$ObjectRef, jsonReader), new GuildExperimentDto$Parser$parse$3(ref$ObjectRef2, jsonReader), new GuildExperimentDto$Parser$parse$4(ref$ObjectRef3, jsonReader), new GuildExperimentDto$Parser$parse$5(ref$ObjectRef4, jsonReader));
        Long l = (Long) ref$ObjectRefC0.element;
        m.checkNotNull(l);
        long jLongValue = l.longValue();
        String str = (String) ref$ObjectRef.element;
        Integer num = (Integer) ref$ObjectRef2.element;
        m.checkNotNull(num);
        int iIntValue = num.intValue();
        List list = (List) ref$ObjectRef4.element;
        List list2 = (List) ref$ObjectRef3.element;
        m.checkNotNull(list2);
        return new GuildExperimentDto(jLongValue, str, iIntValue, list2, list);
    }
}
