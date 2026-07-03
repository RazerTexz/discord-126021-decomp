package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PorterDuff.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PorterDuffKt {
    public static final PorterDuffColorFilter toColorFilter(PorterDuff.Mode mode, int i) {
        C12238m.checkNotNullParameter(mode, "<this>");
        return new PorterDuffColorFilter(i, mode);
    }

    public static final PorterDuffXfermode toXfermode(PorterDuff.Mode mode) {
        C12238m.checkNotNullParameter(mode, "<this>");
        return new PorterDuffXfermode(mode);
    }
}
