package p007b.p008a.p062y.p063j0;

import android.graphics.Bitmap;
import com.discord.utilities.colors.RepresentativeColorsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.j0.g */
/* JADX INFO: compiled from: StageCallSpeakerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1344g extends AbstractC12240o implements Function2<Bitmap, String, Unit> {
    public final /* synthetic */ String $colorId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1344g(String str) {
        super(2);
        this.$colorId = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(Bitmap bitmap, String str) {
        Bitmap bitmap2 = bitmap;
        C12238m.checkNotNullParameter(bitmap2, "bitmap");
        RepresentativeColorsKt.getUserRepresentativeColors().handleBitmap(this.$colorId, bitmap2, str);
        return Unit.f27425a;
    }
}
