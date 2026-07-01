package b.e.b;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import h0.a.a.ClassWriter2;
import h0.a.a.Label2;
import h0.a.a.MethodVisitor2;
import h0.a.a.Type2;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.e.b.c, reason: use source file name */
/* JADX INFO: compiled from: FieldAccess.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class FieldAccess2 {
    public String[] a;

    public static FieldAccess2 a(Class cls) {
        Class<?> clsA;
        ArrayList arrayList = new ArrayList();
        Class superclass = cls;
        while (true) {
            if (superclass == Object.class) {
                break;
            }
            for (Field field : superclass.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                if (!Modifier.isStatic(modifiers) && !Modifier.isPrivate(modifiers)) {
                    arrayList.add(field);
                }
            }
            superclass = superclass.getSuperclass();
        }
        int size = arrayList.size();
        String[] strArr = new String[size];
        Class[] clsArr = new Class[arrayList.size()];
        for (int i = 0; i < size; i++) {
            strArr[i] = ((Field) arrayList.get(i)).getName();
            clsArr[i] = ((Field) arrayList.get(i)).getType();
        }
        String name = cls.getName();
        String strW = outline.w(name, "FieldAccess");
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
                    ClassWriter2 classWriter2 = new ClassWriter2(0);
                    classWriter2.c(Opcodes.V1_1, 33, strReplace, null, "com/esotericsoftware/reflectasm/FieldAccess", null);
                    MethodVisitor2 methodVisitor2E = classWriter2.e(1, "<init>", "()V", null, null);
                    methodVisitor2E.t(25, 0);
                    methodVisitor2E.o(Opcodes.INVOKESPECIAL, "com/esotericsoftware/reflectasm/FieldAccess", "<init>", "()V");
                    methodVisitor2E.e(Opcodes.RETURN);
                    methodVisitor2E.n(1, 1);
                    m(classWriter2, strReplace2, arrayList);
                    p(classWriter2, strReplace2, arrayList);
                    n(classWriter2, strReplace2, arrayList, Type2.f3726b);
                    q(classWriter2, strReplace2, arrayList, Type2.f3726b);
                    n(classWriter2, strReplace2, arrayList, Type2.d);
                    q(classWriter2, strReplace2, arrayList, Type2.d);
                    n(classWriter2, strReplace2, arrayList, Type2.e);
                    q(classWriter2, strReplace2, arrayList, Type2.e);
                    n(classWriter2, strReplace2, arrayList, Type2.f);
                    q(classWriter2, strReplace2, arrayList, Type2.f);
                    n(classWriter2, strReplace2, arrayList, Type2.h);
                    q(classWriter2, strReplace2, arrayList, Type2.h);
                    n(classWriter2, strReplace2, arrayList, Type2.i);
                    q(classWriter2, strReplace2, arrayList, Type2.i);
                    n(classWriter2, strReplace2, arrayList, Type2.g);
                    q(classWriter2, strReplace2, arrayList, Type2.g);
                    n(classWriter2, strReplace2, arrayList, Type2.c);
                    q(classWriter2, strReplace2, arrayList, Type2.c);
                    o(classWriter2, strReplace2, arrayList);
                    clsA = accessClassLoaderB.a(strW, classWriter2.b());
                }
            }
        }
        try {
            FieldAccess2 fieldAccess2 = (FieldAccess2) clsA.newInstance();
            fieldAccess2.a = strArr;
            return fieldAccess2;
        } catch (Throwable th) {
            throw new RuntimeException(outline.w("Error constructing field access class: ", strW), th);
        }
    }

    public static void m(ClassWriter2 classWriter2, String str, ArrayList<Field> arrayList) {
        int i;
        MethodVisitor2 methodVisitor2E = classWriter2.e(1, "get", "(Ljava/lang/Object;I)Ljava/lang/Object;", null, null);
        methodVisitor2E.t(21, 2);
        if (arrayList.isEmpty()) {
            i = 6;
        } else {
            i = 5;
            int size = arrayList.size();
            Label2[] label2Arr = new Label2[size];
            for (int i2 = 0; i2 < size; i2++) {
                label2Arr[i2] = new Label2();
            }
            Label2 label2 = new Label2();
            methodVisitor2E.q(0, size - 1, label2, label2Arr);
            for (int i3 = 0; i3 < size; i3++) {
                Field field = arrayList.get(i3);
                methodVisitor2E.i(label2Arr[i3]);
                methodVisitor2E.c(3, 0, null, 0, null);
                methodVisitor2E.t(25, 1);
                methodVisitor2E.s(Opcodes.CHECKCAST, str);
                methodVisitor2E.b(180, str, field.getName(), Type2.e(field.getType()));
                switch (Type2.j(field.getType()).i()) {
                    case 1:
                        methodVisitor2E.o(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
                        break;
                    case 2:
                        methodVisitor2E.o(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
                        break;
                    case 3:
                        methodVisitor2E.o(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                        break;
                    case 4:
                        methodVisitor2E.o(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                        break;
                    case 5:
                        methodVisitor2E.o(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                        break;
                    case 6:
                        methodVisitor2E.o(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                        break;
                    case 7:
                        methodVisitor2E.o(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                        break;
                    case 8:
                        methodVisitor2E.o(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                        break;
                }
                methodVisitor2E.e(Opcodes.ARETURN);
            }
            methodVisitor2E.i(label2);
            methodVisitor2E.c(3, 0, null, 0, null);
        }
        r(methodVisitor2E);
        methodVisitor2E.n(i, 3);
    }

    public static void n(ClassWriter2 classWriter2, String str, ArrayList<Field> arrayList, Type2 type2) {
        String str2;
        int i;
        String strD = type2.d();
        int i2 = type2.i();
        int i3 = Opcodes.IRETURN;
        switch (i2) {
            case 1:
                str2 = "getBoolean";
                break;
            case 2:
                str2 = "getChar";
                break;
            case 3:
                str2 = "getByte";
                break;
            case 4:
                str2 = "getShort";
                break;
            case 5:
                str2 = "getInt";
                break;
            case 6:
                i3 = Opcodes.FRETURN;
                str2 = "getFloat";
                break;
            case 7:
                i3 = Opcodes.LRETURN;
                str2 = "getLong";
                break;
            case 8:
                i3 = 175;
                str2 = "getDouble";
                break;
            default:
                i3 = Opcodes.ARETURN;
                str2 = "get";
                break;
        }
        MethodVisitor2 methodVisitor2E = classWriter2.e(1, str2, outline.w("(Ljava/lang/Object;I)", strD), null, null);
        methodVisitor2E.t(21, 2);
        if (arrayList.isEmpty()) {
            i = 6;
        } else {
            int size = arrayList.size();
            Label2[] label2Arr = new Label2[size];
            Label2 label2 = new Label2();
            boolean z2 = false;
            for (int i4 = 0; i4 < size; i4++) {
                if (Type2.j(arrayList.get(i4).getType()).equals(type2)) {
                    label2Arr[i4] = new Label2();
                } else {
                    label2Arr[i4] = label2;
                    z2 = true;
                }
            }
            Label2 label3 = new Label2();
            methodVisitor2E.q(0, size - 1, label3, label2Arr);
            for (int i5 = 0; i5 < size; i5++) {
                Field field = arrayList.get(i5);
                if (!label2Arr[i5].equals(label2)) {
                    methodVisitor2E.i(label2Arr[i5]);
                    methodVisitor2E.c(3, 0, null, 0, null);
                    methodVisitor2E.t(25, 1);
                    methodVisitor2E.s(Opcodes.CHECKCAST, str);
                    methodVisitor2E.b(180, str, field.getName(), strD);
                    methodVisitor2E.e(i3);
                }
            }
            if (z2) {
                methodVisitor2E.i(label2);
                methodVisitor2E.c(3, 0, null, 0, null);
                s(methodVisitor2E, type2.c());
            }
            methodVisitor2E.i(label3);
            methodVisitor2E.c(3, 0, null, 0, null);
            i = 5;
        }
        r(methodVisitor2E);
        methodVisitor2E.n(i, 3);
    }

    public static void o(ClassWriter2 classWriter2, String str, ArrayList<Field> arrayList) {
        int i;
        MethodVisitor2 methodVisitor2E = classWriter2.e(1, "getString", "(Ljava/lang/Object;I)Ljava/lang/String;", null, null);
        methodVisitor2E.t(21, 2);
        if (arrayList.isEmpty()) {
            i = 6;
        } else {
            int size = arrayList.size();
            Label2[] label2Arr = new Label2[size];
            Label2 label2 = new Label2();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                if (arrayList.get(i2).getType().equals(String.class)) {
                    label2Arr[i2] = new Label2();
                } else {
                    label2Arr[i2] = label2;
                    z2 = true;
                }
            }
            Label2 label3 = new Label2();
            methodVisitor2E.q(0, size - 1, label3, label2Arr);
            for (int i3 = 0; i3 < size; i3++) {
                if (!label2Arr[i3].equals(label2)) {
                    methodVisitor2E.i(label2Arr[i3]);
                    methodVisitor2E.c(3, 0, null, 0, null);
                    methodVisitor2E.t(25, 1);
                    methodVisitor2E.s(Opcodes.CHECKCAST, str);
                    methodVisitor2E.b(180, str, arrayList.get(i3).getName(), "Ljava/lang/String;");
                    methodVisitor2E.e(Opcodes.ARETURN);
                }
            }
            if (z2) {
                methodVisitor2E.i(label2);
                methodVisitor2E.c(3, 0, null, 0, null);
                s(methodVisitor2E, "String");
            }
            methodVisitor2E.i(label3);
            methodVisitor2E.c(3, 0, null, 0, null);
            i = 5;
        }
        r(methodVisitor2E);
        methodVisitor2E.n(i, 3);
    }

    public static void p(ClassWriter2 classWriter2, String str, ArrayList<Field> arrayList) {
        int i;
        MethodVisitor2 methodVisitor2E = classWriter2.e(1, "set", "(Ljava/lang/Object;ILjava/lang/Object;)V", null, null);
        methodVisitor2E.t(21, 2);
        if (arrayList.isEmpty()) {
            i = 6;
        } else {
            i = 5;
            int size = arrayList.size();
            Label2[] label2Arr = new Label2[size];
            for (int i2 = 0; i2 < size; i2++) {
                label2Arr[i2] = new Label2();
            }
            Label2 label2 = new Label2();
            methodVisitor2E.q(0, size - 1, label2, label2Arr);
            for (int i3 = 0; i3 < size; i3++) {
                Field field = arrayList.get(i3);
                Type2 type2J = Type2.j(field.getType());
                methodVisitor2E.i(label2Arr[i3]);
                methodVisitor2E.c(3, 0, null, 0, null);
                methodVisitor2E.t(25, 1);
                methodVisitor2E.s(Opcodes.CHECKCAST, str);
                methodVisitor2E.t(25, 3);
                switch (type2J.i()) {
                    case 1:
                        methodVisitor2E.s(Opcodes.CHECKCAST, "java/lang/Boolean");
                        methodVisitor2E.o(Opcodes.INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z");
                        break;
                    case 2:
                        methodVisitor2E.s(Opcodes.CHECKCAST, "java/lang/Character");
                        methodVisitor2E.o(Opcodes.INVOKEVIRTUAL, "java/lang/Character", "charValue", "()C");
                        break;
                    case 3:
                        methodVisitor2E.s(Opcodes.CHECKCAST, "java/lang/Byte");
                        methodVisitor2E.o(Opcodes.INVOKEVIRTUAL, "java/lang/Byte", "byteValue", "()B");
                        break;
                    case 4:
                        methodVisitor2E.s(Opcodes.CHECKCAST, "java/lang/Short");
                        methodVisitor2E.o(Opcodes.INVOKEVIRTUAL, "java/lang/Short", "shortValue", "()S");
                        break;
                    case 5:
                        methodVisitor2E.s(Opcodes.CHECKCAST, "java/lang/Integer");
                        methodVisitor2E.o(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I");
                        break;
                    case 6:
                        methodVisitor2E.s(Opcodes.CHECKCAST, "java/lang/Float");
                        methodVisitor2E.o(Opcodes.INVOKEVIRTUAL, "java/lang/Float", "floatValue", "()F");
                        break;
                    case 7:
                        methodVisitor2E.s(Opcodes.CHECKCAST, "java/lang/Long");
                        methodVisitor2E.o(Opcodes.INVOKEVIRTUAL, "java/lang/Long", "longValue", "()J");
                        break;
                    case 8:
                        methodVisitor2E.s(Opcodes.CHECKCAST, "java/lang/Double");
                        methodVisitor2E.o(Opcodes.INVOKEVIRTUAL, "java/lang/Double", "doubleValue", "()D");
                        break;
                    case 9:
                        methodVisitor2E.s(Opcodes.CHECKCAST, type2J.d());
                        break;
                    case 10:
                        methodVisitor2E.s(Opcodes.CHECKCAST, type2J.g());
                        break;
                }
                methodVisitor2E.b(Opcodes.PUTFIELD, str, field.getName(), type2J.d());
                methodVisitor2E.e(Opcodes.RETURN);
            }
            methodVisitor2E.i(label2);
            methodVisitor2E.c(3, 0, null, 0, null);
        }
        r(methodVisitor2E);
        methodVisitor2E.n(i, 4);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    public static void q(ClassWriter2 classWriter2, String str, ArrayList<Field> arrayList, Type2 type2) {
        String str2;
        String str3;
        int i;
        String str4;
        String str5;
        int i2;
        int i3;
        String strD = type2.d();
        switch (type2.i()) {
            case 1:
                str2 = "setBoolean";
                str3 = str2;
                i = 21;
                str5 = str3;
                i2 = 4;
                break;
            case 2:
                str2 = "setChar";
                str3 = str2;
                i = 21;
                str5 = str3;
                i2 = 4;
                break;
            case 3:
                str2 = "setByte";
                str3 = str2;
                i = 21;
                str5 = str3;
                i2 = 4;
                break;
            case 4:
                str2 = "setShort";
                str3 = str2;
                i = 21;
                str5 = str3;
                i2 = 4;
                break;
            case 5:
                str2 = "setInt";
                str3 = str2;
                i = 21;
                str5 = str3;
                i2 = 4;
                break;
            case 6:
                i = 23;
                str3 = "setFloat";
                str5 = str3;
                i2 = 4;
                break;
            case 7:
                i = 22;
                str4 = "setLong";
                str5 = str4;
                i2 = 5;
                break;
            case 8:
                i = 24;
                str4 = "setDouble";
                str5 = str4;
                i2 = 5;
                break;
            default:
                str3 = "set";
                i = 25;
                str5 = str3;
                i2 = 4;
                break;
        }
        MethodVisitor2 methodVisitor2E = classWriter2.e(1, str5, outline.y("(Ljava/lang/Object;I", strD, ")V"), null, null);
        methodVisitor2E.t(21, 2);
        if (arrayList.isEmpty()) {
            i3 = 6;
        } else {
            int size = arrayList.size();
            Label2[] label2Arr = new Label2[size];
            Label2 label2 = new Label2();
            boolean z2 = false;
            for (int i4 = 0; i4 < size; i4++) {
                if (Type2.j(arrayList.get(i4).getType()).equals(type2)) {
                    label2Arr[i4] = new Label2();
                } else {
                    label2Arr[i4] = label2;
                    z2 = true;
                }
            }
            Label2 label3 = new Label2();
            methodVisitor2E.q(0, size - 1, label3, label2Arr);
            for (int i5 = 0; i5 < size; i5++) {
                if (!label2Arr[i5].equals(label2)) {
                    methodVisitor2E.i(label2Arr[i5]);
                    methodVisitor2E.c(3, 0, null, 0, null);
                    methodVisitor2E.t(25, 1);
                    methodVisitor2E.s(Opcodes.CHECKCAST, str);
                    methodVisitor2E.t(i, 3);
                    methodVisitor2E.b(Opcodes.PUTFIELD, str, arrayList.get(i5).getName(), strD);
                    methodVisitor2E.e(Opcodes.RETURN);
                }
            }
            if (z2) {
                methodVisitor2E.i(label2);
                methodVisitor2E.c(3, 0, null, 0, null);
                s(methodVisitor2E, type2.c());
            }
            methodVisitor2E.i(label3);
            methodVisitor2E.c(3, 0, null, 0, null);
            i3 = 5;
        }
        r(methodVisitor2E);
        methodVisitor2E.n(i3, i2);
    }

    public static MethodVisitor2 r(MethodVisitor2 methodVisitor2) {
        methodVisitor2.s(Opcodes.NEW, "java/lang/IllegalArgumentException");
        methodVisitor2.e(89);
        methodVisitor2.s(Opcodes.NEW, "java/lang/StringBuilder");
        methodVisitor2.e(89);
        methodVisitor2.j("Field not found: ");
        methodVisitor2.o(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
        methodVisitor2.t(21, 2);
        methodVisitor2.o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
        methodVisitor2.o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
        methodVisitor2.o(Opcodes.INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
        methodVisitor2.e(Opcodes.ATHROW);
        return methodVisitor2;
    }

    public static MethodVisitor2 s(MethodVisitor2 methodVisitor2, String str) {
        methodVisitor2.s(Opcodes.NEW, "java/lang/IllegalArgumentException");
        methodVisitor2.e(89);
        methodVisitor2.s(Opcodes.NEW, "java/lang/StringBuilder");
        methodVisitor2.e(89);
        methodVisitor2.j("Field not declared as " + str + ": ");
        methodVisitor2.o(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
        methodVisitor2.t(21, 2);
        methodVisitor2.o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
        methodVisitor2.o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
        methodVisitor2.o(Opcodes.INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
        methodVisitor2.e(Opcodes.ATHROW);
        return methodVisitor2;
    }

    public abstract void A(Object obj, int i, long j);

    public abstract void B(Object obj, int i, short s2);

    public abstract Object b(Object obj, int i);

    public abstract boolean c(Object obj, int i);

    public abstract byte d(Object obj, int i);

    public abstract char e(Object obj, int i);

    public abstract double f(Object obj, int i);

    public abstract float g(Object obj, int i);

    public int h(String str) {
        int length = this.a.length;
        for (int i = 0; i < length; i++) {
            if (this.a[i].equals(str)) {
                return i;
            }
        }
        throw new IllegalArgumentException(outline.w("Unable to find non-private field: ", str));
    }

    public abstract int i(Object obj, int i);

    public abstract long j(Object obj, int i);

    public abstract short k(Object obj, int i);

    public abstract String l(Object obj, int i);

    public abstract void t(Object obj, int i, Object obj2);

    public abstract void u(Object obj, int i, boolean z2);

    public abstract void v(Object obj, int i, byte b2);

    public abstract void w(Object obj, int i, char c);

    public abstract void x(Object obj, int i, double d);

    public abstract void y(Object obj, int i, float f);

    public abstract void z(Object obj, int i, int i2);
}
