package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader;
import com.discord.models.domain.Model$JsonReader$ItemFactory;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseRange$1<T> implements Model$JsonReader$ItemFactory<Unit> {
    public final /* synthetic */ Ref$ObjectRef $end;
    public final /* synthetic */ Model$JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $start;

    public GuildExperimentFilter$Parser$parseRange$1(Model$JsonReader model$JsonReader, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2) {
        this.$reader = model$JsonReader;
        this.$start = ref$ObjectRef;
        this.$end = ref$ObjectRef2;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ Unit get() throws IOException {
        get2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public final void get2() throws IOException {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        this.$reader.nextListIndexed(new GuildExperimentFilter$Parser$parseRange$1$1(this, ref$ObjectRef), new GuildExperimentFilter$Parser$parseRange$1$2(this, ref$ObjectRef));
    }
}
