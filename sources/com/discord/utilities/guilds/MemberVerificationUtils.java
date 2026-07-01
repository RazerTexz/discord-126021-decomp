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
import d0.Standard2;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

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

    /* JADX INFO: renamed from: com.discord.utilities.guilds.MemberVerificationUtils$maybeShowVerificationGate$1, reason: invalid class name */
    /* JADX INFO: compiled from: MemberVerificationUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
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
        Collection collectionM;
        com.discord.api.guild.Guild guild2;
        if (guild == null || (collectionM = guild.getFeatures()) == null) {
            collectionM = (invite == null || (guild2 = invite.guild) == null) ? null : guild2.m();
        }
        if (collectionM == null) {
            collectionM = Sets5.emptySet();
        }
        return collectionM.contains(GuildFeature.MEMBER_VERIFICATION_GATE_ENABLED) && collectionM.contains(GuildFeature.COMMUNITY);
    }

    public final void maybeShowVerificationGate(Context context, FragmentManager fragmentManager, long guildId, String location, ModelInvite invite, Function0<Unit> onMembershipGated, Function0<Unit> onFullMembership) {
        int iOrdinal;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intrinsics3.checkNotNullParameter(onMembershipGated, "onMembershipGated");
        Intrinsics3.checkNotNullParameter(onFullMembership, "onFullMembership");
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
                throw new Standard2(null, 1, null);
            }
        } else {
            onFullMembership.invoke();
            showMemberVerificationSuccessDialog(guild, invite);
        }
    }
}
