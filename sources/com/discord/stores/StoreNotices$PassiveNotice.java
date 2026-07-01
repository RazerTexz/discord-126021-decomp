package com.discord.stores;

import androidx.fragment.app.FragmentActivity;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.u;
import d0.z.d.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public class StoreNotices$PassiveNotice extends StoreNotices$Notice {
    public /* synthetic */ StoreNotices$PassiveNotice(String str, int i, boolean z2, long j, long j2, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? 31536000000L : j, (i2 & 16) != 0 ? 21600000L : j2, function1);
    }

    @Override // com.discord.stores.StoreNotices$Notice
    public boolean shouldShow(Map<Integer, Long> lastShownTimes) {
        m.checkNotNullParameter(lastShownTimes, "lastShownTimes");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map$Entry<Integer, Long>> it = lastShownTimes.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map$Entry<Integer, Long> next = it.next();
            if (next.getKey().intValue() <= getPriority()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        Long l = (Long) u.maxOrNull((Iterable) linkedHashMap.values());
        return getDelayPeriodMs() < getClock().currentTimeMillis() - (l != null ? l.longValue() : 0L);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreNotices$PassiveNotice(String str, int i, boolean z2, long j, long j2, Function1<? super FragmentActivity, Boolean> function1) {
        super(str, null, 0L, i, z2, null, j2, false, j, function1, Opcodes.IF_ACMPNE, null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(function1, "show");
    }
}
