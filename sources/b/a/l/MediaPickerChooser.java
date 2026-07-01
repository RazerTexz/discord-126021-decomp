package b.a.l;

import android.content.Intent;
import android.net.Uri;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.l.a, reason: use source file name */
/* JADX INFO: compiled from: MediaPickerChooser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaPickerChooser extends Lambda implements Function1<Intent, Unit> {
    public final /* synthetic */ Uri $captureFileURI;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaPickerChooser(Uri uri) {
        super(1);
        this.$captureFileURI = uri;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Intent intent) {
        Intent intent2 = intent;
        Intrinsics3.checkNotNullParameter(intent2, "intent");
        intent2.putExtra("output", this.$captureFileURI);
        return Unit.a;
    }
}
