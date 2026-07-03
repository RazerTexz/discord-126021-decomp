package com.discord.utilities.colors;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import p007b.p008a.p023g.C0903a;
import p007b.p008a.p023g.C0904b;
import p007b.p008a.p023g.C0906d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.C12185b;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;
import p659s.p660a.C13124k0;
import p659s.p660a.C13163x0;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: compiled from: RepresentativeColors.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RepresentativeColors<T> {
    private final HashMap<T, Integer> representativeColors = new HashMap<>();
    private final BehaviorSubject<Map<T, Integer>> representativeColorsSubject = BehaviorSubject.m11129k0();
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
                C12238m.checkNotNullParameter(exc, "exception");
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
                C12238m.checkNotNullParameter(exception, "exception");
                return new Failure(exception);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Failure) && C12238m.areEqual(this.exception, ((Failure) other).exception);
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
                StringBuilder sbM833U = C1643a.m833U("Failure(exception=");
                sbM833U.append(this.exception);
                sbM833U.append(")");
                return sbM833U.toString();
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
                return C1643a.m814B(C1643a.m833U("Success(color="), this.color, ")");
            }
        }

        private RepresentativeColorResult() {
        }

        public /* synthetic */ RepresentativeColorResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.colors.RepresentativeColors$getRepresentativeColorAsync$2 */
    /* JADX INFO: compiled from: RepresentativeColors.kt */
    @InterfaceC12188e(m10084c = "com.discord.utilities.colors.RepresentativeColors$getRepresentativeColorAsync$2", m10085f = "RepresentativeColors.kt", m10086l = {}, m10087m = "invokeSuspend")
    public static final class C67342 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super RepresentativeColorResult>, Object> {
        public final /* synthetic */ Bitmap $bitmap;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67342(Bitmap bitmap, Continuation continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return new C67342(this.$bitmap, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RepresentativeColorResult> continuation) {
            return ((C67342) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            C12183c.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(obj);
            return RepresentativeColors.this.getRepresentativeColor(this.$bitmap);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.colors.RepresentativeColors$handleBitmap$1 */
    /* JADX INFO: compiled from: RepresentativeColors.kt */
    @InterfaceC12188e(m10084c = "com.discord.utilities.colors.RepresentativeColors$handleBitmap$1", m10085f = "RepresentativeColors.kt", m10086l = {59}, m10087m = "invokeSuspend")
    public static final class C67351 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Bitmap $bitmap;
        public final /* synthetic */ Object $id;
        public final /* synthetic */ String $url;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67351(Object obj, Bitmap bitmap, String str, Continuation continuation) {
            super(2, continuation);
            this.$id = obj;
            this.$bitmap = bitmap;
            this.$url = str;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return new C67351(this.$id, this.$bitmap, this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67351) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            int i;
            int color;
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                C12113l.throwOnFailure(obj);
                if (RepresentativeColors.this.representativeColors.containsKey(this.$id)) {
                    return Unit.f27425a;
                }
                if (this.$bitmap.isRecycled()) {
                    i = RepresentativeColors.BLURPLE;
                } else {
                    Bitmap bitmapCopy = this.$bitmap.copy(Bitmap.Config.ARGB_8888, false);
                    RepresentativeColors representativeColors = RepresentativeColors.this;
                    C12238m.checkNotNullExpressionValue(bitmapCopy, "copiedBitmap");
                    this.label = 1;
                    obj = representativeColors.getRepresentativeColorAsync(bitmapCopy, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                RepresentativeColors.this.representativeColors.put(this.$id, C12185b.boxInt(i));
                RepresentativeColors.this.representativeColorsSubject.onNext(RepresentativeColors.this.representativeColors);
                return Unit.f27425a;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(obj);
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
                AppLog appLog = AppLog.f14950g;
                Exception exception = ((RepresentativeColorResult.Failure) representativeColorResult).getException();
                Pair[] pairArr = new Pair[4];
                pairArr[0] = C12116o.m10073to(ModelAuditLogEntry.CHANGE_KEY_ID, String.valueOf(this.$id));
                pairArr[1] = C12116o.m10073to("bitmapWidth", String.valueOf(this.$bitmap.getWidth()));
                pairArr[2] = C12116o.m10073to("bitmapHeight", String.valueOf(this.$bitmap.getHeight()));
                String str = this.$url;
                if (str == null) {
                    str = "not provided";
                }
                pairArr[3] = C12116o.m10073to("url", str);
                appLog.mo8364e("Failed to get representative color for entity", exception, C12136h0.mapOf(pairArr));
            }
            i = color;
            RepresentativeColors.this.representativeColors.put(this.$id, C12185b.boxInt(i));
            RepresentativeColors.this.representativeColorsSubject.onNext(RepresentativeColors.this.representativeColors);
            return Unit.f27425a;
        }
    }

    private final int getColorDistance(int c1, int c2) {
        int i = ((c1 >> 16) & 255) - ((c2 >> 16) & 255);
        int i2 = ((c1 >> 8) & 255) - ((c2 >> 8) & 255);
        int i3 = (c1 & 255) - (c2 & 255);
        return Math.abs((i3 * i3) + (i2 * i2) + (i * i));
    }

    private final List<Integer> getPrimaryColorsForBitmap(Bitmap bitmap) {
        C0903a.b bVar = C0903a.f626a;
        C12238m.checkNotNullParameter(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        List<C0906d> list = new C0903a(new C0904b(iArr), 2, null).f630e;
        if (!list.isEmpty()) {
            return C12145m.listOf(Integer.valueOf(list.get(0).f648d));
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
        return C3404f.m4197C1(C13124k0.f27866a, new C67342(bitmap, null), continuation);
    }

    public final void handleBitmap(T id2, Bitmap bitmap, String url) {
        C12238m.checkNotNullParameter(bitmap, "bitmap");
        C13163x0 c13163x0 = C13163x0.f27919j;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        C3404f.m4211H0(c13163x0, C13031n.f27700b, null, new C67351(id2, bitmap, url, null), 2, null);
    }

    public final Observable<Integer> observeRepresentativeColor(final T id2) {
        Observable<Integer> observableM11112r = this.representativeColorsSubject.m11083G(new InterfaceC12589b<Map<T, ? extends Integer>, Integer>() { // from class: com.discord.utilities.colors.RepresentativeColors.observeRepresentativeColor.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Integer call(Map<T, Integer> map) {
                return map.get(id2);
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "representativeColorsSubj…  .distinctUntilChanged()");
        return observableM11112r;
    }
}
