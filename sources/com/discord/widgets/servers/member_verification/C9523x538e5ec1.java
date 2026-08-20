package com.discord.widgets.servers.member_verification;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$Companion$enqueue$memberVerificationPendingDialogNotice$1 */
/* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9523x538e5ec1 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ MemberVerificationPendingViewModel.DialogState $dialogState;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ StoreNotices $storeNotices;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9523x538e5ec1(long j, MemberVerificationPendingViewModel.DialogState dialogState, StoreNotices storeNotices, String str) {
        super(1);
        this.$guildId = j;
        this.$dialogState = dialogState;
        this.$storeNotices = storeNotices;
        this.$noticeName = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        C12238m.checkNotNullParameter(fragmentActivity, "appActivity");
        MemberVerificationPendingDialog memberVerificationPendingDialog = new MemberVerificationPendingDialog();
        Bundle bundle = new Bundle();
        bundle.putLong(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, this.$guildId);
        bundle.putSerializable("INTENT_EXTRA_DIALOG_STATE", this.$dialogState);
        memberVerificationPendingDialog.setArguments(bundle);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        C12238m.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
        memberVerificationPendingDialog.show(supportFragmentManager, C12216a0.getOrCreateKotlinClass(MemberVerificationPendingDialog.class).toString());
        StoreNotices.markSeen$default(this.$storeNotices, this.$noticeName, 0L, 2, null);
        return true;
    }
}
