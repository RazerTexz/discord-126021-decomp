package com.discord.widgets.settings.connections;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.connectedaccounts.ConnectedAccountIntegration;
import com.discord.api.connectedaccounts.ConnectedIntegrationGuild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsViewModel extends d0<WidgetSettingsUserConnectionsViewModel$ViewState> {
    public static final WidgetSettingsUserConnectionsViewModel$Companion Companion = new WidgetSettingsUserConnectionsViewModel$Companion(null);
    private final BehaviorSubject<Map<String, WidgetSettingsUserConnectionsViewModel$JoinStatus>> joinStateSubject;
    private final Map<String, WidgetSettingsUserConnectionsViewModel$JoinStatus> joinStatusMap;
    private final RestAPI restApi;

    public WidgetSettingsUserConnectionsViewModel() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ WidgetSettingsUserConnectionsViewModel(Observable observable, StoreUserConnections storeUserConnections, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? WidgetSettingsUserConnectionsViewModel$Companion.access$observeStores(Companion) : observable, (i & 2) != 0 ? StoreStream.Companion.getUserConnections() : storeUserConnections, (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ List access$combineState(WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel, WidgetSettingsUserConnectionsViewModel$StoreState widgetSettingsUserConnectionsViewModel$StoreState, Map map) {
        return widgetSettingsUserConnectionsViewModel.combineState(widgetSettingsUserConnectionsViewModel$StoreState, map);
    }

    public static final /* synthetic */ BehaviorSubject access$getJoinStateSubject$p(WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel) {
        return widgetSettingsUserConnectionsViewModel.joinStateSubject;
    }

    public static final /* synthetic */ Map access$getJoinStatusMap$p(WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel) {
        return widgetSettingsUserConnectionsViewModel.joinStatusMap;
    }

    public static final /* synthetic */ void access$handleConnectionsState(WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel, List list) {
        widgetSettingsUserConnectionsViewModel.handleConnectionsState(list);
    }

    private final List<WidgetSettingsUserConnectionsViewModel$ConnectionState> combineState(WidgetSettingsUserConnectionsViewModel$StoreState storeState, Map<String, ? extends WidgetSettingsUserConnectionsViewModel$JoinStatus> joinMap) {
        ArrayList arrayList = new ArrayList();
        for (ConnectedAccount connectedAccount : storeState.getConnectedAccounts()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<ConnectedAccountIntegration> listC = connectedAccount.c();
            if (listC != null) {
                for (ConnectedAccountIntegration connectedAccountIntegration : listC) {
                    ConnectedIntegrationGuild guild = connectedAccountIntegration.getGuild();
                    if (guild != null) {
                        if (storeState.getGuilds().containsKey(Long.valueOf(guild.getId()))) {
                            linkedHashMap.put(connectedAccountIntegration.getId(), WidgetSettingsUserConnectionsViewModel$JoinStatus$Joined.INSTANCE);
                        }
                        WidgetSettingsUserConnectionsViewModel$JoinStatus widgetSettingsUserConnectionsViewModel$JoinStatus = joinMap.get(connectedAccountIntegration.getId());
                        if (widgetSettingsUserConnectionsViewModel$JoinStatus != null) {
                            linkedHashMap.put(connectedAccountIntegration.getId(), widgetSettingsUserConnectionsViewModel$JoinStatus);
                        }
                    }
                }
            }
            arrayList.add(new WidgetSettingsUserConnectionsViewModel$ConnectionState(connectedAccount, linkedHashMap));
        }
        return arrayList;
    }

    private final void handleConnectionsState(List<WidgetSettingsUserConnectionsViewModel$ConnectionState> state) {
        if (state == null || state.isEmpty()) {
            updateViewState(WidgetSettingsUserConnectionsViewModel$ViewState$Empty.INSTANCE);
        } else {
            updateViewState(new WidgetSettingsUserConnectionsViewModel$ViewState$Loaded(state));
        }
    }

    public final void joinConnectionIntegrationGuild(String integrationId) {
        m.checkNotNullParameter(integrationId, "integrationId");
        this.joinStatusMap.put(integrationId, WidgetSettingsUserConnectionsViewModel$JoinStatus$Joining.INSTANCE);
        this.joinStateSubject.onNext(this.joinStatusMap);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.joinGuildFromIntegration(integrationId), false, 1, null), WidgetSettingsUserConnectionsViewModel.class, (Context) null, (Function1) null, new WidgetSettingsUserConnectionsViewModel$joinConnectionIntegrationGuild$1(this, integrationId), (Function0) null, (Function0) null, new WidgetSettingsUserConnectionsViewModel$joinConnectionIntegrationGuild$2(this, integrationId), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsUserConnectionsViewModel(Observable<WidgetSettingsUserConnectionsViewModel$StoreState> observable, StoreUserConnections storeUserConnections, RestAPI restAPI) {
        super(WidgetSettingsUserConnectionsViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(observable, "storeStateObservable");
        m.checkNotNullParameter(storeUserConnections, "storeUserConnections");
        m.checkNotNullParameter(restAPI, "restApi");
        this.restApi = restAPI;
        this.joinStatusMap = new LinkedHashMap();
        BehaviorSubject<Map<String, WidgetSettingsUserConnectionsViewModel$JoinStatus>> behaviorSubjectL0 = BehaviorSubject.l0(h0.emptyMap());
        this.joinStateSubject = behaviorSubjectL0;
        storeUserConnections.fetchConnectedAccounts();
        Observable observableJ = Observable.j(observable, behaviorSubjectL0, new WidgetSettingsUserConnectionsViewModel$1(this));
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…te(storeState, joinMap) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableJ), this, null, 2, null), WidgetSettingsUserConnectionsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsUserConnectionsViewModel$2(this), 62, (Object) null);
    }
}
