package b.b.a.d;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import b.f.g.e.s;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ThumbnailViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$d extends o implements Function1<Bitmap, Unit> {
    public final /* synthetic */ i this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i$d(i iVar) {
        super(1);
        this.this$0 = iVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Bitmap bitmap) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.this$0.a().getResources(), bitmap);
        GenericDraweeHierarchy hierarchy = this.this$0.a().getHierarchy();
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
        ScalingUtils$ScaleType scalingUtils$ScaleType2 = s.l;
        hierarchy.o(1, bitmapDrawable);
        hierarchy.l(1).r(scalingUtils$ScaleType2);
        return Unit.a;
    }
}
