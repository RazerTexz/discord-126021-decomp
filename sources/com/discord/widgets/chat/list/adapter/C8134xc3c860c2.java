package com.discord.widgets.chat.list.adapter;

import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.textprocessing.FontColorSpan;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$usernameRenderContext$1 */
/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8134xc3c860c2 extends AbstractC12240o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ int $authorRoleColor;
    public final /* synthetic */ int $otherRoleColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8134xc3c860c2(int i, int i2) {
        super(1);
        this.$authorRoleColor = i;
        this.$otherRoleColor = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$usernameRenderContext$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            C12238m.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new FontColorSpan(C8134xc3c860c2.this.$authorRoleColor));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$usernameRenderContext$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Hook, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            C12238m.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new FontColorSpan(C8134xc3c860c2.this.$otherRoleColor));
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
        renderContext.m8422a("usernameOnClick", new AnonymousClass1());
        renderContext.m8422a("otherUsernameOnClick", new AnonymousClass2());
    }
}
