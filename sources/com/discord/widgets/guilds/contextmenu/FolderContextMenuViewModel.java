package com.discord.widgets.guilds.contextmenu;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.a.OnSubscribeFromIterable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FolderContextMenuViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long folderId;
    private List<Long> guildIds;
    private final RestAPI restAPI;
    private final Observable<StoreState> storeStateObservable;
    private Set<Long> unreadGuildIds;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(FolderContextMenuViewModel folderContextMenuViewModel) {
            super(1, folderContextMenuViewModel, FolderContextMenuViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ((FolderContextMenuViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(final long folderId, StoreUserSettings userSettingsStore, StoreReadStates readStateStore) {
            Observable<StoreState> observableJ = Observable.j(userSettingsStore.observeGuildFolders(), readStateStore.getUnreadGuildIds(), new Func2<List<? extends ModelGuildFolder>, Set<? extends Long>, StoreState>() { // from class: com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel$Companion$observeStoreState$1
                @Override // rx.functions.Func2
                public /* bridge */ /* synthetic */ FolderContextMenuViewModel.StoreState call(List<? extends ModelGuildFolder> list, Set<? extends Long> set) {
                    return call2((List<ModelGuildFolder>) list, (Set<Long>) set);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final FolderContextMenuViewModel.StoreState call2(List<ModelGuildFolder> list, Set<Long> set) {
                    Object next;
                    Long id2;
                    Intrinsics3.checkNotNullExpressionValue(list, "guildFolders");
                    Iterator<T> it = list.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        id2 = ((ModelGuildFolder) next).getId();
                    } while (!(id2 != null && id2.longValue() == folderId));
                    ModelGuildFolder modelGuildFolder = (ModelGuildFolder) next;
                    if (modelGuildFolder == null) {
                        return FolderContextMenuViewModel.StoreState.Invalid.INSTANCE;
                    }
                    Intrinsics3.checkNotNullExpressionValue(set, "unreadGuildIds");
                    return new FolderContextMenuViewModel.StoreState.Valid(modelGuildFolder, set);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…      )\n        }\n      }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
        public static final class Dismiss extends Event {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final ModelGuildFolder folder;
            private final Set<Long> unreadGuildIds;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(ModelGuildFolder modelGuildFolder, Set<Long> set) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelGuildFolder, "folder");
                Intrinsics3.checkNotNullParameter(set, "unreadGuildIds");
                this.folder = modelGuildFolder;
                this.unreadGuildIds = set;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Valid copy$default(Valid valid, ModelGuildFolder modelGuildFolder, Set set, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildFolder = valid.folder;
                }
                if ((i & 2) != 0) {
                    set = valid.unreadGuildIds;
                }
                return valid.copy(modelGuildFolder, set);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelGuildFolder getFolder() {
                return this.folder;
            }

            public final Set<Long> component2() {
                return this.unreadGuildIds;
            }

            public final Valid copy(ModelGuildFolder folder, Set<Long> unreadGuildIds) {
                Intrinsics3.checkNotNullParameter(folder, "folder");
                Intrinsics3.checkNotNullParameter(unreadGuildIds, "unreadGuildIds");
                return new Valid(folder, unreadGuildIds);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.folder, valid.folder) && Intrinsics3.areEqual(this.unreadGuildIds, valid.unreadGuildIds);
            }

            public final ModelGuildFolder getFolder() {
                return this.folder;
            }

            public final Set<Long> getUnreadGuildIds() {
                return this.unreadGuildIds;
            }

            public int hashCode() {
                ModelGuildFolder modelGuildFolder = this.folder;
                int iHashCode = (modelGuildFolder != null ? modelGuildFolder.hashCode() : 0) * 31;
                Set<Long> set = this.unreadGuildIds;
                return iHashCode + (set != null ? set.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(folder=");
                sbU.append(this.folder);
                sbU.append(", unreadGuildIds=");
                return outline.N(sbU, this.unreadGuildIds, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final ModelGuildFolder folder;
            private final boolean showMarkAsRead;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(ModelGuildFolder modelGuildFolder, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelGuildFolder, "folder");
                this.folder = modelGuildFolder;
                this.showMarkAsRead = z2;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, ModelGuildFolder modelGuildFolder, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildFolder = valid.folder;
                }
                if ((i & 2) != 0) {
                    z2 = valid.showMarkAsRead;
                }
                return valid.copy(modelGuildFolder, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelGuildFolder getFolder() {
                return this.folder;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getShowMarkAsRead() {
                return this.showMarkAsRead;
            }

            public final Valid copy(ModelGuildFolder folder, boolean showMarkAsRead) {
                Intrinsics3.checkNotNullParameter(folder, "folder");
                return new Valid(folder, showMarkAsRead);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.folder, valid.folder) && this.showMarkAsRead == valid.showMarkAsRead;
            }

            public final ModelGuildFolder getFolder() {
                return this.folder;
            }

            public final boolean getShowMarkAsRead() {
                return this.showMarkAsRead;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                ModelGuildFolder modelGuildFolder = this.folder;
                int iHashCode = (modelGuildFolder != null ? modelGuildFolder.hashCode() : 0) * 31;
                boolean z2 = this.showMarkAsRead;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(folder=");
                sbU.append(this.folder);
                sbU.append(", showMarkAsRead=");
                return outline.O(sbU, this.showMarkAsRead, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel$onMarkAsReadClicked$1, reason: invalid class name */
    /* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<Void>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<Void> list) {
            invoke2(list);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Void> list) {
            FolderContextMenuViewModel.this.eventSubject.k.onNext((T) Event.Dismiss.INSTANCE);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FolderContextMenuViewModel(long j, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        restAPI = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i & 4) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = companion.observeStoreState(j, companion2.getUserSettings(), companion2.getReadStates());
        }
        this(j, restAPI, observable);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (!(storeState instanceof StoreState.Valid)) {
            if (Intrinsics3.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
                updateViewState(ViewState.Invalid.INSTANCE);
                return;
            }
            return;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        this.guildIds = valid.getFolder().getGuildIds();
        this.unreadGuildIds = valid.getUnreadGuildIds();
        ModelGuildFolder folder = valid.getFolder();
        List<Long> guildIds = valid.getFolder().getGuildIds();
        boolean z2 = false;
        if (!(guildIds instanceof Collection) || !guildIds.isEmpty()) {
            Iterator<T> it = guildIds.iterator();
            while (it.hasNext()) {
                if (this.unreadGuildIds.contains(Long.valueOf(((Number) it.next()).longValue()))) {
                    z2 = true;
                    break;
                }
            }
        }
        updateViewState(new ViewState.Valid(folder, z2));
    }

    public final Observable<StoreState> getStoreStateObservable() {
        return this.storeStateObservable;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onMarkAsReadClicked() {
        Set setIntersect = _Collections.intersect(this.guildIds, this.unreadGuildIds);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(setIntersect, 10));
        Iterator it = setIntersect.iterator();
        while (it.hasNext()) {
            arrayList.add(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ackGuild(((Number) it.next()).longValue()), false, 1, null));
        }
        Observable observableF0 = Observable.H(Observable.h0(new OnSubscribeFromIterable(arrayList))).f0();
        Intrinsics3.checkNotNullExpressionValue(observableF0, "Observable\n        .merg…tCalls)\n        .toList()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableF0, this, null, 2, null), (Class<?>) FolderContextMenuViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final void onSettingsClicked() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.Dismiss.INSTANCE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderContextMenuViewModel(long j, RestAPI restAPI, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.folderId = j;
        this.restAPI = restAPI;
        this.storeStateObservable = observable;
        this.eventSubject = PublishSubject.k0();
        this.guildIds = Collections2.emptyList();
        this.unreadGuildIds = Sets5.emptySet();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) FolderContextMenuViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
