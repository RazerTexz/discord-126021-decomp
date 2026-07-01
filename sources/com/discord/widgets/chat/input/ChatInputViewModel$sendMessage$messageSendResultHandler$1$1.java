package com.discord.widgets.chat.input;

import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.user.UserUtils;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$sendMessage$messageSendResultHandler$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ ChatInputViewModel$sendMessage$messageSendResultHandler$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$sendMessage$messageSendResultHandler$1$1(ChatInputViewModel$sendMessage$messageSendResultHandler$1 chatInputViewModel$sendMessage$messageSendResultHandler$1, Guild guild) {
        super(0);
        this.this$0 = chatInputViewModel$sendMessage$messageSendResultHandler$1;
        this.$guild = guild;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
        Guild guild = this.$guild;
        int iMax = Math.max(premiumUtils.getGuildMaxFileSizeMB(guild != null ? guild.getPremiumTier() : 0), premiumUtils.getMaxFileSizeMB(this.this$0.$loadedViewState.getMe()));
        PublishSubject publishSubjectAccess$getEventSubject$p = ChatInputViewModel.access$getEventSubject$p(this.this$0.this$0);
        MeUser me2 = this.this$0.$loadedViewState.getMe();
        publishSubjectAccess$getEventSubject$p.k.onNext((T) new ChatInputViewModel$Event$FilesTooLarge(iMax, Float.MAX_VALUE, Float.MAX_VALUE, me2 != null ? UserUtils.INSTANCE.isPremium(me2) : false, this.this$0.$attachmentsContext.getAttachments(), this.this$0.$attachmentsContext.getHasImage(), this.this$0.$attachmentsContext.getHasVideo(), this.this$0.$attachmentsContext.getHasGif(), this.this$0.$messageResendCompressedHandler));
    }
}
