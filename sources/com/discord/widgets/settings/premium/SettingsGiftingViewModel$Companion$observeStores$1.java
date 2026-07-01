package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGift;
import com.discord.stores.StoreGifting;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGiftingViewModel$Companion$observeStores$1<T, R> implements b<Long, Observable<? extends List<? extends ModelGift>>> {
    public static final SettingsGiftingViewModel$Companion$observeStores$1 INSTANCE = new SettingsGiftingViewModel$Companion$observeStores$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends List<? extends ModelGift>> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<ModelGift>> call2(Long l) {
        StoreGifting gifting = StoreStream.Companion.getGifting();
        m.checkNotNullExpressionValue(l, "meId");
        return gifting.getMyResolvedGifts(l.longValue());
    }
}
