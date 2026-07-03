package p007b.p106e.p108b;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p617h0.p618a.p619a.AbstractC12428q;
import p617h0.p618a.p619a.C12417f;
import p617h0.p618a.p619a.C12427p;
import p617h0.p618a.p619a.C12434w;

/* JADX INFO: renamed from: b.e.b.d */
/* JADX INFO: compiled from: MethodAccess.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1648d {

    /* JADX INFO: renamed from: a */
    public String[] f3014a;

    /* JADX INFO: renamed from: b */
    public Class[][] f3015b;

    /* JADX INFO: renamed from: a */
    public static void m923a(Class cls, ArrayList<Method> arrayList) {
        for (Method method : cls.getDeclaredMethods()) {
            if (!Modifier.isPrivate(method.getModifiers())) {
                arrayList.add(method);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static AbstractC1648d m924b(Class cls) {
        Class[][] clsArr;
        String str;
        AbstractC12428q abstractC12428q;
        Class<?> clsM891a;
        AbstractC12428q abstractC12428q2;
        ArrayList arrayList = new ArrayList();
        boolean zIsInterface = cls.isInterface();
        if (zIsInterface) {
            m925e(cls, arrayList);
        } else {
            for (Class superclass = cls; superclass != Object.class; superclass = superclass.getSuperclass()) {
                m923a(superclass, arrayList);
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
        String strM883w = C1643a.m883w(name, "MethodAccess");
        if (strM883w.startsWith("java.")) {
            strM883w = C1643a.m883w("reflectasm.", strM883w);
        }
        C1645a c1645aM889b = C1645a.m889b(cls);
        try {
            clsM891a = c1645aM889b.loadClass(strM883w);
            clsArr = clsArr2;
        } catch (ClassNotFoundException unused) {
            synchronized (c1645aM889b) {
                try {
                    clsM891a = c1645aM889b.loadClass(strM883w);
                    clsArr = clsArr2;
                } catch (ClassNotFoundException unused2) {
                    String strReplace = strM883w.replace('.', MentionUtilsKt.SLASH_CHAR);
                    String strReplace2 = name.replace('.', MentionUtilsKt.SLASH_CHAR);
                    C12417f c12417f = new C12417f(1);
                    c12417f.m10565c(Opcodes.V1_1, 33, strReplace, null, "com/esotericsoftware/reflectasm/MethodAccess", null);
                    AbstractC12428q abstractC12428qM10567e = c12417f.m10567e(1, "<init>", "()V", null, null);
                    abstractC12428qM10567e.mo10612t(25, 0);
                    abstractC12428qM10567e.m10607o(Opcodes.INVOKESPECIAL, "com/esotericsoftware/reflectasm/MethodAccess", "<init>", "()V");
                    abstractC12428qM10567e.mo10597e(Opcodes.RETURN);
                    abstractC12428qM10567e.mo10606n(0, 0);
                    AbstractC12428q abstractC12428qM10567e2 = c12417f.m10567e(Opcodes.LOR, "invoke", "(Ljava/lang/Object;I[Ljava/lang/Object;)Ljava/lang/Object;", null, null);
                    if (arrayList.isEmpty()) {
                        clsArr = clsArr2;
                        str = strM883w;
                        abstractC12428q = abstractC12428qM10567e2;
                    } else {
                        abstractC12428qM10567e2.mo10612t(25, 1);
                        abstractC12428qM10567e2.mo10611s(Opcodes.CHECKCAST, strReplace2);
                        abstractC12428qM10567e2.mo10612t(58, 4);
                        abstractC12428qM10567e2.mo10612t(21, 2);
                        C12427p[] c12427pArr = new C12427p[size];
                        for (int i2 = 0; i2 < size; i2++) {
                            c12427pArr[i2] = new C12427p();
                        }
                        C12427p c12427p = new C12427p();
                        abstractC12428qM10567e2.mo10609q(0, size - 1, c12427p, c12427pArr);
                        StringBuilder sb = new StringBuilder(128);
                        int i3 = 0;
                        while (i3 < size) {
                            abstractC12428qM10567e2.mo10601i(c12427pArr[i3]);
                            if (i3 == 0) {
                                abstractC12428q2 = abstractC12428qM10567e2;
                                abstractC12428qM10567e2.mo10595c(1, 1, new Object[]{strReplace2}, 0, null);
                            } else {
                                abstractC12428q2 = abstractC12428qM10567e2;
                                abstractC12428q2.mo10595c(3, 0, null, 0, null);
                            }
                            abstractC12428qM10567e2 = abstractC12428q2;
                            abstractC12428qM10567e2.mo10612t(25, 4);
                            sb.setLength(0);
                            sb.append('(');
                            int i4 = i3;
                            Class[] clsArr4 = clsArr2[i4];
                            Class cls2 = clsArr3[i4];
                            int i5 = 0;
                            int i6 = size;
                            while (i5 < clsArr4.length) {
                                Class[] clsArr5 = clsArr3;
                                abstractC12428qM10567e2.mo10612t(25, 3);
                                abstractC12428qM10567e2.mo10599g(16, i5);
                                abstractC12428qM10567e2.mo10597e(50);
                                C12434w c12434wM10648j = C12434w.m10648j(clsArr4[i5]);
                                switch (c12434wM10648j.m10654i()) {
                                    case 1:
                                        clsArr4 = clsArr4;
                                        abstractC12428qM10567e2.mo10611s(Opcodes.CHECKCAST, "java/lang/Boolean");
                                        abstractC12428qM10567e2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z");
                                        break;
                                    case 2:
                                        clsArr4 = clsArr4;
                                        abstractC12428qM10567e2.mo10611s(Opcodes.CHECKCAST, "java/lang/Character");
                                        abstractC12428qM10567e2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Character", "charValue", "()C");
                                        break;
                                    case 3:
                                        clsArr4 = clsArr4;
                                        abstractC12428qM10567e2.mo10611s(Opcodes.CHECKCAST, "java/lang/Byte");
                                        abstractC12428qM10567e2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Byte", "byteValue", "()B");
                                        break;
                                    case 4:
                                        clsArr4 = clsArr4;
                                        abstractC12428qM10567e2.mo10611s(Opcodes.CHECKCAST, "java/lang/Short");
                                        abstractC12428qM10567e2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Short", "shortValue", "()S");
                                        break;
                                    case 5:
                                        clsArr4 = clsArr4;
                                        abstractC12428qM10567e2.mo10611s(Opcodes.CHECKCAST, "java/lang/Integer");
                                        abstractC12428qM10567e2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I");
                                        break;
                                    case 6:
                                        clsArr4 = clsArr4;
                                        abstractC12428qM10567e2.mo10611s(Opcodes.CHECKCAST, "java/lang/Float");
                                        abstractC12428qM10567e2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Float", "floatValue", "()F");
                                        break;
                                    case 7:
                                        clsArr4 = clsArr4;
                                        abstractC12428qM10567e2.mo10611s(Opcodes.CHECKCAST, "java/lang/Long");
                                        abstractC12428qM10567e2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Long", "longValue", "()J");
                                        break;
                                    case 8:
                                        clsArr4 = clsArr4;
                                        abstractC12428qM10567e2.mo10611s(Opcodes.CHECKCAST, "java/lang/Double");
                                        abstractC12428qM10567e2.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Double", "doubleValue", "()D");
                                        break;
                                    case 9:
                                        abstractC12428qM10567e2.mo10611s(Opcodes.CHECKCAST, c12434wM10648j.m10651d());
                                        break;
                                    case 10:
                                        abstractC12428qM10567e2.mo10611s(Opcodes.CHECKCAST, c12434wM10648j.m10653g());
                                        break;
                                    default:
                                        clsArr4 = clsArr4;
                                        break;
                                }
                                sb.append(c12434wM10648j.m10651d());
                                i5++;
                                clsArr4 = clsArr4;
                                clsArr3 = clsArr5;
                                clsArr2 = clsArr2;
                                strM883w = strM883w;
                            }
                            Class[][] clsArr6 = clsArr2;
                            Class[] clsArr7 = clsArr3;
                            String str2 = strM883w;
                            sb.append(')');
                            sb.append(C12434w.m10646e(cls2));
                            abstractC12428qM10567e2.m10607o(zIsInterface ? Opcodes.INVOKEINTERFACE : Modifier.isStatic(((Method) arrayList.get(i4)).getModifiers()) ? Opcodes.INVOKESTATIC : Opcodes.INVOKEVIRTUAL, strReplace2, strArr[i4], sb.toString());
                            switch (C12434w.m10648j(cls2).m10654i()) {
                                case 0:
                                    abstractC12428qM10567e2.mo10597e(1);
                                    break;
                                case 1:
                                    abstractC12428qM10567e2.m10607o(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
                                    break;
                                case 2:
                                    abstractC12428qM10567e2.m10607o(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
                                    break;
                                case 3:
                                    abstractC12428qM10567e2.m10607o(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                                    break;
                                case 4:
                                    abstractC12428qM10567e2.m10607o(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                                    break;
                                case 5:
                                    abstractC12428qM10567e2.m10607o(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                    break;
                                case 6:
                                    abstractC12428qM10567e2.m10607o(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                                    break;
                                case 7:
                                    abstractC12428qM10567e2.m10607o(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                                    break;
                                case 8:
                                    abstractC12428qM10567e2.m10607o(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                                    break;
                            }
                            abstractC12428qM10567e2.mo10597e(Opcodes.ARETURN);
                            i3 = i4 + 1;
                            size = i6;
                            c12427pArr = c12427pArr;
                            clsArr3 = clsArr7;
                            clsArr2 = clsArr6;
                            strM883w = str2;
                            c12427p = c12427p;
                        }
                        clsArr = clsArr2;
                        str = strM883w;
                        abstractC12428qM10567e2.mo10601i(c12427p);
                        abstractC12428q = abstractC12428qM10567e2;
                        abstractC12428qM10567e2.mo10595c(3, 0, null, 0, null);
                    }
                    abstractC12428q.mo10611s(Opcodes.NEW, "java/lang/IllegalArgumentException");
                    abstractC12428q.mo10597e(89);
                    abstractC12428q.mo10611s(Opcodes.NEW, "java/lang/StringBuilder");
                    abstractC12428q.mo10597e(89);
                    abstractC12428q.mo10602j("Method not found: ");
                    abstractC12428q.m10607o(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
                    abstractC12428q.mo10612t(21, 2);
                    abstractC12428q.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
                    abstractC12428q.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
                    abstractC12428q.m10607o(Opcodes.INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
                    abstractC12428q.mo10597e(Opcodes.ATHROW);
                    abstractC12428q.mo10606n(0, 0);
                    strM883w = str;
                    clsM891a = c1645aM889b.m891a(strM883w, c12417f.m10564b());
                }
            }
        }
        try {
            AbstractC1648d abstractC1648d = (AbstractC1648d) clsM891a.newInstance();
            abstractC1648d.f3014a = strArr;
            abstractC1648d.f3015b = clsArr;
            return abstractC1648d;
        } catch (Throwable th) {
            throw new RuntimeException(C1643a.m883w("Error constructing method access class: ", strM883w), th);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m925e(Class cls, ArrayList<Method> arrayList) {
        m923a(cls, arrayList);
        for (Class<?> cls2 : cls.getInterfaces()) {
            m925e(cls2, arrayList);
        }
    }

    /* JADX INFO: renamed from: c */
    public int m926c(String str, Class... clsArr) {
        int length = this.f3014a.length;
        for (int i = 0; i < length; i++) {
            if (this.f3014a[i].equals(str) && Arrays.equals(clsArr, this.f3015b[i])) {
                return i;
            }
        }
        StringBuilder sbM837Y = C1643a.m837Y("Unable to find non-private method: ", str, " ");
        sbM837Y.append(Arrays.toString(clsArr));
        throw new IllegalArgumentException(sbM837Y.toString());
    }

    /* JADX INFO: renamed from: d */
    public abstract Object m927d(Object obj, int i, Object... objArr);
}
