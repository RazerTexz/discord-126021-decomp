package b.e.b;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import h0.a.a.ClassWriter2;
import h0.a.a.Label2;
import h0.a.a.MethodVisitor2;
import h0.a.a.Type2;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.e.b.d, reason: use source file name */
/* JADX INFO: compiled from: MethodAccess.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class MethodAccess {
    public String[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class[][] f455b;

    public static void a(Class cls, ArrayList<Method> arrayList) {
        for (Method method : cls.getDeclaredMethods()) {
            if (!Modifier.isPrivate(method.getModifiers())) {
                arrayList.add(method);
            }
        }
    }

    public static MethodAccess b(Class cls) {
        Class[][] clsArr;
        String str;
        MethodVisitor2 methodVisitor2;
        Class<?> clsA;
        MethodVisitor2 methodVisitor3;
        ArrayList arrayList = new ArrayList();
        boolean zIsInterface = cls.isInterface();
        if (zIsInterface) {
            e(cls, arrayList);
        } else {
            for (Class superclass = cls; superclass != Object.class; superclass = superclass.getSuperclass()) {
                a(superclass, arrayList);
            }
        }
        int size = arrayList.size();
        String[] strArr = new String[size];
        Class[][] clsArr2 = new Class[size][];
        Class[] clsArr3 = new Class[size];
        for (int i = 0; i < size; i++) {
            Method method = (Method) arrayList.get(i);
            strArr[i] = method.getName();
            clsArr2[i] = method.getParameterTypes();
            clsArr3[i] = method.getReturnType();
        }
        String name = cls.getName();
        String strW = outline.w(name, "MethodAccess");
        if (strW.startsWith("java.")) {
            strW = outline.w("reflectasm.", strW);
        }
        AccessClassLoader accessClassLoaderB = AccessClassLoader.b(cls);
        try {
            clsA = accessClassLoaderB.loadClass(strW);
            clsArr = clsArr2;
        } catch (ClassNotFoundException unused) {
            synchronized (accessClassLoaderB) {
                try {
                    clsA = accessClassLoaderB.loadClass(strW);
                    clsArr = clsArr2;
                } catch (ClassNotFoundException unused2) {
                    String strReplace = strW.replace('.', MentionUtils.SLASH_CHAR);
                    String strReplace2 = name.replace('.', MentionUtils.SLASH_CHAR);
                    ClassWriter2 classWriter2 = new ClassWriter2(1);
                    classWriter2.c(Opcodes.V1_1, 33, strReplace, null, "com/esotericsoftware/reflectasm/MethodAccess", null);
                    MethodVisitor2 methodVisitor2E = classWriter2.e(1, "<init>", "()V", null, null);
                    methodVisitor2E.t(25, 0);
                    methodVisitor2E.o(Opcodes.INVOKESPECIAL, "com/esotericsoftware/reflectasm/MethodAccess", "<init>", "()V");
                    methodVisitor2E.e(Opcodes.RETURN);
                    methodVisitor2E.n(0, 0);
                    MethodVisitor2 methodVisitor2E2 = classWriter2.e(Opcodes.LOR, "invoke", "(Ljava/lang/Object;I[Ljava/lang/Object;)Ljava/lang/Object;", null, null);
                    if (arrayList.isEmpty()) {
                        clsArr = clsArr2;
                        str = strW;
                        methodVisitor2 = methodVisitor2E2;
                    } else {
                        methodVisitor2E2.t(25, 1);
                        methodVisitor2E2.s(Opcodes.CHECKCAST, strReplace2);
                        methodVisitor2E2.t(58, 4);
                        methodVisitor2E2.t(21, 2);
                        Label2[] label2Arr = new Label2[size];
                        for (int i2 = 0; i2 < size; i2++) {
                            label2Arr[i2] = new Label2();
                        }
                        Label2 label2 = new Label2();
                        methodVisitor2E2.q(0, size - 1, label2, label2Arr);
                        StringBuilder sb = new StringBuilder(128);
                        int i3 = 0;
                        while (i3 < size) {
                            methodVisitor2E2.i(label2Arr[i3]);
                            if (i3 == 0) {
                                methodVisitor3 = methodVisitor2E2;
                                methodVisitor2E2.c(1, 1, new Object[]{strReplace2}, 0, null);
                            } else {
                                methodVisitor3 = methodVisitor2E2;
                                methodVisitor3.c(3, 0, null, 0, null);
                            }
                            methodVisitor2E2 = methodVisitor3;
                            methodVisitor2E2.t(25, 4);
                            sb.setLength(0);
                            sb.append('(');
                            int i4 = i3;
                            Class[] clsArr4 = clsArr2[i4];
                            Class cls2 = clsArr3[i4];
                            int i5 = 0;
                            int i6 = size;
                            while (i5 < clsArr4.length) {
                                Class[] clsArr5 = clsArr3;
                                methodVisitor2E2.t(25, 3);
                                methodVisitor2E2.g(16, i5);
                                methodVisitor2E2.e(50);
                                Type2 type2J = Type2.j(clsArr4[i5]);
                                switch (type2J.i()) {
                                    case 1:
                                        clsArr4 = clsArr4;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, "java/lang/Boolean");
                                        methodVisitor2E2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z");
                                        break;
                                    case 2:
                                        clsArr4 = clsArr4;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, "java/lang/Character");
                                        methodVisitor2E2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Character", "charValue", "()C");
                                        break;
                                    case 3:
                                        clsArr4 = clsArr4;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, "java/lang/Byte");
                                        methodVisitor2E2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Byte", "byteValue", "()B");
                                        break;
                                    case 4:
                                        clsArr4 = clsArr4;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, "java/lang/Short");
                                        methodVisitor2E2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Short", "shortValue", "()S");
                                        break;
                                    case 5:
                                        clsArr4 = clsArr4;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, "java/lang/Integer");
                                        methodVisitor2E2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I");
                                        break;
                                    case 6:
                                        clsArr4 = clsArr4;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, "java/lang/Float");
                                        methodVisitor2E2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Float", "floatValue", "()F");
                                        break;
                                    case 7:
                                        clsArr4 = clsArr4;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, "java/lang/Long");
                                        methodVisitor2E2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Long", "longValue", "()J");
                                        break;
                                    case 8:
                                        clsArr4 = clsArr4;
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, "java/lang/Double");
                                        methodVisitor2E2.o(Opcodes.INVOKEVIRTUAL, "java/lang/Double", "doubleValue", "()D");
                                        break;
                                    case 9:
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, type2J.d());
                                        break;
                                    case 10:
                                        methodVisitor2E2.s(Opcodes.CHECKCAST, type2J.g());
                                        break;
                                    default:
                                        clsArr4 = clsArr4;
                                        break;
                                }
                                sb.append(type2J.d());
                                i5++;
                                clsArr4 = clsArr4;
                                clsArr3 = clsArr5;
                                clsArr2 = clsArr2;
                                strW = strW;
                            }
                            Class[][] clsArr6 = clsArr2;
                            Class[] clsArr7 = clsArr3;
                            String str2 = strW;
                            sb.append(')');
                            sb.append(Type2.e(cls2));
                            methodVisitor2E2.o(zIsInterface ? Opcodes.INVOKEINTERFACE : Modifier.isStatic(((Method) arrayList.get(i4)).getModifiers()) ? Opcodes.INVOKESTATIC : Opcodes.INVOKEVIRTUAL, strReplace2, strArr[i4], sb.toString());
                            switch (Type2.j(cls2).i()) {
                                case 0:
                                    methodVisitor2E2.e(1);
                                    break;
                                case 1:
                                    methodVisitor2E2.o(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
                                    break;
                                case 2:
                                    methodVisitor2E2.o(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
                                    break;
                                case 3:
                                    methodVisitor2E2.o(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                                    break;
                                case 4:
                                    methodVisitor2E2.o(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                                    break;
                                case 5:
                                    methodVisitor2E2.o(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                    break;
                                case 6:
                                    methodVisitor2E2.o(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                                    break;
                                case 7:
                                    methodVisitor2E2.o(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                                    break;
                                case 8:
                                    methodVisitor2E2.o(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                                    break;
                            }
                            methodVisitor2E2.e(Opcodes.ARETURN);
                            i3 = i4 + 1;
                            size = i6;
                            label2Arr = label2Arr;
                            clsArr3 = clsArr7;
                            clsArr2 = clsArr6;
                            strW = str2;
                            label2 = label2;
                        }
                        clsArr = clsArr2;
                        str = strW;
                        methodVisitor2E2.i(label2);
                        methodVisitor2 = methodVisitor2E2;
                        methodVisitor2E2.c(3, 0, null, 0, null);
                    }
                    methodVisitor2.s(Opcodes.NEW, "java/lang/IllegalArgumentException");
                    methodVisitor2.e(89);
                    methodVisitor2.s(Opcodes.NEW, "java/lang/StringBuilder");
                    methodVisitor2.e(89);
                    methodVisitor2.j("Method not found: ");
                    methodVisitor2.o(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
                    methodVisitor2.t(21, 2);
                    methodVisitor2.o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
                    methodVisitor2.o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
                    methodVisitor2.o(Opcodes.INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
                    methodVisitor2.e(Opcodes.ATHROW);
                    methodVisitor2.n(0, 0);
                    strW = str;
                    clsA = accessClassLoaderB.a(strW, classWriter2.b());
                }
            }
        }
        try {
            MethodAccess methodAccess = (MethodAccess) clsA.newInstance();
            methodAccess.a = strArr;
            methodAccess.f455b = clsArr;
            return methodAccess;
        } catch (Throwable th) {
            throw new RuntimeException(outline.w("Error constructing method access class: ", strW), th);
        }
    }

    public static void e(Class cls, ArrayList<Method> arrayList) {
        a(cls, arrayList);
        for (Class<?> cls2 : cls.getInterfaces()) {
            e(cls2, arrayList);
        }
    }

    public int c(String str, Class... clsArr) {
        int length = this.a.length;
        for (int i = 0; i < length; i++) {
            if (this.a[i].equals(str) && Arrays.equals(clsArr, this.f455b[i])) {
                return i;
            }
        }
        StringBuilder sbY = outline.Y("Unable to find non-private method: ", str, " ");
        sbY.append(Arrays.toString(clsArr));
        throw new IllegalArgumentException(sbY.toString());
    }

    public abstract Object d(Object obj, int i, Object... objArr);
}
