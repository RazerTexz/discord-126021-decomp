package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelGuildFolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelGuildFolder {
    private final Integer color;
    private final List<Long> guildIds;
    private final Long id;
    private final String name;

    public ModelGuildFolder(Long l, List<Long> list, Integer num, String str) {
        m.checkNotNullParameter(list, "guildIds");
        this.id = l;
        this.guildIds = list;
        this.color = num;
        this.name = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelGuildFolder copy$default(ModelGuildFolder modelGuildFolder, Long l, List list, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = modelGuildFolder.id;
        }
        if ((i & 2) != 0) {
            list = modelGuildFolder.guildIds;
        }
        if ((i & 4) != 0) {
            num = modelGuildFolder.color;
        }
        if ((i & 8) != 0) {
            str = modelGuildFolder.name;
        }
        return modelGuildFolder.copy(l, list, num, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    public final List<Long> component2() {
        return this.guildIds;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ModelGuildFolder copy(Long id2, List<Long> guildIds, Integer color, String name) {
        m.checkNotNullParameter(guildIds, "guildIds");
        return new ModelGuildFolder(id2, guildIds, color, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGuildFolder)) {
            return false;
        }
        ModelGuildFolder modelGuildFolder = (ModelGuildFolder) other;
        return m.areEqual(this.id, modelGuildFolder.id) && m.areEqual(this.guildIds, modelGuildFolder.guildIds) && m.areEqual(this.color, modelGuildFolder.color) && m.areEqual(this.name, modelGuildFolder.name);
    }

    public final Integer getColor() {
        return this.color;
    }

    public final List<Long> getGuildIds() {
        return this.guildIds;
    }

    public final Long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        List<Long> list = this.guildIds;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Integer num = this.color;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.name;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelGuildFolder(id=");
        sbU.append(this.id);
        sbU.append(", guildIds=");
        sbU.append(this.guildIds);
        sbU.append(", color=");
        sbU.append(this.color);
        sbU.append(", name=");
        return a.J(sbU, this.name, ")");
    }

    public /* synthetic */ ModelGuildFolder(Long l, List list, Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, list, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str);
    }
}
