package com.discord.widgets.servers.member_verification;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationPendingDialog$Companion$enqueue$memberVerificationPendingDialogNotice$1 extends o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ MemberVerificationPendingViewModel$DialogState $dialogState;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ StoreNotices $storeNotices;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationPendingDialog$Companion$enqueue$memberVerificationPendingDialogNotice$1(long j, MemberVerificationPendingViewModel$DialogState memberVerificationPendingViewModel$DialogState, StoreNotices storeNotices, String str) {
        super(1);
        this.$guildId = j;
        this.$dialogState = memberVerificationPendingViewModel$DialogState;
        this.$storeNotices = storeNotices;
        this.$noticeName = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, "appActivity");
        MemberVerificationPendingDialog memberVerificationPendingDialog = new MemberVerificationPendingDialog();
        Bundle bundle = new Bundle();
        bundle.putLong(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, this.$guildId);
        bundle.putSerializable("INTENT_EXTRA_DIALOG_STATE", this.$dialogState);
        memberVerificationPendingDialog.setArguments(bundle);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
        memberVerificationPendingDialog.show(supportFragmentManager, a0.getOrCreateKotlinClass(MemberVerificationPendingDialog.class).toString());
        StoreNotices.markSeen$default(this.$storeNotices, this.$noticeName, 0L, 2, null);
        return true;
    }
}
