package com.discord.stores;

import com.discord.api.user.User;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGift;
import com.discord.restapi.RestAPIAbortCodes;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Dispatcher dispatcher;
    private HashMap<String, GiftState> knownGifts;
    private final BehaviorSubject<Map<String, GiftState>> knownGiftsSubject;

    /* JADX INFO: compiled from: StoreGifting.kt */
    public static final class Companion {
        private Companion() {
        }

        public final String makeComboId(long skuId, Long planId) {
            StringBuilder sb = new StringBuilder();
            sb.append(skuId);
            sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
            sb.append(planId);
            return sb.toString();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreGifting.kt */
    public static abstract class GiftState {

        /* JADX INFO: compiled from: StoreGifting.kt */
        public static final class Invalid extends GiftState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreGifting.kt */
        public static final class LoadFailed extends GiftState {
            public static final LoadFailed INSTANCE = new LoadFailed();

            private LoadFailed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreGifting.kt */
        public static final class Loading extends GiftState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreGifting.kt */
        public static final /* data */ class RedeemedFailed extends GiftState implements HasGift {
            private final boolean canRetry;
            private final Integer errorCode;
            private final ModelGift gift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RedeemedFailed(ModelGift modelGift, boolean z2, Integer num) {
                super(null);
                C12238m.checkNotNullParameter(modelGift, "gift");
                this.gift = modelGift;
                this.canRetry = z2;
                this.errorCode = num;
            }

            public static /* synthetic */ RedeemedFailed copy$default(RedeemedFailed redeemedFailed, ModelGift modelGift, boolean z2, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGift = redeemedFailed.getGift();
                }
                if ((i & 2) != 0) {
                    z2 = redeemedFailed.canRetry;
                }
                if ((i & 4) != 0) {
                    num = redeemedFailed.errorCode;
                }
                return redeemedFailed.copy(modelGift, z2, num);
            }

            public final ModelGift component1() {
                return getGift();
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getCanRetry() {
                return this.canRetry;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Integer getErrorCode() {
                return this.errorCode;
            }

            public final RedeemedFailed copy(ModelGift gift, boolean canRetry, Integer errorCode) {
                C12238m.checkNotNullParameter(gift, "gift");
                return new RedeemedFailed(gift, canRetry, errorCode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RedeemedFailed)) {
                    return false;
                }
                RedeemedFailed redeemedFailed = (RedeemedFailed) other;
                return C12238m.areEqual(getGift(), redeemedFailed.getGift()) && this.canRetry == redeemedFailed.canRetry && C12238m.areEqual(this.errorCode, redeemedFailed.errorCode);
            }

            public final boolean getCanRetry() {
                return this.canRetry;
            }

            public final Integer getErrorCode() {
                return this.errorCode;
            }

            @Override // com.discord.stores.StoreGifting.HasGift
            public ModelGift getGift() {
                return this.gift;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3 */
            /* JADX WARN: Type inference failed for: r2v4 */
            public int hashCode() {
                ModelGift gift = getGift();
                int iHashCode = (gift != null ? gift.hashCode() : 0) * 31;
                boolean z2 = this.canRetry;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode + r2) * 31;
                Integer num = this.errorCode;
                return i + (num != null ? num.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("RedeemedFailed(gift=");
                sbM833U.append(getGift());
                sbM833U.append(", canRetry=");
                sbM833U.append(this.canRetry);
                sbM833U.append(", errorCode=");
                return C1643a.m818F(sbM833U, this.errorCode, ")");
            }
        }

        /* JADX INFO: compiled from: StoreGifting.kt */
        public static final /* data */ class Redeeming extends GiftState implements HasGift {
            private final ModelGift gift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Redeeming(ModelGift modelGift) {
                super(null);
                C12238m.checkNotNullParameter(modelGift, "gift");
                this.gift = modelGift;
            }

            public static /* synthetic */ Redeeming copy$default(Redeeming redeeming, ModelGift modelGift, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGift = redeeming.getGift();
                }
                return redeeming.copy(modelGift);
            }

            public final ModelGift component1() {
                return getGift();
            }

            public final Redeeming copy(ModelGift gift) {
                C12238m.checkNotNullParameter(gift, "gift");
                return new Redeeming(gift);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Redeeming) && C12238m.areEqual(getGift(), ((Redeeming) other).getGift());
                }
                return true;
            }

            @Override // com.discord.stores.StoreGifting.HasGift
            public ModelGift getGift() {
                return this.gift;
            }

            public int hashCode() {
                ModelGift gift = getGift();
                if (gift != null) {
                    return gift.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Redeeming(gift=");
                sbM833U.append(getGift());
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: StoreGifting.kt */
        public static final /* data */ class Resolved extends GiftState implements HasGift {
            private final ModelGift gift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Resolved(ModelGift modelGift) {
                super(null);
                C12238m.checkNotNullParameter(modelGift, "gift");
                this.gift = modelGift;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, ModelGift modelGift, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGift = resolved.getGift();
                }
                return resolved.copy(modelGift);
            }

            public final ModelGift component1() {
                return getGift();
            }

            public final Resolved copy(ModelGift gift) {
                C12238m.checkNotNullParameter(gift, "gift");
                return new Resolved(gift);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && C12238m.areEqual(getGift(), ((Resolved) other).getGift());
                }
                return true;
            }

            @Override // com.discord.stores.StoreGifting.HasGift
            public ModelGift getGift() {
                return this.gift;
            }

            public int hashCode() {
                ModelGift gift = getGift();
                if (gift != null) {
                    return gift.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Resolved(gift=");
                sbM833U.append(getGift());
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: StoreGifting.kt */
        public static final /* data */ class Revoking extends GiftState implements HasGift {
            private final ModelGift gift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Revoking(ModelGift modelGift) {
                super(null);
                C12238m.checkNotNullParameter(modelGift, "gift");
                this.gift = modelGift;
            }

            public static /* synthetic */ Revoking copy$default(Revoking revoking, ModelGift modelGift, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGift = revoking.getGift();
                }
                return revoking.copy(modelGift);
            }

            public final ModelGift component1() {
                return getGift();
            }

            public final Revoking copy(ModelGift gift) {
                C12238m.checkNotNullParameter(gift, "gift");
                return new Revoking(gift);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Revoking) && C12238m.areEqual(getGift(), ((Revoking) other).getGift());
                }
                return true;
            }

            @Override // com.discord.stores.StoreGifting.HasGift
            public ModelGift getGift() {
                return this.gift;
            }

            public int hashCode() {
                ModelGift gift = getGift();
                if (gift != null) {
                    return gift.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Revoking(gift=");
                sbM833U.append(getGift());
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private GiftState() {
        }

        public /* synthetic */ GiftState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreGifting.kt */
    public interface HasGift {
        ModelGift getGift();
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            Error.Type.values();
            int[] iArr = new int[18];
            $EnumSwitchMapping$0 = iArr;
            Error.Type type = Error.Type.DISCORD_REQUEST_ERROR;
            iArr[type.ordinal()] = 1;
            Error.Type type2 = Error.Type.NETWORK;
            iArr[type2.ordinal()] = 2;
            Error.Type.values();
            int[] iArr2 = new int[18];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[type.ordinal()] = 1;
            iArr2[type2.ordinal()] = 2;
            Error.Type.values();
            int[] iArr3 = new int[18];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[type.ordinal()] = 1;
            iArr3[type2.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifting$acceptGift$1 */
    /* JADX INFO: compiled from: StoreGifting.kt */
    public static final class C59871 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ ModelGift $gift;

        /* JADX INFO: renamed from: com.discord.stores.StoreGifting$acceptGift$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifting.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreGifting$acceptGift$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreGifting.kt */
            public static final class C132531 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ Error $error;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C132531(Error error) {
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
                    if (this.$error.getType() != Error.Type.DISCORD_BAD_REQUEST) {
                        C59871 c59871 = C59871.this;
                        StoreGifting.this.setGifts(c59871.$gift.getCode(), new GiftState.RedeemedFailed(C59871.this.$gift, true, null));
                    }
                    this.$error.setShowErrorToasts(false);
                    Error.Response response = this.$error.getResponse();
                    C12238m.checkNotNullExpressionValue(response, "error.response");
                    switch (response.getCode()) {
                        case RestAPIAbortCodes.GIFTING_ALREADY_USED_ERROR_CODE /* 50050 */:
                            C59871 c59872 = C59871.this;
                            StoreGifting storeGifting = StoreGifting.this;
                            String code = c59872.$gift.getCode();
                            ModelGift modelGift = C59871.this.$gift;
                            storeGifting.setGifts(code, new GiftState.Resolved(modelGift.copy((2045 & 1) != 0 ? modelGift.skuId : 0L, (2045 & 2) != 0 ? modelGift.redeemed : false, (2045 & 4) != 0 ? modelGift.expiresAt : null, (2045 & 8) != 0 ? modelGift.code : null, (2045 & 16) != 0 ? modelGift.uses : modelGift.getMaxUses(), (2045 & 32) != 0 ? modelGift.storeListing : null, (2045 & 64) != 0 ? modelGift.maxUses : 0, (2045 & 128) != 0 ? modelGift.user : null, (2045 & 256) != 0 ? modelGift.subscriptionPlanId : null, (2045 & 512) != 0 ? modelGift.subscriptionPlan : null, (2045 & 1024) != 0 ? modelGift.giftStyle : null)));
                            break;
                        case RestAPIAbortCodes.GIFTING_ALREADY_OWNED_ERROR_CODE /* 50051 */:
                            C59871 c59873 = C59871.this;
                            StoreGifting storeGifting2 = StoreGifting.this;
                            String code2 = c59873.$gift.getCode();
                            ModelGift modelGift2 = C59871.this.$gift;
                            storeGifting2.setGifts(code2, new GiftState.Resolved(modelGift2.copy((2045 & 1) != 0 ? modelGift2.skuId : 0L, (2045 & 2) != 0 ? modelGift2.redeemed : true, (2045 & 4) != 0 ? modelGift2.expiresAt : null, (2045 & 8) != 0 ? modelGift2.code : null, (2045 & 16) != 0 ? modelGift2.uses : 0, (2045 & 32) != 0 ? modelGift2.storeListing : null, (2045 & 64) != 0 ? modelGift2.maxUses : 0, (2045 & 128) != 0 ? modelGift2.user : null, (2045 & 256) != 0 ? modelGift2.subscriptionPlanId : null, (2045 & 512) != 0 ? modelGift2.subscriptionPlan : null, (2045 & 1024) != 0 ? modelGift2.giftStyle : null)));
                            break;
                        default:
                            C59871 c59874 = C59871.this;
                            StoreGifting storeGifting3 = StoreGifting.this;
                            String code3 = c59874.$gift.getCode();
                            ModelGift modelGift3 = C59871.this.$gift;
                            Error.Response response2 = this.$error.getResponse();
                            C12238m.checkNotNullExpressionValue(response2, "error.response");
                            storeGifting3.setGifts(code3, new GiftState.RedeemedFailed(modelGift3, false, Integer.valueOf(response2.getCode())));
                            break;
                    }
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                C12238m.checkNotNullParameter(error, "error");
                StoreGifting.this.getDispatcher().schedule(new C132531(error));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreGifting$acceptGift$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifting.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Void, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreGifting$acceptGift$1$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreGifting.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C59871 c59871 = C59871.this;
                    StoreGifting storeGifting = StoreGifting.this;
                    String code = c59871.$gift.getCode();
                    ModelGift modelGift = C59871.this.$gift;
                    storeGifting.setGifts(code, new GiftState.Resolved(modelGift.copy((2045 & 1) != 0 ? modelGift.skuId : 0L, (2045 & 2) != 0 ? modelGift.redeemed : true, (2045 & 4) != 0 ? modelGift.expiresAt : null, (2045 & 8) != 0 ? modelGift.code : null, (2045 & 16) != 0 ? modelGift.uses : 0, (2045 & 32) != 0 ? modelGift.storeListing : null, (2045 & 64) != 0 ? modelGift.maxUses : 0, (2045 & 128) != 0 ? modelGift.user : null, (2045 & 256) != 0 ? modelGift.subscriptionPlanId : null, (2045 & 512) != 0 ? modelGift.subscriptionPlan : null, (2045 & 1024) != 0 ? modelGift.giftStyle : null)));
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r2) {
                StoreGifting.this.getDispatcher().schedule(new AnonymousClass1());
                StoreStream.INSTANCE.getLibrary().fetchApplications();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59871(ModelGift modelGift) {
            super(0);
            this.$gift = modelGift;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifting.this.setGifts(this.$gift.getCode(), new GiftState.Redeeming(this.$gift));
            Observable<Void> observableM11098X = RestAPI.INSTANCE.getApi().acceptGift(this.$gift.getCode()).m11098X(C12781a.m10875c());
            C12238m.checkNotNullExpressionValue(observableM11098X, "RestAPI\n        .api\n   …scribeOn(Schedulers.io())");
            ObservableExtensionsKt.appSubscribe(observableM11098X, (Class<?>) StoreGifting.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass2());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifting$fetchGift$1 */
    /* JADX INFO: compiled from: StoreGifting.kt */
    public static final class C59881 extends AbstractC12240o implements Function1<ModelGift, Unit> {
        public final /* synthetic */ String $giftCode;

        /* JADX INFO: renamed from: com.discord.stores.StoreGifting$fetchGift$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifting.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ ModelGift $gift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ModelGift modelGift) {
                super(0);
                this.$gift = modelGift;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnalyticsTracker.INSTANCE.giftResolved(this.$gift);
                C59881 c59881 = C59881.this;
                StoreGifting.this.setGifts(c59881.$giftCode, new GiftState.Resolved(this.$gift));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59881(String str) {
            super(1);
            this.$giftCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGift modelGift) {
            invoke2(modelGift);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGift modelGift) {
            C12238m.checkNotNullParameter(modelGift, "gift");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(modelGift));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifting$fetchGift$2 */
    /* JADX INFO: compiled from: StoreGifting.kt */
    public static final class C59892 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ String $giftCode;

        /* JADX INFO: renamed from: com.discord.stores.StoreGifting$fetchGift$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifting.kt */
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
                AnalyticsTracker.INSTANCE.giftResolvedFailed(C59892.this.$giftCode);
                int iOrdinal = this.$error.getType().ordinal();
                if (iOrdinal == 3) {
                    this.$error.setShowErrorToasts(false);
                    C59892 c59892 = C59892.this;
                    StoreGifting.this.setGifts(c59892.$giftCode, GiftState.Invalid.INSTANCE);
                } else if (iOrdinal != 11) {
                    C59892 c59893 = C59892.this;
                    StoreGifting.this.setGifts(c59893.$giftCode, GiftState.LoadFailed.INSTANCE);
                } else {
                    C59892 c59894 = C59892.this;
                    StoreGifting.this.setGifts(c59894.$giftCode, GiftState.LoadFailed.INSTANCE);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59892(String str) {
            super(1);
            this.$giftCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifting$fetchMyGiftsForSku$1 */
    /* JADX INFO: compiled from: StoreGifting.kt */
    public static final class C59901 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $comboId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59901(String str) {
            super(0);
            this.$comboId = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifting.this.setGifts(this.$comboId, GiftState.Loading.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifting$fetchMyGiftsForSku$2 */
    /* JADX INFO: compiled from: StoreGifting.kt */
    public static final class C59912 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ String $comboId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGifting$fetchMyGiftsForSku$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifting.kt */
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
                int iOrdinal = this.$error.getType().ordinal();
                if (iOrdinal == 3) {
                    this.$error.setShowErrorToasts(false);
                    C59912 c59912 = C59912.this;
                    StoreGifting.this.setGifts(c59912.$comboId, GiftState.Invalid.INSTANCE);
                } else if (iOrdinal == 11) {
                    C59912 c59913 = C59912.this;
                    StoreGifting.this.setGifts(c59913.$comboId, GiftState.LoadFailed.INSTANCE);
                } else {
                    Logger.e$default(AppLog.f14950g, "Fetching Gift Error", new Exception(String.valueOf(this.$error.getType())), null, 4, null);
                    C59912 c59914 = C59912.this;
                    StoreGifting.this.setGifts(c59914.$comboId, GiftState.LoadFailed.INSTANCE);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59912(String str) {
            super(1);
            this.$comboId = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifting$fetchMyGiftsForSku$3 */
    /* JADX INFO: compiled from: StoreGifting.kt */
    public static final class C59923 extends AbstractC12240o implements Function1<List<? extends ModelGift>, Unit> {
        public final /* synthetic */ String $comboId;
        public final /* synthetic */ Long $planId;
        public final /* synthetic */ long $skuId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGifting$fetchMyGiftsForSku$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifting.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ List $gifts;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$gifts = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C59923 c59923 = C59923.this;
                StoreGifting.this.removeGiftCode(c59923.$comboId);
                C59923 c59924 = C59923.this;
                StoreGifting.this.clearGiftsForSku(c59924.$skuId, c59924.$planId);
                for (ModelGift modelGift : this.$gifts) {
                    StoreGifting.this.setGifts(modelGift.getCode(), new GiftState.Resolved(modelGift));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59923(String str, long j, Long l) {
            super(1);
            this.$comboId = str;
            this.$skuId = j;
            this.$planId = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGift> list) {
            invoke2((List<ModelGift>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelGift> list) {
            C12238m.checkNotNullParameter(list, "gifts");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifting$generateGiftCode$1 */
    /* JADX INFO: compiled from: StoreGifting.kt */
    public static final class C59931 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $comboId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59931(String str) {
            super(0);
            this.$comboId = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifting.this.setGifts(this.$comboId, GiftState.Loading.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifting$generateGiftCode$2 */
    /* JADX INFO: compiled from: StoreGifting.kt */
    public static final class C59942 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ String $comboId;
        public final /* synthetic */ Function1 $onError;

        /* JADX INFO: renamed from: com.discord.stores.StoreGifting$generateGiftCode$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifting.kt */
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
                int iOrdinal = this.$error.getType().ordinal();
                if (iOrdinal == 3) {
                    this.$error.setShowErrorToasts(false);
                    C59942 c59942 = C59942.this;
                    StoreGifting.this.setGifts(c59942.$comboId, GiftState.Invalid.INSTANCE);
                } else if (iOrdinal != 11) {
                    Logger.e$default(AppLog.f14950g, "Generate Gift Code Error", new Exception(String.valueOf(this.$error.getType())), null, 4, null);
                    C59942 c59943 = C59942.this;
                    StoreGifting.this.setGifts(c59943.$comboId, GiftState.LoadFailed.INSTANCE);
                } else {
                    C59942 c59944 = C59942.this;
                    StoreGifting.this.setGifts(c59944.$comboId, GiftState.LoadFailed.INSTANCE);
                }
                C59942 c59945 = C59942.this;
                StoreGifting.this.setGifts(c59945.$comboId, GiftState.LoadFailed.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59942(String str, Function1 function1) {
            super(1);
            this.$comboId = str;
            this.$onError = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(error));
            Function1 function1 = this.$onError;
            if (function1 != null) {
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifting$generateGiftCode$3 */
    /* JADX INFO: compiled from: StoreGifting.kt */
    public static final class C59953 extends AbstractC12240o implements Function1<ModelGift, Unit> {
        public final /* synthetic */ String $comboId;
        public final /* synthetic */ Function1 $onSuccess;

        /* JADX INFO: renamed from: com.discord.stores.StoreGifting$generateGiftCode$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifting.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ ModelGift $newGift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ModelGift modelGift) {
                super(0);
                this.$newGift = modelGift;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C59953 c59953 = C59953.this;
                StoreGifting.this.removeGiftCode(c59953.$comboId);
                StoreGifting.this.setGifts(this.$newGift.getCode(), new GiftState.Resolved(this.$newGift));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59953(String str, Function1 function1) {
            super(1);
            this.$comboId = str;
            this.$onSuccess = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGift modelGift) {
            invoke2(modelGift);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGift modelGift) {
            C12238m.checkNotNullParameter(modelGift, "newGift");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(modelGift));
            Function1 function1 = this.$onSuccess;
            if (function1 != null) {
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifting$requestGift$1 */
    /* JADX INFO: compiled from: StoreGifting.kt */
    public static final class C59971 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $giftCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59971(String str) {
            super(0);
            this.$giftCode = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifting.this.fetchGift(this.$giftCode);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifting$revokeGiftCode$1 */
    /* JADX INFO: compiled from: StoreGifting.kt */
    public static final class C59991 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ ModelGift $gift;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59991(ModelGift modelGift) {
            super(0);
            this.$gift = modelGift;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifting.this.setGifts(this.$gift.getCode(), new GiftState.Revoking(this.$gift));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifting$revokeGiftCode$2 */
    /* JADX INFO: compiled from: StoreGifting.kt */
    public static final class C60002 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ ModelGift $gift;

        /* JADX INFO: renamed from: com.discord.stores.StoreGifting$revokeGiftCode$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifting.kt */
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
                Logger.e$default(AppLog.f14950g, "Revoking Gift Error", new Exception(String.valueOf(this.$error.getType())), null, 4, null);
                C60002 c60002 = C60002.this;
                StoreGifting.this.setGifts(c60002.$gift.getCode(), new GiftState.Resolved(C60002.this.$gift));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60002(ModelGift modelGift) {
            super(1);
            this.$gift = modelGift;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGifting$revokeGiftCode$3 */
    /* JADX INFO: compiled from: StoreGifting.kt */
    public static final class C60013 extends AbstractC12240o implements Function1<Void, Unit> {
        public final /* synthetic */ ModelGift $gift;

        /* JADX INFO: renamed from: com.discord.stores.StoreGifting$revokeGiftCode$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGifting.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C60013 c60013 = C60013.this;
                StoreGifting.this.removeGiftCode(c60013.$gift.getCode());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60013(ModelGift modelGift) {
            super(1);
            this.$gift = modelGift;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1());
        }
    }

    public StoreGifting(Dispatcher dispatcher) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.knownGifts = new HashMap<>();
        this.knownGiftsSubject = BehaviorSubject.m11130l0(C12136h0.emptyMap());
    }

    @StoreThread
    private final void clearGiftsForSku(long skuId, Long subscriptionPlanId) {
        HashMap<String, GiftState> map = this.knownGifts;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, GiftState> entry : map.entrySet()) {
            GiftState value = entry.getValue();
            boolean z2 = true;
            if (value instanceof GiftState.Resolved) {
                GiftState.Resolved resolved = (GiftState.Resolved) value;
                if (resolved.getGift().getSkuId() == skuId && subscriptionPlanId != null && !(!C12238m.areEqual(resolved.getGift().getSubscriptionPlanId(), subscriptionPlanId))) {
                    z2 = false;
                }
            }
            if (z2) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        this.knownGifts = new HashMap<>(linkedHashMap);
        this.knownGiftsSubject.onNext(new HashMap(this.knownGifts));
    }

    @StoreThread
    private final void fetchGift(String giftCode) {
        if (this.knownGifts.containsKey(giftCode) && !(this.knownGifts.get(giftCode) instanceof GiftState.LoadFailed)) {
            if (!(this.knownGifts.get(giftCode) instanceof GiftState.Resolved)) {
                return;
            }
            GiftState giftState = this.knownGifts.get(giftCode);
            Objects.requireNonNull(giftState, "null cannot be cast to non-null type com.discord.stores.StoreGifting.GiftState.Resolved");
            if (((GiftState.Resolved) giftState).getGift().isComplete()) {
                return;
            }
        }
        setGifts(giftCode, GiftState.Loading.INSTANCE);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().resolveGiftCode(giftCode, true, true), false, 1, null), (Class<?>) StoreGifting.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C59892(giftCode)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C59881(giftCode));
    }

    @StoreThread
    private final void removeGiftCode(String code) {
        this.knownGifts.remove(code);
        this.knownGiftsSubject.onNext(new HashMap(this.knownGifts));
    }

    @StoreThread
    private final void setGifts(String code, GiftState giftState) {
        this.knownGifts.put(code, giftState);
        this.knownGiftsSubject.onNext(new HashMap(this.knownGifts));
    }

    public final void acceptGift(ModelGift gift) {
        C12238m.checkNotNullParameter(gift, "gift");
        this.dispatcher.schedule(new C59871(gift));
    }

    public final void fetchMyGiftsForSku(long skuId, Long planId) {
        String strMakeComboId = INSTANCE.makeComboId(skuId, planId);
        if (!this.knownGifts.containsKey(strMakeComboId) || (this.knownGifts.get(strMakeComboId) instanceof GiftState.LoadFailed)) {
            this.dispatcher.schedule(new C59901(strMakeComboId));
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().resolveSkuIdGift(skuId, planId), false, 1, null), (Class<?>) StoreGifting.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C59912(strMakeComboId)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C59923(strMakeComboId, skuId, planId));
        }
    }

    public final void generateGiftCode(long skuId, Long planId, Function1<? super ModelGift, Unit> onSuccess, Function1<? super Error, Unit> onError) {
        String strMakeComboId = INSTANCE.makeComboId(skuId, planId);
        if (this.knownGifts.get(strMakeComboId) instanceof GiftState.Loading) {
            return;
        }
        this.dispatcher.schedule(new C59931(strMakeComboId));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().generateGiftCode(new RestAPIParams.GenerateGiftCode(skuId, planId)), false, 1, null), (Class<?>) StoreGifting.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C59942(strMakeComboId, onError)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C59953(strMakeComboId, onSuccess));
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final HashMap<String, GiftState> getKnownGifts() {
        return this.knownGifts;
    }

    public final Observable<List<ModelGift>> getMyResolvedGifts(final long userId) {
        Observable observableM11083G = this.knownGiftsSubject.m11083G(new InterfaceC12589b<Map<String, ? extends GiftState>, List<? extends ModelGift>>() { // from class: com.discord.stores.StoreGifting.getMyResolvedGifts.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final List<ModelGift> call(Map<String, ? extends GiftState> map) {
                User user;
                Collection<? extends GiftState> collectionValues = map.values();
                ArrayList<GiftState> arrayList = new ArrayList();
                for (T t : collectionValues) {
                    GiftState giftState = (GiftState) t;
                    if ((giftState instanceof GiftState.Resolved) && (user = ((GiftState.Resolved) giftState).getGift().getUser()) != null && user.getId() == userId) {
                        arrayList.add(t);
                    }
                }
                ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
                for (GiftState giftState2 : arrayList) {
                    Objects.requireNonNull(giftState2, "null cannot be cast to non-null type com.discord.stores.StoreGifting.GiftState.Resolved");
                    arrayList2.add(((GiftState.Resolved) giftState2).getGift());
                }
                return arrayList2;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "knownGiftsSubject\n      …              }\n        }");
        return observableM11083G;
    }

    @StoreThread
    public final void handlePreLogout() {
        this.knownGifts.clear();
    }

    public final Observable<GiftState> requestGift(final String giftCode) {
        C12238m.checkNotNullParameter(giftCode, "giftCode");
        this.dispatcher.schedule(new C59971(giftCode));
        Observable<GiftState> observableM11112r = this.knownGiftsSubject.m11083G(new InterfaceC12589b<Map<String, ? extends GiftState>, GiftState>() { // from class: com.discord.stores.StoreGifting.requestGift.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final GiftState call(Map<String, ? extends GiftState> map) {
                GiftState giftState = map.get(giftCode);
                return giftState != null ? giftState : GiftState.Loading.INSTANCE;
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "knownGiftsSubject\n      …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final void revokeGiftCode(ModelGift gift) {
        C12238m.checkNotNullParameter(gift, "gift");
        if (this.knownGifts.containsKey(gift.getCode()) && (this.knownGifts.get(gift.getCode()) instanceof GiftState.Revoking)) {
            return;
        }
        this.dispatcher.schedule(new C59991(gift));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().revokeGiftCode(gift.getCode()), false, 1, null), (Class<?>) StoreGifting.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C60002(gift)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C60013(gift));
    }

    public final void setKnownGifts(HashMap<String, GiftState> map) {
        C12238m.checkNotNullParameter(map, "<set-?>");
        this.knownGifts = map;
    }
}
