package com.discord.stores;

import b.d.b.a.outline;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

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
                Intrinsics3.checkNotNullParameter(modelGuildTemplate, "guildTemplate");
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
                Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
                return new Resolved(guildTemplate);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && Intrinsics3.areEqual(this.guildTemplate, ((Resolved) other).guildTemplate);
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
                StringBuilder sbU = outline.U("Resolved(guildTemplate=");
                sbU.append(this.guildTemplate);
                sbU.append(")");
                return sbU.toString();
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

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildTemplates$maybeInitTemplateState$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildTemplates.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $guildTemplateCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$guildTemplateCode = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
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

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildTemplates$observeDynamicLinkGuildTemplateCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildTemplates.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<String> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return StoreGuildTemplates.this.dynamicLinkGuildTemplateCode;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildTemplates$observeGuildTemplate$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildTemplates.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<GuildTemplateState> {
        public final /* synthetic */ String $guildTemplateCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildTemplates$requestGuildTemplate$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildTemplates.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelGuildTemplate, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildTemplates$requestGuildTemplate$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreGuildTemplates.kt */
        public static final class C01331 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ModelGuildTemplate $guildTemplate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01331(ModelGuildTemplate modelGuildTemplate) {
                super(0);
                this.$guildTemplate = modelGuildTemplate;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildTemplates.this.handleRequestGuildTemplateSuccess(this.$guildTemplate);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGuildTemplate modelGuildTemplate) {
            invoke2(modelGuildTemplate);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGuildTemplate modelGuildTemplate) {
            Intrinsics3.checkNotNullParameter(modelGuildTemplate, "guildTemplate");
            StoreGuildTemplates.this.dispatcher.schedule(new C01331(modelGuildTemplate));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildTemplates$requestGuildTemplate$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildTemplates.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $guildTemplateCode;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildTemplates$requestGuildTemplate$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildTemplates.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StoreGuildTemplates storeGuildTemplates = StoreGuildTemplates.this;
                String str = anonymousClass2.$guildTemplateCode;
                Error.Type type = this.$error.getType();
                Intrinsics3.checkNotNullExpressionValue(type, "error.type");
                storeGuildTemplates.handleRequestGuildTemplateError(str, type);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$guildTemplateCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            StoreGuildTemplates.this.dispatcher.schedule(new AnonymousClass1(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildTemplates$setDynamicLinkGuildTemplateCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildTemplates.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $guildTemplateCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$guildTemplateCode = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildTemplates.this.dynamicLinkGuildTemplateCode = this.$guildTemplateCode;
            StoreGuildTemplates.this.markChanged();
        }
    }

    public StoreGuildTemplates(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.guildTemplatesByCode = new LinkedHashMap();
        this.guildTemplatesByCodeSnapshot = Maps6.emptyMap();
    }

    @Store3
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

    @Store3
    private final void handleRequestGuildTemplateSuccess(ModelGuildTemplate guildTemplate) {
        this.guildTemplatesByCode.put(guildTemplate.getCode(), new GuildTemplateState.Resolved(guildTemplate));
        markChanged();
        AnalyticsTracker.INSTANCE.guildTemplateResolved(guildTemplate);
    }

    private final void requestGuildTemplate(String guildTemplateCode) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGuildTemplateCode(guildTemplateCode), false, 1, null), (Class<?>) StoreGuildTemplates.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2(guildTemplateCode)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final void clearDynamicLinkGuildTemplateCode() {
        setDynamicLinkGuildTemplateCode(null);
    }

    public final String getDynamicLinkGuildTemplateCode() {
        return this.dynamicLinkGuildTemplateCode;
    }

    public final GuildTemplateState getGuildTemplate(String guildTemplateCode) {
        Intrinsics3.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        return this.guildTemplatesByCodeSnapshot.get(guildTemplateCode);
    }

    public final void maybeInitTemplateState(String guildTemplateCode) {
        Intrinsics3.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        this.dispatcher.schedule(new AnonymousClass1(guildTemplateCode));
    }

    public final Observable<String> observeDynamicLinkGuildTemplateCode() {
        Observable<String> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<GuildTemplateState> observeGuildTemplate(String guildTemplateCode) {
        Intrinsics3.checkNotNullParameter(guildTemplateCode, "guildTemplateCode");
        Observable<GuildTemplateState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildTemplateCode), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void setDynamicLinkGuildTemplateCode(String guildTemplateCode) {
        this.dispatcher.schedule(new AnonymousClass1(guildTemplateCode));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildTemplatesByCodeSnapshot = new HashMap(this.guildTemplatesByCode);
    }
}
