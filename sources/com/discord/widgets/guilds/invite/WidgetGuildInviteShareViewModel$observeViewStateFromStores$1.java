package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.user.User;
import d0.g0.t;
import d0.g0.w;
import d0.t.h0;
import d0.t.n0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import rx.functions.Func5;

/* JADX INFO: compiled from: WidgetGuildInviteShareViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareViewModel$observeViewStateFromStores$1<T1, T2, T3, T4, T5, R> implements Func5<WidgetInviteModel, List<? extends InviteSuggestion>, String, Map<String, ? extends Set<? extends Long>>, Unit, WidgetGuildInviteShareViewModel$ViewState$Loaded> {
    public final /* synthetic */ WidgetGuildInviteShareViewModel this$0;

    public WidgetGuildInviteShareViewModel$observeViewStateFromStores$1(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel) {
        this.this$0 = widgetGuildInviteShareViewModel;
    }

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetGuildInviteShareViewModel$ViewState$Loaded call(WidgetInviteModel widgetInviteModel, List<? extends InviteSuggestion> list, String str, Map<String, ? extends Set<? extends Long>> map, Unit unit) {
        return call2(widgetInviteModel, list, str, (Map<String, ? extends Set<Long>>) map, unit);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:55:0x0119  */
    /* JADX WARN: Code duplicated, block: B:57:0x011d  */
    /* JADX WARN: Code duplicated, block: B:77:0x0140 A[SYNTHETIC] */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildInviteShareViewModel$ViewState$Loaded call2(WidgetInviteModel widgetInviteModel, List<? extends InviteSuggestion> list, String str, Map<String, ? extends Set<Long>> map, Unit unit) {
        boolean zContains;
        ArrayList arrayList;
        List listListOf;
        InviteSuggestionItem inviteSuggestionItem$UserItem;
        boolean z2;
        m.checkNotNullExpressionValue(map, "sentInvites");
        String strAccess$getInviteLink$p = WidgetGuildInviteShareViewModel.access$getInviteLink$p(this.this$0, widgetInviteModel.getInvite());
        m.checkNotNullExpressionValue(strAccess$getInviteLink$p, "widgetInviteModel.invite.inviteLink");
        Set<Long> setEmptySet = map.get(strAccess$getInviteLink$p);
        if (setEmptySet == null) {
            setEmptySet = n0.emptySet();
        }
        Set<Long> set = setEmptySet;
        boolean z3 = false;
        if (str == null || t.isBlank(str)) {
            m.checkNotNullExpressionValue(list, "inviteSuggestions");
        } else {
            ArrayList arrayListA0 = a.a0(list, "inviteSuggestions");
            for (Object obj : list) {
                InviteSuggestion inviteSuggestion = (InviteSuggestion) obj;
                if (inviteSuggestion instanceof InviteSuggestion$ChannelItem) {
                    zContains = w.contains((CharSequence) ChannelUtils.c(((InviteSuggestion$ChannelItem) inviteSuggestion).getChannel()), (CharSequence) str, true);
                } else {
                    if (!(inviteSuggestion instanceof InviteSuggestion$UserSuggestion)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    zContains = w.contains((CharSequence) ((InviteSuggestion$UserSuggestion) inviteSuggestion).getUser().getUsername(), (CharSequence) str, true);
                }
                if (zContains) {
                    arrayListA0.add(obj);
                }
            }
            list = arrayListA0;
        }
        List<Channel> dms = widgetInviteModel.getDms();
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(dms, 10));
        for (Channel channel : dms) {
            User userA = ChannelUtils.a(channel);
            arrayList2.add(d0.o.to(userA != null ? Long.valueOf(userA.getId()) : null, Long.valueOf(channel.getId())));
        }
        Map map2 = h0.toMap(arrayList2);
        if (true ^ list.isEmpty()) {
            arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
            for (InviteSuggestion inviteSuggestion2 : list) {
                if (inviteSuggestion2 instanceof InviteSuggestion$ChannelItem) {
                    InviteSuggestion$ChannelItem inviteSuggestion$ChannelItem = (InviteSuggestion$ChannelItem) inviteSuggestion2;
                    inviteSuggestionItem$UserItem = new InviteSuggestionItem$ChannelItem(inviteSuggestion$ChannelItem.getChannel(), set.contains(Long.valueOf(inviteSuggestion$ChannelItem.getChannel().getId())));
                } else {
                    if (inviteSuggestion2 instanceof InviteSuggestion$UserSuggestion) {
                        throw new NoWhenBranchMatchedException();
                    }
                    InviteSuggestion$UserSuggestion inviteSuggestion$UserSuggestion = (InviteSuggestion$UserSuggestion) inviteSuggestion2;
                    inviteSuggestionItem$UserItem = new InviteSuggestionItem$UserItem(inviteSuggestion$UserSuggestion.getUser(), u.contains(set, map2.get(Long.valueOf(inviteSuggestion$UserSuggestion.getUser().getId()))));
                }
                arrayList.add(inviteSuggestionItem$UserItem);
            }
            listListOf = arrayList;
        } else if (str == null || t.isBlank(str)) {
            arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
            while (r11.hasNext()) {
                if (inviteSuggestion2 instanceof InviteSuggestion$ChannelItem) {
                    InviteSuggestion$ChannelItem inviteSuggestion$ChannelItem2 = (InviteSuggestion$ChannelItem) inviteSuggestion2;
                    inviteSuggestionItem$UserItem = new InviteSuggestionItem$ChannelItem(inviteSuggestion$ChannelItem2.getChannel(), set.contains(Long.valueOf(inviteSuggestion$ChannelItem2.getChannel().getId())));
                } else {
                    if (inviteSuggestion2 instanceof InviteSuggestion$UserSuggestion) {
                        throw new NoWhenBranchMatchedException();
                    }
                    InviteSuggestion$UserSuggestion inviteSuggestion$UserSuggestion2 = (InviteSuggestion$UserSuggestion) inviteSuggestion2;
                    inviteSuggestionItem$UserItem = new InviteSuggestionItem$UserItem(inviteSuggestion$UserSuggestion2.getUser(), u.contains(set, map2.get(Long.valueOf(inviteSuggestion$UserSuggestion2.getUser().getId()))));
                }
                arrayList.add(inviteSuggestionItem$UserItem);
            }
            listListOf = arrayList;
        } else {
            listListOf = d0.t.m.listOf(InviteSuggestionItem.SearchNoResultsItem);
        }
        if (widgetInviteModel.getInvite() != null) {
            if (!widgetInviteModel.getInvite().isStatic() && !widgetInviteModel.isInviteFromStore()) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = true;
        }
        m.checkNotNullExpressionValue(widgetInviteModel, "widgetInviteModel");
        m.checkNotNullExpressionValue(str, "filter");
        return new WidgetGuildInviteShareViewModel$ViewState$Loaded(widgetInviteModel, listListOf, str, map, z2);
    }
}
