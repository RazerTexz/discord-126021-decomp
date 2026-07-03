package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import com.discord.C5419R;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.message.Message;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1 */
/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8133x2640c67a extends AbstractC12240o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ int $authorRoleColor;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ Long $roleSubscriptionListingId;
    public final /* synthetic */ Message $this_getSystemMessage;
    public final /* synthetic */ WidgetChatListAdapterItemSystemMessage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8133x2640c67a(WidgetChatListAdapterItemSystemMessage widgetChatListAdapterItemSystemMessage, Message message, int i, Context context, Long l) {
        super(1);
        this.this$0 = widgetChatListAdapterItemSystemMessage;
        this.$this_getSystemMessage = message;
        this.$authorRoleColor = i;
        this.$context = context;
        this.$roleSubscriptionListingId = l;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
        public static final class C132801 extends AbstractC12240o implements Function1<View, Unit> {
            public C132801() {
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
                WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(C8133x2640c67a.this.this$0).getEventHandler();
                C8133x2640c67a c8133x2640c67a = C8133x2640c67a.this;
                eventHandler.onMessageAuthorNameClicked(c8133x2640c67a.$this_getSystemMessage, WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(c8133x2640c67a.this$0).getData().getGuildId());
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            C12238m.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new ClickableSpan(Integer.valueOf(C8133x2640c67a.this.$authorRoleColor), false, null, new C132801(), 4, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Hook, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<View, Unit> {
            public AnonymousClass1() {
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
                C8133x2640c67a c8133x2640c67a = C8133x2640c67a.this;
                if (c8133x2640c67a.$roleSubscriptionListingId != null) {
                    WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(c8133x2640c67a.this$0).onRoleSubscriptionPurchaseSystemMessageClicked(C8133x2640c67a.this.$roleSubscriptionListingId.longValue(), C8133x2640c67a.this.$this_getSystemMessage.getId());
                }
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            C12238m.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(C8133x2640c67a.this.$context, C5419R.attr.colorTextLink)), false, null, new AnonymousClass1(), 4, null));
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
        renderContext.m8422a("roleSubscriptionOnClick", new AnonymousClass2());
    }
}
