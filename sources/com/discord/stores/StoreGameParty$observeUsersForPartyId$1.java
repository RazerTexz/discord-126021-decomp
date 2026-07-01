package com.discord.stores;

import com.discord.models.user.User;
import d0.t.g0;
import d0.t.n;
import d0.t.u;
import d0.z.d.o;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGameParty.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGameParty$observeUsersForPartyId$1 extends o implements Function0<Map<Long, ? extends User>> {
    public final /* synthetic */ String $partyId;
    public final /* synthetic */ StoreGameParty this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGameParty$observeUsersForPartyId$1(StoreGameParty storeGameParty, String str) {
        super(0);
        this.this$0 = storeGameParty;
        this.$partyId = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends User> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends User> invoke2() {
        List listEmptyList;
        HashSet hashSet = (HashSet) StoreGameParty.access$getPartiesSnapshot$p(this.this$0).get(this.$partyId);
        StoreUser storeUser = this.this$0.getStoreUser();
        if (hashSet == null || (listEmptyList = u.toList(hashSet)) == null) {
            listEmptyList = n.emptyList();
        }
        SortedMap sortedMap = g0.toSortedMap(storeUser.getUsers(listEmptyList, false));
        Objects.requireNonNull(sortedMap, "null cannot be cast to non-null type kotlin.collections.Map<com.discord.primitives.UserId /* = kotlin.Long */, com.discord.models.user.User>");
        return sortedMap;
    }
}
