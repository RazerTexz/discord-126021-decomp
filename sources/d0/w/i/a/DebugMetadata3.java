package d0.w.i.a;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: d0.w.i.a.h, reason: use source file name */
/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DebugMetadata3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f3586b;
    public static final DebugMetadata3 c = new DebugMetadata3();
    public static final a a = new a(null, null, null);

    /* JADX INFO: renamed from: d0.w.i.a.h$a */
    /* JADX INFO: compiled from: DebugMetadata.kt */
    public static final class a {
        public final Method a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f3587b;
        public final Method c;

        public a(Method method, Method method2, Method method3) {
            this.a = method;
            this.f3587b = method2;
            this.c = method3;
        }
    }

    public final String getModuleName(ContinuationImpl continuationImpl) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        Intrinsics3.checkNotNullParameter(continuationImpl, "continuation");
        a aVar = f3586b;
        if (aVar == null) {
            try {
                a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), continuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), continuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(ModelAuditLogEntry.CHANGE_KEY_NAME, new Class[0]));
                f3586b = aVar2;
                aVar = aVar2;
            } catch (Exception unused) {
                aVar = a;
                f3586b = aVar;
            }
        }
        if (aVar == a || (method = aVar.a) == null || (objInvoke = method.invoke(continuationImpl.getClass(), new Object[0])) == null || (method2 = aVar.f3587b) == null || (objInvoke2 = method2.invoke(objInvoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVar.c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        return (String) (objInvoke3 instanceof String ? objInvoke3 : null);
    }
}
