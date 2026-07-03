package p007b.p195g.p196a.p205c.p218h0;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.InterfaceC2363m;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;

/* JADX INFO: renamed from: b.g.a.c.h0.l */
/* JADX INFO: compiled from: TypeBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2333l extends AbstractC2360j implements InterfaceC2363m {

    /* JADX INFO: renamed from: j */
    public static final C2334m f4905j = C2334m.f4908l;
    private static final long serialVersionUID = 1;
    public final C2334m _bindings;
    public final AbstractC2360j _superClass;
    public final AbstractC2360j[] _superInterfaces;

    public AbstractC2333l(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr, int i, Object obj, Object obj2, boolean z2) {
        super(cls, i, obj, obj2, z2);
        this._bindings = c2334m == null ? f4905j : c2334m;
        this._superClass = abstractC2360j;
        this._superInterfaces = abstractC2360jArr;
    }

    /* JADX INFO: renamed from: J */
    public static StringBuilder m2139J(Class<?> cls, StringBuilder sb, boolean z2) {
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
                StringBuilder sbM833U = C1643a.m833U("Unrecognized primitive type: ");
                sbM833U.append(cls.getName());
                throw new IllegalStateException(sbM833U.toString());
            }
            sb.append('V');
        }
        return sb;
    }

    /* JADX INFO: renamed from: K */
    public String mo2106K() {
        return this._class.getName();
    }

    @Override // p007b.p195g.p196a.p205c.InterfaceC2363m
    /* JADX INFO: renamed from: c */
    public void mo2140c(AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        abstractC2108d.mo1658j0(mo2106K());
    }

    @Override // p007b.p195g.p196a.p205c.InterfaceC2363m
    /* JADX INFO: renamed from: d */
    public void mo2141d(AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        C2138b c2138b = new C2138b(this, EnumC2112h.VALUE_STRING);
        abstractC2215g.mo1959e(abstractC2108d, c2138b);
        abstractC2108d.mo1658j0(mo2106K());
        abstractC2215g.mo1960f(abstractC2108d, c2138b);
    }

    @Override // p007b.p195g.p196a.p198b.p203s.AbstractC2137a
    /* JADX INFO: renamed from: e */
    public String mo1729e() {
        return mo2106K();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: f */
    public AbstractC2360j mo2142f(int i) {
        return this._bindings.m2151f(i);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: g */
    public int mo2143g() {
        return this._bindings.m2155j();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: i */
    public final AbstractC2360j mo2144i(Class<?> cls) {
        AbstractC2360j abstractC2360jMo2144i;
        AbstractC2360j[] abstractC2360jArr;
        if (cls == this._class) {
            return this;
        }
        if (cls.isInterface() && (abstractC2360jArr = this._superInterfaces) != null) {
            int length = abstractC2360jArr.length;
            for (int i = 0; i < length; i++) {
                AbstractC2360j abstractC2360jMo2144i2 = this._superInterfaces[i].mo2144i(cls);
                if (abstractC2360jMo2144i2 != null) {
                    return abstractC2360jMo2144i2;
                }
            }
        }
        AbstractC2360j abstractC2360j = this._superClass;
        if (abstractC2360j == null || (abstractC2360jMo2144i = abstractC2360j.mo2144i(cls)) == null) {
            return null;
        }
        return abstractC2360jMo2144i;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: j */
    public C2334m mo2136j() {
        return this._bindings;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: n */
    public List<AbstractC2360j> mo2145n() {
        AbstractC2360j[] abstractC2360jArr = this._superInterfaces;
        if (abstractC2360jArr == null) {
            return Collections.emptyList();
        }
        int length = abstractC2360jArr.length;
        if (length != 0) {
            return length != 1 ? Arrays.asList(abstractC2360jArr) : Collections.singletonList(abstractC2360jArr[0]);
        }
        return Collections.emptyList();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2360j
    /* JADX INFO: renamed from: q */
    public AbstractC2360j mo2137q() {
        return this._superClass;
    }
}
