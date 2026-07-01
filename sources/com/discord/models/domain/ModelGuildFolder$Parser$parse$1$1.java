package com.discord.models.domain;


/* JADX INFO: compiled from: ModelGuildFolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelGuildFolder$Parser$parse$1$1<T> implements Model$JsonReader$ItemFactory<Long> {
    public final /* synthetic */ ModelGuildFolder$Parser$parse$1 this$0;

    public ModelGuildFolder$Parser$parse$1$1(ModelGuildFolder$Parser$parse$1 modelGuildFolder$Parser$parse$1) {
        this.this$0 = modelGuildFolder$Parser$parse$1;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ Long get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final Long get() {
        return this.this$0.$reader.nextLongOrNull();
    }
}
