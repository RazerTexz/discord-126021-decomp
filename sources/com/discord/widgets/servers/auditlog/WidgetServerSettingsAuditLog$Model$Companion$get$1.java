package com.discord.widgets.servers.auditlog;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelAuditLogEntry$TargetType;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.domain.ModelWebhook;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreAuditLog$AuditLogState;
import com.discord.utilities.auditlogs.AuditLogChangeUtils;
import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.NoWhenBranchMatchedException;
import rx.functions.Func6;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLog$Model$Companion$get$1<T1, T2, T3, T4, T5, T6, R> implements Func6<StoreAuditLog$AuditLogState, Guild, Map<Long, ? extends Channel>, Map<Long, ? extends User>, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, WidgetServerSettingsAuditLog$Model> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ long $guildId;

    public WidgetServerSettingsAuditLog$Model$Companion$get$1(long j, Context context) {
        this.$guildId = j;
        this.$context = context;
    }

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetServerSettingsAuditLog$Model call(StoreAuditLog$AuditLogState storeAuditLog$AuditLogState, Guild guild, Map<Long, ? extends Channel> map, Map<Long, ? extends User> map2, Map<Long, ? extends GuildRole> map3, Map<Long, ? extends GuildMember> map4) {
        return call2(storeAuditLog$AuditLogState, guild, (Map<Long, Channel>) map, map2, (Map<Long, GuildRole>) map3, (Map<Long, GuildMember>) map4);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:30:0x00aa  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsAuditLog$Model call2(StoreAuditLog$AuditLogState storeAuditLog$AuditLogState, Guild guild, Map<Long, Channel> map, Map<Long, ? extends User> map2, Map<Long, GuildRole> map3, Map<Long, GuildMember> map4) {
        CharSequence string;
        CharSequence userNameWithDiscriminator$default;
        Channel channel;
        CharSequence charSequenceAccess$resolveChannelName;
        Map map5;
        Map<Long, Channel> map6 = map;
        if ((storeAuditLog$AuditLogState != null ? storeAuditLog$AuditLogState.getEntries() : null) == null || guild == null) {
            return WidgetServerSettingsAuditLog$Model$Loading.INSTANCE;
        }
        HashMap map7 = new HashMap();
        map7.putAll(storeAuditLog$AuditLogState.getDeletedTargets());
        for (ModelAuditLogEntry modelAuditLogEntry : storeAuditLog$AuditLogState.getEntries()) {
            if (map7.get(modelAuditLogEntry.getTargetType()) == null) {
                ModelAuditLogEntry$TargetType targetType = modelAuditLogEntry.getTargetType();
                m.checkNotNullExpressionValue(targetType, "entry.targetType");
                map7.put(targetType, new HashMap());
            }
            ModelAuditLogEntry$TargetType targetType2 = modelAuditLogEntry.getTargetType();
            if (targetType2 == null) {
                charSequenceAccess$resolveChannelName = null;
            } else {
                switch (targetType2) {
                    case ALL:
                    case UNKNOWN:
                    case GUILD:
                    case INVITE:
                    case WEBHOOK:
                    case EMOJI:
                    case INTEGRATION:
                    case STAGE_INSTANCE:
                    case GUILD_SCHEDULED_EVENT:
                    case STICKER:
                    case THREAD:
                        charSequenceAccess$resolveChannelName = null;
                        break;
                    case CHANNEL:
                    case CHANNEL_OVERWRITE:
                        WidgetServerSettingsAuditLog$Model$Companion widgetServerSettingsAuditLog$Model$Companion = WidgetServerSettingsAuditLog$Model.Companion;
                        m.checkNotNullExpressionValue(map6, "channels");
                        charSequenceAccess$resolveChannelName = WidgetServerSettingsAuditLog$Model$Companion.access$resolveChannelName(widgetServerSettingsAuditLog$Model$Companion, map6, modelAuditLogEntry);
                        break;
                    case USER:
                        User user = map2.get(Long.valueOf(modelAuditLogEntry.getTargetId()));
                        if (user != null) {
                            charSequenceAccess$resolveChannelName = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
                        } else {
                            charSequenceAccess$resolveChannelName = null;
                        }
                        break;
                    case ROLE:
                        GuildRole guildRole = map3.get(Long.valueOf(modelAuditLogEntry.getTargetId()));
                        if (guildRole != null) {
                            charSequenceAccess$resolveChannelName = guildRole.getName();
                        } else {
                            charSequenceAccess$resolveChannelName = null;
                        }
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            if (charSequenceAccess$resolveChannelName != null && (map5 = (Map) map7.get(modelAuditLogEntry.getTargetType())) != null) {
            }
        }
        ModelAuditLogEntry$TargetType modelAuditLogEntry$TargetType = ModelAuditLogEntry$TargetType.CHANNEL;
        if (map7.get(modelAuditLogEntry$TargetType) == null) {
            map7.put(modelAuditLogEntry$TargetType, new HashMap());
        }
        m.checkNotNullExpressionValue(map6, "channels");
        Iterator<Map$Entry<Long, Channel>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                ModelAuditLogEntry$TargetType modelAuditLogEntry$TargetType2 = ModelAuditLogEntry$TargetType.USER;
                if (map7.get(modelAuditLogEntry$TargetType2) == null) {
                    map7.put(modelAuditLogEntry$TargetType2, new HashMap());
                }
                for (Map$Entry<Long, User> map$Entry : storeAuditLog$AuditLogState.getUsers().entrySet()) {
                    Map map8 = (Map) map7.get(ModelAuditLogEntry$TargetType.USER);
                    if (map8 != null) {
                    }
                }
                ModelAuditLogEntry$TargetType modelAuditLogEntry$TargetType3 = ModelAuditLogEntry$TargetType.GUILD;
                if (map7.get(modelAuditLogEntry$TargetType3) == null) {
                    map7.put(modelAuditLogEntry$TargetType3, new HashMap());
                }
                Map map9 = (Map) map7.get(modelAuditLogEntry$TargetType3);
                if (map9 != null) {
                }
                ModelAuditLogEntry$TargetType modelAuditLogEntry$TargetType4 = ModelAuditLogEntry$TargetType.WEBHOOK;
                if (map7.get(modelAuditLogEntry$TargetType4) == null) {
                    map7.put(modelAuditLogEntry$TargetType4, new HashMap());
                }
                for (ModelWebhook modelWebhook : storeAuditLog$AuditLogState.getWebhooks()) {
                    Map map10 = (Map) map7.get(ModelAuditLogEntry$TargetType.WEBHOOK);
                    if (map10 != null) {
                    }
                }
                ModelAuditLogEntry$TargetType modelAuditLogEntry$TargetType5 = ModelAuditLogEntry$TargetType.INTEGRATION;
                if (map7.get(modelAuditLogEntry$TargetType5) == null) {
                    map7.put(modelAuditLogEntry$TargetType5, new HashMap());
                }
                for (ModelGuildIntegration modelGuildIntegration : storeAuditLog$AuditLogState.getIntegrations()) {
                    Map map11 = (Map) map7.get(ModelAuditLogEntry$TargetType.INTEGRATION);
                    if (map11 != null) {
                    }
                }
                ModelAuditLogEntry$TargetType modelAuditLogEntry$TargetType6 = ModelAuditLogEntry$TargetType.GUILD_SCHEDULED_EVENT;
                if (map7.get(modelAuditLogEntry$TargetType6) == null) {
                    map7.put(modelAuditLogEntry$TargetType6, new HashMap());
                }
                for (GuildScheduledEvent guildScheduledEvent : storeAuditLog$AuditLogState.getGuildScheduledEvents()) {
                    Map map12 = (Map) map7.get(ModelAuditLogEntry$TargetType.GUILD_SCHEDULED_EVENT);
                    if (map12 != null) {
                    }
                }
                ModelAuditLogEntry$TargetType modelAuditLogEntry$TargetType7 = ModelAuditLogEntry$TargetType.THREAD;
                if (map7.get(modelAuditLogEntry$TargetType7) == null) {
                    map7.put(modelAuditLogEntry$TargetType7, new HashMap());
                }
                for (Channel channel2 : storeAuditLog$AuditLogState.getThreads()) {
                    Map map13 = (Map) map7.get(ModelAuditLogEntry$TargetType.THREAD);
                    if (map13 != null) {
                    }
                }
                boolean z2 = true;
                ArrayList arrayList = new ArrayList(storeAuditLog$AuditLogState.getEntries().size() + 1);
                List<ModelAuditLogEntry> entries = storeAuditLog$AuditLogState.getEntries();
                ArrayList<ModelAuditLogEntry> arrayList2 = new ArrayList();
                for (Object obj : entries) {
                    if (AuditLogUtils.INSTANCE.getALL_ACTION_TYPES().contains(Integer.valueOf(((ModelAuditLogEntry) obj).getActionTypeId()))) {
                        arrayList2.add(obj);
                    }
                }
                for (ModelAuditLogEntry modelAuditLogEntry2 : arrayList2) {
                    String str = ((modelAuditLogEntry2.getTargetType() == ModelAuditLogEntry$TargetType.CHANNEL || modelAuditLogEntry2.getTargetType() == ModelAuditLogEntry$TargetType.CHANNEL_OVERWRITE) && (channel = map6.get(Long.valueOf(modelAuditLogEntry2.getTargetId()))) != null && ChannelUtils.v(channel) == z2) ? "#" : "";
                    User user2 = storeAuditLog$AuditLogState.getUsers().get(Long.valueOf(modelAuditLogEntry2.getUserId()));
                    CharSequence charSequence = (user2 == null || (userNameWithDiscriminator$default = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user2, null, null, 3, null)) == null) ? "" : userNameWithDiscriminator$default;
                    long id2 = modelAuditLogEntry2.getId();
                    Long selectedItemId = storeAuditLog$AuditLogState.getSelectedItemId();
                    boolean z3 = selectedItemId != null && id2 == selectedItemId.longValue();
                    User user3 = storeAuditLog$AuditLogState.getUsers().get(Long.valueOf(modelAuditLogEntry2.getUserId()));
                    GuildMember guildMember = map4.get(Long.valueOf(modelAuditLogEntry2.getUserId()));
                    AuditLogUtils auditLogUtils = AuditLogUtils.INSTANCE;
                    CharSequence headerString = auditLogUtils.getHeaderString(modelAuditLogEntry2, charSequence, this.$context, map7, str);
                    AuditLogChangeUtils auditLogChangeUtils = AuditLogChangeUtils.INSTANCE;
                    arrayList.add(new WidgetServerSettingsAuditLogAdapter$AuditLogEntryItem(modelAuditLogEntry2, z3, user3, guildMember, headerString, auditLogChangeUtils.getChangeSummary(this.$context, modelAuditLogEntry2, map7), auditLogChangeUtils.hasChangesToRender(modelAuditLogEntry2), auditLogUtils.getTimestampString(modelAuditLogEntry2, this.$context)));
                    z2 = true;
                    map6 = map;
                }
                if (storeAuditLog$AuditLogState.isLoading()) {
                    arrayList.add(new WidgetServerSettingsAuditLogAdapter$AuditLogLoadingItem());
                }
                User user4 = map2.get(Long.valueOf(storeAuditLog$AuditLogState.getFilter().getUserFilter()));
                if (user4 == null || (string = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user4, null, null, 3, null)) == null) {
                    string = this.$context.getString(2131891182);
                    m.checkNotNullExpressionValue(string, "context.getString(R.stri…ettings_filter_all_users)");
                }
                String string2 = this.$context.getString(AuditLogUtils.INSTANCE.getActionName(storeAuditLog$AuditLogState.getFilter().getActionFilter()));
                m.checkNotNullExpressionValue(string2, "context.getString(AuditL…ate.filter.actionFilter))");
                return new WidgetServerSettingsAuditLog$Model$Loaded(arrayList, string, string2);
            }
            Map$Entry<Long, Channel> next = it.next();
            String str2 = ChannelUtils.v(next.getValue()) ? "#" : "";
            Map map14 = (Map) map7.get(ModelAuditLogEntry$TargetType.CHANNEL);
            if (map14 != null) {
                Long lValueOf = Long.valueOf(next.getValue().getId());
                StringBuilder sbU = a.U(str2);
                sbU.append(ChannelUtils.c(next.getValue()));
            }
        }
    }
}
