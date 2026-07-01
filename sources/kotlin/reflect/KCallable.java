package kotlin.reflect;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.b;
import d0.e0.f;
import d0.e0.h;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: KCallable.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface KCallable<R> extends b {
    R call(Object... args);

    R callBy(Map<f, ? extends Object> args);

    String getName();

    List<f> getParameters();

    KType getReturnType();

    List<h> getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
