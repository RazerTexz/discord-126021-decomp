package com.discord.widgets.guilds.profile;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.emoji.GuildEmoji;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.app.AppActivity;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreGuildProfiles;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.permissions.PermissionsContexts;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func9;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheetViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private boolean isEmojiSectionExpanded;
    private final RestAPI restAPI;
    private final StoreLurking storeLurking;
    private final StoreUserGuildSettings storeUserGuildSettings;
    private final StoreUserSettings storeUserSettings;
    private final boolean viewingGuild;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetGuildProfileSheetViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final /* data */ class Actions {
        private final boolean canChangeNickname;
        private final boolean canLeaveGuild;
        private final boolean canManageChannels;
        private final boolean canManageEvents;
        private final boolean displayGuildIdentityRow;
        private final String guildAvatar;
        private final boolean hideMutedChannels;
        private final boolean isAllowDMChecked;
        private final boolean isDeveloper;
        private final boolean isUnread;
        private final String nick;
        private final String username;

        /* JADX WARN: Code duplicated, block: B:17:0x003d  */
        public Actions(boolean z2, boolean z3, boolean z4, boolean z5, String str, String str2, boolean z6, boolean z7, boolean z8, boolean z9, String str3) {
            boolean z10;
            Intrinsics3.checkNotNullParameter(str3, "username");
            this.isUnread = z2;
            this.canManageChannels = z3;
            this.canManageEvents = z4;
            this.canChangeNickname = z5;
            this.nick = str;
            this.guildAvatar = str2;
            this.isAllowDMChecked = z6;
            this.hideMutedChannels = z7;
            this.canLeaveGuild = z8;
            this.isDeveloper = z9;
            this.username = str3;
            if (str == null || str.length() == 0) {
                z10 = str2 == null || str2.length() == 0 ? false : true;
            }
            this.displayGuildIdentityRow = z10;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsUnread() {
            return this.isUnread;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final boolean getIsDeveloper() {
            return this.isDeveloper;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getUsername() {
            return this.username;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getCanManageChannels() {
            return this.canManageChannels;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getCanManageEvents() {
            return this.canManageEvents;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getCanChangeNickname() {
            return this.canChangeNickname;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getNick() {
            return this.nick;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getGuildAvatar() {
            return this.guildAvatar;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsAllowDMChecked() {
            return this.isAllowDMChecked;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getHideMutedChannels() {
            return this.hideMutedChannels;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getCanLeaveGuild() {
            return this.canLeaveGuild;
        }

        public final Actions copy(boolean isUnread, boolean canManageChannels, boolean canManageEvents, boolean canChangeNickname, String nick, String guildAvatar, boolean isAllowDMChecked, boolean hideMutedChannels, boolean canLeaveGuild, boolean isDeveloper, String username) {
            Intrinsics3.checkNotNullParameter(username, "username");
            return new Actions(isUnread, canManageChannels, canManageEvents, canChangeNickname, nick, guildAvatar, isAllowDMChecked, hideMutedChannels, canLeaveGuild, isDeveloper, username);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Actions)) {
                return false;
            }
            Actions actions = (Actions) other;
            return this.isUnread == actions.isUnread && this.canManageChannels == actions.canManageChannels && this.canManageEvents == actions.canManageEvents && this.canChangeNickname == actions.canChangeNickname && Intrinsics3.areEqual(this.nick, actions.nick) && Intrinsics3.areEqual(this.guildAvatar, actions.guildAvatar) && this.isAllowDMChecked == actions.isAllowDMChecked && this.hideMutedChannels == actions.hideMutedChannels && this.canLeaveGuild == actions.canLeaveGuild && this.isDeveloper == actions.isDeveloper && Intrinsics3.areEqual(this.username, actions.username);
        }

        public final boolean getCanChangeNickname() {
            return this.canChangeNickname;
        }

        public final boolean getCanLeaveGuild() {
            return this.canLeaveGuild;
        }

        public final boolean getCanManageChannels() {
            return this.canManageChannels;
        }

        public final boolean getCanManageEvents() {
            return this.canManageEvents;
        }

        public final boolean getDisplayGuildIdentityRow() {
            return this.displayGuildIdentityRow;
        }

        public final String getGuildAvatar() {
            return this.guildAvatar;
        }

        public final boolean getHideMutedChannels() {
            return this.hideMutedChannels;
        }

        public final String getNick() {
            return this.nick;
        }

        public final String getUsername() {
            return this.username;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v13, types: [int] */
        /* JADX WARN: Type inference failed for: r0v22 */
        /* JADX WARN: Type inference failed for: r0v23 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v13, types: [int] */
        /* JADX WARN: Type inference failed for: r2v15, types: [int] */
        /* JADX WARN: Type inference failed for: r2v17, types: [int] */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v25 */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v27 */
        /* JADX WARN: Type inference failed for: r2v28 */
        /* JADX WARN: Type inference failed for: r2v29 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v31 */
        /* JADX WARN: Type inference failed for: r2v32 */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        public int hashCode() {
            boolean z2 = this.isUnread;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.canManageChannels;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.canManageEvents;
            ?? r3 = z4;
            if (z4) {
                r3 = 1;
            }
            int i3 = (i2 + r3) * 31;
            boolean z5 = this.canChangeNickname;
            ?? r4 = z5;
            if (z5) {
                r4 = 1;
            }
            int i4 = (i3 + r4) * 31;
            String str = this.nick;
            int iHashCode = (i4 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.guildAvatar;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z6 = this.isAllowDMChecked;
            ?? r5 = z6;
            if (z6) {
                r5 = 1;
            }
            int i5 = (iHashCode2 + r5) * 31;
            boolean z7 = this.hideMutedChannels;
            ?? r6 = z7;
            if (z7) {
                r6 = 1;
            }
            int i6 = (i5 + r6) * 31;
            boolean z8 = this.canLeaveGuild;
            ?? r7 = z8;
            if (z8) {
                r7 = 1;
            }
            int i7 = (i6 + r7) * 31;
            boolean z9 = this.isDeveloper;
            int i8 = (i7 + (z9 ? 1 : z9)) * 31;
            String str3 = this.username;
            return i8 + (str3 != null ? str3.hashCode() : 0);
        }

        public final boolean isAllowDMChecked() {
            return this.isAllowDMChecked;
        }

        public final boolean isDeveloper() {
            return this.isDeveloper;
        }

        public final boolean isUnread() {
            return this.isUnread;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Actions(isUnread=");
            sbU.append(this.isUnread);
            sbU.append(", canManageChannels=");
            sbU.append(this.canManageChannels);
            sbU.append(", canManageEvents=");
            sbU.append(this.canManageEvents);
            sbU.append(", canChangeNickname=");
            sbU.append(this.canChangeNickname);
            sbU.append(", nick=");
            sbU.append(this.nick);
            sbU.append(", guildAvatar=");
            sbU.append(this.guildAvatar);
            sbU.append(", isAllowDMChecked=");
            sbU.append(this.isAllowDMChecked);
            sbU.append(", hideMutedChannels=");
            sbU.append(this.hideMutedChannels);
            sbU.append(", canLeaveGuild=");
            sbU.append(this.canLeaveGuild);
            sbU.append(", isDeveloper=");
            sbU.append(this.isDeveloper);
            sbU.append(", username=");
            return outline.J(sbU, this.username, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final /* data */ class Banner {
        private final long guildId;
        private final String hash;
        private final Type type;

        /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
        public enum Type {
            BANNER,
            SPLASH
        }

        public Banner(long j, String str, Type type) {
            Intrinsics3.checkNotNullParameter(type, "type");
            this.guildId = j;
            this.hash = str;
            this.type = type;
        }

        public static /* synthetic */ Banner copy$default(Banner banner, long j, String str, Type type, int i, Object obj) {
            if ((i & 1) != 0) {
                j = banner.guildId;
            }
            if ((i & 2) != 0) {
                str = banner.hash;
            }
            if ((i & 4) != 0) {
                type = banner.type;
            }
            return banner.copy(j, str, type);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getHash() {
            return this.hash;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Type getType() {
            return this.type;
        }

        public final Banner copy(long guildId, String hash, Type type) {
            Intrinsics3.checkNotNullParameter(type, "type");
            return new Banner(guildId, hash, type);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Banner)) {
                return false;
            }
            Banner banner = (Banner) other;
            return this.guildId == banner.guildId && Intrinsics3.areEqual(this.hash, banner.hash) && Intrinsics3.areEqual(this.type, banner.type);
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final String getHash() {
            return this.hash;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            int iA = b.a(this.guildId) * 31;
            String str = this.hash;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            Type type = this.type;
            return iHashCode + (type != null ? type.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Banner(guildId=");
            sbU.append(this.guildId);
            sbU.append(", hash=");
            sbU.append(this.hash);
            sbU.append(", type=");
            sbU.append(this.type);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final /* data */ class BottomActions {
        private final boolean showJoinServer;
        private final boolean showUploadEmoji;
        private final boolean showViewServer;

        public BottomActions(boolean z2, boolean z3, boolean z4) {
            this.showUploadEmoji = z2;
            this.showJoinServer = z3;
            this.showViewServer = z4;
        }

        public static /* synthetic */ BottomActions copy$default(BottomActions bottomActions, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = bottomActions.showUploadEmoji;
            }
            if ((i & 2) != 0) {
                z3 = bottomActions.showJoinServer;
            }
            if ((i & 4) != 0) {
                z4 = bottomActions.showViewServer;
            }
            return bottomActions.copy(z2, z3, z4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getShowUploadEmoji() {
            return this.showUploadEmoji;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getShowJoinServer() {
            return this.showJoinServer;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getShowViewServer() {
            return this.showViewServer;
        }

        public final BottomActions copy(boolean showUploadEmoji, boolean showJoinServer, boolean showViewServer) {
            return new BottomActions(showUploadEmoji, showJoinServer, showViewServer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BottomActions)) {
                return false;
            }
            BottomActions bottomActions = (BottomActions) other;
            return this.showUploadEmoji == bottomActions.showUploadEmoji && this.showJoinServer == bottomActions.showJoinServer && this.showViewServer == bottomActions.showViewServer;
        }

        public final boolean getShowJoinServer() {
            return this.showJoinServer;
        }

        public final boolean getShowUploadEmoji() {
            return this.showUploadEmoji;
        }

        public final boolean getShowViewServer() {
            return this.showViewServer;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            boolean z2 = this.showUploadEmoji;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.showJoinServer;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.showViewServer;
            return i2 + (z4 ? 1 : z4);
        }

        public String toString() {
            StringBuilder sbU = outline.U("BottomActions(showUploadEmoji=");
            sbU.append(this.showUploadEmoji);
            sbU.append(", showJoinServer=");
            sbU.append(this.showJoinServer);
            sbU.append(", showViewServer=");
            return outline.O(sbU, this.showViewServer, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStores(final long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableC = Observable.c(companion.getGuilds().observeGuild(guildId), companion.getGuildProfiles().observeGuildProfile(guildId), companion.getReadStates().getIsUnread(guildId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), StoreUser.observeMe$default(companion.getUsers(), false, 1, null).Y(new Func1<MeUser, Observable<? extends GuildMember>>() { // from class: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$Companion$observeStores$1
                @Override // j0.k.Func1
                public final Observable<? extends GuildMember> call(final MeUser meUser) {
                    return StoreStream.INSTANCE.getGuilds().observeComputed(guildId, CollectionsJVM.listOf(Long.valueOf(meUser.getId()))).G(new Func1<Map<Long, ? extends GuildMember>, GuildMember>() { // from class: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$Companion$observeStores$1.1
                        @Override // j0.k.Func1
                        public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
                            return call2((Map<Long, GuildMember>) map);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final GuildMember call2(Map<Long, GuildMember> map) {
                            return map.get(Long.valueOf(meUser.getId()));
                        }
                    });
                }
            }), companion.getUserSettings().observeRestrictedGuildIds(), companion.getEmojis().getEmojiSet(new StoreEmoji.EmojiContext.GuildProfile(guildId), true, false).G(new Func1<EmojiSet, List<Emoji>>() { // from class: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$Companion$observeStores$2
                @Override // j0.k.Func1
                public final List<Emoji> call(EmojiSet emojiSet) {
                    return emojiSet.customEmojis.get(Long.valueOf(guildId));
                }
            }), companion.getLurking().isLurkingObs(guildId), GuildChannelsInfo.INSTANCE.get(guildId), new Func9<Guild, StoreGuildProfiles.GuildProfileData, Boolean, MeUser, GuildMember, List<? extends Long>, List<Emoji>, Boolean, GuildChannelsInfo, StoreState>() { // from class: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$Companion$observeStores$3
                @Override // rx.functions.Func9
                public /* bridge */ /* synthetic */ WidgetGuildProfileSheetViewModel.StoreState call(Guild guild, StoreGuildProfiles.GuildProfileData guildProfileData, Boolean bool, MeUser meUser, GuildMember guildMember, List<? extends Long> list, List<Emoji> list2, Boolean bool2, GuildChannelsInfo guildChannelsInfo) {
                    return call2(guild, guildProfileData, bool, meUser, guildMember, (List<Long>) list, list2, bool2, guildChannelsInfo);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final WidgetGuildProfileSheetViewModel.StoreState call2(Guild guild, StoreGuildProfiles.GuildProfileData guildProfileData, Boolean bool, MeUser meUser, GuildMember guildMember, List<Long> list, List<Emoji> list2, Boolean bool2, GuildChannelsInfo guildChannelsInfo) {
                    Intrinsics3.checkNotNullExpressionValue(guildChannelsInfo, "guildChannelsInfo");
                    Intrinsics3.checkNotNullExpressionValue(meUser, "me");
                    Intrinsics3.checkNotNullExpressionValue(list, "restrictedGuildIds");
                    boolean isDeveloperMode = StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode();
                    List<Emoji> listEmptyList = list2 != null ? list2 : Collections2.emptyList();
                    Intrinsics3.checkNotNullExpressionValue(bool2, "isLurking");
                    boolean zBooleanValue = bool2.booleanValue();
                    Intrinsics3.checkNotNullExpressionValue(bool, "isUnread");
                    return new WidgetGuildProfileSheetViewModel.StoreState(guild, guildProfileData, guildChannelsInfo, meUser, guildMember, list, isDeveloperMode, listEmptyList, zBooleanValue, bool.booleanValue());
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableC, "Observable.combineLatest…ead\n          )\n        }");
            return observableC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final /* data */ class EmojisData {
        private final List<Emoji> emojis;
        private final boolean isExpanded;
        private final boolean isPremium;

        /* JADX WARN: Multi-variable type inference failed */
        public EmojisData(boolean z2, boolean z3, List<? extends Emoji> list) {
            Intrinsics3.checkNotNullParameter(list, "emojis");
            this.isPremium = z2;
            this.isExpanded = z3;
            this.emojis = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EmojisData copy$default(EmojisData emojisData, boolean z2, boolean z3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = emojisData.isPremium;
            }
            if ((i & 2) != 0) {
                z3 = emojisData.isExpanded;
            }
            if ((i & 4) != 0) {
                list = emojisData.emojis;
            }
            return emojisData.copy(z2, z3, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsPremium() {
            return this.isPremium;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsExpanded() {
            return this.isExpanded;
        }

        public final List<Emoji> component3() {
            return this.emojis;
        }

        public final EmojisData copy(boolean isPremium, boolean isExpanded, List<? extends Emoji> emojis) {
            Intrinsics3.checkNotNullParameter(emojis, "emojis");
            return new EmojisData(isPremium, isExpanded, emojis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EmojisData)) {
                return false;
            }
            EmojisData emojisData = (EmojisData) other;
            return this.isPremium == emojisData.isPremium && this.isExpanded == emojisData.isExpanded && Intrinsics3.areEqual(this.emojis, emojisData.emojis);
        }

        public final List<Emoji> getEmojis() {
            return this.emojis;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            boolean z2 = this.isPremium;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.isExpanded;
            int i2 = (i + (z3 ? 1 : z3)) * 31;
            List<Emoji> list = this.emojis;
            return i2 + (list != null ? list.hashCode() : 0);
        }

        public final boolean isExpanded() {
            return this.isExpanded;
        }

        public final boolean isPremium() {
            return this.isPremium;
        }

        public String toString() {
            StringBuilder sbU = outline.U("EmojisData(isPremium=");
            sbU.append(this.isPremium);
            sbU.append(", isExpanded=");
            sbU.append(this.isExpanded);
            sbU.append(", emojis=");
            return outline.L(sbU, this.emojis, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
        public static final /* data */ class DismissAndShowToast extends Event {
            private final int stringRes;

            public DismissAndShowToast(@StringRes int i) {
                super(null);
                this.stringRes = i;
            }

            public static /* synthetic */ DismissAndShowToast copy$default(DismissAndShowToast dismissAndShowToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = dismissAndShowToast.stringRes;
                }
                return dismissAndShowToast.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getStringRes() {
                return this.stringRes;
            }

            public final DismissAndShowToast copy(@StringRes int stringRes) {
                return new DismissAndShowToast(stringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof DismissAndShowToast) && this.stringRes == ((DismissAndShowToast) other).stringRes;
                }
                return true;
            }

            public final int getStringRes() {
                return this.stringRes;
            }

            public int hashCode() {
                return this.stringRes;
            }

            public String toString() {
                return outline.B(outline.U("DismissAndShowToast(stringRes="), this.stringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final GuildMember computedMe;
        private final List<Emoji> emojis;
        private final Guild guild;
        private final GuildChannelsInfo guildChannelsInfo;
        private final StoreGuildProfiles.GuildProfileData guildProfile;
        private final boolean isDeveloper;
        private final boolean isLurking;
        private final boolean isUnread;
        private final MeUser me;
        private final List<Long> restrictedGuildIds;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Guild guild, StoreGuildProfiles.GuildProfileData guildProfileData, GuildChannelsInfo guildChannelsInfo, MeUser meUser, GuildMember guildMember, List<Long> list, boolean z2, List<? extends Emoji> list2, boolean z3, boolean z4) {
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(list, "restrictedGuildIds");
            Intrinsics3.checkNotNullParameter(list2, "emojis");
            this.guild = guild;
            this.guildProfile = guildProfileData;
            this.guildChannelsInfo = guildChannelsInfo;
            this.me = meUser;
            this.computedMe = guildMember;
            this.restrictedGuildIds = list;
            this.isDeveloper = z2;
            this.emojis = list2;
            this.isLurking = z3;
            this.isUnread = z4;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final boolean getIsUnread() {
            return this.isUnread;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StoreGuildProfiles.GuildProfileData getGuildProfile() {
            return this.guildProfile;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final GuildMember getComputedMe() {
            return this.computedMe;
        }

        public final List<Long> component6() {
            return this.restrictedGuildIds;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsDeveloper() {
            return this.isDeveloper;
        }

        public final List<Emoji> component8() {
            return this.emojis;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getIsLurking() {
            return this.isLurking;
        }

        public final StoreState copy(Guild guild, StoreGuildProfiles.GuildProfileData guildProfile, GuildChannelsInfo guildChannelsInfo, MeUser me2, GuildMember computedMe, List<Long> restrictedGuildIds, boolean isDeveloper, List<? extends Emoji> emojis, boolean isLurking, boolean isUnread) {
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(restrictedGuildIds, "restrictedGuildIds");
            Intrinsics3.checkNotNullParameter(emojis, "emojis");
            return new StoreState(guild, guildProfile, guildChannelsInfo, me2, computedMe, restrictedGuildIds, isDeveloper, emojis, isLurking, isUnread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.guildProfile, storeState.guildProfile) && Intrinsics3.areEqual(this.guildChannelsInfo, storeState.guildChannelsInfo) && Intrinsics3.areEqual(this.me, storeState.me) && Intrinsics3.areEqual(this.computedMe, storeState.computedMe) && Intrinsics3.areEqual(this.restrictedGuildIds, storeState.restrictedGuildIds) && this.isDeveloper == storeState.isDeveloper && Intrinsics3.areEqual(this.emojis, storeState.emojis) && this.isLurking == storeState.isLurking && this.isUnread == storeState.isUnread;
        }

        public final GuildMember getComputedMe() {
            return this.computedMe;
        }

        public final List<Emoji> getEmojis() {
            return this.emojis;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        public final StoreGuildProfiles.GuildProfileData getGuildProfile() {
            return this.guildProfile;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final List<Long> getRestrictedGuildIds() {
            return this.restrictedGuildIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r0v20, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v16, types: [int] */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            StoreGuildProfiles.GuildProfileData guildProfileData = this.guildProfile;
            int iHashCode2 = (iHashCode + (guildProfileData != null ? guildProfileData.hashCode() : 0)) * 31;
            GuildChannelsInfo guildChannelsInfo = this.guildChannelsInfo;
            int iHashCode3 = (iHashCode2 + (guildChannelsInfo != null ? guildChannelsInfo.hashCode() : 0)) * 31;
            MeUser meUser = this.me;
            int iHashCode4 = (iHashCode3 + (meUser != null ? meUser.hashCode() : 0)) * 31;
            GuildMember guildMember = this.computedMe;
            int iHashCode5 = (iHashCode4 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            List<Long> list = this.restrictedGuildIds;
            int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.isDeveloper;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode6 + r2) * 31;
            List<Emoji> list2 = this.emojis;
            int iHashCode7 = (i + (list2 != null ? list2.hashCode() : 0)) * 31;
            boolean z3 = this.isLurking;
            ?? r1 = z3;
            if (z3) {
                r1 = 1;
            }
            int i2 = (iHashCode7 + r1) * 31;
            boolean z4 = this.isUnread;
            return i2 + (z4 ? 1 : z4);
        }

        public final boolean isDeveloper() {
            return this.isDeveloper;
        }

        public final boolean isLurking() {
            return this.isLurking;
        }

        public final boolean isUnread() {
            return this.isUnread;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guild=");
            sbU.append(this.guild);
            sbU.append(", guildProfile=");
            sbU.append(this.guildProfile);
            sbU.append(", guildChannelsInfo=");
            sbU.append(this.guildChannelsInfo);
            sbU.append(", me=");
            sbU.append(this.me);
            sbU.append(", computedMe=");
            sbU.append(this.computedMe);
            sbU.append(", restrictedGuildIds=");
            sbU.append(this.restrictedGuildIds);
            sbU.append(", isDeveloper=");
            sbU.append(this.isDeveloper);
            sbU.append(", emojis=");
            sbU.append(this.emojis);
            sbU.append(", isLurking=");
            sbU.append(this.isLurking);
            sbU.append(", isUnread=");
            return outline.O(sbU, this.isUnread, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final /* data */ class TabItems {
        private final boolean ableToInstantInvite;
        private final boolean canAccessSettings;
        private final int premiumSubscriptionCount;

        public TabItems(boolean z2, boolean z3, int i) {
            this.canAccessSettings = z2;
            this.ableToInstantInvite = z3;
            this.premiumSubscriptionCount = i;
        }

        public static /* synthetic */ TabItems copy$default(TabItems tabItems, boolean z2, boolean z3, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z2 = tabItems.canAccessSettings;
            }
            if ((i2 & 2) != 0) {
                z3 = tabItems.ableToInstantInvite;
            }
            if ((i2 & 4) != 0) {
                i = tabItems.premiumSubscriptionCount;
            }
            return tabItems.copy(z2, z3, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getCanAccessSettings() {
            return this.canAccessSettings;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getAbleToInstantInvite() {
            return this.ableToInstantInvite;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPremiumSubscriptionCount() {
            return this.premiumSubscriptionCount;
        }

        public final TabItems copy(boolean canAccessSettings, boolean ableToInstantInvite, int premiumSubscriptionCount) {
            return new TabItems(canAccessSettings, ableToInstantInvite, premiumSubscriptionCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TabItems)) {
                return false;
            }
            TabItems tabItems = (TabItems) other;
            return this.canAccessSettings == tabItems.canAccessSettings && this.ableToInstantInvite == tabItems.ableToInstantInvite && this.premiumSubscriptionCount == tabItems.premiumSubscriptionCount;
        }

        public final boolean getAbleToInstantInvite() {
            return this.ableToInstantInvite;
        }

        public final boolean getCanAccessSettings() {
            return this.canAccessSettings;
        }

        public final int getPremiumSubscriptionCount() {
            return this.premiumSubscriptionCount;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            boolean z2 = this.canAccessSettings;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.ableToInstantInvite;
            return ((i + (z3 ? 1 : z3)) * 31) + this.premiumSubscriptionCount;
        }

        public String toString() {
            StringBuilder sbU = outline.U("TabItems(canAccessSettings=");
            sbU.append(this.canAccessSettings);
            sbU.append(", ableToInstantInvite=");
            sbU.append(this.ableToInstantInvite);
            sbU.append(", premiumSubscriptionCount=");
            return outline.B(sbU, this.premiumSubscriptionCount, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Actions actions;
            private final Banner banner;
            private final BottomActions bottomActions;
            private final EmojisData emojisData;
            private final String guildDescription;
            private final String guildIcon;
            private final long guildId;
            private final String guildName;
            private final String guildShortName;
            private final boolean isGuildHub;
            private final MeUser meUser;
            private final Integer memberCount;
            private final Integer onlineCount;
            private final TabItems tabItems;
            private final Integer verifiedPartneredIconRes;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(long j, String str, String str2, String str3, String str4, Integer num, Banner banner, Integer num2, Integer num3, TabItems tabItems, Actions actions, EmojisData emojisData, BottomActions bottomActions, boolean z2, MeUser meUser) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "guildName");
                Intrinsics3.checkNotNullParameter(str2, "guildShortName");
                Intrinsics3.checkNotNullParameter(banner, "banner");
                Intrinsics3.checkNotNullParameter(emojisData, "emojisData");
                Intrinsics3.checkNotNullParameter(bottomActions, "bottomActions");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                this.guildId = j;
                this.guildName = str;
                this.guildShortName = str2;
                this.guildIcon = str3;
                this.guildDescription = str4;
                this.verifiedPartneredIconRes = num;
                this.banner = banner;
                this.onlineCount = num2;
                this.memberCount = num3;
                this.tabItems = tabItems;
                this.actions = actions;
                this.emojisData = emojisData;
                this.bottomActions = bottomActions;
                this.isGuildHub = z2;
                this.meUser = meUser;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, long j, String str, String str2, String str3, String str4, Integer num, Banner banner, Integer num2, Integer num3, TabItems tabItems, Actions actions, EmojisData emojisData, BottomActions bottomActions, boolean z2, MeUser meUser, int i, Object obj) {
                return loaded.copy((i & 1) != 0 ? loaded.guildId : j, (i & 2) != 0 ? loaded.guildName : str, (i & 4) != 0 ? loaded.guildShortName : str2, (i & 8) != 0 ? loaded.guildIcon : str3, (i & 16) != 0 ? loaded.guildDescription : str4, (i & 32) != 0 ? loaded.verifiedPartneredIconRes : num, (i & 64) != 0 ? loaded.banner : banner, (i & 128) != 0 ? loaded.onlineCount : num2, (i & 256) != 0 ? loaded.memberCount : num3, (i & 512) != 0 ? loaded.tabItems : tabItems, (i & 1024) != 0 ? loaded.actions : actions, (i & 2048) != 0 ? loaded.emojisData : emojisData, (i & 4096) != 0 ? loaded.bottomActions : bottomActions, (i & 8192) != 0 ? loaded.isGuildHub : z2, (i & 16384) != 0 ? loaded.meUser : meUser);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final TabItems getTabItems() {
                return this.tabItems;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final Actions getActions() {
                return this.actions;
            }

            /* JADX INFO: renamed from: component12, reason: from getter */
            public final EmojisData getEmojisData() {
                return this.emojisData;
            }

            /* JADX INFO: renamed from: component13, reason: from getter */
            public final BottomActions getBottomActions() {
                return this.bottomActions;
            }

            /* JADX INFO: renamed from: component14, reason: from getter */
            public final boolean getIsGuildHub() {
                return this.isGuildHub;
            }

            /* JADX INFO: renamed from: component15, reason: from getter */
            public final MeUser getMeUser() {
                return this.meUser;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getGuildName() {
                return this.guildName;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getGuildShortName() {
                return this.guildShortName;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getGuildIcon() {
                return this.guildIcon;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getGuildDescription() {
                return this.guildDescription;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final Integer getVerifiedPartneredIconRes() {
                return this.verifiedPartneredIconRes;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final Banner getBanner() {
                return this.banner;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final Integer getOnlineCount() {
                return this.onlineCount;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final Integer getMemberCount() {
                return this.memberCount;
            }

            public final Loaded copy(long guildId, String guildName, String guildShortName, String guildIcon, String guildDescription, Integer verifiedPartneredIconRes, Banner banner, Integer onlineCount, Integer memberCount, TabItems tabItems, Actions actions, EmojisData emojisData, BottomActions bottomActions, boolean isGuildHub, MeUser meUser) {
                Intrinsics3.checkNotNullParameter(guildName, "guildName");
                Intrinsics3.checkNotNullParameter(guildShortName, "guildShortName");
                Intrinsics3.checkNotNullParameter(banner, "banner");
                Intrinsics3.checkNotNullParameter(emojisData, "emojisData");
                Intrinsics3.checkNotNullParameter(bottomActions, "bottomActions");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                return new Loaded(guildId, guildName, guildShortName, guildIcon, guildDescription, verifiedPartneredIconRes, banner, onlineCount, memberCount, tabItems, actions, emojisData, bottomActions, isGuildHub, meUser);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.guildId == loaded.guildId && Intrinsics3.areEqual(this.guildName, loaded.guildName) && Intrinsics3.areEqual(this.guildShortName, loaded.guildShortName) && Intrinsics3.areEqual(this.guildIcon, loaded.guildIcon) && Intrinsics3.areEqual(this.guildDescription, loaded.guildDescription) && Intrinsics3.areEqual(this.verifiedPartneredIconRes, loaded.verifiedPartneredIconRes) && Intrinsics3.areEqual(this.banner, loaded.banner) && Intrinsics3.areEqual(this.onlineCount, loaded.onlineCount) && Intrinsics3.areEqual(this.memberCount, loaded.memberCount) && Intrinsics3.areEqual(this.tabItems, loaded.tabItems) && Intrinsics3.areEqual(this.actions, loaded.actions) && Intrinsics3.areEqual(this.emojisData, loaded.emojisData) && Intrinsics3.areEqual(this.bottomActions, loaded.bottomActions) && this.isGuildHub == loaded.isGuildHub && Intrinsics3.areEqual(this.meUser, loaded.meUser);
            }

            public final Actions getActions() {
                return this.actions;
            }

            public final Banner getBanner() {
                return this.banner;
            }

            public final BottomActions getBottomActions() {
                return this.bottomActions;
            }

            public final EmojisData getEmojisData() {
                return this.emojisData;
            }

            public final String getGuildDescription() {
                return this.guildDescription;
            }

            public final String getGuildIcon() {
                return this.guildIcon;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final String getGuildName() {
                return this.guildName;
            }

            public final String getGuildShortName() {
                return this.guildShortName;
            }

            public final MeUser getMeUser() {
                return this.meUser;
            }

            public final Integer getMemberCount() {
                return this.memberCount;
            }

            public final Integer getOnlineCount() {
                return this.onlineCount;
            }

            public final TabItems getTabItems() {
                return this.tabItems;
            }

            public final Integer getVerifiedPartneredIconRes() {
                return this.verifiedPartneredIconRes;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v27, types: [int] */
            /* JADX WARN: Type inference failed for: r1v37, types: [int] */
            /* JADX WARN: Type inference failed for: r1v39 */
            /* JADX WARN: Type inference failed for: r1v52 */
            public int hashCode() {
                int iA = b.a(this.guildId) * 31;
                String str = this.guildName;
                int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.guildShortName;
                int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.guildIcon;
                int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
                String str4 = this.guildDescription;
                int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
                Integer num = this.verifiedPartneredIconRes;
                int iHashCode5 = (iHashCode4 + (num != null ? num.hashCode() : 0)) * 31;
                Banner banner = this.banner;
                int iHashCode6 = (iHashCode5 + (banner != null ? banner.hashCode() : 0)) * 31;
                Integer num2 = this.onlineCount;
                int iHashCode7 = (iHashCode6 + (num2 != null ? num2.hashCode() : 0)) * 31;
                Integer num3 = this.memberCount;
                int iHashCode8 = (iHashCode7 + (num3 != null ? num3.hashCode() : 0)) * 31;
                TabItems tabItems = this.tabItems;
                int iHashCode9 = (iHashCode8 + (tabItems != null ? tabItems.hashCode() : 0)) * 31;
                Actions actions = this.actions;
                int iHashCode10 = (iHashCode9 + (actions != null ? actions.hashCode() : 0)) * 31;
                EmojisData emojisData = this.emojisData;
                int iHashCode11 = (iHashCode10 + (emojisData != null ? emojisData.hashCode() : 0)) * 31;
                BottomActions bottomActions = this.bottomActions;
                int iHashCode12 = (iHashCode11 + (bottomActions != null ? bottomActions.hashCode() : 0)) * 31;
                boolean z2 = this.isGuildHub;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode12 + r1) * 31;
                MeUser meUser = this.meUser;
                return i + (meUser != null ? meUser.hashCode() : 0);
            }

            public final boolean isGuildHub() {
                return this.isGuildHub;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(guildId=");
                sbU.append(this.guildId);
                sbU.append(", guildName=");
                sbU.append(this.guildName);
                sbU.append(", guildShortName=");
                sbU.append(this.guildShortName);
                sbU.append(", guildIcon=");
                sbU.append(this.guildIcon);
                sbU.append(", guildDescription=");
                sbU.append(this.guildDescription);
                sbU.append(", verifiedPartneredIconRes=");
                sbU.append(this.verifiedPartneredIconRes);
                sbU.append(", banner=");
                sbU.append(this.banner);
                sbU.append(", onlineCount=");
                sbU.append(this.onlineCount);
                sbU.append(", memberCount=");
                sbU.append(this.memberCount);
                sbU.append(", tabItems=");
                sbU.append(this.tabItems);
                sbU.append(", actions=");
                sbU.append(this.actions);
                sbU.append(", emojisData=");
                sbU.append(this.emojisData);
                sbU.append(", bottomActions=");
                sbU.append(this.bottomActions);
                sbU.append(", isGuildHub=");
                sbU.append(this.isGuildHub);
                sbU.append(", meUser=");
                sbU.append(this.meUser);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$onClickLeaveServer$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(1);
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            this.$onSuccess.invoke();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$onClickMarkAsRead$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r3) {
            WidgetGuildProfileSheetViewModel.this.eventSubject.k.onNext((T) new Event.DismissAndShowToast(R.string.marked_as_read));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$onClickResetNickname$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(1);
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            this.$onSuccess.invoke();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$onClickSaveNickname$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(1);
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            this.$onSuccess.invoke();
        }
    }

    public /* synthetic */ WidgetGuildProfileSheetViewModel(StoreUserSettings storeUserSettings, StoreUserGuildSettings storeUserGuildSettings, boolean z2, RestAPI restAPI, StoreLurking storeLurking, StoreAnalytics storeAnalytics, long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings, (i & 2) != 0 ? StoreStream.INSTANCE.getUserGuildSettings() : storeUserGuildSettings, z2, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 16) != 0 ? StoreStream.INSTANCE.getLurking() : storeLurking, (i & 32) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics, j, (i & 128) != 0 ? INSTANCE.observeStores(j) : observable);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0044  */
    /* JADX WARN: Code duplicated, block: B:13:0x0057  */
    /* JADX WARN: Code duplicated, block: B:16:0x005b  */
    /* JADX WARN: Code duplicated, block: B:18:0x006b  */
    /* JADX WARN: Code duplicated, block: B:19:0x0072  */
    /* JADX WARN: Code duplicated, block: B:22:0x0096  */
    /* JADX WARN: Code duplicated, block: B:23:0x009d  */
    /* JADX WARN: Code duplicated, block: B:25:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:44:0x0112  */
    /* JADX WARN: Code duplicated, block: B:45:0x0119  */
    /* JADX WARN: Code duplicated, block: B:47:0x011d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0132  */
    private final void handleLoadedGuild(Guild guild, GuildPreview guildPreview, GuildChannelsInfo guildChannelsInfo, MeUser me2, GuildMember computedMe, List<Long> restrictedGuildIds, boolean isDeveloper, List<? extends Emoji> emojis, boolean isLurking, boolean isUnread) {
        Integer num;
        Integer numValueOf;
        PermissionsContexts manageGuildContext;
        TabItems tabItems;
        Actions actions;
        List<? extends Emoji> listEmptyList;
        boolean z2;
        Integer approximatePresenceCount;
        List<GuildEmoji> listD;
        String nick;
        String avatarHash;
        if (!guild.getFeatures().contains(GuildFeature.VERIFIED)) {
            if (guild.getFeatures().contains(GuildFeature.PARTNERED)) {
                numValueOf = Integer.valueOf(R.drawable.ic_partnered_badge);
            } else {
                num = null;
            }
            Banner banner = new Banner(guild.getId(), guild.getBanner(), Banner.Type.BANNER);
            manageGuildContext = guildChannelsInfo.getManageGuildContext();
            if (isLurking) {
                tabItems = null;
            } else {
                tabItems = new TabItems(manageGuildContext.canManage(), guildChannelsInfo.getAbleToInstantInvite(), guild.getPremiumSubscriptionCount());
            }
            if (isLurking) {
                actions = null;
            } else {
                boolean canManageChannels = manageGuildContext.getCanManageChannels();
                boolean canManageEvents = manageGuildContext.getCanManageEvents();
                boolean canChangeNickname = guildChannelsInfo.getCanChangeNickname();
                if (computedMe != null) {
                    nick = computedMe.getNick();
                } else {
                    nick = null;
                }
                boolean z3 = !restrictedGuildIds.contains(Long.valueOf(guild.getId()));
                boolean hideMutedChannels = guildChannelsInfo.getHideMutedChannels();
                boolean z4 = !guild.isOwner(me2.getId());
                if (computedMe != null) {
                    avatarHash = computedMe.getAvatarHash();
                } else {
                    avatarHash = null;
                }
                actions = new Actions(isUnread, canManageChannels, canManageEvents, canChangeNickname, nick, avatarHash, z3, hideMutedChannels, z4, isDeveloper, me2.getUsername());
            }
            if (isLurking) {
                listEmptyList = emojis;
            } else if (guildPreview != null || (listD = guildPreview.d()) == null) {
                listEmptyList = null;
            } else {
                listEmptyList = new ArrayList<>(Iterables2.collectionSizeOrDefault(listD, 10));
                Iterator<T> it = listD.iterator();
                while (it.hasNext()) {
                    listEmptyList.add(new ModelEmojiCustom((GuildEmoji) it.next(), guildPreview.getId()));
                }
            }
            if (isLurking && manageGuildContext.getCanManageEmojisAndStickers()) {
                z2 = true;
            } else {
                z2 = false;
            }
            BottomActions bottomActions = new BottomActions(z2, isLurking, true ^ this.viewingGuild);
            long id2 = guild.getId();
            String name = guild.getName();
            String shortName = guild.getShortName();
            String icon = guild.getIcon();
            String description = guild.getDescription();
            if (guildPreview != null) {
                approximatePresenceCount = guildPreview.getApproximatePresenceCount();
            } else {
                approximatePresenceCount = null;
            }
            Integer approximateMemberCount = guildPreview != null ? guildPreview.getApproximateMemberCount() : null;
            TabItems tabItems2 = tabItems;
            boolean zIsPremium = UserUtils.INSTANCE.isPremium(me2);
            boolean z5 = this.isEmojiSectionExpanded;
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            updateViewState(new ViewState.Loaded(id2, name, shortName, icon, description, num, banner, approximatePresenceCount, approximateMemberCount, tabItems2, actions, new EmojisData(zIsPremium, z5, listEmptyList), bottomActions, guild.isHub(), me2));
        }
        numValueOf = Integer.valueOf(R.drawable.ic_verified_badge);
        num = numValueOf;
        Banner banner2 = new Banner(guild.getId(), guild.getBanner(), Banner.Type.BANNER);
        manageGuildContext = guildChannelsInfo.getManageGuildContext();
        if (isLurking) {
            tabItems = new TabItems(manageGuildContext.canManage(), guildChannelsInfo.getAbleToInstantInvite(), guild.getPremiumSubscriptionCount());
        } else {
            tabItems = null;
        }
        if (isLurking) {
            boolean canManageChannels2 = manageGuildContext.getCanManageChannels();
            boolean canManageEvents2 = manageGuildContext.getCanManageEvents();
            boolean canChangeNickname2 = guildChannelsInfo.getCanChangeNickname();
            if (computedMe != null) {
                nick = computedMe.getNick();
            } else {
                nick = null;
            }
            boolean z6 = !restrictedGuildIds.contains(Long.valueOf(guild.getId()));
            boolean hideMutedChannels2 = guildChannelsInfo.getHideMutedChannels();
            boolean z7 = !guild.isOwner(me2.getId());
            if (computedMe != null) {
                avatarHash = computedMe.getAvatarHash();
            } else {
                avatarHash = null;
            }
            actions = new Actions(isUnread, canManageChannels2, canManageEvents2, canChangeNickname2, nick, avatarHash, z6, hideMutedChannels2, z7, isDeveloper, me2.getUsername());
        } else {
            actions = null;
        }
        if (isLurking) {
            listEmptyList = emojis;
        } else if (guildPreview != null) {
            listEmptyList = null;
        } else {
            listEmptyList = null;
        }
        if (isLurking) {
            z2 = false;
        } else {
            z2 = false;
        }
        BottomActions bottomActions2 = new BottomActions(z2, isLurking, true ^ this.viewingGuild);
        long id3 = guild.getId();
        String name2 = guild.getName();
        String shortName2 = guild.getShortName();
        String icon2 = guild.getIcon();
        String description2 = guild.getDescription();
        if (guildPreview != null) {
            approximatePresenceCount = guildPreview.getApproximatePresenceCount();
        } else {
            approximatePresenceCount = null;
        }
        if (guildPreview != null) {
        }
        TabItems tabItems3 = tabItems;
        boolean zIsPremium2 = UserUtils.INSTANCE.isPremium(me2);
        boolean z8 = this.isEmojiSectionExpanded;
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        updateViewState(new ViewState.Loaded(id3, name2, shortName2, icon2, description2, num, banner2, approximatePresenceCount, approximateMemberCount, tabItems3, actions, new EmojisData(zIsPremium2, z8, listEmptyList), bottomActions2, guild.isHub(), me2));
    }

    private final void handleLoadedGuildPreview(GuildPreview guildPreview, MeUser meUser) {
        Integer numValueOf;
        if (guildPreview.f().contains(GuildFeature.VERIFIED)) {
            numValueOf = Integer.valueOf(R.drawable.ic_verified_badge);
        } else {
            numValueOf = guildPreview.f().contains(GuildFeature.PARTNERED) ? Integer.valueOf(R.drawable.ic_partnered_badge) : null;
        }
        Integer num = numValueOf;
        Banner banner = new Banner(guildPreview.getId(), guildPreview.getSplash(), Banner.Type.SPLASH);
        BottomActions bottomActions = new BottomActions(false, true, !this.viewingGuild);
        long id2 = guildPreview.getId();
        String name = guildPreview.getName();
        String strComputeShortName = GuildUtils.computeShortName(guildPreview.getName());
        String icon = guildPreview.getIcon();
        String description = guildPreview.getDescription();
        Integer approximatePresenceCount = guildPreview.getApproximatePresenceCount();
        Integer approximateMemberCount = guildPreview.getApproximateMemberCount();
        boolean zIsPremium = UserUtils.INSTANCE.isPremium(meUser);
        boolean z2 = this.isEmojiSectionExpanded;
        List<GuildEmoji> listD = guildPreview.d();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listD, 10));
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            arrayList.add(new ModelEmojiCustom((GuildEmoji) it.next(), guildPreview.getId()));
            it = it;
            approximatePresenceCount = approximatePresenceCount;
            approximateMemberCount = approximateMemberCount;
        }
        updateViewState(new ViewState.Loaded(id2, name, strComputeShortName, icon, description, num, banner, approximatePresenceCount, approximateMemberCount, null, null, new EmojisData(zIsPremium, z2, arrayList), bottomActions, guildPreview.f().contains(GuildFeature.HUB), meUser));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleStoreState(StoreState storeState) {
        Guild guild = storeState.getGuild();
        StoreGuildProfiles.GuildProfileData guildProfile = storeState.getGuildProfile();
        GuildChannelsInfo guildChannelsInfo = storeState.getGuildChannelsInfo();
        MeUser me2 = storeState.getMe();
        GuildMember computedMe = storeState.getComputedMe();
        List<Long> listComponent6 = storeState.component6();
        boolean isDeveloper = storeState.getIsDeveloper();
        List<? extends Emoji> listComponent8 = storeState.component8();
        boolean isLurking = storeState.getIsLurking();
        boolean isUnread = storeState.getIsUnread();
        if (guild != null) {
            handleLoadedGuild(guild, guildProfile != null ? guildProfile.getData() : null, guildChannelsInfo, me2, computedMe, listComponent6, isDeveloper, listComponent8, isLurking, isUnread);
            return;
        }
        Object fetchState = guildProfile != null ? guildProfile.getFetchState() : null;
        Object obj = StoreGuildProfiles.FetchStates.SUCCEEDED;
        if (fetchState == obj && guildProfile.getData() != null) {
            handleLoadedGuildPreview(guildProfile.getData(), me2);
            return;
        }
        if ((guildProfile != null ? guildProfile.getFetchState() : null) != StoreGuildProfiles.FetchStates.FAILED) {
            if ((guildProfile != null ? guildProfile.getFetchState() : null) != obj || guildProfile.getData() != null) {
                updateViewState(ViewState.Loading.INSTANCE);
                return;
            }
        }
        updateViewState(ViewState.Invalid.INSTANCE);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onClickEmoji() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || this.isEmojiSectionExpanded) {
            return;
        }
        this.isEmojiSectionExpanded = true;
        updateViewState(ViewState.Loaded.copy$default(loaded, 0L, null, null, null, null, null, null, null, null, null, null, EmojisData.copy$default(loaded.getEmojisData(), false, this.isEmojiSectionExpanded, null, 5, null), null, false, null, 30719, null));
    }

    public final void onClickJoinServer(long guildId, Fragment fragment) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Context context = fragment.getContext();
        if (context != null) {
            StoreLurking storeLurking = this.storeLurking;
            Intrinsics3.checkNotNullExpressionValue(context, "it");
            storeLurking.postJoinGuildAsMember(guildId, context);
        }
    }

    public final void onClickLeaveServer(long guildId, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.leaveGuild(guildId), false, 1, null), this, null, 2, null), (Class<?>) WidgetGuildProfileSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(onSuccess));
    }

    public final void onClickMarkAsRead(long guildId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ackGuild(guildId), false, 1, null), this, null, 2, null), (Class<?>) WidgetGuildProfileSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final void onClickResetNickname(long guildId, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.changeGuildNickname(guildId, new RestAPIParams.Nick("")), false, 1, null), this, null, 2, null), (Class<?>) WidgetGuildProfileSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(onSuccess));
    }

    public final void onClickSaveNickname(long guildId, String nick, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(nick, ModelAuditLogEntry.CHANGE_KEY_NICK);
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.changeGuildNickname(guildId, new RestAPIParams.Nick(nick)), false, 1, null), this, null, 2, null), (Class<?>) WidgetGuildProfileSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(onSuccess));
    }

    public final void onClickViewServer(long guildId, Long channelId) {
        StoreLurking.startLurkingAndNavigate$default(this.storeLurking, guildId, channelId, null, 4, null);
    }

    public final void setAllowDM(AppActivity appActivity, long guildId, boolean allow) {
        this.storeUserSettings.setRestrictedGuildId(appActivity, guildId, !allow);
    }

    public final void setHideMutedChannels(long guildId, boolean hide) {
        this.storeUserGuildSettings.setHideMutedChannels(guildId, hide);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheetViewModel(StoreUserSettings storeUserSettings, StoreUserGuildSettings storeUserGuildSettings, boolean z2, RestAPI restAPI, StoreLurking storeLurking, StoreAnalytics storeAnalytics, long j, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        Intrinsics3.checkNotNullParameter(storeUserGuildSettings, "storeUserGuildSettings");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(storeLurking, "storeLurking");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.storeUserSettings = storeUserSettings;
        this.storeUserGuildSettings = storeUserGuildSettings;
        this.viewingGuild = z2;
        this.restAPI = restAPI;
        this.storeLurking = storeLurking;
        this.guildId = j;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) WidgetGuildProfileSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        storeAnalytics.trackGuildProfileOpened(j);
    }
}
