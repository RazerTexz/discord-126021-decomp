package com.discord.widgets.hubs;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import b.a.y.b0;
import b.a.y.b0$a;
import b.a.y.c0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailFlow$onViewCreated$learnMore$1$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetHubEmailFlow$onViewCreated$learnMore$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEmailFlow$onViewCreated$learnMore$1$1(WidgetHubEmailFlow$onViewCreated$learnMore$1 widgetHubEmailFlow$onViewCreated$learnMore$1) {
        super(1);
        this.this$0 = widgetHubEmailFlow$onViewCreated$learnMore$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        b0$a b0_a = b0.k;
        FragmentManager childFragmentManager = this.this$0.this$0.getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        String string = this.this$0.this$0.getString(2131891804);
        m.checkNotNullExpressionValue(string, "getString(R.string.hub_e…idebar_learn_more_header)");
        b0$a.b(b0_a, childFragmentManager, string, d0.t.m.listOf(new c0(null, this.this$0.this$0.getString(2131891802), null, null, null, null, null, Opcodes.LUSHR)), false, null, 16);
    }
}
