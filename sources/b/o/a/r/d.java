package b.o.a.r;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: GridLinesLayout.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends View {
    public static final int j = Color.argb(Opcodes.IF_ICMPNE, 255, 255, 255);
    public b.o.a.m.g k;
    public int l;
    public ColorDrawable m;
    public ColorDrawable n;
    public final float o;

    public d(@NonNull Context context) {
        super(context, null);
        this.l = j;
        this.m = new ColorDrawable(this.l);
        this.n = new ColorDrawable(this.l);
        this.o = TypedValue.applyDimension(1, 0.9f, context.getResources().getDisplayMetrics());
    }

    private int getLineCount() {
        int iOrdinal = this.k.ordinal();
        if (iOrdinal == 1) {
            return 2;
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? 0 : 2;
        }
        return 3;
    }

    public int getGridColor() {
        return this.l;
    }

    @NonNull
    public b.o.a.m.g getGridMode() {
        return this.k;
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        float f;
        super.onDraw(canvas);
        int lineCount = getLineCount();
        for (int i = 0; i < lineCount; i++) {
            int lineCount2 = getLineCount();
            if (this.k == b.o.a.m.g.DRAW_PHI) {
                f = 0.38196602f;
                if (i != 1) {
                    f = 0.618034f;
                }
            } else {
                f = (1.0f / (lineCount2 + 1)) * (i + 1.0f);
            }
            canvas.translate(0.0f, getHeight() * f);
            this.m.draw(canvas);
            float f2 = -f;
            canvas.translate(0.0f, getHeight() * f2);
            canvas.translate(f * getWidth(), 0.0f);
            this.n.draw(canvas);
            canvas.translate(f2 * getWidth(), 0.0f);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        this.m.setBounds(i, 0, i3, (int) this.o);
        this.n.setBounds(0, i2, (int) this.o, i4);
    }

    public void setGridColor(@ColorInt int i) {
        this.l = i;
        this.m.setColor(i);
        this.n.setColor(i);
        postInvalidate();
    }

    public void setGridMode(@NonNull b.o.a.m.g gVar) {
        this.k = gVar;
        postInvalidate();
    }
}
