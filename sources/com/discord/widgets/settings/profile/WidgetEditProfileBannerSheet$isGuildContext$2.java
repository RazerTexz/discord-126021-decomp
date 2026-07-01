package com.discord.widgets.settings.profile;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditProfileBannerSheet$isGuildContext$2 extends o implements Function0<Boolean> {
    public final /* synthetic */ WidgetEditProfileBannerSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditProfileBannerSheet$isGuildContext$2(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        super(0);
        this.this$0 = widgetEditProfileBannerSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return WidgetEditProfileBannerSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_GUILD_ID") > 0;
    }
}
