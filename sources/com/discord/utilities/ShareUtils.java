package com.discord.utilities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import b.d.b.a.outline;
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
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.Tuples;
import d0.f0._Sequences2;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Sets5;
import d0.t._Collections;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
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
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;

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
            return Intrinsics3.areEqual(this.text, sharedContent.text) && Intrinsics3.areEqual(this.uris, sharedContent.uris);
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
            StringBuilder sbU = outline.U("SharedContent(text=");
            sbU.append(this.text);
            sbU.append(", uris=");
            return outline.L(sbU, this.uris, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.ShareUtils$loadAdaptiveBitmaps$1, reason: invalid class name */
    /* JADX INFO: compiled from: ShareUtils.kt */
    public static final class AnonymousClass1<T, R> implements Func1<MGImagesBitmap.CloseableBitmaps, Observable<? extends MGImagesBitmap.CloseableBitmaps>> {
        public final /* synthetic */ int $fillMargins;
        public final /* synthetic */ int $fullBitmapSize;
        public final /* synthetic */ int $iconSize;

        public AnonymousClass1(int i, int i2, int i3) {
            this.$iconSize = i;
            this.$fullBitmapSize = i2;
            this.$fillMargins = i3;
        }

        @Override // j0.k.Func1
        public final Observable<? extends MGImagesBitmap.CloseableBitmaps> call(final MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
            final RepresentativeColors representativeColors = new RepresentativeColors();
            Observable<R> observableN = Observable.B(closeableBitmaps.entrySet()).n(new Func1<Map.Entry<? extends String, ? extends Bitmap>, Observable<? extends Tuples2<? extends String, ? extends Bitmap>>>() { // from class: com.discord.utilities.ShareUtils.loadAdaptiveBitmaps.1.1
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Observable<? extends Tuples2<? extends String, ? extends Bitmap>> call(Map.Entry<? extends String, ? extends Bitmap> entry) {
                    return call2((Map.Entry<String, Bitmap>) entry);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends Tuples2<String, Bitmap>> call2(Map.Entry<String, Bitmap> entry) {
                    Observable<R> scalarSynchronousObservable;
                    final String key = entry.getKey();
                    final Bitmap value = entry.getValue();
                    if (value.getWidth() <= 0 || value.getHeight() <= 0 || value.getPixel(0, 0) != 0) {
                        scalarSynchronousObservable = new ScalarSynchronousObservable(0);
                    } else {
                        RepresentativeColors.handleBitmap$default(representativeColors, key, value, null, 4, null);
                        Observable<R> observableG = representativeColors.observeRepresentativeColor(key).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
                        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
                        scalarSynchronousObservable = observableG.z().c0(2L, TimeUnit.SECONDS).M(new Func1<Throwable, Integer>() { // from class: com.discord.utilities.ShareUtils$loadAdaptiveBitmaps$1$1$representativeColor$1
                            @Override // j0.k.Func1
                            public final Integer call(Throwable th) {
                                return null;
                            }
                        });
                    }
                    return scalarSynchronousObservable.G(new Func1<Integer, Tuples2<? extends String, ? extends Bitmap>>() { // from class: com.discord.utilities.ShareUtils.loadAdaptiveBitmaps.1.1.1
                        @Override // j0.k.Func1
                        public final Tuples2<String, Bitmap> call(Integer num) {
                            String str = key;
                            MGImages mGImages = MGImages.INSTANCE;
                            Bitmap bitmap = value;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            int i = anonymousClass1.$iconSize;
                            int i2 = anonymousClass1.$fullBitmapSize;
                            return Tuples.to(str, mGImages.centerBitmapInTransparentBitmap(bitmap, i, i, i2, i2, anonymousClass1.$fillMargins, num != null ? num.intValue() : 0));
                        }
                    });
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableN, "Observable.from(iconBitm…        }\n              }");
            return ObservableExtensionsKt.toMap(observableN).G(new Func1<Map<String, ? extends Bitmap>, MGImagesBitmap.CloseableBitmaps>() { // from class: com.discord.utilities.ShareUtils.loadAdaptiveBitmaps.1.2
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ MGImagesBitmap.CloseableBitmaps call(Map<String, ? extends Bitmap> map) {
                    return call2((Map<String, Bitmap>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final MGImagesBitmap.CloseableBitmaps call2(Map<String, Bitmap> map) {
                    closeableBitmaps.close();
                    Intrinsics3.checkNotNullExpressionValue(map, "bitmaps");
                    return new MGImagesBitmap.CloseableBitmaps(map, false);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$2, reason: invalid class name */
    /* JADX INFO: compiled from: ShareUtils.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Tuples2<? extends List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps> tuples2) throws IOException {
            invoke2((Tuples2<? extends List<Tuples2<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps>) tuples2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<? extends List<Tuples2<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps> tuples2) throws IOException {
            List<Tuples2<ChannelShortcutInfo, String>> listComponent1 = tuples2.component1();
            MGImagesBitmap.CloseableBitmaps closeableBitmapsComponent2 = tuples2.component2();
            try {
                ShareUtils shareUtils = ShareUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(listComponent1, "channelAndIconUriPairs");
                Context context = this.$context;
                Intrinsics3.checkNotNullExpressionValue(closeableBitmapsComponent2, "iconBitmaps");
                shareUtils.updateDynamicShortcuts(listComponent1, context, closeableBitmapsComponent2);
                Closeable.closeFinally(closeableBitmapsComponent2, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    Closeable.closeFinally(closeableBitmapsComponent2, th);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.ShareUtils$updateDirectShareTargets$4, reason: invalid class name */
    /* JADX INFO: compiled from: ShareUtils.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Map<Long, ? extends Channel>, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends Channel> map) {
            invoke2((Map<Long, Channel>) map);
            return Unit.a;
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0041  */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, Channel> map) {
            boolean z2;
            List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(this.$context);
            ArrayList<ShortcutInfoCompat> arrayListA0 = outline.a0(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
            for (Object obj : dynamicShortcuts) {
                ShortcutInfoCompat shortcutInfoCompat = (ShortcutInfoCompat) obj;
                Intrinsics3.checkNotNullExpressionValue(shortcutInfoCompat, "it");
                if (shortcutInfoCompat.isPinned()) {
                    String id2 = shortcutInfoCompat.getId();
                    Intrinsics3.checkNotNullExpressionValue(id2, "it.id");
                    if (map.containsKey(Long.valueOf(Long.parseLong(id2)))) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
                if (z2) {
                    arrayListA0.add(obj);
                }
            }
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arrayListA0, 10));
            for (ShortcutInfoCompat shortcutInfoCompat2 : arrayListA0) {
                Intrinsics3.checkNotNullExpressionValue(shortcutInfoCompat2, "it");
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

    private final Observable<List<Tuples2<ChannelShortcutInfo, String>>> observeChannelAndIconPairs(final Context context) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableG = ObservableExtensionsKt.takeSingleUntilTimeout$default(companion.getChannels().observeDirectShareCandidates(context), 0L, false, 1, null).G(new Func1<List<? extends Channel>, List<? extends ChannelShortcutInfo>>() { // from class: com.discord.utilities.ShareUtils.observeChannelAndIconPairs.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ List<? extends ChannelShortcutInfo> call(List<? extends Channel> list) {
                return call2((List<Channel>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<ChannelShortcutInfo> call2(List<Channel> list) {
                Intrinsics3.checkNotNullExpressionValue(list, "it");
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                int i = 0;
                for (T t : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        Collections2.throwIndexOverflow();
                    }
                    arrayList.add(new ChannelShortcutInfo((Channel) t, i, false));
                    i = i2;
                }
                return arrayList;
            }
        });
        Observable<Map<Long, Channel>> observableY = companion.getChannels().observeGuildAndPrivateChannels().y(new Func1<Map<Long, ? extends Channel>, Boolean>() { // from class: com.discord.utilities.ShareUtils.observeChannelAndIconPairs.2
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Map<Long, Channel> map) {
                Intrinsics3.checkNotNullExpressionValue(map, "it");
                return Boolean.valueOf(!map.isEmpty());
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …ilter { it.isNotEmpty() }");
        return Observable.j(observableG, ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 1, null), new Func2<List<? extends ChannelShortcutInfo>, Map<Long, ? extends Channel>, List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>>() { // from class: com.discord.utilities.ShareUtils.observeChannelAndIconPairs.3
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>> call(List<? extends ChannelShortcutInfo> list, Map<Long, ? extends Channel> map) {
                return call2((List<ChannelShortcutInfo>) list, (Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<Tuples2<ChannelShortcutInfo, String>> call2(List<ChannelShortcutInfo> list, Map<Long, Channel> map) {
                Intrinsics3.checkNotNullExpressionValue(list, "directShareChannels");
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((ChannelShortcutInfo) it.next()).getChannel().getId()));
                }
                Set set = _Collections.toSet(arrayList);
                List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(context);
                Intrinsics3.checkNotNullExpressionValue(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
                List<ChannelShortcutInfo> listPlus = _Collections.plus((Collection) list, _Sequences2.map(_Sequences2.mapNotNull(_Sequences2.filter(_Sequences2.map(_Sequences2.filter(_Collections.asSequence(dynamicShortcuts), ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$1.INSTANCE), ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$2.INSTANCE), new ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$3(set)), new ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$4(map)), ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$5.INSTANCE));
                ArrayList arrayList2 = new ArrayList();
                for (ChannelShortcutInfo channelShortcutInfo : listPlus) {
                    String forChannel$default = IconUtils.getForChannel$default(channelShortcutInfo.getChannel(), null, 2, null);
                    Tuples2 tuples2 = forChannel$default != null ? Tuples.to(channelShortcutInfo, forChannel$default) : null;
                    if (tuples2 != null) {
                        arrayList2.add(tuples2);
                    }
                }
                return arrayList2;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShortcutInfoCompat toShortcutInfo$default(ShareUtils shareUtils, Context context, long j, CharSequence charSequence, CharSequence charSequence2, IconCompat iconCompat, List list, int i, int i2, Object obj) {
        return shareUtils.toShortcutInfo(context, j, charSequence, (i2 & 8) != 0 ? charSequence : charSequence2, (i2 & 16) != 0 ? null : iconCompat, (i2 & 32) != 0 ? Collections2.emptyList() : list, (i2 & 64) != 0 ? 0 : i);
    }

    private final void updateDynamicShortcuts(List<Tuples2<ChannelShortcutInfo, String>> channelAndIconUriPairs, Context context, MGImagesBitmap.CloseableBitmaps iconBitmaps) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = channelAndIconUriPairs.iterator();
        while (it.hasNext()) {
            Tuples2 tuples2 = (Tuples2) it.next();
            Boolean boolValueOf = Boolean.valueOf(((ChannelShortcutInfo) tuples2.component1()).isPinnedOnly());
            Object arrayList = linkedHashMap.get(boolValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(boolValueOf, arrayList);
            }
            List list = (List) arrayList;
            ChannelShortcutInfo channelShortcutInfo = (ChannelShortcutInfo) tuples2.component1();
            String str = (String) tuples2.component2();
            ShareUtils shareUtils = INSTANCE;
            Channel channel = channelShortcutInfo.getChannel();
            Bitmap bitmap = (Bitmap) iconBitmaps.get((Object) str);
            list.add(shareUtils.toShortcutInfo(channel, context, bitmap != null ? IconCompat.createWithAdaptiveBitmap(bitmap) : null, channelShortcutInfo.getRank()));
        }
        Object objEmptyList = linkedHashMap.get(Boolean.FALSE);
        if (objEmptyList == null) {
            objEmptyList = Collections2.emptyList();
        }
        List list2 = (List) objEmptyList;
        Object objEmptyList2 = linkedHashMap.get(Boolean.TRUE);
        if (objEmptyList2 == null) {
            objEmptyList2 = Collections2.emptyList();
        }
        ShortcutManagerCompat.setDynamicShortcuts(context, list2);
        ShortcutManagerCompat.updateShortcuts(context, (List) objEmptyList2);
    }

    public final void addShortcut(Context context, ShortcutInfoCompat shortcutInfo, NotificationCompat.Builder notificationBuilder) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(shortcutInfo, "shortcutInfo");
        if (notificationBuilder != null) {
            notificationBuilder.setShortcutId(shortcutInfo.getId());
        }
        if (notificationBuilder != null) {
            notificationBuilder.setLocusId(new LocusIdCompat(shortcutInfo.getId()));
        }
        List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(context);
        Intrinsics3.checkNotNullExpressionValue(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
        boolean z2 = false;
        if (!(dynamicShortcuts instanceof Collection) || !dynamicShortcuts.isEmpty()) {
            for (ShortcutInfoCompat shortcutInfoCompat : dynamicShortcuts) {
                Intrinsics3.checkNotNullExpressionValue(shortcutInfoCompat, "it");
                if (Intrinsics3.areEqual(shortcutInfoCompat.getId(), shortcutInfo.getId())) {
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
        Intrinsics3.checkNotNullParameter(intent, "intent");
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.TEXT");
        String stringExtra = intent.getStringExtra("android.intent.extra.SUBJECT");
        ArrayList arrayListArrayListOf = null;
        if (charSequenceExtra == null || StringsJVM.isBlank(charSequenceExtra)) {
            charSequenceExtra = !(stringExtra == null || StringsJVM.isBlank(stringExtra)) ? stringExtra : null;
        }
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != -1173264947) {
                if (iHashCode == -58484670 && action.equals("android.intent.action.SEND_MULTIPLE")) {
                    arrayListArrayListOf = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
                }
            } else if (action.equals("android.intent.action.SEND") && (uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM")) != null) {
                arrayListArrayListOf = Collections2.arrayListOf(uri);
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
        Intrinsics3.checkNotNullParameter(iconUris, "iconUris");
        int iDpToPixels = DimenUtils.dpToPixels(72);
        int iDpToPixels2 = DimenUtils.dpToPixels(108);
        int iDpToPixels3 = DimenUtils.dpToPixels(18);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> it = iconUris.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(new MGImagesBitmap.ImageRequest(it.next(), false));
        }
        Observable observableA = MGImagesBitmap.getBitmaps(linkedHashSet).A(new AnonymousClass1(iDpToPixels, iDpToPixels2, iDpToPixels3));
        Intrinsics3.checkNotNullExpressionValue(observableA, "MGImagesBitmap\n        .…              }\n        }");
        return observableA;
    }

    public final ShortcutInfoCompat toShortcutInfo(Context context, long channelId, CharSequence shortLabel, CharSequence longLabel, IconCompat icon, List<? extends Person> persons, int rank) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(shortLabel, "shortLabel");
        Intrinsics3.checkNotNullParameter(longLabel, "longLabel");
        Intrinsics3.checkNotNullParameter(persons, "persons");
        ShortcutInfoCompat.Builder categories = new ShortcutInfoCompat.Builder(context, String.valueOf(channelId)).setLocusId(new LocusIdCompat(String.valueOf(channelId))).setShortLabel(shortLabel).setLongLabel(longLabel).setIcon(icon).setIntent(IntentUtils.RouteBuilders.selectChannel$default(channelId, 0L, null, 6, null).setPackage(context.getPackageName())).setRank(rank).setLongLived(true).setCategories(Sets5.setOf((Object[]) new String[]{"com.discord.intent.category.DIRECT_SHARE_TARGET", "android.shortcut.conversation"}));
        Object[] array = persons.toArray(new Person[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        ShortcutInfoCompat shortcutInfoCompatBuild = categories.setPersons((Person[]) array).build();
        Intrinsics3.checkNotNullExpressionValue(shortcutInfoCompatBuild, "ShortcutInfoCompat.Build…ray())\n          .build()");
        return shortcutInfoCompatBuild;
    }

    public final void updateDirectShareTargets(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Observable<List<Tuples2<ChannelShortcutInfo, String>>> observableObserveChannelAndIconPairs = observeChannelAndIconPairs(context);
        Intrinsics3.checkNotNullExpressionValue(observableObserveChannelAndIconPairs, "observeChannelAndIconPairs(context)");
        Observable observableA = ObservableExtensionsKt.computationLatest(observableObserveChannelAndIconPairs).A(new Func1<List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, Observable<? extends Tuples2<? extends List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>>>() { // from class: com.discord.utilities.ShareUtils.updateDirectShareTargets.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Tuples2<? extends List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>> call(List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>> list) {
                return call2((List<Tuples2<ChannelShortcutInfo, String>>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Tuples2<List<Tuples2<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps>> call2(final List<Tuples2<ChannelShortcutInfo, String>> list) {
                Intrinsics3.checkNotNullExpressionValue(list, "channelAndIconUriPairs");
                return ShareUtils.INSTANCE.loadAdaptiveBitmaps(_Sequences2.map(_Collections.asSequence(list), ShareUtils$updateDirectShareTargets$1$uris$1.INSTANCE)).G(new Func1<MGImagesBitmap.CloseableBitmaps, Tuples2<? extends List<? extends Tuples2<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap.CloseableBitmaps>>() { // from class: com.discord.utilities.ShareUtils.updateDirectShareTargets.1.1
                    @Override // j0.k.Func1
                    public final Tuples2<List<Tuples2<ChannelShortcutInfo, String>>, MGImagesBitmap.CloseableBitmaps> call(MGImagesBitmap.CloseableBitmaps closeableBitmaps) {
                        return Tuples.to(list, closeableBitmaps);
                    }
                });
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableA, "observeChannelAndIconPai…riPairs to it }\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(observableA), (Class<?>) ShareUtils.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(context));
        Observable<Map<Long, Channel>> observableY = StoreStream.INSTANCE.getChannels().observeGuildAndPrivateChannels().y(new Func1<Map<Long, ? extends Channel>, Boolean>() { // from class: com.discord.utilities.ShareUtils.updateDirectShareTargets.3
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Map<Long, Channel> map) {
                Intrinsics3.checkNotNullExpressionValue(map, "it");
                return Boolean.valueOf(!map.isEmpty());
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream.getChannels(…ilter { it.isNotEmpty() }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 1, null)), (Class<?>) ShareUtils.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass4(context));
    }

    private final ShortcutInfoCompat toShortcutInfo(Channel channel, Context context, IconCompat iconCompat, int i) {
        long id2 = channel.getId();
        String strC = ChannelUtils.c(channel);
        List<User> listG = ChannelUtils.g(channel);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listG, 10));
        for (User user : listG) {
            Person personBuild = new Person.Builder().setName(user.getUsername()).setKey(user.toString()).setBot(user.getIsBot()).build();
            Intrinsics3.checkNotNullExpressionValue(personBuild, "Person.Builder()\n       …\n                .build()");
            arrayList.add(personBuild);
        }
        return toShortcutInfo$default(this, context, id2, strC, null, iconCompat, arrayList, i, 8, null);
    }
}
