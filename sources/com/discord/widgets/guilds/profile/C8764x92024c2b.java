package com.discord.widgets.guilds.profile;

import android.text.Editable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$configureNickname$$inlined$also$lambda$1 */
/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8764x92024c2b extends AbstractC12240o implements Function1<Editable, Unit> {
    public final /* synthetic */ WidgetChangeGuildIdentityViewModel.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetChangeGuildIdentity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8764x92024c2b(WidgetChangeGuildIdentity widgetChangeGuildIdentity, WidgetChangeGuildIdentityViewModel.ViewState.Loaded loaded) {
        super(1);
        this.this$0 = widgetChangeGuildIdentity;
        this.$viewState$inlined = loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        C12238m.checkNotNullParameter(editable, "editable");
        this.this$0.getViewModel().updateNickname(editable.toString());
    }
}
