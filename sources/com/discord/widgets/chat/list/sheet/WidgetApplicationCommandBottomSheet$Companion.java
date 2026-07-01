package com.discord.widgets.chat.list.sheet;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet$Companion {
    private WidgetApplicationCommandBottomSheet$Companion() {
    }

    public final void show(FragmentManager fragmentManager, long interactionId, long messageId, long channelId, Long guildId, long userId, long applicationId, String messageNonce) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        boolean z2 = false;
        Experiment userExperiment = StoreStream.Companion.getExperiments().getUserExperiment("2021-03_android_app_slash_commands_bottom_sheet_disabled", false);
        if (userExperiment != null && userExperiment.getBucket() == 1) {
            z2 = true;
        }
        if (z2) {
            return;
        }
        WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet = new WidgetApplicationCommandBottomSheet();
        Bundle bundleT = a.T("com.discord.intent.extra.EXTRA_INTERACTION_ID", interactionId);
        bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        bundleT.putLong("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId);
        if (guildId != null) {
            bundleT.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId.longValue());
        }
        bundleT.putLong("com.discord.intent.extra.EXTRA_USER_ID", userId);
        bundleT.putLong("com.discord.intent.extra.EXTRA_APPLICATION_ID", applicationId);
        bundleT.putString(WidgetApplicationCommandBottomSheet.ARG_MESSAGE_NONCE, messageNonce);
        widgetApplicationCommandBottomSheet.setArguments(bundleT);
        widgetApplicationCommandBottomSheet.show(fragmentManager, WidgetApplicationCommandBottomSheet.class.getName());
    }

    public /* synthetic */ WidgetApplicationCommandBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
