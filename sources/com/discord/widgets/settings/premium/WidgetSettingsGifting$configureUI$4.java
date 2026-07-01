package com.discord.widgets.settings.premium;

import com.discord.stores.StoreGifting;
import com.discord.stores.StoreStream;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGifting$configureUI$4 extends o implements Function2<Long, Long, Unit> {
    public static final WidgetSettingsGifting$configureUI$4 INSTANCE = new WidgetSettingsGifting$configureUI$4();

    public WidgetSettingsGifting$configureUI$4() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
        invoke(l.longValue(), l2);
        return Unit.a;
    }

    public final void invoke(long j, Long l) {
        StoreGifting.generateGiftCode$default(StoreStream.Companion.getGifting(), j, l, null, null, 12, null);
    }
}
