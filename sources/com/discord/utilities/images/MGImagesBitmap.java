package com.discord.utilities.images;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.f.j.e.ImagePipeline2;
import b.f.j.e.ImagePipelineFactory;
import b.f.j.f.BaseBitmapDataSubscriber;
import b.f.j.j.CloseableImage;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d0.Tuples;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import j0.k.Func1;
import j0.l.a.OnSubscribeFromIterable;
import j0.p.Schedulers2;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: compiled from: MGImagesBitmap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImagesBitmap {
    public static final MGImagesBitmap INSTANCE = new MGImagesBitmap();

    /* JADX INFO: compiled from: MGImagesBitmap.kt */
    public static final class CloseableBitmaps implements Map<String, Bitmap>, Closeable, KMarkers {
        private final boolean recycleBitmaps;
        private final Map<String, Bitmap> underlyingMap;

        public CloseableBitmaps(Map<String, Bitmap> map, boolean z2) {
            Intrinsics3.checkNotNullParameter(map, "underlyingMap");
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
            Intrinsics3.checkNotNullParameter(key, "key");
            return this.underlyingMap.containsKey(key);
        }

        public boolean containsValue(Bitmap value) {
            Intrinsics3.checkNotNullParameter(value, "value");
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
            Intrinsics3.checkNotNullParameter(key, "key");
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
            Intrinsics3.checkNotNullParameter(other, "other");
            return new CloseableBitmaps(Maps6.plus(this.underlyingMap, other.underlyingMap), this.recycleBitmaps && other.recycleBitmaps);
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
            Intrinsics3.checkNotNullParameter(str, "imageUri");
        }
    }

    /* JADX INFO: compiled from: MGImagesBitmap.kt */
    public static final class ImageNotFoundException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageNotFoundException(String str) {
            super("404 image not found: " + str);
            Intrinsics3.checkNotNullParameter(str, "imageUri");
        }
    }

    /* JADX INFO: compiled from: MGImagesBitmap.kt */
    public static final /* data */ class ImageRequest {
        private final String imageUri;
        private final boolean roundAsCircle;

        public ImageRequest(String str, boolean z2) {
            Intrinsics3.checkNotNullParameter(str, "imageUri");
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
            Intrinsics3.checkNotNullParameter(imageUri, "imageUri");
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
            return Intrinsics3.areEqual(this.imageUri, imageRequest.imageUri) && this.roundAsCircle == imageRequest.roundAsCircle;
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
            StringBuilder sbU = outline.U("ImageRequest(imageUri=");
            sbU.append(this.imageUri);
            sbU.append(", roundAsCircle=");
            return outline.O(sbU, this.roundAsCircle, ")");
        }
    }

    /* JADX INFO: compiled from: MGImagesBitmap.kt */
    public static final class MissingBitmapException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingBitmapException(String str) {
            super("Unable to decode image as bitmap: " + str);
            Intrinsics3.checkNotNullParameter(str, "imageUri");
        }
    }

    private MGImagesBitmap() {
    }

    public static final Observable<CloseableBitmaps> getBitmaps(Set<ImageRequest> imageRequests) {
        Intrinsics3.checkNotNullParameter(imageRequests, "imageRequests");
        ArrayList arrayList = new ArrayList();
        for (Object obj : imageRequests) {
            if (!StringsJVM.isBlank(((ImageRequest) obj).getImageUri())) {
                arrayList.add(obj);
            }
        }
        Observable<CloseableBitmaps> observableX = Observable.h0(new OnSubscribeFromIterable(arrayList)).A(new Func1<ImageRequest, Observable<? extends Tuples2<? extends String, ? extends Bitmap>>>() { // from class: com.discord.utilities.images.MGImagesBitmap.getBitmaps.1
            @Override // j0.k.Func1
            public final Observable<? extends Tuples2<String, Bitmap>> call(final ImageRequest imageRequest) {
                return MGImagesBitmap.INSTANCE.getBitmap(imageRequest.getImageUri(), imageRequest.getRoundAsCircle()).G(new Func1<Bitmap, Tuples2<? extends String, ? extends Bitmap>>() { // from class: com.discord.utilities.images.MGImagesBitmap.getBitmaps.1.1
                    @Override // j0.k.Func1
                    public final Tuples2<String, Bitmap> call(Bitmap bitmap) {
                        return Tuples.to(imageRequest.getImageUri(), bitmap);
                    }
                });
            }
        }).g0(new Func1<Tuples2<? extends String, ? extends Bitmap>, String>() { // from class: com.discord.utilities.images.MGImagesBitmap.getBitmaps.2
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ String call(Tuples2<? extends String, ? extends Bitmap> tuples2) {
                return call2((Tuples2<String, Bitmap>) tuples2);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final String call2(Tuples2<String, Bitmap> tuples2) {
                return tuples2.getFirst();
            }
        }, new Func1<Tuples2<? extends String, ? extends Bitmap>, Bitmap>() { // from class: com.discord.utilities.images.MGImagesBitmap.getBitmaps.3
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Bitmap call(Tuples2<? extends String, ? extends Bitmap> tuples2) {
                return call2((Tuples2<String, Bitmap>) tuples2);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Bitmap call2(Tuples2<String, Bitmap> tuples2) {
                return tuples2.getSecond();
            }
        }).G(new Func1<Map<String, Bitmap>, CloseableBitmaps>() { // from class: com.discord.utilities.images.MGImagesBitmap.getBitmaps.4
            @Override // j0.k.Func1
            public final CloseableBitmaps call(Map<String, Bitmap> map) {
                Intrinsics3.checkNotNullExpressionValue(map, "it");
                return new CloseableBitmaps(map, false, 2, null);
            }
        }).X(Schedulers2.a());
        Intrinsics3.checkNotNullExpressionValue(observableX, "Observable\n        .from…Schedulers.computation())");
        return observableX;
    }

    private final boolean isValidUri(String imageUri) {
        Uri uri = Uri.parse(imageUri);
        Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        String scheme = uri.getScheme();
        if (scheme == null || StringsJVM.isBlank(scheme)) {
            return false;
        }
        String host = uri.getHost();
        if (host == null || StringsJVM.isBlank(host)) {
            return false;
        }
        String path = uri.getPath();
        return !(path == null || StringsJVM.isBlank(path));
    }

    public final Observable<Bitmap> getBitmap(final String imageUri, boolean imageIsCircle) {
        Intrinsics3.checkNotNullParameter(imageUri, "imageUri");
        if (!isValidUri(imageUri)) {
            Observable<Bitmap> observableX = Observable.x(new IllegalArgumentException(outline.w("invalid uri: ", imageUri)));
            Intrinsics3.checkNotNullExpressionValue(observableX, "Observable.error(Illegal…invalid uri: $imageUri\"))");
            return observableX;
        }
        ImagePipelineFactory imagePipelineFactory = ImagePipelineFactory.a;
        AnimatableValueParser.y(imagePipelineFactory, "ImagePipelineFactory was not initialized!");
        if (imagePipelineFactory.l == null) {
            imagePipelineFactory.l = imagePipelineFactory.a();
        }
        ImagePipeline2 imagePipeline2 = imagePipelineFactory.l;
        ImageRequestBuilder imageRequest = MGImages.getImageRequest(imageUri, 0, 0, false);
        if (imageIsCircle) {
            imageRequest.l = new RoundAsCirclePostProcessor2(imageUri);
        }
        final DataSource<CloseableReference<CloseableImage>> dataSourceA = imagePipeline2.a(imageRequest.a(), null, ImageRequest.c.FULL_FETCH, null, null);
        Observable<Bitmap> observableH0 = Observable.h0(new Observable.a<Bitmap>() { // from class: com.discord.utilities.images.MGImagesBitmap.getBitmap.1
            @Override // rx.functions.Action1
            public final void call(final Subscriber<? super Bitmap> subscriber) {
                dataSourceA.f(new BaseBitmapDataSubscriber() { // from class: com.discord.utilities.images.MGImagesBitmap.getBitmap.1.1
                    @Override // b.f.e.BaseDataSubscriber
                    public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                        String message;
                        Intrinsics3.checkNotNullParameter(dataSource, "dataSource");
                        Throwable thD = dataSource.d();
                        if (thD != null && (message = thD.getMessage()) != null && Strings4.contains$default((CharSequence) message, (CharSequence) "404", false, 2, (Object) null)) {
                            subscriber.onError(new ImageNotFoundException(imageUri));
                            return;
                        }
                        Subscriber subscriber2 = subscriber;
                        Throwable thD2 = dataSource.d();
                        if (thD2 == null) {
                            thD2 = new DecodeException(imageUri);
                        }
                        subscriber2.onError(thD2);
                    }

                    @Override // b.f.j.f.BaseBitmapDataSubscriber
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
        Intrinsics3.checkNotNullExpressionValue(observableH0, "Observable.unsafeCreate …y emits the bitmap.\n    }");
        return observableH0;
    }
}
