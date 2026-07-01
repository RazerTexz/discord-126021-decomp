package com.discord.widgets.guilds.contextmenu;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.n;
import d0.t.n0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import j0.l.a.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: FolderContextMenuViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FolderContextMenuViewModel extends d0<FolderContextMenuViewModel$ViewState> {
    public static final FolderContextMenuViewModel$Companion Companion = new FolderContextMenuViewModel$Companion(null);
    private final PublishSubject<FolderContextMenuViewModel$Event> eventSubject;
    private final long folderId;
    private List<Long> guildIds;
    private final RestAPI restAPI;
    private final Observable<FolderContextMenuViewModel$StoreState> storeStateObservable;
    private Set<Long> unreadGuildIds;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FolderContextMenuViewModel(long j, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        restAPI = (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI;
        if ((i & 4) != 0) {
            FolderContextMenuViewModel$Companion folderContextMenuViewModel$Companion = Companion;
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observable = FolderContextMenuViewModel$Companion.access$observeStoreState(folderContextMenuViewModel$Companion, j, storeStream$Companion.getUserSettings(), storeStream$Companion.getReadStates());
        }
        this(j, restAPI, observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(FolderContextMenuViewModel folderContextMenuViewModel) {
        return folderContextMenuViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(FolderContextMenuViewModel folderContextMenuViewModel, FolderContextMenuViewModel$StoreState folderContextMenuViewModel$StoreState) {
        folderContextMenuViewModel.handleStoreState(folderContextMenuViewModel$StoreState);
    }

    @MainThread
    private final void handleStoreState(FolderContextMenuViewModel$StoreState storeState) {
        if (!(storeState instanceof FolderContextMenuViewModel$StoreState$Valid)) {
            if (m.areEqual(storeState, FolderContextMenuViewModel$StoreState$Invalid.INSTANCE)) {
                updateViewState(FolderContextMenuViewModel$ViewState$Invalid.INSTANCE);
                return;
            }
            return;
        }
        FolderContextMenuViewModel$StoreState$Valid folderContextMenuViewModel$StoreState$Valid = (FolderContextMenuViewModel$StoreState$Valid) storeState;
        this.guildIds = folderContextMenuViewModel$StoreState$Valid.getFolder().getGuildIds();
        this.unreadGuildIds = folderContextMenuViewModel$StoreState$Valid.getUnreadGuildIds();
        ModelGuildFolder folder = folderContextMenuViewModel$StoreState$Valid.getFolder();
        List<Long> guildIds = folderContextMenuViewModel$StoreState$Valid.getFolder().getGuildIds();
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
        updateViewState(new FolderContextMenuViewModel$ViewState$Valid(folder, z2));
    }

    public final Observable<FolderContextMenuViewModel$StoreState> getStoreStateObservable() {
        return this.storeStateObservable;
    }

    public final Observable<FolderContextMenuViewModel$Event> observeEvents() {
        PublishSubject<FolderContextMenuViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onMarkAsReadClicked() {
        Set setIntersect = u.intersect(this.guildIds, this.unreadGuildIds);
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(setIntersect, 10));
        Iterator it = setIntersect.iterator();
        while (it.hasNext()) {
            arrayList.add(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ackGuild(((Number) it.next()).longValue()), false, 1, null));
        }
        Observable observableF0 = Observable.H(Observable.h0(new q(arrayList))).f0();
        m.checkNotNullExpressionValue(observableF0, "Observable\n        .merg…tCalls)\n        .toList()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableF0, this, null, 2, null), FolderContextMenuViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new FolderContextMenuViewModel$onMarkAsReadClicked$1(this), 62, (Object) null);
    }

    public final void onSettingsClicked() {
        PublishSubject<FolderContextMenuViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(FolderContextMenuViewModel$Event$Dismiss.INSTANCE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderContextMenuViewModel(long j, RestAPI restAPI, Observable<FolderContextMenuViewModel$StoreState> observable) {
        super(null);
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.folderId = j;
        this.restAPI = restAPI;
        this.storeStateObservable = observable;
        this.eventSubject = PublishSubject.k0();
        this.guildIds = n.emptyList();
        this.unreadGuildIds = n0.emptySet();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), FolderContextMenuViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new FolderContextMenuViewModel$1(this), 62, (Object) null);
    }
}
