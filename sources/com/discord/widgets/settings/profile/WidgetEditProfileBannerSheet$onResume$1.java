package com.discord.widgets.settings.profile;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditProfileBannerSheet$onResume$1 extends o implements Function1<EditProfileBannerSheetViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetEditProfileBannerSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditProfileBannerSheet$onResume$1(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        super(1);
        this.this$0 = widgetEditProfileBannerSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(EditProfileBannerSheetViewModel$ViewState editProfileBannerSheetViewModel$ViewState) {
        invoke2(editProfileBannerSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(EditProfileBannerSheetViewModel$ViewState editProfileBannerSheetViewModel$ViewState) {
        m.checkNotNullParameter(editProfileBannerSheetViewModel$ViewState, "viewState");
        WidgetEditProfileBannerSheet.access$configureUi(this.this$0, editProfileBannerSheetViewModel$ViewState);
    }
}
