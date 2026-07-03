package p007b.p452o.p453a.p467r;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import org.objectweb.asm.Opcodes;
import p007b.p452o.p453a.p454m.EnumC5120g;

/* JADX INFO: renamed from: b.o.a.r.d */
/* JADX INFO: compiled from: GridLinesLayout.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5203d extends View {

    /* JADX INFO: renamed from: j */
    public static final int f14110j = Color.argb(Opcodes.IF_ICMPNE, 255, 255, 255);

    /* JADX INFO: renamed from: k */
    public EnumC5120g f14111k;

    /* JADX INFO: renamed from: l */
    public int f14112l;

    /* JADX INFO: renamed from: m */
    public ColorDrawable f14113m;

    /* JADX INFO: renamed from: n */
    public ColorDrawable f14114n;

    /* JADX INFO: renamed from: o */
    public final float f14115o;

    public C5203d(@NonNull Context context) {
        super(context, null);
        this.f14112l = f14110j;
        this.f14113m = new ColorDrawable(this.f14112l);
        this.f14114n = new ColorDrawable(this.f14112l);
        this.f14115o = TypedValue.applyDimension(1, 0.9f, context.getResources().getDisplayMetrics());
    }

    private int getLineCount() {
        int iOrdinal = this.f14111k.ordinal();
        if (iOrdinal == 1) {
            return 2;
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? 0 : 2;
        }
        return 3;
    }

    public int getGridColor() {
        return this.f14112l;
    }

    @NonNull
    public EnumC5120g getGridMode() {
        return this.f14111k;
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        float f;
        super.onDraw(canvas);
        int lineCount = getLineCount();
        for (int i = 0; i < lineCount; i++) {
            int lineCount2 = getLineCount();
            if (this.f14111k == EnumC5120g.DRAW_PHI) {
                f = 0.38196602f;
                if (i != 1) {
                    f = 0.618034f;
                }
            } else {
                f = (1.0f / (lineCount2 + 1)) * (i + 1.0f);
            }
            canvas.translate(0.0f, getHeight() * f);
            this.f14113m.draw(canvas);
            float f2 = -f;
            canvas.translate(0.0f, getHeight() * f2);
            canvas.translate(f * getWidth(), 0.0f);
            this.f14114n.draw(canvas);
            canvas.translate(f2 * getWidth(), 0.0f);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        this.f14113m.setBounds(i, 0, i3, (int) this.f14115o);
        this.f14114n.setBounds(0, i2, (int) this.f14115o, i4);
    }

    public void setGridColor(@ColorInt int i) {
        this.f14112l = i;
        this.f14113m.setColor(i);
        this.f14114n.setColor(i);
        postInvalidate();
    }

    public void setGridMode(@NonNull EnumC5120g enumC5120g) {
        this.f14111k = enumC5120g;
        postInvalidate();
    }
}
