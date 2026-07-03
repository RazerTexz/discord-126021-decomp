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

    /* JADX INFO: renamed from: a */
    public final String f14566a;

    /* JADX INFO: renamed from: b */
    public final JSONObject f14567b;

    public SkuDetails(@NonNull String str) throws JSONException {
        this.f14566a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.f14567b = jSONObject;
        if (TextUtils.isEmpty(jSONObject.optString("productId"))) {
            throw new IllegalArgumentException("SKU cannot be empty.");
        }
        if (TextUtils.isEmpty(jSONObject.optString("type"))) {
            throw new IllegalArgumentException("SkuType cannot be empty.");
        }
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public String m7500a() {
        return this.f14567b.optString(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public String m7501b() {
        return this.f14567b.optString("price");
    }

    /* JADX INFO: renamed from: c */
    public long m7502c() {
        return this.f14567b.optLong("price_amount_micros");
    }

    @NonNull
    /* JADX INFO: renamed from: d */
    public String m7503d() {
        return this.f14567b.optString("productId");
    }

    @NonNull
    /* JADX INFO: renamed from: e */
    public String m7504e() {
        return this.f14567b.optString("type");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkuDetails) {
            return TextUtils.equals(this.f14566a, ((SkuDetails) obj).f14566a);
        }
        return false;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public final String m7505f() {
        return this.f14567b.optString("packageName");
    }

    public int hashCode() {
        return this.f14566a.hashCode();
    }

    @NonNull
    public String toString() {
        String strValueOf = String.valueOf(this.f14566a);
        return strValueOf.length() != 0 ? "SkuDetails: ".concat(strValueOf) : new String("SkuDetails: ");
    }
}
