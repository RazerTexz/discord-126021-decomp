package com.discord.widgets.guilds.profile;

import android.text.Editable;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity$configureNickname$$inlined$also$lambda$1 extends o implements Function1<Editable, Unit> {
    public final /* synthetic */ WidgetChangeGuildIdentityViewModel$ViewState$Loaded $viewState$inlined;
    public final /* synthetic */ WidgetChangeGuildIdentity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChangeGuildIdentity$configureNickname$$inlined$also$lambda$1(WidgetChangeGuildIdentity widgetChangeGuildIdentity, WidgetChangeGuildIdentityViewModel$ViewState$Loaded widgetChangeGuildIdentityViewModel$ViewState$Loaded) {
        super(1);
        this.this$0 = widgetChangeGuildIdentity;
        this.$viewState$inlined = widgetChangeGuildIdentityViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        m.checkNotNullParameter(editable, "editable");
        WidgetChangeGuildIdentity.access$getViewModel$p(this.this$0).updateNickname(editable.toString());
    }
}
