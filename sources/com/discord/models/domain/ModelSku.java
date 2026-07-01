package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.api.application.Application;
import com.discord.api.premium.PremiumTier;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelSku;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelSku.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelSku {
    private final Application application;
    private final long applicationId;
    private final Map<Integer, ExternalSkuStrategy> externalSkuStrategies;
    private final int flags;
    private final long id;
    private final String name;
    private final boolean premium;
    private final Price price;
    private final int type;

    /* JADX INFO: compiled from: ModelSku.kt */
    public static final /* data */ class ExternalSkuStrategy {
        private final int type;

        public ExternalSkuStrategy(int i) {
            this.type = i;
        }

        public static /* synthetic */ ExternalSkuStrategy copy$default(ExternalSkuStrategy externalSkuStrategy, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = externalSkuStrategy.type;
            }
            return externalSkuStrategy.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public final ExternalSkuStrategy copy(int type) {
            return new ExternalSkuStrategy(type);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ExternalSkuStrategy) && this.type == ((ExternalSkuStrategy) other).type;
            }
            return true;
        }

        public final int getType() {
            return this.type;
        }

        public int hashCode() {
            return this.type;
        }

        public String toString() {
            return outline.B(outline.U("ExternalSkuStrategy(type="), this.type, ")");
        }

        /* JADX INFO: renamed from: getType, reason: collision with other method in class */
        public final ExternalStrategyTypes m6getType() {
            return ExternalStrategyTypes.INSTANCE.from(this.type);
        }
    }

    /* JADX INFO: compiled from: ModelSku.kt */
    public enum ExternalStrategyTypes {
        CONSTANT(1),
        APPLE(2),
        GOOGLE(3),
        UNKNOWN(null);


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Integer intRepresentation;

        /* JADX INFO: compiled from: ModelSku.kt */
        public static final class Companion {
            private Companion() {
            }

            /* JADX WARN: Code duplicated, block: B:18:0x0025  */
            /* JADX WARN: Code duplicated, block: B:22:? A[RETURN, SYNTHETIC] */
            public final ExternalStrategyTypes from(int externalStrategyInt) {
                ExternalStrategyTypes externalStrategyTypes;
                ExternalStrategyTypes[] externalStrategyTypesArrValues = ExternalStrategyTypes.values();
                for (int i = 0; i < 4; i++) {
                    externalStrategyTypes = externalStrategyTypesArrValues[i];
                    Integer intRepresentation = externalStrategyTypes.getIntRepresentation();
                    if (intRepresentation != null && intRepresentation.intValue() == externalStrategyInt) {
                        if (externalStrategyTypes != null) {
                            return externalStrategyTypes;
                        }
                        return ExternalStrategyTypes.UNKNOWN;
                    }
                }
                externalStrategyTypes = null;
                if (externalStrategyTypes != null) {
                    return externalStrategyTypes;
                }
                return ExternalStrategyTypes.UNKNOWN;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        ExternalStrategyTypes(Integer num) {
            this.intRepresentation = num;
        }

        public final Integer getIntRepresentation() {
            return this.intRepresentation;
        }
    }

    /* JADX INFO: compiled from: ModelSku.kt */
    public static final /* data */ class ModelPremiumSkuPrice {
        private final int amount;
        private final int percentage;

        public ModelPremiumSkuPrice(int i, int i2) {
            this.amount = i;
            this.percentage = i2;
        }

        public static /* synthetic */ ModelPremiumSkuPrice copy$default(ModelPremiumSkuPrice modelPremiumSkuPrice, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = modelPremiumSkuPrice.amount;
            }
            if ((i3 & 2) != 0) {
                i2 = modelPremiumSkuPrice.percentage;
            }
            return modelPremiumSkuPrice.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getAmount() {
            return this.amount;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getPercentage() {
            return this.percentage;
        }

        public final ModelPremiumSkuPrice copy(int amount, int percentage) {
            return new ModelPremiumSkuPrice(amount, percentage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModelPremiumSkuPrice)) {
                return false;
            }
            ModelPremiumSkuPrice modelPremiumSkuPrice = (ModelPremiumSkuPrice) other;
            return this.amount == modelPremiumSkuPrice.amount && this.percentage == modelPremiumSkuPrice.percentage;
        }

        public final int getAmount() {
            return this.amount;
        }

        public final int getPercentage() {
            return this.percentage;
        }

        public int hashCode() {
            return (this.amount * 31) + this.percentage;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ModelPremiumSkuPrice(amount=");
            sbU.append(this.amount);
            sbU.append(", percentage=");
            return outline.B(sbU, this.percentage, ")");
        }
    }

    /* JADX INFO: compiled from: ModelSku.kt */
    public static final class Parser implements Model.Parser<ModelSku> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelSku parse(final Model.JsonReader reader) throws IOException {
            final Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            final Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
            ref$ObjectRef4.element = null;
            final Ref$ObjectRef ref$ObjectRef5 = new Ref$ObjectRef();
            ref$ObjectRef5.element = null;
            final Ref$ObjectRef ref$ObjectRef6 = new Ref$ObjectRef();
            ref$ObjectRef6.element = null;
            final Ref$ObjectRef ref$ObjectRef7 = new Ref$ObjectRef();
            ref$ObjectRef7.element = null;
            reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.ModelSku$Parser$parse$1
                /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                @Override // rx.functions.Action1
                public final void call(String str) throws IOException {
                    if (str != null) {
                        switch (str.hashCode()) {
                            case -1287148950:
                                if (str.equals(ModelAuditLogEntry.CHANGE_KEY_APPLICATION_ID)) {
                                    ref$ObjectRefC0.element = (T) reader.nextLongOrNull();
                                    return;
                                }
                                break;
                            case -318452137:
                                if (str.equals("premium")) {
                                    ref$ObjectRef4.element = (T) reader.nextBooleanOrNull();
                                    return;
                                }
                                break;
                            case 3355:
                                if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                                    ref$ObjectRef2.element = (T) reader.nextLongOrNull();
                                    return;
                                }
                                break;
                            case 3373707:
                                if (str.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                                    ref$ObjectRef.element = (T) reader.nextStringOrNull();
                                    return;
                                }
                                break;
                            case 3575610:
                                if (str.equals("type")) {
                                    ref$ObjectRef5.element = (T) reader.nextIntOrNull();
                                    return;
                                }
                                break;
                            case 97513095:
                                if (str.equals("flags")) {
                                    ref$ObjectRef7.element = (T) reader.nextIntOrNull();
                                    return;
                                }
                                break;
                            case 106934601:
                                if (str.equals("price")) {
                                    ref$ObjectRef6.element = (T) ModelSku.Price.Parser.INSTANCE.parse(reader);
                                    return;
                                }
                                break;
                            case 1554253136:
                                if (str.equals("application")) {
                                    ref$ObjectRef3.element = (T) ((Application) InboundGatewayGsonParser.fromJson(reader, Application.class));
                                    return;
                                }
                                break;
                        }
                    }
                    reader.skipValue();
                }
            });
            Long l = (Long) ref$ObjectRefC0.element;
            long jLongValue = l != null ? l.longValue() : 0L;
            String str = (String) ref$ObjectRef.element;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            Long l2 = (Long) ref$ObjectRef2.element;
            long jLongValue2 = l2 != null ? l2.longValue() : 0L;
            Application application = (Application) ref$ObjectRef3.element;
            Boolean bool = (Boolean) ref$ObjectRef4.element;
            Intrinsics3.checkNotNull(bool);
            boolean zBooleanValue = bool.booleanValue();
            Integer num = (Integer) ref$ObjectRef5.element;
            Intrinsics3.checkNotNull(num);
            int iIntValue = num.intValue();
            Price price = (Price) ref$ObjectRef6.element;
            Integer num2 = (Integer) ref$ObjectRef7.element;
            Intrinsics3.checkNotNull(num2);
            return new ModelSku(jLongValue, str2, jLongValue2, application, zBooleanValue, iIntValue, price, num2.intValue(), null);
        }
    }

    /* JADX INFO: compiled from: ModelSku.kt */
    public static final /* data */ class Price {
        private final int amount;
        private final String currency;
        private final Map<PremiumTier, ModelPremiumSkuPrice> premium;

        /* JADX INFO: compiled from: ModelSku.kt */
        public static final class Parser implements Model.Parser<Price> {
            public static final Parser INSTANCE = new Parser();

            private Parser() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.discord.models.domain.Model.Parser
            public Price parse(final Model.JsonReader reader) throws IOException {
                final Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
                ref$ObjectRefC0.element = null;
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = null;
                reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.ModelSku$Price$Parser$parse$1
                    @Override // rx.functions.Action1
                    public final void call(String str) throws IOException {
                        if (str != null) {
                            int iHashCode = str.hashCode();
                            if (iHashCode != -1413853096) {
                                if (iHashCode == 575402001 && str.equals("currency")) {
                                    ref$ObjectRef.element = (T) reader.nextStringOrNull();
                                    return;
                                }
                            } else if (str.equals("amount")) {
                                ref$ObjectRefC0.element = (T) reader.nextIntOrNull();
                                return;
                            }
                        }
                        reader.skipValue();
                    }
                });
                Integer num = (Integer) ref$ObjectRefC0.element;
                int iIntValue = num != null ? num.intValue() : -1;
                String str = (String) ref$ObjectRef.element;
                if (str == null) {
                    str = "";
                }
                return new Price(iIntValue, str, null, 4, null);
            }
        }

        public Price(int i, String str, Map<PremiumTier, ModelPremiumSkuPrice> map) {
            Intrinsics3.checkNotNullParameter(str, "currency");
            this.amount = i;
            this.currency = str;
            this.premium = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Price copy$default(Price price, int i, String str, Map map, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = price.amount;
            }
            if ((i2 & 2) != 0) {
                str = price.currency;
            }
            if ((i2 & 4) != 0) {
                map = price.premium;
            }
            return price.copy(i, str, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getAmount() {
            return this.amount;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCurrency() {
            return this.currency;
        }

        public final Map<PremiumTier, ModelPremiumSkuPrice> component3() {
            return this.premium;
        }

        public final Price copy(int amount, String currency, Map<PremiumTier, ModelPremiumSkuPrice> premium) {
            Intrinsics3.checkNotNullParameter(currency, "currency");
            return new Price(amount, currency, premium);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Price)) {
                return false;
            }
            Price price = (Price) other;
            return this.amount == price.amount && Intrinsics3.areEqual(this.currency, price.currency) && Intrinsics3.areEqual(this.premium, price.premium);
        }

        public final int getAmount() {
            return this.amount;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final Map<PremiumTier, ModelPremiumSkuPrice> getPremium() {
            return this.premium;
        }

        public int hashCode() {
            int i = this.amount * 31;
            String str = this.currency;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            Map<PremiumTier, ModelPremiumSkuPrice> map = this.premium;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Price(amount=");
            sbU.append(this.amount);
            sbU.append(", currency=");
            sbU.append(this.currency);
            sbU.append(", premium=");
            return outline.M(sbU, this.premium, ")");
        }

        public /* synthetic */ Price(int i, String str, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, (i2 & 4) != 0 ? null : map);
        }
    }

    /* JADX INFO: compiled from: ModelSku.kt */
    public enum SkuCategory {
        GAME,
        NITRO,
        NITRO_CLASSIC
    }

    public ModelSku(long j, String str, long j2, Application application, boolean z2, int i, Price price, int i2, Map<Integer, ExternalSkuStrategy> map) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.applicationId = j;
        this.name = str;
        this.id = j2;
        this.application = application;
        this.premium = z2;
        this.type = i;
        this.price = price;
        this.flags = i2;
        this.externalSkuStrategies = map;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getPremium() {
        return this.premium;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Price getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    public final Map<Integer, ExternalSkuStrategy> component9() {
        return this.externalSkuStrategies;
    }

    public final ModelSku copy(long applicationId, String name, long id2, Application application, boolean premium, int type, Price price, int flags, Map<Integer, ExternalSkuStrategy> externalSkuStrategies) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ModelSku(applicationId, name, id2, application, premium, type, price, flags, externalSkuStrategies);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSku)) {
            return false;
        }
        ModelSku modelSku = (ModelSku) other;
        return this.applicationId == modelSku.applicationId && Intrinsics3.areEqual(this.name, modelSku.name) && this.id == modelSku.id && Intrinsics3.areEqual(this.application, modelSku.application) && this.premium == modelSku.premium && this.type == modelSku.type && Intrinsics3.areEqual(this.price, modelSku.price) && this.flags == modelSku.flags && Intrinsics3.areEqual(this.externalSkuStrategies, modelSku.externalSkuStrategies);
    }

    public final Application getApplication() {
        return this.application;
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final Map<Integer, ExternalSkuStrategy> getExternalSkuStrategies() {
        return this.externalSkuStrategies;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getPremium() {
        return this.premium;
    }

    public final Price getPrice() {
        return this.price;
    }

    public final SkuCategory getSkuCategory() {
        long j = this.id;
        if (j == ModelSku4.PREMIUM_TIER_1_SKU_ID) {
            return SkuCategory.NITRO_CLASSIC;
        }
        return j == ModelSku4.PREMIUM_TIER_2_SKU_ID ? SkuCategory.NITRO : SkuCategory.GAME;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    public int hashCode() {
        long j = this.applicationId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j2 = this.id;
        int i2 = (((i + iHashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Application application = this.application;
        int iHashCode2 = (i2 + (application != null ? application.hashCode() : 0)) * 31;
        boolean z2 = this.premium;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i3 = (((iHashCode2 + r0) * 31) + this.type) * 31;
        Price price = this.price;
        int iHashCode3 = (((i3 + (price != null ? price.hashCode() : 0)) * 31) + this.flags) * 31;
        Map<Integer, ExternalSkuStrategy> map = this.externalSkuStrategies;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public final boolean isAvailable() {
        return (this.flags & 4) > 0;
    }

    public final boolean isStickerPack() {
        return (this.flags & 16) > 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelSku(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(", premium=");
        sbU.append(this.premium);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", price=");
        sbU.append(this.price);
        sbU.append(", flags=");
        sbU.append(this.flags);
        sbU.append(", externalSkuStrategies=");
        return outline.M(sbU, this.externalSkuStrategies, ")");
    }
}
