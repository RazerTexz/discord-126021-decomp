package d0.w.i.a;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static h$a f3586b;
    public static final h c = new h();
    public static final h$a a = new h$a(null, null, null);

    public final String getModuleName(a aVar) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        m.checkNotNullParameter(aVar, "continuation");
        h$a h_a = f3586b;
        if (h_a == null) {
            try {
                h$a h_a2 = new h$a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(ModelAuditLogEntry.CHANGE_KEY_NAME, new Class[0]));
                f3586b = h_a2;
                h_a = h_a2;
            } catch (Exception unused) {
                h_a = a;
                f3586b = h_a;
            }
        }
        if (h_a == a || (method = h_a.a) == null || (objInvoke = method.invoke(aVar.getClass(), new Object[0])) == null || (method2 = h_a.f3587b) == null || (objInvoke2 = method2.invoke(objInvoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = h_a.c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        return (String) (objInvoke3 instanceof String ? objInvoke3 : null);
    }
}
