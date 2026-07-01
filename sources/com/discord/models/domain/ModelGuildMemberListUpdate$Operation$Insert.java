package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelGuildMemberListUpdate$Operation$Insert extends ModelGuildMemberListUpdate$Operation {
    private final int index;
    private final ModelGuildMemberListUpdate$Operation$Item item;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelGuildMemberListUpdate$Operation$Insert(int i, ModelGuildMemberListUpdate$Operation$Item modelGuildMemberListUpdate$Operation$Item) {
        super(modelGuildMemberListUpdate$Operation$Item, null, 2, null);
        m.checkNotNullParameter(modelGuildMemberListUpdate$Operation$Item, "item");
        this.index = i;
        this.item = modelGuildMemberListUpdate$Operation$Item;
    }

    public static /* synthetic */ ModelGuildMemberListUpdate$Operation$Insert copy$default(ModelGuildMemberListUpdate$Operation$Insert modelGuildMemberListUpdate$Operation$Insert, int i, ModelGuildMemberListUpdate$Operation$Item modelGuildMemberListUpdate$Operation$Item, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = modelGuildMemberListUpdate$Operation$Insert.index;
        }
        if ((i2 & 2) != 0) {
            modelGuildMemberListUpdate$Operation$Item = modelGuildMemberListUpdate$Operation$Insert.getItem();
        }
        return modelGuildMemberListUpdate$Operation$Insert.copy(i, modelGuildMemberListUpdate$Operation$Item);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    public final ModelGuildMemberListUpdate$Operation$Item component2() {
        return getItem();
    }

    public final ModelGuildMemberListUpdate$Operation$Insert copy(int index, ModelGuildMemberListUpdate$Operation$Item item) {
        m.checkNotNullParameter(item, "item");
        return new ModelGuildMemberListUpdate$Operation$Insert(index, item);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGuildMemberListUpdate$Operation$Insert)) {
            return false;
        }
        ModelGuildMemberListUpdate$Operation$Insert modelGuildMemberListUpdate$Operation$Insert = (ModelGuildMemberListUpdate$Operation$Insert) other;
        return this.index == modelGuildMemberListUpdate$Operation$Insert.index && m.areEqual(getItem(), modelGuildMemberListUpdate$Operation$Insert.getItem());
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // com.discord.models.domain.ModelGuildMemberListUpdate$Operation
    public ModelGuildMemberListUpdate$Operation$Item getItem() {
        return this.item;
    }

    public int hashCode() {
        int i = this.index * 31;
        ModelGuildMemberListUpdate$Operation$Item item = getItem();
        return i + (item != null ? item.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Insert(index=");
        sbU.append(this.index);
        sbU.append(", item=");
        sbU.append(getItem());
        sbU.append(")");
        return sbU.toString();
    }
}
