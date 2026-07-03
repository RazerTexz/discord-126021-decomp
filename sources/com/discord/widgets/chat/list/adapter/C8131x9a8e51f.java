package com.discord.widgets.chat.list.adapter;

import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.textprocessing.FontColorSpan;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$actorRenderContext$1 */
/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8131x9a8e51f extends AbstractC12240o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ int $authorRoleColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8131x9a8e51f(int i) {
        super(1);
        this.$authorRoleColor = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$actorRenderContext$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            C12238m.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new FontColorSpan(C8131x9a8e51f.this.$authorRoleColor));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        C12238m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.m8422a("actorHook", new AnonymousClass1());
    }
}
