package com.discord.utilities.directories;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import b.a.y.b0;
import b.a.y.b0$a;
import b.a.y.c0;
import com.discord.analytics.generated.events.TrackHubEventCtaClicked;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.utils.hubs.HubGuildScheduledEventClickType;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils$Tracker;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.guilds.join.GuildJoinHelperKt;
import d0.o;
import d0.t.m;
import d0.t.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DirectoryUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DirectoryUtils {
    public static final String JOIN_GUILD_SOURCE = "Directory Channel Entry";
    public static final DirectoryUtils INSTANCE = new DirectoryUtils();
    private static final List<DirectoryUtils$DirectoryServerMenuOptions> SERVER_OWNER_MENU_OPTIONS = n.listOf((Object[]) new DirectoryUtils$DirectoryServerMenuOptions[]{DirectoryUtils$DirectoryServerMenuOptions.Edit, DirectoryUtils$DirectoryServerMenuOptions.Remove});
    private static final List<DirectoryUtils$DirectoryServerMenuOptions> NON_SERVER_OWNER_MENU_OPTIONS = m.listOf(DirectoryUtils$DirectoryServerMenuOptions.Report);

    private DirectoryUtils() {
    }

    public final void logGuildScheduledEventClickAction(long guildScheduledEventId, long guildScheduledEventGuildId, long guildId, HubGuildScheduledEventClickType clickType) {
        d0.z.d.m.checkNotNullParameter(clickType, "clickType");
        AnalyticsUtils$Tracker tracker = AnalyticsTracker.INSTANCE.getTracker();
        TrackHubEventCtaClicked trackHubEventCtaClicked = new TrackHubEventCtaClicked(Long.valueOf(guildScheduledEventId), Long.valueOf(guildScheduledEventGuildId), clickType.getType());
        trackHubEventCtaClicked.c(new TrackGuild(Long.valueOf(guildId), null, null, null, null, null, null, null, null, null, null, null, 4094));
        tracker.track(trackHubEventCtaClicked);
    }

    public final void maybeJoinAndGoToGuild(AppBottomSheet bottomSheet, GuildScheduledEvent guildScheduledEvent, boolean isInGuild, long hubGuildId, long directoryChannelId, boolean shouldToggleRsvp, Function0<Unit> toggleRsvp) {
        d0.z.d.m.checkNotNullParameter(bottomSheet, "bottomSheet");
        d0.z.d.m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        d0.z.d.m.checkNotNullParameter(toggleRsvp, "toggleRsvp");
        if (isInGuild) {
            StoreStream.Companion.getGuildSelected().set(guildScheduledEvent.getGuildId());
            bottomSheet.dismiss();
        } else {
            logGuildScheduledEventClickAction(guildScheduledEvent.getId(), guildScheduledEvent.getGuildId(), hubGuildId, HubGuildScheduledEventClickType.JoinServer);
            Context contextRequireContext = bottomSheet.requireContext();
            d0.z.d.m.checkNotNullExpressionValue(contextRequireContext, "bottomSheet.requireContext()");
            GuildJoinHelperKt.joinGuild$default(contextRequireContext, guildScheduledEvent.getGuildId(), false, null, Long.valueOf(directoryChannelId), RestAPI.Companion.getApi().jsonObjectOf(o.to("source", JOIN_GUILD_SOURCE)), DirectoryUtils.class, null, null, null, new DirectoryUtils$maybeJoinAndGoToGuild$1(shouldToggleRsvp, toggleRsvp, guildScheduledEvent, bottomSheet), 896, null);
        }
    }

    public final void showServerOptions(AppFragment fragment, DirectoryEntryGuild directoryEntry, String hubName, boolean isServerOwner, Function0<Unit> removeGuildListener) {
        d0.z.d.m.checkNotNullParameter(fragment, "fragment");
        d0.z.d.m.checkNotNullParameter(directoryEntry, "directoryEntry");
        d0.z.d.m.checkNotNullParameter(hubName, "hubName");
        d0.z.d.m.checkNotNullParameter(removeGuildListener, "removeGuildListener");
        Context context = fragment.getContext();
        if (context != null) {
            d0.z.d.m.checkNotNullExpressionValue(context, "fragment.context ?: return");
            List<DirectoryUtils$DirectoryServerMenuOptions> list = isServerOwner ? SERVER_OWNER_MENU_OPTIONS : NON_SERVER_OWNER_MENU_OPTIONS;
            b0$a b0_a = b0.k;
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            d0.z.d.m.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
            String string = fragment.getString(2131895591);
            d0.z.d.m.checkNotNullExpressionValue(string, "fragment.getString(R.string.server_settings)");
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
            for (DirectoryUtils$DirectoryServerMenuOptions directoryUtils$DirectoryServerMenuOptions : list) {
                arrayList.add(new c0(fragment.getString(directoryUtils$DirectoryServerMenuOptions.getTitleRes()), null, Integer.valueOf(directoryUtils$DirectoryServerMenuOptions.getIconRes()), null, null, null, null, 122));
            }
            b0_a.a(childFragmentManager, string, arrayList, false, new DirectoryUtils$showServerOptions$2(list, context, directoryEntry, hubName, fragment, removeGuildListener));
        }
    }
}
