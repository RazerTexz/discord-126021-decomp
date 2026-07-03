package p007b.p008a.p032l;

import android.content.Intent;
import android.net.Uri;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.l.a */
/* JADX INFO: compiled from: MediaPickerChooser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1128a extends AbstractC12240o implements Function1<Intent, Unit> {
    public final /* synthetic */ Uri $captureFileURI;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1128a(Uri uri) {
        super(1);
        this.$captureFileURI = uri;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Intent intent) {
        Intent intent2 = intent;
        C12238m.checkNotNullParameter(intent2, "intent");
        intent2.putExtra("output", this.$captureFileURI);
        return Unit.f27425a;
    }
}
