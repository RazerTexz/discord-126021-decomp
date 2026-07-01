package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import com.discord.R;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.message.Message;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage4 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ int $authorRoleColor;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ Long $roleSubscriptionListingId;
    public final /* synthetic */ Message $this_getSystemMessage;
    public final /* synthetic */ WidgetChatListAdapterItemSystemMessage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSystemMessage4(WidgetChatListAdapterItemSystemMessage widgetChatListAdapterItemSystemMessage, Message message, int i, Context context, Long l) {
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
        return Unit.a;
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
        public static final class C02771 extends Lambda implements Function1<View, Unit> {
            public C02771() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(WidgetChatListAdapterItemSystemMessage4.this.this$0).getEventHandler();
                WidgetChatListAdapterItemSystemMessage4 widgetChatListAdapterItemSystemMessage4 = WidgetChatListAdapterItemSystemMessage4.this;
                eventHandler.onMessageAuthorNameClicked(widgetChatListAdapterItemSystemMessage4.$this_getSystemMessage, WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(widgetChatListAdapterItemSystemMessage4.this$0).getData().getGuildId());
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            Intrinsics3.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new ClickableSpan(Integer.valueOf(WidgetChatListAdapterItemSystemMessage4.this.$authorRoleColor), false, null, new C02771(), 4, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Hook, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                WidgetChatListAdapterItemSystemMessage4 widgetChatListAdapterItemSystemMessage4 = WidgetChatListAdapterItemSystemMessage4.this;
                if (widgetChatListAdapterItemSystemMessage4.$roleSubscriptionListingId != null) {
                    WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(widgetChatListAdapterItemSystemMessage4.this$0).onRoleSubscriptionPurchaseSystemMessageClicked(WidgetChatListAdapterItemSystemMessage4.this.$roleSubscriptionListingId.longValue(), WidgetChatListAdapterItemSystemMessage4.this.$this_getSystemMessage.getId());
                }
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            Intrinsics3.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(WidgetChatListAdapterItemSystemMessage4.this.$context, R.attr.colorTextLink)), false, null, new AnonymousClass1(), 4, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("usernameOnClick", new AnonymousClass1());
        renderContext.a("roleSubscriptionOnClick", new AnonymousClass2());
    }
}
