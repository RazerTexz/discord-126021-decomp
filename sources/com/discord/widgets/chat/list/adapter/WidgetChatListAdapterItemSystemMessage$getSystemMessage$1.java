package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import b.a.k.b;
import com.discord.api.user.User;
import com.discord.models.message.Message;
import com.discord.utilities.message.MessageUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage$getSystemMessage$1 extends o implements Function1<Context, CharSequence> {
    public final /* synthetic */ Function1 $actorRenderContext;
    public final /* synthetic */ String $authorName;
    public final /* synthetic */ Function1 $autoModRenderContext;
    public final /* synthetic */ int $autoModSystemMessage;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ Long $firstMentionedUserId;
    public final /* synthetic */ String $firstMentionedUserName;
    public final /* synthetic */ String $guildName;
    public final /* synthetic */ Function1 $roleSubscriptionPurchaseContext;
    public final /* synthetic */ Message $this_getSystemMessage;
    public final /* synthetic */ Function1 $usernameRenderContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSystemMessage$getSystemMessage$1(Message message, String str, String str2, Function1 function1, Long l, Context context, String str3, Function1 function2, int i, Function1 function3, Function1 function4) {
        super(1);
        this.$this_getSystemMessage = message;
        this.$authorName = str;
        this.$firstMentionedUserName = str2;
        this.$usernameRenderContext = function1;
        this.$firstMentionedUserId = l;
        this.$context = context;
        this.$guildName = str3;
        this.$actorRenderContext = function2;
        this.$autoModSystemMessage = i;
        this.$autoModRenderContext = function3;
        this.$roleSubscriptionPurchaseContext = function4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Context context) {
        return invoke2(context);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Context context) {
        m.checkNotNullParameter(context, "$this$getString");
        Integer type = this.$this_getSystemMessage.getType();
        if (type != null && type.intValue() == 1) {
            return b.b(context, 2131896245, new Object[]{this.$authorName, this.$firstMentionedUserName}, this.$usernameRenderContext);
        }
        if (type != null && type.intValue() == 2) {
            Long l = this.$firstMentionedUserId;
            User author = this.$this_getSystemMessage.getAuthor();
            return m.areEqual(l, author != null ? Long.valueOf(author.getId()) : null) ? b.b(context, 2131896249, new Object[]{this.$authorName}, this.$usernameRenderContext) : b.b(context, 2131896247, new Object[]{this.$authorName, this.$firstMentionedUserName}, this.$usernameRenderContext);
        }
        if (type != null && type.intValue() == 4) {
            return b.b(context, 2131896184, new Object[]{this.$authorName, this.$this_getSystemMessage.getContent()}, this.$usernameRenderContext);
        }
        if (type != null && type.intValue() == 5) {
            return b.b(context, 2131896182, new Object[]{this.$authorName}, this.$usernameRenderContext);
        }
        if (type != null && type.intValue() == 6) {
            return b.b(context, 2131896241, new Object[]{this.$authorName}, this.$usernameRenderContext);
        }
        if (type != null && type.intValue() == 7) {
            return b.b(context, MessageUtils.INSTANCE.getSystemMessageUserJoin(this.$context, this.$this_getSystemMessage.getId()), new Object[]{this.$authorName}, this.$usernameRenderContext);
        }
        if (type != null && type.intValue() == 8) {
            String content = this.$this_getSystemMessage.getContent();
            int i = content == null || content.length() == 0 ? 1 : Integer.parseInt(this.$this_getSystemMessage.getContent());
            return i > 1 ? b.b(context, 2131896222, new Object[]{this.$authorName, String.valueOf(i)}, this.$usernameRenderContext) : b.b(context, 2131896218, new Object[]{this.$authorName}, this.$usernameRenderContext);
        }
        if (type != null && type.intValue() == 9) {
            return b.b(context, 2131896219, new Object[]{this.$authorName, this.$guildName, b.h(context, 2131894200, new Object[0], null, 4)}, this.$usernameRenderContext);
        }
        if (type != null && type.intValue() == 10) {
            return b.b(context, 2131896219, new Object[]{this.$authorName, this.$guildName, b.h(context, 2131894202, new Object[0], null, 4)}, this.$usernameRenderContext);
        }
        if (type != null && type.intValue() == 11) {
            return b.b(context, 2131896219, new Object[]{this.$authorName, this.$guildName, b.h(context, 2131894204, new Object[0], null, 4)}, this.$usernameRenderContext);
        }
        if (type != null && type.intValue() == 12) {
            return b.b(context, 2131896179, new Object[]{this.$authorName, this.$this_getSystemMessage.getContent()}, this.$usernameRenderContext);
        }
        if (type != null && type.intValue() == 14) {
            return b.h(context, 2131896188, new Object[0], null, 4);
        }
        if (type != null && type.intValue() == 15) {
            return b.h(context, 2131896191, new Object[0], null, 4);
        }
        if (type != null && type.intValue() == 16) {
            return b.h(context, 2131896190, new Object[0], null, 4);
        }
        if (type != null && type.intValue() == 17) {
            return b.h(context, 2131896189, new Object[0], null, 4);
        }
        if (type != null && type.intValue() == 18) {
            return b.b(context, 2131896260, new Object[]{this.$authorName, this.$this_getSystemMessage.getContent()}, this.$actorRenderContext);
        }
        if (type != null && type.intValue() == -7) {
            return b.h(context, 2131896396, new Object[0], null, 4);
        }
        if (type != null && type.intValue() == 24) {
            return b.b(context, this.$autoModSystemMessage, new Object[0], this.$autoModRenderContext);
        }
        return (type != null && type.intValue() == 25) ? MessageUtils.INSTANCE.getSystemMessageRoleSubscriptionPurchase(this.$context, this.$guildName, this.$authorName, this.$this_getSystemMessage.getRoleSubscriptionData(), this.$roleSubscriptionPurchaseContext) : b.h(context, 2131894772, new Object[0], null, 4);
    }
}
