package com.discord.models.domain;


/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StreamCreateOrUpdate$Parser$parse$1$1<T> implements Model$JsonReader$ItemFactory<Long> {
    public final /* synthetic */ StreamCreateOrUpdate$Parser$parse$1 this$0;

    public StreamCreateOrUpdate$Parser$parse$1$1(StreamCreateOrUpdate$Parser$parse$1 streamCreateOrUpdate$Parser$parse$1) {
        this.this$0 = streamCreateOrUpdate$Parser$parse$1;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ Long get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final Long get() {
        return Long.valueOf(this.this$0.$reader.nextLong(0L));
    }
}
