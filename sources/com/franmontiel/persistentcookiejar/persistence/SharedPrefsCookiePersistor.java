package com.franmontiel.persistentcookiejar.persistence;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.adjust.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p600f0.C12370n;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"CommitPrefEdits"})
public class SharedPrefsCookiePersistor implements CookiePersistor {

    /* JADX INFO: renamed from: a */
    public final SharedPreferences f19672a;

    public SharedPrefsCookiePersistor(Context context) {
        this.f19672a = context.getSharedPreferences("CookiePersistence", 0);
    }

    /* JADX INFO: renamed from: b */
    public static String m8748b(C12370n c12370n) {
        StringBuilder sb = new StringBuilder();
        sb.append(c12370n.f25952k ? Constants.SCHEME : "http");
        sb.append("://");
        sb.append(c12370n.f25950i);
        sb.append(c12370n.f25951j);
        sb.append("|");
        sb.append(c12370n.f25947f);
        return sb.toString();
    }

    @Override // com.franmontiel.persistentcookiejar.persistence.CookiePersistor
    /* JADX INFO: renamed from: a */
    public void mo8747a(Collection<C12370n> collection) throws Throwable {
        ObjectOutputStream objectOutputStream;
        SharedPreferences.Editor editorEdit = this.f19672a.edit();
        for (C12370n c12370n : collection) {
            String strM8748b = m8748b(c12370n);
            SerializableCookie serializableCookie = new SerializableCookie();
            serializableCookie.f19671k = c12370n;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream2 = null;
            string = null;
            string = null;
            String string = null;
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    try {
                        objectOutputStream.writeObject(serializableCookie);
                        try {
                            objectOutputStream.close();
                        } catch (IOException e) {
                            Log.d(SerializableCookie.f19670j, "Stream not closed in encodeCookie", e);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        StringBuilder sb = new StringBuilder(byteArray.length * 2);
                        for (byte b2 : byteArray) {
                            int i = b2 & 255;
                            if (i < 16) {
                                sb.append('0');
                            }
                            sb.append(Integer.toHexString(i));
                        }
                        string = sb.toString();
                    } catch (IOException e2) {
                        e = e2;
                        Log.d(SerializableCookie.f19670j, "IOException in encodeCookie", e);
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException e3) {
                                Log.d(SerializableCookie.f19670j, "Stream not closed in encodeCookie", e3);
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e4) {
                            Log.d(SerializableCookie.f19670j, "Stream not closed in encodeCookie", e4);
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                objectOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
            editorEdit.putString(strM8748b, string);
        }
        editorEdit.commit();
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x001d A[SYNTHETIC] */
    /* JADX INFO: renamed from: c */
    public List<C12370n> m8749c() throws Throwable {
        ObjectInputStream objectInputStream;
        ArrayList arrayList = new ArrayList(this.f19672a.getAll().size());
        Iterator<Map.Entry<String, ?>> it = this.f19672a.getAll().entrySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next().getValue();
            new SerializableCookie();
            int length = str.length();
            byte[] bArr = new byte[length / 2];
            for (int i = 0; i < length; i += 2) {
                bArr[i / 2] = (byte) (Character.digit(str.charAt(i + 1), 16) + (Character.digit(str.charAt(i), 16) << 4));
            }
            ObjectInputStream objectInputStream2 = null;
            c12370n = null;
            c12370n = null;
            c12370n = null;
            C12370n c12370n = null;
            try {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
                try {
                    try {
                        c12370n = ((SerializableCookie) objectInputStream.readObject()).f19671k;
                    } catch (Throwable th) {
                        th = th;
                        objectInputStream2 = objectInputStream;
                        if (objectInputStream2 != null) {
                            try {
                                objectInputStream2.close();
                            } catch (IOException e) {
                                Log.d(SerializableCookie.f19670j, "Stream not closed in decodeCookie", e);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    Log.d(SerializableCookie.f19670j, "IOException in decodeCookie", e);
                    if (objectInputStream != null) {
                    }
                    if (c12370n != null) {
                        arrayList.add(c12370n);
                    }
                } catch (ClassNotFoundException e3) {
                    e = e3;
                    Log.d(SerializableCookie.f19670j, "ClassNotFoundException in decodeCookie", e);
                    if (objectInputStream != null) {
                    }
                    if (c12370n != null) {
                        arrayList.add(c12370n);
                    }
                }
            } catch (IOException e4) {
                e = e4;
                objectInputStream = null;
            } catch (ClassNotFoundException e5) {
                e = e5;
                objectInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                objectInputStream.close();
            } catch (IOException e6) {
                Log.d(SerializableCookie.f19670j, "Stream not closed in decodeCookie", e6);
            }
            if (c12370n != null) {
                arrayList.add(c12370n);
            }
        }
        return arrayList;
    }

    @Override // com.franmontiel.persistentcookiejar.persistence.CookiePersistor
    public void removeAll(Collection<C12370n> collection) {
        SharedPreferences.Editor editorEdit = this.f19672a.edit();
        Iterator<C12370n> it = collection.iterator();
        while (it.hasNext()) {
            editorEdit.remove(m8748b(it.next()));
        }
        editorEdit.commit();
    }
}
