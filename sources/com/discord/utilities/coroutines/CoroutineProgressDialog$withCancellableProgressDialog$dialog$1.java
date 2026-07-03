package com.discord.utilities.coroutines;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AlertDialog;
import com.discord.C5419R;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p007b.p008a.p025i.C0984j2;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: CoroutineProgressDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@InterfaceC12188e(m10084c = "com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$dialog$1", m10085f = "CoroutineProgressDialog.kt", m10086l = {}, m10087m = "invokeSuspend")
public final class CoroutineProgressDialog$withCancellableProgressDialog$dialog$1 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super AlertDialog>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CoroutineContext $myCoroutineContext;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineProgressDialog$withCancellableProgressDialog$dialog$1(Context context, CoroutineContext coroutineContext, Continuation continuation) {
        super(2, continuation);
        this.$context = context;
        this.$myCoroutineContext = coroutineContext;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C12238m.checkNotNullParameter(continuation, "completion");
        return new CoroutineProgressDialog$withCancellableProgressDialog$dialog$1(this.$context, this.$myCoroutineContext, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AlertDialog> continuation) {
        return ((CoroutineProgressDialog$withCancellableProgressDialog$dialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Object invokeSuspend(Object obj) {
        C12183c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C12113l.throwOnFailure(obj);
        View viewInflate = LayoutInflater.from(this.$context).inflate(C5419R.layout.view_generic_loading, (ViewGroup) null, false);
        Objects.requireNonNull(viewInflate, "rootView");
        FrameLayout frameLayout = (FrameLayout) viewInflate;
        C12238m.checkNotNullExpressionValue(new C0984j2(frameLayout), "ViewGenericLoadingBindin…utInflater.from(context))");
        return new AlertDialog.Builder(this.$context, 2131951632).setView(frameLayout).setCancelable(true).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$dialog$1.1
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                C3404f.m4339s(CoroutineProgressDialog$withCancellableProgressDialog$dialog$1.this.$myCoroutineContext, null, 1, null);
            }
        }).show();
    }
}
