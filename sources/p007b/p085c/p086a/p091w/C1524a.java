package p007b.p085c.p086a.p091w;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.c.a.w.a */
/* JADX INFO: compiled from: LPaint.java */
/* JADX INFO: loaded from: classes.dex */
public class C1524a extends Paint {
    public C1524a() {
    }

    @Override // android.graphics.Paint
    public void setTextLocales(@NonNull LocaleList localeList) {
    }

    public C1524a(int i) {
        super(i);
    }

    public C1524a(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public C1524a(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
