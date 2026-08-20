package com.discord.widgets.settings.premium;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGiftingOutboundPromosAdapter$Companion$DIFF_CALLBACK$1 */
/* JADX INFO: compiled from: WidgetSettingsGiftingOutboundPromosAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9920x78cf4fc0 extends AbstractC12240o implements Function1<SettingsGiftingViewModel.OutboundPromoItem, Object> {
    public static final C9920x78cf4fc0 INSTANCE = new C9920x78cf4fc0();

    public C9920x78cf4fc0() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem) {
        C12238m.checkNotNullParameter(outboundPromoItem, "it");
        return Long.valueOf(outboundPromoItem.getId());
    }
}
