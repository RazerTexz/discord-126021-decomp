package com.discord.utilities.coroutines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog$Builder;
import b.a.i.j2;
import com.discord.R$layout;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CoroutineProgressDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$dialog$1", f = "CoroutineProgressDialog.kt", l = {}, m = "invokeSuspend")
public final class CoroutineProgressDialog$withCancellableProgressDialog$dialog$1 extends k implements Function2<CoroutineScope, Continuation<? super AlertDialog>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CoroutineContext $myCoroutineContext;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineProgressDialog$withCancellableProgressDialog$dialog$1(Context context, CoroutineContext coroutineContext, Continuation continuation) {
        super(2, continuation);
        this.$context = context;
        this.$myCoroutineContext = coroutineContext;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new CoroutineProgressDialog$withCancellableProgressDialog$dialog$1(this.$context, this.$myCoroutineContext, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AlertDialog> continuation) {
        return ((CoroutineProgressDialog$withCancellableProgressDialog$dialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.throwOnFailure(obj);
        View viewInflate = LayoutInflater.from(this.$context).inflate(R$layout.view_generic_loading, (ViewGroup) null, false);
        Objects.requireNonNull(viewInflate, "rootView");
        FrameLayout frameLayout = (FrameLayout) viewInflate;
        m.checkNotNullExpressionValue(new j2(frameLayout), "ViewGenericLoadingBindin…utInflater.from(context))");
        return new AlertDialog$Builder(this.$context, 2131951632).setView(frameLayout).setCancelable(true).setOnCancelListener(new CoroutineProgressDialog$withCancellableProgressDialog$dialog$1$1(this)).show();
    }
}
