package com.discord.widgets.servers.guildboost;

import b.d.b.a.a;
import com.android.billingclient.api.Purchase;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildBoostViewModel$ViewState$Loaded extends GuildBoostViewModel$ViewState {
    private final Map<Long, ModelGuildBoostSlot> boostSlotMap;
    private final Guild guild;
    private final MeUser meUser;
    private final ModelSubscription premiumSubscription;
    private final List<Purchase> purchases;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildBoostViewModel$ViewState$Loaded(Map<Long, ModelGuildBoostSlot> map, ModelSubscription modelSubscription, List<? extends Purchase> list, MeUser meUser, Guild guild) {
        super(null);
        m.checkNotNullParameter(map, "boostSlotMap");
        m.checkNotNullParameter(list, "purchases");
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(guild, "guild");
        this.boostSlotMap = map;
        this.premiumSubscription = modelSubscription;
        this.purchases = list;
        this.meUser = meUser;
        this.guild = guild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildBoostViewModel$ViewState$Loaded copy$default(GuildBoostViewModel$ViewState$Loaded guildBoostViewModel$ViewState$Loaded, Map map, ModelSubscription modelSubscription, List list, MeUser meUser, Guild guild, int i, Object obj) {
        if ((i & 1) != 0) {
            map = guildBoostViewModel$ViewState$Loaded.boostSlotMap;
        }
        if ((i & 2) != 0) {
            modelSubscription = guildBoostViewModel$ViewState$Loaded.premiumSubscription;
        }
        ModelSubscription modelSubscription2 = modelSubscription;
        if ((i & 4) != 0) {
            list = guildBoostViewModel$ViewState$Loaded.purchases;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            meUser = guildBoostViewModel$ViewState$Loaded.meUser;
        }
        MeUser meUser2 = meUser;
        if ((i & 16) != 0) {
            guild = guildBoostViewModel$ViewState$Loaded.guild;
        }
        return guildBoostViewModel$ViewState$Loaded.copy(map, modelSubscription2, list2, meUser2, guild);
    }

    public final Map<Long, ModelGuildBoostSlot> component1() {
        return this.boostSlotMap;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ModelSubscription getPremiumSubscription() {
        return this.premiumSubscription;
    }

    public final List<Purchase> component3() {
        return this.purchases;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final GuildBoostViewModel$ViewState$Loaded copy(Map<Long, ModelGuildBoostSlot> boostSlotMap, ModelSubscription premiumSubscription, List<? extends Purchase> purchases, MeUser meUser, Guild guild) {
        m.checkNotNullParameter(boostSlotMap, "boostSlotMap");
        m.checkNotNullParameter(purchases, "purchases");
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(guild, "guild");
        return new GuildBoostViewModel$ViewState$Loaded(boostSlotMap, premiumSubscription, purchases, meUser, guild);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildBoostViewModel$ViewState$Loaded)) {
            return false;
        }
        GuildBoostViewModel$ViewState$Loaded guildBoostViewModel$ViewState$Loaded = (GuildBoostViewModel$ViewState$Loaded) other;
        return m.areEqual(this.boostSlotMap, guildBoostViewModel$ViewState$Loaded.boostSlotMap) && m.areEqual(this.premiumSubscription, guildBoostViewModel$ViewState$Loaded.premiumSubscription) && m.areEqual(this.purchases, guildBoostViewModel$ViewState$Loaded.purchases) && m.areEqual(this.meUser, guildBoostViewModel$ViewState$Loaded.meUser) && m.areEqual(this.guild, guildBoostViewModel$ViewState$Loaded.guild);
    }

    public final Map<Long, ModelGuildBoostSlot> getBoostSlotMap() {
        return this.boostSlotMap;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final ModelSubscription getPremiumSubscription() {
        return this.premiumSubscription;
    }

    public final List<Purchase> getPurchases() {
        return this.purchases;
    }

    public int hashCode() {
        Map<Long, ModelGuildBoostSlot> map = this.boostSlotMap;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        ModelSubscription modelSubscription = this.premiumSubscription;
        int iHashCode2 = (iHashCode + (modelSubscription != null ? modelSubscription.hashCode() : 0)) * 31;
        List<Purchase> list = this.purchases;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        MeUser meUser = this.meUser;
        int iHashCode4 = (iHashCode3 + (meUser != null ? meUser.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        return iHashCode4 + (guild != null ? guild.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(boostSlotMap=");
        sbU.append(this.boostSlotMap);
        sbU.append(", premiumSubscription=");
        sbU.append(this.premiumSubscription);
        sbU.append(", purchases=");
        sbU.append(this.purchases);
        sbU.append(", meUser=");
        sbU.append(this.meUser);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(")");
        return sbU.toString();
    }
}
