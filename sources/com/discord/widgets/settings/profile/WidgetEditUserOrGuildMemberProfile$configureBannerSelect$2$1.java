package com.discord.widgets.settings.profile;

import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1(WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2 widgetEditUserOrGuildMemberProfile$configureBannerSelect$2) {
        super(1);
        this.this$0 = widgetEditUserOrGuildMemberProfile$configureBannerSelect$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        WidgetEditProfileBannerSheet$Companion widgetEditProfileBannerSheet$Companion = WidgetEditProfileBannerSheet.Companion;
        Long lAccess$getGuildId$p = WidgetEditUserOrGuildMemberProfile.access$getGuildId$p(this.this$0.this$0);
        m.checkNotNullExpressionValue(str, "avatarRepresentativeColorHex");
        String nonDefaultColorPreviewHex = this.this$0.$viewState.getNonDefaultColorPreviewHex();
        boolean hasBannerImageForDisplay = this.this$0.$viewState.getHasBannerImageForDisplay();
        FragmentManager parentFragmentManager = this.this$0.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetEditProfileBannerSheet$Companion.show(lAccess$getGuildId$p, str, nonDefaultColorPreviewHex, hasBannerImageForDisplay, parentFragmentManager, new WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$1(this), new WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$2(this), new WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$3(this));
    }
}
