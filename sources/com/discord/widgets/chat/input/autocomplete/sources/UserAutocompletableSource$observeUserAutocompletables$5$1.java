package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.z.d.m;
import java.util.Map;
import java.util.TreeSet;
import rx.functions.Func2;

/* JADX INFO: compiled from: UserMentionableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAutocompletableSource$observeUserAutocompletables$5$1<T1, T2, R> implements Func2<Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>> {
    public final /* synthetic */ UserAutocompletableSource$observeUserAutocompletables$5 this$0;

    public UserAutocompletableSource$observeUserAutocompletables$5$1(UserAutocompletableSource$observeUserAutocompletables$5 userAutocompletableSource$observeUserAutocompletables$5) {
        this.this$0 = userAutocompletableSource$observeUserAutocompletables$5;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(Map<Long, ? extends User> map, Map<Long, ? extends Presence> map2) {
        return call2(map, (Map<Long, Presence>) map2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(Map<Long, ? extends User> map, Map<Long, Presence> map2) {
        UserAutocompletableSource userAutocompletableSource = this.this$0.this$0;
        m.checkNotNullExpressionValue(map, "users");
        m.checkNotNullExpressionValue(map2, "presences");
        return UserAutocompletableSource.access$createAutocompletablesForDmUsers(userAutocompletableSource, map, map2, this.this$0.$channel.q());
    }
}
