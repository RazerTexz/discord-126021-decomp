package com.discord.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface$OnShowListener;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import j0.l.e.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppBottomSheet$c implements DialogInterface$OnShowListener {
    public final /* synthetic */ Dialog a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppBottomSheet f2079b;

    public AppBottomSheet$c(Dialog dialog, AppBottomSheet appBottomSheet) {
        this.a = dialog;
        this.f2079b = appBottomSheet;
    }

    @Override // android.content.DialogInterface$OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        k kVar = new k(Unit.a);
        m.checkNotNullExpressionValue(kVar, "Observable.just(Unit)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(kVar, this.f2079b, null, 2, null), this.f2079b.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AppBottomSheet$c$a(this), 62, (Object) null);
    }
}
