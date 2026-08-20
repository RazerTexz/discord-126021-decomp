package com.discord.widgets.guilds.contextmenu;

import androidx.annotation.MainThread;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p643a.C12662q;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FolderContextMenuViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long folderId;
    private List<Long> guildIds;
    private final RestAPI restAPI;
    private final Observable<StoreState> storeStateObservable;
    private Set<Long> unreadGuildIds;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel$1 */
    /* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
    public static final /* synthetic */ class C85831 extends C12236k implements Function1<StoreState, Unit> {
        public C85831(FolderContextMenuViewModel folderContextMenuViewModel) {
            super(1, folderContextMenuViewModel, FolderContextMenuViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guilds/contextmenu/FolderContextMenuViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "p1");
            ((FolderContextMenuViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(final long folderId, StoreUserSettings userSettingsStore, StoreReadStates readStateStore) {
            Observable<StoreState> observableM11076j = Observable.m11076j(userSettingsStore.observeGuildFolders(), readStateStore.getUnreadGuildIds(), new Func2<List<? extends ModelGuildFolder>, Set<? extends Long>, StoreState>() { // from class: com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel$Companion$observeStoreState$1
                @Override // p658rx.functions.Func2
                public /* bridge */ /* synthetic */ FolderContextMenuViewModel.StoreState call(List<? extends ModelGuildFolder> list, Set<? extends Long> set) {
                    return call2((List<ModelGuildFolder>) list, (Set<Long>) set);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final FolderContextMenuViewModel.StoreState call2(List<ModelGuildFolder> list, Set<Long> set) {
                    Object next;
                    Long id2;
                    C12238m.checkNotNullExpressionValue(list, "guildFolders");
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
                    C12238m.checkNotNullExpressionValue(set, "unreadGuildIds");
                    return new FolderContextMenuViewModel.StoreState.Valid(modelGuildFolder, set);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…      )\n        }\n      }");
            return observableM11076j;
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
                C12238m.checkNotNullParameter(modelGuildFolder, "folder");
                C12238m.checkNotNullParameter(set, "unreadGuildIds");
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
                C12238m.checkNotNullParameter(folder, "folder");
                C12238m.checkNotNullParameter(unreadGuildIds, "unreadGuildIds");
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
                return C12238m.areEqual(this.folder, valid.folder) && C12238m.areEqual(this.unreadGuildIds, valid.unreadGuildIds);
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
                StringBuilder sbM833U = C1643a.m833U("Valid(folder=");
                sbM833U.append(this.folder);
                sbM833U.append(", unreadGuildIds=");
                return C1643a.m826N(sbM833U, this.unreadGuildIds, ")");
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
                C12238m.checkNotNullParameter(modelGuildFolder, "folder");
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
                C12238m.checkNotNullParameter(folder, "folder");
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
                return C12238m.areEqual(this.folder, valid.folder) && this.showMarkAsRead == valid.showMarkAsRead;
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
                StringBuilder sbM833U = C1643a.m833U("Valid(folder=");
                sbM833U.append(this.folder);
                sbM833U.append(", showMarkAsRead=");
                return C1643a.m827O(sbM833U, this.showMarkAsRead, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel$onMarkAsReadClicked$1 */
    /* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
    public static final class C85841 extends AbstractC12240o implements Function1<List<Void>, Unit> {
        public C85841() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<Void> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Void> list) {
            FolderContextMenuViewModel.this.eventSubject.f27650k.onNext((T) Event.Dismiss.INSTANCE);
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
            if (C12238m.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
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
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onMarkAsReadClicked() {
        Set setIntersect = C12163u.intersect(this.guildIds, this.unreadGuildIds);
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(setIntersect, 10));
        Iterator it = setIntersect.iterator();
        while (it.hasNext()) {
            arrayList.add(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ackGuild(((Number) it.next()).longValue()), false, 1, null));
        }
        Observable observableM11105f0 = Observable.m11063H(Observable.m11074h0(new C12662q(arrayList))).m11105f0();
        C12238m.checkNotNullExpressionValue(observableM11105f0, "Observable\n        .merg…tCalls)\n        .toList()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11105f0, this, null, 2, null), (Class<?>) FolderContextMenuViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C85841());
    }

    public final void onSettingsClicked() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.Dismiss.INSTANCE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderContextMenuViewModel(long j, RestAPI restAPI, Observable<StoreState> observable) {
        super(null);
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.folderId = j;
        this.restAPI = restAPI;
        this.storeStateObservable = observable;
        this.eventSubject = PublishSubject.m11133k0();
        this.guildIds = C12147n.emptyList();
        this.unreadGuildIds = C12148n0.emptySet();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) FolderContextMenuViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C85831(this));
    }
}
