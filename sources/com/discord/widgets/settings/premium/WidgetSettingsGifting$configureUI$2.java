package com.discord.widgets.settings.premium;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.discord.utilities.gifting.GiftingUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGifting$configureUI$2 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetSettingsGifting this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGifting$configureUI$2(WidgetSettingsGifting widgetSettingsGifting) {
        super(1);
        this.this$0 = widgetSettingsGifting;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "giftCode");
        Context context = this.this$0.getContext();
        Object systemService = context != null ? context.getSystemService("clipboard") : null;
        ClipboardManager clipboardManager = (ClipboardManager) (systemService instanceof ClipboardManager ? systemService : null);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("", GiftingUtils.INSTANCE.generateGiftUrl(str)));
        }
        WidgetSettingsGifting.access$getViewModel$p(this.this$0).handleCopyClicked(str);
    }
}
