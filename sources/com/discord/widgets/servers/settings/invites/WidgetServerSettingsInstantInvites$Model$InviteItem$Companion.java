package com.discord.widgets.servers.settings.invites;

import com.discord.api.user.User;
import com.discord.models.domain.ModelInvite;
import com.discord.models.member.GuildMember;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvites$Model$InviteItem$Companion {
    private WidgetServerSettingsInstantInvites$Model$InviteItem$Companion() {
    }

    public final List<WidgetServerSettingsInstantInvites$Model$InviteItem> createList(Map<String, ? extends ModelInvite> invites, long guildId, Map<Long, GuildMember> guildMembers) {
        m.checkNotNullParameter(invites, "invites");
        m.checkNotNullParameter(guildMembers, "guildMembers");
        Collection<? extends ModelInvite> collectionValues = invites.values();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(collectionValues, 10));
        for (ModelInvite modelInvite : collectionValues) {
            User inviter = modelInvite.getInviter();
            arrayList.add(new WidgetServerSettingsInstantInvites$Model$InviteItem(modelInvite, guildId, inviter != null ? guildMembers.get(Long.valueOf(inviter.getId())) : null));
        }
        return u.sorted(arrayList);
    }

    public /* synthetic */ WidgetServerSettingsInstantInvites$Model$InviteItem$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
