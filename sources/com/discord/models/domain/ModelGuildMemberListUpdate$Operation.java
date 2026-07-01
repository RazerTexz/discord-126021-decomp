package com.discord.models.domain;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class ModelGuildMemberListUpdate$Operation {
    private final ModelGuildMemberListUpdate$Operation$Item item;
    private final List<ModelGuildMemberListUpdate$Operation$Item> items;

    /* JADX WARN: Multi-variable type inference failed */
    private ModelGuildMemberListUpdate$Operation(ModelGuildMemberListUpdate$Operation$Item modelGuildMemberListUpdate$Operation$Item, List<? extends ModelGuildMemberListUpdate$Operation$Item> list) {
        this.item = modelGuildMemberListUpdate$Operation$Item;
        this.items = list;
    }

    public ModelGuildMemberListUpdate$Operation$Item getItem() {
        return this.item;
    }

    public List<ModelGuildMemberListUpdate$Operation$Item> getItems() {
        return this.items;
    }

    public /* synthetic */ ModelGuildMemberListUpdate$Operation(ModelGuildMemberListUpdate$Operation$Item modelGuildMemberListUpdate$Operation$Item, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : modelGuildMemberListUpdate$Operation$Item, (i & 2) != 0 ? null : list);
    }
}
