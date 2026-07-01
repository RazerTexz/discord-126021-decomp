package com.discord.widgets.guilds.create;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import b.a.d.d0;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams$CreateGuild;
import com.discord.restapi.RestAPIParams$CreateGuildFromTemplate;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState$Loading;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState$None;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState$Resolved;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.t;
import d0.z.d.m;
import j0.l.e.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildCreateViewModel extends d0<WidgetGuildCreateViewModel$ViewState> {
    private final String analyticLocation;
    private final boolean closeWithResult;
    private final String customTitle;
    private final int defaultGuildNameFormatRes;
    private boolean didTrackCreateGuildViewed;
    private final PublishSubject<WidgetGuildCreateViewModel$Event> eventsSubject;
    private final String guildTemplateCode;
    private final RestAPI restAPI;
    private final StoreGuildSelected selectedGuildStore;
    private final boolean showChannelPrompt;
    private final StockGuildTemplate stockGuildTemplate;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetGuildCreateViewModel(int i, StockGuildTemplate stockGuildTemplate, String str, boolean z2, String str2, String str3, boolean z3, StoreGuildSelected storeGuildSelected, RestAPI restAPI, Observable observable, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observable2;
        StockGuildTemplate stockGuildTemplate2 = (i2 & 2) != 0 ? StockGuildTemplate.CREATE : stockGuildTemplate;
        boolean z4 = (i2 & 64) != 0 ? false : z3;
        StoreGuildSelected guildSelected = (i2 & 128) != 0 ? StoreStream.Companion.getGuildSelected() : storeGuildSelected;
        RestAPI api = (i2 & 256) != 0 ? RestAPI.Companion.getApi() : restAPI;
        if ((i2 & 512) != 0) {
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            Observable observableZ = StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null).Z(1);
            Observable<StoreGuildTemplates$GuildTemplateState> kVar = str == null ? new k<>(StoreGuildTemplates$GuildTemplateState$None.INSTANCE) : storeStream$Companion.getGuildTemplates().observeGuildTemplate(str).v(new WidgetGuildCreateViewModel$1(str));
            WidgetGuildCreateViewModel$2 widgetGuildCreateViewModel$2 = WidgetGuildCreateViewModel$2.INSTANCE;
            Observable observableJ = Observable.j(observableZ, kVar, (Func2) (widgetGuildCreateViewModel$2 != null ? new WidgetGuildCreateViewModel$sam$rx_functions_Func2$0(widgetGuildCreateViewModel$2) : widgetGuildCreateViewModel$2));
            m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…},\n      ::StoreState\n  )");
            observable2 = observableJ;
        } else {
            observable2 = observable;
        }
        this(i, stockGuildTemplate2, str, z2, str2, str3, z4, guildSelected, api, observable2);
    }

    public static final /* synthetic */ StockGuildTemplate access$getStockGuildTemplate$p(WidgetGuildCreateViewModel widgetGuildCreateViewModel) {
        return widgetGuildCreateViewModel.stockGuildTemplate;
    }

    public static final /* synthetic */ void access$handleGuildCreateFailure(WidgetGuildCreateViewModel widgetGuildCreateViewModel) {
        widgetGuildCreateViewModel.handleGuildCreateFailure();
    }

    public static final /* synthetic */ void access$handleGuildCreateSuccess(WidgetGuildCreateViewModel widgetGuildCreateViewModel, Guild guild) {
        widgetGuildCreateViewModel.handleGuildCreateSuccess(guild);
    }

    @MainThread
    private final void emitEvent(WidgetGuildCreateViewModel$Event event) {
        this.eventsSubject.k.onNext(event);
    }

    @MainThread
    private final void handleGuildCreateFailure() {
        WidgetGuildCreateViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetGuildCreateViewModel$ViewState$Initialized)) {
            viewState = null;
        }
        WidgetGuildCreateViewModel$ViewState$Initialized widgetGuildCreateViewModel$ViewState$Initialized = (WidgetGuildCreateViewModel$ViewState$Initialized) viewState;
        if (widgetGuildCreateViewModel$ViewState$Initialized != null) {
            updateViewState(WidgetGuildCreateViewModel$ViewState$Initialized.copy$default(widgetGuildCreateViewModel$ViewState$Initialized, null, 0, null, null, null, false, null, 95, null));
        }
    }

    @MainThread
    private final void handleGuildCreateSuccess(Guild guild) {
        WidgetGuildCreateViewModel$Event widgetGuildCreateViewModel$Event$CloseWithResult;
        if (!this.closeWithResult) {
            this.selectedGuildStore.set(guild.getId());
        }
        if (this.showChannelPrompt) {
            widgetGuildCreateViewModel$Event$CloseWithResult = new WidgetGuildCreateViewModel$Event$LaunchChannelPrompt(guild.getId());
        } else {
            widgetGuildCreateViewModel$Event$CloseWithResult = this.closeWithResult ? new WidgetGuildCreateViewModel$Event$CloseWithResult(guild.getId()) : new WidgetGuildCreateViewModel$Event$LaunchInviteShareScreen(guild.getId());
        }
        emitEvent(widgetGuildCreateViewModel$Event$CloseWithResult);
    }

    @MainThread
    public final void createGuild(Context context) {
        Observable<com.discord.api.guild.Guild> observableLogNetworkAction;
        m.checkNotNullParameter(context, "context");
        WidgetGuildCreateViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetGuildCreateViewModel$ViewState$Initialized)) {
            viewState = null;
        }
        WidgetGuildCreateViewModel$ViewState$Initialized widgetGuildCreateViewModel$ViewState$Initialized = (WidgetGuildCreateViewModel$ViewState$Initialized) viewState;
        if (widgetGuildCreateViewModel$ViewState$Initialized != null) {
            String guildName = widgetGuildCreateViewModel$ViewState$Initialized.getGuildName(context);
            String guildIconUri = widgetGuildCreateViewModel$ViewState$Initialized.getGuildIconUri();
            if (widgetGuildCreateViewModel$ViewState$Initialized.isBusy()) {
                return;
            }
            if (t.isBlank(guildName)) {
                emitEvent(new WidgetGuildCreateViewModel$Event$ShowToast(2131895588));
                return;
            }
            if (widgetGuildCreateViewModel$ViewState$Initialized.getGuildTemplate() instanceof StoreGuildTemplates$GuildTemplateState$Resolved) {
                observableLogNetworkAction = this.restAPI.createGuildFromTemplate(((StoreGuildTemplates$GuildTemplateState$Resolved) widgetGuildCreateViewModel$ViewState$Initialized.getGuildTemplate()).getGuildTemplate().getCode(), new RestAPIParams$CreateGuildFromTemplate(guildName, guildIconUri));
            } else {
                RestAPI restAPI = this.restAPI;
                StockGuildTemplate stockGuildTemplate = this.stockGuildTemplate;
                Resources resources = context.getResources();
                m.checkNotNullExpressionValue(resources, "context.resources");
                observableLogNetworkAction = RestCallStateKt.logNetworkAction(restAPI.createGuild(new RestAPIParams$CreateGuild(guildName, guildIconUri, stockGuildTemplate.getChannels(resources), Long.valueOf(this.stockGuildTemplate.getSystemChannelId()))), new WidgetGuildCreateViewModel$createGuild$createGuildRequestObservable$1(this));
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn(observableLogNetworkAction, false), this, null, 2, null), WidgetGuildCreateViewModel.class, (Context) null, (Function1) null, new WidgetGuildCreateViewModel$createGuild$2(this), (Function0) null, (Function0) null, new WidgetGuildCreateViewModel$createGuild$1(this), 54, (Object) null);
            updateViewState(WidgetGuildCreateViewModel$ViewState$Initialized.copy$default(widgetGuildCreateViewModel$ViewState$Initialized, null, 0, null, null, null, true, null, 95, null));
        }
    }

    @MainThread
    public final void handleStoreState(WidgetGuildCreateViewModel$StoreState storeState) {
        m.checkNotNullParameter(storeState, "storeState");
        updateViewState(new WidgetGuildCreateViewModel$ViewState$Initialized(storeState.getGuildTemplate(), this.defaultGuildNameFormatRes, storeState.getMeUser().getUsername(), null, null, false, this.customTitle));
        if (this.didTrackCreateGuildViewed || (storeState.getGuildTemplate() instanceof StoreGuildTemplates$GuildTemplateState$Loading)) {
            return;
        }
        AnalyticsTracker.INSTANCE.createGuildViewed(this.stockGuildTemplate, storeState.getGuildTemplate() instanceof StoreGuildTemplates$GuildTemplateState$Resolved ? ((StoreGuildTemplates$GuildTemplateState$Resolved) storeState.getGuildTemplate()).getGuildTemplate() : null, this.analyticLocation);
    }

    public final Observable<WidgetGuildCreateViewModel$Event> observeEvents() {
        PublishSubject<WidgetGuildCreateViewModel$Event> publishSubject = this.eventsSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventsSubject");
        return publishSubject;
    }

    @MainThread
    public final void updateGuildIconUri(String guildIconUri) {
        WidgetGuildCreateViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetGuildCreateViewModel$ViewState$Initialized)) {
            viewState = null;
        }
        WidgetGuildCreateViewModel$ViewState$Initialized widgetGuildCreateViewModel$ViewState$Initialized = (WidgetGuildCreateViewModel$ViewState$Initialized) viewState;
        if (widgetGuildCreateViewModel$ViewState$Initialized != null) {
            updateViewState(WidgetGuildCreateViewModel$ViewState$Initialized.copy$default(widgetGuildCreateViewModel$ViewState$Initialized, null, 0, null, null, guildIconUri, false, null, 111, null));
        }
    }

    @MainThread
    public final void updateGuildName(String guildName) {
        m.checkNotNullParameter(guildName, "guildName");
        WidgetGuildCreateViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof WidgetGuildCreateViewModel$ViewState$Initialized)) {
            viewState = null;
        }
        WidgetGuildCreateViewModel$ViewState$Initialized widgetGuildCreateViewModel$ViewState$Initialized = (WidgetGuildCreateViewModel$ViewState$Initialized) viewState;
        if (widgetGuildCreateViewModel$ViewState$Initialized != null) {
            updateViewState(WidgetGuildCreateViewModel$ViewState$Initialized.copy$default(widgetGuildCreateViewModel$ViewState$Initialized, null, 0, null, guildName, null, false, null, 119, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCreateViewModel(@StringRes int i, StockGuildTemplate stockGuildTemplate, String str, boolean z2, String str2, String str3, boolean z3, StoreGuildSelected storeGuildSelected, RestAPI restAPI, Observable<WidgetGuildCreateViewModel$StoreState> observable) {
        super(WidgetGuildCreateViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(stockGuildTemplate, "stockGuildTemplate");
        m.checkNotNullParameter(str2, "analyticLocation");
        m.checkNotNullParameter(storeGuildSelected, "selectedGuildStore");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observable, "storeObservable");
        this.defaultGuildNameFormatRes = i;
        this.stockGuildTemplate = stockGuildTemplate;
        this.guildTemplateCode = str;
        this.showChannelPrompt = z2;
        this.analyticLocation = str2;
        this.customTitle = str3;
        this.closeWithResult = z3;
        this.selectedGuildStore = storeGuildSelected;
        this.restAPI = restAPI;
        this.eventsSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetGuildCreateViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildCreateViewModel$3(this), 62, (Object) null);
    }
}
