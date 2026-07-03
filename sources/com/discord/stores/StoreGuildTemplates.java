package com.discord.stores;

import com.discord.models.domain.ModelGuildTemplate;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildTemplates extends StoreV2 {
    private final Dispatcher dispatcher;
    private String dynamicLinkGuildTemplateCode;
    private final Map<String, GuildTemplateState> guildTemplatesByCode;
    private Map<String, ? extends GuildTemplateState> guildTemplatesByCodeSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    /* JADX INFO: compiled from: StoreGuildTemplates.kt */
    public static abstract class GuildTemplateState {

        /* JADX INFO: compiled from: StoreGuildTemplates.kt */
        public static final class Invalid extends GuildTemplateState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreGuildTemplates.kt */
        public static final class LoadFailed extends GuildTemplateState {
            public static final LoadFailed INSTANCE = new LoadFailed();

            private LoadFailed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreGuildTemplates.kt */
        public static final class Loading extends GuildTemplateState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreGuildTemplates.kt */
        public static final class None extends GuildTemplateState {
            public static final None INSTANCE = new None();

            private None() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreGuildTemplates.kt */
        public static final /* data */ class Resolved extends GuildTemplateState {
            private final ModelGuildTemplate guildTemplate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Resolved(ModelGuildTemplate modelGuildTemplate) {
                super(null);
                C12238m.checkNotNullParameter(modelGuildTemplate, "guildTemplate");
                this.guildTemplate = modelGuildTemplate;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, ModelGuildTemplate modelGuildTemplate, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildTemplate = resolved.guildTemplate;
                }
                return resolved.copy(modelGuildTemplate);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelGuildTemplate getGuildTemplate() {
                return this.guildTemplate;
            }

            public final Resolved copy(ModelGuildTemplate guildTemplate) {
                C12238m.checkNotNullParameter(guildTemplate, "guildTemplate");
                return new Resolved(guildTemplate);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && C12238m.areEqual(this.guildTemplate, ((Resolved) other).guildTemplate);
                }
                return true;
            }

            public final ModelGuildTemplate getGuildTemplate() {
                return this.guildTemplate;
            }

            public int hashCode() {
                ModelGuildTemplate modelGuildTemplate = this.guildTemplate;
                if (modelGuildTemplate != null) {
                    return modelGuildTemplate.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Resolved(guildTemplate=");
                sbM833U.append(this.guildTemplate);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private GuildTemplateState() {
        }

        public /* synthetic */ GuildTemplateState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Error.Type.values();
            int[] iArr = new int[18];
            $EnumSwitchMapping$0 = iArr;
            iArr[Error.Type.DISCORD_REQUEST_ERROR.ordinal()] = 1;
            iArr[Error.Type.NETWORK.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildTemplates$maybeInitTemplateState$1 */
    /* JADX INFO: compiled from: StoreGuildTemplates.kt */
    public static final class C60831 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $guildTemplateCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60831(String str) {
            super(0);
            this.$guildTemplateCode = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!StoreGuildTemplates.this.guildTemplatesByCode.containsKey(this.$guildTemplateCode) || (StoreGuildTemplates.this.guildTemplatesByCode.get(this.$guildTemplateCode) instanceof GuildTemplateState.LoadFailed)) {
                StoreGuildTemplates.this.guildTemplatesByCode.put(this.$guildTemplateCode, GuildTemplateState.Loading.INSTANCE);
                StoreGuildTemplates.this.markChanged();
                StoreGuildTemplates.this.requestGuildTemplate(this.$guildTemplateCode);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildTemplates$observeDynamicLinkGuildTemplateCode$1 */
    /* JADX INFO: compiled from: StoreGuildTemplates.kt */
    public static final class C60841 extends AbstractC12240o implements Function0<String> {
        public C60841() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return StoreGuildTemplates.this.dynamicLinkGuildTemplateCode;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildTemplates$observeGuildTemplate$1 */
    /* JADX INFO: compiled from: StoreGuildTemplates.kt */
    public static final class C60851 extends AbstractC12240o implements Function0<GuildTemplateState> {
        public final /* synthetic */ String $guildTemplateCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60851(String str) {
            super(0);
            this.$guildTemplateCode = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GuildTemplateState invoke() {
            GuildTemplateState guildTemplate = StoreGuildTemplates.this.getGuildTemplate(this.$guildTemplateCode);
            return guildTemplate != null ? guildTemplate : GuildTemplateState.Loading.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildTemplates$requestGuildTemplate$1 */
    /* JADX INFO: compiled from: StoreGuildTemplates.kt */
    public static final class C60861 extends AbstractC12240o implements Function1<ModelGuildTemplate, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildTemplates$requestGuildTemplate$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildTemplates.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ ModelGuildTemplate $guildTemplate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ModelGuildTemplate modelGuildTemplate) {
                super(0);
                this.$guildTemplate = modelGuildTemplate;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildTemplates.this.handleRequestGuildTemplateSuccess(this.$guildTemplate);
            }
        }

        public C60861() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGuildTemplate modelGuildTemplate) {
            invoke2(modelGuildTemplate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGuildTemplate modelGuildTemplate) {
            C12238m.checkNotNullParameter(modelGuildTemplate, "guildTemplate");
            StoreGuildTemplates.this.dispatcher.schedule(new AnonymousClass1(modelGuildTemplate));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildTemplates$requestGuildTemplate$2 */
    /* JADX INFO: compiled from: StoreGuildTemplates.kt */
    public static final class C60872 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ String $guildTemplateCode;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildTemplates$requestGuildTemplate$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildTemplates.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C60872 c60872 = C60872.this;
                StoreGuildTemplates storeGuildTemplates = StoreGuildTemplates.this;
                String str = c60872.$guildTemplateCode;
                Error.Type type = this.$error.getType();
                C12238m.checkNotNullExpressionValue(type, "error.type");
                storeGuildTemplates.handleRequestGuildTemplateError(str, type);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60872(String str) {
            super(1);
            this.$guildTemplateCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            StoreGuildTemplates.this.dispatcher.schedule(new AnonymousClass1(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildTemplates$setDynamicLinkGuildTemplateCode$1 */
    /* JADX INFO: compiled from: StoreGuildTemplates.kt */
    public static final class C60881 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $guildTemplateCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60881(String str) {
            super(0);
            this.$guildTemplateCode = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildTemplates.this.dynamicLinkGuildTemplateCode = this.$guildTemplateCode;
            StoreGuildTemplates.this.markChanged();
        }
    }

    public StoreGuildTemplates(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.guildTemplatesByCode = new LinkedHashMap();
        this.guildTemplatesByCodeSnapshot = C12136h0.emptyMap();
    }

    @StoreThread
    private final void handleRequestGuildTemplateError(String guildTemplateCode, Error.Type errorType) {
        int iOrdinal = errorType.ordinal();
        if (iOrdinal == 3) {
            this.guildTemplatesByCode.put(guildTemplateCode, GuildTemplateState.Invalid.INSTANCE);
            markChanged();
            AnalyticsTracker.guildTemplateResolveFailed(guildTemplateCode);
        } else {
            if (iOrdinal != 11) {
                return;
            }
            this.guildTemplatesByCode.put(guildTemplateCode, GuildTemplateState.LoadFailed.INSTANCE);
            markChanged();
        }
    }

    @StoreThread
    private final void handleRequestGuildTemplateSuccess(ModelGuildTemplate guildTemplate) {
        this.guildTemplatesByCode.put(guildTemplate.getCode(), new GuildTemplateState.Resolved(guildTemplate));
        markChanged();
        AnalyticsTracker.INSTANCE.guildTemplateResolved(guildTemplate);
    }

    private final void requestGuildTemplate(String guildTemplateCode) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGuildTemplateCode(guildTemplateCode), false, 1, null), (Class<?>) StoreGuildTemplates.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C60872(guildTemplateCode)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C60861());
    }

    public final void clearDynamicLinkGuildTemplateCode() {
        setDynamicLinkGuildTemplateCode(null);
    }

    public final String getDynamicLinkGuildTemplateCode() {
        return this.dynamicLinkGuildTemplateCode;
    }

    public final GuildTemplateState getGuildTemplate(String guildTemplateCode) {
        C12238m.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        return this.guildTemplatesByCodeSnapshot.get(guildTemplateCode);
    }

    public final void maybeInitTemplateState(String guildTemplateCode) {
        C12238m.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        this.dispatcher.schedule(new C60831(guildTemplateCode));
    }

    public final Observable<String> observeDynamicLinkGuildTemplateCode() {
        Observable<String> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60841(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<GuildTemplateState> observeGuildTemplate(String guildTemplateCode) {
        C12238m.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        Observable<GuildTemplateState> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60851(guildTemplateCode), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final void setDynamicLinkGuildTemplateCode(String guildTemplateCode) {
        this.dispatcher.schedule(new C60881(guildTemplateCode));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildTemplatesByCodeSnapshot = new HashMap(this.guildTemplatesByCode);
    }
}
