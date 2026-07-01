package com.discord.widgets.servers.community;

import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CommunityGetStartedInformationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CommunityGetStartedInformationView$initAttrs$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ CommunityGetStartedInformationView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommunityGetStartedInformationView$initAttrs$1(CommunityGetStartedInformationView communityGetStartedInformationView) {
        super(1);
        this.this$0 = communityGetStartedInformationView;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(this.this$0.getContext(), 2130968989));
    }
}
