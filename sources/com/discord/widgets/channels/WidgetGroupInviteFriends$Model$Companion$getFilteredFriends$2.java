package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.List;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2<T, R> implements Func1<List<Long>, Observable<? extends Map<Long, Integer>>> {
    public final /* synthetic */ String $nameFilter;

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Integer>, Observable<? extends Map<Long, Integer>>> {
        public final /* synthetic */ List $excludeUserIds;

        public AnonymousClass1(List list) {
            this.$excludeUserIds = list;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Map<Long, Integer>> call(Map<Long, ? extends Integer> map) {
            return call2((Map<Long, Integer>) map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Map<Long, Integer>> call2(final Map<Long, Integer> map) {
            return StoreStream.INSTANCE.getUsers().observeUsers(map.keySet()).Y(new Func1<Map<Long, ? extends User>, Observable<? extends Map<Long, Integer>>>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends.Model.Companion.getFilteredFriends.2.1.1
                @Override // j0.k.Func1
                public final Observable<? extends Map<Long, Integer>> call(final Map<Long, ? extends User> map2) {
                    return Observable.B(map.entrySet()).y(new Func1<Map.Entry<? extends Long, ? extends Integer>, Boolean>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends.Model.Companion.getFilteredFriends.2.1.1.1
                        @Override // j0.k.Func1
                        public /* bridge */ /* synthetic */ Boolean call(Map.Entry<? extends Long, ? extends Integer> entry) {
                            return call2((Map.Entry<Long, Integer>) entry);
                        }

                        /* JADX WARN: Code duplicated, block: B:17:0x004a  */
                        /* JADX WARN: Code duplicated, block: B:22:0x0055  */
                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final Boolean call2(Map.Entry<Long, Integer> entry) {
                            boolean z2;
                            boolean zContains;
                            User user;
                            String username;
                            String lowerCase;
                            if (!AnonymousClass1.this.$excludeUserIds.contains(entry.getKey()) && map2.containsKey(entry.getKey())) {
                                Map map3 = map2;
                                if (map3 == null || (user = (User) map3.get(entry.getKey())) == null || (username = user.getUsername()) == null) {
                                    zContains = false;
                                } else {
                                    String str = WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2.this.$nameFilter;
                                    if (str != null) {
                                        lowerCase = str.toLowerCase();
                                        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                                        if (lowerCase == null) {
                                            lowerCase = "";
                                        }
                                    } else {
                                        lowerCase = "";
                                    }
                                    zContains = Strings4.contains((CharSequence) username, (CharSequence) lowerCase, true);
                                }
                                z2 = zContains;
                            }
                            return Boolean.valueOf(z2);
                        }
                    }).g0(new Func1<Map.Entry<? extends Long, ? extends Integer>, Long>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends.Model.Companion.getFilteredFriends.2.1.1.2
                        @Override // j0.k.Func1
                        public /* bridge */ /* synthetic */ Long call(Map.Entry<? extends Long, ? extends Integer> entry) {
                            return call2((Map.Entry<Long, Integer>) entry);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final Long call2(Map.Entry<Long, Integer> entry) {
                            return entry.getKey();
                        }
                    }, new Func1<Map.Entry<? extends Long, ? extends Integer>, Integer>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends.Model.Companion.getFilteredFriends.2.1.1.3
                        @Override // j0.k.Func1
                        public /* bridge */ /* synthetic */ Integer call(Map.Entry<? extends Long, ? extends Integer> entry) {
                            return call2((Map.Entry<Long, Integer>) entry);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final Integer call2(Map.Entry<Long, Integer> entry) {
                            return entry.getValue();
                        }
                    });
                }
            });
        }
    }

    public WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2(String str) {
        this.$nameFilter = str;
    }

    @Override // j0.k.Func1
    public final Observable<? extends Map<Long, Integer>> call(List<Long> list) {
        return StoreStream.INSTANCE.getUserRelationships().observeForType(1).Y(new AnonymousClass1(list));
    }
}
