package com.discord.widgets.guilds.profile;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildmember.PatchGuildMemberBody;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.nullserializable.NullSerializable;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func4;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentityViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final RestAPI restAPI;
    private final String sourceSection;
    private boolean trackedModalOpen;
    private boolean trackedUpsell;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
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
            WidgetChangeGuildIdentityViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(final long guildId, StoreGuilds storeGuilds, StoreUser storeUser) {
            Observable<StoreState> observableH = Observable.h(GuildChannelsInfo.INSTANCE.get(guildId), storeGuilds.observeGuild(guildId), StoreUser.observeMe$default(storeUser, false, 1, null), StoreUser.observeMe$default(storeUser, false, 1, null).Y(new Func1<MeUser, Observable<? extends GuildMember>>() { // from class: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel$Companion$observeStoreState$1
                @Override // j0.k.Func1
                public final Observable<? extends GuildMember> call(final MeUser meUser) {
                    return StoreStream.INSTANCE.getGuilds().observeComputed(guildId, CollectionsJVM.listOf(Long.valueOf(meUser.getId()))).G(new Func1<Map<Long, ? extends GuildMember>, GuildMember>() { // from class: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel$Companion$observeStoreState$1.1
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
            }), new Func4<GuildChannelsInfo, Guild, MeUser, GuildMember, StoreState>() { // from class: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel$Companion$observeStoreState$2
                @Override // rx.functions.Func4
                public final WidgetChangeGuildIdentityViewModel.StoreState call(GuildChannelsInfo guildChannelsInfo, Guild guild, MeUser meUser, GuildMember guildMember) {
                    Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
                    Intrinsics3.checkNotNullExpressionValue(guildChannelsInfo, "guildChannelsInfo");
                    return new WidgetChangeGuildIdentityViewModel.StoreState(guild, meUser, guildMember, guildChannelsInfo);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…uildChannelsInfo)\n      }");
            return observableH;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, long j, StoreGuilds storeGuilds, StoreUser storeUser, int i, Object obj) {
            if ((i & 2) != 0) {
                storeGuilds = StoreStream.INSTANCE.getGuilds();
            }
            if ((i & 4) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            return companion.observeStoreState(j, storeGuilds, storeUser);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
        public static final /* data */ class MemberUpdateFailed extends Event {
            private final String errorMessage;

            public MemberUpdateFailed(String str) {
                super(null);
                this.errorMessage = str;
            }

            public static /* synthetic */ MemberUpdateFailed copy$default(MemberUpdateFailed memberUpdateFailed, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = memberUpdateFailed.errorMessage;
                }
                return memberUpdateFailed.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public final MemberUpdateFailed copy(String errorMessage) {
                return new MemberUpdateFailed(errorMessage);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof MemberUpdateFailed) && Intrinsics3.areEqual(this.errorMessage, ((MemberUpdateFailed) other).errorMessage);
                }
                return true;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public int hashCode() {
                String str = this.errorMessage;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("MemberUpdateFailed(errorMessage="), this.errorMessage, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
        public static final class MemberUpdateSucceeded extends Event {
            public static final MemberUpdateSucceeded INSTANCE = new MemberUpdateSucceeded();

            private MemberUpdateSucceeded() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final GuildChannelsInfo guildChannelsInfo;
        private final MeUser meUser;
        private final GuildMember member;

        public StoreState(Guild guild, MeUser meUser, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            this.guild = guild;
            this.meUser = meUser;
            this.member = guildMember;
            this.guildChannelsInfo = guildChannelsInfo;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, MeUser meUser, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.guild;
            }
            if ((i & 2) != 0) {
                meUser = storeState.meUser;
            }
            if ((i & 4) != 0) {
                guildMember = storeState.member;
            }
            if ((i & 8) != 0) {
                guildChannelsInfo = storeState.guildChannelsInfo;
            }
            return storeState.copy(guild, meUser, guildMember, guildChannelsInfo);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final GuildMember getMember() {
            return this.member;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        public final StoreState copy(Guild guild, MeUser meUser, GuildMember member, GuildChannelsInfo guildChannelsInfo) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
            return new StoreState(guild, meUser, member, guildChannelsInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.meUser, storeState.meUser) && Intrinsics3.areEqual(this.member, storeState.member) && Intrinsics3.areEqual(this.guildChannelsInfo, storeState.guildChannelsInfo);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final GuildChannelsInfo getGuildChannelsInfo() {
            return this.guildChannelsInfo;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final GuildMember getMember() {
            return this.member;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            MeUser meUser = this.meUser;
            int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
            GuildMember guildMember = this.member;
            int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
            GuildChannelsInfo guildChannelsInfo = this.guildChannelsInfo;
            return iHashCode3 + (guildChannelsInfo != null ? guildChannelsInfo.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guild=");
            sbU.append(this.guild);
            sbU.append(", meUser=");
            sbU.append(this.meUser);
            sbU.append(", member=");
            sbU.append(this.member);
            sbU.append(", guildChannelsInfo=");
            sbU.append(this.guildChannelsInfo);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean canChangeNickname;
            private final NullSerializable<String> currentAvatar;
            private final String currentNickname;
            private final boolean dimmed;
            private final String displayedAvatarURL;
            private final boolean displayingGuildAvatar;
            private final Guild guild;
            private final boolean isDirty;
            private final MeUser meUser;
            private final GuildMember member;
            private final boolean shouldUpsell;
            private final boolean showSaveFab;

            public /* synthetic */ Loaded(Guild guild, MeUser meUser, GuildMember guildMember, boolean z2, String str, NullSerializable nullSerializable, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(guild, meUser, guildMember, z2, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : nullSerializable, (i & 64) != 0 ? false : z3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Guild guild, MeUser meUser, GuildMember guildMember, boolean z2, String str, NullSerializable nullSerializable, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = loaded.guild;
                }
                if ((i & 2) != 0) {
                    meUser = loaded.meUser;
                }
                MeUser meUser2 = meUser;
                if ((i & 4) != 0) {
                    guildMember = loaded.member;
                }
                GuildMember guildMember2 = guildMember;
                if ((i & 8) != 0) {
                    z2 = loaded.canChangeNickname;
                }
                boolean z4 = z2;
                if ((i & 16) != 0) {
                    str = loaded.currentNickname;
                }
                String str2 = str;
                if ((i & 32) != 0) {
                    nullSerializable = loaded.currentAvatar;
                }
                NullSerializable nullSerializable2 = nullSerializable;
                if ((i & 64) != 0) {
                    z3 = loaded.dimmed;
                }
                return loaded.copy(guild, meUser2, guildMember2, z4, str2, nullSerializable2, z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final MeUser getMeUser() {
                return this.meUser;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final GuildMember getMember() {
                return this.member;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getCanChangeNickname() {
                return this.canChangeNickname;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getCurrentNickname() {
                return this.currentNickname;
            }

            public final NullSerializable<String> component6() {
                return this.currentAvatar;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final boolean getDimmed() {
                return this.dimmed;
            }

            public final Loaded copy(Guild guild, MeUser meUser, GuildMember member, boolean canChangeNickname, String currentNickname, NullSerializable<String> currentAvatar, boolean dimmed) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                Intrinsics3.checkNotNullParameter(member, "member");
                return new Loaded(guild, meUser, member, canChangeNickname, currentNickname, currentAvatar, dimmed);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.guild, loaded.guild) && Intrinsics3.areEqual(this.meUser, loaded.meUser) && Intrinsics3.areEqual(this.member, loaded.member) && this.canChangeNickname == loaded.canChangeNickname && Intrinsics3.areEqual(this.currentNickname, loaded.currentNickname) && Intrinsics3.areEqual(this.currentAvatar, loaded.currentAvatar) && this.dimmed == loaded.dimmed;
            }

            public final boolean getCanChangeNickname() {
                return this.canChangeNickname;
            }

            public final NullSerializable<String> getCurrentAvatar() {
                return this.currentAvatar;
            }

            public final String getCurrentNickname() {
                return this.currentNickname;
            }

            public final boolean getDimmed() {
                return this.dimmed;
            }

            public final String getDisplayedAvatarURL() {
                return this.displayedAvatarURL;
            }

            public final boolean getDisplayingGuildAvatar() {
                return this.displayingGuildAvatar;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final MeUser getMeUser() {
                return this.meUser;
            }

            public final GuildMember getMember() {
                return this.member;
            }

            public final boolean getShouldUpsell() {
                return this.shouldUpsell;
            }

            public final boolean getShowSaveFab() {
                return this.showSaveFab;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v14, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r2v13 */
            /* JADX WARN: Type inference failed for: r2v16 */
            /* JADX WARN: Type inference failed for: r2v7, types: [int] */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                MeUser meUser = this.meUser;
                int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
                GuildMember guildMember = this.member;
                int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
                boolean z2 = this.canChangeNickname;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode3 + r2) * 31;
                String str = this.currentNickname;
                int iHashCode4 = (i + (str != null ? str.hashCode() : 0)) * 31;
                NullSerializable<String> nullSerializable = this.currentAvatar;
                int iHashCode5 = (iHashCode4 + (nullSerializable != null ? nullSerializable.hashCode() : 0)) * 31;
                boolean z3 = this.dimmed;
                return iHashCode5 + (z3 ? 1 : z3);
            }

            /* JADX INFO: renamed from: isDirty, reason: from getter */
            public final boolean getIsDirty() {
                return this.isDirty;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(guild=");
                sbU.append(this.guild);
                sbU.append(", meUser=");
                sbU.append(this.meUser);
                sbU.append(", member=");
                sbU.append(this.member);
                sbU.append(", canChangeNickname=");
                sbU.append(this.canChangeNickname);
                sbU.append(", currentNickname=");
                sbU.append(this.currentNickname);
                sbU.append(", currentAvatar=");
                sbU.append(this.currentAvatar);
                sbU.append(", dimmed=");
                return outline.O(sbU, this.dimmed, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Guild guild, MeUser meUser, GuildMember guildMember, boolean z2, String str, NullSerializable<String> nullSerializable, boolean z3) {
                String forGuildMember$default;
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                Intrinsics3.checkNotNullParameter(guildMember, "member");
                this.guild = guild;
                this.meUser = meUser;
                this.member = guildMember;
                this.canChangeNickname = z2;
                this.currentNickname = str;
                this.currentAvatar = nullSerializable;
                this.dimmed = z3;
                String nick = guildMember.getNick();
                boolean z4 = (Intrinsics3.areEqual(nick == null ? "" : nick, str) ^ true) || nullSerializable != null;
                this.isDirty = z4;
                this.showSaveFab = z4;
                if (!(nullSerializable instanceof NullSerializable)) {
                    forGuildMember$default = guildMember.hasAvatar() ? IconUtils.getForGuildMember$default(IconUtils.INSTANCE, guildMember, null, true, 2, null) : IconUtils.getForUser$default(meUser, true, null, 4, null);
                } else if (nullSerializable instanceof NullSerializable.b) {
                    forGuildMember$default = (String) ((NullSerializable.b) nullSerializable).a();
                } else {
                    if (!(nullSerializable instanceof NullSerializable.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    forGuildMember$default = IconUtils.getForUser$default(meUser, true, null, 4, null);
                }
                this.displayedAvatarURL = forGuildMember$default;
                this.displayingGuildAvatar = nullSerializable instanceof NullSerializable ? nullSerializable instanceof NullSerializable.b : guildMember.hasAvatar();
                this.shouldUpsell = !UserUtils.INSTANCE.isPremiumTier2(meUser);
            }
        }

        /* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
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

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel$saveMemberChanges$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x005f  */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            String message;
            Intrinsics3.checkNotNullParameter(error, "it");
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "it.response");
            if (!response.getMessages().values().isEmpty()) {
                Error.Response response2 = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response2, "it.response");
                Object objFirst = _Collections.first(response2.getMessages().values());
                Intrinsics3.checkNotNullExpressionValue(objFirst, "it.response.messages.values.first()");
                if (!((Collection) objFirst).isEmpty()) {
                    Error.Response response3 = error.getResponse();
                    Intrinsics3.checkNotNullExpressionValue(response3, "it.response");
                    Object objFirst2 = _Collections.first(response3.getMessages().values());
                    Intrinsics3.checkNotNullExpressionValue(objFirst2, "it.response.messages.values.first()");
                    message = (String) _Collections.first((List) objFirst2);
                } else {
                    Error.Response response4 = error.getResponse();
                    Intrinsics3.checkNotNullExpressionValue(response4, "it.response");
                    message = response4.getMessage();
                }
            } else {
                Error.Response response5 = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response5, "it.response");
                message = response5.getMessage();
            }
            WidgetChangeGuildIdentityViewModel.this.eventSubject.k.onNext((T) new Event.MemberUpdateFailed(message));
            WidgetChangeGuildIdentityViewModel.this.updateViewState(ViewState.Loaded.copy$default(this.$viewState, null, null, null, false, null, null, false, 63, null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel$saveMemberChanges$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
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
            Intrinsics3.checkNotNullParameter(guildMember, "it");
            WidgetChangeGuildIdentityViewModel.this.eventSubject.k.onNext((T) Event.MemberUpdateSucceeded.INSTANCE);
            WidgetChangeGuildIdentityViewModel.this.updateViewState(ViewState.Loaded.copy$default(this.$viewState, null, null, null, false, null, null, false, 63, null));
        }
    }

    public /* synthetic */ WidgetChangeGuildIdentityViewModel(long j, String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        String nick;
        NullSerializable<String> currentAvatar;
        Guild guild = storeState.getGuild();
        GuildMember member = storeState.getMember();
        MeUser meUser = storeState.getMeUser();
        GuildChannelsInfo guildChannelsInfo = storeState.getGuildChannelsInfo();
        if (guild == null || member == null) {
            return;
        }
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (nick = loaded.getCurrentNickname()) == null) {
            nick = member.getNick();
        }
        String str = nick;
        ViewState viewState2 = getViewState();
        if (!(viewState2 instanceof ViewState.Loaded)) {
            viewState2 = null;
        }
        ViewState.Loaded loaded2 = (ViewState.Loaded) viewState2;
        updateViewState(new ViewState.Loaded(guild, meUser, member, guildChannelsInfo.getCanChangeNickname(), str, (loaded2 == null || (currentAvatar = loaded2.getCurrentAvatar()) == null) ? null : currentAvatar, false, 64, null));
    }

    @MainThread
    public final void clearStatus() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, false, "", null, false, 111, null));
        }
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getSourceSection() {
        return this.sourceSection;
    }

    public final boolean getTrackedModalOpen() {
        return this.trackedModalOpen;
    }

    public final boolean getTrackedUpsell() {
        return this.trackedUpsell;
    }

    public final Observable<Event> observeEvents() {
        return this.eventSubject;
    }

    @MainThread
    public final void saveMemberChanges(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, false, null, null, true, 63, null));
            RestAPI restAPI = this.restAPI;
            long id2 = loaded.getGuild().getId();
            String currentNickname = loaded.getCurrentNickname();
            String nick = loaded.getMember().getNick();
            if (nick == null) {
                nick = "";
            }
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(restAPI.updateMeGuildMember(id2, new PatchGuildMemberBody(Intrinsics3.areEqual(currentNickname, nick) ^ true ? loaded.getCurrentNickname() : null, loaded.getCurrentAvatar(), null, null, 12)), false, 1, null), this, null, 2, null), (Class<?>) WidgetChangeGuildIdentityViewModel.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1(loaded)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(loaded));
        }
    }

    public final void setTrackedModalOpen(boolean z2) {
        this.trackedModalOpen = z2;
    }

    public final void setTrackedUpsell(boolean z2) {
        this.trackedUpsell = z2;
    }

    @MainThread
    public final void updateAvatar(String dataUrl) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, false, null, dataUrl != null ? new NullSerializable.b(dataUrl) : new NullSerializable.a(null, 1), false, 95, null));
        }
    }

    @MainThread
    public final void updateNickname(String nickname) {
        Intrinsics3.checkNotNullParameter(nickname, "nickname");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || !(!Intrinsics3.areEqual(nickname, loaded.getCurrentNickname()))) {
            return;
        }
        updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, false, nickname, null, false, 111, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChangeGuildIdentityViewModel(long j, String str, RestAPI restAPI) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(str, "sourceSection");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.guildId = j;
        this.sourceSection = str;
        this.restAPI = restAPI;
        PublishSubject<Event> publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(Companion.observeStoreState$default(INSTANCE, j, null, null, 6, null)), this, null, 2, null), (Class<?>) WidgetChangeGuildIdentityViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
