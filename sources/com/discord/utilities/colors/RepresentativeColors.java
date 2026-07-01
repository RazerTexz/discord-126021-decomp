package com.discord.utilities.colors;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import b.a.g.a;
import b.a.g.a$b;
import b.a.g.b;
import b.a.g.d;
import b.i.a.f.e.o.f;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineDispatcher;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import s.a.a.n;
import s.a.k0;
import s.a.x0;

/* JADX INFO: compiled from: RepresentativeColors.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RepresentativeColors<T> {
    private final HashMap<T, Integer> representativeColors = new HashMap<>();
    private final BehaviorSubject<Map<T, Integer>> representativeColorsSubject = BehaviorSubject.k0();
    public static final RepresentativeColors$Companion Companion = new RepresentativeColors$Companion(null);
    private static final int BLURPLE = Color.parseColor("#5865f2");

    public static final /* synthetic */ int access$getBLURPLE$cp() {
        return BLURPLE;
    }

    public static final /* synthetic */ RepresentativeColors$RepresentativeColorResult access$getRepresentativeColor(RepresentativeColors representativeColors, Bitmap bitmap) {
        return representativeColors.getRepresentativeColor(bitmap);
    }

    public static final /* synthetic */ HashMap access$getRepresentativeColors$p(RepresentativeColors representativeColors) {
        return representativeColors.representativeColors;
    }

    public static final /* synthetic */ BehaviorSubject access$getRepresentativeColorsSubject$p(RepresentativeColors representativeColors) {
        return representativeColors.representativeColorsSubject;
    }

    private final int getColorDistance(int c1, int c2) {
        int i = ((c1 >> 16) & 255) - ((c2 >> 16) & 255);
        int i2 = ((c1 >> 8) & 255) - ((c2 >> 8) & 255);
        int i3 = (c1 & 255) - (c2 & 255);
        return Math.abs((i3 * i3) + (i2 * i2) + (i * i));
    }

    private final List<Integer> getPrimaryColorsForBitmap(Bitmap bitmap) {
        a$b a_b = a.a;
        m.checkNotNullParameter(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        List<d> list = new a(new b(iArr), 2, null).e;
        if (!list.isEmpty()) {
            return d0.t.m.listOf(Integer.valueOf(list.get(0).d));
        }
        throw new RepresentativeColors$NoSwatchesFoundException();
    }

    private final RepresentativeColors$RepresentativeColorResult getRepresentativeColor(Bitmap bitmap) {
        try {
            int alphaComponent = ColorUtils.setAlphaComponent(getPrimaryColorsForBitmap(bitmap).get(0).intValue(), 255);
            int i = Integer.MAX_VALUE;
            int width = bitmap.getWidth();
            int i2 = alphaComponent;
            for (int i3 = 0; i3 < width; i3++) {
                int height = bitmap.getHeight();
                for (int i4 = 0; i4 < height; i4++) {
                    int alphaComponent2 = ColorUtils.setAlphaComponent(bitmap.getPixel(i3, i4), 255);
                    int colorDistance = getColorDistance(alphaComponent, alphaComponent2);
                    if (colorDistance < i) {
                        i2 = alphaComponent2;
                        i = colorDistance;
                    }
                }
            }
            return new RepresentativeColors$RepresentativeColorResult$Success(i2);
        } catch (Exception e) {
            return new RepresentativeColors$RepresentativeColorResult$Failure(e);
        }
    }

    public static /* synthetic */ void handleBitmap$default(RepresentativeColors representativeColors, Object obj, Bitmap bitmap, String str, int i, Object obj2) {
        if ((i & 4) != 0) {
            str = null;
        }
        representativeColors.handleBitmap(obj, bitmap, str);
    }

    public final Object getRepresentativeColorAsync(Bitmap bitmap, Continuation<? super RepresentativeColors$RepresentativeColorResult> continuation) {
        return f.C1(k0.a, new RepresentativeColors$getRepresentativeColorAsync$2(this, bitmap, null), continuation);
    }

    public final void handleBitmap(T id2, Bitmap bitmap, String url) {
        m.checkNotNullParameter(bitmap, "bitmap");
        x0 x0Var = x0.j;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        f.H0(x0Var, n.f3830b, null, new RepresentativeColors$handleBitmap$1(this, id2, bitmap, url, null), 2, null);
    }

    public final Observable<Integer> observeRepresentativeColor(T id2) {
        Observable<Integer> observableR = this.representativeColorsSubject.G(new RepresentativeColors$observeRepresentativeColor$1(id2)).r();
        m.checkNotNullExpressionValue(observableR, "representativeColorsSubj…  .distinctUntilChanged()");
        return observableR;
    }
}
