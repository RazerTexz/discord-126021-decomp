package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.api.user.User;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelLibraryApplication;
import com.discord.models.user.MeUser;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift$ModelProvider$getResolvedGiftModel$1<T1, T2, R> implements Func2<MeUser, Map<Long, ? extends ModelLibraryApplication>, WidgetChatListAdapterItemGift$Model> {
    public final /* synthetic */ ModelGift $gift;
    public final /* synthetic */ boolean $redeeming;

    public WidgetChatListAdapterItemGift$ModelProvider$getResolvedGiftModel$1(ModelGift modelGift, boolean z2) {
        this.$gift = modelGift;
        this.$redeeming = z2;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemGift$Model call(MeUser meUser, Map<Long, ? extends ModelLibraryApplication> map) {
        return call2(meUser, (Map<Long, ModelLibraryApplication>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemGift$Model call2(MeUser meUser, Map<Long, ModelLibraryApplication> map) {
        WidgetChatListAdapterItemGift$Model widgetChatListAdapterItemGift$Model$Invalid;
        if (this.$gift.isExpired(ClockFactory.get().currentTimeMillis())) {
            User user = this.$gift.getUser();
            widgetChatListAdapterItemGift$Model$Invalid = new WidgetChatListAdapterItemGift$Model$Invalid(user != null ? Long.valueOf(user.getId()) : null, meUser.getId());
        } else {
            ModelGift modelGift = this.$gift;
            m.checkNotNullExpressionValue(meUser, "me");
            widgetChatListAdapterItemGift$Model$Invalid = new WidgetChatListAdapterItemGift$Model$Resolved(modelGift, meUser, map != null && map.containsKey(Long.valueOf(this.$gift.getSkuId())), this.$redeeming);
        }
        return widgetChatListAdapterItemGift$Model$Invalid;
    }
}
