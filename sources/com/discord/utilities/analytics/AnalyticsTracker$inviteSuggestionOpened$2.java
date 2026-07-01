package com.discord.utilities.analytics;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.h0;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsTracker$inviteSuggestionOpened$2 extends o implements Function1<Set<? extends Long>, Unit> {
    public final /* synthetic */ List $channelSuggestions;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ List $userSuggestions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticsTracker$inviteSuggestionOpened$2(List list, List list2, long j) {
        super(1);
        this.$channelSuggestions = list;
        this.$userSuggestions = list2;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Long> set) {
        invoke2((Set<Long>) set);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Set<Long> set) {
        List list = this.$channelSuggestions;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            Integer numValueOf = Integer.valueOf(((Channel) obj).getType());
            Object arrayList = linkedHashMap.get(numValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(numValueOf, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        List list2 = (List) linkedHashMap.get(1);
        int size = list2 != null ? list2.size() : 0;
        List list3 = (List) linkedHashMap.get(3);
        AnalyticsTracker.INSTANCE.getTracker().track("invite_suggestion_opened", h0.mapOf(d0.o.to("num_suggestions", Integer.valueOf(this.$userSuggestions.size() + this.$channelSuggestions.size())), d0.o.to("num_friends", Integer.valueOf(set.size())), d0.o.to("num_dms", Integer.valueOf(this.$userSuggestions.size() + size)), d0.o.to("num_group_dms", Integer.valueOf(list3 != null ? list3.size() : 0)), d0.o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(this.$guildId))));
    }
}
