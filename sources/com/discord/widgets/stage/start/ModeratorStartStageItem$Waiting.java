package com.discord.widgets.stage.start;

import b.d.b.a.a;
import com.discord.models.guild.UserGuildMember;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModeratorStartStageItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ModeratorStartStageItem$Waiting extends ModeratorStartStageItem {
    private final String key;
    private final int type;
    private final List<UserGuildMember> users;

    public /* synthetic */ ModeratorStartStageItem$Waiting(int i, String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 3 : i, (i2 & 2) != 0 ? "KEY_CREATE_STAGE_EVENT_WAITING" : str, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModeratorStartStageItem$Waiting copy$default(ModeratorStartStageItem$Waiting moderatorStartStageItem$Waiting, int i, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = moderatorStartStageItem$Waiting.getType();
        }
        if ((i2 & 2) != 0) {
            str = moderatorStartStageItem$Waiting.getKey();
        }
        if ((i2 & 4) != 0) {
            list = moderatorStartStageItem$Waiting.users;
        }
        return moderatorStartStageItem$Waiting.copy(i, str, list);
    }

    public final int component1() {
        return getType();
    }

    public final String component2() {
        return getKey();
    }

    public final List<UserGuildMember> component3() {
        return this.users;
    }

    public final ModeratorStartStageItem$Waiting copy(int type, String key, List<UserGuildMember> users) {
        m.checkNotNullParameter(key, "key");
        m.checkNotNullParameter(users, "users");
        return new ModeratorStartStageItem$Waiting(type, key, users);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModeratorStartStageItem$Waiting)) {
            return false;
        }
        ModeratorStartStageItem$Waiting moderatorStartStageItem$Waiting = (ModeratorStartStageItem$Waiting) other;
        return getType() == moderatorStartStageItem$Waiting.getType() && m.areEqual(getKey(), moderatorStartStageItem$Waiting.getKey()) && m.areEqual(this.users, moderatorStartStageItem$Waiting.users);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final List<UserGuildMember> getUsers() {
        return this.users;
    }

    public int hashCode() {
        int type = getType() * 31;
        String key = getKey();
        int iHashCode = (type + (key != null ? key.hashCode() : 0)) * 31;
        List<UserGuildMember> list = this.users;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Waiting(type=");
        sbU.append(getType());
        sbU.append(", key=");
        sbU.append(getKey());
        sbU.append(", users=");
        return a.L(sbU, this.users, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModeratorStartStageItem$Waiting(int i, String str, List<UserGuildMember> list) {
        super(null);
        m.checkNotNullParameter(str, "key");
        m.checkNotNullParameter(list, "users");
        this.type = i;
        this.key = str;
        this.users = list;
    }
}
