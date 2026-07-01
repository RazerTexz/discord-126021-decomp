package com.discord.widgets.chat.list.adapter;

import android.text.style.StyleSpan;
import android.view.View;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.message.Message;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemApplicationCommand2 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ int $authorTextColor;
    public final /* synthetic */ int $cmdColor;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemApplicationCommand this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemApplicationCommand2(WidgetChatListAdapterItemApplicationCommand widgetChatListAdapterItemApplicationCommand, int i, Message message, int i2) {
        super(1);
        this.this$0 = widgetChatListAdapterItemApplicationCommand;
        this.$authorTextColor = i;
        this.$message = message;
        this.$cmdColor = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("usernameOnClick", new AnonymousClass1());
        renderContext.a("commandNameOnClick", new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
        public static final class C02691 extends Lambda implements Function1<View, Unit> {
            public C02691() {
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
                WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemApplicationCommand.access$getAdapter$p(WidgetChatListAdapterItemApplicationCommand2.this.this$0).getEventHandler();
                WidgetChatListAdapterItemApplicationCommand2 widgetChatListAdapterItemApplicationCommand2 = WidgetChatListAdapterItemApplicationCommand2.this;
                eventHandler.onMessageAuthorAvatarClicked(widgetChatListAdapterItemApplicationCommand2.$message, WidgetChatListAdapterItemApplicationCommand.access$getAdapter$p(widgetChatListAdapterItemApplicationCommand2.this$0).getData().getGuildId());
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            Intrinsics3.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new StyleSpan(1));
            hook.styles.add(new ClickableSpan(Integer.valueOf(WidgetChatListAdapterItemApplicationCommand2.this.$authorTextColor), false, null, new C02691(), 4, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Hook, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$content$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            Intrinsics3.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new StyleSpan(1));
            hook.styles.add(new ClickableSpan(Integer.valueOf(WidgetChatListAdapterItemApplicationCommand2.this.$cmdColor), false, null, AnonymousClass1.INSTANCE, 4, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }
}
