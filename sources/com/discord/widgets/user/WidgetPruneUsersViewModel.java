package com.discord.widgets.user;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guild.PruneCountResponse;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsersViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PruneDays DEFAULT_DAYS = PruneDays.Thirty;
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final String guildName;
    private Subscription pruneCountRequest;
    private final RestAPI restAPI;
    private final StoreGuilds storeGuilds;
    private final StoreUser storeUsers;
    private PruneDays whichPruneDays;

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "canKick");
            if (bool.booleanValue()) {
                WidgetPruneUsersViewModel.this.getUpdatedPruneCount();
            } else {
                WidgetPruneUsersViewModel.this.updateViewState(new ViewState.LoadFailed(true));
            }
        }
    }

    /* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreData> observeStoreState(long guildId, ObservationDeck observationDeck, StorePermissions storePermissions, StoreGuilds storeGuilds, StoreUser storeUsers) {
            Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
            Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
            Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
            Intrinsics3.checkNotNullParameter(storeUsers, "storeUsers");
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storePermissions, storeGuilds, storeUsers}, false, null, null, new WidgetPruneUsersViewModel2(storePermissions, guildId, storeGuilds, storeUsers), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
        public static final class Dismiss extends Event {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
        public static final /* data */ class RestClientFailed extends Event {
            private final Throwable throwable;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RestClientFailed(Throwable th) {
                super(null);
                Intrinsics3.checkNotNullParameter(th, "throwable");
                this.throwable = th;
            }

            public static /* synthetic */ RestClientFailed copy$default(RestClientFailed restClientFailed, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    th = restClientFailed.throwable;
                }
                return restClientFailed.copy(th);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Throwable getThrowable() {
                return this.throwable;
            }

            public final RestClientFailed copy(Throwable throwable) {
                Intrinsics3.checkNotNullParameter(throwable, "throwable");
                return new RestClientFailed(throwable);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof RestClientFailed) && Intrinsics3.areEqual(this.throwable, ((RestClientFailed) other).throwable);
                }
                return true;
            }

            public final Throwable getThrowable() {
                return this.throwable;
            }

            public int hashCode() {
                Throwable th = this.throwable;
                if (th != null) {
                    return th.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("RestClientFailed(throwable=");
                sbU.append(this.throwable);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
    public enum PruneDays {
        Seven(7),
        Thirty(30);

        private final int count;

        PruneDays(int i) {
            this.count = i;
        }

        public final int getCount() {
            return this.count;
        }
    }

    /* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
    public static final /* data */ class StoreData {
        private final Guild guild;
        private final Long permission;
        private final MeUser user;

        public StoreData(Long l, Guild guild, MeUser meUser) {
            this.permission = l;
            this.guild = guild;
            this.user = meUser;
        }

        public static /* synthetic */ StoreData copy$default(StoreData storeData, Long l, Guild guild, MeUser meUser, int i, Object obj) {
            if ((i & 1) != 0) {
                l = storeData.permission;
            }
            if ((i & 2) != 0) {
                guild = storeData.guild;
            }
            if ((i & 4) != 0) {
                meUser = storeData.user;
            }
            return storeData.copy(l, guild, meUser);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Long getPermission() {
            return this.permission;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final MeUser getUser() {
            return this.user;
        }

        public final StoreData copy(Long permission, Guild guild, MeUser user) {
            return new StoreData(permission, guild, user);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreData)) {
                return false;
            }
            StoreData storeData = (StoreData) other;
            return Intrinsics3.areEqual(this.permission, storeData.permission) && Intrinsics3.areEqual(this.guild, storeData.guild) && Intrinsics3.areEqual(this.user, storeData.user);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Long getPermission() {
            return this.permission;
        }

        public final MeUser getUser() {
            return this.user;
        }

        public int hashCode() {
            Long l = this.permission;
            int iHashCode = (l != null ? l.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            MeUser meUser = this.user;
            return iHashCode2 + (meUser != null ? meUser.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreData(permission=");
            sbU.append(this.permission);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", user=");
            sbU.append(this.user);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
        public static final /* data */ class LoadFailed extends ViewState {
            private final boolean dismiss;

            public LoadFailed(boolean z2) {
                super(null);
                this.dismiss = z2;
            }

            public static /* synthetic */ LoadFailed copy$default(LoadFailed loadFailed, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = loadFailed.dismiss;
                }
                return loadFailed.copy(z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getDismiss() {
                return this.dismiss;
            }

            public final LoadFailed copy(boolean dismiss) {
                return new LoadFailed(dismiss);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LoadFailed) && this.dismiss == ((LoadFailed) other).dismiss;
                }
                return true;
            }

            public final boolean getDismiss() {
                return this.dismiss;
            }

            public int hashCode() {
                boolean z2 = this.dismiss;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public String toString() {
                return outline.O(outline.U("LoadFailed(dismiss="), this.dismiss, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final int pruneCount;
            private final PruneDays pruneDays;
            private final boolean pruneInProgress;

            public /* synthetic */ Loaded(PruneDays pruneDays, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(pruneDays, i, (i2 & 4) != 0 ? false : z2);
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            private final boolean getPruneInProgress() {
                return this.pruneInProgress;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, PruneDays pruneDays, int i, boolean z2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    pruneDays = loaded.pruneDays;
                }
                if ((i2 & 2) != 0) {
                    i = loaded.pruneCount;
                }
                if ((i2 & 4) != 0) {
                    z2 = loaded.pruneInProgress;
                }
                return loaded.copy(pruneDays, i, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PruneDays getPruneDays() {
                return this.pruneDays;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getPruneCount() {
                return this.pruneCount;
            }

            public final Loaded copy(PruneDays pruneDays, int pruneCount, boolean pruneInProgress) {
                Intrinsics3.checkNotNullParameter(pruneDays, "pruneDays");
                return new Loaded(pruneDays, pruneCount, pruneInProgress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.pruneDays, loaded.pruneDays) && this.pruneCount == loaded.pruneCount && this.pruneInProgress == loaded.pruneInProgress;
            }

            public final boolean getPruneButtonEnabled() {
                return this.pruneCount > 0 && !this.pruneInProgress;
            }

            public final int getPruneCount() {
                return this.pruneCount;
            }

            public final PruneDays getPruneDays() {
                return this.pruneDays;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3 */
            /* JADX WARN: Type inference failed for: r1v4 */
            public int hashCode() {
                PruneDays pruneDays = this.pruneDays;
                int iHashCode = (((pruneDays != null ? pruneDays.hashCode() : 0) * 31) + this.pruneCount) * 31;
                boolean z2 = this.pruneInProgress;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(pruneDays=");
                sbU.append(this.pruneDays);
                sbU.append(", pruneCount=");
                sbU.append(this.pruneCount);
                sbU.append(", pruneInProgress=");
                return outline.O(sbU, this.pruneInProgress, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(PruneDays pruneDays, int i, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(pruneDays, "pruneDays");
                this.pruneDays = pruneDays;
                this.pruneCount = i;
                this.pruneInProgress = z2;
            }
        }

        /* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
        public static final /* data */ class Loading extends ViewState {
            private final String guildName;
            private final PruneDays whichPruneDays;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loading(PruneDays pruneDays, String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(pruneDays, "whichPruneDays");
                Intrinsics3.checkNotNullParameter(str, "guildName");
                this.whichPruneDays = pruneDays;
                this.guildName = str;
            }

            public static /* synthetic */ Loading copy$default(Loading loading, PruneDays pruneDays, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    pruneDays = loading.whichPruneDays;
                }
                if ((i & 2) != 0) {
                    str = loading.guildName;
                }
                return loading.copy(pruneDays, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PruneDays getWhichPruneDays() {
                return this.whichPruneDays;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getGuildName() {
                return this.guildName;
            }

            public final Loading copy(PruneDays whichPruneDays, String guildName) {
                Intrinsics3.checkNotNullParameter(whichPruneDays, "whichPruneDays");
                Intrinsics3.checkNotNullParameter(guildName, "guildName");
                return new Loading(whichPruneDays, guildName);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loading)) {
                    return false;
                }
                Loading loading = (Loading) other;
                return Intrinsics3.areEqual(this.whichPruneDays, loading.whichPruneDays) && Intrinsics3.areEqual(this.guildName, loading.guildName);
            }

            public final String getGuildName() {
                return this.guildName;
            }

            public final PruneDays getWhichPruneDays() {
                return this.whichPruneDays;
            }

            public int hashCode() {
                PruneDays pruneDays = this.whichPruneDays;
                int iHashCode = (pruneDays != null ? pruneDays.hashCode() : 0) * 31;
                String str = this.guildName;
                return iHashCode + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loading(whichPruneDays=");
                sbU.append(this.whichPruneDays);
                sbU.append(", guildName=");
                return outline.J(sbU, this.guildName, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$getUpdatedPruneCount$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "request");
            Subscription subscription2 = WidgetPruneUsersViewModel.this.pruneCountRequest;
            if (subscription2 != null) {
                subscription2.unsubscribe();
            }
            WidgetPruneUsersViewModel.this.pruneCountRequest = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$getUpdatedPruneCount$6, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
    public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<ViewState, Unit> {
        public AnonymousClass6(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
            super(1, widgetPruneUsersViewModel, WidgetPruneUsersViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetPruneUsersViewModel) this.receiver).updateViewState(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$pruneClicked$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
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
        public final void invoke2(Void r2) {
            WidgetPruneUsersViewModel.this.eventSubject.k.onNext((T) Event.Dismiss.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$pruneClicked$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetPruneUsersViewModel.this.pruneInProgress(false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$pruneClicked$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
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
            PublishSubject publishSubject = WidgetPruneUsersViewModel.this.eventSubject;
            Throwable throwable = error.getThrowable();
            Intrinsics3.checkNotNullExpressionValue(throwable, "it.throwable");
            publishSubject.k.onNext((T) new Event.RestClientFailed(throwable));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetPruneUsersViewModel(long j, StoreGuilds storeGuilds, StoreUser storeUser, String str, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str2;
        Observable observableObserveStoreState;
        StoreGuilds guilds = (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreUser users = (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        if ((i & 8) != 0) {
            Guild guild = guilds.getGuilds().get(Long.valueOf(j));
            String name = guild != null ? guild.getName() : null;
            str2 = name == null ? "" : name;
        } else {
            str2 = str;
        }
        RestAPI api = (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i & 32) != 0) {
            Companion companion = INSTANCE;
            ObservationDeck observationDeck = ObservationDeck4.get();
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableObserveStoreState = companion.observeStoreState(j, observationDeck, companion2.getPermissions(), companion2.getGuilds(), users);
        } else {
            observableObserveStoreState = observable;
        }
        this(j, guilds, users, str2, api, observableObserveStoreState);
    }

    private final ViewState.Loading getLoadingState() {
        return new ViewState.Loading(this.whichPruneDays, this.guildName);
    }

    private final void getUpdatedPruneCount() {
        updateViewState(getLoadingState());
        Observable observableM = ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getPruneCount(this.guildId, this.whichPruneDays.getCount()), false, 1, null).G(new Func1<PruneCountResponse, Integer>() { // from class: com.discord.widgets.user.WidgetPruneUsersViewModel.getUpdatedPruneCount.1
            @Override // j0.k.Func1
            public final Integer call(PruneCountResponse pruneCountResponse) {
                return Integer.valueOf(pruneCountResponse.getPruned());
            }
        }).G(new Func1<Integer, ViewState>() { // from class: com.discord.widgets.user.WidgetPruneUsersViewModel.getUpdatedPruneCount.2
            @Override // j0.k.Func1
            public final ViewState call(Integer num) {
                PruneDays pruneDays = WidgetPruneUsersViewModel.this.whichPruneDays;
                Intrinsics3.checkNotNullExpressionValue(num, "count");
                return new ViewState.Loaded(pruneDays, num.intValue(), false, 4, null);
            }
        }).t(new Action1<Throwable>() { // from class: com.discord.widgets.user.WidgetPruneUsersViewModel.getUpdatedPruneCount.3
            @Override // rx.functions.Action1
            public final void call(Throwable th) {
                PublishSubject publishSubject = WidgetPruneUsersViewModel.this.eventSubject;
                Intrinsics3.checkNotNullExpressionValue(th, "it");
                publishSubject.k.onNext(new Event.RestClientFailed(th));
            }
        }).M(new Func1<Throwable, ViewState>() { // from class: com.discord.widgets.user.WidgetPruneUsersViewModel.getUpdatedPruneCount.4
            @Override // j0.k.Func1
            public final ViewState call(Throwable th) {
                return new ViewState.LoadFailed(false);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableM, "restAPI.getPruneCount(gu…Failed(dismiss = false) }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM, this, null, 2, null), (Class<?>) WidgetPruneUsersViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass5()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass6(this));
    }

    private final void pruneInProgress(boolean inProgress) {
        ViewState.Loaded loadedCopy$default;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (loadedCopy$default = ViewState.Loaded.copy$default(loaded, null, 0, inProgress, 3, null)) == null) {
            return;
        }
        updateViewState(loadedCopy$default);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void pruneClicked() {
        pruneInProgress(true);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.pruneMembers(this.guildId, new RestAPIParams.PruneGuild(Integer.valueOf(this.whichPruneDays.getCount()), Boolean.FALSE)), false, 1, null), this, null, 2, null), (Class<?>) WidgetPruneUsersViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : new AnonymousClass2()), new AnonymousClass1());
    }

    public final void pruneDaysSelected(PruneDays days) {
        Intrinsics3.checkNotNullParameter(days, "days");
        this.whichPruneDays = days;
        getUpdatedPruneCount();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPruneUsersViewModel(long j, StoreGuilds storeGuilds, StoreUser storeUser, String str, RestAPI restAPI, Observable<StoreData> observable) {
        super(new ViewState.Loading(DEFAULT_DAYS, str));
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUsers");
        Intrinsics3.checkNotNullParameter(str, "guildName");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeDataObservable");
        this.guildId = j;
        this.storeGuilds = storeGuilds;
        this.storeUsers = storeUser;
        this.guildName = str;
        this.restAPI = restAPI;
        this.eventSubject = PublishSubject.k0();
        ViewState viewState = getViewState();
        Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.user.WidgetPruneUsersViewModel.ViewState.Loading");
        this.whichPruneDays = ((ViewState.Loading) viewState).getWhichPruneDays();
        Observable observableR = observable.G(new Func1<StoreData, Boolean>() { // from class: com.discord.widgets.user.WidgetPruneUsersViewModel.1
            @Override // j0.k.Func1
            public final Boolean call(StoreData storeData) {
                return Boolean.valueOf((storeData.getPermission() == null || storeData.getUser() == null || storeData.getGuild() == null || !PermissionUtils.canAndIsElevated(2L, storeData.getPermission(), storeData.getUser().getMfaEnabled(), storeData.getGuild().getMfaLevel())) ? false : true);
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeDataObservable\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), (Class<?>) WidgetPruneUsersViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
