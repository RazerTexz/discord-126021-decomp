package com.discord.workers;

import android.app.Application;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.discord.stores.StoreStream;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p650m.C12756a;

/* JADX INFO: compiled from: BackgroundMessageSendWorker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BackgroundMessageSendWorker extends Worker {

    /* JADX INFO: renamed from: com.discord.workers.BackgroundMessageSendWorker$a */
    /* JADX INFO: compiled from: BackgroundMessageSendWorker.kt */
    public static final class C10617a<T, R> implements InterfaceC12589b<Boolean, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final C10617a f19414j = new C10617a();

        @Override // p637j0.p641k.InterfaceC12589b
        public Boolean call(Boolean bool) {
            return Boolean.valueOf(C12238m.areEqual(bool, Boolean.TRUE));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundMessageSendWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(workerParameters, "params");
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        Context applicationContext = getApplicationContext();
        if (!(applicationContext instanceof Application)) {
            applicationContext = null;
        }
        Application application = (Application) applicationContext;
        if (application == null) {
            ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
            C12238m.checkNotNullExpressionValue(resultFailure, "Result.failure()");
            return resultFailure;
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.initialize(application);
        new C12756a(companion.getMessages().observeInitResendFinished().m11118y(C10617a.f19414j).m11100Z(1)).m10860b();
        ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
        C12238m.checkNotNullExpressionValue(resultSuccess, "Result.success()");
        return resultSuccess;
    }
}
