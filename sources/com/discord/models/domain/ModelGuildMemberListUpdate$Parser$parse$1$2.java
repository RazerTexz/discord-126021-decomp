package com.discord.models.domain;


/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelGuildMemberListUpdate$Parser$parse$1$2<T> implements Model$JsonReader$ItemFactory<ModelGuildMemberListUpdate$Group> {
    public final /* synthetic */ ModelGuildMemberListUpdate$Parser$parse$1 this$0;

    public ModelGuildMemberListUpdate$Parser$parse$1$2(ModelGuildMemberListUpdate$Parser$parse$1 modelGuildMemberListUpdate$Parser$parse$1) {
        this.this$0 = modelGuildMemberListUpdate$Parser$parse$1;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ ModelGuildMemberListUpdate$Group get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final ModelGuildMemberListUpdate$Group get() {
        return ModelGuildMemberListUpdate$Group$Parser.INSTANCE.parse(this.this$0.$reader);
    }
}
