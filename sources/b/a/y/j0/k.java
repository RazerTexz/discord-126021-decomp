package b.a.y.j0;

import android.graphics.Bitmap;
import com.discord.utilities.colors.RepresentativeColorsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VideoCallParticipantView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k extends d0.z.d.o implements Function2<Bitmap, String, Unit> {
    public final /* synthetic */ String $colorId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(String str) {
        super(2);
        this.$colorId = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(Bitmap bitmap, String str) {
        Bitmap bitmap2 = bitmap;
        d0.z.d.m.checkNotNullParameter(bitmap2, "bitmap");
        RepresentativeColorsKt.getUserRepresentativeColors().handleBitmap(this.$colorId, bitmap2, str);
        return Unit.a;
    }
}
