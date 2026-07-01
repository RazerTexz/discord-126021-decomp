package com.discord.widgets.chat.list.adapter;

import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.ViewKt;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelInvite;
import com.discord.widgets.guilds.invite.InviteJoinHelper;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WidgetChatListAdapterItemInviteBase.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetChatListAdapterItemInviteBase extends WidgetChatListItem {

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInviteBase$joinServerOrDM$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemInviteBase.kt */
    @DebugMetadata(c = "com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInviteBase$joinServerOrDM$1", f = "WidgetChatListAdapterItemInviteBase.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(modelInvite, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInviteBase$joinServerOrDM$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemInviteBase.kt */
    @DebugMetadata(c = "com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInviteBase$joinServerOrDM$2", f = "WidgetChatListAdapterItemInviteBase.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends ContinuationImpl6 implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(modelInvite, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemInviteBase(@LayoutRes int i, WidgetChatListAdapter widgetChatListAdapter) {
        super(i, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Job joinServerOrDM$default(WidgetChatListAdapterItemInviteBase widgetChatListAdapterItemInviteBase, Class cls, ModelInvite modelInvite, Function2 function2, Function2 function3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinServerOrDM");
        }
        if ((i & 4) != 0) {
            function2 = new AnonymousClass1(null);
        }
        if ((i & 8) != 0) {
            function3 = new AnonymousClass2(null);
        }
        return widgetChatListAdapterItemInviteBase.joinServerOrDM(cls, modelInvite, function2, function3);
    }

    public final Job joinServerOrDM(Class<?> javaClass, ModelInvite invite, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInvitePostSuccess, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInviteFlowFinished) {
        Intrinsics3.checkNotNullParameter(javaClass, "javaClass");
        Intrinsics3.checkNotNullParameter(invite, "invite");
        Intrinsics3.checkNotNullParameter(onInvitePostSuccess, "onInvitePostSuccess");
        Intrinsics3.checkNotNullParameter(onInviteFlowFinished, "onInviteFlowFinished");
        InviteJoinHelper inviteJoinHelper = InviteJoinHelper.INSTANCE;
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        return inviteJoinHelper.joinViaInvite(invite, javaClass, (AppFragment) ViewKt.findFragment(view), "Invite Button Embed", (Opcodes.D2F & 16) != 0 ? new InviteJoinHelper.AnonymousClass1(null) : null, (Opcodes.D2F & 32) != 0 ? new InviteJoinHelper.AnonymousClass2(null) : onInvitePostSuccess, (Opcodes.D2F & 64) != 0 ? new InviteJoinHelper.AnonymousClass3(null) : onInviteFlowFinished, (Opcodes.D2F & 128) != 0 ? null : null);
    }
}
