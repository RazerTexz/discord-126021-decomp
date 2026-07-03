package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3278b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class AvailabilityException extends Exception {
    private final ArrayMap<C3278b<?>, ConnectionResult> zaa;

    @Override // java.lang.Throwable
    @NonNull
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        for (C3278b<?> c3278b : this.zaa.keySet()) {
            ConnectionResult connectionResult = this.zaa.get(c3278b);
            if (connectionResult.m9020x0()) {
                z2 = false;
            }
            String str = c3278b.f9346b.f9325c;
            String strValueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(strValueOf.length() + String.valueOf(str).length() + 2);
            sb.append(str);
            sb.append(": ");
            sb.append(strValueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z2) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}
