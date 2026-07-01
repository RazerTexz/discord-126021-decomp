package com.discord.widgets.settings.profile;

import android.graphics.Color;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditProfileBannerSheet$viewModel$2 extends o implements Function0<EditProfileBannerSheetViewModel> {
    public final /* synthetic */ WidgetEditProfileBannerSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditProfileBannerSheet$viewModel$2(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        super(0);
        this.this$0 = widgetEditProfileBannerSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ EditProfileBannerSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EditProfileBannerSheetViewModel invoke() {
        String string = WidgetEditProfileBannerSheet.access$getArgumentsOrDefault$p(this.this$0).getString("ARG_DEFAULT_BANNER_COLOR_HEX");
        m.checkNotNull(string);
        m.checkNotNullExpressionValue(string, "argumentsOrDefault.getSt…FAULT_BANNER_COLOR_HEX)!!");
        String string2 = WidgetEditProfileBannerSheet.access$getArgumentsOrDefault$p(this.this$0).getString("ARG_INITIAL_COLOR_PREVIEW_HEX");
        WidgetEditProfileBannerSheet.access$setDefaultBannerColor$p(this.this$0, Color.parseColor(string));
        return new EditProfileBannerSheetViewModel(string, string2, null, 4, null);
    }
}
