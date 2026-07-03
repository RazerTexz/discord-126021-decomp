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
import com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog;
import com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog;
import com.discord.widgets.servers.member_verification.WidgetMemberVerification;
import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.C12111j;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MemberVerificationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationUtils {
    public static final MemberVerificationUtils INSTANCE = new MemberVerificationUtils();

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ApplicationStatus.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationStatus.APPROVED.ordinal()] = 1;
            iArr[ApplicationStatus.PENDING.ordinal()] = 2;
            iArr[ApplicationStatus.REJECTED.ordinal()] = 3;
            iArr[ApplicationStatus.STARTED.ordinal()] = 4;
            iArr[ApplicationStatus.UNKNOWN.ordinal()] = 5;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.guilds.MemberVerificationUtils$maybeShowVerificationGate$1 */
    /* JADX INFO: compiled from: MemberVerificationUtils.kt */
    public static final class C67681 extends AbstractC12240o implements Function0<Unit> {
        public static final C67681 INSTANCE = new C67681();

        public C67681() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

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

    private final void showMemberVerificationPendingDialog(FragmentManager fragmentManager, long guildId) {
        MemberVerificationPendingDialog.Companion.show$default(MemberVerificationPendingDialog.INSTANCE, fragmentManager, guildId, null, 4, null);
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
        MemberVerificationSuccessDialog.INSTANCE.enqueue(guild.getId());
    }

    public static /* synthetic */ void showMemberVerificationSuccessDialog$default(MemberVerificationUtils memberVerificationUtils, Guild guild, ModelInvite modelInvite, int i, Object obj) {
        if ((i & 2) != 0) {
            modelInvite = null;
        }
        memberVerificationUtils.showMemberVerificationSuccessDialog(guild, modelInvite);
    }

    private final void showMemberVerificationWidget(Context context, long guildId, String location, ModelInvite invite) {
        WidgetMemberVerification.INSTANCE.create(context, guildId, location, invite);
    }

    public static /* synthetic */ void showMemberVerificationWidget$default(MemberVerificationUtils memberVerificationUtils, Context context, long j, String str, ModelInvite modelInvite, int i, Object obj) {
        if ((i & 8) != 0) {
            modelInvite = null;
        }
        memberVerificationUtils.showMemberVerificationWidget(context, j, str, modelInvite);
    }

    public final boolean hasVerificationGate(Guild guild, ModelInvite invite) {
        Collection collectionM7866m;
        com.discord.api.guild.Guild guild2;
        if (guild == null || (collectionM7866m = guild.getFeatures()) == null) {
            collectionM7866m = (invite == null || (guild2 = invite.guild) == null) ? null : guild2.m7866m();
        }
        if (collectionM7866m == null) {
            collectionM7866m = C12148n0.emptySet();
        }
        return collectionM7866m.contains(GuildFeature.MEMBER_VERIFICATION_GATE_ENABLED) && collectionM7866m.contains(GuildFeature.COMMUNITY);
    }

    public final void maybeShowVerificationGate(Context context, FragmentManager fragmentManager, long guildId, String location, ModelInvite invite, Function0<Unit> onMembershipGated, Function0<Unit> onFullMembership) {
        int iOrdinal;
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        C12238m.checkNotNullParameter(onMembershipGated, "onMembershipGated");
        C12238m.checkNotNullParameter(onFullMembership, "onFullMembership");
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreGuilds guilds = companion.getGuilds();
        GuildMember member = guilds.getMember(guildId, companion.getUsers().getMeSnapshot().getId());
        if (member != null && !member.getPending()) {
            onFullMembership.invoke();
            return;
        }
        Guild guild = guilds.getGuild(guildId);
        if (!hasVerificationGate(guild, invite)) {
            onFullMembership.invoke();
            return;
        }
        GuildJoinRequest guildJoinRequest = companion.getGuildJoinRequests().getGuildJoinRequest(guildId);
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
                throw new C12111j(null, 1, null);
            }
        } else {
            onFullMembership.invoke();
            showMemberVerificationSuccessDialog(guild, invite);
        }
    }
}
