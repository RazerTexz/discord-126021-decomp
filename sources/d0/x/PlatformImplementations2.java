package d0.x;

import d0.g0.Strings4;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.x.b, reason: use source file name */
/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PlatformImplementations2 {
    public static final PlatformImplementations a;

    /* JADX WARN: Code duplicated, block: B:39:0x0109 A[Catch: ClassCastException -> 0x010d, ClassNotFoundException -> 0x0143, TRY_ENTER, TryCatch #5 {ClassCastException -> 0x010d, blocks: (B:39:0x0109, B:42:0x010f, B:43:0x0114), top: B:66:0x0107, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x010f A[Catch: ClassCastException -> 0x010d, ClassNotFoundException -> 0x0143, TryCatch #5 {ClassCastException -> 0x010d, blocks: (B:39:0x0109, B:42:0x010f, B:43:0x0114), top: B:66:0x0107, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x018b  */
    /* JADX WARN: Code duplicated, block: B:62:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        PlatformImplementations platformImplementations;
        Object objNewInstance;
        String property = System.getProperty("java.specification.version");
        int i = 65542;
        if (property != null) {
            int iIndexOf$default = Strings4.indexOf$default((CharSequence) property, '.', 0, false, 6, (Object) null);
            try {
                if (iIndexOf$default < 0) {
                    i = Integer.parseInt(property) * 65536;
                } else {
                    int i2 = iIndexOf$default + 1;
                    int iIndexOf$default2 = Strings4.indexOf$default((CharSequence) property, '.', i2, false, 4, (Object) null);
                    if (iIndexOf$default2 < 0) {
                        iIndexOf$default2 = property.length();
                    }
                    String strSubstring = property.substring(0, iIndexOf$default);
                    Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    String strSubstring2 = property.substring(i2, iIndexOf$default2);
                    Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    i = (Integer.parseInt(strSubstring) * 65536) + Integer.parseInt(strSubstring2);
                }
            } catch (NumberFormatException unused) {
            }
        }
        if (i >= 65544) {
            try {
                Object objNewInstance2 = Class.forName("d0.x.e.a").newInstance();
                Intrinsics3.checkNotNullExpressionValue(objNewInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    try {
                        if (objNewInstance2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        platformImplementations = (PlatformImplementations) objNewInstance2;
                    } catch (ClassCastException e) {
                        Throwable thInitCause = new ClassCastException("Instance classloader: " + objNewInstance2.getClass().getClassLoader() + ", base type classloader: " + PlatformImplementations.class.getClassLoader()).initCause(e);
                        Intrinsics3.checkNotNullExpressionValue(thInitCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw thInitCause;
                    }
                } catch (ClassNotFoundException unused2) {
                    if (i >= 65543) {
                        try {
                            try {
                                objNewInstance = Class.forName("d0.x.d.a").newInstance();
                                Intrinsics3.checkNotNullExpressionValue(objNewInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                                try {
                                    if (objNewInstance != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                                    }
                                    platformImplementations = (PlatformImplementations) objNewInstance;
                                } catch (ClassCastException e2) {
                                    Throwable thInitCause2 = new ClassCastException("Instance classloader: " + objNewInstance.getClass().getClassLoader() + ", base type classloader: " + PlatformImplementations.class.getClassLoader()).initCause(e2);
                                    Intrinsics3.checkNotNullExpressionValue(thInitCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                                    throw thInitCause2;
                                }
                            } catch (ClassNotFoundException unused3) {
                                Object objNewInstance3 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                                Intrinsics3.checkNotNullExpressionValue(objNewInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                                try {
                                    if (objNewInstance3 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                                    }
                                    platformImplementations = (PlatformImplementations) objNewInstance3;
                                } catch (ClassCastException e3) {
                                    Throwable thInitCause3 = new ClassCastException("Instance classloader: " + objNewInstance3.getClass().getClassLoader() + ", base type classloader: " + PlatformImplementations.class.getClassLoader()).initCause(e3);
                                    Intrinsics3.checkNotNullExpressionValue(thInitCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                                    throw thInitCause3;
                                }
                            }
                        } catch (ClassNotFoundException unused4) {
                            platformImplementations = new PlatformImplementations();
                        }
                    } else {
                        platformImplementations = new PlatformImplementations();
                    }
                }
            } catch (ClassNotFoundException unused5) {
                Object objNewInstance4 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                Intrinsics3.checkNotNullExpressionValue(objNewInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    if (objNewInstance4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    platformImplementations = (PlatformImplementations) objNewInstance4;
                } catch (ClassCastException e4) {
                    Throwable thInitCause4 = new ClassCastException("Instance classloader: " + objNewInstance4.getClass().getClassLoader() + ", base type classloader: " + PlatformImplementations.class.getClassLoader()).initCause(e4);
                    Intrinsics3.checkNotNullExpressionValue(thInitCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw thInitCause4;
                }
            }
        } else if (i >= 65543) {
            objNewInstance = Class.forName("d0.x.d.a").newInstance();
            Intrinsics3.checkNotNullExpressionValue(objNewInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
            if (objNewInstance != null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            platformImplementations = (PlatformImplementations) objNewInstance;
        } else {
            platformImplementations = new PlatformImplementations();
        }
        a = platformImplementations;
    }
}
