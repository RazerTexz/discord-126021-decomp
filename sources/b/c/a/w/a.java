package b.c.a.w;

import android.graphics.Paint;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: LPaint.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends Paint {
    public a() {
    }

    @Override // android.graphics.Paint
    public void setTextLocales(@NonNull LocaleList localeList) {
    }

    public a(int i) {
        super(i);
    }

    public a(PorterDuff$Mode porterDuff$Mode) {
        setXfermode(new PorterDuffXfermode(porterDuff$Mode));
    }

    public a(int i, PorterDuff$Mode porterDuff$Mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(porterDuff$Mode));
    }
}
