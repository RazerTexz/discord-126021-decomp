package b.e.b;

import com.discord.widgets.chat.input.MentionUtilsKt;
import h0.a.a.f;
import h0.a.a.q;
import java.lang.reflect.Modifier;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: ConstructorAccess.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<T> {
    /* JADX WARN: Code duplicated, block: B:41:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c4  */
    public static <T> b<T> a(Class<T> cls) {
        int modifiers;
        String str;
        Class<?> clsA;
        Class<?> enclosingClass = cls.getEnclosingClass();
        boolean z2 = false;
        boolean z3 = (enclosingClass == null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? false : true;
        String name = cls.getName();
        String strW = b.d.b.a.a.w(name, "ConstructorAccess");
        if (strW.startsWith("java.")) {
            strW = b.d.b.a.a.w("reflectasm.", strW);
        }
        a aVarB = a.b(cls);
        try {
            clsA = aVarB.loadClass(strW);
        } catch (ClassNotFoundException unused) {
            synchronized (aVarB) {
                try {
                    clsA = aVarB.loadClass(strW);
                } catch (ClassNotFoundException unused2) {
                    String strReplace = strW.replace('.', MentionUtilsKt.SLASH_CHAR);
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
                            f fVar = new f(0);
                            fVar.c(Opcodes.V1_1, 33, strReplace, null, str, null);
                            q qVarE = fVar.e(1, "<init>", "()V", null, null);
                            qVarE.t(25, 0);
                            qVarE.o(Opcodes.INVOKESPECIAL, str, "<init>", "()V");
                            qVarE.e(Opcodes.RETURN);
                            qVarE.n(1, 1);
                            q qVarE2 = fVar.e(1, "newInstance", "()Ljava/lang/Object;", null, null);
                            qVarE2.s(Opcodes.NEW, strReplace2);
                            qVarE2.e(89);
                            qVarE2.o(Opcodes.INVOKESPECIAL, strReplace2, "<init>", "()V");
                            qVarE2.e(Opcodes.ARETURN);
                            qVarE2.n(2, 1);
                            b(fVar, strReplace2, str2);
                            clsA = aVarB.a(strW, fVar.b());
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
                            f fVar2 = new f(0);
                            fVar2.c(Opcodes.V1_1, 33, strReplace, null, str, null);
                            q qVarE3 = fVar2.e(1, "<init>", "()V", null, null);
                            qVarE3.t(25, 0);
                            qVarE3.o(Opcodes.INVOKESPECIAL, str, "<init>", "()V");
                            qVarE3.e(Opcodes.RETURN);
                            qVarE3.n(1, 1);
                            q qVarE4 = fVar2.e(1, "newInstance", "()Ljava/lang/Object;", null, null);
                            qVarE4.s(Opcodes.NEW, strReplace2);
                            qVarE4.e(89);
                            qVarE4.o(Opcodes.INVOKESPECIAL, strReplace2, "<init>", "()V");
                            qVarE4.e(Opcodes.ARETURN);
                            qVarE4.n(2, 1);
                            b(fVar2, strReplace2, str3);
                            clsA = aVarB.a(strW, fVar2.b());
                        } catch (Exception e2) {
                            throw new RuntimeException("Class cannot be created (missing no-arg constructor): " + cls.getName(), e2);
                        }
                    }
                }
            }
        }
        try {
            b<T> bVar = (b) clsA.newInstance();
            if (!(bVar instanceof e)) {
                if (cls.getPackage() == clsA.getPackage()) {
                    ClassLoader classLoader = cls.getClassLoader();
                    ClassLoader classLoader2 = clsA.getClassLoader();
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
            Objects.requireNonNull(bVar);
            return bVar;
        } catch (Throwable th) {
            throw new RuntimeException(b.d.b.a.a.w("Exception constructing constructor access class: ", strW), th);
        }
    }

    public static void b(f fVar, String str, String str2) {
        q qVarE = fVar.e(1, "newInstance", "(Ljava/lang/Object;)Ljava/lang/Object;", null, null);
        if (str2 == null) {
            qVarE.s(Opcodes.NEW, "java/lang/UnsupportedOperationException");
            qVarE.e(89);
            qVarE.j("Not an inner class.");
            qVarE.o(Opcodes.INVOKESPECIAL, "java/lang/UnsupportedOperationException", "<init>", "(Ljava/lang/String;)V");
            qVarE.e(Opcodes.ATHROW);
            qVarE.n(3, 2);
            return;
        }
        qVarE.s(Opcodes.NEW, str);
        qVarE.e(89);
        qVarE.t(25, 1);
        qVarE.s(Opcodes.CHECKCAST, str2);
        qVarE.e(89);
        qVarE.o(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
        qVarE.e(87);
        qVarE.o(Opcodes.INVOKESPECIAL, str, "<init>", "(L" + str2 + ";)V");
        qVarE.e(Opcodes.ARETURN);
        qVarE.n(4, 2);
    }

    public abstract T c();
}
