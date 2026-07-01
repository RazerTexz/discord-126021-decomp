package com.discord.utilities.guilds;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog;
import com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$Companion;
import com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog;
import com.discord.widgets.servers.member_verification.WidgetMemberVerification;
import d0.j;
import d0.t.n0;
import d0.z.d.m;
import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MemberVerificationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationUtils {
    public static final MemberVerificationUtils INSTANCE = new MemberVerificationUtils();

    private MemberVerificationUtils() {
    }

    public static /* synthetic */ boolean hasVerificationGate$default(MemberVerificationUtils memberVerificationUtils, Guild guild, ModelInvite modelInvite, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = null;
        }
        if ((i & 2) != 0) {
            modelInvite = null;
        }
        return memberVerificationUtils.hasVerificationGate(guild, modelInvite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void maybeShowVerificationGate$default(MemberVerificationUtils memberVerificationUtils, Context context, FragmentManager fragmentManager, long j, String str, ModelInvite modelInvite, Function0 function0, Function0 function1, int i, Object obj) {
        memberVerificationUtils.maybeShowVerificationGate(context, fragmentManager, j, str, (i & 16) != 0 ? null : modelInvite, (i & 32) != 0 ? MemberVerificationUtils$maybeShowVerificationGate$1.INSTANCE : function0, function1);
    }

    private final void showMemberVerificationPendingDialog(FragmentManager fragmentManager, long guildId) {
        MemberVerificationPendingDialog$Companion.show$default(MemberVerificationPendingDialog.Companion, fragmentManager, guildId, null, 4, null);
    }

    private final void showMemberVerificationSuccessDialog(Guild guild, ModelInvite invite) {
        String name;
        com.discord.api.guild.Guild guild2;
        if (guild == null || (name = guild.getName()) == null) {
            name = (invite == null || (guild2 = invite.guild) == null) ? null : guild2.getName();
        }
        if (name == null || guild == null) {
            return;
        }
        MemberVerificationSuccessDialog.Companion.enqueue(guild.getId());
    }

    public static /* synthetic */ void showMemberVerificationSuccessDialog$default(MemberVerificationUtils memberVerificationUtils, Guild guild, ModelInvite modelInvite, int i, Object obj) {
        if ((i & 2) != 0) {
            modelInvite = null;
        }
        memberVerificationUtils.showMemberVerificationSuccessDialog(guild, modelInvite);
    }

    private final void showMemberVerificationWidget(Context context, long guildId, String location, ModelInvite invite) {
        WidgetMemberVerification.Companion.create(context, guildId, location, invite);
    }

    public static /* synthetic */ void showMemberVerificationWidget$default(MemberVerificationUtils memberVerificationUtils, Context context, long j, String str, ModelInvite modelInvite, int i, Object obj) {
        if ((i & 8) != 0) {
            modelInvite = null;
        }
        memberVerificationUtils.showMemberVerificationWidget(context, j, str, modelInvite);
    }

    public final boolean hasVerificationGate(Guild guild, ModelInvite invite) {
        Collection collectionM;
        com.discord.api.guild.Guild guild2;
        if (guild == null || (collectionM = guild.getFeatures()) == null) {
            collectionM = (invite == null || (guild2 = invite.guild) == null) ? null : guild2.m();
        }
        if (collectionM == null) {
            collectionM = n0.emptySet();
        }
        return collectionM.contains(GuildFeature.MEMBER_VERIFICATION_GATE_ENABLED) && collectionM.contains(GuildFeature.COMMUNITY);
    }

    public final void maybeShowVerificationGate(Context context, FragmentManager fragmentManager, long guildId, String location, ModelInvite invite, Function0<Unit> onMembershipGated, Function0<Unit> onFullMembership) {
        int iOrdinal;
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        m.checkNotNullParameter(onMembershipGated, "onMembershipGated");
        m.checkNotNullParameter(onFullMembership, "onFullMembership");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreGuilds guilds = storeStream$Companion.getGuilds();
        GuildMember member = guilds.getMember(guildId, storeStream$Companion.getUsers().getMeSnapshot().getId());
        if (member != null && !member.getPending()) {
            onFullMembership.invoke();
            return;
        }
        Guild guild = guilds.getGuild(guildId);
        if (!hasVerificationGate(guild, invite)) {
            onFullMembership.invoke();
            return;
        }
        GuildJoinRequest guildJoinRequest = storeStream$Companion.getGuildJoinRequests().getGuildJoinRequest(guildId);
        ApplicationStatus applicationStatus = guildJoinRequest != null ? guildJoinRequest.getApplicationStatus() : null;
        if (applicationStatus == null || (iOrdinal = applicationStatus.ordinal()) == 0) {
            onMembershipGated.invoke();
            showMemberVerificationWidget(context, guildId, location, invite);
            return;
        }
        if (iOrdinal == 1) {
            onMembershipGated.invoke();
            showMemberVerificationPendingDialog(fragmentManager, guildId);
        } else if (iOrdinal == 2) {
            onMembershipGated.invoke();
            showMemberVerificationPendingDialog(fragmentManager, guildId);
        } else if (iOrdinal != 3) {
            if (iOrdinal == 4) {
                throw new j(null, 1, null);
            }
        } else {
            onFullMembership.invoke();
            showMemberVerificationSuccessDialog(guild, invite);
        }
    }
}
