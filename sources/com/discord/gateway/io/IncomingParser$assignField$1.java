package com.discord.gateway.io;

import com.discord.api.presence.Presence;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model$JsonReader;
import com.discord.models.domain.Model$JsonReader$ItemFactory;

/* JADX INFO: compiled from: Incoming.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IncomingParser$assignField$1<T> implements Model$JsonReader$ItemFactory<Presence> {
    public final /* synthetic */ Model$JsonReader $reader;

    public IncomingParser$assignField$1(Model$JsonReader model$JsonReader) {
        this.$reader = model$JsonReader;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ Presence get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final Presence get() {
        return (Presence) InboundGatewayGsonParser.fromJson(this.$reader, Presence.class);
    }
}
