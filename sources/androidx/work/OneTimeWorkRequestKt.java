package androidx.work;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import d0.e0.c;
import d0.z.a;
import d0.z.d.m;

/* JADX INFO: compiled from: OneTimeWorkRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OneTimeWorkRequestKt {
    public static final /* synthetic */ <W extends ListenableWorker> OneTimeWorkRequest$Builder OneTimeWorkRequestBuilder() {
        m.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new OneTimeWorkRequest$Builder(ListenableWorker.class);
    }

    public static final OneTimeWorkRequest$Builder setInputMerger(OneTimeWorkRequest$Builder oneTimeWorkRequest$Builder, @NonNull c<? extends InputMerger> cVar) {
        m.checkParameterIsNotNull(oneTimeWorkRequest$Builder, "$this$setInputMerger");
        m.checkParameterIsNotNull(cVar, "inputMerger");
        OneTimeWorkRequest$Builder inputMerger = oneTimeWorkRequest$Builder.setInputMerger(a.getJavaClass(cVar));
        m.checkExpressionValueIsNotNull(inputMerger, "setInputMerger(inputMerger.java)");
        return inputMerger;
    }
}
