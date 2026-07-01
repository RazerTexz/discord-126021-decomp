package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: InviteSuggestionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteSuggestionsManager$observeInviteSuggestions$1<T, R> implements b<List<? extends Long>, Observable<? extends InviteSuggestionsManager$UserAffinityData>> {
    public final /* synthetic */ InviteSuggestionsManager this$0;

    public InviteSuggestionsManager$observeInviteSuggestions$1(InviteSuggestionsManager inviteSuggestionsManager) {
        this.this$0 = inviteSuggestionsManager;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends InviteSuggestionsManager$UserAffinityData> call(List<? extends Long> list) {
        return call2((List<Long>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends InviteSuggestionsManager$UserAffinityData> call2(List<Long> list) {
        StoreUser storeUserAccess$getStoreUsers$p = InviteSuggestionsManager.access$getStoreUsers$p(this.this$0);
        m.checkNotNullExpressionValue(list, "affinityUserIds");
        return Observable.j(storeUserAccess$getStoreUsers$p.observeUsers(list).r(), InviteSuggestionsManager.access$getStoreUserRelationships$p(this.this$0).observe(list), new InviteSuggestionsManager$observeInviteSuggestions$1$1(list));
    }
}
