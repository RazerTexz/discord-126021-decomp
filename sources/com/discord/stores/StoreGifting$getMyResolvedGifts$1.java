package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.user.User;
import com.discord.models.domain.ModelGift;
import d0.t.o;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting$getMyResolvedGifts$1<T, R> implements b<Map<String, ? extends StoreGifting$GiftState>, List<? extends ModelGift>> {
    public final /* synthetic */ long $userId;

    public StoreGifting$getMyResolvedGifts$1(long j) {
        this.$userId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends ModelGift> call(Map<String, ? extends StoreGifting$GiftState> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<ModelGift> call2(Map<String, ? extends StoreGifting$GiftState> map) {
        User user;
        Collection<? extends StoreGifting$GiftState> collectionValues = map.values();
        ArrayList<StoreGifting$GiftState> arrayList = new ArrayList();
        for (T t : collectionValues) {
            StoreGifting$GiftState storeGifting$GiftState = (StoreGifting$GiftState) t;
            if ((storeGifting$GiftState instanceof StoreGifting$GiftState$Resolved) && (user = ((StoreGifting$GiftState$Resolved) storeGifting$GiftState).getGift().getUser()) != null && user.getId() == this.$userId) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        for (StoreGifting$GiftState storeGifting$GiftState2 : arrayList) {
            Objects.requireNonNull(storeGifting$GiftState2, "null cannot be cast to non-null type com.discord.stores.StoreGifting.GiftState.Resolved");
            arrayList2.add(((StoreGifting$GiftState$Resolved) storeGifting$GiftState2).getGift());
        }
        return arrayList2;
    }
}
