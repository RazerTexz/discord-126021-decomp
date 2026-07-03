package p507d0.p592z.p594d;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import p507d0.InterfaceC11213c;
import p507d0.p592z.p593c.InterfaceC12211a;
import p507d0.p592z.p593c.InterfaceC12212b;
import p507d0.p592z.p593c.InterfaceC12213c;
import p507d0.p592z.p593c.InterfaceC12214d;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;
import p507d0.p592z.p594d.p595g0.InterfaceC12229b;
import p507d0.p592z.p594d.p595g0.InterfaceC12230c;
import p507d0.p592z.p594d.p595g0.InterfaceC12231d;
import p507d0.p592z.p594d.p595g0.InterfaceC12232e;

/* JADX INFO: renamed from: d0.z.d.e0 */
/* JADX INFO: compiled from: TypeIntrinsics.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12224e0 {
    public static Collection asMutableCollection(Object obj) {
        if ((obj instanceof InterfaceC12228a) && !(obj instanceof InterfaceC12229b)) {
            throwCce(obj, "kotlin.collections.MutableCollection");
        }
        return castToCollection(obj);
    }

    public static Iterable asMutableIterable(Object obj) {
        if ((obj instanceof InterfaceC12228a) && !(obj instanceof InterfaceC12229b)) {
            throwCce(obj, "kotlin.collections.MutableIterable");
        }
        return castToIterable(obj);
    }

    public static List asMutableList(Object obj) {
        if ((obj instanceof InterfaceC12228a) && !(obj instanceof InterfaceC12230c)) {
            throwCce(obj, "kotlin.collections.MutableList");
        }
        return castToList(obj);
    }

    public static Map asMutableMap(Object obj) {
        if ((obj instanceof InterfaceC12228a) && !(obj instanceof InterfaceC12231d)) {
            throwCce(obj, "kotlin.collections.MutableMap");
        }
        return castToMap(obj);
    }

    public static Set asMutableSet(Object obj) {
        if ((obj instanceof InterfaceC12228a) && !(obj instanceof InterfaceC12232e)) {
            throwCce(obj, "kotlin.collections.MutableSet");
        }
        return castToSet(obj);
    }

    public static Object beforeCheckcastToFunctionOfArity(Object obj, int i) {
        if (obj != null && !isFunctionOfArity(obj, i)) {
            throwCce(obj, "kotlin.jvm.functions.Function" + i);
        }
        return obj;
    }

    public static Collection castToCollection(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static Iterable castToIterable(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static List castToList(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static Map castToMap(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static Set castToSet(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e) {
            throw throwCce(e);
        }
    }

    public static int getFunctionArity(Object obj) {
        if (obj instanceof InterfaceC12234i) {
            return ((InterfaceC12234i) obj).getArity();
        }
        if (obj instanceof Function0) {
            return 0;
        }
        if (obj instanceof Function1) {
            return 1;
        }
        if (obj instanceof Function2) {
            return 2;
        }
        if (obj instanceof Function3) {
            return 3;
        }
        if (obj instanceof Function4) {
            return 4;
        }
        if (obj instanceof Function5) {
            return 5;
        }
        if (obj instanceof Function6) {
            return 6;
        }
        if (obj instanceof Function7) {
            return 7;
        }
        if (obj instanceof Function8) {
            return 8;
        }
        if (obj instanceof Function9) {
            return 9;
        }
        if (obj instanceof Function10) {
            return 10;
        }
        if (obj instanceof Function11) {
            return 11;
        }
        if (obj instanceof Function12) {
            return 12;
        }
        if (obj instanceof Function13) {
            return 13;
        }
        if (obj instanceof Function14) {
            return 14;
        }
        if (obj instanceof Function15) {
            return 15;
        }
        if (obj instanceof Function16) {
            return 16;
        }
        if (obj instanceof Function17) {
            return 17;
        }
        if (obj instanceof InterfaceC12211a) {
            return 18;
        }
        if (obj instanceof InterfaceC12212b) {
            return 19;
        }
        if (obj instanceof InterfaceC12213c) {
            return 20;
        }
        if (obj instanceof InterfaceC12214d) {
            return 21;
        }
        return obj instanceof Function22 ? 22 : -1;
    }

    public static boolean isFunctionOfArity(Object obj, int i) {
        return (obj instanceof InterfaceC11213c) && getFunctionArity(obj) == i;
    }

    public static boolean isMutableList(Object obj) {
        return (obj instanceof List) && (!(obj instanceof InterfaceC12228a) || (obj instanceof InterfaceC12230c));
    }

    public static boolean isMutableMap(Object obj) {
        return (obj instanceof Map) && (!(obj instanceof InterfaceC12228a) || (obj instanceof InterfaceC12231d));
    }

    public static ClassCastException throwCce(ClassCastException classCastException) {
        C12238m.m10093b(classCastException, C12224e0.class.getName());
        throw classCastException;
    }

    public static void throwCce(Object obj, String str) {
        throwCce((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void throwCce(String str) {
        throw throwCce(new ClassCastException(str));
    }
}
