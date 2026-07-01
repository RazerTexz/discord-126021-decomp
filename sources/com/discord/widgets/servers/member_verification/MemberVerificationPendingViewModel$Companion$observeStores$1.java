package com.discord.widgets.servers.member_verification;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.domain.ModelMemberVerificationForm;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildMemberVerificationForm$MemberVerificationFormData;
import rx.functions.Func3;

/* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationPendingViewModel$Companion$observeStores$1<T1, T2, T3, R> implements Func3<StoreGuildMemberVerificationForm$MemberVerificationFormData, Guild, GuildJoinRequest, MemberVerificationPendingViewModel$StoreState> {
    public static final MemberVerificationPendingViewModel$Companion$observeStores$1 INSTANCE = new MemberVerificationPendingViewModel$Companion$observeStores$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ MemberVerificationPendingViewModel$StoreState call(StoreGuildMemberVerificationForm$MemberVerificationFormData storeGuildMemberVerificationForm$MemberVerificationFormData, Guild guild, GuildJoinRequest guildJoinRequest) {
        return call2(storeGuildMemberVerificationForm$MemberVerificationFormData, guild, guildJoinRequest);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final MemberVerificationPendingViewModel$StoreState call2(StoreGuildMemberVerificationForm$MemberVerificationFormData storeGuildMemberVerificationForm$MemberVerificationFormData, Guild guild, GuildJoinRequest guildJoinRequest) {
        ApplicationStatus applicationStatus;
        ModelMemberVerificationForm form;
        boolean z2 = (storeGuildMemberVerificationForm$MemberVerificationFormData == null || (form = storeGuildMemberVerificationForm$MemberVerificationFormData.getForm()) == null || !form.isFormOutdated()) ? false : true;
        boolean zHasFeature = guild != null ? guild.hasFeature(GuildFeature.PREVIEW_ENABLED) : false;
        if (guildJoinRequest == null || (applicationStatus = guildJoinRequest.getApplicationStatus()) == null) {
            applicationStatus = ApplicationStatus.STARTED;
        }
        return new MemberVerificationPendingViewModel$StoreState(z2, zHasFeature, applicationStatus, guildJoinRequest != null ? guildJoinRequest.getRejectionReason() : null);
    }
}
