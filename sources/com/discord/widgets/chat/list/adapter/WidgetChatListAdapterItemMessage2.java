package com.discord.widgets.chat.list.adapter;

import android.text.style.StyleSpan;
import android.view.View;
import com.discord.R;
import com.discord.api.interaction.Interaction;
import com.discord.api.user.User;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMessage2 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ Interaction $interaction;
    public final /* synthetic */ User $interactionUser;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemMessage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemMessage2(WidgetChatListAdapterItemMessage widgetChatListAdapterItemMessage, Interaction interaction, Message message, User user) {
        super(1);
        this.this$0 = widgetChatListAdapterItemMessage;
        this.$interaction = interaction;
        this.$message = message;
        this.$interactionUser = user;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("commandNameOnClick", new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
        public static final class C02741 extends Lambda implements Function1<View, Unit> {
            public C02741() {
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
                Guild guild = WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage2.this.this$0).getData().getGuild();
                Long lValueOf = guild != null ? Long.valueOf(guild.getId()) : null;
                Long id2 = WidgetChatListAdapterItemMessage2.this.$interaction.getId();
                if (id2 != null) {
                    long jLongValue = id2.longValue();
                    if (!WidgetChatListAdapterItemMessage2.this.$message.isLocalApplicationCommand() || WidgetChatListAdapterItemMessage2.this.$message.isFailed()) {
                        Integer type = WidgetChatListAdapterItemMessage2.this.$message.getType();
                        if (type != null && type.intValue() == 23) {
                            return;
                        }
                        WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage2.this.this$0).getEventHandler();
                        long channelId = WidgetChatListAdapterItemMessage2.this.$message.getChannelId();
                        long id3 = WidgetChatListAdapterItemMessage2.this.$message.getId();
                        long id4 = WidgetChatListAdapterItemMessage2.this.$interactionUser.getId();
                        User author = WidgetChatListAdapterItemMessage2.this.$message.getAuthor();
                        Intrinsics3.checkNotNull(author);
                        eventHandler.onCommandClicked(jLongValue, lValueOf, channelId, id3, id4, author.getId(), WidgetChatListAdapterItemMessage2.this.$message.getNonce());
                    }
                }
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            Intrinsics3.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new StyleSpan(1));
            hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(WidgetChatListAdapterItemMessage2.this.this$0.replyText, R.attr.colorTextLink)), false, null, new C02741(), 4, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }
}
