package com.discord.utilities.colors;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import androidx.exifinterface.media.ExifInterface;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.l;
import d0.o;
import d0.t.h0;
import d0.w.h.c;
import d0.w.i.a.b;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RepresentativeColors.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.utilities.colors.RepresentativeColors$handleBitmap$1", f = "RepresentativeColors.kt", l = {59}, m = "invokeSuspend")
public final class RepresentativeColors$handleBitmap$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Bitmap $bitmap;
    public final /* synthetic */ Object $id;
    public final /* synthetic */ String $url;
    public int label;
    public final /* synthetic */ RepresentativeColors this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepresentativeColors$handleBitmap$1(RepresentativeColors representativeColors, Object obj, Bitmap bitmap, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = representativeColors;
        this.$id = obj;
        this.$bitmap = bitmap;
        this.$url = str;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new RepresentativeColors$handleBitmap$1(this.this$0, this.$id, this.$bitmap, this.$url, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RepresentativeColors$handleBitmap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        int iAccess$getBLURPLE$cp;
        int iAccess$getBLURPLE$cp2;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            if (RepresentativeColors.access$getRepresentativeColors$p(this.this$0).containsKey(this.$id)) {
                return Unit.a;
            }
            if (this.$bitmap.isRecycled()) {
                iAccess$getBLURPLE$cp = RepresentativeColors.access$getBLURPLE$cp();
            } else {
                Bitmap bitmapCopy = this.$bitmap.copy(Bitmap$Config.ARGB_8888, false);
                RepresentativeColors representativeColors = this.this$0;
                m.checkNotNullExpressionValue(bitmapCopy, "copiedBitmap");
                this.label = 1;
                obj = representativeColors.getRepresentativeColorAsync(bitmapCopy, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            RepresentativeColors.access$getRepresentativeColors$p(this.this$0).put(this.$id, b.boxInt(iAccess$getBLURPLE$cp));
            RepresentativeColors.access$getRepresentativeColorsSubject$p(this.this$0).onNext(RepresentativeColors.access$getRepresentativeColors$p(this.this$0));
            return Unit.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.throwOnFailure(obj);
        RepresentativeColors$RepresentativeColorResult representativeColors$RepresentativeColorResult = (RepresentativeColors$RepresentativeColorResult) obj;
        if (representativeColors$RepresentativeColorResult instanceof RepresentativeColors$RepresentativeColorResult$Success) {
            iAccess$getBLURPLE$cp2 = ((RepresentativeColors$RepresentativeColorResult$Success) representativeColors$RepresentativeColorResult).getColor();
        } else {
            if (!(representativeColors$RepresentativeColorResult instanceof RepresentativeColors$RepresentativeColorResult$Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            iAccess$getBLURPLE$cp2 = RepresentativeColors.access$getBLURPLE$cp();
        }
        if (representativeColors$RepresentativeColorResult instanceof RepresentativeColors$RepresentativeColorResult$Failure) {
            AppLog appLog = AppLog.g;
            Exception exception = ((RepresentativeColors$RepresentativeColorResult$Failure) representativeColors$RepresentativeColorResult).getException();
            Pair[] pairArr = new Pair[4];
            pairArr[0] = o.to(ModelAuditLogEntry.CHANGE_KEY_ID, String.valueOf(this.$id));
            pairArr[1] = o.to("bitmapWidth", String.valueOf(this.$bitmap.getWidth()));
            pairArr[2] = o.to("bitmapHeight", String.valueOf(this.$bitmap.getHeight()));
            String str = this.$url;
            if (str == null) {
                str = "not provided";
            }
            pairArr[3] = o.to("url", str);
            appLog.e("Failed to get representative color for entity", exception, h0.mapOf(pairArr));
        }
        iAccess$getBLURPLE$cp = iAccess$getBLURPLE$cp2;
        RepresentativeColors.access$getRepresentativeColors$p(this.this$0).put(this.$id, b.boxInt(iAccess$getBLURPLE$cp));
        RepresentativeColors.access$getRepresentativeColorsSubject$p(this.this$0).onNext(RepresentativeColors.access$getRepresentativeColors$p(this.this$0));
        return Unit.a;
    }
}
