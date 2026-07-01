package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelCustomStatusSetting;
import com.discord.models.domain.emoji.EmojiSet;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSetCustomStatusViewModel$Companion$observeStoreState$1<T1, T2, R> implements Func2<ModelCustomStatusSetting, EmojiSet, WidgetUserSetCustomStatusViewModel$StoreState> {
    public static final WidgetUserSetCustomStatusViewModel$Companion$observeStoreState$1 INSTANCE = new WidgetUserSetCustomStatusViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetUserSetCustomStatusViewModel$StoreState call(ModelCustomStatusSetting modelCustomStatusSetting, EmojiSet emojiSet) {
        return call2(modelCustomStatusSetting, emojiSet);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetUserSetCustomStatusViewModel$StoreState call2(ModelCustomStatusSetting modelCustomStatusSetting, EmojiSet emojiSet) {
        m.checkNotNullExpressionValue(modelCustomStatusSetting, "customStatusSetting");
        m.checkNotNullExpressionValue(emojiSet, "emojiSet");
        return new WidgetUserSetCustomStatusViewModel$StoreState(modelCustomStatusSetting, emojiSet);
    }
}
