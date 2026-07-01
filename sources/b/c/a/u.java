package b.c.a;

import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import androidx.annotation.ColorInt;

/* JADX INFO: compiled from: SimpleColorFilter.java */
/* JADX INFO: loaded from: classes.dex */
public class u extends PorterDuffColorFilter {
    public u(@ColorInt int i) {
        super(i, PorterDuff$Mode.SRC_ATOP);
    }
}
