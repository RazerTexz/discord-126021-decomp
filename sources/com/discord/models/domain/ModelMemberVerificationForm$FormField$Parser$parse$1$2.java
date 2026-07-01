package com.discord.models.domain;


/* JADX INFO: compiled from: ModelMemberVerificationForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelMemberVerificationForm$FormField$Parser$parse$1$2<T> implements Model$JsonReader$ItemFactory<String> {
    public final /* synthetic */ ModelMemberVerificationForm$FormField$Parser$parse$1 this$0;

    public ModelMemberVerificationForm$FormField$Parser$parse$1$2(ModelMemberVerificationForm$FormField$Parser$parse$1 modelMemberVerificationForm$FormField$Parser$parse$1) {
        this.this$0 = modelMemberVerificationForm$FormField$Parser$parse$1;
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    public /* bridge */ /* synthetic */ String get() {
        return get2();
    }

    @Override // com.discord.models.domain.Model$JsonReader$ItemFactory
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public final String get2() {
        return this.this$0.$reader.nextString("");
    }
}
