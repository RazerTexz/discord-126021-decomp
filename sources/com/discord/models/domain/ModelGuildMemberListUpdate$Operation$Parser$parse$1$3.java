package com.discord.models.domain;


/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelGuildMemberListUpdate$Operation$Parser$parse$1$3<T> implements Model$JsonReader$ItemFactory<ModelGuildMemberListUpdate$Operation$Item> {
    public final /* synthetic */ ModelGuildMemberListUpdate$Operation$Parser$parse$1 this$0;

    public ModelGuildMemberListUpdate$Operation$Parser$parse$1$3(ModelGuildMemberListUpdate$Operation$Parser$parse$1 modelGuildMemberListUpdate$Operation$Parser$parse$1) {
        this.this$0 = modelGuildMemberListUpdate$Operation$Parser$parse$1;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ ModelGuildMemberListUpdate$Operation$Item get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final ModelGuildMemberListUpdate$Operation$Item get() {
        return ModelGuildMemberListUpdate$Operation$Item$Parser.INSTANCE.parse(this.this$0.$reader);
    }
}
