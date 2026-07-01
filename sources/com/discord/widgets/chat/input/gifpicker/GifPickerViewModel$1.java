package com.discord.widgets.chat.input.gifpicker;

import androidx.core.app.NotificationCompat;
import com.discord.models.gifpicker.domain.ModelGifCategory;
import d0.z.d.m;
import java.util.List;
import rx.functions.Func2;

/* JADX INFO: compiled from: GifPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifPickerViewModel$1<T1, T2, R> implements Func2<List<? extends ModelGifCategory>, String, GifPickerViewModel$StoreState> {
    public static final GifPickerViewModel$1 INSTANCE = new GifPickerViewModel$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ GifPickerViewModel$StoreState call(List<? extends ModelGifCategory> list, String str) {
        return call2((List<ModelGifCategory>) list, str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GifPickerViewModel$StoreState call2(List<ModelGifCategory> list, String str) {
        m.checkNotNullExpressionValue(list, "gifCategories");
        m.checkNotNullExpressionValue(str, "trendingGifCategoryPreviewUrl");
        return new GifPickerViewModel$StoreState(list, str);
    }
}
