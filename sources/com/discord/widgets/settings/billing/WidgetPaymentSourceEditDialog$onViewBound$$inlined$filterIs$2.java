package com.discord.widgets.settings.billing;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import j0.k.b;
import java.util.Objects;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog$onViewBound$$inlined$filterIs$2<T, R> implements b<Object, T> {
    public static final WidgetPaymentSourceEditDialog$onViewBound$$inlined$filterIs$2 INSTANCE = new WidgetPaymentSourceEditDialog$onViewBound$$inlined$filterIs$2();

    @Override // j0.k.b
    public final T call(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.settings.billing.SettingsBillingViewModel.ViewState.Loaded");
        return (T) ((SettingsBillingViewModel$ViewState$Loaded) obj);
    }
}
