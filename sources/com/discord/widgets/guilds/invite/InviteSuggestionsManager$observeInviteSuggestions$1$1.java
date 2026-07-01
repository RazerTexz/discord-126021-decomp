package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import rx.functions.Func2;

/* JADX INFO: compiled from: InviteSuggestionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteSuggestionsManager$observeInviteSuggestions$1$1<T1, T2, R> implements Func2<Map<Long, ? extends User>, Map<Long, ? extends Integer>, InviteSuggestionsManager$UserAffinityData> {
    public final /* synthetic */ List $affinityUserIds;

    public InviteSuggestionsManager$observeInviteSuggestions$1$1(List list) {
        this.$affinityUserIds = list;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ InviteSuggestionsManager$UserAffinityData call(Map<Long, ? extends User> map, Map<Long, ? extends Integer> map2) {
        return call2(map, (Map<Long, Integer>) map2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final InviteSuggestionsManager$UserAffinityData call2(Map<Long, ? extends User> map, Map<Long, Integer> map2) {
        List list = this.$affinityUserIds;
        m.checkNotNullExpressionValue(list, "affinityUserIds");
        m.checkNotNullExpressionValue(map, "users");
        m.checkNotNullExpressionValue(map2, "relationships");
        return new InviteSuggestionsManager$UserAffinityData(list, map, map2);
    }
}
