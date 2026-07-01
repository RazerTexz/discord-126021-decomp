package com.discord.models.experiments.dto;

import com.discord.models.domain.Model$JsonReader;
import com.discord.models.domain.Model$JsonReader$ItemFactory;
import java.io.IOException;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseFilters$1<T> implements Model$JsonReader$ItemFactory<Unit> {
    public final /* synthetic */ List $filters;
    public final /* synthetic */ Model$JsonReader $reader;

    public GuildExperimentFilter$Parser$parseFilters$1(Model$JsonReader model$JsonReader, List list) {
        this.$reader = model$JsonReader;
        this.$filters = list;
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
        this.$reader.nextListIndexed(new GuildExperimentFilter$Parser$parseFilters$1$1(this, ref$ObjectRef), new GuildExperimentFilter$Parser$parseFilters$1$2(this, ref$ObjectRef));
    }
}
