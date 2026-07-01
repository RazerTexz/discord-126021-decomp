package com.discord.utilities.rx;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.error.Error;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.functions.Action1;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableExtensionsKt$appSubscribe$subscription$1<T> implements Action1<Throwable> {
    public final /* synthetic */ Function1 $errorHandler;
    public final /* synthetic */ String $errorTag;
    public final /* synthetic */ Function0 $onTerminated;
    public final /* synthetic */ WeakReference $weakContext;

    public ObservableExtensionsKt$appSubscribe$subscription$1(String str, Function1 function1, WeakReference weakReference, Function0 function0) {
        this.$errorTag = str;
        this.$errorHandler = function1;
        this.$weakContext = weakReference;
        this.$onTerminated = function0;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Throwable th) throws Throwable {
        call2(th);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Throwable th) throws Throwable {
        String str = this.$errorTag;
        Function1 function1 = this.$errorHandler;
        Object observableExtensionsKt$sam$rx_functions_Action1$0 = function1;
        if (function1 != null) {
            observableExtensionsKt$sam$rx_functions_Action1$0 = new ObservableExtensionsKt$sam$rx_functions_Action1$0(function1);
        }
        Error.handle(th, str, (Action1) observableExtensionsKt$sam$rx_functions_Action1$0, (Context) this.$weakContext.get());
        this.$onTerminated.invoke();
    }
}
