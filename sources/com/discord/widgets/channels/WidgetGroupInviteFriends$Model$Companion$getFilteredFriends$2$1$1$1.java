package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import d0.g0.w;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1$1<T, R> implements b<Map$Entry<? extends Long, ? extends Integer>, Boolean> {
    public final /* synthetic */ Map $users;
    public final /* synthetic */ WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1 this$0;

    public WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1$1(WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1 widgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1, Map map) {
        this.this$0 = widgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1;
        this.$users = map;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Map$Entry<? extends Long, ? extends Integer> map$Entry) {
        return call2((Map$Entry<Long, Integer>) map$Entry);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004a  */
    /* JADX WARN: Code duplicated, block: B:22:0x0055  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Map$Entry<Long, Integer> map$Entry) {
        boolean z2;
        boolean zContains;
        User user;
        String username;
        String lowerCase;
        if (!this.this$0.this$0.$excludeUserIds.contains(map$Entry.getKey()) && this.$users.containsKey(map$Entry.getKey())) {
            Map map = this.$users;
            if (map == null || (user = (User) map.get(map$Entry.getKey())) == null || (username = user.getUsername()) == null) {
                zContains = false;
            } else {
                String str = this.this$0.this$0.this$0.$nameFilter;
                if (str != null) {
                    lowerCase = str.toLowerCase();
                    m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                    if (lowerCase == null) {
                        lowerCase = "";
                    }
                } else {
                    lowerCase = "";
                }
                zContains = w.contains((CharSequence) username, (CharSequence) lowerCase, true);
            }
            z2 = zContains;
        }
        return Boolean.valueOf(z2);
    }
}
