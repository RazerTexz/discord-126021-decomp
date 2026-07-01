package com.discord.models.domain;


/* JADX INFO: compiled from: ModelChannelUnreadUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelChannelUnreadUpdate$Parser$parse$1$1<T> implements Model$JsonReader$ItemFactory<ModelReadState> {
    public final /* synthetic */ ModelChannelUnreadUpdate$Parser$parse$1 this$0;

    public ModelChannelUnreadUpdate$Parser$parse$1$1(ModelChannelUnreadUpdate$Parser$parse$1 modelChannelUnreadUpdate$Parser$parse$1) {
        this.this$0 = modelChannelUnreadUpdate$Parser$parse$1;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ ModelReadState get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final ModelReadState get() {
        return ModelReadState$Parser.INSTANCE.parse(this.this$0.$reader);
    }
}
