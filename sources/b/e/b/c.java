package b.e.b;

import com.discord.widgets.chat.input.MentionUtilsKt;
import h0.a.a.f;
import h0.a.a.p;
import h0.a.a.q;
import h0.a.a.w;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: FieldAccess.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public String[] a;

    public static c a(Class cls) {
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
        String strW = b.d.b.a.a.w(name, "FieldAccess");
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
                    f fVar = new f(0);
                    fVar.c(Opcodes.V1_1, 33, strReplace, null, "com/esotericsoftware/reflectasm/FieldAccess", null);
                    q qVarE = fVar.e(1, "<init>", "()V", null, null);
                    qVarE.t(25, 0);
                    qVarE.o(Opcodes.INVOKESPECIAL, "com/esotericsoftware/reflectasm/FieldAccess", "<init>", "()V");
                    qVarE.e(Opcodes.RETURN);
                    qVarE.n(1, 1);
                    m(fVar, strReplace2, arrayList);
                    p(fVar, strReplace2, arrayList);
                    n(fVar, strReplace2, arrayList, w.f3726b);
                    q(fVar, strReplace2, arrayList, w.f3726b);
                    n(fVar, strReplace2, arrayList, w.d);
                    q(fVar, strReplace2, arrayList, w.d);
                    n(fVar, strReplace2, arrayList, w.e);
                    q(fVar, strReplace2, arrayList, w.e);
                    n(fVar, strReplace2, arrayList, w.f);
                    q(fVar, strReplace2, arrayList, w.f);
                    n(fVar, strReplace2, arrayList, w.h);
                    q(fVar, strReplace2, arrayList, w.h);
                    n(fVar, strReplace2, arrayList, w.i);
                    q(fVar, strReplace2, arrayList, w.i);
                    n(fVar, strReplace2, arrayList, w.g);
                    q(fVar, strReplace2, arrayList, w.g);
                    n(fVar, strReplace2, arrayList, w.c);
                    q(fVar, strReplace2, arrayList, w.c);
                    o(fVar, strReplace2, arrayList);
                    clsA = aVarB.a(strW, fVar.b());
                }
            }
        }
        try {
            c cVar = (c) clsA.newInstance();
            cVar.a = strArr;
            return cVar;
        } catch (Throwable th) {
            throw new RuntimeException(b.d.b.a.a.w("Error constructing field access class: ", strW), th);
        }
    }

    public static void m(f fVar, String str, ArrayList<Field> arrayList) {
        int i;
        q qVarE = fVar.e(1, "get", "(Ljava/lang/Object;I)Ljava/lang/Object;", null, null);
        qVarE.t(21, 2);
        if (arrayList.isEmpty()) {
            i = 6;
        } else {
            i = 5;
            int size = arrayList.size();
            p[] pVarArr = new p[size];
            for (int i2 = 0; i2 < size; i2++) {
                pVarArr[i2] = new p();
            }
            p pVar = new p();
            qVarE.q(0, size - 1, pVar, pVarArr);
            for (int i3 = 0; i3 < size; i3++) {
                Field field = arrayList.get(i3);
                qVarE.i(pVarArr[i3]);
                qVarE.c(3, 0, null, 0, null);
                qVarE.t(25, 1);
                qVarE.s(Opcodes.CHECKCAST, str);
                qVarE.b(180, str, field.getName(), w.e(field.getType()));
                switch (w.j(field.getType()).i()) {
                    case 1:
                        qVarE.o(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
                        break;
                    case 2:
                        qVarE.o(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
                        break;
                    case 3:
                        qVarE.o(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                        break;
                    case 4:
                        qVarE.o(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                        break;
                    case 5:
                        qVarE.o(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                        break;
                    case 6:
                        qVarE.o(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                        break;
                    case 7:
                        qVarE.o(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                        break;
                    case 8:
                        qVarE.o(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                        break;
                }
                qVarE.e(Opcodes.ARETURN);
            }
            qVarE.i(pVar);
            qVarE.c(3, 0, null, 0, null);
        }
        r(qVarE);
        qVarE.n(i, 3);
    }

    public static void n(f fVar, String str, ArrayList<Field> arrayList, w wVar) {
        String str2;
        int i;
        String strD = wVar.d();
        int i2 = wVar.i();
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
        q qVarE = fVar.e(1, str2, b.d.b.a.a.w("(Ljava/lang/Object;I)", strD), null, null);
        qVarE.t(21, 2);
        if (arrayList.isEmpty()) {
            i = 6;
        } else {
            int size = arrayList.size();
            p[] pVarArr = new p[size];
            p pVar = new p();
            boolean z2 = false;
            for (int i4 = 0; i4 < size; i4++) {
                if (w.j(arrayList.get(i4).getType()).equals(wVar)) {
                    pVarArr[i4] = new p();
                } else {
                    pVarArr[i4] = pVar;
                    z2 = true;
                }
            }
            p pVar2 = new p();
            qVarE.q(0, size - 1, pVar2, pVarArr);
            for (int i5 = 0; i5 < size; i5++) {
                Field field = arrayList.get(i5);
                if (!pVarArr[i5].equals(pVar)) {
                    qVarE.i(pVarArr[i5]);
                    qVarE.c(3, 0, null, 0, null);
                    qVarE.t(25, 1);
                    qVarE.s(Opcodes.CHECKCAST, str);
                    qVarE.b(180, str, field.getName(), strD);
                    qVarE.e(i3);
                }
            }
            if (z2) {
                qVarE.i(pVar);
                qVarE.c(3, 0, null, 0, null);
                s(qVarE, wVar.c());
            }
            qVarE.i(pVar2);
            qVarE.c(3, 0, null, 0, null);
            i = 5;
        }
        r(qVarE);
        qVarE.n(i, 3);
    }

    public static void o(f fVar, String str, ArrayList<Field> arrayList) {
        int i;
        q qVarE = fVar.e(1, "getString", "(Ljava/lang/Object;I)Ljava/lang/String;", null, null);
        qVarE.t(21, 2);
        if (arrayList.isEmpty()) {
            i = 6;
        } else {
            int size = arrayList.size();
            p[] pVarArr = new p[size];
            p pVar = new p();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                if (arrayList.get(i2).getType().equals(String.class)) {
                    pVarArr[i2] = new p();
                } else {
                    pVarArr[i2] = pVar;
                    z2 = true;
                }
            }
            p pVar2 = new p();
            qVarE.q(0, size - 1, pVar2, pVarArr);
            for (int i3 = 0; i3 < size; i3++) {
                if (!pVarArr[i3].equals(pVar)) {
                    qVarE.i(pVarArr[i3]);
                    qVarE.c(3, 0, null, 0, null);
                    qVarE.t(25, 1);
                    qVarE.s(Opcodes.CHECKCAST, str);
                    qVarE.b(180, str, arrayList.get(i3).getName(), "Ljava/lang/String;");
                    qVarE.e(Opcodes.ARETURN);
                }
            }
            if (z2) {
                qVarE.i(pVar);
                qVarE.c(3, 0, null, 0, null);
                s(qVarE, "String");
            }
            qVarE.i(pVar2);
            qVarE.c(3, 0, null, 0, null);
            i = 5;
        }
        r(qVarE);
        qVarE.n(i, 3);
    }

    public static void p(f fVar, String str, ArrayList<Field> arrayList) {
        int i;
        q qVarE = fVar.e(1, "set", "(Ljava/lang/Object;ILjava/lang/Object;)V", null, null);
        qVarE.t(21, 2);
        if (arrayList.isEmpty()) {
            i = 6;
        } else {
            i = 5;
            int size = arrayList.size();
            p[] pVarArr = new p[size];
            for (int i2 = 0; i2 < size; i2++) {
                pVarArr[i2] = new p();
            }
            p pVar = new p();
            qVarE.q(0, size - 1, pVar, pVarArr);
            for (int i3 = 0; i3 < size; i3++) {
                Field field = arrayList.get(i3);
                w wVarJ = w.j(field.getType());
                qVarE.i(pVarArr[i3]);
                qVarE.c(3, 0, null, 0, null);
                qVarE.t(25, 1);
                qVarE.s(Opcodes.CHECKCAST, str);
                qVarE.t(25, 3);
                switch (wVarJ.i()) {
                    case 1:
                        qVarE.s(Opcodes.CHECKCAST, "java/lang/Boolean");
                        qVarE.o(Opcodes.INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z");
                        break;
                    case 2:
                        qVarE.s(Opcodes.CHECKCAST, "java/lang/Character");
                        qVarE.o(Opcodes.INVOKEVIRTUAL, "java/lang/Character", "charValue", "()C");
                        break;
                    case 3:
                        qVarE.s(Opcodes.CHECKCAST, "java/lang/Byte");
                        qVarE.o(Opcodes.INVOKEVIRTUAL, "java/lang/Byte", "byteValue", "()B");
                        break;
                    case 4:
                        qVarE.s(Opcodes.CHECKCAST, "java/lang/Short");
                        qVarE.o(Opcodes.INVOKEVIRTUAL, "java/lang/Short", "shortValue", "()S");
                        break;
                    case 5:
                        qVarE.s(Opcodes.CHECKCAST, "java/lang/Integer");
                        qVarE.o(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I");
                        break;
                    case 6:
                        qVarE.s(Opcodes.CHECKCAST, "java/lang/Float");
                        qVarE.o(Opcodes.INVOKEVIRTUAL, "java/lang/Float", "floatValue", "()F");
                        break;
                    case 7:
                        qVarE.s(Opcodes.CHECKCAST, "java/lang/Long");
                        qVarE.o(Opcodes.INVOKEVIRTUAL, "java/lang/Long", "longValue", "()J");
                        break;
                    case 8:
                        qVarE.s(Opcodes.CHECKCAST, "java/lang/Double");
                        qVarE.o(Opcodes.INVOKEVIRTUAL, "java/lang/Double", "doubleValue", "()D");
                        break;
                    case 9:
                        qVarE.s(Opcodes.CHECKCAST, wVarJ.d());
                        break;
                    case 10:
                        qVarE.s(Opcodes.CHECKCAST, wVarJ.g());
                        break;
                }
                qVarE.b(Opcodes.PUTFIELD, str, field.getName(), wVarJ.d());
                qVarE.e(Opcodes.RETURN);
            }
            qVarE.i(pVar);
            qVarE.c(3, 0, null, 0, null);
        }
        r(qVarE);
        qVarE.n(i, 4);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    public static void q(f fVar, String str, ArrayList<Field> arrayList, w wVar) {
        String str2;
        String str3;
        int i;
        String str4;
        String str5;
        int i2;
        int i3;
        String strD = wVar.d();
        switch (wVar.i()) {
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
        q qVarE = fVar.e(1, str5, b.d.b.a.a.y("(Ljava/lang/Object;I", strD, ")V"), null, null);
        qVarE.t(21, 2);
        if (arrayList.isEmpty()) {
            i3 = 6;
        } else {
            int size = arrayList.size();
            p[] pVarArr = new p[size];
            p pVar = new p();
            boolean z2 = false;
            for (int i4 = 0; i4 < size; i4++) {
                if (w.j(arrayList.get(i4).getType()).equals(wVar)) {
                    pVarArr[i4] = new p();
                } else {
                    pVarArr[i4] = pVar;
                    z2 = true;
                }
            }
            p pVar2 = new p();
            qVarE.q(0, size - 1, pVar2, pVarArr);
            for (int i5 = 0; i5 < size; i5++) {
                if (!pVarArr[i5].equals(pVar)) {
                    qVarE.i(pVarArr[i5]);
                    qVarE.c(3, 0, null, 0, null);
                    qVarE.t(25, 1);
                    qVarE.s(Opcodes.CHECKCAST, str);
                    qVarE.t(i, 3);
                    qVarE.b(Opcodes.PUTFIELD, str, arrayList.get(i5).getName(), strD);
                    qVarE.e(Opcodes.RETURN);
                }
            }
            if (z2) {
                qVarE.i(pVar);
                qVarE.c(3, 0, null, 0, null);
                s(qVarE, wVar.c());
            }
            qVarE.i(pVar2);
            qVarE.c(3, 0, null, 0, null);
            i3 = 5;
        }
        r(qVarE);
        qVarE.n(i3, i2);
    }

    public static q r(q qVar) {
        qVar.s(Opcodes.NEW, "java/lang/IllegalArgumentException");
        qVar.e(89);
        qVar.s(Opcodes.NEW, "java/lang/StringBuilder");
        qVar.e(89);
        qVar.j("Field not found: ");
        qVar.o(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
        qVar.t(21, 2);
        qVar.o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
        qVar.o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
        qVar.o(Opcodes.INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
        qVar.e(Opcodes.ATHROW);
        return qVar;
    }

    public static q s(q qVar, String str) {
        qVar.s(Opcodes.NEW, "java/lang/IllegalArgumentException");
        qVar.e(89);
        qVar.s(Opcodes.NEW, "java/lang/StringBuilder");
        qVar.e(89);
        qVar.j("Field not declared as " + str + ": ");
        qVar.o(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
        qVar.t(21, 2);
        qVar.o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
        qVar.o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
        qVar.o(Opcodes.INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
        qVar.e(Opcodes.ATHROW);
        return qVar;
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
        throw new IllegalArgumentException(b.d.b.a.a.w("Unable to find non-private field: ", str));
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
