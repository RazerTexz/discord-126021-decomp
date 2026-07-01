package com.discord.widgets.servers.auditlog;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreAuditLog$AuditLogState;
import d0.f0.n;
import d0.f0.q;
import d0.g0.t;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.sequences.Sequence;
import rx.functions.Func5;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter$Model$Companion$get$2<T1, T2, T3, T4, T5, R> implements Func5<StoreAuditLog$AuditLogState, Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, List<? extends Integer>, String, WidgetServerSettingsAuditLogFilter$Model> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ int $filterType;

    public WidgetServerSettingsAuditLogFilter$Model$Companion$get$2(int i, Context context) {
        this.$filterType = i;
        this.$context = context;
    }

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetServerSettingsAuditLogFilter$Model call(StoreAuditLog$AuditLogState storeAuditLog$AuditLogState, Map<Long, ? extends User> map, Map<Long, ? extends GuildMember> map2, List<? extends Integer> list, String str) {
        return call2(storeAuditLog$AuditLogState, map, (Map<Long, GuildMember>) map2, (List<Integer>) list, str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsAuditLogFilter$Model call2(StoreAuditLog$AuditLogState storeAuditLog$AuditLogState, Map<Long, ? extends User> map, Map<Long, GuildMember> map2, List<Integer> list, String str) {
        Sequence sequenceEmptySequence;
        if (this.$filterType != 0) {
            m.checkNotNullExpressionValue(list, "actions");
            return new WidgetServerSettingsAuditLogFilter$Model(q.toList(q.sortedWith(q.map(q.filter(u.asSequence(list), new WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$1(this, str)), new WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$2(this, storeAuditLog$AuditLogState)), new WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$$special$$inlined$sortedBy$2())));
        }
        m.checkNotNullExpressionValue(str, "filterText");
        if (t.isBlank(str)) {
            sequenceEmptySequence = u.asSequence(d0.t.m.listOf(new WidgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem(null, null, 0L, this.$context.getString(2131891182), null, storeAuditLog$AuditLogState.getFilter().getUserFilter() == 0)));
        } else {
            sequenceEmptySequence = n.emptySequence();
        }
        return new WidgetServerSettingsAuditLogFilter$Model(q.toList(q.sortedWith(q.plus(sequenceEmptySequence, q.map(q.filterNotNull(q.filter(u.asSequence(map.values()), new WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$listItems$1(str))), new WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$listItems$2(map2, storeAuditLog$AuditLogState))), new WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$$special$$inlined$sortedBy$1())));
    }
}
