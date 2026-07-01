package com.discord.utilities.images;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.c.a.a0.d;
import b.f.j.e.h;
import com.facebook.imagepipeline.request.ImageRequest$c;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d0.g0.t;
import d0.z.d.m;
import j0.l.a.q;
import j0.p.a;
import java.util.ArrayList;
import java.util.Set;
import rx.Observable;

/* JADX INFO: compiled from: MGImagesBitmap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImagesBitmap {
    public static final MGImagesBitmap INSTANCE = new MGImagesBitmap();

    private MGImagesBitmap() {
    }

    public static final Observable<MGImagesBitmap$CloseableBitmaps> getBitmaps(Set<MGImagesBitmap$ImageRequest> imageRequests) {
        m.checkNotNullParameter(imageRequests, "imageRequests");
        ArrayList arrayList = new ArrayList();
        for (Object obj : imageRequests) {
            if (!t.isBlank(((MGImagesBitmap$ImageRequest) obj).getImageUri())) {
                arrayList.add(obj);
            }
        }
        Observable<MGImagesBitmap$CloseableBitmaps> observableX = Observable.h0(new q(arrayList)).A(MGImagesBitmap$getBitmaps$1.INSTANCE).g0(MGImagesBitmap$getBitmaps$2.INSTANCE, MGImagesBitmap$getBitmaps$3.INSTANCE).G(MGImagesBitmap$getBitmaps$4.INSTANCE).X(a.a());
        m.checkNotNullExpressionValue(observableX, "Observable\n        .from…Schedulers.computation())");
        return observableX;
    }

    private final boolean isValidUri(String imageUri) {
        Uri uri = Uri.parse(imageUri);
        m.checkNotNullExpressionValue(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        String scheme = uri.getScheme();
        if (scheme == null || t.isBlank(scheme)) {
            return false;
        }
        String host = uri.getHost();
        if (host == null || t.isBlank(host)) {
            return false;
        }
        String path = uri.getPath();
        return !(path == null || t.isBlank(path));
    }

    public final Observable<Bitmap> getBitmap(String imageUri, boolean imageIsCircle) {
        m.checkNotNullParameter(imageUri, "imageUri");
        if (!isValidUri(imageUri)) {
            Observable<Bitmap> observableX = Observable.x(new IllegalArgumentException(b.d.b.a.a.w("invalid uri: ", imageUri)));
            m.checkNotNullExpressionValue(observableX, "Observable.error(Illegal…invalid uri: $imageUri\"))");
            return observableX;
        }
        b.f.j.e.m mVar = b.f.j.e.m.a;
        d.y(mVar, "ImagePipelineFactory was not initialized!");
        if (mVar.l == null) {
            mVar.l = mVar.a();
        }
        h hVar = mVar.l;
        ImageRequestBuilder imageRequest = MGImages.getImageRequest(imageUri, 0, 0, false);
        if (imageIsCircle) {
            imageRequest.l = new RoundAsCirclePostprocessor(imageUri);
        }
        Observable<Bitmap> observableH0 = Observable.h0(new MGImagesBitmap$getBitmap$1(hVar.a(imageRequest.a(), null, ImageRequest$c.FULL_FETCH, null, null), imageUri));
        m.checkNotNullExpressionValue(observableH0, "Observable.unsafeCreate …y emits the bitmap.\n    }");
        return observableH0;
    }
}
