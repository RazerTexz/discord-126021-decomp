package com.discord.widgets.guilds.invite;

import androidx.annotation.MainThread;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: GuildInviteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteViewModel extends AbstractC0859d0<ViewState> implements AppComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreInstantInvites instantInvitesStore;
    private final StoreInviteSettings.InviteCode inviteCode;
    private boolean inviteResolved;
    private final Observable<StoreState> storeStateObservable;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteViewModel$1 */
    /* JADX INFO: compiled from: GuildInviteViewModel.kt */
    public static final class C86261 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C86261() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            GuildInviteViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GuildInviteViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreInstantInvites instantInvitesStore, StoreInviteSettings.InviteCode inviteCode) {
            if (inviteCode == null) {
                C12721k c12721k = new C12721k(StoreState.Invalid.INSTANCE);
                C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(StoreState.Invalid)");
                return c12721k;
            }
            Observable observableM11083G = instantInvitesStore.observeInvite(ModelInvite.getInviteStoreKey(inviteCode.getInviteCode(), inviteCode.getEventId())).m11083G(new InterfaceC12589b<StoreInstantInvites.InviteState, StoreState>() { // from class: com.discord.widgets.guilds.invite.GuildInviteViewModel$Companion$observeStoreState$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final GuildInviteViewModel.StoreState call(StoreInstantInvites.InviteState inviteState) {
                    if (inviteState instanceof StoreInstantInvites.InviteState.Loading) {
                        return GuildInviteViewModel.StoreState.Loading.INSTANCE;
                    }
                    return inviteState instanceof StoreInstantInvites.InviteState.Resolved ? new GuildInviteViewModel.StoreState.Loaded(((StoreInstantInvites.InviteState.Resolved) inviteState).getInvite()) : GuildInviteViewModel.StoreState.Invalid.INSTANCE;
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11083G, "instantInvitesStore\n    …            }\n          }");
            return observableM11083G;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildInviteViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: GuildInviteViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildInviteViewModel.kt */
        public static final /* data */ class Loaded extends StoreState {
            private final ModelInvite invite;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(ModelInvite modelInvite) {
                super(null);
                C12238m.checkNotNullParameter(modelInvite, "invite");
                this.invite = modelInvite;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, ModelInvite modelInvite, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvite = loaded.invite;
                }
                return loaded.copy(modelInvite);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelInvite getInvite() {
                return this.invite;
            }

            public final Loaded copy(ModelInvite invite) {
                C12238m.checkNotNullParameter(invite, "invite");
                return new Loaded(invite);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.invite, ((Loaded) other).invite);
                }
                return true;
            }

            public final ModelInvite getInvite() {
                return this.invite;
            }

            public int hashCode() {
                ModelInvite modelInvite = this.invite;
                if (modelInvite != null) {
                    return modelInvite.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(invite=");
                sbM833U.append(this.invite);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: GuildInviteViewModel.kt */
        public static final class Loading extends StoreState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildInviteViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: GuildInviteViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildInviteViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final ModelInvite invite;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(ModelInvite modelInvite) {
                super(null);
                C12238m.checkNotNullParameter(modelInvite, "invite");
                this.invite = modelInvite;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, ModelInvite modelInvite, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvite = loaded.invite;
                }
                return loaded.copy(modelInvite);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelInvite getInvite() {
                return this.invite;
            }

            public final Loaded copy(ModelInvite invite) {
                C12238m.checkNotNullParameter(invite, "invite");
                return new Loaded(invite);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.invite, ((Loaded) other).invite);
                }
                return true;
            }

            public final ModelInvite getInvite() {
                return this.invite;
            }

            public int hashCode() {
                ModelInvite modelInvite = this.invite;
                if (modelInvite != null) {
                    return modelInvite.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(invite=");
                sbM833U.append(this.invite);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: GuildInviteViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildInviteViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteViewModel$fetchInviteIfNotLoaded$1 */
    /* JADX INFO: compiled from: GuildInviteViewModel.kt */
    public static final class C86271 extends AbstractC12240o implements Function0<Unit> {
        public C86271() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppLog appLog = AppLog.f14950g;
            StringBuilder sbM833U = C1643a.m833U("Failed to resolve invite[");
            sbM833U.append(GuildInviteViewModel.this.getInviteCode().getInviteCode());
            sbM833U.append("] from ");
            sbM833U.append(GuildInviteViewModel.this.getInviteCode().getSource());
            Logger.d$default(appLog, sbM833U.toString(), null, 2, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildInviteViewModel(StoreInviteSettings.InviteCode inviteCode, StoreInstantInvites storeInstantInvites, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storeInstantInvites = (i & 2) != 0 ? StoreStream.INSTANCE.getInstantInvites() : storeInstantInvites;
        this(inviteCode, storeInstantInvites, (i & 4) != 0 ? INSTANCE.observeStoreState(storeInstantInvites, inviteCode) : observable);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (storeState instanceof StoreState.Loading) {
            updateViewState(ViewState.Loading.INSTANCE);
        } else if (storeState instanceof StoreState.Invalid) {
            updateViewState(ViewState.Invalid.INSTANCE);
        } else if (storeState instanceof StoreState.Loaded) {
            updateViewState(new ViewState.Loaded(((StoreState.Loaded) storeState).getInvite()));
        }
    }

    public final void fetchInviteIfNotLoaded() {
        if (this.inviteCode == null) {
            return;
        }
        StoreStream.INSTANCE.getInstantInvites().fetchInviteIfNotLoaded(this.inviteCode.getInviteCode(), this.inviteCode.getEventId(), this.inviteCode.getSource(), Boolean.valueOf(this.inviteResolved), new C86271());
    }

    public final StoreInviteSettings.InviteCode getInviteCode() {
        return this.inviteCode;
    }

    public final boolean getInviteResolved() {
        return this.inviteResolved;
    }

    public final Observable<StoreState> getStoreStateObservable() {
        return this.storeStateObservable;
    }

    public final void setInviteResolved(boolean z2) {
        this.inviteResolved = z2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteViewModel(StoreInviteSettings.InviteCode inviteCode, StoreInstantInvites storeInstantInvites, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        C12238m.checkNotNullParameter(storeInstantInvites, "instantInvitesStore");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.inviteCode = inviteCode;
        this.instantInvitesStore = storeInstantInvites;
        this.storeStateObservable = observable;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) GuildInviteViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C86261());
    }
}
