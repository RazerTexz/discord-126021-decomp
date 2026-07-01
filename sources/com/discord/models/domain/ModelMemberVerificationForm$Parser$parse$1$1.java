package com.discord.models.domain;


/* JADX INFO: compiled from: ModelMemberVerificationForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelMemberVerificationForm$Parser$parse$1$1<T> implements Model$JsonReader$ItemFactory<ModelMemberVerificationForm$FormField> {
    public final /* synthetic */ ModelMemberVerificationForm$Parser$parse$1 this$0;

    public ModelMemberVerificationForm$Parser$parse$1$1(ModelMemberVerificationForm$Parser$parse$1 modelMemberVerificationForm$Parser$parse$1) {
        this.this$0 = modelMemberVerificationForm$Parser$parse$1;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ ModelMemberVerificationForm$FormField get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public final ModelMemberVerificationForm$FormField get() {
        return ModelMemberVerificationForm$FormField$Parser.INSTANCE.parse(this.this$0.$reader);
    }
}
