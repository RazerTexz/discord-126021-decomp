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
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2004b;
    public final JSONObject c;

    /* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
    public static class a {

        @Nullable
        public final List<Purchase> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BillingResult f2005b;

        public a(@NonNull BillingResult billingResult, @Nullable List<Purchase> list) {
            this.a = list;
            this.f2005b = billingResult;
        }
    }

    public Purchase(@NonNull String str, @NonNull String str2) throws JSONException {
        this.a = str;
        this.f2004b = str2;
        this.c = new JSONObject(str);
    }

    @NonNull
    public String a() {
        JSONObject jSONObject = this.c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    @NonNull
    public ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.c.has("productIds")) {
            JSONArray jSONArrayOptJSONArray = this.c.optJSONArray("productIds");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i));
                }
            }
        } else if (this.c.has("productId")) {
            arrayList.add(this.c.optString("productId"));
        }
        return arrayList;
    }

    public boolean c() {
        return this.c.optBoolean("acknowledged", true);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return TextUtils.equals(this.a, purchase.a) && TextUtils.equals(this.f2004b, purchase.f2004b);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NonNull
    public String toString() {
        String strValueOf = String.valueOf(this.a);
        return strValueOf.length() != 0 ? "Purchase. Json: ".concat(strValueOf) : new String("Purchase. Json: ");
    }
}
