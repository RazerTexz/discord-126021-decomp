package com.discord.widgets.servers.member_verification;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.t.m;
import d0.z.d.a0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationPendingDialog$Companion {
    private MemberVerificationPendingDialog$Companion() {
    }

    public static /* synthetic */ void enqueue$default(MemberVerificationPendingDialog$Companion memberVerificationPendingDialog$Companion, long j, MemberVerificationPendingViewModel$DialogState memberVerificationPendingViewModel$DialogState, int i, Object obj) {
        if ((i & 2) != 0) {
            memberVerificationPendingViewModel$DialogState = null;
        }
        memberVerificationPendingDialog$Companion.enqueue(j, memberVerificationPendingViewModel$DialogState);
    }

    public static /* synthetic */ void show$default(MemberVerificationPendingDialog$Companion memberVerificationPendingDialog$Companion, FragmentManager fragmentManager, long j, MemberVerificationPendingViewModel$DialogState memberVerificationPendingViewModel$DialogState, int i, Object obj) {
        if ((i & 4) != 0) {
            memberVerificationPendingViewModel$DialogState = null;
        }
        memberVerificationPendingDialog$Companion.show(fragmentManager, j, memberVerificationPendingViewModel$DialogState);
    }

    public final void enqueue(long guildId, MemberVerificationPendingViewModel$DialogState dialogState) {
        StoreNotices notices = StoreStream.Companion.getNotices();
        String strT = a.t("MEMBERVERIFICATION-", guildId);
        notices.requestToShow(new StoreNotices$Notice(strT, null, 0L, 0, false, m.listOf(a0.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new MemberVerificationPendingDialog$Companion$enqueue$memberVerificationPendingDialogNotice$1(guildId, dialogState, notices, strT), 150, null));
    }

    public final void show(FragmentManager supportFragmentManager, long guildId, MemberVerificationPendingViewModel$DialogState dialogState) {
        d0.z.d.m.checkNotNullParameter(supportFragmentManager, "supportFragmentManager");
        MemberVerificationPendingDialog memberVerificationPendingDialog = new MemberVerificationPendingDialog();
        Bundle bundle = new Bundle();
        bundle.putLong(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        bundle.putSerializable("INTENT_EXTRA_DIALOG_STATE", dialogState);
        memberVerificationPendingDialog.setArguments(bundle);
        memberVerificationPendingDialog.show(supportFragmentManager, MemberVerificationPendingDialog.class.getSimpleName());
    }

    public /* synthetic */ MemberVerificationPendingDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
