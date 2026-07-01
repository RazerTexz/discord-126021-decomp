package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.discord.models.domain.ModelAuditLogEntry;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public class SkuDetails {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f2006b;

    public SkuDetails(@NonNull String str) throws JSONException {
        this.a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f2006b = jSONObject;
        if (TextUtils.isEmpty(jSONObject.optString("productId"))) {
            throw new IllegalArgumentException("SKU cannot be empty.");
        }
        if (TextUtils.isEmpty(jSONObject.optString("type"))) {
            throw new IllegalArgumentException("SkuType cannot be empty.");
        }
    }

    @NonNull
    public String a() {
        return this.f2006b.optString(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
    }

    @NonNull
    public String b() {
        return this.f2006b.optString("price");
    }

    public long c() {
        return this.f2006b.optLong("price_amount_micros");
    }

    @NonNull
    public String d() {
        return this.f2006b.optString("productId");
    }

    @NonNull
    public String e() {
        return this.f2006b.optString("type");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkuDetails) {
            return TextUtils.equals(this.a, ((SkuDetails) obj).a);
        }
        return false;
    }

    @NonNull
    public final String f() {
        return this.f2006b.optString("packageName");
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NonNull
    public String toString() {
        String strValueOf = String.valueOf(this.a);
        return strValueOf.length() != 0 ? "SkuDetails: ".concat(strValueOf) : new String("SkuDetails: ");
    }
}
