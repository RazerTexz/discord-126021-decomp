package com.discord.widgets.guilds.profile;

import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentityViewModel$saveMemberChanges$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetChangeGuildIdentityViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetChangeGuildIdentityViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChangeGuildIdentityViewModel$saveMemberChanges$1(WidgetChangeGuildIdentityViewModel widgetChangeGuildIdentityViewModel, WidgetChangeGuildIdentityViewModel$ViewState$Loaded widgetChangeGuildIdentityViewModel$ViewState$Loaded) {
        super(1);
        this.this$0 = widgetChangeGuildIdentityViewModel;
        this.$viewState = widgetChangeGuildIdentityViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x005f  */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        String message;
        m.checkNotNullParameter(error, "it");
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "it.response");
        if (!response.getMessages().values().isEmpty()) {
            Error$Response response2 = error.getResponse();
            m.checkNotNullExpressionValue(response2, "it.response");
            Object objFirst = u.first(response2.getMessages().values());
            m.checkNotNullExpressionValue(objFirst, "it.response.messages.values.first()");
            if (!((Collection) objFirst).isEmpty()) {
                Error$Response response3 = error.getResponse();
                m.checkNotNullExpressionValue(response3, "it.response");
                Object objFirst2 = u.first(response3.getMessages().values());
                m.checkNotNullExpressionValue(objFirst2, "it.response.messages.values.first()");
                message = (String) u.first((List) objFirst2);
            } else {
                Error$Response response4 = error.getResponse();
                m.checkNotNullExpressionValue(response4, "it.response");
                message = response4.getMessage();
            }
        } else {
            Error$Response response5 = error.getResponse();
            m.checkNotNullExpressionValue(response5, "it.response");
            message = response5.getMessage();
        }
        WidgetChangeGuildIdentityViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) new WidgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed(message));
        WidgetChangeGuildIdentityViewModel.access$updateViewState(this.this$0, WidgetChangeGuildIdentityViewModel$ViewState$Loaded.copy$default(this.$viewState, null, null, null, false, null, null, false, 63, null));
    }
}
