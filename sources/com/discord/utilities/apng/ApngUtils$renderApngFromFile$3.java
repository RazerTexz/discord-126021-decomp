package com.discord.utilities.apng;

import b.i.a.f.e.o.f;
import b.l.a.a;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.y.b;
import d0.z.d.m;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import s.a.a.n;
import s.a.k0;
import s.a.l1;

/* JADX INFO: compiled from: ApngUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.utilities.apng.ApngUtils$renderApngFromFile$3", f = "ApngUtils.kt", l = {31}, m = "invokeSuspend")
public final class ApngUtils$renderApngFromFile$3 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ boolean $autoPlay;
    public final /* synthetic */ File $file;
    public final /* synthetic */ Ref$ObjectRef $imageViewRef;
    public final /* synthetic */ Integer $maxHeight;
    public final /* synthetic */ Integer $maxWidth;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApngUtils$renderApngFromFile$3(File file, Integer num, Integer num2, Ref$ObjectRef ref$ObjectRef, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.$file = file;
        this.$maxHeight = num;
        this.$maxWidth = num2;
        this.$imageViewRef = ref$ObjectRef;
        this.$autoPlay = z2;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new ApngUtils$renderApngFromFile$3(this.$file, this.$maxHeight, this.$maxWidth, this.$imageViewRef, this.$autoPlay, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ApngUtils$renderApngFromFile$3) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, b.l.a.a] */
    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                l.throwOnFailure(obj);
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                File file = this.$file;
                Integer num = this.$maxHeight;
                Integer num2 = this.$maxWidth;
                m.checkNotNullParameter(file, "file");
                InputStream fileInputStream = new FileInputStream(file);
                BufferedInputStream bufferedInputStream = fileInputStream instanceof BufferedInputStream ? (BufferedInputStream) fileInputStream : new BufferedInputStream(fileInputStream, 8192);
                try {
                    ?? A = a.a(bufferedInputStream, num2, num);
                    b.closeFinally(bufferedInputStream, null);
                    ref$ObjectRef.element = A;
                    CoroutineDispatcher coroutineDispatcher = k0.a;
                    l1 l1Var = n.f3830b;
                    ApngUtils$renderApngFromFile$3$1 apngUtils$renderApngFromFile$3$1 = new ApngUtils$renderApngFromFile$3$1(this, ref$ObjectRef, null);
                    this.label = 1;
                    if (f.C1(l1Var, apngUtils$renderApngFromFile$3$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        b.closeFinally(bufferedInputStream, th);
                        throw th2;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Unit.a;
    }
}
