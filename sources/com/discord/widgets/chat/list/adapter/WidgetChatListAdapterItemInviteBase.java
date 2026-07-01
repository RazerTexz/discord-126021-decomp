package com.discord.widgets.chat.list.adapter;

import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.ViewKt;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelInvite;
import com.discord.widgets.guilds.invite.InviteJoinHelper;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WidgetChatListAdapterItemInviteBase.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetChatListAdapterItemInviteBase extends WidgetChatListItem {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemInviteBase(@LayoutRes int i, WidgetChatListAdapter widgetChatListAdapter) {
        super(i, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Job joinServerOrDM$default(WidgetChatListAdapterItemInviteBase widgetChatListAdapterItemInviteBase, Class cls, ModelInvite modelInvite, Function2 function2, Function2 function3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinServerOrDM");
        }
        if ((i & 4) != 0) {
            function2 = new WidgetChatListAdapterItemInviteBase$joinServerOrDM$1(null);
        }
        if ((i & 8) != 0) {
            function3 = new WidgetChatListAdapterItemInviteBase$joinServerOrDM$2(null);
        }
        return widgetChatListAdapterItemInviteBase.joinServerOrDM(cls, modelInvite, function2, function3);
    }

    public final Job joinServerOrDM(Class<?> javaClass, ModelInvite invite, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInvitePostSuccess, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInviteFlowFinished) {
        m.checkNotNullParameter(javaClass, "javaClass");
        m.checkNotNullParameter(invite, "invite");
        m.checkNotNullParameter(onInvitePostSuccess, "onInvitePostSuccess");
        m.checkNotNullParameter(onInviteFlowFinished, "onInviteFlowFinished");
        InviteJoinHelper inviteJoinHelper = InviteJoinHelper.INSTANCE;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        return InviteJoinHelper.joinViaInvite$default(inviteJoinHelper, invite, javaClass, (AppFragment) ViewKt.findFragment(view), "Invite Button Embed", null, onInvitePostSuccess, onInviteFlowFinished, null, Opcodes.D2F, null);
    }
}
