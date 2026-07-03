package androidx.work;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.OneTimeWorkRequest;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p592z.C12209a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: OneTimeWorkRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OneTimeWorkRequestKt {
    public static final /* synthetic */ <W extends ListenableWorker> OneTimeWorkRequest.Builder OneTimeWorkRequestBuilder() {
        C12238m.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new OneTimeWorkRequest.Builder(ListenableWorker.class);
    }

    public static final OneTimeWorkRequest.Builder setInputMerger(OneTimeWorkRequest.Builder builder, @NonNull InterfaceC11230c<? extends InputMerger> interfaceC11230c) {
        C12238m.checkParameterIsNotNull(builder, "$this$setInputMerger");
        C12238m.checkParameterIsNotNull(interfaceC11230c, "inputMerger");
        OneTimeWorkRequest.Builder inputMerger = builder.setInputMerger(C12209a.getJavaClass(interfaceC11230c));
        C12238m.checkExpressionValueIsNotNull(inputMerger, "setInputMerger(inputMerger.java)");
        return inputMerger;
    }
}
