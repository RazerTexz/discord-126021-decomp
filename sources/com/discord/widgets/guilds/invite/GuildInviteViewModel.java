package com.discord.widgets.guilds.invite;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.invite.GuildInviteViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: GuildInviteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteViewModel extends AppViewModel<ViewState> implements AppComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreInstantInvites instantInvitesStore;
    private final StoreInviteSettings.InviteCode inviteCode;
    private boolean inviteResolved;
    private final Observable<StoreState> storeStateObservable;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildInviteViewModel.kt */
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
            GuildInviteViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GuildInviteViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreInstantInvites instantInvitesStore, StoreInviteSettings.InviteCode inviteCode) {
            if (inviteCode == null) {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(StoreState.Invalid.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(StoreState.Invalid)");
                return scalarSynchronousObservable;
            }
            Observable observableG = instantInvitesStore.observeInvite(ModelInvite.getInviteStoreKey(inviteCode.getInviteCode(), inviteCode.getEventId())).G(new Func1<StoreInstantInvites.InviteState, StoreState>() { // from class: com.discord.widgets.guilds.invite.GuildInviteViewModel$Companion$observeStoreState$1
                @Override // j0.k.Func1
                public final GuildInviteViewModel.StoreState call(StoreInstantInvites.InviteState inviteState) {
                    if (inviteState instanceof StoreInstantInvites.InviteState.Loading) {
                        return GuildInviteViewModel.StoreState.Loading.INSTANCE;
                    }
                    return inviteState instanceof StoreInstantInvites.InviteState.Resolved ? new GuildInviteViewModel.StoreState.Loaded(((StoreInstantInvites.InviteState.Resolved) inviteState).getInvite()) : GuildInviteViewModel.StoreState.Invalid.INSTANCE;
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableG, "instantInvitesStore\n    …            }\n          }");
            return observableG;
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
                Intrinsics3.checkNotNullParameter(modelInvite, "invite");
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
                Intrinsics3.checkNotNullParameter(invite, "invite");
                return new Loaded(invite);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.invite, ((Loaded) other).invite);
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
                StringBuilder sbU = outline.U("Loaded(invite=");
                sbU.append(this.invite);
                sbU.append(")");
                return sbU.toString();
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
                Intrinsics3.checkNotNullParameter(modelInvite, "invite");
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
                Intrinsics3.checkNotNullParameter(invite, "invite");
                return new Loaded(invite);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.invite, ((Loaded) other).invite);
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
                StringBuilder sbU = outline.U("Loaded(invite=");
                sbU.append(this.invite);
                sbU.append(")");
                return sbU.toString();
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

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.GuildInviteViewModel$fetchInviteIfNotLoaded$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildInviteViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppLog appLog = AppLog.g;
            StringBuilder sbU = outline.U("Failed to resolve invite[");
            sbU.append(GuildInviteViewModel.this.getInviteCode().getInviteCode());
            sbU.append("] from ");
            sbU.append(GuildInviteViewModel.this.getInviteCode().getSource());
            Logger.d$default(appLog, sbU.toString(), null, 2, null);
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
        StoreStream.INSTANCE.getInstantInvites().fetchInviteIfNotLoaded(this.inviteCode.getInviteCode(), this.inviteCode.getEventId(), this.inviteCode.getSource(), Boolean.valueOf(this.inviteResolved), new AnonymousClass1());
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
        Intrinsics3.checkNotNullParameter(storeInstantInvites, "instantInvitesStore");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.inviteCode = inviteCode;
        this.instantInvitesStore = storeInstantInvites;
        this.storeStateObservable = observable;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) GuildInviteViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
