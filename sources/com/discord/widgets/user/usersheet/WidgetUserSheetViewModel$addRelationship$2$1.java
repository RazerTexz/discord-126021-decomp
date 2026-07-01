package com.discord.widgets.user.usersheet;

import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet$Companion;
import com.discord.widgets.captcha.WidgetCaptchaKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheetViewModel$addRelationship$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Error $error;
    public final /* synthetic */ WidgetUserSheetViewModel$addRelationship$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheetViewModel$addRelationship$2$1(WidgetUserSheetViewModel$addRelationship$2 widgetUserSheetViewModel$addRelationship$2, Error error) {
        super(0);
        this.this$0 = widgetUserSheetViewModel$addRelationship$2;
        this.$error = error;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (WidgetCaptchaKt.isCaptchaError(this.$error)) {
            WidgetCaptchaBottomSheet$Companion.enqueue$default(WidgetCaptchaBottomSheet.Companion, "Add Friend Captcha", new WidgetUserSheetViewModel$addRelationship$2$1$1(this), null, CaptchaErrorBody.Companion.createFromError(this.$error), 4, null);
            return;
        }
        WidgetUserSheetViewModel widgetUserSheetViewModel = this.this$0.this$0;
        Error$Response response = this.$error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        WidgetUserSheetViewModel.access$emitShowFriendRequestAbortToast(widgetUserSheetViewModel, response.getCode(), this.this$0.$username);
    }
}
