package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import java.util.List;
import java.util.Map;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2<T, R> implements InterfaceC12589b<List<Long>, Observable<? extends Map<Long, Integer>>> {
    public final /* synthetic */ String $nameFilter;

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1 */
    /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
    public static final class C73781<T, R> implements InterfaceC12589b<Map<Long, ? extends Integer>, Observable<? extends Map<Long, Integer>>> {
        public final /* synthetic */ List $excludeUserIds;

        public C73781(List list) {
            this.$excludeUserIds = list;
        }

        @Override // p637j0.p641k.InterfaceC12589b
        public /* bridge */ /* synthetic */ Observable<? extends Map<Long, Integer>> call(Map<Long, ? extends Integer> map) {
            return call2((Map<Long, Integer>) map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Map<Long, Integer>> call2(final Map<Long, Integer> map) {
            return StoreStream.INSTANCE.getUsers().observeUsers(map.keySet()).m11099Y(new InterfaceC12589b<Map<Long, ? extends User>, Observable<? extends Map<Long, Integer>>>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends.Model.Companion.getFilteredFriends.2.1.1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends Map<Long, Integer>> call(final Map<Long, ? extends User> map2) {
                    return Observable.m11058B(map.entrySet()).m11118y(new InterfaceC12589b<Map.Entry<? extends Long, ? extends Integer>, Boolean>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends.Model.Companion.getFilteredFriends.2.1.1.1
                        @Override // p637j0.p641k.InterfaceC12589b
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
                            if (!C73781.this.$excludeUserIds.contains(entry.getKey()) && map2.containsKey(entry.getKey())) {
                                Map map3 = map2;
                                if (map3 == null || (user = (User) map3.get(entry.getKey())) == null || (username = user.getUsername()) == null) {
                                    zContains = false;
                                } else {
                                    String str = WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2.this.$nameFilter;
                                    if (str != null) {
                                        lowerCase = str.toLowerCase();
                                        C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                                        if (lowerCase == null) {
                                            lowerCase = "";
                                        }
                                    } else {
                                        lowerCase = "";
                                    }
                                    zContains = C12106w.contains((CharSequence) username, (CharSequence) lowerCase, true);
                                }
                                z2 = zContains;
                            }
                            return Boolean.valueOf(z2);
                        }
                    }).m11106g0(new InterfaceC12589b<Map.Entry<? extends Long, ? extends Integer>, Long>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends.Model.Companion.getFilteredFriends.2.1.1.2
                        @Override // p637j0.p641k.InterfaceC12589b
                        public /* bridge */ /* synthetic */ Long call(Map.Entry<? extends Long, ? extends Integer> entry) {
                            return call2((Map.Entry<Long, Integer>) entry);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final Long call2(Map.Entry<Long, Integer> entry) {
                            return entry.getKey();
                        }
                    }, new InterfaceC12589b<Map.Entry<? extends Long, ? extends Integer>, Integer>() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriends.Model.Companion.getFilteredFriends.2.1.1.3
                        @Override // p637j0.p641k.InterfaceC12589b
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

    @Override // p637j0.p641k.InterfaceC12589b
    public final Observable<? extends Map<Long, Integer>> call(List<Long> list) {
        return StoreStream.INSTANCE.getUserRelationships().observeForType(1).m11099Y(new C73781(list));
    }
}
