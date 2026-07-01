package com.discord.widgets.servers.settings.invites;

import androidx.fragment.app.FragmentManager;
import com.discord.models.domain.ModelInvite;
import com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions;
import com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvites$configureUI$1 extends o implements Function1<ModelInvite, Unit> {
    public final /* synthetic */ WidgetServerSettingsInstantInvites this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsInstantInvites$configureUI$1(WidgetServerSettingsInstantInvites widgetServerSettingsInstantInvites) {
        super(1);
        this.this$0 = widgetServerSettingsInstantInvites;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
        invoke2(modelInvite);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelInvite modelInvite) {
        m.checkNotNullParameter(modelInvite, "invite");
        WidgetServerSettingsInstantInvitesActions$Companion widgetServerSettingsInstantInvitesActions$Companion = WidgetServerSettingsInstantInvitesActions.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String str = modelInvite.code;
        m.checkNotNullExpressionValue(str, "invite.code");
        widgetServerSettingsInstantInvitesActions$Companion.create(parentFragmentManager, str);
    }
}
