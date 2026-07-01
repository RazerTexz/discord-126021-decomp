package com.discord.utilities.analytics;

import b.d.b.a.a;
import d0.z.d.m;
import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Traits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class Traits$Location implements Serializable {
    private final String _object;
    private final String objectType;
    private final String page;
    private final Integer promotionId;
    private final String section;

    public Traits$Location() {
        this(null, null, null, null, null, 31, null);
    }

    public Traits$Location(String str, String str2, String str3, String str4, Integer num) {
        this.page = str;
        this.section = str2;
        this._object = str3;
        this.objectType = str4;
        this.promotionId = num;
    }

    public static /* synthetic */ Traits$Location copy$default(Traits$Location traits$Location, String str, String str2, String str3, String str4, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = traits$Location.page;
        }
        if ((i & 2) != 0) {
            str2 = traits$Location.section;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = traits$Location._object;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = traits$Location.objectType;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            num = traits$Location.promotionId;
        }
        return traits$Location.copy(str, str5, str6, str7, num);
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

    public final Traits$Location copy(String page, String section, String _object, String objectType, Integer promotionId) {
        return new Traits$Location(page, section, _object, objectType, promotionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Traits$Location)) {
            return false;
        }
        Traits$Location traits$Location = (Traits$Location) other;
        return m.areEqual(this.page, traits$Location.page) && m.areEqual(this.section, traits$Location.section) && m.areEqual(this._object, traits$Location._object) && m.areEqual(this.objectType, traits$Location.objectType) && m.areEqual(this.promotionId, traits$Location.promotionId);
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
        m.checkNotNullParameter(properties, "properties");
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
        StringBuilder sbU = a.U("Location(page=");
        sbU.append(this.page);
        sbU.append(", section=");
        sbU.append(this.section);
        sbU.append(", _object=");
        sbU.append(this._object);
        sbU.append(", objectType=");
        sbU.append(this.objectType);
        sbU.append(", promotionId=");
        return a.F(sbU, this.promotionId, ")");
    }

    public /* synthetic */ Traits$Location(String str, String str2, String str3, String str4, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num);
    }
}
