package b.i.a.f.h.l;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.os.StrictMode$ThreadPolicy;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k2 implements z2 {
    public final Context j;

    public k2(Context context) {
        this.j = context;
    }

    @Override // b.i.a.f.h.l.z2
    public final Object a() {
        x2 y2Var;
        Context contextCreateDeviceProtectedStorageContext = this.j;
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        if (!((str.equals("eng") || str.equals("userdebug")) && (str2.contains("dev-keys") || str2.contains("test-keys")))) {
            return w2.j;
        }
        if (w1.a() && !contextCreateDeviceProtectedStorageContext.isDeviceProtectedStorage()) {
            contextCreateDeviceProtectedStorageContext = contextCreateDeviceProtectedStorageContext.createDeviceProtectedStorageContext();
        }
        StrictMode$ThreadPolicy strictMode$ThreadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            try {
                File file = new File(contextCreateDeviceProtectedStorageContext.getDir("phenotype_hermetic", 0), "overrides.txt");
                y2Var = file.exists() ? new y2(file) : w2.j;
                StrictMode.setThreadPolicy(strictMode$ThreadPolicyAllowThreadDiskReads);
            } catch (RuntimeException e) {
                Log.e("HermeticFileOverrides", "no data dir", e);
                y2Var = w2.j;
                StrictMode.setThreadPolicy(strictMode$ThreadPolicyAllowThreadDiskReads);
            }
            if (!y2Var.b()) {
                return w2.j;
            }
            File file2 = (File) y2Var.c();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                try {
                    HashMap map = new HashMap();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            String strValueOf = String.valueOf(file2);
                            StringBuilder sb = new StringBuilder(strValueOf.length() + 7);
                            sb.append("Parsed ");
                            sb.append(strValueOf);
                            Log.i("HermeticFileOverrides", sb.toString());
                            h2 h2Var = new h2(map);
                            bufferedReader.close();
                            return new y2(h2Var);
                        }
                        String[] strArrSplit = line.split(" ", 3);
                        if (strArrSplit.length != 3) {
                            Log.e("HermeticFileOverrides", line.length() != 0 ? "Invalid: ".concat(line) : new String("Invalid: "));
                        } else {
                            String str3 = strArrSplit[0];
                            String strDecode = Uri.decode(strArrSplit[1]);
                            String strDecode2 = Uri.decode(strArrSplit[2]);
                            if (!map.containsKey(str3)) {
                                map.put(str3, new HashMap());
                            }
                            ((Map) map.get(str3)).put(strDecode, strDecode2);
                        }
                        throw new RuntimeException(e);
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        g3.a.a(th, th2);
                    }
                    throw th;
                }
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        } catch (Throwable th3) {
            StrictMode.setThreadPolicy(strictMode$ThreadPolicyAllowThreadDiskReads);
            throw th3;
        }
    }
}
