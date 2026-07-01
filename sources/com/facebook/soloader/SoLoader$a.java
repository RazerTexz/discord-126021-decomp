package com.facebook.soloader;

import android.util.Log;
import b.d.b.a.a;
import b.f.m.k;
import com.adjust.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes3.dex */
public class SoLoader$a implements k {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2907b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Runtime d;
    public final /* synthetic */ Method e;

    public SoLoader$a(boolean z2, String str, String str2, Runtime runtime, Method method) {
        this.a = z2;
        this.f2907b = str;
        this.c = str2;
        this.d = runtime;
        this.e = method;
    }

    public final String a(String str) {
        try {
            File file = new File(str);
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i <= 0) {
                        String str2 = String.format("%32x", new BigInteger(1, messageDigest.digest()));
                        fileInputStream.close();
                        return str2;
                    }
                    messageDigest.update(bArr, 0, i);
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            return e.toString();
        } catch (SecurityException e2) {
            return e2.toString();
        } catch (NoSuchAlgorithmException e3) {
            return e3.toString();
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x006f */
    /* JADX WARN: Code duplicated, block: B:47:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(String str, int i) throws Throwable {
        String str2;
        if (!this.a) {
            System.load(str);
            return;
        }
        SoLoader$a soLoader$a = null;
        String str3 = (i & 4) == 4 ? this.f2907b : this.c;
        try {
            try {
                synchronized (this.d) {
                    try {
                        str2 = (String) this.e.invoke(this.d, str, SoLoader.class.getClassLoader(), str3);
                        try {
                            if (str2 != null) {
                                throw new UnsatisfiedLinkError(str2);
                            }
                        } catch (Throwable th) {
                            th = th;
                            while (true) {
                                try {
                                    break;
                                } catch (IllegalAccessException e) {
                                    e = e;
                                    throw new RuntimeException("Error: Cannot load " + str, e);
                                } catch (IllegalArgumentException e2) {
                                    e = e2;
                                    throw new RuntimeException("Error: Cannot load " + str, e);
                                } catch (InvocationTargetException e3) {
                                    e = e3;
                                    throw new RuntimeException("Error: Cannot load " + str, e);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (str2 != null) {
                    StringBuilder sbY = a.Y("Error when loading lib: ", str2, " lib hash: ");
                    sbY.append(a(str));
                    sbY.append(" search path is ");
                    sbY.append(str3);
                    Log.e("SoLoader", sbY.toString());
                }
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                    StringBuilder sbY2 = a.Y("Error when loading lib: ", null, " lib hash: ");
                    sbY2.append(soLoader$a.a(str));
                    sbY2.append(" search path is ");
                    sbY2.append(str3);
                    Log.e("SoLoader", sbY2.toString());
                }
                throw th;
            }
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new RuntimeException("Error: Cannot load " + str, e);
        } catch (IllegalArgumentException e5) {
            e = e5;
            throw new RuntimeException("Error: Cannot load " + str, e);
        } catch (InvocationTargetException e6) {
            e = e6;
            throw new RuntimeException("Error: Cannot load " + str, e);
        } catch (Throwable th4) {
            th = th4;
            soLoader$a = this;
            if (0 != 0) {
                StringBuilder sbY3 = a.Y("Error when loading lib: ", null, " lib hash: ");
                sbY3.append(soLoader$a.a(str));
                sbY3.append(" search path is ");
                sbY3.append(str3);
                Log.e("SoLoader", sbY3.toString());
            }
            throw th;
        }
    }
}
