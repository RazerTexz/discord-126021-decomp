package b.e.b;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import h0.a.a.ClassWriter2;
import h0.a.a.MethodVisitor2;
import java.lang.reflect.Modifier;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.e.b.b, reason: use source file name */
/* JADX INFO: compiled from: ConstructorAccess.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ConstructorAccess<T> {
    /* JADX WARN: Code duplicated, block: B:41:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c4  */
    public static <T> ConstructorAccess<T> a(Class<T> cls) {
        int modifiers;
        String str;
        Class<?> clsA;
        Class<?> enclosingClass = cls.getEnclosingClass();
        boolean z2 = false;
        boolean z3 = (enclosingClass == null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? false : true;
        String name = cls.getName();
        String strW = outline.w(name, "ConstructorAccess");
        if (strW.startsWith("java.")) {
            strW = outline.w("reflectasm.", strW);
        }
        AccessClassLoader accessClassLoaderB = AccessClassLoader.b(cls);
        try {
            clsA = accessClassLoaderB.loadClass(strW);
        } catch (ClassNotFoundException unused) {
            synchronized (accessClassLoaderB) {
                try {
                    clsA = accessClassLoaderB.loadClass(strW);
                } catch (ClassNotFoundException unused2) {
                    String strReplace = strW.replace('.', MentionUtils.SLASH_CHAR);
                    String strReplace2 = name.replace('.', MentionUtils.SLASH_CHAR);
                    String strReplace3 = null;
                    if (z3) {
                        strReplace3 = enclosingClass.getName().replace('.', MentionUtils.SLASH_CHAR);
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
                            ClassWriter2 classWriter2 = new ClassWriter2(0);
                            classWriter2.c(Opcodes.V1_1, 33, strReplace, null, str, null);
                            MethodVisitor2 methodVisitor2E = classWriter2.e(1, "<init>", "()V", null, null);
                            methodVisitor2E.t(25, 0);
                            methodVisitor2E.o(Opcodes.INVOKESPECIAL, str, "<init>", "()V");
                            methodVisitor2E.e(Opcodes.RETURN);
                            methodVisitor2E.n(1, 1);
                            MethodVisitor2 methodVisitor2E2 = classWriter2.e(1, "newInstance", "()Ljava/lang/Object;", null, null);
                            methodVisitor2E2.s(Opcodes.NEW, strReplace2);
                            methodVisitor2E2.e(89);
                            methodVisitor2E2.o(Opcodes.INVOKESPECIAL, strReplace2, "<init>", "()V");
                            methodVisitor2E2.e(Opcodes.ARETURN);
                            methodVisitor2E2.n(2, 1);
                            b(classWriter2, strReplace2, str2);
                            clsA = accessClassLoaderB.a(strW, classWriter2.b());
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
                            ClassWriter2 classWriter3 = new ClassWriter2(0);
                            classWriter3.c(Opcodes.V1_1, 33, strReplace, null, str, null);
                            MethodVisitor2 methodVisitor2E3 = classWriter3.e(1, "<init>", "()V", null, null);
                            methodVisitor2E3.t(25, 0);
                            methodVisitor2E3.o(Opcodes.INVOKESPECIAL, str, "<init>", "()V");
                            methodVisitor2E3.e(Opcodes.RETURN);
                            methodVisitor2E3.n(1, 1);
                            MethodVisitor2 methodVisitor2E4 = classWriter3.e(1, "newInstance", "()Ljava/lang/Object;", null, null);
                            methodVisitor2E4.s(Opcodes.NEW, strReplace2);
                            methodVisitor2E4.e(89);
                            methodVisitor2E4.o(Opcodes.INVOKESPECIAL, strReplace2, "<init>", "()V");
                            methodVisitor2E4.e(Opcodes.ARETURN);
                            methodVisitor2E4.n(2, 1);
                            b(classWriter3, strReplace2, str3);
                            clsA = accessClassLoaderB.a(strW, classWriter3.b());
                        } catch (Exception e2) {
                            throw new RuntimeException("Class cannot be created (missing no-arg constructor): " + cls.getName(), e2);
                        }
                    }
                }
            }
        }
        try {
            ConstructorAccess<T> constructorAccess = (ConstructorAccess) clsA.newInstance();
            if (!(constructorAccess instanceof PublicConstructorAccess)) {
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
            Objects.requireNonNull(constructorAccess);
            return constructorAccess;
        } catch (Throwable th) {
            throw new RuntimeException(outline.w("Exception constructing constructor access class: ", strW), th);
        }
    }

    public static void b(ClassWriter2 classWriter2, String str, String str2) {
        MethodVisitor2 methodVisitor2E = classWriter2.e(1, "newInstance", "(Ljava/lang/Object;)Ljava/lang/Object;", null, null);
        if (str2 == null) {
            methodVisitor2E.s(Opcodes.NEW, "java/lang/UnsupportedOperationException");
            methodVisitor2E.e(89);
            methodVisitor2E.j("Not an inner class.");
            methodVisitor2E.o(Opcodes.INVOKESPECIAL, "java/lang/UnsupportedOperationException", "<init>", "(Ljava/lang/String;)V");
            methodVisitor2E.e(Opcodes.ATHROW);
            methodVisitor2E.n(3, 2);
            return;
        }
        methodVisitor2E.s(Opcodes.NEW, str);
        methodVisitor2E.e(89);
        methodVisitor2E.t(25, 1);
        methodVisitor2E.s(Opcodes.CHECKCAST, str2);
        methodVisitor2E.e(89);
        methodVisitor2E.o(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
        methodVisitor2E.e(87);
        methodVisitor2E.o(Opcodes.INVOKESPECIAL, str, "<init>", "(L" + str2 + ";)V");
        methodVisitor2E.e(Opcodes.ARETURN);
        methodVisitor2E.n(4, 2);
    }

    public abstract T c();
}
