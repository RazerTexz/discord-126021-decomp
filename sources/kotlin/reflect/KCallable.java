package kotlin.reflect;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import java.util.Map;
import p507d0.p513e0.InterfaceC11229b;
import p507d0.p513e0.InterfaceC11233f;
import p507d0.p513e0.InterfaceC11235h;

/* JADX INFO: compiled from: KCallable.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface KCallable<R> extends InterfaceC11229b {
    R call(Object... args);

    R callBy(Map<InterfaceC11233f, ? extends Object> args);

    String getName();

    List<InterfaceC11233f> getParameters();

    KType getReturnType();

    List<InterfaceC11235h> getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
