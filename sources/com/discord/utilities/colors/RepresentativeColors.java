package com.discord.utilities.colors;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import b.a.g.ColorCutQuantizer;
import b.a.g.ColorHistogram;
import b.a.g.Swatch;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.Result3;
import d0.Tuples;
import d0.t.CollectionsJVM;
import d0.t.Maps6;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.w.i.a.boxing;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import s.a.CoroutineScope2;
import s.a.Dispatchers;
import s.a.a.MainDispatchers;

/* JADX INFO: compiled from: RepresentativeColors.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RepresentativeColors<T> {
    private final HashMap<T, Integer> representativeColors = new HashMap<>();
    private final BehaviorSubject<Map<T, Integer>> representativeColorsSubject = BehaviorSubject.k0();
    private static final int BLURPLE = Color.parseColor("#5865f2");

    /* JADX INFO: compiled from: RepresentativeColors.kt */
    public static final class NoSwatchesFoundException extends RuntimeException {
    }

    /* JADX INFO: compiled from: RepresentativeColors.kt */
    public static abstract class RepresentativeColorResult {

        /* JADX INFO: compiled from: RepresentativeColors.kt */
        public static final /* data */ class Failure extends RepresentativeColorResult {
            private final Exception exception;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failure(Exception exc) {
                super(null);
                Intrinsics3.checkNotNullParameter(exc, "exception");
                this.exception = exc;
            }

            public static /* synthetic */ Failure copy$default(Failure failure, Exception exc, int i, Object obj) {
                if ((i & 1) != 0) {
                    exc = failure.exception;
                }
                return failure.copy(exc);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Exception getException() {
                return this.exception;
            }

            public final Failure copy(Exception exception) {
                Intrinsics3.checkNotNullParameter(exception, "exception");
                return new Failure(exception);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Failure) && Intrinsics3.areEqual(this.exception, ((Failure) other).exception);
                }
                return true;
            }

            public final Exception getException() {
                return this.exception;
            }

            public int hashCode() {
                Exception exc = this.exception;
                if (exc != null) {
                    return exc.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Failure(exception=");
                sbU.append(this.exception);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: RepresentativeColors.kt */
        public static final /* data */ class Success extends RepresentativeColorResult {
            private final int color;

            public Success(@ColorInt int i) {
                super(null);
                this.color = i;
            }

            public static /* synthetic */ Success copy$default(Success success, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = success.color;
                }
                return success.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getColor() {
                return this.color;
            }

            public final Success copy(@ColorInt int color) {
                return new Success(color);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Success) && this.color == ((Success) other).color;
                }
                return true;
            }

            public final int getColor() {
                return this.color;
            }

            public int hashCode() {
                return this.color;
            }

            public String toString() {
                return outline.B(outline.U("Success(color="), this.color, ")");
            }
        }

        private RepresentativeColorResult() {
        }

        public /* synthetic */ RepresentativeColorResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.colors.RepresentativeColors$getRepresentativeColorAsync$2, reason: invalid class name */
    /* JADX INFO: compiled from: RepresentativeColors.kt */
    @DebugMetadata(c = "com.discord.utilities.colors.RepresentativeColors$getRepresentativeColorAsync$2", f = "RepresentativeColors.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super RepresentativeColorResult>, Object> {
        public final /* synthetic */ Bitmap $bitmap;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Bitmap bitmap, Continuation continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass2(this.$bitmap, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RepresentativeColorResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            return RepresentativeColors.this.getRepresentativeColor(this.$bitmap);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.colors.RepresentativeColors$handleBitmap$1, reason: invalid class name */
    /* JADX INFO: compiled from: RepresentativeColors.kt */
    @DebugMetadata(c = "com.discord.utilities.colors.RepresentativeColors$handleBitmap$1", f = "RepresentativeColors.kt", l = {59}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Bitmap $bitmap;
        public final /* synthetic */ Object $id;
        public final /* synthetic */ String $url;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Object obj, Bitmap bitmap, String str, Continuation continuation) {
            super(2, continuation);
            this.$id = obj;
            this.$bitmap = bitmap;
            this.$url = str;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(this.$id, this.$bitmap, this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i;
            int color;
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                Result3.throwOnFailure(obj);
                if (RepresentativeColors.this.representativeColors.containsKey(this.$id)) {
                    return Unit.a;
                }
                if (this.$bitmap.isRecycled()) {
                    i = RepresentativeColors.BLURPLE;
                } else {
                    Bitmap bitmapCopy = this.$bitmap.copy(Bitmap.Config.ARGB_8888, false);
                    RepresentativeColors representativeColors = RepresentativeColors.this;
                    Intrinsics3.checkNotNullExpressionValue(bitmapCopy, "copiedBitmap");
                    this.label = 1;
                    obj = representativeColors.getRepresentativeColorAsync(bitmapCopy, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                RepresentativeColors.this.representativeColors.put(this.$id, boxing.boxInt(i));
                RepresentativeColors.this.representativeColorsSubject.onNext(RepresentativeColors.this.representativeColors);
                return Unit.a;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            RepresentativeColorResult representativeColorResult = (RepresentativeColorResult) obj;
            if (representativeColorResult instanceof RepresentativeColorResult.Success) {
                color = ((RepresentativeColorResult.Success) representativeColorResult).getColor();
            } else {
                if (!(representativeColorResult instanceof RepresentativeColorResult.Failure)) {
                    throw new NoWhenBranchMatchedException();
                }
                color = RepresentativeColors.BLURPLE;
            }
            if (representativeColorResult instanceof RepresentativeColorResult.Failure) {
                AppLog appLog = AppLog.g;
                Exception exception = ((RepresentativeColorResult.Failure) representativeColorResult).getException();
                Tuples2[] tuples2Arr = new Tuples2[4];
                tuples2Arr[0] = Tuples.to(ModelAuditLogEntry.CHANGE_KEY_ID, String.valueOf(this.$id));
                tuples2Arr[1] = Tuples.to("bitmapWidth", String.valueOf(this.$bitmap.getWidth()));
                tuples2Arr[2] = Tuples.to("bitmapHeight", String.valueOf(this.$bitmap.getHeight()));
                String str = this.$url;
                if (str == null) {
                    str = "not provided";
                }
                tuples2Arr[3] = Tuples.to("url", str);
                appLog.e("Failed to get representative color for entity", exception, Maps6.mapOf(tuples2Arr));
            }
            i = color;
            RepresentativeColors.this.representativeColors.put(this.$id, boxing.boxInt(i));
            RepresentativeColors.this.representativeColorsSubject.onNext(RepresentativeColors.this.representativeColors);
            return Unit.a;
        }
    }

    private final int getColorDistance(int c1, int c2) {
        int i = ((c1 >> 16) & 255) - ((c2 >> 16) & 255);
        int i2 = ((c1 >> 8) & 255) - ((c2 >> 8) & 255);
        int i3 = (c1 & 255) - (c2 & 255);
        return Math.abs((i3 * i3) + (i2 * i2) + (i * i));
    }

    private final List<Integer> getPrimaryColorsForBitmap(Bitmap bitmap) {
        ColorCutQuantizer.b bVar = ColorCutQuantizer.a;
        Intrinsics3.checkNotNullParameter(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        List<Swatch> list = new ColorCutQuantizer(new ColorHistogram(iArr), 2, null).e;
        if (!list.isEmpty()) {
            return CollectionsJVM.listOf(Integer.valueOf(list.get(0).d));
        }
        throw new NoSwatchesFoundException();
    }

    private final RepresentativeColorResult getRepresentativeColor(Bitmap bitmap) {
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
            return new RepresentativeColorResult.Success(i2);
        } catch (Exception e) {
            return new RepresentativeColorResult.Failure(e);
        }
    }

    public static /* synthetic */ void handleBitmap$default(RepresentativeColors representativeColors, Object obj, Bitmap bitmap, String str, int i, Object obj2) {
        if ((i & 4) != 0) {
            str = null;
        }
        representativeColors.handleBitmap(obj, bitmap, str);
    }

    public final Object getRepresentativeColorAsync(Bitmap bitmap, Continuation<? super RepresentativeColorResult> continuation) {
        return f.C1(Dispatchers.a, new AnonymousClass2(bitmap, null), continuation);
    }

    public final void handleBitmap(T id2, Bitmap bitmap, String url) {
        Intrinsics3.checkNotNullParameter(bitmap, "bitmap");
        CoroutineScope2 coroutineScope2 = CoroutineScope2.j;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        f.H0(coroutineScope2, MainDispatchers.f3830b, null, new AnonymousClass1(id2, bitmap, url, null), 2, null);
    }

    public final Observable<Integer> observeRepresentativeColor(final T id2) {
        Observable<Integer> observableR = this.representativeColorsSubject.G(new Func1<Map<T, ? extends Integer>, Integer>() { // from class: com.discord.utilities.colors.RepresentativeColors.observeRepresentativeColor.1
            @Override // j0.k.Func1
            public final Integer call(Map<T, Integer> map) {
                return map.get(id2);
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "representativeColorsSubj…  .distinctUntilChanged()");
        return observableR;
    }
}
