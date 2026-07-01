package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShare$Companion {
    private WidgetGuildInviteShare$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetGuildInviteShare$Companion widgetGuildInviteShare$Companion, Context context, FragmentManager fragmentManager, long j, Long l, boolean z2, Long l2, String str, String str2, int i, Object obj) {
        widgetGuildInviteShare$Companion.launch(context, fragmentManager, j, (i & 8) != 0 ? null : l, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? null : l2, (i & 64) != 0 ? null : str, str2);
    }

    public final void launch(Context context, FragmentManager fragmentManager, long guildId, Long channelId, boolean isNuxFlow, Long guildScheduledEventId, String inviteStoreKey, String source) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(source, "source");
        if (GuildInviteShareSheetFeatureFlag.Companion.getINSTANCE().isEnabled()) {
            WidgetGuildInviteShareSheet.Companion.show(fragmentManager, channelId, guildId, source);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(WidgetGuildInviteShare.INTENT_IS_NUX_FLOW, isNuxFlow);
        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId != null ? channelId.longValue() : 0L);
        intent.putExtra("com.discord.intent.ORIGIN_SOURCE", source);
        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", guildScheduledEventId);
        intent.putExtra(WidgetGuildInviteShare.INTENT_INVITE_STORE_KEY, inviteStoreKey);
        Observable observableJ = Observable.j(StoreStream.Companion.getExperiments().observeUserExperiment("2020-01_mobile_invite_suggestion_compact", true), new InviteSuggestionsManager(null, null, null, null, null, 31, null).observeInviteSuggestions(), WidgetGuildInviteShare$Companion$launch$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…-> exp to inviteService }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout(ObservableExtensionsKt.computationLatest(observableJ), 50L, false), WidgetGuildInviteShare.class, (Context) null, (Function1) null, new WidgetGuildInviteShare$Companion$launch$2(source, context, intent), (Function0) null, (Function0) null, new WidgetGuildInviteShare$Companion$launch$3(source, context, intent), 54, (Object) null);
    }

    public /* synthetic */ WidgetGuildInviteShare$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
