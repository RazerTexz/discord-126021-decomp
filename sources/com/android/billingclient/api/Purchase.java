package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public class Purchase {

    /* JADX INFO: renamed from: a */
    public final String f14561a;

    /* JADX INFO: renamed from: b */
    public final String f14562b;

    /* JADX INFO: renamed from: c */
    public final JSONObject f14563c;

    /* JADX INFO: renamed from: com.android.billingclient.api.Purchase$a */
    /* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
    public static class C5413a {

        /* JADX INFO: renamed from: a */
        @Nullable
        public final List<Purchase> f14564a;

        /* JADX INFO: renamed from: b */
        public final BillingResult f14565b;

        public C5413a(@NonNull BillingResult billingResult, @Nullable List<Purchase> list) {
            this.f14564a = list;
            this.f14565b = billingResult;
        }
    }

    public Purchase(@NonNull String str, @NonNull String str2) throws JSONException {
        this.f14561a = str;
        this.f14562b = str2;
        this.f14563c = new JSONObject(str);
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public String m7497a() {
        JSONObject jSONObject = this.f14563c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public ArrayList<String> m7498b() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.f14563c.has("productIds")) {
            JSONArray jSONArrayOptJSONArray = this.f14563c.optJSONArray("productIds");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i));
                }
            }
        } else if (this.f14563c.has("productId")) {
            arrayList.add(this.f14563c.optString("productId"));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: c */
    public boolean m7499c() {
        return this.f14563c.optBoolean("acknowledged", true);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return TextUtils.equals(this.f14561a, purchase.f14561a) && TextUtils.equals(this.f14562b, purchase.f14562b);
    }

    public int hashCode() {
        return this.f14561a.hashCode();
    }

    @NonNull
    public String toString() {
        String strValueOf = String.valueOf(this.f14561a);
        return strValueOf.length() != 0 ? "Purchase. Json: ".concat(strValueOf) : new String("Purchase. Json: ");
    }
}
