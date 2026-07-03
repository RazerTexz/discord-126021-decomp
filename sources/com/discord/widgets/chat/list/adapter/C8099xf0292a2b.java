package com.discord.widgets.chat.list.adapter;

import android.text.style.StyleSpan;
import android.view.View;
import com.discord.C5419R;
import com.discord.api.interaction.Interaction;
import com.discord.api.user.User;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1 */
/* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8099xf0292a2b extends AbstractC12240o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ Interaction $interaction;
    public final /* synthetic */ User $interactionUser;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemMessage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8099xf0292a2b(WidgetChatListAdapterItemMessage widgetChatListAdapterItemMessage, Interaction interaction, Message message, User user) {
        super(1);
        this.this$0 = widgetChatListAdapterItemMessage;
        this.$interaction = interaction;
        this.$message = message;
        this.$interactionUser = user;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        C12238m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.m8422a("commandNameOnClick", new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
    public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$configureReplyInteraction$content$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
        public static final class C132791 extends AbstractC12240o implements Function1<View, Unit> {
            public C132791() {
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
                Guild guild = WidgetChatListAdapterItemMessage.access$getAdapter$p(C8099xf0292a2b.this.this$0).getData().getGuild();
                Long lValueOf = guild != null ? Long.valueOf(guild.getId()) : null;
                Long id2 = C8099xf0292a2b.this.$interaction.getId();
                if (id2 != null) {
                    long jLongValue = id2.longValue();
                    if (!C8099xf0292a2b.this.$message.isLocalApplicationCommand() || C8099xf0292a2b.this.$message.isFailed()) {
                        Integer type = C8099xf0292a2b.this.$message.getType();
                        if (type != null && type.intValue() == 23) {
                            return;
                        }
                        WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemMessage.access$getAdapter$p(C8099xf0292a2b.this.this$0).getEventHandler();
                        long channelId = C8099xf0292a2b.this.$message.getChannelId();
                        long id3 = C8099xf0292a2b.this.$message.getId();
                        long id4 = C8099xf0292a2b.this.$interactionUser.getId();
                        User author = C8099xf0292a2b.this.$message.getAuthor();
                        C12238m.checkNotNull(author);
                        eventHandler.onCommandClicked(jLongValue, lValueOf, channelId, id3, id4, author.getId(), C8099xf0292a2b.this.$message.getNonce());
                    }
                }
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            C12238m.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new StyleSpan(1));
            hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(C8099xf0292a2b.this.this$0.replyText, C5419R.attr.colorTextLink)), false, null, new C132791(), 4, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.f27425a;
        }
    }
}
