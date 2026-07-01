package b.g.a.c.h0;

import b.g.a.c.x;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: TypeBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends b.g.a.c.j implements b.g.a.c.m {
    public static final m j = m.l;
    private static final long serialVersionUID = 1;
    public final m _bindings;
    public final b.g.a.c.j _superClass;
    public final b.g.a.c.j[] _superInterfaces;

    public l(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr, int i, Object obj, Object obj2, boolean z2) {
        super(cls, i, obj, obj2, z2);
        this._bindings = mVar == null ? j : mVar;
        this._superClass = jVar;
        this._superInterfaces = jVarArr;
    }

    public static StringBuilder J(Class<?> cls, StringBuilder sb, boolean z2) {
        if (!cls.isPrimitive()) {
            sb.append('L');
            String name = cls.getName();
            int length = name.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = name.charAt(i);
                if (cCharAt == '.') {
                    cCharAt = MentionUtilsKt.SLASH_CHAR;
                }
                sb.append(cCharAt);
            }
            if (z2) {
                sb.append(';');
            }
        } else if (cls == Boolean.TYPE) {
            sb.append('Z');
        } else if (cls == Byte.TYPE) {
            sb.append('B');
        } else if (cls == Short.TYPE) {
            sb.append('S');
        } else if (cls == Character.TYPE) {
            sb.append('C');
        } else if (cls == Integer.TYPE) {
            sb.append('I');
        } else if (cls == Long.TYPE) {
            sb.append('J');
        } else if (cls == Float.TYPE) {
            sb.append('F');
        } else if (cls == Double.TYPE) {
            sb.append('D');
        } else {
            if (cls != Void.TYPE) {
                StringBuilder sbU = b.d.b.a.a.U("Unrecognized primitive type: ");
                sbU.append(cls.getName());
                throw new IllegalStateException(sbU.toString());
            }
            sb.append('V');
        }
        return sb;
    }

    public String K() {
        return this._class.getName();
    }

    @Override // b.g.a.c.m
    public void c(b.g.a.b.d dVar, x xVar) throws IOException {
        dVar.j0(K());
    }

    @Override // b.g.a.c.m
    public void d(b.g.a.b.d dVar, x xVar, b.g.a.c.e0.g gVar) throws IOException {
        b.g.a.b.s.b bVar = new b.g.a.b.s.b(this, b.g.a.b.h.VALUE_STRING);
        gVar.e(dVar, bVar);
        dVar.j0(K());
        gVar.f(dVar, bVar);
    }

    @Override // b.g.a.b.s.a
    public String e() {
        return K();
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j f(int i) {
        return this._bindings.f(i);
    }

    @Override // b.g.a.c.j
    public int g() {
        return this._bindings.j();
    }

    @Override // b.g.a.c.j
    public final b.g.a.c.j i(Class<?> cls) {
        b.g.a.c.j jVarI;
        b.g.a.c.j[] jVarArr;
        if (cls == this._class) {
            return this;
        }
        if (cls.isInterface() && (jVarArr = this._superInterfaces) != null) {
            int length = jVarArr.length;
            for (int i = 0; i < length; i++) {
                b.g.a.c.j jVarI2 = this._superInterfaces[i].i(cls);
                if (jVarI2 != null) {
                    return jVarI2;
                }
            }
        }
        b.g.a.c.j jVar = this._superClass;
        if (jVar == null || (jVarI = jVar.i(cls)) == null) {
            return null;
        }
        return jVarI;
    }

    @Override // b.g.a.c.j
    public m j() {
        return this._bindings;
    }

    @Override // b.g.a.c.j
    public List<b.g.a.c.j> n() {
        b.g.a.c.j[] jVarArr = this._superInterfaces;
        if (jVarArr == null) {
            return Collections.emptyList();
        }
        int length = jVarArr.length;
        if (length != 0) {
            return length != 1 ? Arrays.asList(jVarArr) : Collections.singletonList(jVarArr[0]);
        }
        return Collections.emptyList();
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j q() {
        return this._superClass;
    }
}
