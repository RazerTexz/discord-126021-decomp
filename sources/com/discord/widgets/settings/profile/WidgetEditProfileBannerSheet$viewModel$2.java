package com.discord.widgets.settings.profile;

import android.graphics.Color;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditProfileBannerSheet$viewModel$2 extends AbstractC12240o implements Function0<EditProfileBannerSheetViewModel> {
    public final /* synthetic */ WidgetEditProfileBannerSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditProfileBannerSheet$viewModel$2(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        super(0);
        this.this$0 = widgetEditProfileBannerSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EditProfileBannerSheetViewModel invoke() {
        String string = this.this$0.getArgumentsOrDefault().getString("ARG_DEFAULT_BANNER_COLOR_HEX");
        C12238m.checkNotNull(string);
        C12238m.checkNotNullExpressionValue(string, "argumentsOrDefault.getSt…FAULT_BANNER_COLOR_HEX)!!");
        String string2 = this.this$0.getArgumentsOrDefault().getString("ARG_INITIAL_COLOR_PREVIEW_HEX");
        this.this$0.defaultBannerColor = Color.parseColor(string);
        return new EditProfileBannerSheetViewModel(string, string2, null, 4, null);
    }
}
