package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.PaymentSourceRaw;
import d0.u.a;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePaymentSources$ensureDefaultPaymentSource$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return a.compareValues(Integer.valueOf(!((PaymentSourceRaw) t).getDefault() ? 1 : 0), Integer.valueOf(!((PaymentSourceRaw) t2).getDefault() ? 1 : 0));
    }
}
