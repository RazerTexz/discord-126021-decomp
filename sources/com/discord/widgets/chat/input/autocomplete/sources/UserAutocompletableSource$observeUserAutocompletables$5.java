package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreUser;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import rx.Observable;

/* JADX INFO: compiled from: UserMentionableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAutocompletableSource$observeUserAutocompletables$5<T, R> implements b<List<Long>, Observable<? extends Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>>> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ UserAutocompletableSource this$0;

    public UserAutocompletableSource$observeUserAutocompletables$5(UserAutocompletableSource userAutocompletableSource, Channel channel) {
        this.this$0 = userAutocompletableSource;
        this.$channel = channel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>> call(List<Long> list) {
        return call2(list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<LeadingIdentifier, TreeSet<Autocompletable>>> call2(List<Long> list) {
        StoreUser storeUsers = this.this$0.getStoreUsers();
        m.checkNotNullExpressionValue(list, "recipientIds");
        return Observable.j(storeUsers.observeUsers(list), this.this$0.getStorePresences().observePresencesForUsers(list), new UserAutocompletableSource$observeUserAutocompletables$5$1(this)).r();
    }
}
