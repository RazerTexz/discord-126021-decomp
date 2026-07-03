package com.discord.utilities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.p004pm.ShortcutInfoCompat;
import androidx.core.content.p004pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.colors.RepresentativeColors;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImagesBitmap;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p578f0.C12078q;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils {
    public static final ShareUtils INSTANCE = new ShareUtils();

    /* JADX INFO: compiled from: ShareUtils.kt */
    public static final /* data */ class SharedContent {
        private final CharSequence text;
        private final List<Uri> uris;

        /* JADX WARN: Multi-variable type inference failed */
        public SharedContent(CharSequence charSequence, List<? extends Uri> list) {
            this.text = charSequence;
            this.uris = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SharedContent copy$default(SharedContent sharedContent, CharSequence charSequence, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = sharedContent.text;
            }
            if ((i & 2) != 0) {
                list = sharedContent.uris;
            }
            return sharedContent.copy(charSequence, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CharSequence getText() {
            return this.text;
        }

        public final List<Uri> component2() {
            return this.uris;
        }

        public final SharedContent copy(CharSequence text, List<? extends Uri> uris) {
            return new SharedContent(text, uris);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SharedContent)) {
                return false;
            }
            SharedContent sharedContent = (SharedContent) other;
            return C12238m.areEqual(this.text, sharedContent.text) && C12238m.areEqual(this.uris, sharedContent.uris);
        }

        public final CharSequence getText() {
            return this.text;
        }

        public final List<Uri> getUris() {
            return this.uris;
        }

        public int hashCode() {
            CharSequence charSequence = this.text;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            List<Uri> list = this.uris;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("SharedContent(text=");
            sbM833U.append(this.text);
            sbM833U.append(", uris=");
            return C1643a.m824L(sbM833U, this.uris, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.ShareUtils$loadAdaptiveBitmaps$1 */
    /* JADX INFO: compiled from: ShareUtils.kt */
    public static final class C66491<T, R> implements InterfaceC12589b<MGImagesBitmap.CloseableBitmaps, Observable<? extends MGImagesBitmap.CloseableBitmaps>> {
        public final /* synthetic */ int $fillMargins;
        public final /* synthetic */ int $fullBitmapSize;
        public final /* synthetic */ int $iconSize;

        public C66491(int i, int i2, int i3) {
            this.$iconSize = i;
            this.$fullBitmapSize = i2;
            this.$fillMargins = i3;
        }

        @Override // p637j0.p641k.InterfaceC12589b
        public final Observable<? extends MGImagesBitmap.CloseableBitmaps> call(final MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
            final RepresentativeColors representativeColors = new RepresentativeColors();
            Observable<R> observableM11109n = Observable.m11058B(closeableBitmaps.entrySet()).m11109n(new InterfaceC12589b<Map.Entry<? extends String, ? extends Bitmap>, Observable<? extends Pair<? extends String, ? extends Bitmap>>>() { // from class: com.discord.utilities.ShareUtils.loadAdaptiveBitmaps.1.1
                @Override // p637j0.p641k.InterfaceC12589b
                public /* bridge */ /* synthetic */ Observable<? extends Pair<? extends String, ? extends Bitmap>> call(Map.Entry<? extends String, ? extends Bitmap> entry) {
                    return call2((Map.Entry<String, Bitmap>) entry);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends Pair<String, Bitmap>> call2(Map.Entry<String, Bitmap> entry) {
                    Observable<R> c12721k;
                    final String key = entry.getKey();
                    final Bitmap value = entry.getValue();
                    if (value.getWidth() <= 0 || value.getHeight() <= 0 || value.getPixel(0, 0) != 0) {
                        c12721k = new C12721k(0);
                    } else {
                        RepresentativeColors.handleBitmap$default(representativeColors, key, value, null, 4, null);
                        Observable<R> observableM11083G = representativeColors.observeRepresentativeColor(key).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
                        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
                        c12721k = observableM11083G.m11119z().m11104c0(2L, TimeUnit.SECONDS).m11087M(new InterfaceC12589b<Throwable, Integer>() { // from class: com.discord.utilities.ShareUtils$loadAdaptiveBitmaps$1$1$representativeColor$1
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final Integer call(Throwable th) {
                                return null;
                            }
                        });
                    }
                    return c12721k.m11083G(new InterfaceC12589b<Integer, Pair<? extends String, ? extends Bitmap>>() { // from class: com.discord.utilities.ShareUtils.loadAdaptiveBitmaps.1.1.1
                        @Override // p637j0.p641k.InterfaceC12589b
                        public final Pair<String, Bitmap> call(Integer num) {
                            String str = key;
                            MGImages mGImages = MGImages.INSTANCE;
                            Bitmap bitmap = value;
                            C66491 c66491 = C66491.this;
                            int i = c66491.$iconSize;
                            int i2 = c66491.$fullBitmapSize;
                            return C12116o.m10073to(str, mGImages.centerBitmapInTransparentBitmap(bitmap, i, i, i2, i2, c66491.$fillMargins, num != null ? num.intValue() : 0));
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11109n, "Observable.from(iconBitm…        }\n              }");
            return ObservableExtensionsKt.toMap(observableM11109n).m11083G(new InterfaceC12589b<Map<String, ? extends Bitmap>, MGImagesBitmap.CloseableBitmaps>() { // from class: com.discord.utilities.ShareUtils.loadAdaptiveBitmaps.1.2
                @Override // p637j0.p641k.InterfaceC12589b
                public /* bridge */ /* synthetic */ MGImagesBitmap.CloseableBitmaps call(Map<String, ? extends Bitmap> map) {
                    return call2((Map<String, Bitmap>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final MGImagesBitmap.CloseableBitmaps call2(Map<String, Bitmap> map) {
                    closeableBitmaps.close();
                    C12238m.checkNotNullExpressionValue(map, "bitmaps");
                    return new MGImagesBitmap.CloseableBitmaps(map, false);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$2 */
    /* JADX INFO: compiled from: ShareUtils.kt */
    public static final class C66592 extends AbstractC12240o implements Function1<Pair<? extends List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66592(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps> pair) throws IOException {
            invoke2((Pair<? extends List<Pair<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps>) pair);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<? extends List<Pair<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps> pair) throws IOException {
            List<Pair<ChannelShortcutInfo, String>> listComponent1 = pair.component1();
            MGImagesBitmap.CloseableBitmaps closeableBitmapsComponent2 = pair.component2();
            try {
                ShareUtils shareUtils = ShareUtils.INSTANCE;
                C12238m.checkNotNullExpressionValue(listComponent1, "channelAndIconUriPairs");
                Context context = this.$context;
                C12238m.checkNotNullExpressionValue(closeableBitmapsComponent2, "iconBitmaps");
                shareUtils.updateDynamicShortcuts(listComponent1, context, closeableBitmapsComponent2);
                C12201b.closeFinally(closeableBitmapsComponent2, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    C12201b.closeFinally(closeableBitmapsComponent2, th);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$4 */
    /* JADX INFO: compiled from: ShareUtils.kt */
    public static final class C66614 extends AbstractC12240o implements Function1<Map<Long, ? extends Channel>, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66614(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends Channel> map) {
            invoke2((Map<Long, Channel>) map);
            return Unit.f27425a;
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0041  */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, Channel> map) {
            boolean z2;
            List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(this.$context);
            ArrayList<ShortcutInfoCompat> arrayListM840a0 = C1643a.m840a0(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
            for (Object obj : dynamicShortcuts) {
                ShortcutInfoCompat shortcutInfoCompat = (ShortcutInfoCompat) obj;
                C12238m.checkNotNullExpressionValue(shortcutInfoCompat, "it");
                if (shortcutInfoCompat.isPinned()) {
                    String id2 = shortcutInfoCompat.getId();
                    C12238m.checkNotNullExpressionValue(id2, "it.id");
                    if (map.containsKey(Long.valueOf(Long.parseLong(id2)))) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
                if (z2) {
                    arrayListM840a0.add(obj);
                }
            }
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(arrayListM840a0, 10));
            for (ShortcutInfoCompat shortcutInfoCompat2 : arrayListM840a0) {
                C12238m.checkNotNullExpressionValue(shortcutInfoCompat2, "it");
                arrayList.add(shortcutInfoCompat2.getId());
            }
            ShortcutManagerCompat.disableShortcuts(this.$context, arrayList, "The channels these shortcuts are for no longer exist.");
            ShortcutManagerCompat.removeLongLivedShortcuts(this.$context, arrayList);
        }
    }

    private ShareUtils() {
    }

    public static /* synthetic */ void addShortcut$default(ShareUtils shareUtils, Context context, ShortcutInfoCompat shortcutInfoCompat, NotificationCompat.Builder builder, int i, Object obj) {
        if ((i & 4) != 0) {
            builder = null;
        }
        shareUtils.addShortcut(context, shortcutInfoCompat, builder);
    }

    private final Observable<List<Pair<ChannelShortcutInfo, String>>> observeChannelAndIconPairs(final Context context) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableM11083G = ObservableExtensionsKt.takeSingleUntilTimeout$default(companion.getChannels().observeDirectShareCandidates(context), 0L, false, 1, null).m11083G(new InterfaceC12589b<List<? extends Channel>, List<? extends ChannelShortcutInfo>>() { // from class: com.discord.utilities.ShareUtils.observeChannelAndIconPairs.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ List<? extends ChannelShortcutInfo> call(List<? extends Channel> list) {
                return call2((List<Channel>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<ChannelShortcutInfo> call2(List<Channel> list) {
                C12238m.checkNotNullExpressionValue(list, "it");
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
                int i = 0;
                for (T t : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        C12147n.throwIndexOverflow();
                    }
                    arrayList.add(new ChannelShortcutInfo((Channel) t, i, false));
                    i = i2;
                }
                return arrayList;
            }
        });
        Observable<Map<Long, Channel>> observableM11118y = companion.getChannels().observeGuildAndPrivateChannels().m11118y(new InterfaceC12589b<Map<Long, ? extends Channel>, Boolean>() { // from class: com.discord.utilities.ShareUtils.observeChannelAndIconPairs.2
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Map<Long, Channel> map) {
                C12238m.checkNotNullExpressionValue(map, "it");
                return Boolean.valueOf(!map.isEmpty());
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11118y, "StoreStream\n            …ilter { it.isNotEmpty() }");
        return Observable.m11076j(observableM11083G, ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11118y, 0L, false, 1, null), new Func2<List<? extends ChannelShortcutInfo>, Map<Long, ? extends Channel>, List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>>() { // from class: com.discord.utilities.ShareUtils.observeChannelAndIconPairs.3
            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>> call(List<? extends ChannelShortcutInfo> list, Map<Long, ? extends Channel> map) {
                return call2((List<ChannelShortcutInfo>) list, (Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<Pair<ChannelShortcutInfo, String>> call2(List<ChannelShortcutInfo> list, Map<Long, Channel> map) {
                C12238m.checkNotNullExpressionValue(list, "directShareChannels");
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((ChannelShortcutInfo) it.next()).getChannel().getId()));
                }
                Set set = C12163u.toSet(arrayList);
                List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(context);
                C12238m.checkNotNullExpressionValue(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
                List<ChannelShortcutInfo> listPlus = C12163u.plus((Collection) list, C12078q.map(C12078q.mapNotNull(C12078q.filter(C12078q.map(C12078q.filter(C12163u.asSequence(dynamicShortcuts), C6653x626dc25a.INSTANCE), C6654x626dc25b.INSTANCE), new C6655x626dc25c(set)), new C6656x626dc25d(map)), C6657x626dc25e.INSTANCE));
                ArrayList arrayList2 = new ArrayList();
                for (ChannelShortcutInfo channelShortcutInfo : listPlus) {
                    String forChannel$default = IconUtils.getForChannel$default(channelShortcutInfo.getChannel(), null, 2, null);
                    Pair pairM10073to = forChannel$default != null ? C12116o.m10073to(channelShortcutInfo, forChannel$default) : null;
                    if (pairM10073to != null) {
                        arrayList2.add(pairM10073to);
                    }
                }
                return arrayList2;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShortcutInfoCompat toShortcutInfo$default(ShareUtils shareUtils, Context context, long j, CharSequence charSequence, CharSequence charSequence2, IconCompat iconCompat, List list, int i, int i2, Object obj) {
        return shareUtils.toShortcutInfo(context, j, charSequence, (i2 & 8) != 0 ? charSequence : charSequence2, (i2 & 16) != 0 ? null : iconCompat, (i2 & 32) != 0 ? C12147n.emptyList() : list, (i2 & 64) != 0 ? 0 : i);
    }

    private final void updateDynamicShortcuts(List<Pair<ChannelShortcutInfo, String>> channelAndIconUriPairs, Context context, MGImagesBitmap.CloseableBitmaps iconBitmaps) {
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
            objEmptyList = C12147n.emptyList();
        }
        List list2 = (List) objEmptyList;
        Object objEmptyList2 = linkedHashMap.get(Boolean.TRUE);
        if (objEmptyList2 == null) {
            objEmptyList2 = C12147n.emptyList();
        }
        ShortcutManagerCompat.setDynamicShortcuts(context, list2);
        ShortcutManagerCompat.updateShortcuts(context, (List) objEmptyList2);
    }

    public final void addShortcut(Context context, ShortcutInfoCompat shortcutInfo, NotificationCompat.Builder notificationBuilder) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(shortcutInfo, "shortcutInfo");
        if (notificationBuilder != null) {
            notificationBuilder.setShortcutId(shortcutInfo.getId());
        }
        if (notificationBuilder != null) {
            notificationBuilder.setLocusId(new LocusIdCompat(shortcutInfo.getId()));
        }
        List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(context);
        C12238m.checkNotNullExpressionValue(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
        boolean z2 = false;
        if (!(dynamicShortcuts instanceof Collection) || !dynamicShortcuts.isEmpty()) {
            for (ShortcutInfoCompat shortcutInfoCompat : dynamicShortcuts) {
                C12238m.checkNotNullExpressionValue(shortcutInfoCompat, "it");
                if (C12238m.areEqual(shortcutInfoCompat.getId(), shortcutInfo.getId())) {
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

    public final SharedContent getSharedContent(Intent intent, boolean deleteExtras) {
        Uri uri;
        C12238m.checkNotNullParameter(intent, "intent");
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.TEXT");
        String stringExtra = intent.getStringExtra("android.intent.extra.SUBJECT");
        ArrayList arrayListArrayListOf = null;
        if (charSequenceExtra == null || C12103t.isBlank(charSequenceExtra)) {
            charSequenceExtra = !(stringExtra == null || C12103t.isBlank(stringExtra)) ? stringExtra : null;
        }
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != -1173264947) {
                if (iHashCode == -58484670 && action.equals("android.intent.action.SEND_MULTIPLE")) {
                    arrayListArrayListOf = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
                }
            } else if (action.equals("android.intent.action.SEND") && (uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM")) != null) {
                arrayListArrayListOf = C12147n.arrayListOf(uri);
            }
        }
        if (deleteExtras) {
            intent.removeExtra("android.intent.extra.TEXT");
            intent.removeExtra("android.intent.extra.SUBJECT");
            intent.removeExtra("android.intent.extra.STREAM");
        }
        return new SharedContent(charSequenceExtra, arrayListArrayListOf);
    }

    public final Observable<MGImagesBitmap.CloseableBitmaps> loadAdaptiveBitmaps(Sequence<String> iconUris) {
        C12238m.checkNotNullParameter(iconUris, "iconUris");
        int iDpToPixels = DimenUtils.dpToPixels(72);
        int iDpToPixels2 = DimenUtils.dpToPixels(108);
        int iDpToPixels3 = DimenUtils.dpToPixels(18);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> it = iconUris.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(new MGImagesBitmap.ImageRequest(it.next(), false));
        }
        Observable observableM11082A = MGImagesBitmap.getBitmaps(linkedHashSet).m11082A(new C66491(iDpToPixels, iDpToPixels2, iDpToPixels3));
        C12238m.checkNotNullExpressionValue(observableM11082A, "MGImagesBitmap\n        .…              }\n        }");
        return observableM11082A;
    }

    public final ShortcutInfoCompat toShortcutInfo(Context context, long channelId, CharSequence shortLabel, CharSequence longLabel, IconCompat icon, List<? extends Person> persons, int rank) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(shortLabel, "shortLabel");
        C12238m.checkNotNullParameter(longLabel, "longLabel");
        C12238m.checkNotNullParameter(persons, "persons");
        ShortcutInfoCompat.Builder categories = new ShortcutInfoCompat.Builder(context, String.valueOf(channelId)).setLocusId(new LocusIdCompat(String.valueOf(channelId))).setShortLabel(shortLabel).setLongLabel(longLabel).setIcon(icon).setIntent(IntentUtils.RouteBuilders.selectChannel$default(channelId, 0L, null, 6, null).setPackage(context.getPackageName())).setRank(rank).setLongLived(true).setCategories(C12148n0.setOf((Object[]) new String[]{"com.discord.intent.category.DIRECT_SHARE_TARGET", "android.shortcut.conversation"}));
        Object[] array = persons.toArray(new Person[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        ShortcutInfoCompat shortcutInfoCompatBuild = categories.setPersons((Person[]) array).build();
        C12238m.checkNotNullExpressionValue(shortcutInfoCompatBuild, "ShortcutInfoCompat.Build…ray())\n          .build()");
        return shortcutInfoCompatBuild;
    }

    public final void updateDirectShareTargets(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        Observable<List<Pair<ChannelShortcutInfo, String>>> observableObserveChannelAndIconPairs = observeChannelAndIconPairs(context);
        C12238m.checkNotNullExpressionValue(observableObserveChannelAndIconPairs, "observeChannelAndIconPairs(context)");
        Observable observableM11082A = ObservableExtensionsKt.computationLatest(observableObserveChannelAndIconPairs).m11082A(new InterfaceC12589b<List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, Observable<? extends Pair<? extends List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>>>() { // from class: com.discord.utilities.ShareUtils.updateDirectShareTargets.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Observable<? extends Pair<? extends List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>> call(List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>> list) {
                return call2((List<Pair<ChannelShortcutInfo, String>>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Pair<List<Pair<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps>> call2(final List<Pair<ChannelShortcutInfo, String>> list) {
                C12238m.checkNotNullExpressionValue(list, "channelAndIconUriPairs");
                return ShareUtils.INSTANCE.loadAdaptiveBitmaps(C12078q.map(C12163u.asSequence(list), ShareUtils$updateDirectShareTargets$1$uris$1.INSTANCE)).m11083G(new InterfaceC12589b<MGImagesBitmap.CloseableBitmaps, Pair<? extends List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>>() { // from class: com.discord.utilities.ShareUtils.updateDirectShareTargets.1.1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Pair<List<Pair<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps> call(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
                        return C12116o.m10073to(list, closeableBitmaps);
                    }
                });
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11082A, "observeChannelAndIconPai…riPairs to it }\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(observableM11082A), (Class<?>) ShareUtils.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C66592(context));
        Observable<Map<Long, Channel>> observableM11118y = StoreStream.INSTANCE.getChannels().observeGuildAndPrivateChannels().m11118y(new InterfaceC12589b<Map<Long, ? extends Channel>, Boolean>() { // from class: com.discord.utilities.ShareUtils.updateDirectShareTargets.3
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Map<Long, Channel> map) {
                C12238m.checkNotNullExpressionValue(map, "it");
                return Boolean.valueOf(!map.isEmpty());
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11118y, "StoreStream.getChannels(…ilter { it.isNotEmpty() }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11118y, 0L, false, 1, null)), (Class<?>) ShareUtils.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C66614(context));
    }

    private final ShortcutInfoCompat toShortcutInfo(Channel channel, Context context, IconCompat iconCompat, int i) {
        long id2 = channel.getId();
        String strM7679c = ChannelUtils.m7679c(channel);
        List<User> listM7683g = ChannelUtils.m7683g(channel);
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listM7683g, 10));
        for (User user : listM7683g) {
            Person personBuild = new Person.Builder().setName(user.getUsername()).setKey(user.toString()).setBot(user.getIsBot()).build();
            C12238m.checkNotNullExpressionValue(personBuild, "Person.Builder()\n       …\n                .build()");
            arrayList.add(personBuild);
        }
        return toShortcutInfo$default(this, context, id2, strM7679c, null, iconCompat, arrayList, i, 8, null);
    }
}
