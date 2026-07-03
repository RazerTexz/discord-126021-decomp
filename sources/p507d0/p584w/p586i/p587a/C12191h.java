package p507d0.p584w.p586i.p587a;

import com.discord.models.domain.ModelAuditLogEntry;
import java.lang.reflect.Method;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.w.i.a.h */
/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12191h {

    /* JADX INFO: renamed from: b */
    public static a f25246b;

    /* JADX INFO: renamed from: c */
    public static final C12191h f25247c = new C12191h();

    /* JADX INFO: renamed from: a */
    public static final a f25245a = new a(null, null, null);

    /* JADX INFO: renamed from: d0.w.i.a.h$a */
    /* JADX INFO: compiled from: DebugMetadata.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final Method f25248a;

        /* JADX INFO: renamed from: b */
        public final Method f25249b;

        /* JADX INFO: renamed from: c */
        public final Method f25250c;

        public a(Method method, Method method2, Method method3) {
            this.f25248a = method;
            this.f25249b = method2;
            this.f25250c = method3;
        }
    }

    public final String getModuleName(AbstractC12184a abstractC12184a) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        C12238m.checkNotNullParameter(abstractC12184a, "continuation");
        a aVar = f25246b;
        if (aVar == null) {
            try {
                a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), abstractC12184a.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), abstractC12184a.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(ModelAuditLogEntry.CHANGE_KEY_NAME, new Class[0]));
                f25246b = aVar2;
                aVar = aVar2;
            } catch (Exception unused) {
                aVar = f25245a;
                f25246b = aVar;
            }
        }
        if (aVar == f25245a || (method = aVar.f25248a) == null || (objInvoke = method.invoke(abstractC12184a.getClass(), new Object[0])) == null || (method2 = aVar.f25249b) == null || (objInvoke2 = method2.invoke(objInvoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVar.f25250c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        return (String) (objInvoke3 instanceof String ? objInvoke3 : null);
    }
}
