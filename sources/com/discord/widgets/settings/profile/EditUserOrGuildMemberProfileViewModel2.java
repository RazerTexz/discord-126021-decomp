package com.discord.widgets.settings.profile;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildmember.PatchGuildMemberBody;
import com.discord.api.user.PatchUserBody;
import com.discord.api.user.User;
import com.discord.api.user.UserProfile;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.nullserializable.NullSerializable;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserProfile;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.error.Error;
import com.discord.utilities.premium.PremiumUtils3;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.settings.profile.EditUserOrGuildMemberProfileViewModel2;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.subjects.PublishSubject;

/* JADX INFO: renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel, reason: use source file name */
/* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EditUserOrGuildMemberProfileViewModel2 extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> bioParser;
    private final PublishSubject<Event> eventSubject;
    private final Long guildId;
    private final RestAPI restAPI;
    private final Set<Integer> revealedBioIndices;
    private final StoreGuilds storeGuilds;
    private final StoreUserProfile storeUserProfile;

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<MeUser, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            EditUserOrGuildMemberProfileViewModel2.this.storeUserProfile.fetchProfile(meUser.getId(), (12 & 2) != 0 ? null : EditUserOrGuildMemberProfileViewModel2.this.guildId, (12 & 4) != 0 ? false : false, (12 & 8) != 0 ? null : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2 = EditUserOrGuildMemberProfileViewModel2.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            editUserOrGuildMemberProfileViewModel2.handleStoreState(storeState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Companion, reason: from kotlin metadata */
    /* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(final Long guildId, StoreUser storeUser, final StoreGuilds storeGuilds, final StoreUserProfile storeUserProfile) {
            Observable<StoreState> observableY = Observable.j(StoreUser.observeMe$default(storeUser, false, 1, null), storeGuilds.observeGuild(guildId != null ? guildId.longValue() : -1L), new Func2<MeUser, Guild, Tuples2<? extends MeUser, ? extends Guild>>() { // from class: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Companion$observeStoreState$1
                @Override // rx.functions.Func2
                public final Tuples2<MeUser, Guild> call(MeUser meUser, Guild guild) {
                    return new Tuples2<>(meUser, guild);
                }
            }).Y(new Func1<Tuples2<? extends MeUser, ? extends Guild>, Observable<? extends StoreState>>() { // from class: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Companion$observeStoreState$2
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Observable<? extends EditUserOrGuildMemberProfileViewModel2.StoreState> call(Tuples2<? extends MeUser, ? extends Guild> tuples2) {
                    return call2((Tuples2<MeUser, Guild>) tuples2);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends EditUserOrGuildMemberProfileViewModel2.StoreState> call2(Tuples2<MeUser, Guild> tuples2) {
                    final MeUser meUserComponent1 = tuples2.component1();
                    final Guild guildComponent2 = tuples2.component2();
                    Observable<UserProfile> observableObserveUserProfile = storeUserProfile.observeUserProfile(meUserComponent1.getId());
                    StoreGuilds storeGuilds2 = storeGuilds;
                    Long l = guildId;
                    Observable<GuildMember> observableObserveGuildMember = storeGuilds2.observeGuildMember(l != null ? l.longValue() : -1L, meUserComponent1.getId());
                    GuildChannelsInfo.Companion companion = GuildChannelsInfo.INSTANCE;
                    Long l2 = guildId;
                    return Observable.i(observableObserveUserProfile, observableObserveGuildMember, companion.get(l2 != null ? l2.longValue() : -1L), new Func3<UserProfile, GuildMember, GuildChannelsInfo, EditUserOrGuildMemberProfileViewModel2.StoreState>() { // from class: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Companion$observeStoreState$2.1
                        @Override // rx.functions.Func3
                        public final EditUserOrGuildMemberProfileViewModel2.StoreState call(UserProfile userProfile, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo) {
                            MeUser.Companion companion2 = MeUser.INSTANCE;
                            MeUser meUser = meUserComponent1;
                            Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
                            MeUser meUserMerge = companion2.merge(meUser, userProfile.getUser());
                            Guild guild = guildComponent2;
                            Intrinsics3.checkNotNullExpressionValue(userProfile, "userProfile");
                            Intrinsics3.checkNotNullExpressionValue(guildChannelsInfo, "guildChannelsInfo");
                            return new EditUserOrGuildMemberProfileViewModel2.StoreState(meUserMerge, guild, userProfile, guildMember, guildChannelsInfo);
                        }
                    });
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "Observable.combineLatest…      )\n        }\n      }");
            return observableY;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, Long l, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserProfile storeUserProfile, int i, Object obj) {
            if ((i & 2) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            if ((i & 4) != 0) {
                storeGuilds = StoreStream.INSTANCE.getGuilds();
            }
            if ((i & 8) != 0) {
                storeUserProfile = StoreStream.INSTANCE.getUserProfile();
            }
            return companion.observeStoreState(l, storeUser, storeGuilds, storeUserProfile);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Event */
    /* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Event$UserUpdateRequestCompleted */
        /* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
        public static final class UserUpdateRequestCompleted extends Event {
            public static final UserUpdateRequestCompleted INSTANCE = new UserUpdateRequestCompleted();

            private UserUpdateRequestCompleted() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$StoreState */
    /* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final GuildChannelsInfo guildChannelsInfo;
        private final GuildMember meMember;
        private final MeUser user;
        private final UserProfile userProfile;

        public StoreState(MeUser meUser, Guild guild, UserProfile userProfile, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo) {
            Intrinsics3.checkNotNullParameter(meUser, "user");
            Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            this.user = meUser;
            this.guild = guild;
            this.userProfile = userProfile;
            this.meMember = guildMember;
            this.guildChannelsInfo = guildChannelsInfo;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, MeUser meUser, Guild guild, UserProfile userProfile, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                meUser = storeState.user;
            }
            if ((i & 2) != 0) {
                guild = storeState.guild;
            }
            Guild guild2 = guild;
            if ((i & 4) != 0) {
                userProfile = storeState.userProfile;
            }
            UserProfile userProfile2 = userProfile;
            if ((i & 8) != 0) {
                guildMember = storeState.meMember;
            }
            GuildMember guildMember2 = guildMember;
            if ((i & 16) != 0) {
                guildChannelsInfo = storeState.guildChannelsInfo;
            }
            return storeState.copy(meUser, guild2, userProfile2, guildMember2, guildChannelsInfo);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MeUser getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final GuildMember getMeMember() {
            return this.meMember;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        public final StoreState copy(MeUser user, Guild guild, UserProfile userProfile, GuildMember meMember, GuildChannelsInfo guildChannelsInfo) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            return new StoreState(user, guild, userProfile, meMember, guildChannelsInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.user, storeState.user) && Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.userProfile, storeState.userProfile) && Intrinsics3.areEqual(this.meMember, storeState.meMember) && Intrinsics3.areEqual(this.guildChannelsInfo, storeState.guildChannelsInfo);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        public final GuildMember getMeMember() {
            return this.meMember;
        }

        public final MeUser getUser() {
            return this.user;
        }

        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        public int hashCode() {
            MeUser meUser = this.user;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            UserProfile userProfile = this.userProfile;
            int iHashCode3 = (iHashCode2 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
            GuildMember guildMember = this.meMember;
            int iHashCode4 = (iHashCode3 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            GuildChannelsInfo guildChannelsInfo = this.guildChannelsInfo;
            return iHashCode4 + (guildChannelsInfo != null ? guildChannelsInfo.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(user=");
            sbU.append(this.user);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", userProfile=");
            sbU.append(this.userProfile);
            sbU.append(", meMember=");
            sbU.append(this.meMember);
            sbU.append(", guildChannelsInfo=");
            sbU.append(this.guildChannelsInfo);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$ViewState */
    /* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$ViewState$Loaded */
        /* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<Node<MessageRenderContext>> bioAst;
            private final boolean canEditNickname;
            private final boolean canHaveAnimatedAvatars;
            private final NullSerializable<String> currentAvatar;
            private final NullSerializable<String> currentBannerColorHex;
            private final NullSerializable<String> currentBannerImage;
            private final String currentBio;
            private final String currentNickname;
            private final Guild guild;
            private final boolean hasAvatarForDisplay;
            private final boolean hasBannerImageForDisplay;
            private final boolean hasMemberAvatarForDisplay;
            private final boolean hasMemberBannerForDisplay;
            private final boolean hasUserAvatarForDisplay;
            private final boolean hasUserBannerForDisplay;
            private final boolean isBioChanged;
            private final boolean isDirty;
            private final boolean isEditingBio;
            private final GuildMember meMember;
            private final String nonDefaultColorPreviewHex;
            private final boolean showBioEditor;
            private final boolean showSaveFab;
            private final MeUser user;
            private final UserProfile userProfile;

            public /* synthetic */ Loaded(MeUser meUser, Guild guild, GuildMember guildMember, UserProfile userProfile, NullSerializable nullSerializable, NullSerializable nullSerializable2, NullSerializable nullSerializable3, String str, String str2, List list, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(meUser, guild, guildMember, userProfile, (i & 16) != 0 ? null : nullSerializable, (i & 32) != 0 ? null : nullSerializable2, (i & 64) != 0 ? null : nullSerializable3, (i & 128) != 0 ? null : str, str2, list, z2, z3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, MeUser meUser, Guild guild, GuildMember guildMember, UserProfile userProfile, NullSerializable nullSerializable, NullSerializable nullSerializable2, NullSerializable nullSerializable3, String str, String str2, List list, boolean z2, boolean z3, int i, Object obj) {
                return loaded.copy((i & 1) != 0 ? loaded.user : meUser, (i & 2) != 0 ? loaded.guild : guild, (i & 4) != 0 ? loaded.meMember : guildMember, (i & 8) != 0 ? loaded.userProfile : userProfile, (i & 16) != 0 ? loaded.currentAvatar : nullSerializable, (i & 32) != 0 ? loaded.currentBannerImage : nullSerializable2, (i & 64) != 0 ? loaded.currentBannerColorHex : nullSerializable3, (i & 128) != 0 ? loaded.currentNickname : str, (i & 256) != 0 ? loaded.currentBio : str2, (i & 512) != 0 ? loaded.bioAst : list, (i & 1024) != 0 ? loaded.isEditingBio : z2, (i & 2048) != 0 ? loaded.canEditNickname : z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final MeUser getUser() {
                return this.user;
            }

            public final List<Node<MessageRenderContext>> component10() {
                return this.bioAst;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final boolean getIsEditingBio() {
                return this.isEditingBio;
            }

            /* JADX INFO: renamed from: component12, reason: from getter */
            public final boolean getCanEditNickname() {
                return this.canEditNickname;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final GuildMember getMeMember() {
                return this.meMember;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final UserProfile getUserProfile() {
                return this.userProfile;
            }

            public final NullSerializable<String> component5() {
                return this.currentAvatar;
            }

            public final NullSerializable<String> component6() {
                return this.currentBannerImage;
            }

            public final NullSerializable<String> component7() {
                return this.currentBannerColorHex;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final String getCurrentNickname() {
                return this.currentNickname;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final String getCurrentBio() {
                return this.currentBio;
            }

            public final Loaded copy(MeUser user, Guild guild, GuildMember meMember, UserProfile userProfile, NullSerializable<String> currentAvatar, NullSerializable<String> currentBannerImage, NullSerializable<String> currentBannerColorHex, String currentNickname, String currentBio, List<Node<MessageRenderContext>> bioAst, boolean isEditingBio, boolean canEditNickname) {
                Intrinsics3.checkNotNullParameter(user, "user");
                Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
                return new Loaded(user, guild, meMember, userProfile, currentAvatar, currentBannerImage, currentBannerColorHex, currentNickname, currentBio, bioAst, isEditingBio, canEditNickname);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.user, loaded.user) && Intrinsics3.areEqual(this.guild, loaded.guild) && Intrinsics3.areEqual(this.meMember, loaded.meMember) && Intrinsics3.areEqual(this.userProfile, loaded.userProfile) && Intrinsics3.areEqual(this.currentAvatar, loaded.currentAvatar) && Intrinsics3.areEqual(this.currentBannerImage, loaded.currentBannerImage) && Intrinsics3.areEqual(this.currentBannerColorHex, loaded.currentBannerColorHex) && Intrinsics3.areEqual(this.currentNickname, loaded.currentNickname) && Intrinsics3.areEqual(this.currentBio, loaded.currentBio) && Intrinsics3.areEqual(this.bioAst, loaded.bioAst) && this.isEditingBio == loaded.isEditingBio && this.canEditNickname == loaded.canEditNickname;
            }

            public final List<Node<MessageRenderContext>> getBioAst() {
                return this.bioAst;
            }

            public final boolean getCanEditNickname() {
                return this.canEditNickname;
            }

            public final boolean getCanHaveAnimatedAvatars() {
                return this.canHaveAnimatedAvatars;
            }

            public final NullSerializable<String> getCurrentAvatar() {
                return this.currentAvatar;
            }

            public final NullSerializable<String> getCurrentBannerColorHex() {
                return this.currentBannerColorHex;
            }

            public final NullSerializable<String> getCurrentBannerImage() {
                return this.currentBannerImage;
            }

            public final String getCurrentBio() {
                return this.currentBio;
            }

            public final String getCurrentNickname() {
                return this.currentNickname;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final boolean getHasAvatarForDisplay() {
                return this.hasAvatarForDisplay;
            }

            public final boolean getHasBannerImageForDisplay() {
                return this.hasBannerImageForDisplay;
            }

            public final GuildMember getMeMember() {
                return this.meMember;
            }

            public final String getNonDefaultColorPreviewHex() {
                return this.nonDefaultColorPreviewHex;
            }

            public final boolean getShowBioEditor() {
                return this.showBioEditor;
            }

            public final boolean getShowSaveFab() {
                return this.showSaveFab;
            }

            public final MeUser getUser() {
                return this.user;
            }

            public final UserProfile getUserProfile() {
                return this.userProfile;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v22, types: [int] */
            /* JADX WARN: Type inference failed for: r0v24, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r2v25 */
            /* JADX WARN: Type inference failed for: r2v26, types: [int] */
            /* JADX WARN: Type inference failed for: r2v27 */
            public int hashCode() {
                MeUser meUser = this.user;
                int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
                Guild guild = this.guild;
                int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
                GuildMember guildMember = this.meMember;
                int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
                UserProfile userProfile = this.userProfile;
                int iHashCode4 = (iHashCode3 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
                NullSerializable<String> nullSerializable = this.currentAvatar;
                int iHashCode5 = (iHashCode4 + (nullSerializable != null ? nullSerializable.hashCode() : 0)) * 31;
                NullSerializable<String> nullSerializable2 = this.currentBannerImage;
                int iHashCode6 = (iHashCode5 + (nullSerializable2 != null ? nullSerializable2.hashCode() : 0)) * 31;
                NullSerializable<String> nullSerializable3 = this.currentBannerColorHex;
                int iHashCode7 = (iHashCode6 + (nullSerializable3 != null ? nullSerializable3.hashCode() : 0)) * 31;
                String str = this.currentNickname;
                int iHashCode8 = (iHashCode7 + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.currentBio;
                int iHashCode9 = (iHashCode8 + (str2 != null ? str2.hashCode() : 0)) * 31;
                List<Node<MessageRenderContext>> list = this.bioAst;
                int iHashCode10 = (iHashCode9 + (list != null ? list.hashCode() : 0)) * 31;
                boolean z2 = this.isEditingBio;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode10 + r1) * 31;
                boolean z3 = this.canEditNickname;
                return i + (z3 ? 1 : z3);
            }

            /* JADX INFO: renamed from: isBioChanged, reason: from getter */
            public final boolean getIsBioChanged() {
                return this.isBioChanged;
            }

            /* JADX INFO: renamed from: isDirty, reason: from getter */
            public final boolean getIsDirty() {
                return this.isDirty;
            }

            public final boolean isEditingBio() {
                return this.isEditingBio;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(user=");
                sbU.append(this.user);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", meMember=");
                sbU.append(this.meMember);
                sbU.append(", userProfile=");
                sbU.append(this.userProfile);
                sbU.append(", currentAvatar=");
                sbU.append(this.currentAvatar);
                sbU.append(", currentBannerImage=");
                sbU.append(this.currentBannerImage);
                sbU.append(", currentBannerColorHex=");
                sbU.append(this.currentBannerColorHex);
                sbU.append(", currentNickname=");
                sbU.append(this.currentNickname);
                sbU.append(", currentBio=");
                sbU.append(this.currentBio);
                sbU.append(", bioAst=");
                sbU.append(this.bioAst);
                sbU.append(", isEditingBio=");
                sbU.append(this.isEditingBio);
                sbU.append(", canEditNickname=");
                return outline.O(sbU, this.canEditNickname, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Code duplicated, block: B:29:0x0062  */
            /* JADX WARN: Code duplicated, block: B:46:0x008c  */
            public Loaded(MeUser meUser, Guild guild, GuildMember guildMember, UserProfile userProfile, NullSerializable<String> nullSerializable, NullSerializable<String> nullSerializable2, NullSerializable<String> nullSerializable3, String str, String str2, List<Node<MessageRenderContext>> list, boolean z2, boolean z3) {
                boolean z4;
                boolean z5;
                super(null);
                Intrinsics3.checkNotNullParameter(meUser, "user");
                Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
                this.user = meUser;
                this.guild = guild;
                this.meMember = guildMember;
                this.userProfile = userProfile;
                this.currentAvatar = nullSerializable;
                this.currentBannerImage = nullSerializable2;
                this.currentBannerColorHex = nullSerializable3;
                this.currentNickname = str;
                this.currentBio = str2;
                this.bioAst = list;
                this.isEditingBio = z2;
                this.canEditNickname = z3;
                boolean z6 = false;
                if (nullSerializable == null && nullSerializable2 == null && nullSerializable3 == null) {
                    String bio = guildMember != null ? "" : "";
                    if (!(!Intrinsics3.areEqual(str2, bio))) {
                        if (guildMember != null) {
                            String nick = guildMember.getNick();
                            z4 = Intrinsics3.areEqual(nick == null ? "" : nick, str == null ? "" : str) ^ true;
                        }
                    }
                }
                this.isDirty = z4;
                this.showSaveFab = z4 && !z2;
                this.isBioChanged = !Intrinsics3.areEqual(str2, meUser.getBio());
                if (z2) {
                    z5 = true;
                } else {
                    if (str2 == null || StringsJVM.isBlank(str2)) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                }
                this.showBioEditor = z5;
                this.nonDefaultColorPreviewHex = ((nullSerializable3 instanceof NullSerializable.b) || (nullSerializable3 instanceof NullSerializable.a)) ? nullSerializable3.a() : meUser.getBannerColor();
                boolean z7 = guildMember == null && meUser.getAvatar() != null;
                this.hasUserAvatarForDisplay = z7;
                boolean z8 = guildMember != null && guildMember.hasAvatar();
                this.hasMemberAvatarForDisplay = z8;
                this.hasAvatarForDisplay = !(nullSerializable instanceof NullSerializable.a) && ((nullSerializable instanceof NullSerializable.b) || z7 || z8);
                boolean z9 = guildMember == null && meUser.getBanner() != null;
                this.hasUserBannerForDisplay = z9;
                boolean z10 = guildMember != null && guildMember.hasBanner();
                this.hasMemberBannerForDisplay = z10;
                if (!(nullSerializable2 instanceof NullSerializable.a) && ((nullSerializable2 instanceof NullSerializable.b) || z9 || z10)) {
                    z6 = true;
                }
                this.hasBannerImageForDisplay = z6;
                this.canHaveAnimatedAvatars = PremiumUtils3.grantsAccessToCustomTagAndAnimatedAvatarFeatures(meUser.getPremiumTier());
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$saveGuildMemberChanges$1, reason: invalid class name */
    /* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            EditUserOrGuildMemberProfileViewModel2.this.eventSubject.k.onNext((T) Event.UserUpdateRequestCompleted.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$saveGuildMemberChanges$2, reason: invalid class name */
    /* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<com.discord.api.guildmember.GuildMember, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guildmember.GuildMember guildMember) {
            invoke2(guildMember);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guildmember.GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(guildMember, "apiMember");
            EditUserOrGuildMemberProfileViewModel2.this.storeGuilds.handleGuildMember(com.discord.api.guildmember.GuildMember.a(guildMember, EditUserOrGuildMemberProfileViewModel2.this.guildId.longValue(), null, null, null, null, null, false, null, null, null, null, null, null, 8190), EditUserOrGuildMemberProfileViewModel2.this.guildId.longValue(), true);
            EditUserOrGuildMemberProfileViewModel2.this.updateViewState(ViewState.Loaded.copy$default(this.$viewState, null, null, GuildMember.INSTANCE.from(guildMember, EditUserOrGuildMemberProfileViewModel2.this.guildId.longValue(), (8 & 4) != 0 ? null : null, (8 & 8) != 0 ? null : EditUserOrGuildMemberProfileViewModel2.this.storeGuilds), null, null, null, null, null, null, null, false, false, 3979, null));
            EditUserOrGuildMemberProfileViewModel2.this.eventSubject.k.onNext((T) Event.UserUpdateRequestCompleted.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$saveUserChanges$1, reason: invalid class name */
    /* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            EditUserOrGuildMemberProfileViewModel2.this.eventSubject.k.onNext((T) Event.UserUpdateRequestCompleted.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$saveUserChanges$2, reason: invalid class name */
    /* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<User, Unit> {
        public final /* synthetic */ MeUser $meUser;
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MeUser meUser, ViewState.Loaded loaded) {
            super(1);
            this.$meUser = meUser;
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            Intrinsics3.checkNotNullParameter(user, "apiUser");
            EditUserOrGuildMemberProfileViewModel2.this.storeUserProfile.updateUser(user);
            EditUserOrGuildMemberProfileViewModel2.this.updateViewState(ViewState.Loaded.copy$default(this.$viewState, MeUser.INSTANCE.merge(this.$meUser, user), null, null, null, null, null, null, null, null, null, false, false, 3982, null));
            EditUserOrGuildMemberProfileViewModel2.this.eventSubject.k.onNext((T) Event.UserUpdateRequestCompleted.INSTANCE);
        }
    }

    public /* synthetic */ EditUserOrGuildMemberProfileViewModel2(Long l, StoreUser storeUser, StoreUserProfile storeUserProfile, StoreGuilds storeGuilds, RestAPI restAPI, Parser parser, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, (i & 2) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 4) != 0 ? StoreStream.INSTANCE.getUserProfile() : storeUserProfile, (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 32) != 0 ? DiscordParser.createParser$default(false, false, false, false, false, 28, null) : parser, (i & 64) != 0 ? Companion.observeStoreState$default(INSTANCE, l, null, null, null, 14, null) : observable);
    }

    private final List<Node<MessageRenderContext>> createAndProcessBioAstFromText(String bio) {
        List<Node<MessageRenderContext>> bio2 = parseBio(bio);
        createMessagePreprocessor().process(bio2);
        return bio2;
    }

    private final MessagePreprocessor createMessagePreprocessor() {
        return new MessagePreprocessor(-1L, this.revealedBioIndices, null, false, null, 28, null);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        String bio;
        String str;
        MeUser user = storeState.getUser();
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (bio = loaded.getCurrentBio()) == null) {
            GuildMember meMember = storeState.getMeMember();
            if (meMember != null) {
                bio = meMember.getBio();
                if (bio == null) {
                    bio = "";
                }
            } else {
                bio = null;
            }
        }
        if (bio == null) {
            bio = user.getBio();
        }
        String str2 = bio;
        List<Node<MessageRenderContext>> listCreateAndProcessBioAstFromText = str2 != null ? createAndProcessBioAstFromText(str2) : null;
        ViewState viewState2 = getViewState();
        if (!(viewState2 instanceof ViewState.Loaded)) {
            viewState2 = null;
        }
        ViewState.Loaded loaded2 = (ViewState.Loaded) viewState2;
        if (loaded2 == null || (nick = loaded2.getCurrentNickname()) == null) {
            GuildMember meMember2 = storeState.getMeMember();
            if (meMember2 != null) {
                String nick = meMember2.getNick();
                str = nick;
            } else {
                str = null;
            }
        } else {
            str = nick;
        }
        Guild guild = storeState.getGuild();
        UserProfile userProfile = storeState.getUserProfile();
        NullSerializable nullSerializable = null;
        NullSerializable nullSerializable2 = null;
        NullSerializable nullSerializable3 = null;
        ViewState viewState3 = getViewState();
        ViewState.Loaded loaded3 = (ViewState.Loaded) (viewState3 instanceof ViewState.Loaded ? viewState3 : null);
        updateViewState(new ViewState.Loaded(user, guild, storeState.getMeMember(), userProfile, nullSerializable, nullSerializable2, nullSerializable3, str, str2, listCreateAndProcessBioAstFromText, loaded3 != null ? loaded3.isEditingBio() : false, storeState.getGuildChannelsInfo().getCanChangeNickname(), 112, null));
    }

    private final List<Node<MessageRenderContext>> parseBio(String bio) {
        return Parser.parse$default(this.bioParser, bio, MessageParseState.INSTANCE.getInitialState(), null, 4, null);
    }

    @MainThread
    private final void saveGuildMemberChanges(Context context) {
        Long l;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (l = this.guildId) == null) {
            return;
        }
        l.longValue();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.updateMeGuildMember(this.guildId.longValue(), new PatchGuildMemberBody(loaded.getCurrentNickname(), loaded.getCurrentAvatar(), loaded.getCurrentBannerImage(), loaded.getCurrentBio())), false, 1, null), this, null, 2, null), (Class<?>) EditUserOrGuildMemberProfileViewModel2.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(loaded));
    }

    @MainThread
    private final void saveUserChanges(Context context) {
        NullSerializable bVar;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            MeUser user = loaded.getUser();
            String currentBio = loaded.getCurrentBio();
            if (loaded.getIsBioChanged()) {
                bVar = currentBio != null ? new NullSerializable.b(currentBio) : new NullSerializable.a(null, 1);
            } else {
                bVar = null;
            }
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.patchUser(new PatchUserBody(loaded.getCurrentAvatar(), loaded.getCurrentBannerImage(), loaded.getCurrentBannerColorHex(), bVar)), false, 1, null), this, null, 2, null), (Class<?>) EditUserOrGuildMemberProfileViewModel2.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(user, loaded));
        }
    }

    @MainThread
    public final void handleBioIndexClicked(SpoilerNode<?> spoilerNode) {
        String currentBio;
        Intrinsics3.checkNotNullParameter(spoilerNode, "spoilerNode");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (currentBio = loaded.getCurrentBio()) == null) {
            return;
        }
        this.revealedBioIndices.add(Integer.valueOf(spoilerNode.getId()));
        updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, null, null, null, createAndProcessBioAstFromText(currentBio), false, false, 3583, null));
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final Observable<UserProfileHeaderViewModel.ViewState> observeHeaderViewState() {
        Observable<UserProfileHeaderViewModel.ViewState> observableR = observeViewState().G(new Func1<ViewState, UserProfileHeaderViewModel.ViewState>() { // from class: com.discord.widgets.settings.profile.SettingsUserProfileViewModel.observeHeaderViewState.1
            @Override // j0.k.Func1
            public final UserProfileHeaderViewModel.ViewState call(ViewState viewState) {
                MeUser user;
                String banner;
                GuildMember meMember;
                if (viewState == null) {
                    return UserProfileHeaderViewModel.ViewState.Uninitialized.INSTANCE;
                }
                if (!(viewState instanceof ViewState.Loaded)) {
                    throw new NoWhenBranchMatchedException();
                }
                ViewState.Loaded loaded = (ViewState.Loaded) viewState;
                if (loaded.getCurrentAvatar() == null || loaded.getMeMember() != null) {
                    user = loaded.getUser();
                } else {
                    MeUser user2 = loaded.getUser();
                    user = user2.copy((258047 & 1) != 0 ? user2.getId() : 0L, (258047 & 2) != 0 ? user2.getUsername() : null, (258047 & 4) != 0 ? user2.getAvatar() : loaded.getCurrentAvatar().a(), (258047 & 8) != 0 ? user2.getBanner() : null, (258047 & 16) != 0 ? user2.getIsBot() : false, (258047 & 32) != 0 ? user2.getIsSystemUser() : false, (258047 & 64) != 0 ? user2.getDiscriminator() : 0, (258047 & 128) != 0 ? user2.getPremiumTier() : null, (258047 & 256) != 0 ? user2.email : null, (258047 & 512) != 0 ? user2.mfaEnabled : false, (258047 & 1024) != 0 ? user2.isVerified : false, (258047 & 2048) != 0 ? user2.token : null, (258047 & 4096) != 0 ? user2.getFlags() : 0, (258047 & 8192) != 0 ? user2.getPublicFlags() : 0, (258047 & 16384) != 0 ? user2.phoneNumber : null, (258047 & 32768) != 0 ? user2.nsfwAllowance : null, (258047 & 65536) != 0 ? user2.getBio() : null, (258047 & 131072) != 0 ? user2.getBannerColor() : null);
                }
                MeUser meUser = user;
                UserProfile userProfile = loaded.getUserProfile();
                if (loaded.getCurrentBannerImage() == null) {
                    GuildMember meMember2 = loaded.getMeMember();
                    if (meMember2 == null || (banner = meMember2.getBannerHash()) == null) {
                        banner = loaded.getUser().getBanner();
                    }
                } else if (loaded.getCurrentBannerImage() instanceof NullSerializable.a) {
                    banner = loaded.getMeMember() != null ? loaded.getUser().getBanner() : null;
                } else {
                    banner = loaded.getCurrentBannerImage().a();
                }
                String str = banner;
                NullSerializable<String> currentBannerColorHex = loaded.getCurrentBannerColorHex();
                String strA = ((currentBannerColorHex instanceof NullSerializable.b) || (currentBannerColorHex instanceof NullSerializable.a)) ? currentBannerColorHex.a() : loaded.getUser().getBannerColor();
                boolean zIsPremium = UserUtils.INSTANCE.isPremium(loaded.getUser());
                boolean zIsVerified = loaded.getUser().isVerified();
                if (loaded.getMeMember() != null) {
                    GuildMember meMember3 = loaded.getMeMember();
                    if (loaded.getCurrentAvatar() != null) {
                        meMember3 = meMember3.copy((7679 & 1) != 0 ? meMember3.color : 0, (7679 & 2) != 0 ? meMember3.hoistRoleId : 0L, (7679 & 4) != 0 ? meMember3.roles : null, (7679 & 8) != 0 ? meMember3.nick : null, (7679 & 16) != 0 ? meMember3.premiumSince : null, (7679 & 32) != 0 ? meMember3.pending : false, (7679 & 64) != 0 ? meMember3.joinedAt : null, (7679 & 128) != 0 ? meMember3.guildId : 0L, (7679 & 256) != 0 ? meMember3.userId : 0L, (7679 & 512) != 0 ? meMember3.avatarHash : loaded.getCurrentAvatar().a(), (7679 & 1024) != 0 ? meMember3.bannerHash : null, (7679 & 2048) != 0 ? meMember3.bio : null, (7679 & 4096) != 0 ? meMember3.communicationDisabledUntil : null);
                    }
                    GuildMember guildMemberCopy = meMember3;
                    if (loaded.getCurrentBannerImage() != null) {
                        guildMemberCopy = guildMemberCopy.copy((7679 & 1) != 0 ? guildMemberCopy.color : 0, (7679 & 2) != 0 ? guildMemberCopy.hoistRoleId : 0L, (7679 & 4) != 0 ? guildMemberCopy.roles : null, (7679 & 8) != 0 ? guildMemberCopy.nick : null, (7679 & 16) != 0 ? guildMemberCopy.premiumSince : null, (7679 & 32) != 0 ? guildMemberCopy.pending : false, (7679 & 64) != 0 ? guildMemberCopy.joinedAt : null, (7679 & 128) != 0 ? guildMemberCopy.guildId : 0L, (7679 & 256) != 0 ? guildMemberCopy.userId : 0L, (7679 & 512) != 0 ? guildMemberCopy.avatarHash : null, (7679 & 1024) != 0 ? guildMemberCopy.bannerHash : loaded.getCurrentBannerImage().a(), (7679 & 2048) != 0 ? guildMemberCopy.bio : null, (7679 & 4096) != 0 ? guildMemberCopy.communicationDisabledUntil : null);
                    }
                    meMember = guildMemberCopy;
                } else {
                    meMember = loaded.getMeMember();
                }
                return new UserProfileHeaderViewModel.ViewState.Loaded(meUser, str, strA, meMember, null, null, null, userProfile, zIsPremium, zIsVerified, false, false, true, false, false, false, 58480, null);
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeViewState().map {… }.distinctUntilChanged()");
        return observableR;
    }

    @MainThread
    public final void saveChanges(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (this.guildId != null) {
            saveGuildMemberChanges(context);
        } else {
            saveUserChanges(context);
        }
    }

    @MainThread
    public final void updateAvatar(String dataUrl) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, dataUrl != null ? new NullSerializable.b(dataUrl) : new NullSerializable.a(null, 1), null, null, null, null, null, false, false, 4079, null));
        }
    }

    @MainThread
    public final void updateBannerColor(String colorHex) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, colorHex != null ? new NullSerializable.b(colorHex) : new NullSerializable.a(null, 1), null, null, null, false, false, 4031, null));
        }
    }

    @MainThread
    public final void updateBannerImage(String dataUrl) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, dataUrl != null ? new NullSerializable.b(dataUrl) : new NullSerializable.a(null, 1), null, null, null, null, false, false, 4063, null));
        }
    }

    @MainThread
    public final void updateBio(String bio) {
        Intrinsics3.checkNotNullParameter(bio, "bio");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null && (!Intrinsics3.areEqual(bio, loaded.getCurrentBio()))) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, null, null, bio, createAndProcessBioAstFromText(bio), false, false, 3327, null));
        }
    }

    @MainThread
    public final void updateIsEditingBio(boolean isEditing) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, null, null, null, null, isEditing, false, 3071, null));
        }
    }

    @MainThread
    public final void updateNickname(String nick) {
        Intrinsics3.checkNotNullParameter(nick, ModelAuditLogEntry.CHANGE_KEY_NICK);
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, null, nick, null, null, false, false, 3967, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditUserOrGuildMemberProfileViewModel2(Long l, StoreUser storeUser, StoreUserProfile storeUserProfile, StoreGuilds storeGuilds, RestAPI restAPI, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeUserProfile, "storeUserProfile");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(parser, "bioParser");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = l;
        this.storeUserProfile = storeUserProfile;
        this.storeGuilds = storeGuilds;
        this.restAPI = restAPI;
        this.bioParser = parser;
        this.eventSubject = PublishSubject.k0();
        Observable observableZ = ObservableExtensionsKt.computationLatest(storeUser.observeMe(false)).Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "storeUser.observeMe(emit…Latest()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableZ, this, null, 2, null), (Class<?>) EditUserOrGuildMemberProfileViewModel2.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), (Class<?>) EditUserOrGuildMemberProfileViewModel2.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        this.revealedBioIndices = new LinkedHashSet();
    }
}
