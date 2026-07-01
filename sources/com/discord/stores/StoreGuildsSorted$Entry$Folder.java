package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.models.guild.Guild;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: StoreGuildsSorted.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGuildsSorted$Entry$Folder extends StoreGuildsSorted$Entry {
    private final Integer color;
    private final List<Guild> guilds;
    private final long id;
    private final String name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildsSorted$Entry$Folder(long j, List<Guild> list, Integer num, String str) {
        super(null);
        m.checkNotNullParameter(list, "guilds");
        this.id = j;
        this.guilds = list;
        this.color = num;
        this.name = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreGuildsSorted$Entry$Folder copy$default(StoreGuildsSorted$Entry$Folder storeGuildsSorted$Entry$Folder, long j, List list, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = storeGuildsSorted$Entry$Folder.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            list = storeGuildsSorted$Entry$Folder.guilds;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            num = storeGuildsSorted$Entry$Folder.color;
        }
        Integer num2 = num;
        if ((i & 8) != 0) {
            str = storeGuildsSorted$Entry$Folder.name;
        }
        return storeGuildsSorted$Entry$Folder.copy(j2, list2, num2, str);
    }

    @Override // com.discord.stores.StoreGuildsSorted$Entry
    public ModelGuildFolder asModelGuildFolder() {
        Long lValueOf = Long.valueOf(this.id);
        List<Guild> list = this.guilds;
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Guild) it.next()).getId()));
        }
        return new ModelGuildFolder(lValueOf, arrayList, this.color, this.name);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final List<Guild> component2() {
        return this.guilds;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final StoreGuildsSorted$Entry$Folder copy(long id2, List<Guild> guilds, Integer color, String name) {
        m.checkNotNullParameter(guilds, "guilds");
        return new StoreGuildsSorted$Entry$Folder(id2, guilds, color, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreGuildsSorted$Entry$Folder)) {
            return false;
        }
        StoreGuildsSorted$Entry$Folder storeGuildsSorted$Entry$Folder = (StoreGuildsSorted$Entry$Folder) other;
        return this.id == storeGuildsSorted$Entry$Folder.id && m.areEqual(this.guilds, storeGuildsSorted$Entry$Folder.guilds) && m.areEqual(this.color, storeGuildsSorted$Entry$Folder.color) && m.areEqual(this.name, storeGuildsSorted$Entry$Folder.name);
    }

    public final Integer getColor() {
        return this.color;
    }

    public final List<Guild> getGuilds() {
        return this.guilds;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int iA = b.a(this.id) * 31;
        List<Guild> list = this.guilds;
        int iHashCode = (iA + (list != null ? list.hashCode() : 0)) * 31;
        Integer num = this.color;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.name;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Folder(id=");
        sbU.append(this.id);
        sbU.append(", guilds=");
        sbU.append(this.guilds);
        sbU.append(", color=");
        sbU.append(this.color);
        sbU.append(", name=");
        return a.J(sbU, this.name, ")");
    }
}
