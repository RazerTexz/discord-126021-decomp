package com.discord.widgets.user.usersheet;

import com.discord.app.AppFragment;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheetViewModel$addRelationship$2$1$1 extends o implements Function2<AppFragment, CaptchaHelper$CaptchaPayload, Unit> {
    public final /* synthetic */ WidgetUserSheetViewModel$addRelationship$2$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheetViewModel$addRelationship$2$1$1(WidgetUserSheetViewModel$addRelationship$2$1 widgetUserSheetViewModel$addRelationship$2$1) {
        super(2);
        this.this$0 = widgetUserSheetViewModel$addRelationship$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        invoke2(appFragment, captchaHelper$CaptchaPayload);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppFragment appFragment, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        m.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
        m.checkNotNullParameter(captchaHelper$CaptchaPayload, "captchaPayload");
        WidgetUserSheetViewModel$addRelationship$2 widgetUserSheetViewModel$addRelationship$2 = this.this$0.this$0;
        widgetUserSheetViewModel$addRelationship$2.this$0.addRelationship(widgetUserSheetViewModel$addRelationship$2.$type, widgetUserSheetViewModel$addRelationship$2.$username, widgetUserSheetViewModel$addRelationship$2.$successMessageStringRes, captchaHelper$CaptchaPayload);
    }
}
