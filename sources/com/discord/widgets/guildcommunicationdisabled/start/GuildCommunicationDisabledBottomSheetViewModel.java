package com.discord.widgets.guildcommunicationdisabled.start;

import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: GuildCommunicationDisabledBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildCommunicationDisabledBottomSheetViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.discord.widgets.guildcommunicationdisabled.start.GuildCommunicationDisabledBottomSheetViewModel$2 */
    /* JADX INFO: compiled from: GuildCommunicationDisabledBottomSheetViewModel.kt */
    public static final /* synthetic */ class C85562 extends C12236k implements Function1<StoreState, Unit> {
        public C85562(GuildCommunicationDisabledBottomSheetViewModel guildCommunicationDisabledBottomSheetViewModel) {
            super(1, guildCommunicationDisabledBottomSheetViewModel, GuildCommunicationDisabledBottomSheetViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guildcommunicationdisabled/start/GuildCommunicationDisabledBottomSheetViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "p1");
            ((GuildCommunicationDisabledBottomSheetViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GuildCommunicationDisabledBottomSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores(long userId, long guildId, ObservationDeck observationDeck, StoreGuilds guildStore) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{guildStore}, false, null, null, new C8557xcc697ce(guildStore, guildId, userId), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildCommunicationDisabledBottomSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final GuildMember guildMember;

        public StoreState(Guild guild, GuildMember guildMember) {
            this.guild = guild;
            this.guildMember = guildMember;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, GuildMember guildMember, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.guild;
            }
            if ((i & 2) != 0) {
                guildMember = storeState.guildMember;
            }
            return storeState.copy(guild, guildMember);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final StoreState copy(Guild guild, GuildMember guildMember) {
            return new StoreState(guild, guildMember);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.guild, storeState.guild) && C12238m.areEqual(this.guildMember, storeState.guildMember);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            GuildMember guildMember = this.guildMember;
            return iHashCode + (guildMember != null ? guildMember.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", guildMember=");
            sbM833U.append(this.guildMember);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: GuildCommunicationDisabledBottomSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: GuildCommunicationDisabledBottomSheetViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildCommunicationDisabledBottomSheetViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final String guildName;
            private final long timeoutTimeLeftMs;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(long j, String str) {
                super(null);
                C12238m.checkNotNullParameter(str, "guildName");
                this.timeoutTimeLeftMs = j;
                this.guildName = str;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, long j, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = valid.timeoutTimeLeftMs;
                }
                if ((i & 2) != 0) {
                    str = valid.guildName;
                }
                return valid.copy(j, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getTimeoutTimeLeftMs() {
                return this.timeoutTimeLeftMs;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getGuildName() {
                return this.guildName;
            }

            public final Valid copy(long timeoutTimeLeftMs, String guildName) {
                C12238m.checkNotNullParameter(guildName, "guildName");
                return new Valid(timeoutTimeLeftMs, guildName);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return this.timeoutTimeLeftMs == valid.timeoutTimeLeftMs && C12238m.areEqual(this.guildName, valid.guildName);
            }

            public final String getGuildName() {
                return this.guildName;
            }

            public final long getTimeoutTimeLeftMs() {
                return this.timeoutTimeLeftMs;
            }

            public int hashCode() {
                int iM3a = C0002b.m3a(this.timeoutTimeLeftMs) * 31;
                String str = this.guildName;
                return iM3a + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Valid(timeoutTimeLeftMs=");
                sbM833U.append(this.timeoutTimeLeftMs);
                sbM833U.append(", guildName=");
                return C1643a.m822J(sbM833U, this.guildName, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildCommunicationDisabledBottomSheetViewModel(long j, long j2, ObservationDeck observationDeck, StoreGuilds storeGuilds, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        ObservationDeck observationDeck2 = (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck;
        StoreGuilds guilds = (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        this(j, j2, observationDeck2, guilds, (i & 16) != 0 ? INSTANCE.observeStores(j, j2, observationDeck2, guilds) : observable);
    }

    private final void handleStoreState(StoreState storeState) {
        Guild guild = storeState.getGuild();
        GuildMember guildMember = storeState.getGuildMember();
        if (guild == null || guildMember == null) {
            updateViewState(ViewState.Invalid.INSTANCE);
        } else {
            UtcDateTime communicationDisabledUntil = guildMember.getCommunicationDisabledUntil();
            updateViewState(new ViewState.Valid(communicationDisabledUntil != null ? communicationDisabledUntil.getDateTimeMillis() - ClockFactory.get().currentTimeMillis() : 0L, guild.getName()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildCommunicationDisabledBottomSheetViewModel(long j, long j2, ObservationDeck observationDeck, StoreGuilds storeGuilds, Observable<StoreState> observable) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(storeGuilds, "guildStore");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        Observable observableM11076j = Observable.m11076j(Observable.m11062F(0L, 1L, TimeUnit.SECONDS, C12781a.m10873a()), observable, new Func2<Long, StoreState, StoreState>() { // from class: com.discord.widgets.guildcommunicationdisabled.start.GuildCommunicationDisabledBottomSheetViewModel.1
            @Override // p658rx.functions.Func2
            public final StoreState call(Long l, StoreState storeState) {
                return storeState;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…->\n      storeState\n    }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11076j), this, null, 2, null), (Class<?>) GuildCommunicationDisabledBottomSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C85562(this));
    }
}
