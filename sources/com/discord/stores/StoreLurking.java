package com.discord.stores;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelPayload;
import com.discord.restapi.RestAPIInterface;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.guilds.join.GuildJoinHelperKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLurking {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Dispatcher dispatcher;
    private final StoreGuilds guildsStore;
    private LurkRequest lurkRequest;
    private final Map<Long, LurkContext> lurkedGuilds;
    private final BehaviorSubject<Map<Long, LurkContext>> lurkedGuildsSubject;
    private String sessionId;
    private final StoreStream stream;

    /* JADX INFO: compiled from: StoreLurking.kt */
    public static final class Companion {
        private Companion() {
        }

        private final boolean isLurking(boolean isJoined, long guildId, Set<Long> lurkingGuildIds) {
            return !isJoined && lurkingGuildIds.contains(Long.valueOf(guildId));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreLurking.kt */
    public static final /* data */ class LurkContext {
        private final long guildId;
        private final boolean shouldNavigate;

        public LurkContext(long j, boolean z2) {
            this.guildId = j;
            this.shouldNavigate = z2;
        }

        public static /* synthetic */ LurkContext copy$default(LurkContext lurkContext, long j, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = lurkContext.guildId;
            }
            if ((i & 2) != 0) {
                z2 = lurkContext.shouldNavigate;
            }
            return lurkContext.copy(j, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getShouldNavigate() {
            return this.shouldNavigate;
        }

        public final LurkContext copy(long guildId, boolean shouldNavigate) {
            return new LurkContext(guildId, shouldNavigate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LurkContext)) {
                return false;
            }
            LurkContext lurkContext = (LurkContext) other;
            return this.guildId == lurkContext.guildId && this.shouldNavigate == lurkContext.shouldNavigate;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final boolean getShouldNavigate() {
            return this.shouldNavigate;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            int iM3a = C0002b.m3a(this.guildId) * 31;
            boolean z2 = this.shouldNavigate;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iM3a + r1;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("LurkContext(guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", shouldNavigate=");
            return C1643a.m827O(sbM833U, this.shouldNavigate, ")");
        }
    }

    /* JADX INFO: compiled from: StoreLurking.kt */
    public static final /* data */ class LurkRequest {
        private final Long channelId;
        private final long guildId;

        public LurkRequest(long j, Long l) {
            this.guildId = j;
            this.channelId = l;
        }

        public static /* synthetic */ LurkRequest copy$default(LurkRequest lurkRequest, long j, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                j = lurkRequest.guildId;
            }
            if ((i & 2) != 0) {
                l = lurkRequest.channelId;
            }
            return lurkRequest.copy(j, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getChannelId() {
            return this.channelId;
        }

        public final LurkRequest copy(long guildId, Long channelId) {
            return new LurkRequest(guildId, channelId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LurkRequest)) {
                return false;
            }
            LurkRequest lurkRequest = (LurkRequest) other;
            return this.guildId == lurkRequest.guildId && C12238m.areEqual(this.channelId, lurkRequest.channelId);
        }

        public final Long getChannelId() {
            return this.channelId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public int hashCode() {
            int iM3a = C0002b.m3a(this.guildId) * 31;
            Long l = this.channelId;
            return iM3a + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("LurkRequest(guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", channelId=");
            return C1643a.m819G(sbM833U, this.channelId, ")");
        }

        public /* synthetic */ LurkRequest(long j, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? null : l);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreLurking$postJoinGuildAsMember$1 */
    /* JADX INFO: compiled from: StoreLurking.kt */
    public static final class C61471 extends AbstractC12240o implements Function1<Guild, Unit> {
        public static final C61471 INSTANCE = new C61471();

        public C61471() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            C12238m.checkNotNullParameter(guild, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreLurking$postLeaveGuild$1 */
    /* JADX INFO: compiled from: StoreLurking.kt */
    public static final class C61481 extends AbstractC12240o implements Function0<Unit> {
        public static final C61481 INSTANCE = new C61481();

        public C61481() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreLurking$postLeaveGuild$2 */
    /* JADX INFO: compiled from: StoreLurking.kt */
    public static final class C61492 extends AbstractC12240o implements Function0<Unit> {
        public static final C61492 INSTANCE = new C61492();

        public C61492() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreLurking$postLeaveGuild$3 */
    /* JADX INFO: compiled from: StoreLurking.kt */
    public static final class C61503 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ Function0 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61503(Function0 function0) {
            super(1);
            this.$onFailure = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            this.$onFailure.invoke();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreLurking$postLeaveGuild$4 */
    /* JADX INFO: compiled from: StoreLurking.kt */
    public static final class C61514 extends AbstractC12240o implements Function1<Void, Unit> {
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61514(Function0 function0) {
            super(1);
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            this.$onSuccess.invoke();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreLurking$startLurking$1 */
    /* JADX INFO: compiled from: StoreLurking.kt */
    public static final class C61521 extends AbstractC12240o implements Function3<com.discord.models.guild.Guild, Long, Boolean, Unit> {
        public static final C61521 INSTANCE = new C61521();

        public C61521() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.models.guild.Guild guild, Long l, Boolean bool) {
            invoke(guild, l, bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(com.discord.models.guild.Guild guild, Long l, boolean z2) {
            C12238m.checkNotNullParameter(guild, "<anonymous parameter 0>");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreLurking$startLurking$2 */
    /* JADX INFO: compiled from: StoreLurking.kt */
    public static final class C61532 extends AbstractC12240o implements Function0<Unit> {
        public static final C61532 INSTANCE = new C61532();

        public C61532() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreLurking$startLurking$3 */
    /* JADX INFO: compiled from: StoreLurking.kt */
    public static final class C61543 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ boolean $navigateToGuild;
        public final /* synthetic */ Function0 $onErrorLurking;
        public final /* synthetic */ Function3 $onGuildLurked;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61543(long j, Long l, boolean z2, Function3 function3, Function0 function0) {
            super(0);
            this.$guildId = j;
            this.$channelId = l;
            this.$navigateToGuild = z2;
            this.$onGuildLurked = function3;
            this.$onErrorLurking = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreLurking.startLurkingInternal$default(StoreLurking.this, this.$guildId, this.$channelId, this.$navigateToGuild, this.$onGuildLurked, this.$onErrorLurking, null, 32, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreLurking$startLurkingAndNavigate$1 */
    /* JADX INFO: compiled from: StoreLurking.kt */
    public static final class C61551 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreLurking$startLurkingAndNavigate$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreLurking.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function3<com.discord.models.guild.Guild, Long, Boolean, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreLurking$startLurkingAndNavigate$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreLurking.kt */
            public static final class C132601 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
                public static final C132601 INSTANCE = new C132601();

                public C132601() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
                    return Boolean.valueOf(invoke2(fragmentActivity));
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(FragmentActivity fragmentActivity) {
                    C12238m.checkNotNullParameter(fragmentActivity, "it");
                    StoreNavigation.setNavigationPanelAction$default(StoreStream.INSTANCE.getNavigation(), StoreNavigation.PanelAction.OPEN, null, 2, null);
                    return true;
                }
            }

            public AnonymousClass1() {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(com.discord.models.guild.Guild guild, Long l, Boolean bool) {
                invoke(guild, l, bool.booleanValue());
                return Unit.f27425a;
            }

            public final void invoke(com.discord.models.guild.Guild guild, Long l, boolean z2) {
                C12238m.checkNotNullParameter(guild, "guild");
                StoreLurking$startLurkingAndNavigate$1$1$jumpToDestination$1 storeLurking$startLurkingAndNavigate$1$1$jumpToDestination$1 = new StoreLurking$startLurkingAndNavigate$1$1$jumpToDestination$1(this, l);
                if (z2) {
                    storeLurking$startLurkingAndNavigate$1$1$jumpToDestination$1.invoke();
                    return;
                }
                if (z2) {
                    return;
                }
                storeLurking$startLurkingAndNavigate$1$1$jumpToDestination$1.invoke();
                StoreLurking.this.stream.handleGuildJoined(C61551.this.$guildId, guild.getWelcomeScreen());
                StoreNavigation navigation = StoreStream.INSTANCE.getNavigation();
                StringBuilder sbM833U = C1643a.m833U("LURK:");
                sbM833U.append(C61551.this.$guildId);
                navigation.launchNotice(sbM833U.toString(), C132601.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61551(long j, Long l, Context context) {
            super(0);
            this.$guildId = j;
            this.$channelId = l;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreLurking.this.sessionId != null) {
                StoreLurking.startLurkingInternal$default(StoreLurking.this, this.$guildId, this.$channelId, false, new AnonymousClass1(), null, this.$context, 20, null);
                return;
            }
            StringBuilder sbM833U = C1643a.m833U("Queue lurk request: ");
            sbM833U.append(this.$guildId);
            sbM833U.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
            sbM833U.append(this.$channelId);
            AppLog.m8358i(sbM833U.toString());
            StoreLurking.this.lurkRequest = new LurkRequest(this.$guildId, this.$channelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreLurking$startLurkingInternal$1 */
    /* JADX INFO: compiled from: StoreLurking.kt */
    public static final class C61561 extends AbstractC12240o implements Function3<com.discord.models.guild.Guild, Long, Boolean, Unit> {
        public static final C61561 INSTANCE = new C61561();

        public C61561() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.models.guild.Guild guild, Long l, Boolean bool) {
            invoke(guild, l, bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(com.discord.models.guild.Guild guild, Long l, boolean z2) {
            C12238m.checkNotNullParameter(guild, "<anonymous parameter 0>");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreLurking$startLurkingInternal$2 */
    /* JADX INFO: compiled from: StoreLurking.kt */
    public static final class C61572 extends AbstractC12240o implements Function0<Unit> {
        public static final C61572 INSTANCE = new C61572();

        public C61572() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreLurking$startLurkingInternal$3 */
    /* JADX INFO: compiled from: StoreLurking.kt */
    public static final class C61583 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreLurking$startLurkingInternal$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreLurking.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreLurking.this.lurkedGuilds.remove(Long.valueOf(C61583.this.$guildId));
                StoreLurking.this.lurkedGuildsSubject.onNext(StoreLurking.this.lurkedGuilds);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61583(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            error.setShowErrorToasts(StoreLurking.this.isLurking$app_productionGoogleRelease(this.$guildId));
            StoreLurking.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreLurking$startLurkingInternal$4 */
    /* JADX INFO: compiled from: StoreLurking.kt */
    public static final class C61594 extends AbstractC12240o implements Function1<Guild, Unit> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Function3 $onGuildLurked;

        /* JADX INFO: renamed from: com.discord.stores.StoreLurking$startLurkingInternal$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreLurking.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ Guild $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Guild guild) {
                super(0);
                this.$it = guild;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (!StoreLurking.this.isLurking$app_productionGoogleRelease(this.$it)) {
                    StoreLurking.this.lurkedGuilds.remove(Long.valueOf(C61594.this.$guildId));
                    StoreLurking.this.lurkedGuildsSubject.onNext(StoreLurking.this.lurkedGuilds);
                }
                C61594.this.$onGuildLurked.invoke(new com.discord.models.guild.Guild(this.$it), C61594.this.$channelId, Boolean.FALSE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61594(long j, Function3 function3, Long l) {
            super(1);
            this.$guildId = j;
            this.$onGuildLurked = function3;
            this.$channelId = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            C12238m.checkNotNullParameter(guild, "it");
            StoreLurking.this.dispatcher.schedule(new AnonymousClass1(guild));
        }
    }

    public StoreLurking(StoreStream storeStream, StoreGuilds storeGuilds, Dispatcher dispatcher) {
        C12238m.checkNotNullParameter(storeStream, "stream");
        C12238m.checkNotNullParameter(storeGuilds, "guildsStore");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        this.stream = storeStream;
        this.guildsStore = storeGuilds;
        this.dispatcher = dispatcher;
        this.lurkedGuilds = new LinkedHashMap();
        this.lurkedGuildsSubject = BehaviorSubject.m11130l0(new LinkedHashMap());
    }

    private final void postLeaveGuild(long guildId, Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().leaveGuild(guildId, new RestAPIParams.LeaveGuildBody(true)), false, 1, null), (Class<?>) StoreLurking.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C61503(onFailure)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C61514(onSuccess));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void postLeaveGuild$default(StoreLurking storeLurking, long j, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = C61481.INSTANCE;
        }
        if ((i & 4) != 0) {
            function1 = C61492.INSTANCE;
        }
        storeLurking.postLeaveGuild(j, function0, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startLurking$default(StoreLurking storeLurking, long j, Long l, boolean z2, Function3 function3, Function0 function0, int i, Object obj) {
        boolean z3 = (i & 4) != 0 ? true : z2;
        if ((i & 8) != 0) {
            function3 = C61521.INSTANCE;
        }
        Function3 function4 = function3;
        if ((i & 16) != 0) {
            function0 = C61532.INSTANCE;
        }
        storeLurking.startLurking(j, l, z3, function4, function0);
    }

    public static /* synthetic */ void startLurkingAndNavigate$default(StoreLurking storeLurking, long j, Long l, Context context, int i, Object obj) {
        if ((i & 4) != 0) {
            context = null;
        }
        storeLurking.startLurkingAndNavigate(j, l, context);
    }

    @StoreThread
    private final void startLurkingInternal(long guildId, Long channelId, boolean navigateToGuild, Function3<? super com.discord.models.guild.Guild, ? super Long, ? super Boolean, Unit> onGuildLurked, Function0<Unit> onErrorLurking, Context context) {
        if (this.sessionId == null) {
            Logger.w$default(AppLog.f14950g, "Cannot lurk " + guildId + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + channelId + " with no session", null, 2, null);
            onErrorLurking.invoke();
            return;
        }
        if (guildId == 0 && guildId != -1) {
            Logger.w$default(AppLog.f14950g, "Invalid ids for lurking " + guildId + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + channelId, null, 2, null);
            onErrorLurking.invoke();
            return;
        }
        com.discord.models.guild.Guild guild = this.stream.getGuilds().getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        if (guild != null && !isLurking$app_productionGoogleRelease(guild)) {
            onGuildLurked.invoke(guild, channelId, Boolean.TRUE);
            return;
        }
        this.lurkedGuilds.put(Long.valueOf(guildId), new LurkContext(guildId, navigateToGuild));
        this.lurkedGuildsSubject.onNext(this.lurkedGuilds);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPIInterface.DefaultImpls.joinGuild$default(RestAPI.INSTANCE.getApi(), guildId, true, this.sessionId, null, new RestAPIParams.InviteCode(null, null), null, 32, null), false, 1, null)), (Class<?>) StoreLurking.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C61583(guildId)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C61594(guildId, onGuildLurked, channelId));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startLurkingInternal$default(StoreLurking storeLurking, long j, Long l, boolean z2, Function3 function3, Function0 function0, Context context, int i, Object obj) {
        storeLurking.startLurkingInternal(j, l, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? C61561.INSTANCE : function3, (i & 16) != 0 ? C61572.INSTANCE : function0, (i & 32) != 0 ? null : context);
    }

    @StoreThread
    private final void stopLurkingInternal(long guildId) {
        if (this.lurkedGuilds.remove(Long.valueOf(guildId)) != null) {
            this.lurkedGuildsSubject.onNext(this.lurkedGuilds);
        }
    }

    public final Observable<Set<Long>> getLurkingGuildIds() {
        Observable observableM11083G = this.lurkedGuildsSubject.m11083G(new InterfaceC12589b<Map<Long, LurkContext>, Set<? extends Long>>() { // from class: com.discord.stores.StoreLurking.getLurkingGuildIds.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Set<Long> call(Map<Long, LurkContext> map) {
                return map.keySet();
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "lurkedGuildsSubject.map { it.keys }");
        return observableM11083G;
    }

    public final Set<Long> getLurkingGuildIdsSync() {
        return this.lurkedGuilds.keySet();
    }

    @StoreThread
    public final void handleConnectionOpen$app_productionGoogleRelease(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        this.sessionId = payload.getSessionId();
        LurkRequest lurkRequest = this.lurkRequest;
        if (lurkRequest != null) {
            AppLog.m8358i("Processing lurk request from app link");
            startLurkingAndNavigate$default(this, lurkRequest.getGuildId(), lurkRequest.getChannelId(), null, 4, null);
        }
        this.lurkRequest = null;
    }

    @StoreThread
    public final void handleGuildAdd$app_productionGoogleRelease(Guild guild) {
        LurkContext lurkContext;
        C12238m.checkNotNullParameter(guild, "guild");
        if (this.lurkedGuilds.keySet().contains(Long.valueOf(guild.getId()))) {
            if (guild.getJoinedAt() == null && (lurkContext = this.lurkedGuilds.get(Long.valueOf(guild.getId()))) != null && lurkContext.getShouldNavigate()) {
                this.stream.getGuildSelected().handleGuildSelected(guild.getId());
            } else if (guild.getJoinedAt() != null) {
                stopLurkingInternal(guild.getId());
            }
        }
    }

    @StoreThread
    public final void handleGuildRemove$app_productionGoogleRelease(Guild guild) {
        C12238m.checkNotNullParameter(guild, "guild");
        stopLurkingInternal(guild.getId());
    }

    @StoreThread
    public final void handleGuildSelected$app_productionGoogleRelease(long guildId) {
        LurkRequest lurkRequest = this.lurkRequest;
        if ((lurkRequest == null || guildId != lurkRequest.getGuildId()) && this.sessionId != null) {
            this.lurkRequest = null;
        }
        removeOldLurkingGuilds(guildId);
    }

    @StoreThread
    public final void handleVoiceChannelSelected$app_productionGoogleRelease(long channelId) {
        Channel channel = this.stream.getChannels().getChannel(channelId);
        Set<Long> setKeySet = this.lurkedGuilds.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (channel == null || ((Number) obj).longValue() != channel.getGuildId()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            if (jLongValue != this.stream.getGuildSelected().getSelectedGuildIdInternal$app_productionGoogleRelease()) {
                postLeaveGuild$default(this, jLongValue, null, null, 6, null);
            }
        }
    }

    @StoreThread
    public final boolean isLurking$app_productionGoogleRelease(com.discord.models.guild.Guild guild) {
        C12238m.checkNotNullParameter(guild, "guild");
        return INSTANCE.isLurking(guild.getJoinedAt() != null, guild.getId(), this.lurkedGuilds.keySet());
    }

    public final Observable<Boolean> isLurkingObs(long guildId) {
        Observable<Boolean> observableM11112r = Observable.m11076j(getLurkingGuildIds(), this.stream.getGuilds().observeGuild(guildId), new Func2<Set<? extends Long>, com.discord.models.guild.Guild, Boolean>() { // from class: com.discord.stores.StoreLurking.isLurkingObs.1
            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set, com.discord.models.guild.Guild guild) {
                return call2((Set<Long>) set, guild);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Set<Long> set, com.discord.models.guild.Guild guild) {
                boolean zIsLurking = false;
                if (guild != null) {
                    Companion companion = StoreLurking.INSTANCE;
                    zIsLurking = guild.getJoinedAt() != null;
                    long id2 = guild.getId();
                    C12238m.checkNotNullExpressionValue(set, "lurkingGuildIds");
                    zIsLurking = companion.isLurking(zIsLurking, id2, set);
                }
                return Boolean.valueOf(zIsLurking);
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "Observable\n          .co…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final void postJoinGuildAsMember(long guildId, Context context) {
        C12238m.checkNotNullParameter(context, "context");
        GuildJoinHelperKt.joinGuild(context, guildId, false, (944 & 8) != 0 ? null : this.sessionId, (944 & 16) != 0 ? null : null, (944 & 32) != 0 ? null : null, StoreLurking.class, (944 & 128) != 0 ? null : null, (944 & 256) != 0 ? null : null, (944 & 512) != 0 ? null : null, C61471.INSTANCE);
    }

    public final void removeOldLurkingGuilds(long currentlyLurkedGuildId) {
        Channel channel = this.stream.getChannels().getChannel(this.stream.getVoiceChannelSelected().getSelectedVoiceChannelId());
        Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
        Set<Long> setKeySet = this.lurkedGuilds.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            long jLongValue = ((Number) obj).longValue();
            if (jLongValue != currentlyLurkedGuildId && (lValueOf == null || jLongValue != lValueOf.longValue())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.discord.models.guild.Guild guild = this.guildsStore.getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(((Number) it.next()).longValue()));
            if (guild != null) {
                arrayList2.add(guild);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            postLeaveGuild$default(this, ((com.discord.models.guild.Guild) it2.next()).getId(), null, null, 6, null);
        }
    }

    public final void startLurking(long guildId, Long channelId, boolean navigateToGuild, Function3<? super com.discord.models.guild.Guild, ? super Long, ? super Boolean, Unit> onGuildLurked, Function0<Unit> onErrorLurking) {
        C12238m.checkNotNullParameter(onGuildLurked, "onGuildLurked");
        C12238m.checkNotNullParameter(onErrorLurking, "onErrorLurking");
        this.dispatcher.schedule(new C61543(guildId, channelId, navigateToGuild, onGuildLurked, onErrorLurking));
    }

    public final void startLurkingAndNavigate(long guildId, Long channelId, Context context) {
        this.dispatcher.schedule(new C61551(guildId, channelId, context));
    }

    public final void stopLurking(long guildId, Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        C12238m.checkNotNullParameter(onSuccess, "onSuccess");
        C12238m.checkNotNullParameter(onFailure, "onFailure");
        postLeaveGuild(guildId, onSuccess, onFailure);
    }

    @StoreThread
    public final boolean isLurking$app_productionGoogleRelease(Guild guild) {
        C12238m.checkNotNullParameter(guild, "guild");
        return INSTANCE.isLurking(guild.getJoinedAt() != null, guild.getId(), this.lurkedGuilds.keySet());
    }

    @StoreThread
    public final boolean isLurking$app_productionGoogleRelease(long guildId) {
        return INSTANCE.isLurking(false, guildId, this.lurkedGuilds.keySet());
    }
}
