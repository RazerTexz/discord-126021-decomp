package d0.x;

import d0.g0.w;
import d0.z.d.m;

/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final a a;

    /* JADX WARN: Code duplicated, block: B:39:0x0109 A[Catch: ClassCastException -> 0x010d, ClassNotFoundException -> 0x0143, TRY_ENTER, TryCatch #5 {ClassCastException -> 0x010d, blocks: (B:39:0x0109, B:42:0x010f, B:43:0x0114), top: B:66:0x0107, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x010f A[Catch: ClassCastException -> 0x010d, ClassNotFoundException -> 0x0143, TryCatch #5 {ClassCastException -> 0x010d, blocks: (B:39:0x0109, B:42:0x010f, B:43:0x0114), top: B:66:0x0107, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x018b  */
    /* JADX WARN: Code duplicated, block: B:62:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        a aVar;
        Object objNewInstance;
        String property = System.getProperty("java.specification.version");
        int i = 65542;
        if (property != null) {
            int iIndexOf$default = w.indexOf$default((CharSequence) property, '.', 0, false, 6, (Object) null);
            try {
                if (iIndexOf$default < 0) {
                    i = Integer.parseInt(property) * 65536;
                } else {
                    int i2 = iIndexOf$default + 1;
                    int iIndexOf$default2 = w.indexOf$default((CharSequence) property, '.', i2, false, 4, (Object) null);
                    if (iIndexOf$default2 < 0) {
                        iIndexOf$default2 = property.length();
                    }
                    String strSubstring = property.substring(0, iIndexOf$default);
                    m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    String strSubstring2 = property.substring(i2, iIndexOf$default2);
                    m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    i = (Integer.parseInt(strSubstring) * 65536) + Integer.parseInt(strSubstring2);
                }
            } catch (NumberFormatException unused) {
            }
        }
        if (i >= 65544) {
            try {
                Object objNewInstance2 = Class.forName("d0.x.e.a").newInstance();
                m.checkNotNullExpressionValue(objNewInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    try {
                        if (objNewInstance2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        aVar = (a) objNewInstance2;
                    } catch (ClassCastException e) {
                        Throwable thInitCause = new ClassCastException("Instance classloader: " + objNewInstance2.getClass().getClassLoader() + ", base type classloader: " + a.class.getClassLoader()).initCause(e);
                        m.checkNotNullExpressionValue(thInitCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw thInitCause;
                    }
                } catch (ClassNotFoundException unused2) {
                    if (i >= 65543) {
                        try {
                            try {
                                objNewInstance = Class.forName("d0.x.d.a").newInstance();
                                m.checkNotNullExpressionValue(objNewInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                                try {
                                    if (objNewInstance != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                                    }
                                    aVar = (a) objNewInstance;
                                } catch (ClassCastException e2) {
                                    Throwable thInitCause2 = new ClassCastException("Instance classloader: " + objNewInstance.getClass().getClassLoader() + ", base type classloader: " + a.class.getClassLoader()).initCause(e2);
                                    m.checkNotNullExpressionValue(thInitCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                                    throw thInitCause2;
                                }
                            } catch (ClassNotFoundException unused3) {
                                Object objNewInstance3 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                                m.checkNotNullExpressionValue(objNewInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                                try {
                                    if (objNewInstance3 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                                    }
                                    aVar = (a) objNewInstance3;
                                } catch (ClassCastException e3) {
                                    Throwable thInitCause3 = new ClassCastException("Instance classloader: " + objNewInstance3.getClass().getClassLoader() + ", base type classloader: " + a.class.getClassLoader()).initCause(e3);
                                    m.checkNotNullExpressionValue(thInitCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                                    throw thInitCause3;
                                }
                            }
                        } catch (ClassNotFoundException unused4) {
                            aVar = new a();
                        }
                    } else {
                        aVar = new a();
                    }
                }
            } catch (ClassNotFoundException unused5) {
                Object objNewInstance4 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                m.checkNotNullExpressionValue(objNewInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    if (objNewInstance4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) objNewInstance4;
                } catch (ClassCastException e4) {
                    Throwable thInitCause4 = new ClassCastException("Instance classloader: " + objNewInstance4.getClass().getClassLoader() + ", base type classloader: " + a.class.getClassLoader()).initCause(e4);
                    m.checkNotNullExpressionValue(thInitCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw thInitCause4;
                }
            }
        } else if (i >= 65543) {
            objNewInstance = Class.forName("d0.x.d.a").newInstance();
            m.checkNotNullExpressionValue(objNewInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
            if (objNewInstance != null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            aVar = (a) objNewInstance;
        } else {
            aVar = new a();
        }
        a = aVar;
    }
}
