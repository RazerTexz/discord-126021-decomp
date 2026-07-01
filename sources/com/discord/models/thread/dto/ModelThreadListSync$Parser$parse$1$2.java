package com.discord.models.thread.dto;

import com.discord.api.thread.ThreadMember;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model$JsonReader$ItemFactory;

/* JADX INFO: compiled from: ModelThreadListSync.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelThreadListSync$Parser$parse$1$2<T> implements Model$JsonReader$ItemFactory<ThreadMember> {
    public final /* synthetic */ ModelThreadListSync$Parser$parse$1 this$0;

    public ModelThreadListSync$Parser$parse$1$2(ModelThreadListSync$Parser$parse$1 modelThreadListSync$Parser$parse$1) {
        this.this$0 = modelThreadListSync$Parser$parse$1;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ ThreadMember get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final ThreadMember get() {
        return (ThreadMember) InboundGatewayGsonParser.fromJson(this.this$0.$reader, ThreadMember.class);
    }
}
