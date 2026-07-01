package com.discord.widgets.settings.premium;

import com.discord.models.domain.ModelGift;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter$onRevokeClickListener$1 extends o implements Function1<ModelGift, Unit> {
    public static final WidgetSettingsGiftingAdapter$onRevokeClickListener$1 INSTANCE = new WidgetSettingsGiftingAdapter$onRevokeClickListener$1();

    public WidgetSettingsGiftingAdapter$onRevokeClickListener$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelGift modelGift) {
        invoke2(modelGift);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelGift modelGift) {
        m.checkNotNullParameter(modelGift, "<anonymous parameter 0>");
    }
}
