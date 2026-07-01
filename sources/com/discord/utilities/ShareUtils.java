package com.discord.utilities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.Person;
import androidx.core.app.Person$Builder;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompat$Builder;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.images.MGImagesBitmap;
import com.discord.utilities.images.MGImagesBitmap$CloseableBitmaps;
import com.discord.utilities.images.MGImagesBitmap$ImageRequest;
import com.discord.utilities.intent.IntentUtils$RouteBuilders;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.t;
import d0.t.n;
import d0.t.n0;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import rx.Observable;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils {
    public static final ShareUtils INSTANCE = new ShareUtils();

    private ShareUtils() {
    }

    public static final /* synthetic */ void access$updateDynamicShortcuts(ShareUtils shareUtils, List list, Context context, MGImagesBitmap$CloseableBitmaps mGImagesBitmap$CloseableBitmaps) {
        shareUtils.updateDynamicShortcuts(list, context, mGImagesBitmap$CloseableBitmaps);
    }

    public static /* synthetic */ void addShortcut$default(ShareUtils shareUtils, Context context, ShortcutInfoCompat shortcutInfoCompat, NotificationCompat$Builder notificationCompat$Builder, int i, Object obj) {
        if ((i & 4) != 0) {
            notificationCompat$Builder = null;
        }
        shareUtils.addShortcut(context, shortcutInfoCompat, notificationCompat$Builder);
    }

    private final Observable<List<Pair<ChannelShortcutInfo, String>>> observeChannelAndIconPairs(Context context) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableG = ObservableExtensionsKt.takeSingleUntilTimeout$default(storeStream$Companion.getChannels().observeDirectShareCandidates(context), 0L, false, 1, null).G(ShareUtils$observeChannelAndIconPairs$1.INSTANCE);
        Observable<Map<Long, Channel>> observableY = storeStream$Companion.getChannels().observeGuildAndPrivateChannels().y(ShareUtils$observeChannelAndIconPairs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "StoreStream\n            …ilter { it.isNotEmpty() }");
        return Observable.j(observableG, ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 1, null), new ShareUtils$observeChannelAndIconPairs$3(context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShortcutInfoCompat toShortcutInfo$default(ShareUtils shareUtils, Context context, long j, CharSequence charSequence, CharSequence charSequence2, IconCompat iconCompat, List list, int i, int i2, Object obj) {
        return shareUtils.toShortcutInfo(context, j, charSequence, (i2 & 8) != 0 ? charSequence : charSequence2, (i2 & 16) != 0 ? null : iconCompat, (i2 & 32) != 0 ? n.emptyList() : list, (i2 & 64) != 0 ? 0 : i);
    }

    private final void updateDynamicShortcuts(List<Pair<ChannelShortcutInfo, String>> channelAndIconUriPairs, Context context, MGImagesBitmap$CloseableBitmaps iconBitmaps) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = channelAndIconUriPairs.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            Boolean boolValueOf = Boolean.valueOf(((ChannelShortcutInfo) pair.component1()).isPinnedOnly());
            Object arrayList = linkedHashMap.get(boolValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(boolValueOf, arrayList);
            }
            List list = (List) arrayList;
            ChannelShortcutInfo channelShortcutInfo = (ChannelShortcutInfo) pair.component1();
            String str = (String) pair.component2();
            ShareUtils shareUtils = INSTANCE;
            Channel channel = channelShortcutInfo.getChannel();
            Bitmap bitmap = (Bitmap) iconBitmaps.get((Object) str);
            list.add(shareUtils.toShortcutInfo(channel, context, bitmap != null ? IconCompat.createWithAdaptiveBitmap(bitmap) : null, channelShortcutInfo.getRank()));
        }
        Object objEmptyList = linkedHashMap.get(Boolean.FALSE);
        if (objEmptyList == null) {
            objEmptyList = n.emptyList();
        }
        List list2 = (List) objEmptyList;
        Object objEmptyList2 = linkedHashMap.get(Boolean.TRUE);
        if (objEmptyList2 == null) {
            objEmptyList2 = n.emptyList();
        }
        ShortcutManagerCompat.setDynamicShortcuts(context, list2);
        ShortcutManagerCompat.updateShortcuts(context, (List) objEmptyList2);
    }

    public final void addShortcut(Context context, ShortcutInfoCompat shortcutInfo, NotificationCompat$Builder notificationBuilder) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(shortcutInfo, "shortcutInfo");
        if (notificationBuilder != null) {
            notificationBuilder.setShortcutId(shortcutInfo.getId());
        }
        if (notificationBuilder != null) {
            notificationBuilder.setLocusId(new LocusIdCompat(shortcutInfo.getId()));
        }
        List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(context);
        m.checkNotNullExpressionValue(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
        boolean z2 = false;
        if (!(dynamicShortcuts instanceof Collection) || !dynamicShortcuts.isEmpty()) {
            for (ShortcutInfoCompat shortcutInfoCompat : dynamicShortcuts) {
                m.checkNotNullExpressionValue(shortcutInfoCompat, "it");
                if (m.areEqual(shortcutInfoCompat.getId(), shortcutInfo.getId())) {
                    z2 = true;
                    break;
                }
            }
        }
        if (z2) {
            return;
        }
        ShortcutManagerCompat.pushDynamicShortcut(context, shortcutInfo);
    }

    public final ShareUtils$SharedContent getSharedContent(Intent intent, boolean deleteExtras) {
        Uri uri;
        m.checkNotNullParameter(intent, "intent");
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.TEXT");
        String stringExtra = intent.getStringExtra("android.intent.extra.SUBJECT");
        ArrayList arrayListArrayListOf = null;
        if (charSequenceExtra == null || t.isBlank(charSequenceExtra)) {
            charSequenceExtra = !(stringExtra == null || t.isBlank(stringExtra)) ? stringExtra : null;
        }
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != -1173264947) {
                if (iHashCode == -58484670 && action.equals("android.intent.action.SEND_MULTIPLE")) {
                    arrayListArrayListOf = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
                }
            } else if (action.equals("android.intent.action.SEND") && (uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM")) != null) {
                arrayListArrayListOf = n.arrayListOf(uri);
            }
        }
        if (deleteExtras) {
            intent.removeExtra("android.intent.extra.TEXT");
            intent.removeExtra("android.intent.extra.SUBJECT");
            intent.removeExtra("android.intent.extra.STREAM");
        }
        return new ShareUtils$SharedContent(charSequenceExtra, arrayListArrayListOf);
    }

    public final Observable<MGImagesBitmap$CloseableBitmaps> loadAdaptiveBitmaps(Sequence<String> iconUris) {
        m.checkNotNullParameter(iconUris, "iconUris");
        int iDpToPixels = DimenUtils.dpToPixels(72);
        int iDpToPixels2 = DimenUtils.dpToPixels(108);
        int iDpToPixels3 = DimenUtils.dpToPixels(18);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> it = iconUris.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(new MGImagesBitmap$ImageRequest(it.next(), false));
        }
        Observable observableA = MGImagesBitmap.getBitmaps(linkedHashSet).A(new ShareUtils$loadAdaptiveBitmaps$1(iDpToPixels, iDpToPixels2, iDpToPixels3));
        m.checkNotNullExpressionValue(observableA, "MGImagesBitmap\n        .…              }\n        }");
        return observableA;
    }

    public final ShortcutInfoCompat toShortcutInfo(Context context, long channelId, CharSequence shortLabel, CharSequence longLabel, IconCompat icon, List<? extends Person> persons, int rank) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(shortLabel, "shortLabel");
        m.checkNotNullParameter(longLabel, "longLabel");
        m.checkNotNullParameter(persons, "persons");
        ShortcutInfoCompat$Builder categories = new ShortcutInfoCompat$Builder(context, String.valueOf(channelId)).setLocusId(new LocusIdCompat(String.valueOf(channelId))).setShortLabel(shortLabel).setLongLabel(longLabel).setIcon(icon).setIntent(IntentUtils$RouteBuilders.selectChannel$default(channelId, 0L, null, 6, null).setPackage(context.getPackageName())).setRank(rank).setLongLived(true).setCategories(n0.setOf((Object[]) new String[]{"com.discord.intent.category.DIRECT_SHARE_TARGET", "android.shortcut.conversation"}));
        Object[] array = persons.toArray(new Person[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        ShortcutInfoCompat shortcutInfoCompatBuild = categories.setPersons((Person[]) array).build();
        m.checkNotNullExpressionValue(shortcutInfoCompatBuild, "ShortcutInfoCompat.Build…ray())\n          .build()");
        return shortcutInfoCompatBuild;
    }

    public final void updateDirectShareTargets(Context context) {
        m.checkNotNullParameter(context, "context");
        Observable<List<Pair<ChannelShortcutInfo, String>>> observableObserveChannelAndIconPairs = observeChannelAndIconPairs(context);
        m.checkNotNullExpressionValue(observableObserveChannelAndIconPairs, "observeChannelAndIconPairs(context)");
        Observable observableA = ObservableExtensionsKt.computationLatest(observableObserveChannelAndIconPairs).A(ShareUtils$updateDirectShareTargets$1.INSTANCE);
        m.checkNotNullExpressionValue(observableA, "observeChannelAndIconPai…riPairs to it }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableA), ShareUtils.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ShareUtils$updateDirectShareTargets$2(context), 60, (Object) null);
        Observable<Map<Long, Channel>> observableY = StoreStream.Companion.getChannels().observeGuildAndPrivateChannels().y(ShareUtils$updateDirectShareTargets$3.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "StoreStream.getChannels(…ilter { it.isNotEmpty() }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 1, null)), ShareUtils.class, context, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ShareUtils$updateDirectShareTargets$4(context), 60, (Object) null);
    }

    private final ShortcutInfoCompat toShortcutInfo(Channel channel, Context context, IconCompat iconCompat, int i) {
        long id2 = channel.getId();
        String strC = ChannelUtils.c(channel);
        List<User> listG = ChannelUtils.g(channel);
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listG, 10));
        for (User user : listG) {
            Person personBuild = new Person$Builder().setName(user.getUsername()).setKey(user.toString()).setBot(user.getIsBot()).build();
            m.checkNotNullExpressionValue(personBuild, "Person.Builder()\n       …\n                .build()");
            arrayList.add(personBuild);
        }
        return toShortcutInfo$default(this, context, id2, strC, null, iconCompat, arrayList, i, 8, null);
    }
}
