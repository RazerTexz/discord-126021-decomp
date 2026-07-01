package com.franmontiel.persistentcookiejar.persistence;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import android.util.Log;
import com.adjust.sdk.Constants;
import f0.n;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"CommitPrefEdits"})
public class SharedPrefsCookiePersistor implements CookiePersistor {
    public final SharedPreferences a;

    public SharedPrefsCookiePersistor(Context context) {
        this.a = context.getSharedPreferences("CookiePersistence", 0);
    }

    public static String b(n nVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(nVar.k ? Constants.SCHEME : "http");
        sb.append("://");
        sb.append(nVar.i);
        sb.append(nVar.j);
        sb.append("|");
        sb.append(nVar.f);
        return sb.toString();
    }

    @Override // com.franmontiel.persistentcookiejar.persistence.CookiePersistor
    public void a(Collection<n> collection) throws Throwable {
        ObjectOutputStream objectOutputStream;
        SharedPreferences$Editor sharedPreferences$EditorEdit = this.a.edit();
        for (n nVar : collection) {
            String strB = b(nVar);
            SerializableCookie serializableCookie = new SerializableCookie();
            serializableCookie.k = nVar;
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
                            Log.d(SerializableCookie.j, "Stream not closed in encodeCookie", e);
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
                        Log.d(SerializableCookie.j, "IOException in encodeCookie", e);
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException e3) {
                                Log.d(SerializableCookie.j, "Stream not closed in encodeCookie", e3);
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
                            Log.d(SerializableCookie.j, "Stream not closed in encodeCookie", e4);
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
            sharedPreferences$EditorEdit.putString(strB, string);
        }
        sharedPreferences$EditorEdit.commit();
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x001d A[SYNTHETIC] */
    public List<n> c() throws Throwable {
        ObjectInputStream objectInputStream;
        ArrayList arrayList = new ArrayList(this.a.getAll().size());
        Iterator<Map$Entry<String, ?>> it = this.a.getAll().entrySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next().getValue();
            new SerializableCookie();
            int length = str.length();
            byte[] bArr = new byte[length / 2];
            for (int i = 0; i < length; i += 2) {
                bArr[i / 2] = (byte) (Character.digit(str.charAt(i + 1), 16) + (Character.digit(str.charAt(i), 16) << 4));
            }
            ObjectInputStream objectInputStream2 = null;
            nVar = null;
            nVar = null;
            nVar = null;
            n nVar = null;
            try {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
                try {
                    try {
                        nVar = ((SerializableCookie) objectInputStream.readObject()).k;
                    } catch (Throwable th) {
                        th = th;
                        objectInputStream2 = objectInputStream;
                        if (objectInputStream2 != null) {
                            try {
                                objectInputStream2.close();
                            } catch (IOException e) {
                                Log.d(SerializableCookie.j, "Stream not closed in decodeCookie", e);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    Log.d(SerializableCookie.j, "IOException in decodeCookie", e);
                    if (objectInputStream != null) {
                    }
                    if (nVar != null) {
                        arrayList.add(nVar);
                    }
                } catch (ClassNotFoundException e3) {
                    e = e3;
                    Log.d(SerializableCookie.j, "ClassNotFoundException in decodeCookie", e);
                    if (objectInputStream != null) {
                    }
                    if (nVar != null) {
                        arrayList.add(nVar);
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
                Log.d(SerializableCookie.j, "Stream not closed in decodeCookie", e6);
            }
            if (nVar != null) {
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }

    @Override // com.franmontiel.persistentcookiejar.persistence.CookiePersistor
    public void removeAll(Collection<n> collection) {
        SharedPreferences$Editor sharedPreferences$EditorEdit = this.a.edit();
        Iterator<n> it = collection.iterator();
        while (it.hasNext()) {
            sharedPreferences$EditorEdit.remove(b(it.next()));
        }
        sharedPreferences$EditorEdit.commit();
    }
}
