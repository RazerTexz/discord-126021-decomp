package p007b.p106e.p108b;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p617h0.p618a.p619a.AbstractC12428q;
import p617h0.p618a.p619a.C12417f;
import p617h0.p618a.p619a.C12427p;
import p617h0.p618a.p619a.C12434w;

/* JADX INFO: renamed from: b.e.b.c */
/* JADX INFO: compiled from: FieldAccess.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1647c {

    /* JADX INFO: renamed from: a */
    public String[] f3013a;

    /* JADX INFO: renamed from: a */
    public static AbstractC1647c m895a(Class cls) {
        Class<?> clsM891a;
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
        String strM883w = C1643a.m883w(name, "FieldAccess");
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
                    C12417f c12417f = new C12417f(0);
                    c12417f.m10565c(Opcodes.V1_1, 33, strReplace, null, "com/esotericsoftware/reflectasm/FieldAccess", null);
                    AbstractC12428q abstractC12428qM10567e = c12417f.m10567e(1, "<init>", "()V", null, null);
                    abstractC12428qM10567e.mo10612t(25, 0);
                    abstractC12428qM10567e.m10607o(Opcodes.INVOKESPECIAL, "com/esotericsoftware/reflectasm/FieldAccess", "<init>", "()V");
                    abstractC12428qM10567e.mo10597e(Opcodes.RETURN);
                    abstractC12428qM10567e.mo10606n(1, 1);
                    m896m(c12417f, strReplace2, arrayList);
                    m899p(c12417f, strReplace2, arrayList);
                    m897n(c12417f, strReplace2, arrayList, C12434w.f26362b);
                    m900q(c12417f, strReplace2, arrayList, C12434w.f26362b);
                    m897n(c12417f, strReplace2, arrayList, C12434w.f26364d);
                    m900q(c12417f, strReplace2, arrayList, C12434w.f26364d);
                    m897n(c12417f, strReplace2, arrayList, C12434w.f26365e);
                    m900q(c12417f, strReplace2, arrayList, C12434w.f26365e);
                    m897n(c12417f, strReplace2, arrayList, C12434w.f26366f);
                    m900q(c12417f, strReplace2, arrayList, C12434w.f26366f);
                    m897n(c12417f, strReplace2, arrayList, C12434w.f26368h);
                    m900q(c12417f, strReplace2, arrayList, C12434w.f26368h);
                    m897n(c12417f, strReplace2, arrayList, C12434w.f26369i);
                    m900q(c12417f, strReplace2, arrayList, C12434w.f26369i);
                    m897n(c12417f, strReplace2, arrayList, C12434w.f26367g);
                    m900q(c12417f, strReplace2, arrayList, C12434w.f26367g);
                    m897n(c12417f, strReplace2, arrayList, C12434w.f26363c);
                    m900q(c12417f, strReplace2, arrayList, C12434w.f26363c);
                    m898o(c12417f, strReplace2, arrayList);
                    clsM891a = c1645aM889b.m891a(strM883w, c12417f.m10564b());
                }
            }
        }
        try {
            AbstractC1647c abstractC1647c = (AbstractC1647c) clsM891a.newInstance();
            abstractC1647c.f3013a = strArr;
            return abstractC1647c;
        } catch (Throwable th) {
            throw new RuntimeException(C1643a.m883w("Error constructing field access class: ", strM883w), th);
        }
    }

    /* JADX INFO: renamed from: m */
    public static void m896m(C12417f c12417f, String str, ArrayList<Field> arrayList) {
        int i;
        AbstractC12428q abstractC12428qM10567e = c12417f.m10567e(1, "get", "(Ljava/lang/Object;I)Ljava/lang/Object;", null, null);
        abstractC12428qM10567e.mo10612t(21, 2);
        if (arrayList.isEmpty()) {
            i = 6;
        } else {
            i = 5;
            int size = arrayList.size();
            C12427p[] c12427pArr = new C12427p[size];
            for (int i2 = 0; i2 < size; i2++) {
                c12427pArr[i2] = new C12427p();
            }
            C12427p c12427p = new C12427p();
            abstractC12428qM10567e.mo10609q(0, size - 1, c12427p, c12427pArr);
            for (int i3 = 0; i3 < size; i3++) {
                Field field = arrayList.get(i3);
                abstractC12428qM10567e.mo10601i(c12427pArr[i3]);
                abstractC12428qM10567e.mo10595c(3, 0, null, 0, null);
                abstractC12428qM10567e.mo10612t(25, 1);
                abstractC12428qM10567e.mo10611s(Opcodes.CHECKCAST, str);
                abstractC12428qM10567e.mo10594b(180, str, field.getName(), C12434w.m10646e(field.getType()));
                switch (C12434w.m10648j(field.getType()).m10654i()) {
                    case 1:
                        abstractC12428qM10567e.m10607o(Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
                        break;
                    case 2:
                        abstractC12428qM10567e.m10607o(Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
                        break;
                    case 3:
                        abstractC12428qM10567e.m10607o(Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                        break;
                    case 4:
                        abstractC12428qM10567e.m10607o(Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                        break;
                    case 5:
                        abstractC12428qM10567e.m10607o(Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                        break;
                    case 6:
                        abstractC12428qM10567e.m10607o(Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                        break;
                    case 7:
                        abstractC12428qM10567e.m10607o(Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                        break;
                    case 8:
                        abstractC12428qM10567e.m10607o(Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                        break;
                }
                abstractC12428qM10567e.mo10597e(Opcodes.ARETURN);
            }
            abstractC12428qM10567e.mo10601i(c12427p);
            abstractC12428qM10567e.mo10595c(3, 0, null, 0, null);
        }
        m901r(abstractC12428qM10567e);
        abstractC12428qM10567e.mo10606n(i, 3);
    }

    /* JADX INFO: renamed from: n */
    public static void m897n(C12417f c12417f, String str, ArrayList<Field> arrayList, C12434w c12434w) {
        String str2;
        int i;
        String strM10651d = c12434w.m10651d();
        int iM10654i = c12434w.m10654i();
        int i2 = Opcodes.IRETURN;
        switch (iM10654i) {
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
                i2 = Opcodes.FRETURN;
                str2 = "getFloat";
                break;
            case 7:
                i2 = Opcodes.LRETURN;
                str2 = "getLong";
                break;
            case 8:
                i2 = 175;
                str2 = "getDouble";
                break;
            default:
                i2 = Opcodes.ARETURN;
                str2 = "get";
                break;
        }
        AbstractC12428q abstractC12428qM10567e = c12417f.m10567e(1, str2, C1643a.m883w("(Ljava/lang/Object;I)", strM10651d), null, null);
        abstractC12428qM10567e.mo10612t(21, 2);
        if (arrayList.isEmpty()) {
            i = 6;
        } else {
            int size = arrayList.size();
            C12427p[] c12427pArr = new C12427p[size];
            C12427p c12427p = new C12427p();
            boolean z2 = false;
            for (int i3 = 0; i3 < size; i3++) {
                if (C12434w.m10648j(arrayList.get(i3).getType()).equals(c12434w)) {
                    c12427pArr[i3] = new C12427p();
                } else {
                    c12427pArr[i3] = c12427p;
                    z2 = true;
                }
            }
            C12427p c12427p2 = new C12427p();
            abstractC12428qM10567e.mo10609q(0, size - 1, c12427p2, c12427pArr);
            for (int i4 = 0; i4 < size; i4++) {
                Field field = arrayList.get(i4);
                if (!c12427pArr[i4].equals(c12427p)) {
                    abstractC12428qM10567e.mo10601i(c12427pArr[i4]);
                    abstractC12428qM10567e.mo10595c(3, 0, null, 0, null);
                    abstractC12428qM10567e.mo10612t(25, 1);
                    abstractC12428qM10567e.mo10611s(Opcodes.CHECKCAST, str);
                    abstractC12428qM10567e.mo10594b(180, str, field.getName(), strM10651d);
                    abstractC12428qM10567e.mo10597e(i2);
                }
            }
            if (z2) {
                abstractC12428qM10567e.mo10601i(c12427p);
                abstractC12428qM10567e.mo10595c(3, 0, null, 0, null);
                m902s(abstractC12428qM10567e, c12434w.m10650c());
            }
            abstractC12428qM10567e.mo10601i(c12427p2);
            abstractC12428qM10567e.mo10595c(3, 0, null, 0, null);
            i = 5;
        }
        m901r(abstractC12428qM10567e);
        abstractC12428qM10567e.mo10606n(i, 3);
    }

    /* JADX INFO: renamed from: o */
    public static void m898o(C12417f c12417f, String str, ArrayList<Field> arrayList) {
        int i;
        AbstractC12428q abstractC12428qM10567e = c12417f.m10567e(1, "getString", "(Ljava/lang/Object;I)Ljava/lang/String;", null, null);
        abstractC12428qM10567e.mo10612t(21, 2);
        if (arrayList.isEmpty()) {
            i = 6;
        } else {
            int size = arrayList.size();
            C12427p[] c12427pArr = new C12427p[size];
            C12427p c12427p = new C12427p();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                if (arrayList.get(i2).getType().equals(String.class)) {
                    c12427pArr[i2] = new C12427p();
                } else {
                    c12427pArr[i2] = c12427p;
                    z2 = true;
                }
            }
            C12427p c12427p2 = new C12427p();
            abstractC12428qM10567e.mo10609q(0, size - 1, c12427p2, c12427pArr);
            for (int i3 = 0; i3 < size; i3++) {
                if (!c12427pArr[i3].equals(c12427p)) {
                    abstractC12428qM10567e.mo10601i(c12427pArr[i3]);
                    abstractC12428qM10567e.mo10595c(3, 0, null, 0, null);
                    abstractC12428qM10567e.mo10612t(25, 1);
                    abstractC12428qM10567e.mo10611s(Opcodes.CHECKCAST, str);
                    abstractC12428qM10567e.mo10594b(180, str, arrayList.get(i3).getName(), "Ljava/lang/String;");
                    abstractC12428qM10567e.mo10597e(Opcodes.ARETURN);
                }
            }
            if (z2) {
                abstractC12428qM10567e.mo10601i(c12427p);
                abstractC12428qM10567e.mo10595c(3, 0, null, 0, null);
                m902s(abstractC12428qM10567e, "String");
            }
            abstractC12428qM10567e.mo10601i(c12427p2);
            abstractC12428qM10567e.mo10595c(3, 0, null, 0, null);
            i = 5;
        }
        m901r(abstractC12428qM10567e);
        abstractC12428qM10567e.mo10606n(i, 3);
    }

    /* JADX INFO: renamed from: p */
    public static void m899p(C12417f c12417f, String str, ArrayList<Field> arrayList) {
        int i;
        AbstractC12428q abstractC12428qM10567e = c12417f.m10567e(1, "set", "(Ljava/lang/Object;ILjava/lang/Object;)V", null, null);
        abstractC12428qM10567e.mo10612t(21, 2);
        if (arrayList.isEmpty()) {
            i = 6;
        } else {
            i = 5;
            int size = arrayList.size();
            C12427p[] c12427pArr = new C12427p[size];
            for (int i2 = 0; i2 < size; i2++) {
                c12427pArr[i2] = new C12427p();
            }
            C12427p c12427p = new C12427p();
            abstractC12428qM10567e.mo10609q(0, size - 1, c12427p, c12427pArr);
            for (int i3 = 0; i3 < size; i3++) {
                Field field = arrayList.get(i3);
                C12434w c12434wM10648j = C12434w.m10648j(field.getType());
                abstractC12428qM10567e.mo10601i(c12427pArr[i3]);
                abstractC12428qM10567e.mo10595c(3, 0, null, 0, null);
                abstractC12428qM10567e.mo10612t(25, 1);
                abstractC12428qM10567e.mo10611s(Opcodes.CHECKCAST, str);
                abstractC12428qM10567e.mo10612t(25, 3);
                switch (c12434wM10648j.m10654i()) {
                    case 1:
                        abstractC12428qM10567e.mo10611s(Opcodes.CHECKCAST, "java/lang/Boolean");
                        abstractC12428qM10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z");
                        break;
                    case 2:
                        abstractC12428qM10567e.mo10611s(Opcodes.CHECKCAST, "java/lang/Character");
                        abstractC12428qM10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Character", "charValue", "()C");
                        break;
                    case 3:
                        abstractC12428qM10567e.mo10611s(Opcodes.CHECKCAST, "java/lang/Byte");
                        abstractC12428qM10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Byte", "byteValue", "()B");
                        break;
                    case 4:
                        abstractC12428qM10567e.mo10611s(Opcodes.CHECKCAST, "java/lang/Short");
                        abstractC12428qM10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Short", "shortValue", "()S");
                        break;
                    case 5:
                        abstractC12428qM10567e.mo10611s(Opcodes.CHECKCAST, "java/lang/Integer");
                        abstractC12428qM10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I");
                        break;
                    case 6:
                        abstractC12428qM10567e.mo10611s(Opcodes.CHECKCAST, "java/lang/Float");
                        abstractC12428qM10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Float", "floatValue", "()F");
                        break;
                    case 7:
                        abstractC12428qM10567e.mo10611s(Opcodes.CHECKCAST, "java/lang/Long");
                        abstractC12428qM10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Long", "longValue", "()J");
                        break;
                    case 8:
                        abstractC12428qM10567e.mo10611s(Opcodes.CHECKCAST, "java/lang/Double");
                        abstractC12428qM10567e.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/Double", "doubleValue", "()D");
                        break;
                    case 9:
                        abstractC12428qM10567e.mo10611s(Opcodes.CHECKCAST, c12434wM10648j.m10651d());
                        break;
                    case 10:
                        abstractC12428qM10567e.mo10611s(Opcodes.CHECKCAST, c12434wM10648j.m10653g());
                        break;
                }
                abstractC12428qM10567e.mo10594b(Opcodes.PUTFIELD, str, field.getName(), c12434wM10648j.m10651d());
                abstractC12428qM10567e.mo10597e(Opcodes.RETURN);
            }
            abstractC12428qM10567e.mo10601i(c12427p);
            abstractC12428qM10567e.mo10595c(3, 0, null, 0, null);
        }
        m901r(abstractC12428qM10567e);
        abstractC12428qM10567e.mo10606n(i, 4);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    /* JADX INFO: renamed from: q */
    public static void m900q(C12417f c12417f, String str, ArrayList<Field> arrayList, C12434w c12434w) {
        String str2;
        String str3;
        int i;
        String str4;
        String str5;
        int i2;
        int i3;
        String strM10651d = c12434w.m10651d();
        switch (c12434w.m10654i()) {
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
        AbstractC12428q abstractC12428qM10567e = c12417f.m10567e(1, str5, C1643a.m886y("(Ljava/lang/Object;I", strM10651d, ")V"), null, null);
        abstractC12428qM10567e.mo10612t(21, 2);
        if (arrayList.isEmpty()) {
            i3 = 6;
        } else {
            int size = arrayList.size();
            C12427p[] c12427pArr = new C12427p[size];
            C12427p c12427p = new C12427p();
            boolean z2 = false;
            for (int i4 = 0; i4 < size; i4++) {
                if (C12434w.m10648j(arrayList.get(i4).getType()).equals(c12434w)) {
                    c12427pArr[i4] = new C12427p();
                } else {
                    c12427pArr[i4] = c12427p;
                    z2 = true;
                }
            }
            C12427p c12427p2 = new C12427p();
            abstractC12428qM10567e.mo10609q(0, size - 1, c12427p2, c12427pArr);
            for (int i5 = 0; i5 < size; i5++) {
                if (!c12427pArr[i5].equals(c12427p)) {
                    abstractC12428qM10567e.mo10601i(c12427pArr[i5]);
                    abstractC12428qM10567e.mo10595c(3, 0, null, 0, null);
                    abstractC12428qM10567e.mo10612t(25, 1);
                    abstractC12428qM10567e.mo10611s(Opcodes.CHECKCAST, str);
                    abstractC12428qM10567e.mo10612t(i, 3);
                    abstractC12428qM10567e.mo10594b(Opcodes.PUTFIELD, str, arrayList.get(i5).getName(), strM10651d);
                    abstractC12428qM10567e.mo10597e(Opcodes.RETURN);
                }
            }
            if (z2) {
                abstractC12428qM10567e.mo10601i(c12427p);
                abstractC12428qM10567e.mo10595c(3, 0, null, 0, null);
                m902s(abstractC12428qM10567e, c12434w.m10650c());
            }
            abstractC12428qM10567e.mo10601i(c12427p2);
            abstractC12428qM10567e.mo10595c(3, 0, null, 0, null);
            i3 = 5;
        }
        m901r(abstractC12428qM10567e);
        abstractC12428qM10567e.mo10606n(i3, i2);
    }

    /* JADX INFO: renamed from: r */
    public static AbstractC12428q m901r(AbstractC12428q abstractC12428q) {
        abstractC12428q.mo10611s(Opcodes.NEW, "java/lang/IllegalArgumentException");
        abstractC12428q.mo10597e(89);
        abstractC12428q.mo10611s(Opcodes.NEW, "java/lang/StringBuilder");
        abstractC12428q.mo10597e(89);
        abstractC12428q.mo10602j("Field not found: ");
        abstractC12428q.m10607o(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
        abstractC12428q.mo10612t(21, 2);
        abstractC12428q.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
        abstractC12428q.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
        abstractC12428q.m10607o(Opcodes.INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
        abstractC12428q.mo10597e(Opcodes.ATHROW);
        return abstractC12428q;
    }

    /* JADX INFO: renamed from: s */
    public static AbstractC12428q m902s(AbstractC12428q abstractC12428q, String str) {
        abstractC12428q.mo10611s(Opcodes.NEW, "java/lang/IllegalArgumentException");
        abstractC12428q.mo10597e(89);
        abstractC12428q.mo10611s(Opcodes.NEW, "java/lang/StringBuilder");
        abstractC12428q.mo10597e(89);
        abstractC12428q.mo10602j("Field not declared as " + str + ": ");
        abstractC12428q.m10607o(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
        abstractC12428q.mo10612t(21, 2);
        abstractC12428q.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
        abstractC12428q.m10607o(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
        abstractC12428q.m10607o(Opcodes.INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
        abstractC12428q.mo10597e(Opcodes.ATHROW);
        return abstractC12428q;
    }

    /* JADX INFO: renamed from: A */
    public abstract void m903A(Object obj, int i, long j);

    /* JADX INFO: renamed from: B */
    public abstract void m904B(Object obj, int i, short s2);

    /* JADX INFO: renamed from: b */
    public abstract Object m905b(Object obj, int i);

    /* JADX INFO: renamed from: c */
    public abstract boolean m906c(Object obj, int i);

    /* JADX INFO: renamed from: d */
    public abstract byte m907d(Object obj, int i);

    /* JADX INFO: renamed from: e */
    public abstract char m908e(Object obj, int i);

    /* JADX INFO: renamed from: f */
    public abstract double m909f(Object obj, int i);

    /* JADX INFO: renamed from: g */
    public abstract float m910g(Object obj, int i);

    /* JADX INFO: renamed from: h */
    public int m911h(String str) {
        int length = this.f3013a.length;
        for (int i = 0; i < length; i++) {
            if (this.f3013a[i].equals(str)) {
                return i;
            }
        }
        throw new IllegalArgumentException(C1643a.m883w("Unable to find non-private field: ", str));
    }

    /* JADX INFO: renamed from: i */
    public abstract int m912i(Object obj, int i);

    /* JADX INFO: renamed from: j */
    public abstract long m913j(Object obj, int i);

    /* JADX INFO: renamed from: k */
    public abstract short m914k(Object obj, int i);

    /* JADX INFO: renamed from: l */
    public abstract String m915l(Object obj, int i);

    /* JADX INFO: renamed from: t */
    public abstract void m916t(Object obj, int i, Object obj2);

    /* JADX INFO: renamed from: u */
    public abstract void m917u(Object obj, int i, boolean z2);

    /* JADX INFO: renamed from: v */
    public abstract void m918v(Object obj, int i, byte b2);

    /* JADX INFO: renamed from: w */
    public abstract void m919w(Object obj, int i, char c);

    /* JADX INFO: renamed from: x */
    public abstract void m920x(Object obj, int i, double d);

    /* JADX INFO: renamed from: y */
    public abstract void m921y(Object obj, int i, float f);

    /* JADX INFO: renamed from: z */
    public abstract void m922z(Object obj, int i, int i2);
}
