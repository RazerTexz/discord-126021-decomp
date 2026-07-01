package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import d0.o;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionConfirmationDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionConfirmationDialog$Companion {
    private GuildRoleSubscriptionConfirmationDialog$Companion() {
    }

    public static /* synthetic */ void show$default(GuildRoleSubscriptionConfirmationDialog$Companion guildRoleSubscriptionConfirmationDialog$Companion, FragmentManager fragmentManager, String str, String str2, String str3, boolean z2, Function0 function0, int i, Object obj) {
        guildRoleSubscriptionConfirmationDialog$Companion.show(fragmentManager, str, str2, str3, (i & 16) != 0 ? false : z2, function0);
    }

    public final void show(FragmentManager fragmentManager, String title, String subtitle, String confirmationButtonText, boolean isDestructiveOperation, Function0<Unit> confirmCallback) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(title, "title");
        m.checkNotNullParameter(subtitle, "subtitle");
        m.checkNotNullParameter(confirmationButtonText, "confirmationButtonText");
        m.checkNotNullParameter(confirmCallback, "confirmCallback");
        GuildRoleSubscriptionConfirmationDialog guildRoleSubscriptionConfirmationDialog = new GuildRoleSubscriptionConfirmationDialog();
        guildRoleSubscriptionConfirmationDialog.setConfirmCallback(confirmCallback);
        guildRoleSubscriptionConfirmationDialog.setArguments(BundleKt.bundleOf(o.to("INTENT_EXTRA_TITLE", title), o.to("INTENT_EXTRA_SUBTITLE", subtitle), o.to("INTENT_EXTRA_CONFIRMATION_BUTTON_TEXT", confirmationButtonText), o.to("INTENT_EXTRA_IS_DESTRUCTIVE_OPERATION", Boolean.valueOf(isDestructiveOperation))));
        guildRoleSubscriptionConfirmationDialog.show(fragmentManager, GuildRoleSubscriptionConfirmationDialog.class.getSimpleName());
    }

    public /* synthetic */ GuildRoleSubscriptionConfirmationDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
