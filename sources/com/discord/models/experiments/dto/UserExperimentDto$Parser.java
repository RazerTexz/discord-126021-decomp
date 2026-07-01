package com.discord.models.experiments.dto;

import b.d.b.a.a;
import com.discord.models.domain.Model$JsonReader;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: UserExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserExperimentDto$Parser {
    public static final UserExperimentDto$Parser INSTANCE = new UserExperimentDto$Parser();

    private UserExperimentDto$Parser() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final UserExperimentDto parse(Model$JsonReader reader) throws IOException {
        Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
        ref$ObjectRefC0.element = null;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = null;
        Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        ref$ObjectRef3.element = null;
        reader.nextListIndexed(new UserExperimentDto$Parser$parse$1(ref$ObjectRefC0, reader), new UserExperimentDto$Parser$parse$2(ref$ObjectRef, reader), new UserExperimentDto$Parser$parse$3(ref$ObjectRef2, reader), new UserExperimentDto$Parser$parse$4(ref$ObjectRef3, reader));
        Long l = (Long) ref$ObjectRefC0.element;
        m.checkNotNull(l);
        long jLongValue = l.longValue();
        Integer num = (Integer) ref$ObjectRef.element;
        m.checkNotNull(num);
        int iIntValue = num.intValue();
        Integer num2 = (Integer) ref$ObjectRef2.element;
        m.checkNotNull(num2);
        int iIntValue2 = num2.intValue();
        Integer num3 = (Integer) ref$ObjectRef3.element;
        m.checkNotNull(num3);
        return new UserExperimentDto(jLongValue, iIntValue, iIntValue2, num3.intValue());
    }
}
