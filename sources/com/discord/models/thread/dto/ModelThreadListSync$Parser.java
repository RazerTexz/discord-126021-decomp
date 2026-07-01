package com.discord.models.thread.dto;

import com.discord.models.domain.Model$JsonReader;
import com.discord.models.domain.Model$Parser;
import d0.t.n;
import d0.z.d.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: ModelThreadListSync.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelThreadListSync$Parser implements Model$Parser<ModelThreadListSync> {
    public static final ModelThreadListSync$Parser INSTANCE = new ModelThreadListSync$Parser();

    private ModelThreadListSync$Parser() {
    }

    @Override // com.discord.models.domain.Model$Parser
    public /* bridge */ /* synthetic */ ModelThreadListSync parse(Model$JsonReader model$JsonReader) {
        return parse(model$JsonReader);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.ArrayList] */
    @Override // com.discord.models.domain.Model$Parser
    public ModelThreadListSync parse(Model$JsonReader reader) throws IOException {
        m.checkNotNullParameter(reader, "reader");
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = -1L;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = new ArrayList();
        Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        ref$ObjectRef3.element = null;
        reader.nextObject(new ModelThreadListSync$Parser$parse$1(ref$LongRef, reader, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3));
        long j = ref$LongRef.element;
        List listEmptyList = (List) ref$ObjectRef.element;
        if (listEmptyList == null) {
            listEmptyList = n.emptyList();
        }
        return new ModelThreadListSync(j, listEmptyList, (List) ref$ObjectRef2.element, (List) ref$ObjectRef3.element);
    }
}
