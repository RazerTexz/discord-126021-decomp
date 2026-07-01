package com.discord.widgets.guilds.create;

import a0.a.a.b;
import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import b.a.d.AppViewModel;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.Guild;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuildTemplates;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.StringsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildCreateViewModel extends AppViewModel<ViewState> {
    private final String analyticLocation;
    private final boolean closeWithResult;
    private final String customTitle;
    private final int defaultGuildNameFormatRes;
    private boolean didTrackCreateGuildViewed;
    private final PublishSubject<Event> eventsSubject;
    private final String guildTemplateCode;
    private final RestAPI restAPI;
    private final StoreGuildSelected selectedGuildStore;
    private final boolean showChannelPrompt;
    private final StockGuildTemplate stockGuildTemplate;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.create.WidgetGuildCreateViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<User, StoreGuildTemplates.GuildTemplateState, StoreState> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(2, StoreState.class, "<init>", "<init>(Lcom/discord/models/user/User;Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final StoreState invoke(User user, StoreGuildTemplates.GuildTemplateState guildTemplateState) {
            Intrinsics3.checkNotNullParameter(user, "p1");
            Intrinsics3.checkNotNullParameter(guildTemplateState, "p2");
            return new StoreState(user, guildTemplateState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.create.WidgetGuildCreateViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "it");
            WidgetGuildCreateViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
        public static final /* data */ class CloseWithResult extends Event {
            private final long guildId;

            public CloseWithResult(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ CloseWithResult copy$default(CloseWithResult closeWithResult, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = closeWithResult.guildId;
                }
                return closeWithResult.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final CloseWithResult copy(long guildId) {
                return new CloseWithResult(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof CloseWithResult) && this.guildId == ((CloseWithResult) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return b.a(this.guildId);
            }

            public String toString() {
                return outline.C(outline.U("CloseWithResult(guildId="), this.guildId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
        public static final /* data */ class LaunchChannelPrompt extends Event {
            private final long guildId;

            public LaunchChannelPrompt(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ LaunchChannelPrompt copy$default(LaunchChannelPrompt launchChannelPrompt, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchChannelPrompt.guildId;
                }
                return launchChannelPrompt.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final LaunchChannelPrompt copy(long guildId) {
                return new LaunchChannelPrompt(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LaunchChannelPrompt) && this.guildId == ((LaunchChannelPrompt) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return b.a(this.guildId);
            }

            public String toString() {
                return outline.C(outline.U("LaunchChannelPrompt(guildId="), this.guildId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
        public static final /* data */ class LaunchInviteShareScreen extends Event {
            private final long guildId;

            public LaunchInviteShareScreen(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ LaunchInviteShareScreen copy$default(LaunchInviteShareScreen launchInviteShareScreen, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchInviteShareScreen.guildId;
                }
                return launchInviteShareScreen.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final LaunchInviteShareScreen copy(long guildId) {
                return new LaunchInviteShareScreen(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LaunchInviteShareScreen) && this.guildId == ((LaunchInviteShareScreen) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return b.a(this.guildId);
            }

            public String toString() {
                return outline.C(outline.U("LaunchInviteShareScreen(guildId="), this.guildId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
        public static final /* data */ class ShowToast extends Event {
            private final int stringResId;

            public ShowToast(@StringRes int i) {
                super(null);
                this.stringResId = i;
            }

            public static /* synthetic */ ShowToast copy$default(ShowToast showToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showToast.stringResId;
                }
                return showToast.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getStringResId() {
                return this.stringResId;
            }

            public final ShowToast copy(@StringRes int stringResId) {
                return new ShowToast(stringResId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowToast) && this.stringResId == ((ShowToast) other).stringResId;
                }
                return true;
            }

            public final int getStringResId() {
                return this.stringResId;
            }

            public int hashCode() {
                return this.stringResId;
            }

            public String toString() {
                return outline.B(outline.U("ShowToast(stringResId="), this.stringResId, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
    public static final /* data */ class StoreState {
        private final StoreGuildTemplates.GuildTemplateState guildTemplate;
        private final User meUser;

        public StoreState(User user, StoreGuildTemplates.GuildTemplateState guildTemplateState) {
            Intrinsics3.checkNotNullParameter(user, "meUser");
            Intrinsics3.checkNotNullParameter(guildTemplateState, "guildTemplate");
            this.meUser = user;
            this.guildTemplate = guildTemplateState;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, User user, StoreGuildTemplates.GuildTemplateState guildTemplateState, int i, Object obj) {
            if ((i & 1) != 0) {
                user = storeState.meUser;
            }
            if ((i & 2) != 0) {
                guildTemplateState = storeState.guildTemplate;
            }
            return storeState.copy(user, guildTemplateState);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getMeUser() {
            return this.meUser;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StoreGuildTemplates.GuildTemplateState getGuildTemplate() {
            return this.guildTemplate;
        }

        public final StoreState copy(User meUser, StoreGuildTemplates.GuildTemplateState guildTemplate) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
            return new StoreState(meUser, guildTemplate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.meUser, storeState.meUser) && Intrinsics3.areEqual(this.guildTemplate, storeState.guildTemplate);
        }

        public final StoreGuildTemplates.GuildTemplateState getGuildTemplate() {
            return this.guildTemplate;
        }

        public final User getMeUser() {
            return this.meUser;
        }

        public int hashCode() {
            User user = this.meUser;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            StoreGuildTemplates.GuildTemplateState guildTemplateState = this.guildTemplate;
            return iHashCode + (guildTemplateState != null ? guildTemplateState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(meUser=");
            sbU.append(this.meUser);
            sbU.append(", guildTemplate=");
            sbU.append(this.guildTemplate);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
        public static final /* data */ class Initialized extends ViewState {
            private final String customTitle;
            private final int defaultGuildNameFormatRes;
            private final String guildIconUri;
            private final String guildName;
            private final StoreGuildTemplates.GuildTemplateState guildTemplate;
            private final boolean isBusy;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initialized(StoreGuildTemplates.GuildTemplateState guildTemplateState, @StringRes int i, String str, String str2, String str3, boolean z2, String str4) {
                super(null);
                Intrinsics3.checkNotNullParameter(guildTemplateState, "guildTemplate");
                Intrinsics3.checkNotNullParameter(str, "username");
                this.guildTemplate = guildTemplateState;
                this.defaultGuildNameFormatRes = i;
                this.username = str;
                this.guildName = str2;
                this.guildIconUri = str3;
                this.isBusy = z2;
                this.customTitle = str4;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            private final int getDefaultGuildNameFormatRes() {
                return this.defaultGuildNameFormatRes;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            private final String getUsername() {
                return this.username;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            private final String getGuildName() {
                return this.guildName;
            }

            public static /* synthetic */ Initialized copy$default(Initialized initialized, StoreGuildTemplates.GuildTemplateState guildTemplateState, int i, String str, String str2, String str3, boolean z2, String str4, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    guildTemplateState = initialized.guildTemplate;
                }
                if ((i2 & 2) != 0) {
                    i = initialized.defaultGuildNameFormatRes;
                }
                int i3 = i;
                if ((i2 & 4) != 0) {
                    str = initialized.username;
                }
                String str5 = str;
                if ((i2 & 8) != 0) {
                    str2 = initialized.guildName;
                }
                String str6 = str2;
                if ((i2 & 16) != 0) {
                    str3 = initialized.guildIconUri;
                }
                String str7 = str3;
                if ((i2 & 32) != 0) {
                    z2 = initialized.isBusy;
                }
                boolean z3 = z2;
                if ((i2 & 64) != 0) {
                    str4 = initialized.customTitle;
                }
                return initialized.copy(guildTemplateState, i3, str5, str6, str7, z3, str4);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final StoreGuildTemplates.GuildTemplateState getGuildTemplate() {
                return this.guildTemplate;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getGuildIconUri() {
                return this.guildIconUri;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getIsBusy() {
                return this.isBusy;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final String getCustomTitle() {
                return this.customTitle;
            }

            public final Initialized copy(StoreGuildTemplates.GuildTemplateState guildTemplate, @StringRes int defaultGuildNameFormatRes, String username, String guildName, String guildIconUri, boolean isBusy, String customTitle) {
                Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
                Intrinsics3.checkNotNullParameter(username, "username");
                return new Initialized(guildTemplate, defaultGuildNameFormatRes, username, guildName, guildIconUri, isBusy, customTitle);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initialized)) {
                    return false;
                }
                Initialized initialized = (Initialized) other;
                return Intrinsics3.areEqual(this.guildTemplate, initialized.guildTemplate) && this.defaultGuildNameFormatRes == initialized.defaultGuildNameFormatRes && Intrinsics3.areEqual(this.username, initialized.username) && Intrinsics3.areEqual(this.guildName, initialized.guildName) && Intrinsics3.areEqual(this.guildIconUri, initialized.guildIconUri) && this.isBusy == initialized.isBusy && Intrinsics3.areEqual(this.customTitle, initialized.customTitle);
            }

            public final String getCustomTitle() {
                return this.customTitle;
            }

            public final String getGuildIconUri() {
                return this.guildIconUri;
            }

            public final String getGuildName(Context context) {
                Intrinsics3.checkNotNullParameter(context, "context");
                String str = this.guildName;
                return str != null ? str : FormatUtils.b(context, this.defaultGuildNameFormatRes, new Object[]{this.username}, (4 & 4) != 0 ? FormatUtils.b.j : null).toString();
            }

            public final StoreGuildTemplates.GuildTemplateState getGuildTemplate() {
                return this.guildTemplate;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v12, types: [int] */
            /* JADX WARN: Type inference failed for: r2v11, types: [int] */
            /* JADX WARN: Type inference failed for: r2v13 */
            /* JADX WARN: Type inference failed for: r2v17 */
            public int hashCode() {
                StoreGuildTemplates.GuildTemplateState guildTemplateState = this.guildTemplate;
                int iHashCode = (((guildTemplateState != null ? guildTemplateState.hashCode() : 0) * 31) + this.defaultGuildNameFormatRes) * 31;
                String str = this.username;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.guildName;
                int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.guildIconUri;
                int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
                boolean z2 = this.isBusy;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode4 + r2) * 31;
                String str4 = this.customTitle;
                return i + (str4 != null ? str4.hashCode() : 0);
            }

            public final boolean isBusy() {
                return this.isBusy;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Initialized(guildTemplate=");
                sbU.append(this.guildTemplate);
                sbU.append(", defaultGuildNameFormatRes=");
                sbU.append(this.defaultGuildNameFormatRes);
                sbU.append(", username=");
                sbU.append(this.username);
                sbU.append(", guildName=");
                sbU.append(this.guildName);
                sbU.append(", guildIconUri=");
                sbU.append(this.guildIconUri);
                sbU.append(", isBusy=");
                sbU.append(this.isBusy);
                sbU.append(", customTitle=");
                return outline.J(sbU, this.customTitle, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
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

    /* JADX INFO: renamed from: com.discord.widgets.guilds.create.WidgetGuildCreateViewModel$createGuild$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Guild, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "createdGuild");
            WidgetGuildCreateViewModel.this.handleGuildCreateSuccess(new com.discord.models.guild.Guild(guild));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.create.WidgetGuildCreateViewModel$createGuild$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetGuildCreateViewModel.this.handleGuildCreateFailure();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetGuildCreateViewModel(int i, StockGuildTemplate stockGuildTemplate, final String str, boolean z2, String str2, String str3, boolean z3, StoreGuildSelected storeGuildSelected, RestAPI restAPI, Observable observable, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observable2;
        StockGuildTemplate stockGuildTemplate2 = (i2 & 2) != 0 ? StockGuildTemplate.CREATE : stockGuildTemplate;
        boolean z4 = (i2 & 64) != 0 ? false : z3;
        StoreGuildSelected guildSelected = (i2 & 128) != 0 ? StoreStream.INSTANCE.getGuildSelected() : storeGuildSelected;
        RestAPI api = (i2 & 256) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i2 & 512) != 0) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableZ = StoreUser.observeMe$default(companion.getUsers(), false, 1, null).Z(1);
            Observable<StoreGuildTemplates.GuildTemplateState> scalarSynchronousObservable = str == null ? new ScalarSynchronousObservable<>(StoreGuildTemplates.GuildTemplateState.None.INSTANCE) : companion.getGuildTemplates().observeGuildTemplate(str).v(new Action0() { // from class: com.discord.widgets.guilds.create.WidgetGuildCreateViewModel.1
                @Override // rx.functions.Action0
                public final void call() {
                    StoreStream.INSTANCE.getGuildTemplates().maybeInitTemplateState(str);
                }
            });
            final AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
            Observable observableJ = Observable.j(observableZ, scalarSynchronousObservable, (Func2) (anonymousClass2 != null ? new Func2() { // from class: com.discord.widgets.guilds.create.WidgetGuildCreateViewModel$sam$rx_functions_Func2$0
                @Override // rx.functions.Func2
                public final /* synthetic */ Object call(Object obj, Object obj2) {
                    return anonymousClass2.invoke(obj, obj2);
                }
            } : anonymousClass2));
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…},\n      ::StoreState\n  )");
            observable2 = observableJ;
        } else {
            observable2 = observable;
        }
        this(i, stockGuildTemplate2, str, z2, str2, str3, z4, guildSelected, api, observable2);
    }

    @MainThread
    private final void emitEvent(Event event) {
        this.eventsSubject.k.onNext(event);
    }

    @MainThread
    private final void handleGuildCreateFailure() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            updateViewState(ViewState.Initialized.copy$default(initialized, null, 0, null, null, null, false, null, 95, null));
        }
    }

    @MainThread
    private final void handleGuildCreateSuccess(com.discord.models.guild.Guild guild) {
        Event closeWithResult;
        if (!this.closeWithResult) {
            this.selectedGuildStore.set(guild.getId());
        }
        if (this.showChannelPrompt) {
            closeWithResult = new Event.LaunchChannelPrompt(guild.getId());
        } else {
            closeWithResult = this.closeWithResult ? new Event.CloseWithResult(guild.getId()) : new Event.LaunchInviteShareScreen(guild.getId());
        }
        emitEvent(closeWithResult);
    }

    @MainThread
    public final void createGuild(Context context) {
        Observable<Guild> observableLogNetworkAction;
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            String guildName = initialized.getGuildName(context);
            String guildIconUri = initialized.getGuildIconUri();
            if (initialized.isBusy()) {
                return;
            }
            if (StringsJVM.isBlank(guildName)) {
                emitEvent(new Event.ShowToast(R.string.server_name_required));
                return;
            }
            if (initialized.getGuildTemplate() instanceof StoreGuildTemplates.GuildTemplateState.Resolved) {
                observableLogNetworkAction = this.restAPI.createGuildFromTemplate(((StoreGuildTemplates.GuildTemplateState.Resolved) initialized.getGuildTemplate()).getGuildTemplate().getCode(), new RestAPIParams.CreateGuildFromTemplate(guildName, guildIconUri));
            } else {
                RestAPI restAPI = this.restAPI;
                StockGuildTemplate stockGuildTemplate = this.stockGuildTemplate;
                Resources resources = context.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
                observableLogNetworkAction = RestCallState5.logNetworkAction(restAPI.createGuild(new RestAPIParams.CreateGuild(guildName, guildIconUri, stockGuildTemplate.getChannels(resources), Long.valueOf(this.stockGuildTemplate.getSystemChannelId()))), new WidgetGuildCreateViewModel2(this));
            }
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn(observableLogNetworkAction, false), this, null, 2, null), (Class<?>) WidgetGuildCreateViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
            updateViewState(ViewState.Initialized.copy$default(initialized, null, 0, null, null, null, true, null, 95, null));
        }
    }

    @MainThread
    public final void handleStoreState(StoreState storeState) {
        Intrinsics3.checkNotNullParameter(storeState, "storeState");
        updateViewState(new ViewState.Initialized(storeState.getGuildTemplate(), this.defaultGuildNameFormatRes, storeState.getMeUser().getUsername(), null, null, false, this.customTitle));
        if (this.didTrackCreateGuildViewed || (storeState.getGuildTemplate() instanceof StoreGuildTemplates.GuildTemplateState.Loading)) {
            return;
        }
        AnalyticsTracker.INSTANCE.createGuildViewed(this.stockGuildTemplate, storeState.getGuildTemplate() instanceof StoreGuildTemplates.GuildTemplateState.Resolved ? ((StoreGuildTemplates.GuildTemplateState.Resolved) storeState.getGuildTemplate()).getGuildTemplate() : null, this.analyticLocation);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventsSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventsSubject");
        return publishSubject;
    }

    @MainThread
    public final void updateGuildIconUri(String guildIconUri) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            updateViewState(ViewState.Initialized.copy$default(initialized, null, 0, null, null, guildIconUri, false, null, 111, null));
        }
    }

    @MainThread
    public final void updateGuildName(String guildName) {
        Intrinsics3.checkNotNullParameter(guildName, "guildName");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            updateViewState(ViewState.Initialized.copy$default(initialized, null, 0, null, guildName, null, false, null, 119, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCreateViewModel(@StringRes int i, StockGuildTemplate stockGuildTemplate, String str, boolean z2, String str2, String str3, boolean z3, StoreGuildSelected storeGuildSelected, RestAPI restAPI, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(stockGuildTemplate, "stockGuildTemplate");
        Intrinsics3.checkNotNullParameter(str2, "analyticLocation");
        Intrinsics3.checkNotNullParameter(storeGuildSelected, "selectedGuildStore");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) WidgetGuildCreateViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
    }
}
