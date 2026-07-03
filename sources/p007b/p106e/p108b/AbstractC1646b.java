package p007b.p106e.p108b;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.lang.reflect.Modifier;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p617h0.p618a.p619a.AbstractC12428q;
import p617h0.p618a.p619a.C12417f;

/* JADX INFO: renamed from: b.e.b.b */
/* JADX INFO: compiled from: ConstructorAccess.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1646b<T> {
    /* JADX WARN: Code duplicated, block: B:41:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c4  */
    /* JADX INFO: renamed from: a */
    public static <T> AbstractC1646b<T> m892a(Class<T> cls) {
        int modifiers;
        String str;
        Class<?> clsM891a;
        Class<?> enclosingClass = cls.getEnclosingClass();
        boolean z2 = false;
        boolean z3 = (enclosingClass == null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? false : true;
        String name = cls.getName();
        String strM883w = C1643a.m883w(name, "ConstructorAccess");
        if (strM883w.startsWith("java.")) {
            strM883w = C1643a.m883w("reflectasm.", strM883w);
        }
        C1645a c1645aM889b = C1645a.m889b(cls);
        try {
            clsM891a = c1645aM889b.loadClass(strM883w);
        } catch (ClassNotFoundException unused) {
            synchronized (c1645aM889b) {
                try {
                    clsM891a = c1645aM889b.loadClass(strM883w);
                } catch (ClassNotFoundException unused2) {
                    String strReplace = strM883w.replace('.', MentionUtilsKt.SLASH_CHAR);
                    String strReplace2 = name.replace('.', MentionUtilsKt.SLASH_CHAR);
                    String strReplace3 = null;
                    if (z3) {
                        strReplace3 = enclosingClass.getName().replace('.', MentionUtilsKt.SLASH_CHAR);
                        try {
                            modifiers = cls.getDeclaredConstructor(enclosingClass).getModifiers();
                            if (Modifier.isPrivate(modifiers)) {
                                throw new RuntimeException("Non-static member class cannot be created (the enclosing class constructor is private): " + cls.getName());
                            }
                            String str2 = strReplace3;
                            if (Modifier.isPublic(modifiers)) {
                                str = "com/esotericsoftware/reflectasm/PublicConstructorAccess";
                            } else {
                                str = "com/esotericsoftware/reflectasm/ConstructorAccess";
                            }
                            C12417f c12417f = new C12417f(0);
                            c12417f.m10565c(Opcodes.V1_1, 33, strReplace, null, str, null);
                            AbstractC12428q abstractC12428qM10567e = c12417f.m10567e(1, "<init>", "()V", null, null);
                            abstractC12428qM10567e.mo10612t(25, 0);
                            abstractC12428qM10567e.m10607o(Opcodes.INVOKESPECIAL, str, "<init>", "()V");
                            abstractC12428qM10567e.mo10597e(Opcodes.RETURN);
                            abstractC12428qM10567e.mo10606n(1, 1);
                            AbstractC12428q abstractC12428qM10567e2 = c12417f.m10567e(1, "newInstance", "()Ljava/lang/Object;", null, null);
                            abstractC12428qM10567e2.mo10611s(Opcodes.NEW, strReplace2);
                            abstractC12428qM10567e2.mo10597e(89);
                            abstractC12428qM10567e2.m10607o(Opcodes.INVOKESPECIAL, strReplace2, "<init>", "()V");
                            abstractC12428qM10567e2.mo10597e(Opcodes.ARETURN);
                            abstractC12428qM10567e2.mo10606n(2, 1);
                            m893b(c12417f, strReplace2, str2);
                            clsM891a = c1645aM889b.m891a(strM883w, c12417f.m10564b());
                        } catch (Exception e) {
                            throw new RuntimeException("Non-static member class cannot be created (missing enclosing class constructor): " + cls.getName(), e);
                        }
                    } else {
                        try {
                            modifiers = cls.getDeclaredConstructor(null).getModifiers();
                            if (Modifier.isPrivate(modifiers)) {
                                throw new RuntimeException("Class cannot be created (the no-arg constructor is private): " + cls.getName());
                            }
                            String str3 = strReplace3;
                            if (Modifier.isPublic(modifiers)) {
                                str = "com/esotericsoftware/reflectasm/PublicConstructorAccess";
                            } else {
                                str = "com/esotericsoftware/reflectasm/ConstructorAccess";
                            }
                            C12417f c12417f2 = new C12417f(0);
                            c12417f2.m10565c(Opcodes.V1_1, 33, strReplace, null, str, null);
                            AbstractC12428q abstractC12428qM10567e3 = c12417f2.m10567e(1, "<init>", "()V", null, null);
                            abstractC12428qM10567e3.mo10612t(25, 0);
                            abstractC12428qM10567e3.m10607o(Opcodes.INVOKESPECIAL, str, "<init>", "()V");
                            abstractC12428qM10567e3.mo10597e(Opcodes.RETURN);
                            abstractC12428qM10567e3.mo10606n(1, 1);
                            AbstractC12428q abstractC12428qM10567e4 = c12417f2.m10567e(1, "newInstance", "()Ljava/lang/Object;", null, null);
                            abstractC12428qM10567e4.mo10611s(Opcodes.NEW, strReplace2);
                            abstractC12428qM10567e4.mo10597e(89);
                            abstractC12428qM10567e4.m10607o(Opcodes.INVOKESPECIAL, strReplace2, "<init>", "()V");
                            abstractC12428qM10567e4.mo10597e(Opcodes.ARETURN);
                            abstractC12428qM10567e4.mo10606n(2, 1);
                            m893b(c12417f2, strReplace2, str3);
                            clsM891a = c1645aM889b.m891a(strM883w, c12417f2.m10564b());
                        } catch (Exception e2) {
                            throw new RuntimeException("Class cannot be created (missing no-arg constructor): " + cls.getName(), e2);
                        }
                    }
                }
            }
        }
        try {
            AbstractC1646b<T> abstractC1646b = (AbstractC1646b) clsM891a.newInstance();
            if (!(abstractC1646b instanceof AbstractC1649e)) {
                if (cls.getPackage() == clsM891a.getPackage()) {
                    ClassLoader classLoader = cls.getClassLoader();
                    ClassLoader classLoader2 = clsM891a.getClassLoader();
                    ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                    if (classLoader != null ? !(classLoader2 != null ? classLoader != classLoader2 : classLoader != systemClassLoader) : !(classLoader2 != null && classLoader2 != systemClassLoader)) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(!z3 ? "Class cannot be created (the no-arg constructor is protected or package-protected, and its ConstructorAccess could not be defined in the same class loader): " : "Non-static member class cannot be created (the enclosing class constructor is protected or package-protected, and its ConstructorAccess could not be defined in the same class loader): ");
                    sb.append(cls.getName());
                    throw new RuntimeException(sb.toString());
                }
            }
            Objects.requireNonNull(abstractC1646b);
            return abstractC1646b;
        } catch (Throwable th) {
            throw new RuntimeException(C1643a.m883w("Exception constructing constructor access class: ", strM883w), th);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m893b(C12417f c12417f, String str, String str2) {
        AbstractC12428q abstractC12428qM10567e = c12417f.m10567e(1, "newInstance", "(Ljava/lang/Object;)Ljava/lang/Object;", null, null);
        if (str2 == null) {
            abstractC12428qM10567e.mo10611s(Opcodes.NEW, "java/lang/UnsupportedOperationException");
            abstractC12428qM10567e.mo10597e(89);
            abstractC12428qM10567e.mo10602j("Not an inner class.");
            abstractC12428qM10567e.m10607o(Opcodes.INVOKESPECIAL, "java/lang/UnsupportedOperationException", "<init>", "(Ljava/lang/String;)V");
            abstractC12428qM10567e.mo10597e(Opcodes.ATHROW);
            abstractC12428qM10567e.mo10606n(3, 2);
            return;
        }
        abstractC12428qM10567e.mo10611s(Opcodes.NEW, str);
        abstractC12428qM10567e.mo10597e(89);
        abstractC12428qM10567e.mo10612t(25, 1);
        abstractC12428qM10567e.mo10611s(Opcodes.CHECKCAST, str2);
        abstractC12428qM10567e.mo10597e(89);
        abstractC12428qM10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
        abstractC12428qM10567e.mo10597e(87);
        abstractC12428qM10567e.m10607o(Opcodes.INVOKESPECIAL, str, "<init>", "(L" + str2 + ";)V");
        abstractC12428qM10567e.mo10597e(Opcodes.ARETURN);
        abstractC12428qM10567e.mo10606n(4, 2);
    }

    /* JADX INFO: renamed from: c */
    public abstract T m894c();
}
