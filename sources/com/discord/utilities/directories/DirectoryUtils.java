package com.discord.utilities.directories;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.analytics.generated.events.TrackHubEventCtaClicked;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.utils.hubs.HubGuildScheduledEventClickType;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.dialogs.SimpleConfirmationDialogArgs;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.guilds.join.GuildJoinHelperKt;
import com.discord.widgets.hubs.HubDescriptionArgs;
import com.discord.widgets.hubs.WidgetHubDescription;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.C0825e;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p008a.p062y.C1322b0;
import p007b.p008a.p062y.C1324c0;
import p507d0.C12116o;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: DirectoryUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DirectoryUtils {
    public static final String JOIN_GUILD_SOURCE = "Directory Channel Entry";
    public static final DirectoryUtils INSTANCE = new DirectoryUtils();
    private static final List<DirectoryServerMenuOptions> SERVER_OWNER_MENU_OPTIONS = C12147n.listOf((Object[]) new DirectoryServerMenuOptions[]{DirectoryServerMenuOptions.Edit, DirectoryServerMenuOptions.Remove});
    private static final List<DirectoryServerMenuOptions> NON_SERVER_OWNER_MENU_OPTIONS = C12145m.listOf(DirectoryServerMenuOptions.Report);

    /* JADX INFO: compiled from: DirectoryUtils.kt */
    public enum DirectoryServerMenuOptions {
        Edit(C5419R.string.hub_entry_update, C5419R.drawable.ic_edit_24dp),
        Remove(C5419R.string.hub_entry_remove, C5419R.drawable.ic_delete_24dp),
        Report(C5419R.string.report, C5419R.drawable.ic_flag_24dp);

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

    /* JADX INFO: renamed from: com.discord.utilities.directories.DirectoryUtils$maybeJoinAndGoToGuild$1 */
    /* JADX INFO: compiled from: DirectoryUtils.kt */
    public static final class C67421 extends AbstractC12240o implements Function1<Guild, Unit> {
        public final /* synthetic */ AppBottomSheet $bottomSheet;
        public final /* synthetic */ GuildScheduledEvent $guildScheduledEvent;
        public final /* synthetic */ boolean $shouldToggleRsvp;
        public final /* synthetic */ Function0 $toggleRsvp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67421(boolean z2, Function0 function0, GuildScheduledEvent guildScheduledEvent, AppBottomSheet appBottomSheet) {
            super(1);
            this.$shouldToggleRsvp = z2;
            this.$toggleRsvp = function0;
            this.$guildScheduledEvent = guildScheduledEvent;
            this.$bottomSheet = appBottomSheet;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            C12238m.checkNotNullParameter(guild, "it");
            if (this.$shouldToggleRsvp) {
                this.$toggleRsvp.invoke();
            }
            StoreStream.INSTANCE.getGuildSelected().set(this.$guildScheduledEvent.getGuildId());
            FragmentManager parentFragmentManager = this.$bottomSheet.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "bottomSheet.parentFragmentManager");
            List<Fragment> fragments = parentFragmentManager.getFragments();
            C12238m.checkNotNullExpressionValue(fragments, "bottomSheet.parentFragmentManager.fragments");
            for (Fragment fragment : fragments) {
                if (fragment instanceof AppBottomSheet) {
                    ((AppBottomSheet) fragment).dismiss();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.directories.DirectoryUtils$showServerOptions$2 */
    /* JADX INFO: compiled from: DirectoryUtils.kt */
    public static final class C67432 extends AbstractC12240o implements Function1<Integer, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ DirectoryEntryGuild $directoryEntry;
        public final /* synthetic */ AppFragment $fragment;
        public final /* synthetic */ String $hubName;
        public final /* synthetic */ List $options;
        public final /* synthetic */ Function0 $removeGuildListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67432(List list, Context context, DirectoryEntryGuild directoryEntryGuild, String str, AppFragment appFragment, Function0 function0) {
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
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            DirectoryServerMenuOptions directoryServerMenuOptions = (DirectoryServerMenuOptions) C12163u.getOrNull(this.$options, i);
            if (directoryServerMenuOptions != null) {
                int iOrdinal = directoryServerMenuOptions.ordinal();
                if (iOrdinal == 0) {
                    C0870j.m156d(this.$context, WidgetHubDescription.class, new HubDescriptionArgs(this.$directoryEntry.getGuild().getId(), this.$directoryEntry.getDirectoryChannelId(), true, this.$hubName, false, this.$directoryEntry.getDescription(), Integer.valueOf(this.$directoryEntry.getPrimaryCategoryId()), 16, null));
                    return;
                }
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        return;
                    }
                    WidgetMobileReports.INSTANCE.launchDirectoryServerReport(this.$context, this.$directoryEntry.getGuild().getId(), this.$directoryEntry.getEntityId(), this.$directoryEntry.getDirectoryChannelId());
                } else {
                    C0825e.Companion cVar = C0825e.INSTANCE;
                    FragmentManager childFragmentManager = this.$fragment.getChildFragmentManager();
                    C12238m.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
                    cVar.m128a(childFragmentManager, new SimpleConfirmationDialogArgs(this.$fragment.getString(C5419R.string.hub_entry_remove), C1107b.m216h(this.$context, C5419R.string.hub_entry_remove_body, new Object[]{this.$directoryEntry.getGuild().getName()}, null, 4).toString(), this.$fragment.getString(C5419R.string.remove), this.$fragment.getString(C5419R.string.cancel)), new View.OnClickListener() { // from class: com.discord.utilities.directories.DirectoryUtils.showServerOptions.2.1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            C67432.this.$removeGuildListener.invoke();
                        }
                    });
                }
            }
        }
    }

    private DirectoryUtils() {
    }

    public final void logGuildScheduledEventClickAction(long guildScheduledEventId, long guildScheduledEventGuildId, long guildId, HubGuildScheduledEventClickType clickType) {
        C12238m.checkNotNullParameter(clickType, "clickType");
        AnalyticsUtils.Tracker tracker = AnalyticsTracker.INSTANCE.getTracker();
        TrackHubEventCtaClicked trackHubEventCtaClicked = new TrackHubEventCtaClicked(Long.valueOf(guildScheduledEventId), Long.valueOf(guildScheduledEventGuildId), clickType.getType());
        trackHubEventCtaClicked.mo7508c(new TrackGuild(Long.valueOf(guildId), null, null, null, null, null, null, null, null, null, null, null, 4094));
        tracker.track(trackHubEventCtaClicked);
    }

    public final void maybeJoinAndGoToGuild(AppBottomSheet bottomSheet, GuildScheduledEvent guildScheduledEvent, boolean isInGuild, long hubGuildId, long directoryChannelId, boolean shouldToggleRsvp, Function0<Unit> toggleRsvp) {
        C12238m.checkNotNullParameter(bottomSheet, "bottomSheet");
        C12238m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        C12238m.checkNotNullParameter(toggleRsvp, "toggleRsvp");
        if (isInGuild) {
            StoreStream.INSTANCE.getGuildSelected().set(guildScheduledEvent.getGuildId());
            bottomSheet.dismiss();
        } else {
            logGuildScheduledEventClickAction(guildScheduledEvent.getId(), guildScheduledEvent.getGuildId(), hubGuildId, HubGuildScheduledEventClickType.JoinServer);
            Context contextRequireContext = bottomSheet.requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "bottomSheet.requireContext()");
            GuildJoinHelperKt.joinGuild(contextRequireContext, guildScheduledEvent.getGuildId(), false, (944 & 8) != 0 ? null : null, (944 & 16) != 0 ? null : Long.valueOf(directoryChannelId), (944 & 32) != 0 ? null : RestAPI.INSTANCE.getApi().jsonObjectOf(C12116o.m10073to("source", JOIN_GUILD_SOURCE)), DirectoryUtils.class, (944 & 128) != 0 ? null : null, (944 & 256) != 0 ? null : null, (944 & 512) != 0 ? null : null, new C67421(shouldToggleRsvp, toggleRsvp, guildScheduledEvent, bottomSheet));
        }
    }

    public final void showServerOptions(AppFragment fragment, DirectoryEntryGuild directoryEntry, String hubName, boolean isServerOwner, Function0<Unit> removeGuildListener) {
        C12238m.checkNotNullParameter(fragment, "fragment");
        C12238m.checkNotNullParameter(directoryEntry, "directoryEntry");
        C12238m.checkNotNullParameter(hubName, "hubName");
        C12238m.checkNotNullParameter(removeGuildListener, "removeGuildListener");
        Context context = fragment.getContext();
        if (context != null) {
            C12238m.checkNotNullExpressionValue(context, "fragment.context ?: return");
            List<DirectoryServerMenuOptions> list = isServerOwner ? SERVER_OWNER_MENU_OPTIONS : NON_SERVER_OWNER_MENU_OPTIONS;
            C1322b0.Companion companion = C1322b0.INSTANCE;
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            C12238m.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
            String string = fragment.getString(C5419R.string.server_settings);
            C12238m.checkNotNullExpressionValue(string, "fragment.getString(R.string.server_settings)");
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
            for (DirectoryServerMenuOptions directoryServerMenuOptions : list) {
                arrayList.add(new C1324c0(fragment.getString(directoryServerMenuOptions.getTitleRes()), null, Integer.valueOf(directoryServerMenuOptions.getIconRes()), null, null, null, null, 122));
            }
            companion.m379a(childFragmentManager, string, arrayList, false, new C67432(list, context, directoryEntry, hubName, fragment, removeGuildListener));
        }
    }
}
