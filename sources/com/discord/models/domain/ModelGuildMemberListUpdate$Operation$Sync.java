package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelGuildMemberListUpdate$Operation$Sync extends ModelGuildMemberListUpdate$Operation {
    private final List<ModelGuildMemberListUpdate$Operation$Item> items;
    private final IntRange range;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ModelGuildMemberListUpdate$Operation$Sync(IntRange intRange, List<? extends ModelGuildMemberListUpdate$Operation$Item> list) {
        super(null, list, 1, null);
        m.checkNotNullParameter(intRange, "range");
        m.checkNotNullParameter(list, "items");
        this.range = intRange;
        this.items = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelGuildMemberListUpdate$Operation$Sync copy$default(ModelGuildMemberListUpdate$Operation$Sync modelGuildMemberListUpdate$Operation$Sync, IntRange intRange, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            intRange = modelGuildMemberListUpdate$Operation$Sync.range;
        }
        if ((i & 2) != 0) {
            list = modelGuildMemberListUpdate$Operation$Sync.getItems();
        }
        return modelGuildMemberListUpdate$Operation$Sync.copy(intRange, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final IntRange getRange() {
        return this.range;
    }

    public final List<ModelGuildMemberListUpdate$Operation$Item> component2() {
        return getItems();
    }

    public final ModelGuildMemberListUpdate$Operation$Sync copy(IntRange range, List<? extends ModelGuildMemberListUpdate$Operation$Item> items) {
        m.checkNotNullParameter(range, "range");
        m.checkNotNullParameter(items, "items");
        return new ModelGuildMemberListUpdate$Operation$Sync(range, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGuildMemberListUpdate$Operation$Sync)) {
            return false;
        }
        ModelGuildMemberListUpdate$Operation$Sync modelGuildMemberListUpdate$Operation$Sync = (ModelGuildMemberListUpdate$Operation$Sync) other;
        return m.areEqual(this.range, modelGuildMemberListUpdate$Operation$Sync.range) && m.areEqual(getItems(), modelGuildMemberListUpdate$Operation$Sync.getItems());
    }

    @Override // com.discord.models.domain.ModelGuildMemberListUpdate$Operation
    public List<ModelGuildMemberListUpdate$Operation$Item> getItems() {
        return this.items;
    }

    public final IntRange getRange() {
        return this.range;
    }

    public int hashCode() {
        IntRange intRange = this.range;
        int iHashCode = (intRange != null ? intRange.hashCode() : 0) * 31;
        List<ModelGuildMemberListUpdate$Operation$Item> items = getItems();
        return iHashCode + (items != null ? items.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Sync(range=");
        sbU.append(this.range);
        sbU.append(", items=");
        sbU.append(getItems());
        sbU.append(")");
        return sbU.toString();
    }
}
