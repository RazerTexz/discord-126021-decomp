package com.discord.utilities.images;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p109f.p161j.p170e.C1893h;
import p007b.p109f.p161j.p170e.C1898m;
import p007b.p109f.p161j.p171f.AbstractC1905c;
import p007b.p109f.p161j.p175j.AbstractC1917c;
import p507d0.C12116o;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.C12662q;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Subscriber;

/* JADX INFO: compiled from: MGImagesBitmap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImagesBitmap {
    public static final MGImagesBitmap INSTANCE = new MGImagesBitmap();

    /* JADX INFO: compiled from: MGImagesBitmap.kt */
    public static final class CloseableBitmaps implements Map<String, Bitmap>, Closeable, InterfaceC12228a {
        private final boolean recycleBitmaps;
        private final Map<String, Bitmap> underlyingMap;

        public CloseableBitmaps(Map<String, Bitmap> map, boolean z2) {
            C12238m.checkNotNullParameter(map, "underlyingMap");
            this.underlyingMap = map;
            this.recycleBitmaps = z2;
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.recycleBitmaps) {
                Iterator<Map.Entry<String, Bitmap>> it = this.underlyingMap.entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().recycle();
                }
            }
        }

        /* JADX INFO: renamed from: compute, reason: avoid collision after fix types in other method */
        public Bitmap compute2(String str, BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap compute(String str, BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: computeIfAbsent, reason: avoid collision after fix types in other method */
        public Bitmap computeIfAbsent2(String str, Function<? super String, ? extends Bitmap> function) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap computeIfAbsent(String str, Function<? super String, ? extends Bitmap> function) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: computeIfPresent, reason: avoid collision after fix types in other method */
        public Bitmap computeIfPresent2(String str, BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap computeIfPresent(String str, BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return containsKey((String) obj);
            }
            return false;
        }

        public boolean containsKey(String key) {
            C12238m.checkNotNullParameter(key, "key");
            return this.underlyingMap.containsKey(key);
        }

        public boolean containsValue(Bitmap value) {
            C12238m.checkNotNullParameter(value, "value");
            return this.underlyingMap.containsValue(value);
        }

        @Override // java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof Bitmap) {
                return containsValue((Bitmap) obj);
            }
            return false;
        }

        @Override // java.util.Map
        public final /* bridge */ Set<Map.Entry<String, Bitmap>> entrySet() {
            return getEntries();
        }

        public Bitmap get(String key) {
            C12238m.checkNotNullParameter(key, "key");
            return this.underlyingMap.get(key);
        }

        @Override // java.util.Map
        public final /* bridge */ Bitmap get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public Set<Map.Entry<String, Bitmap>> getEntries() {
            return this.underlyingMap.entrySet();
        }

        public Set<String> getKeys() {
            return this.underlyingMap.keySet();
        }

        public int getSize() {
            return this.underlyingMap.size();
        }

        public Collection<Bitmap> getValues() {
            return this.underlyingMap.values();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.underlyingMap.isEmpty();
        }

        @Override // java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return getKeys();
        }

        /* JADX INFO: renamed from: merge, reason: avoid collision after fix types in other method */
        public Bitmap merge2(String str, Bitmap bitmap, BiFunction<? super Bitmap, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap merge(String str, Bitmap bitmap, BiFunction<? super Bitmap, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final CloseableBitmaps plus(CloseableBitmaps other) {
            C12238m.checkNotNullParameter(other, "other");
            return new CloseableBitmaps(C12136h0.plus(this.underlyingMap, other.underlyingMap), this.recycleBitmaps && other.recycleBitmaps);
        }

        /* JADX INFO: renamed from: put, reason: avoid collision after fix types in other method */
        public Bitmap put2(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap put(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends String, ? extends Bitmap> map) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: putIfAbsent, reason: avoid collision after fix types in other method */
        public Bitmap putIfAbsent2(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap putIfAbsent(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public Bitmap remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public boolean remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: replace, reason: avoid collision after fix types in other method */
        public Bitmap replace2(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap replace(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ boolean replace(String str, Bitmap bitmap, Bitmap bitmap2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX INFO: renamed from: replace, reason: avoid collision after fix types in other method */
        public boolean replace2(String str, Bitmap bitmap, Bitmap bitmap2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.Map
        public final /* bridge */ Collection<Bitmap> values() {
            return getValues();
        }

        public /* synthetic */ CloseableBitmaps(Map map, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(map, (i & 2) != 0 ? true : z2);
        }
    }

    /* JADX INFO: compiled from: MGImagesBitmap.kt */
    public static final class DecodeException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DecodeException(String str) {
            super("Unable to decode image: " + str + '.');
            C12238m.checkNotNullParameter(str, "imageUri");
        }
    }

    /* JADX INFO: compiled from: MGImagesBitmap.kt */
    public static final class ImageNotFoundException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageNotFoundException(String str) {
            super("404 image not found: " + str);
            C12238m.checkNotNullParameter(str, "imageUri");
        }
    }

    /* JADX INFO: compiled from: MGImagesBitmap.kt */
    public static final /* data */ class ImageRequest {
        private final String imageUri;
        private final boolean roundAsCircle;

        public ImageRequest(String str, boolean z2) {
            C12238m.checkNotNullParameter(str, "imageUri");
            this.imageUri = str;
            this.roundAsCircle = z2;
        }

        public static /* synthetic */ ImageRequest copy$default(ImageRequest imageRequest, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = imageRequest.imageUri;
            }
            if ((i & 2) != 0) {
                z2 = imageRequest.roundAsCircle;
            }
            return imageRequest.copy(str, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getImageUri() {
            return this.imageUri;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getRoundAsCircle() {
            return this.roundAsCircle;
        }

        public final ImageRequest copy(String imageUri, boolean roundAsCircle) {
            C12238m.checkNotNullParameter(imageUri, "imageUri");
            return new ImageRequest(imageUri, roundAsCircle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImageRequest)) {
                return false;
            }
            ImageRequest imageRequest = (ImageRequest) other;
            return C12238m.areEqual(this.imageUri, imageRequest.imageUri) && this.roundAsCircle == imageRequest.roundAsCircle;
        }

        public final String getImageUri() {
            return this.imageUri;
        }

        public final boolean getRoundAsCircle() {
            return this.roundAsCircle;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            String str = this.imageUri;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.roundAsCircle;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ImageRequest(imageUri=");
            sbM833U.append(this.imageUri);
            sbM833U.append(", roundAsCircle=");
            return C1643a.m827O(sbM833U, this.roundAsCircle, ")");
        }
    }

    /* JADX INFO: compiled from: MGImagesBitmap.kt */
    public static final class MissingBitmapException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingBitmapException(String str) {
            super("Unable to decode image as bitmap: " + str);
            C12238m.checkNotNullParameter(str, "imageUri");
        }
    }

    private MGImagesBitmap() {
    }

    public static final Observable<CloseableBitmaps> getBitmaps(Set<ImageRequest> imageRequests) {
        C12238m.checkNotNullParameter(imageRequests, "imageRequests");
        ArrayList arrayList = new ArrayList();
        for (Object obj : imageRequests) {
            if (!C12103t.isBlank(((ImageRequest) obj).getImageUri())) {
                arrayList.add(obj);
            }
        }
        Observable<CloseableBitmaps> observableM11098X = Observable.m11074h0(new C12662q(arrayList)).m11082A(new InterfaceC12589b<ImageRequest, Observable<? extends Pair<? extends String, ? extends Bitmap>>>() { // from class: com.discord.utilities.images.MGImagesBitmap.getBitmaps.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Pair<String, Bitmap>> call(final ImageRequest imageRequest) {
                return MGImagesBitmap.INSTANCE.getBitmap(imageRequest.getImageUri(), imageRequest.getRoundAsCircle()).m11083G(new InterfaceC12589b<Bitmap, Pair<? extends String, ? extends Bitmap>>() { // from class: com.discord.utilities.images.MGImagesBitmap.getBitmaps.1.1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Pair<String, Bitmap> call(Bitmap bitmap) {
                        return C12116o.m10073to(imageRequest.getImageUri(), bitmap);
                    }
                });
            }
        }).m11106g0(new InterfaceC12589b<Pair<? extends String, ? extends Bitmap>, String>() { // from class: com.discord.utilities.images.MGImagesBitmap.getBitmaps.2
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ String call(Pair<? extends String, ? extends Bitmap> pair) {
                return call2((Pair<String, Bitmap>) pair);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final String call2(Pair<String, Bitmap> pair) {
                return pair.getFirst();
            }
        }, new InterfaceC12589b<Pair<? extends String, ? extends Bitmap>, Bitmap>() { // from class: com.discord.utilities.images.MGImagesBitmap.getBitmaps.3
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Bitmap call(Pair<? extends String, ? extends Bitmap> pair) {
                return call2((Pair<String, Bitmap>) pair);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Bitmap call2(Pair<String, Bitmap> pair) {
                return pair.getSecond();
            }
        }).m11083G(new InterfaceC12589b<Map<String, Bitmap>, CloseableBitmaps>() { // from class: com.discord.utilities.images.MGImagesBitmap.getBitmaps.4
            @Override // p637j0.p641k.InterfaceC12589b
            public final CloseableBitmaps call(Map<String, Bitmap> map) {
                C12238m.checkNotNullExpressionValue(map, "it");
                return new CloseableBitmaps(map, false, 2, null);
            }
        }).m11098X(C12781a.m10873a());
        C12238m.checkNotNullExpressionValue(observableM11098X, "Observable\n        .from…Schedulers.computation())");
        return observableM11098X;
    }

    private final boolean isValidUri(String imageUri) {
        Uri uri = Uri.parse(imageUri);
        C12238m.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        String scheme = uri.getScheme();
        if (scheme == null || C12103t.isBlank(scheme)) {
            return false;
        }
        String host = uri.getHost();
        if (host == null || C12103t.isBlank(host)) {
            return false;
        }
        String path = uri.getPath();
        return !(path == null || C12103t.isBlank(path));
    }

    public final Observable<Bitmap> getBitmap(final String imageUri, boolean imageIsCircle) {
        C12238m.checkNotNullParameter(imageUri, "imageUri");
        if (!isValidUri(imageUri)) {
            Observable<Bitmap> observableM11081x = Observable.m11081x(new IllegalArgumentException(C1643a.m883w("invalid uri: ", imageUri)));
            C12238m.checkNotNullExpressionValue(observableM11081x, "Observable.error(Illegal…invalid uri: $imageUri\"))");
            return observableM11081x;
        }
        C1898m c1898m = C1898m.f3788a;
        C1460d.m591y(c1898m, "ImagePipelineFactory was not initialized!");
        if (c1898m.f3799l == null) {
            c1898m.f3799l = c1898m.m1295a();
        }
        C1893h c1893h = c1898m.f3799l;
        ImageRequestBuilder imageRequest = MGImages.getImageRequest(imageUri, 0, 0, false);
        if (imageIsCircle) {
            imageRequest.f19623l = new RoundAsCirclePostprocessor(imageUri);
        }
        final DataSource<CloseableReference<AbstractC1917c>> dataSourceM1262a = c1893h.m1262a(imageRequest.m8724a(), null, ImageRequest.EnumC10667c.FULL_FETCH, null, null);
        Observable<Bitmap> observableM11074h0 = Observable.m11074h0(new Observable.InterfaceC13005a<Bitmap>() { // from class: com.discord.utilities.images.MGImagesBitmap.getBitmap.1
            @Override // p658rx.functions.Action1
            public final void call(final Subscriber<? super Bitmap> subscriber) {
                dataSourceM1262a.mo1022f(new AbstractC1905c() { // from class: com.discord.utilities.images.MGImagesBitmap.getBitmap.1.1
                    @Override // p007b.p109f.p129e.AbstractC1724d
                    public void onFailureImpl(DataSource<CloseableReference<AbstractC1917c>> dataSource) {
                        String message;
                        C12238m.checkNotNullParameter(dataSource, "dataSource");
                        Throwable thMo1020d = dataSource.mo1020d();
                        if (thMo1020d != null && (message = thMo1020d.getMessage()) != null && C12106w.contains$default((CharSequence) message, (CharSequence) "404", false, 2, (Object) null)) {
                            subscriber.onError(new ImageNotFoundException(imageUri));
                            return;
                        }
                        Subscriber subscriber2 = subscriber;
                        Throwable thMo1020d2 = dataSource.mo1020d();
                        if (thMo1020d2 == null) {
                            thMo1020d2 = new DecodeException(imageUri);
                        }
                        subscriber2.onError(thMo1020d2);
                    }

                    @Override // p007b.p109f.p161j.p171f.AbstractC1905c
                    public void onNewResultImpl(Bitmap bitmap) {
                        if (bitmap == null) {
                            subscriber.onError(new MissingBitmapException(imageUri));
                        } else {
                            subscriber.onNext(Bitmap.createBitmap(bitmap));
                            subscriber.onCompleted();
                        }
                    }
                }, new Executor() { // from class: com.discord.utilities.images.MGImagesBitmap.getBitmap.1.2
                    @Override // java.util.concurrent.Executor
                    public final void execute(Runnable runnable) {
                        runnable.run();
                    }
                });
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11074h0, "Observable.unsafeCreate …y emits the bitmap.\n    }");
        return observableM11074h0;
    }
}
