package com.discord.utilities.colors;

import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RepresentativeColors.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.utilities.colors.RepresentativeColors$getRepresentativeColorAsync$2", f = "RepresentativeColors.kt", l = {}, m = "invokeSuspend")
public final class RepresentativeColors$getRepresentativeColorAsync$2 extends k implements Function2<CoroutineScope, Continuation<? super RepresentativeColors$RepresentativeColorResult>, Object> {
    public final /* synthetic */ Bitmap $bitmap;
    public int label;
    public final /* synthetic */ RepresentativeColors this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepresentativeColors$getRepresentativeColorAsync$2(RepresentativeColors representativeColors, Bitmap bitmap, Continuation continuation) {
        super(2, continuation);
        this.this$0 = representativeColors;
        this.$bitmap = bitmap;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new RepresentativeColors$getRepresentativeColorAsync$2(this.this$0, this.$bitmap, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RepresentativeColors$RepresentativeColorResult> continuation) {
        return ((RepresentativeColors$getRepresentativeColorAsync$2) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.throwOnFailure(obj);
        return RepresentativeColors.access$getRepresentativeColor(this.this$0, this.$bitmap);
    }
}
