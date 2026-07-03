package com.discord.widgets.hubs;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.i18n.RenderContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p062y.C1322b0;
import p007b.p008a.p062y.C1324c0;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailFlow$onViewCreated$learnMore$1 extends AbstractC12240o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetHubEmailFlow this$0;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$learnMore$1$1 */
    /* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
    public static final class C90381 extends AbstractC12240o implements Function1<View, Unit> {
        public C90381() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            C1322b0.Companion companion = C1322b0.INSTANCE;
            FragmentManager childFragmentManager = WidgetHubEmailFlow$onViewCreated$learnMore$1.this.this$0.getChildFragmentManager();
            C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            String string = WidgetHubEmailFlow$onViewCreated$learnMore$1.this.this$0.getString(C5419R.string.hub_email_connection_sidebar_learn_more_header);
            C12238m.checkNotNullExpressionValue(string, "getString(R.string.hub_e…idebar_learn_more_header)");
            C1322b0.Companion.m378b(companion, childFragmentManager, string, C12145m.listOf(new C1324c0(null, WidgetHubEmailFlow$onViewCreated$learnMore$1.this.this$0.getString(C5419R.string.hub_email_connection_sidebar_description), null, null, null, null, null, Opcodes.LUSHR)), false, null, 16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEmailFlow$onViewCreated$learnMore$1(WidgetHubEmailFlow widgetHubEmailFlow) {
        super(1);
        this.this$0 = widgetHubEmailFlow;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        C12238m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.m8423b("{helpdeskArticle}", new C90381());
    }
}
