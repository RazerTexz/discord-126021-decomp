package androidx.core.graphics;

import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: PorterDuff.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PorterDuffKt {
    public static final PorterDuffColorFilter toColorFilter(PorterDuff$Mode porterDuff$Mode, int i) {
        m.checkNotNullParameter(porterDuff$Mode, "<this>");
        return new PorterDuffColorFilter(i, porterDuff$Mode);
    }

    public static final PorterDuffXfermode toXfermode(PorterDuff$Mode porterDuff$Mode) {
        m.checkNotNullParameter(porterDuff$Mode, "<this>");
        return new PorterDuffXfermode(porterDuff$Mode);
    }
}
