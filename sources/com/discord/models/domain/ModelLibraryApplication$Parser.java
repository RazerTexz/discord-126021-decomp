package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.api.application.Application;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelLibraryApplication.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelLibraryApplication$Parser implements Model$Parser<ModelLibraryApplication> {
    public static final ModelLibraryApplication$Parser INSTANCE = new ModelLibraryApplication$Parser();

    private ModelLibraryApplication$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelLibraryApplication parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.models.domain.Model$Parser
    public ModelLibraryApplication parse(Model$JsonReader reader) throws IOException {
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
        reader.nextObject(new ModelLibraryApplication$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3, ref$ObjectRef4));
        Application application = (Application) ref$ObjectRefC0.element;
        m.checkNotNull(application);
        String str = (String) ref$ObjectRef.element;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        Long l = (Long) ref$ObjectRef2.element;
        long jLongValue = l != null ? l.longValue() : 0L;
        Integer num = (Integer) ref$ObjectRef3.element;
        int iIntValue = num != null ? num.intValue() : 0;
        Long l2 = (Long) ref$ObjectRef4.element;
        return new ModelLibraryApplication(application, str2, jLongValue, iIntValue, l2 != null ? l2.longValue() : 0L);
    }
}
