package com.discord.models.thread.dto;

import com.discord.api.channel.Channel;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model$JsonReader$ItemFactory;

/* JADX INFO: compiled from: ModelThreadListSync.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelThreadListSync$Parser$parse$1$1<T> implements Model$JsonReader$ItemFactory<Channel> {
    public final /* synthetic */ ModelThreadListSync$Parser$parse$1 this$0;

    public ModelThreadListSync$Parser$parse$1$1(ModelThreadListSync$Parser$parse$1 modelThreadListSync$Parser$parse$1) {
        this.this$0 = modelThreadListSync$Parser$parse$1;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ Channel get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final Channel get() {
        return (Channel) InboundGatewayGsonParser.fromJson(this.this$0.$reader, Channel.class);
    }
}
