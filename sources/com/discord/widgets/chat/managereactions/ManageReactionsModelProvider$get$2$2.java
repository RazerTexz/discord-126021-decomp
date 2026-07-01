package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import j0.k.b;
import j0.l.e.k;
import java.util.List;
import java.util.Map;
import kotlin.Triple;
import rx.Observable;

/* JADX INFO: compiled from: ManageReactionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsModelProvider$get$2$2<T, R> implements b<Triple<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>>, Observable<? extends ManageReactionsModel>> {
    public final /* synthetic */ MeUser $me;
    public final /* synthetic */ ManageReactionsModelProvider$get$2 this$0;

    public ManageReactionsModelProvider$get$2$2(ManageReactionsModelProvider$get$2 manageReactionsModelProvider$get$2, MeUser meUser) {
        this.this$0 = manageReactionsModelProvider$get$2;
        this.$me = meUser;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ManageReactionsModel> call(Triple<? extends Boolean, ? extends List<? extends MessageReaction>, ? extends Map<Long, ? extends GuildMember>> triple) {
        return call2((Triple<Boolean, ? extends List<MessageReaction>, ? extends Map<Long, GuildMember>>) triple);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ManageReactionsModel> call2(Triple<Boolean, ? extends List<MessageReaction>, ? extends Map<Long, GuildMember>> triple) {
        Boolean boolComponent1 = triple.component1();
        List<MessageReaction> listComponent2 = triple.component2();
        return listComponent2.isEmpty() ? new k(null) : ManageReactionsModelProvider.access$getTargetedEmojiKeySubject$p(this.this$0.this$0).r().G(new ManageReactionsModelProvider$get$2$2$1(listComponent2)).Y(new ManageReactionsModelProvider$get$2$2$2(this, listComponent2, boolComponent1, triple.component3()));
    }
}
