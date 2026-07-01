package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompletableComparator;
import com.discord.widgets.chat.input.autocomplete.ChannelAutocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.m;
import java.util.Map;
import java.util.TreeSet;
import rx.functions.Func3;

/* JADX INFO: compiled from: ChannelAutocompletableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelAutocompletableSource$observeChannelAutocompletables$1<T1, T2, T3, R> implements Func3<Map<Long, ? extends Channel>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>> {
    public static final ChannelAutocompletableSource$observeChannelAutocompletables$1 INSTANCE = new ChannelAutocompletableSource$observeChannelAutocompletables$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(Map<Long, ? extends Channel> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends Long> map3) {
        return call2((Map<Long, Channel>) map, (Map<Long, Channel>) map2, (Map<Long, Long>) map3);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(Map<Long, Channel> map, Map<Long, Channel> map2, Map<Long, Long> map3) {
        TreeSet treeSet = new TreeSet(new AutocompletableComparator());
        m.checkNotNullExpressionValue(map2, "activeJoinedThreads");
        m.checkNotNullExpressionValue(map, "guildChannels");
        for (Channel channel : h0.plus(map2, map).values()) {
            if (ChannelUtils.v(channel) || ChannelUtils.J(channel) || ChannelUtils.k(channel)) {
                m.checkNotNullExpressionValue(map3, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS);
                if (PermissionUtils.hasAccess(channel, map3)) {
                    treeSet.add(new ChannelAutocompletable(channel));
                }
            }
        }
        return g0.mapOf(o.to(LeadingIdentifier.CHANNELS, treeSet));
    }
}
