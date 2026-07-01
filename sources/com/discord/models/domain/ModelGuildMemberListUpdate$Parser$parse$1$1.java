package com.discord.models.domain;


/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelGuildMemberListUpdate$Parser$parse$1$1<T> implements Model$JsonReader$ItemFactory<ModelGuildMemberListUpdate$Operation> {
    public final /* synthetic */ ModelGuildMemberListUpdate$Parser$parse$1 this$0;

    public ModelGuildMemberListUpdate$Parser$parse$1$1(ModelGuildMemberListUpdate$Parser$parse$1 modelGuildMemberListUpdate$Parser$parse$1) {
        this.this$0 = modelGuildMemberListUpdate$Parser$parse$1;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ ModelGuildMemberListUpdate$Operation get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final ModelGuildMemberListUpdate$Operation get() {
        return ModelGuildMemberListUpdate$Operation$Parser.INSTANCE.parse(this.this$0.$reader);
    }
}
