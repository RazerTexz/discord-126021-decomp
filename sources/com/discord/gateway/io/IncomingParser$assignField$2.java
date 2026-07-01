package com.discord.gateway.io;

import com.discord.models.domain.Model$JsonReader;
import com.discord.models.domain.Model$JsonReader$ItemFactory;
import com.discord.models.domain.ModelSession;

/* JADX INFO: compiled from: Incoming.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IncomingParser$assignField$2<T> implements Model$JsonReader$ItemFactory<ModelSession> {
    public final /* synthetic */ Model$JsonReader $reader;

    public IncomingParser$assignField$2(Model$JsonReader model$JsonReader) {
        this.$reader = model$JsonReader;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ ModelSession get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final ModelSession get() {
        return (ModelSession) this.$reader.parse(new ModelSession());
    }
}
