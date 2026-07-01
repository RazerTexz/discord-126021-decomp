package com.discord.widgets.settings.profile;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$1(WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1 widgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1) {
        super(0);
        this.this$0 = widgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile = this.this$0.this$0.this$0;
        WidgetEditUserOrGuildMemberProfile.access$setImageSelectedResult$p(widgetEditUserOrGuildMemberProfile, WidgetEditUserOrGuildMemberProfile.access$getBannerSelectedResult$p(widgetEditUserOrGuildMemberProfile));
        this.this$0.this$0.this$0.openMediaChooser();
    }
}
