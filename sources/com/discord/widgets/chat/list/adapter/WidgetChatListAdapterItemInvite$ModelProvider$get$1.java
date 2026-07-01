package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreInstantInvites$InviteState;
import com.discord.stores.StoreInstantInvites$InviteState$LoadFailed;
import com.discord.stores.StoreInstantInvites$InviteState$Loading;
import com.discord.stores.StoreInstantInvites$InviteState$Resolved;
import com.discord.widgets.chat.list.entries.InviteEntry;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemInvite$ModelProvider$get$1<T, R> implements b<StoreInstantInvites$InviteState, Observable<? extends WidgetChatListAdapterItemInvite$Model>> {
    public final /* synthetic */ InviteEntry $item;

    public WidgetChatListAdapterItemInvite$ModelProvider$get$1(InviteEntry inviteEntry) {
        this.$item = inviteEntry;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListAdapterItemInvite$Model> call(StoreInstantInvites$InviteState storeInstantInvites$InviteState) {
        return call2(storeInstantInvites$InviteState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListAdapterItemInvite$Model> call2(StoreInstantInvites$InviteState storeInstantInvites$InviteState) {
        if ((storeInstantInvites$InviteState instanceof StoreInstantInvites$InviteState$Loading) || (storeInstantInvites$InviteState instanceof StoreInstantInvites$InviteState$LoadFailed)) {
            return new k(WidgetChatListAdapterItemInvite$Model$Loading.INSTANCE);
        }
        return storeInstantInvites$InviteState instanceof StoreInstantInvites$InviteState$Resolved ? WidgetChatListAdapterItemInvite$ModelProvider.access$observeModel(WidgetChatListAdapterItemInvite$ModelProvider.INSTANCE, this.$item, ((StoreInstantInvites$InviteState$Resolved) storeInstantInvites$InviteState).getInvite()) : WidgetChatListAdapterItemInvite$ModelProvider.access$getInvalidInvite(WidgetChatListAdapterItemInvite$ModelProvider.INSTANCE, this.$item);
    }
}
