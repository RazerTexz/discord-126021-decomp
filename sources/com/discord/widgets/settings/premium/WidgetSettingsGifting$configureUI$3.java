package com.discord.widgets.settings.premium;

import com.discord.models.domain.ModelGift;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGifting$configureUI$3 extends o implements Function1<ModelGift, Unit> {
    public static final WidgetSettingsGifting$configureUI$3 INSTANCE = new WidgetSettingsGifting$configureUI$3();

    public WidgetSettingsGifting$configureUI$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelGift modelGift) {
        invoke2(modelGift);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelGift modelGift) {
        m.checkNotNullParameter(modelGift, "gift");
        StoreStream.Companion.getGifting().revokeGiftCode(modelGift);
    }
}
