package com.discord.widgets.user;

import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserProfile;
import com.discord.widgets.user.WidgetUserMutualGuilds;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualGuilds$Model$Companion$get$1 extends AbstractC12240o implements Function0<WidgetUserMutualGuilds.Model> {
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreGuildsSorted $storeGuildsSorted;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreUserProfile $storeUserProfile;
    public final /* synthetic */ long $userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMutualGuilds$Model$Companion$get$1(StoreUserProfile storeUserProfile, long j, StoreGuildsSorted storeGuildsSorted, StoreUser storeUser, StoreGuilds storeGuilds) {
        super(0);
        this.$storeUserProfile = storeUserProfile;
        this.$userId = j;
        this.$storeGuildsSorted = storeGuildsSorted;
        this.$storeUser = storeUser;
        this.$storeGuilds = storeGuilds;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetUserMutualGuilds.Model invoke() {
        return new WidgetUserMutualGuilds.Model(this.$storeUserProfile.getUserProfile(this.$userId), this.$storeGuildsSorted.getOrderedGuilds(), this.$storeUser.getUsers().get(Long.valueOf(this.$userId)), this.$storeGuilds.getMembers());
    }
}
