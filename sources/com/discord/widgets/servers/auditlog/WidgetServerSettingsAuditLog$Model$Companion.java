package com.discord.widgets.servers.auditlog;

import android.content.Context;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelAuditLogEntry$Change;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLog$Model$Companion {
    private WidgetServerSettingsAuditLog$Model$Companion() {
    }

    public static final /* synthetic */ String access$resolveChannelName(WidgetServerSettingsAuditLog$Model$Companion widgetServerSettingsAuditLog$Model$Companion, Map map, ModelAuditLogEntry modelAuditLogEntry) {
        return widgetServerSettingsAuditLog$Model$Companion.resolveChannelName(map, modelAuditLogEntry);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ac  */
    private final String resolveChannelName(Map<Long, Channel> channels, ModelAuditLogEntry entry) {
        Object oldValue;
        Object oldValue2;
        Object next;
        ModelAuditLogEntry$Change modelAuditLogEntry$Change;
        Object next2;
        ModelAuditLogEntry$Change modelAuditLogEntry$Change2;
        Channel channel = channels.get(Long.valueOf(entry.getTargetId()));
        if (channel != null) {
            boolean zV = ChannelUtils.v(channel);
            if (zV) {
                StringBuilder sbQ = a.Q(MentionUtilsKt.CHANNELS_CHAR);
                sbQ.append(ChannelUtils.c(channel));
                return sbQ.toString();
            }
            if (zV) {
                throw new NoWhenBranchMatchedException();
            }
            return ChannelUtils.c(channel);
        }
        if (entry.getActionTypeId() == 12) {
            List<ModelAuditLogEntry$Change> changes = entry.getChanges();
            if (changes != null) {
                Iterator<T> it = changes.iterator();
                do {
                    if (!it.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it.next();
                    modelAuditLogEntry$Change2 = (ModelAuditLogEntry$Change) next2;
                    m.checkNotNullExpressionValue(modelAuditLogEntry$Change2, "it");
                } while (!m.areEqual(modelAuditLogEntry$Change2.getKey(), ModelAuditLogEntry.CHANGE_KEY_NAME));
                ModelAuditLogEntry$Change modelAuditLogEntry$Change3 = (ModelAuditLogEntry$Change) next2;
                if (modelAuditLogEntry$Change3 != null) {
                    oldValue = modelAuditLogEntry$Change3.getOldValue();
                } else {
                    oldValue = null;
                }
            } else {
                oldValue = null;
            }
            if (!(oldValue instanceof String)) {
                oldValue = null;
            }
            String str = (String) oldValue;
            List<ModelAuditLogEntry$Change> changes2 = entry.getChanges();
            if (changes2 != null) {
                Iterator<T> it2 = changes2.iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    modelAuditLogEntry$Change = (ModelAuditLogEntry$Change) next;
                    m.checkNotNullExpressionValue(modelAuditLogEntry$Change, "it");
                } while (!m.areEqual(modelAuditLogEntry$Change.getKey(), "type"));
                ModelAuditLogEntry$Change modelAuditLogEntry$Change4 = (ModelAuditLogEntry$Change) next;
                if (modelAuditLogEntry$Change4 != null) {
                    oldValue2 = modelAuditLogEntry$Change4.getOldValue();
                } else {
                    oldValue2 = null;
                }
            } else {
                oldValue2 = null;
            }
            if (!(oldValue2 instanceof Long)) {
                oldValue2 = null;
            }
            Long l = (Long) oldValue2;
            if (str != null && l != null) {
                boolean zL = ChannelUtils.l((int) l.longValue());
                if (!zL) {
                    if (zL) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return str;
                }
                return MentionUtilsKt.CHANNELS_CHAR + str;
            }
        }
        return null;
    }

    public final Observable<WidgetServerSettingsAuditLog$Model> get(long guildId, Context context) {
        m.checkNotNullParameter(context, "context");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetServerSettingsAuditLog$Model> observableR = Observable.f(storeStream$Companion.getAuditLog().observeAuditLogState(guildId), storeStream$Companion.getGuilds().observeGuild(guildId), StoreChannels.observeChannelsForGuild$default(storeStream$Companion.getChannels(), guildId, null, 2, null), ObservableExtensionsKt.leadingEdgeThrottle(storeStream$Companion.getUsers().observeAllUsers(), 3L, TimeUnit.SECONDS), storeStream$Companion.getGuilds().observeRoles(guildId), storeStream$Companion.getGuilds().observeComputed(guildId), new WidgetServerSettingsAuditLog$Model$Companion$get$1(guildId, context)).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetServerSettingsAuditLog$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
