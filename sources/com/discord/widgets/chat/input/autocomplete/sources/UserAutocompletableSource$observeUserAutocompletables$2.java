package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.z.d.m;
import java.util.Map;
import java.util.TreeSet;
import rx.functions.Func8;

/* JADX INFO: compiled from: UserMentionableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAutocompletableSource$observeUserAutocompletables$2<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<Long, Long, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Map<Long, ? extends User>, Map<Long, ? extends Presence>, Long, Channel, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ UserAutocompletableSource this$0;

    public UserAutocompletableSource$observeUserAutocompletables$2(UserAutocompletableSource userAutocompletableSource, Channel channel) {
        this.this$0 = userAutocompletableSource;
        this.$channel = channel;
    }

    @Override // rx.functions.Func8
    public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(Long l, Long l2, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Map<Long, ? extends User> map3, Map<Long, ? extends Presence> map4, Long l3, Channel channel) {
        return call2(l, l2, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, map3, (Map<Long, Presence>) map4, l3, channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(Long l, Long l2, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, ? extends User> map3, Map<Long, Presence> map4, Long l3, Channel channel) {
        UserAutocompletableSource userAutocompletableSource = this.this$0;
        m.checkNotNullExpressionValue(l, "myId");
        long jLongValue = l.longValue();
        Channel channel2 = this.$channel;
        m.checkNotNullExpressionValue(l2, "guildOwnerId");
        long jLongValue2 = l2.longValue();
        m.checkNotNullExpressionValue(map, "roles");
        m.checkNotNullExpressionValue(map2, "members");
        m.checkNotNullExpressionValue(map3, "users");
        m.checkNotNullExpressionValue(map4, "presences");
        return UserAutocompletableSource.access$createAutocompletablesForUsers(userAutocompletableSource, jLongValue, channel2, channel, jLongValue2, map, map2, map3, map4, l3);
    }
}
