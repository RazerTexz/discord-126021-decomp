package com.discord.widgets.settings.profile;

import com.discord.utilities.color.ColorCompat;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$3 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$3(WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1 widgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1) {
        super(1);
        this.this$0 = widgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke2(num);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Integer num) {
        String colorHexFromColorInt;
        if (num != null) {
            colorHexFromColorInt = ColorCompat.INSTANCE.getColorHexFromColorInt(num.intValue());
        } else {
            colorHexFromColorInt = null;
        }
        WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(this.this$0.this$0.this$0).updateBannerColor(colorHexFromColorInt);
    }
}
