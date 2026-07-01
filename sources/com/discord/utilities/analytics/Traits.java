package com.discord.utilities.analytics;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.widgets.chat.AutocompleteUtils;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Traits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Traits {
    public static final Traits INSTANCE = new Traits();

    /* JADX INFO: compiled from: Traits.kt */
    public static final /* data */ class Location implements Serializable {
        private final String _object;
        private final String objectType;
        private final String page;
        private final Integer promotionId;
        private final String section;

        /* JADX INFO: compiled from: Traits.kt */
        public static final class Obj {
            public static final String ACTIVITY_ACTION = "Activity Action";
            public static final String BOOST_GEM_ICON = "Boost Gem Icon";
            public static final String BUTTON_CTA = "Button CTA";
            public static final String BUTTON_UPSELL = "Button Upsell";
            public static final String EDIT_PROFILE_BANNER = "Edit Profile Banner";
            public static final Obj INSTANCE = new Obj();
            public static final String LIST_ITEM = "List Item";
            public static final String PRIVATE_THREAD_CHECKBOX = "Private Thread Checkbox";

            private Obj() {
            }
        }

        /* JADX INFO: compiled from: Traits.kt */
        public static final class ObjType {
            public static final String BUY = "buy";
            public static final ObjType INSTANCE = new ObjType();
            public static final String SEARCH = "Search";
            public static final String TIER_1 = "tier_1";
            public static final String TIER_2 = "tier_2";
            public static final String TIER_3 = "tier_3";

            private ObjType() {
            }
        }

        /* JADX INFO: compiled from: Traits.kt */
        public static final class Page {
            public static final String BOOST_MARKETING = "User-Facing Premium Guild Subscription Fullscreen Modal";
            public static final String CHANNEL_SETTINGS = "Channel Settings";
            public static final String GUILD_CHANNEL = "Guild Channel";
            public static final Page INSTANCE = new Page();
            public static final String USER_SETTINGS = "User Settings";

            private Page() {
            }
        }

        /* JADX INFO: compiled from: Traits.kt */
        public static final class Section {
            public static final String ANDROID_CANNOT_MANAGE_SUBSCRIPTION = "Android Cannot Manage Subscription";
            public static final String CHANNEL_TEXT_AREA = "Channel Text Area";
            public static final String EMOJI_PICKER_POPOUT = "Emoji Picker Popout";
            public static final String EMOJI_SHEET_UPSELL = "Emoji Upsell Popout";
            public static final String EMPTY_STICKER_PICKER_UPSELL = "Empty Sticker Picker Upsell";
            public static final String EXPRESSION_PICKER = "Expression Picker";
            public static final String FOOTER = "Footer";
            public static final String GUILD_POPOUT = "Guild Popout";
            public static final String HEADER = "Header";
            public static final Section INSTANCE = new Section();
            public static final String PLAYSTATION_UPSELL = "Playstation Upsell";
            public static final String PREMIUM_GUILD_SUBSCRIPTION_CONFIRMATION = "Premium Guild Subscription Confirmation";
            public static final String PREMIUM_GUILD_UPSELL_MODAL = "Premium Guild Upsell Modal";
            public static final String PREMIUM_GUILD_USER_MODAL = "Premium Guild User Modal";
            public static final String SETTINGS_TEXT_AND_IMAGES = "Text & Images";
            public static final String STICKER_PICKER_UPSELL = "Sticker Picker Upsell";
            public static final String STICKER_POPOUT = "Sticker Popout";
            public static final String STICKER_PREMIUM_TIER_2_UPSELL_MODAL = "Stickers Nitro Upsell Modal";
            public static final String THREAD_ARCHIVAL_DURATION_SHEET = "Thread Archival Duration Sheet";
            public static final String THREAD_CREATION_OPTIONS = "Thread Creation Options";
            public static final String USER_PROFILE = "User Profile";

            private Section() {
            }
        }

        public Location() {
            this(null, null, null, null, null, 31, null);
        }

        public Location(String str, String str2, String str3, String str4, Integer num) {
            this.page = str;
            this.section = str2;
            this._object = str3;
            this.objectType = str4;
            this.promotionId = num;
        }

        public static /* synthetic */ Location copy$default(Location location, String str, String str2, String str3, String str4, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = location.page;
            }
            if ((i & 2) != 0) {
                str2 = location.section;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = location._object;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                str4 = location.objectType;
            }
            String str7 = str4;
            if ((i & 16) != 0) {
                num = location.promotionId;
            }
            return location.copy(str, str5, str6, str7, num);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPage() {
            return this.page;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSection() {
            return this.section;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String get_object() {
            return this._object;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getObjectType() {
            return this.objectType;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getPromotionId() {
            return this.promotionId;
        }

        public final Location copy(String page, String section, String _object, String objectType, Integer promotionId) {
            return new Location(page, section, _object, objectType, promotionId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Location)) {
                return false;
            }
            Location location = (Location) other;
            return Intrinsics3.areEqual(this.page, location.page) && Intrinsics3.areEqual(this.section, location.section) && Intrinsics3.areEqual(this._object, location._object) && Intrinsics3.areEqual(this.objectType, location.objectType) && Intrinsics3.areEqual(this.promotionId, location.promotionId);
        }

        public final String getObjectType() {
            return this.objectType;
        }

        public final String getPage() {
            return this.page;
        }

        public final Integer getPromotionId() {
            return this.promotionId;
        }

        public final String getSection() {
            return this.section;
        }

        public final String get_object() {
            return this._object;
        }

        public int hashCode() {
            String str = this.page;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.section;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this._object;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.objectType;
            int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            Integer num = this.promotionId;
            return iHashCode4 + (num != null ? num.hashCode() : 0);
        }

        public final void serializeTo(Map<String, Object> properties) {
            Intrinsics3.checkNotNullParameter(properties, "properties");
            String str = this.page;
            if (str != null) {
                properties.put("location_page", str);
            }
            String str2 = this.section;
            if (str2 != null) {
                properties.put("location_section", str2);
            }
            String str3 = this._object;
            if (str3 != null) {
                properties.put("location_object", str3);
            }
            String str4 = this.objectType;
            if (str4 != null) {
                properties.put("location_object_type", str4);
            }
            Integer num = this.promotionId;
            if (num != null) {
                properties.put("location_promotion_id", Integer.valueOf(num.intValue()));
            }
        }

        public String toString() {
            StringBuilder sbU = outline.U("Location(page=");
            sbU.append(this.page);
            sbU.append(", section=");
            sbU.append(this.section);
            sbU.append(", _object=");
            sbU.append(this._object);
            sbU.append(", objectType=");
            sbU.append(this.objectType);
            sbU.append(", promotionId=");
            return outline.F(sbU, this.promotionId, ")");
        }

        public /* synthetic */ Location(String str, String str2, String str3, String str4, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num);
        }
    }

    /* JADX INFO: compiled from: Traits.kt */
    public static final /* data */ class Payment {
        private final String currency;
        private final boolean isGift;
        private final int price;
        private final int regularPrice;
        private final String type;

        /* JADX INFO: compiled from: Traits.kt */
        public static final class Type {
            public static final Type INSTANCE = new Type();
            public static final String STICKER = "sticker";
            public static final String SUBSCRIPTION = "subscription";

            private Type() {
            }
        }

        public Payment(String str, int i, int i2, String str2, boolean z2) {
            Intrinsics3.checkNotNullParameter(str, "type");
            Intrinsics3.checkNotNullParameter(str2, "currency");
            this.type = str;
            this.price = i;
            this.regularPrice = i2;
            this.currency = str2;
            this.isGift = z2;
        }

        public static /* synthetic */ Payment copy$default(Payment payment, String str, int i, int i2, String str2, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = payment.type;
            }
            if ((i3 & 2) != 0) {
                i = payment.price;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                i2 = payment.regularPrice;
            }
            int i5 = i2;
            if ((i3 & 8) != 0) {
                str2 = payment.currency;
            }
            String str3 = str2;
            if ((i3 & 16) != 0) {
                z2 = payment.isGift;
            }
            return payment.copy(str, i4, i5, str3, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getPrice() {
            return this.price;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getRegularPrice() {
            return this.regularPrice;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCurrency() {
            return this.currency;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsGift() {
            return this.isGift;
        }

        public final Payment copy(String type, int price, int regularPrice, String currency, boolean isGift) {
            Intrinsics3.checkNotNullParameter(type, "type");
            Intrinsics3.checkNotNullParameter(currency, "currency");
            return new Payment(type, price, regularPrice, currency, isGift);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Payment)) {
                return false;
            }
            Payment payment = (Payment) other;
            return Intrinsics3.areEqual(this.type, payment.type) && this.price == payment.price && this.regularPrice == payment.regularPrice && Intrinsics3.areEqual(this.currency, payment.currency) && this.isGift == payment.isGift;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final int getPrice() {
            return this.price;
        }

        public final int getRegularPrice() {
            return this.regularPrice;
        }

        public final String getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            String str = this.type;
            int iHashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.price) * 31) + this.regularPrice) * 31;
            String str2 = this.currency;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z2 = this.isGift;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public final boolean isGift() {
            return this.isGift;
        }

        public final void serializeTo(Map<String, Object> properties) {
            Intrinsics3.checkNotNullParameter(properties, "properties");
            properties.put("payment_type", this.type);
            properties.put("price", Integer.valueOf(this.price));
            properties.put("regular_price", Integer.valueOf(this.regularPrice));
            properties.put("currency", this.currency);
            properties.put("is_gift", Boolean.valueOf(this.isGift));
        }

        public String toString() {
            StringBuilder sbU = outline.U("Payment(type=");
            sbU.append(this.type);
            sbU.append(", price=");
            sbU.append(this.price);
            sbU.append(", regularPrice=");
            sbU.append(this.regularPrice);
            sbU.append(", currency=");
            sbU.append(this.currency);
            sbU.append(", isGift=");
            return outline.O(sbU, this.isGift, ")");
        }
    }

    /* JADX INFO: compiled from: Traits.kt */
    public static final /* data */ class Source {
        private final String _object;
        private final String objectType;
        private final String page;
        private final Integer promotionId;
        private final String section;

        /* JADX INFO: compiled from: Traits.kt */
        public static final class Obj {
            public static final String GIF_PICKER = "GIF Picker";
            public static final Obj INSTANCE = new Obj();

            private Obj() {
            }
        }

        public Source() {
            this(null, null, null, null, null, 31, null);
        }

        public Source(String str, String str2, String str3, String str4, Integer num) {
            this.page = str;
            this.section = str2;
            this._object = str3;
            this.objectType = str4;
            this.promotionId = num;
        }

        public static /* synthetic */ Source copy$default(Source source, String str, String str2, String str3, String str4, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = source.page;
            }
            if ((i & 2) != 0) {
                str2 = source.section;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = source._object;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                str4 = source.objectType;
            }
            String str7 = str4;
            if ((i & 16) != 0) {
                num = source.promotionId;
            }
            return source.copy(str, str5, str6, str7, num);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPage() {
            return this.page;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSection() {
            return this.section;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String get_object() {
            return this._object;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getObjectType() {
            return this.objectType;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getPromotionId() {
            return this.promotionId;
        }

        public final Source copy(String page, String section, String _object, String objectType, Integer promotionId) {
            return new Source(page, section, _object, objectType, promotionId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Source)) {
                return false;
            }
            Source source = (Source) other;
            return Intrinsics3.areEqual(this.page, source.page) && Intrinsics3.areEqual(this.section, source.section) && Intrinsics3.areEqual(this._object, source._object) && Intrinsics3.areEqual(this.objectType, source.objectType) && Intrinsics3.areEqual(this.promotionId, source.promotionId);
        }

        public final String getObjectType() {
            return this.objectType;
        }

        public final String getPage() {
            return this.page;
        }

        public final Integer getPromotionId() {
            return this.promotionId;
        }

        public final String getSection() {
            return this.section;
        }

        public final String get_object() {
            return this._object;
        }

        public int hashCode() {
            String str = this.page;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.section;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this._object;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.objectType;
            int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            Integer num = this.promotionId;
            return iHashCode4 + (num != null ? num.hashCode() : 0);
        }

        public final void serializeTo(Map<String, Object> properties) {
            Intrinsics3.checkNotNullParameter(properties, "properties");
            String str = this.page;
            if (str != null) {
                properties.put("source_page", str);
            }
            String str2 = this.section;
            if (str2 != null) {
                properties.put("source_section", str2);
            }
            String str3 = this._object;
            if (str3 != null) {
                properties.put("source_object", str3);
            }
            String str4 = this.objectType;
            if (str4 != null) {
                properties.put("source_object_type", str4);
            }
            Integer num = this.promotionId;
            if (num != null) {
                properties.put("source_promotion_id", Integer.valueOf(num.intValue()));
            }
        }

        public String toString() {
            StringBuilder sbU = outline.U("Source(page=");
            sbU.append(this.page);
            sbU.append(", section=");
            sbU.append(this.section);
            sbU.append(", _object=");
            sbU.append(this._object);
            sbU.append(", objectType=");
            sbU.append(this.objectType);
            sbU.append(", promotionId=");
            return outline.F(sbU, this.promotionId, ")");
        }

        public /* synthetic */ Source(String str, String str2, String str3, String str4, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num);
        }
    }

    /* JADX INFO: compiled from: Traits.kt */
    public static final /* data */ class StoreSku {
        private final long applicationId;
        private final long skuId;
        private final int skuType;
        private final String storeTitle;

        public StoreSku(long j, int i, long j2, String str) {
            Intrinsics3.checkNotNullParameter(str, "storeTitle");
            this.skuId = j;
            this.skuType = i;
            this.applicationId = j2;
            this.storeTitle = str;
        }

        public static /* synthetic */ StoreSku copy$default(StoreSku storeSku, long j, int i, long j2, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = storeSku.skuId;
            }
            long j3 = j;
            if ((i2 & 2) != 0) {
                i = storeSku.skuType;
            }
            int i3 = i;
            if ((i2 & 4) != 0) {
                j2 = storeSku.applicationId;
            }
            long j4 = j2;
            if ((i2 & 8) != 0) {
                str = storeSku.storeTitle;
            }
            return storeSku.copy(j3, i3, j4, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getSkuId() {
            return this.skuId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getSkuType() {
            return this.skuType;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getApplicationId() {
            return this.applicationId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getStoreTitle() {
            return this.storeTitle;
        }

        public final StoreSku copy(long skuId, int skuType, long applicationId, String storeTitle) {
            Intrinsics3.checkNotNullParameter(storeTitle, "storeTitle");
            return new StoreSku(skuId, skuType, applicationId, storeTitle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreSku)) {
                return false;
            }
            StoreSku storeSku = (StoreSku) other;
            return this.skuId == storeSku.skuId && this.skuType == storeSku.skuType && this.applicationId == storeSku.applicationId && Intrinsics3.areEqual(this.storeTitle, storeSku.storeTitle);
        }

        public final long getApplicationId() {
            return this.applicationId;
        }

        public final long getSkuId() {
            return this.skuId;
        }

        public final int getSkuType() {
            return this.skuType;
        }

        public final String getStoreTitle() {
            return this.storeTitle;
        }

        public int hashCode() {
            int iA = (b.a(this.applicationId) + (((b.a(this.skuId) * 31) + this.skuType) * 31)) * 31;
            String str = this.storeTitle;
            return iA + (str != null ? str.hashCode() : 0);
        }

        public final void serializeTo(Map<String, Object> properties) {
            Intrinsics3.checkNotNullParameter(properties, "properties");
            properties.put("sku_id", Long.valueOf(this.skuId));
            properties.put("sku_type", Integer.valueOf(this.skuType));
            properties.put(ModelAuditLogEntry.CHANGE_KEY_APPLICATION_ID, Long.valueOf(this.applicationId));
            properties.put("store_title", this.storeTitle);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreSku(skuId=");
            sbU.append(this.skuId);
            sbU.append(", skuType=");
            sbU.append(this.skuType);
            sbU.append(", applicationId=");
            sbU.append(this.applicationId);
            sbU.append(", storeTitle=");
            return outline.J(sbU, this.storeTitle, ")");
        }
    }

    /* JADX INFO: compiled from: Traits.kt */
    public static final /* data */ class Subscription {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String gatewayPlanId;
        private final Long planId;
        private final Integer type;

        /* JADX INFO: compiled from: Traits.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Subscription from(SubscriptionPlanType subscriptionPlanType) {
                Intrinsics3.checkNotNullParameter(subscriptionPlanType, "subscriptionPlanType");
                return new Subscription(subscriptionPlanType.getPlanTypeString(), 1, Long.valueOf(subscriptionPlanType.getPlanId()));
            }

            public final Subscription withGatewayPlanId(String gatewayPlanId) {
                Intrinsics3.checkNotNullParameter(gatewayPlanId, "gatewayPlanId");
                return new Subscription(gatewayPlanId, 1, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Subscription(String str, Integer num, Long l) {
            this.gatewayPlanId = str;
            this.type = num;
            this.planId = l;
        }

        public static /* synthetic */ Subscription copy$default(Subscription subscription, String str, Integer num, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subscription.gatewayPlanId;
            }
            if ((i & 2) != 0) {
                num = subscription.type;
            }
            if ((i & 4) != 0) {
                l = subscription.planId;
            }
            return subscription.copy(str, num, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getGatewayPlanId() {
            return this.gatewayPlanId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getPlanId() {
            return this.planId;
        }

        public final Subscription copy(String gatewayPlanId, Integer type, Long planId) {
            return new Subscription(gatewayPlanId, type, planId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Subscription)) {
                return false;
            }
            Subscription subscription = (Subscription) other;
            return Intrinsics3.areEqual(this.gatewayPlanId, subscription.gatewayPlanId) && Intrinsics3.areEqual(this.type, subscription.type) && Intrinsics3.areEqual(this.planId, subscription.planId);
        }

        public final String getGatewayPlanId() {
            return this.gatewayPlanId;
        }

        public final Long getPlanId() {
            return this.planId;
        }

        public final Integer getType() {
            return this.type;
        }

        public int hashCode() {
            String str = this.gatewayPlanId;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.type;
            int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
            Long l = this.planId;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public final void serializeTo(Map<String, Object> properties) {
            Intrinsics3.checkNotNullParameter(properties, "properties");
            String str = this.gatewayPlanId;
            if (str != null) {
                properties.put("subscription_plan_gateway_plan_id", str);
            }
            Integer num = this.type;
            if (num != null) {
                properties.put("subscription_type", Integer.valueOf(num.intValue()));
            }
            Long l = this.planId;
            if (l != null) {
                properties.put("subscription_plan_id", Long.valueOf(l.longValue()));
            }
        }

        public String toString() {
            StringBuilder sbU = outline.U("Subscription(gatewayPlanId=");
            sbU.append(this.gatewayPlanId);
            sbU.append(", type=");
            sbU.append(this.type);
            sbU.append(", planId=");
            return outline.G(sbU, this.planId, ")");
        }

        public /* synthetic */ Subscription(String str, Integer num, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, num, (i & 4) != 0 ? null : l);
        }
    }

    private Traits() {
    }
}
