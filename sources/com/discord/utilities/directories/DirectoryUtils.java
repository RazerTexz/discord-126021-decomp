package com.discord.utilities.directories;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.a.SimpleConfirmationDialog;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.a.y.SelectorBottomSheet;
import b.a.y.SelectorBottomSheet2;
import com.discord.R;
import com.discord.analytics.generated.events.TrackHubEventCtaClicked;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.utils.hubs.HubGuildScheduledEventClickType;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.dialogs.SimpleConfirmationDialog2;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.guilds.join.GuildJoinHelper;
import com.discord.widgets.hubs.WidgetHubDescription;
import com.discord.widgets.hubs.WidgetHubDescriptionViewModel2;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DirectoryUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DirectoryUtils {
    public static final String JOIN_GUILD_SOURCE = "Directory Channel Entry";
    public static final DirectoryUtils INSTANCE = new DirectoryUtils();
    private static final List<DirectoryServerMenuOptions> SERVER_OWNER_MENU_OPTIONS = Collections2.listOf((Object[]) new DirectoryServerMenuOptions[]{DirectoryServerMenuOptions.Edit, DirectoryServerMenuOptions.Remove});
    private static final List<DirectoryServerMenuOptions> NON_SERVER_OWNER_MENU_OPTIONS = CollectionsJVM.listOf(DirectoryServerMenuOptions.Report);

    /* JADX INFO: compiled from: DirectoryUtils.kt */
    public enum DirectoryServerMenuOptions {
        Edit(R.string.hub_entry_update, R.drawable.ic_edit_24dp),
        Remove(R.string.hub_entry_remove, R.drawable.ic_delete_24dp),
        Report(R.string.report, R.drawable.ic_flag_24dp);

        private final int iconRes;
        private final int titleRes;

        DirectoryServerMenuOptions(int i, int i2) {
            this.titleRes = i;
            this.iconRes = i2;
        }

        public final int getIconRes() {
            return this.iconRes;
        }

        public final int getTitleRes() {
            return this.titleRes;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            DirectoryServerMenuOptions.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[DirectoryServerMenuOptions.Edit.ordinal()] = 1;
            iArr[DirectoryServerMenuOptions.Remove.ordinal()] = 2;
            iArr[DirectoryServerMenuOptions.Report.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.directories.DirectoryUtils$maybeJoinAndGoToGuild$1, reason: invalid class name */
    /* JADX INFO: compiled from: DirectoryUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Guild, Unit> {
        public final /* synthetic */ AppBottomSheet $bottomSheet;
        public final /* synthetic */ GuildScheduledEvent $guildScheduledEvent;
        public final /* synthetic */ boolean $shouldToggleRsvp;
        public final /* synthetic */ Function0 $toggleRsvp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, Function0 function0, GuildScheduledEvent guildScheduledEvent, AppBottomSheet appBottomSheet) {
            super(1);
            this.$shouldToggleRsvp = z2;
            this.$toggleRsvp = function0;
            this.$guildScheduledEvent = guildScheduledEvent;
            this.$bottomSheet = appBottomSheet;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "it");
            if (this.$shouldToggleRsvp) {
                this.$toggleRsvp.invoke();
            }
            StoreStream.INSTANCE.getGuildSelected().set(this.$guildScheduledEvent.getGuildId());
            FragmentManager parentFragmentManager = this.$bottomSheet.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "bottomSheet.parentFragmentManager");
            List<Fragment> fragments = parentFragmentManager.getFragments();
            Intrinsics3.checkNotNullExpressionValue(fragments, "bottomSheet.parentFragmentManager.fragments");
            for (Fragment fragment : fragments) {
                if (fragment instanceof AppBottomSheet) {
                    ((AppBottomSheet) fragment).dismiss();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.directories.DirectoryUtils$showServerOptions$2, reason: invalid class name */
    /* JADX INFO: compiled from: DirectoryUtils.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ DirectoryEntryGuild $directoryEntry;
        public final /* synthetic */ AppFragment $fragment;
        public final /* synthetic */ String $hubName;
        public final /* synthetic */ List $options;
        public final /* synthetic */ Function0 $removeGuildListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List list, Context context, DirectoryEntryGuild directoryEntryGuild, String str, AppFragment appFragment, Function0 function0) {
            super(1);
            this.$options = list;
            this.$context = context;
            this.$directoryEntry = directoryEntryGuild;
            this.$hubName = str;
            this.$fragment = appFragment;
            this.$removeGuildListener = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            DirectoryServerMenuOptions directoryServerMenuOptions = (DirectoryServerMenuOptions) _Collections.getOrNull(this.$options, i);
            if (directoryServerMenuOptions != null) {
                int iOrdinal = directoryServerMenuOptions.ordinal();
                if (iOrdinal == 0) {
                    AppScreen2.d(this.$context, WidgetHubDescription.class, new WidgetHubDescriptionViewModel2(this.$directoryEntry.getGuild().getId(), this.$directoryEntry.getDirectoryChannelId(), true, this.$hubName, false, this.$directoryEntry.getDescription(), Integer.valueOf(this.$directoryEntry.getPrimaryCategoryId()), 16, null));
                    return;
                }
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        return;
                    }
                    WidgetMobileReports.INSTANCE.launchDirectoryServerReport(this.$context, this.$directoryEntry.getGuild().getId(), this.$directoryEntry.getEntityId(), this.$directoryEntry.getDirectoryChannelId());
                } else {
                    SimpleConfirmationDialog.Companion cVar = SimpleConfirmationDialog.INSTANCE;
                    FragmentManager childFragmentManager = this.$fragment.getChildFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
                    cVar.a(childFragmentManager, new SimpleConfirmationDialog2(this.$fragment.getString(R.string.hub_entry_remove), FormatUtils.b(this.$context, R.string.hub_entry_remove_body, new Object[]{this.$directoryEntry.getGuild().getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null).toString(), this.$fragment.getString(R.string.remove), this.$fragment.getString(R.string.cancel)), new View.OnClickListener() { // from class: com.discord.utilities.directories.DirectoryUtils.showServerOptions.2.1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            AnonymousClass2.this.$removeGuildListener.invoke();
                        }
                    });
                }
            }
        }
    }

    private DirectoryUtils() {
    }

    public final void logGuildScheduledEventClickAction(long guildScheduledEventId, long guildScheduledEventGuildId, long guildId, HubGuildScheduledEventClickType clickType) {
        Intrinsics3.checkNotNullParameter(clickType, "clickType");
        AnalyticsUtils.Tracker tracker = AnalyticsTracker.INSTANCE.getTracker();
        TrackHubEventCtaClicked trackHubEventCtaClicked = new TrackHubEventCtaClicked(Long.valueOf(guildScheduledEventId), Long.valueOf(guildScheduledEventGuildId), clickType.getType());
        trackHubEventCtaClicked.c(new TrackGuild(Long.valueOf(guildId), null, null, null, null, null, null, null, null, null, null, null, 4094));
        tracker.track(trackHubEventCtaClicked);
    }

    public final void maybeJoinAndGoToGuild(AppBottomSheet bottomSheet, GuildScheduledEvent guildScheduledEvent, boolean isInGuild, long hubGuildId, long directoryChannelId, boolean shouldToggleRsvp, Function0<Unit> toggleRsvp) {
        Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        Intrinsics3.checkNotNullParameter(toggleRsvp, "toggleRsvp");
        if (isInGuild) {
            StoreStream.INSTANCE.getGuildSelected().set(guildScheduledEvent.getGuildId());
            bottomSheet.dismiss();
        } else {
            logGuildScheduledEventClickAction(guildScheduledEvent.getId(), guildScheduledEvent.getGuildId(), hubGuildId, HubGuildScheduledEventClickType.JoinServer);
            Context contextRequireContext = bottomSheet.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "bottomSheet.requireContext()");
            GuildJoinHelper.joinGuild(contextRequireContext, guildScheduledEvent.getGuildId(), false, (944 & 8) != 0 ? null : null, (944 & 16) != 0 ? null : Long.valueOf(directoryChannelId), (944 & 32) != 0 ? null : RestAPI.INSTANCE.getApi().jsonObjectOf(Tuples.to("source", JOIN_GUILD_SOURCE)), DirectoryUtils.class, (944 & 128) != 0 ? null : null, (944 & 256) != 0 ? null : null, (944 & 512) != 0 ? null : null, new AnonymousClass1(shouldToggleRsvp, toggleRsvp, guildScheduledEvent, bottomSheet));
        }
    }

    public final void showServerOptions(AppFragment fragment, DirectoryEntryGuild directoryEntry, String hubName, boolean isServerOwner, Function0<Unit> removeGuildListener) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(directoryEntry, "directoryEntry");
        Intrinsics3.checkNotNullParameter(hubName, "hubName");
        Intrinsics3.checkNotNullParameter(removeGuildListener, "removeGuildListener");
        Context context = fragment.getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "fragment.context ?: return");
            List<DirectoryServerMenuOptions> list = isServerOwner ? SERVER_OWNER_MENU_OPTIONS : NON_SERVER_OWNER_MENU_OPTIONS;
            SelectorBottomSheet.Companion companion = SelectorBottomSheet.INSTANCE;
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
            String string = fragment.getString(R.string.server_settings);
            Intrinsics3.checkNotNullExpressionValue(string, "fragment.getString(R.string.server_settings)");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            for (DirectoryServerMenuOptions directoryServerMenuOptions : list) {
                arrayList.add(new SelectorBottomSheet2(fragment.getString(directoryServerMenuOptions.getTitleRes()), null, Integer.valueOf(directoryServerMenuOptions.getIconRes()), null, null, null, null, 122));
            }
            companion.a(childFragmentManager, string, arrayList, false, new AnonymousClass2(list, context, directoryEntry, hubName, fragment, removeGuildListener));
        }
    }
}
